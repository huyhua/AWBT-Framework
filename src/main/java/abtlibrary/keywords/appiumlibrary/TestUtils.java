package abtlibrary.keywords.appiumlibrary;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;

import abtlibrary.utils.HttpRequestUtils;

import com.mifmif.common.regex.Generex;

@RobotKeywords
public class TestUtils {
	
	protected interface Vertical{
		List<String> getSearchId(String url);
		int getSearchHits(String url);
	}
	
	protected enum verticalEnum implements Vertical {
		DEFAULT{

			@Override
			public List<String> getSearchId(String url) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getSearchHits(String url) {
				return 0;
			}
			
		},
		
		immoscout24{

			@Override
			public List<String> getSearchId(String url) {
				ArrayList<String> results = new ArrayList<>();
				String output = HttpRequestUtils.getResponse(url, "GET", null);
				Document doc = Jsoup.parse(output);
				Element content = doc.getElementsByClass("item-listing-list").first();
				for (int i = 0; i < content.getElementsByClass("item").size(); i++) {
					String item = content.getElementsByClass("item").get(i)
							.getElementsByClass("bookmark-item").first()
							.attr("data-pid");
					results.add(item);
				}

				return results;
			}

			@Override
			public int getSearchHits(String url) {
				String output = HttpRequestUtils.getResponse(url, "GET", null);
				Document doc = Jsoup.parse(output);
				return Integer.parseInt(doc.getElementsByClass("search-result-head")
						.first()
						.getElementsByClass("amount")
						.first()
						.text()
						.replace("'", ""));
			}
			
		},
		autoscout24{

			@Override
			public List<String> getSearchId(String url) {
				ArrayList<String> results = new ArrayList<>();
				String output = HttpRequestUtils.getResponse(url, "GET", null);
				Document doc = Jsoup.parse(output);
				Element content = doc.getElementsByClass("object-list").first();
				int pageSize = content.getElementsByAttributeValueStarting("id", "lnkDetail").size();
				for (int i = 0; i < pageSize; i++) {
					String item = content.getElementsByAttributeValueStarting("id", "lnkDetail")
							.get(i)
							.id()
							.replace("lnkDetail", "");
					results.add(item);
				}
				return results;
			}

			@Override
			public int getSearchHits(String url) {
				String output = HttpRequestUtils.getResponse(url, "GET", null);
				Document doc = Jsoup.parse(output);
				return Integer.parseInt(doc.getElementsByClass("title-main")
						.first()
						.getElementsByClass("amount")
						.first()
						.text()
						.replace("'", ""));
			}	
		},
		anibis{

			@Override
			public List<String> getSearchId(String url) {
				ArrayList<String> results = new ArrayList<>();
				String output = HttpRequestUtils.getResponse(url, "GET", null);
				Document doc = Jsoup.parse(output);
				Element content = doc.getElementsByClass("listing-list").first();
				int pageSize = content.getElementsByClass("listing-info").size();
				for (int i = 0; i < pageSize; i++) {
					String item = content.getElementsByClass("listing-info")
							.get(i)
							.getElementsByTag("a")
							.get(0)
							.attr("href");
					item = item.substring(item.lastIndexOf("-")+1, item.lastIndexOf(".aspx"));
					results.add(item);
				}
				return results;
			}

			@Override
			public int getSearchHits(String url) {
				String output = HttpRequestUtils.getResponse(url, "GET", null);
				Document doc = Jsoup.parse(output);
				return Integer.parseInt(doc.getElementsByClass("total-amount-objects")
						.first()
						.text()
						.replace("'", ""));
			}
			
		}
	}
	
	@RobotKeywordOverload
	public String randomize(String pattern){
		return randomize(pattern, null);
	}
	
	@RobotKeywordOverload
	public String randomize(String pattern, String prefix){
		return randomize(pattern, prefix, null);
	}
	
	/**
	 * Random a string based on the regex pattern
	 * 
	 * @param pattern
	 *            the regex pattern that determine how the string looks like
	 * @param prefix
	 *            prefix of the string
	 * @param postfix
	 *            postfix of the string
	 */
	@RobotKeyword
	@ArgumentNames({"pattern","prefix=None","postfix=None"})
	public String randomize(String pattern, String prefix, String postfix){
		String randomName = prefix + new Generex(pattern).random()
				+ postfix;
		return randomName;
	}
	
	protected Vertical parseURL(String url){
		URI targetURL;
		try {
			targetURL = new URI(url);
		} catch (URISyntaxException e) {
			targetURL = null;
		}
		String domain = targetURL.getHost();
		domain = domain.substring(domain.indexOf(".")+1, domain.lastIndexOf("."));
		Vertical vertical = verticalEnum.DEFAULT;
		if(domain != null){
			vertical = verticalEnum.valueOf(domain);
		}
		return vertical;
	}
	
	@RobotKeywordOverload
	public List<String> retrieveResultIdsFromUrl(String url){
		return retrieveResultIdsFromUrl(url, -1);
	}
	
	
	/**
	 * Get all the search id results from url. Currently only support IS24 and AS24
	 * Only retrieve the 1st page!!!! For full list please wait for api support!!
	 * 
	 * @param URL
	 *            the search string
	 * @param Limit
	 *            Optional: only get the limit number of results
	 */
	@RobotKeyword
	@ArgumentNames({"url","limit=-1"})
	public List<String> retrieveResultIdsFromUrl(String url, int limit){
		Vertical vertical = parseURL(url);
		List<String> results = vertical.getSearchId(url);
		if(limit != -1){
			return results.subList(0, limit);
		}
		return results;
	}
	
	@RobotKeyword
	@ArgumentNames({"url"})
	public int retrieveHitsFromUrl(String url){
		Vertical vertical = parseURL(url);
		return vertical.getSearchHits(url);
	}
}

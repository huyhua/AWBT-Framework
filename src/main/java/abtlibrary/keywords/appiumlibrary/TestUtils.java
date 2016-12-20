package abtlibrary.keywords.appiumlibrary;

import java.io.IOException;
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
import abtlibrary.utils.is24ApiClient.APIClient;
import abtlibrary.utils.is24ApiClient.Model.Favorite.FavoriteResponse;
import abtlibrary.utils.is24ApiClient.Model.Searchjob.Property;
import abtlibrary.utils.is24ApiClient.Model.Searchjob.SearchResponse;

import com.google.gson.GsonBuilder;
import com.mifmif.common.regex.Generex;

@RobotKeywords
public class TestUtils {

	protected interface Vertical {
		List<String> getSearchIdFromWeb(String url);

		List<String> getSearchIdFromApi(String url);

		List<String> getFavouriteIdsFromApi(String host, String username,
				String password);

		int getSearchHitsFromWeb(String url);

		int getSearchHitsFromApi(String url);
	}

	protected enum verticalEnum implements Vertical {
		DEFAULT {

			@Override
			public List<String> getSearchIdFromWeb(String url) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getSearchHitsFromWeb(String url) {
				return 0;
			}

			@Override
			public List<String> getSearchIdFromApi(String url) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getSearchHitsFromApi(String url) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public List<String> getFavouriteIdsFromApi(String host,
					String username, String password) {
				// TODO Auto-generated method stub
				return null;
			}

		},

		immoscout24 {
			APIClient client;

			@Override
			public List<String> getSearchIdFromWeb(String url) {
				ArrayList<String> results = new ArrayList<>();
				String output = HttpRequestUtils.getResponse(url, "GET", null);
				Document doc = Jsoup.parse(output);
				Element content = doc.getElementsByClass("item-listing-list")
						.first();
				for (int i = 0; i < content.getElementsByClass("item").size(); i++) {
					String item = content.getElementsByClass("item").get(i)
							.getElementsByClass("bookmark-item").first()
							.attr("data-pid");
					results.add(item);
				}

				return results;
			}

			@Override
			public int getSearchHitsFromWeb(String url) {
				String output = HttpRequestUtils.getResponse(url, "GET", null);
				Document doc = Jsoup.parse(output);
				return Integer.parseInt(doc
						.getElementsByClass("search-result-head").first()
						.getElementsByClass("amount").first().text()
						.replace("'", ""));
			}

			@Override
			public List<String> getSearchIdFromApi(String url) {
				try {
					UrlComponent targetURL = new UrlComponent(url);
					if(client == null){
						client = new APIClient(targetURL.getHost(), null,
							null);
					}
					List<String> results = new ArrayList<String>();
					SearchResponse document = jsonBuilder(
							client.invokeHttpGet(targetURL.getQueryString()),
							SearchResponse.class);
					for (Property item : document.getPropertiesList()
							.getProperties()) {
						results.add(item.getPropertyDetails().getPropertyID()
								.toString());
					}
					return results;
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}

			@Override
			public int getSearchHitsFromApi(String url) {
				SearchResponse document;
				try {
					UrlComponent targetURL = new UrlComponent(url);
					if(client == null){
						client = new APIClient(targetURL.getHost(), null,
							null);
					}
					document = jsonBuilder(
							client.invokeHttpGet(targetURL.getQueryString()),
							SearchResponse.class);
					return document.getPropertiesList().getTotalMatches();
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return 0;
				}
			}

			@Override
			public List<String> getFavouriteIdsFromApi(String host,
					String username, String password) {
				try {
					UrlComponent targetURL = new UrlComponent(host);
					if(client == null | client.getUsername() != username | client.getPassword() != password){
						client = new APIClient(targetURL.getHost(), username, password);
					}
					
					List<String> results = new ArrayList<String>();
					jsonBuilder(
							client.invokeHttpGet("/v1/private/favourites?onlyActive=true"),
							FavoriteResponse.class)
							.getFavouriteProperties()
							.stream()
							.filter(item -> item.getProperty()
									.getPropertyDetails().getIsOnline())
							.forEach(
									item -> results.add(item.getPropertyID()
											.toString()));
					return results;
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
					return null;
				}

			}

		},
		autoscout24 {

			@Override
			public List<String> getSearchIdFromWeb(String url) {
				ArrayList<String> results = new ArrayList<>();
				String output = HttpRequestUtils.getResponse(url, "GET", null);
				Document doc = Jsoup.parse(output);
				Element content = doc.getElementsByClass("object-list").first();
				int pageSize = content.getElementsByAttributeValueStarting(
						"id", "lnkDetail").size();
				for (int i = 0; i < pageSize; i++) {
					String item = content
							.getElementsByAttributeValueStarting("id",
									"lnkDetail").get(i).id()
							.replace("lnkDetail", "");
					results.add(item);
				}
				return results;
			}

			@Override
			public int getSearchHitsFromWeb(String url) {
				String output = HttpRequestUtils.getResponse(url, "GET", null);
				Document doc = Jsoup.parse(output);
				return Integer.parseInt(doc.getElementsByClass("title-main")
						.first().getElementsByClass("amount").first().text()
						.replace("'", ""));
			}

			@Override
			public List<String> getSearchIdFromApi(String url) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getSearchHitsFromApi(String url) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public List<String> getFavouriteIdsFromApi(String host,
					String username, String password) {
				// TODO Auto-generated method stub
				return null;
			}
		},
		anibis {

			@Override
			public List<String> getSearchIdFromWeb(String url) {
				ArrayList<String> results = new ArrayList<>();
				String output = HttpRequestUtils.getResponse(url, "GET", null);
				Document doc = Jsoup.parse(output);
				Element content = doc.getElementsByClass("listing-list")
						.first();
				int pageSize = content.getElementsByClass("listing-info")
						.size();
				for (int i = 0; i < pageSize; i++) {
					String item = content.getElementsByClass("listing-info")
							.get(i).getElementsByTag("a").get(0).attr("href");
					item = item.substring(item.lastIndexOf("-") + 1,
							item.lastIndexOf(".aspx"));
					results.add(item);
				}
				return results;
			}

			@Override
			public int getSearchHitsFromWeb(String url) {
				String output = HttpRequestUtils.getResponse(url, "GET", null);
				Document doc = Jsoup.parse(output);
				return Integer.parseInt(doc
						.getElementsByClass("total-amount-objects").first()
						.text().replace("'", ""));
			}

			@Override
			public List<String> getSearchIdFromApi(String url) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getSearchHitsFromApi(String url) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public List<String> getFavouriteIdsFromApi(String host,
					String username, String password) {
				// TODO Auto-generated method stub
				return null;
			}

		}
	}

	@RobotKeywordOverload
	public String randomize(String pattern) {
		return randomize(pattern, null);
	}

	@RobotKeywordOverload
	public String randomize(String pattern, String prefix) {
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
	@ArgumentNames({ "pattern", "prefix=None", "postfix=None" })
	public String randomize(String pattern, String prefix, String postfix) {
		String randomName = prefix + new Generex(pattern).random() + postfix;
		return randomName;
	}

	protected Vertical parseURL(String url) {
		URI targetURL;
		try {
			targetURL = new URI(url);
		} catch (URISyntaxException e) {
			targetURL = null;
		}
		String domain = targetURL.getHost();
		domain = domain.substring(domain.indexOf(".") + 1,
				domain.lastIndexOf("."));
		Vertical vertical = verticalEnum.DEFAULT;
		if (domain != null) {
			vertical = verticalEnum.valueOf(domain);
		}
		return vertical;
	}

	protected static <T> T jsonBuilder(String text, Class<T> buildClass) {
		return new GsonBuilder().create().fromJson(text, buildClass);
	}

	@RobotKeywordOverload
	public List<String> retrieveResultIdsFromUrl(String url) {
		return retrieveResultIdsFromUrl(url, -1);
	}

	/**
	 * Get all the search id results from url. Currently only support IS24 and
	 * AS24 Only retrieve the 1st page!!!! For full list please wait for api
	 * support!!
	 * 
	 * @param URL
	 *            the search string
	 * @param Limit
	 *            Optional: only get the limit number of results
	 */
	@RobotKeyword
	@ArgumentNames({ "url", "limit=-1" })
	public List<String> retrieveResultIdsFromUrl(String url, int limit) {
		Vertical vertical = parseURL(url);
		List<String> results = vertical.getSearchIdFromWeb(url);
		if (limit != -1) {
			return results.subList(0, limit);
		}
		return results;
	}

	@RobotKeyword
	@ArgumentNames({ "url" })
	public int retrieveHitsFromUrl(String url) {
		Vertical vertical = parseURL(url);
		return vertical.getSearchHitsFromWeb(url);
	}
	
	@RobotKeyword
	@ArgumentNames({ "url" })
	public List<String> retrieveResultIdsFromApi(String url) {
		Vertical vertical = parseURL(url);
		return vertical.getSearchIdFromApi(url);
	}
	
	@RobotKeyword
	@ArgumentNames({ "host","username","password" })
	public List<String> retrieveFavoriteIdsFromApi(String host, String user, String password){
		Vertical vertical = parseURL(host);
		return vertical.getFavouriteIdsFromApi(host, user, password);
	}
	
	@RobotKeyword
	@ArgumentNames({ "url" })
	public int retrieveHitsFromApi(String url) {
		Vertical vertical = parseURL(url);
		return vertical.getSearchHitsFromApi(url);
	}

	protected static class UrlComponent {
		String url;
		String host;
		String queryString;

		public UrlComponent(String url) throws URISyntaxException {
			URI targetURL = new URI(url);
			this.host = targetURL.getScheme() + "://" + targetURL.getHost();
			this.url = url;
			this.queryString = String.format("%1s?%2s", targetURL.getPath(),
					targetURL.getQuery());
		}

		public String getUrl() {
			return url;
		}

		public String getHost() {
			return host;
		}

		public String getQueryString() {
			return queryString;
		}
	}
}

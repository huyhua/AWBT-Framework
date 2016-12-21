package abtlibrary.keywords.appiumlibrary;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;

import abtlibrary.utils.HttpRequestUtils;
import abtlibrary.utils.anibisApiClient.ApiClient;
import abtlibrary.utils.anibisApiClient.ApiException;
import abtlibrary.utils.anibisApiClient.api.FavoriteControllerApi;
import abtlibrary.utils.anibisApiClient.api.SearchControllerApi;
import abtlibrary.utils.anibisApiClient.model.AdvertDto;
import abtlibrary.utils.anibisApiClient.model.SearchParameterDto;
import abtlibrary.utils.anibisApiClient.model.SearchResultDto;
import abtlibrary.utils.is24ApiClient.APIClient;
import abtlibrary.utils.is24ApiClient.Model.Favorite.FavoriteResponse;
import abtlibrary.utils.is24ApiClient.Model.Searchjob.Property;
import abtlibrary.utils.is24ApiClient.Model.Searchjob.SearchResponse;

import com.google.gson.GsonBuilder;
import com.mifmif.common.regex.Generex;

@RobotKeywords
public class TestUtils {

	protected interface Vertical {
		List<String> getSearchIdFromWeb(String host);

		List<String> getSearchIdFromApi(String host, Map<String, ?> parameters);

		List<String> getFavouriteIdsFromApi(String host, String username,
				String password);

		int getSearchHitsFromWeb(String host);

		int getSearchHitsFromApi(String host, Map<String, ?> parameters);
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
			public List<String> getSearchIdFromApi(String url, Map parameters) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getSearchHitsFromApi(String url, Map parameters) {
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
			public List<String> getSearchIdFromApi(String url,
					Map<String, ?> parameters) {
				try {
					if (client == null) {
						client = new APIClient(url, null, null);
					}
					List<String> results = new ArrayList<String>();
					String query = "/v1/public/properties?"
							+ urlEncodeUTF8(parameters);
					SearchResponse document = jsonBuilder(
							client.invokeHttpGet(query), SearchResponse.class);
					for (Property item : document.getPropertiesList()
							.getProperties()) {
						results.add(item.getPropertyDetails().getPropertyID()
								.toString());
					}
					return results;
				} catch (IOException e) {
					e.printStackTrace();
					return null;
				}
			}

			@Override
			public int getSearchHitsFromApi(String url,
					Map<String, ?> parameters) {
				SearchResponse document;
				try {
					if (client == null) {
						client = new APIClient(url, null, null);
					}
					String query = "/v1/public/properties?"
							+ urlEncodeUTF8(parameters);
					document = jsonBuilder(client.invokeHttpGet(query),
							SearchResponse.class);
					return document.getPropertiesList().getTotalMatches();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return 0;
				}
			}

			@Override
			public List<String> getFavouriteIdsFromApi(String host,
					String username, String password) {
				try {
					if (client == null | client.getUsername() != username
							| client.getPassword() != password) {
						client = new APIClient(host, username, password);
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
				} catch (IOException e) {
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
			public List<String> getSearchIdFromApi(String url,
					Map<String, ?> parameters) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getSearchHitsFromApi(String url,
					Map<String, ?> parameters) {
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
			ApiClient client;

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
			public List<String> getSearchIdFromApi(String url,
					Map<String, ?> parameters) {
				if (client == null) {
					client = new ApiClient();
					client.setBasePath(url);
				}

				SearchControllerApi searchApi = new SearchControllerApi(client);
				SearchParameterDto parms = populateParameterFromMap(parameters);
				SearchResultDto resultDto = null;
				List<Integer> objectIds = new ArrayList<>();
				try {
					resultDto = searchApi.searchControllerPost(parms);
					objectIds = resultDto.getObjectIds();
				} catch (ApiException e) {
					e.printStackTrace();
				}
				List<String> stringList = new ArrayList<String>(objectIds.size());
				for (Integer myInt : objectIds) {
					stringList.add(String.valueOf(myInt));
				}
				return stringList;
			}

			@Override
			public int getSearchHitsFromApi(String url,
					Map<String, ?> parameters) {
				if (client == null) {
					client = new ApiClient();
					client.setBasePath(url);
				}

				SearchControllerApi searchApi = new SearchControllerApi(client);
				SearchParameterDto parms = populateParameterFromMap(parameters);
				SearchResultDto resultDto = null;
				try {
					resultDto = searchApi.searchControllerPost(parms);
				} catch (ApiException e) {
					e.printStackTrace();
				}

				return resultDto.getTotalCount();
			}

			@Override
			public List<String> getFavouriteIdsFromApi(String host,
					String username, String password) {
				if (client == null) {
					client = new ApiClient();
					client.setBasePath(host);
				}

				List<Integer> favoriteAdvertIds = new ArrayList<Integer>();
				FavoriteControllerApi favoriteApi = new FavoriteControllerApi(
						client, username, password);
				List<AdvertDto> favoriteAdverts;
				try {
					favoriteAdverts = favoriteApi.favoriteControllerGet();
					for (AdvertDto advert : favoriteAdverts) {
						favoriteAdvertIds.add(advert.getId());
					}
				} catch (ApiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Number of favorites on server: "
						+ favoriteAdvertIds.size());
				List<String> stringList = new ArrayList<String>(favoriteAdvertIds.size());
				for (Integer myInt : favoriteAdvertIds) {
					stringList.add(String.valueOf(myInt));
				}
				return stringList;
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

	protected static Vertical parseURL(String url) {
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

	protected static String urlEncodeUTF8(String s) {
		try {
			return URLEncoder.encode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new UnsupportedOperationException(e);
		}
	}

	protected static String urlEncodeUTF8(Map<?, ?> map) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<?, ?> entry : map.entrySet()) {
			if (sb.length() > 0) {
				sb.append("&");
			}
			sb.append(String.format("%s=%s", urlEncodeUTF8(entry.getKey()
					.toString()), urlEncodeUTF8(entry.getValue().toString())));
		}
		return sb.toString();
	}

	protected static SearchParameterDto populateParameterFromMap(
			Map<String, ?> params) {
		SearchParameterDto paramDto = new SearchParameterDto();
		try {
		paramDto.setCategoryId(convert(params.get("CategoryId"), Integer.class));
		paramDto.setSearchText(convert(params.get("SearchText"),String.class));
		paramDto.setSearchDistance(convert(params.get("SearchDistance"), Integer.class));
		paramDto.setSearchLocation(convert(params.get("SearchLocation"), String.class));
		paramDto.setLanguage(convert(params.get("Language"), String.class));
		paramDto.setMemberId(convert(params.get("MemberId"), Integer.class));
		paramDto.setSortField(convert(params.get("SortField"), String.class));
		paramDto.setResultRows(convert(params.get("ResultRows"), Integer.class));
		if(paramDto.getResultRows() == null){
			paramDto.setResultRows(1000);
		}
		paramDto.setResultStart(convert(params.get("ResultStart"), Integer.class));
		paramDto.setWithImagesOnly(convert(params.get("WithImagesOnly"), Boolean.class));
		paramDto.setSortOrder(convert(params.get("SortOrder"), Boolean.class));
		paramDto.setStateCode(convert(params.get("StateCode"), String.class));
		paramDto.setUsername(convert(params.get("Username"), String.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paramDto;
	}
	
	protected static <I, O> O convert(I input, Class<O> outputClass) throws Exception {
	    return input == null ? null : outputClass.getConstructor(String.class).newInstance(input.toString());
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
	@ArgumentNames({ "host", "limit=-1" })
	public List<String> retrieveResultIdsFromUrl(String host, int limit) {
		Vertical vertical = parseURL(host);
		List<String> results = vertical.getSearchIdFromWeb(host);
		if (limit != -1) {
			return results.subList(0, limit);
		}
		return results;
	}

	@RobotKeyword
	@ArgumentNames({ "host" })
	public int retrieveHitsFromUrl(String host) {
		Vertical vertical = parseURL(host);
		return vertical.getSearchHitsFromWeb(host);
	}

	@RobotKeyword
	@ArgumentNames({ "host" })
	public List<String> retrieveResultIdsFromApi(String host, List<String> parameters) {
		Map<String, String> params = new HashMap<>();
		for (String item : parameters) {
			String[] stringFragment = item.split("=");
			params.put(stringFragment[0], stringFragment[1]);
		}
		Vertical vertical = parseURL(host);
		return vertical.getSearchIdFromApi(host, params);
	}

	@RobotKeyword
	@ArgumentNames({ "host", "username", "password" })
	public List<String> retrieveFavoriteIdsFromApi(String host, String user,
			String password) {
		Vertical vertical = parseURL(host);
		return vertical.getFavouriteIdsFromApi(host, user, password);
	}

	@RobotKeyword
	@ArgumentNames({ "host" })
	public int retrieveHitsFromApi(String host, List<String> parameters) {
		Map<String, String> params = new HashMap<>();
		for (String item : parameters) {
			String[] stringFragment = item.split("=");
			params.put(stringFragment[0], stringFragment[1]);
		}
		Vertical vertical = parseURL(host);
		return vertical.getSearchHitsFromApi(host, params);
	}
	
//	public static void main(String[] args) throws ApiException {
//		List<String> params = new ArrayList<>();
//		params.add("CategoryId=2788");
//		System.out.println(retrieveResultIdsFromApi("https://xbapi-stage.anibis.ch",params).toString());
//	}
}

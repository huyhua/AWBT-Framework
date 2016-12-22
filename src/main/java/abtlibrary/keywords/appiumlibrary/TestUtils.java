package abtlibrary.keywords.appiumlibrary;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
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
import abtlibrary.utils.as24ApiClient.api.FavoriteVehiclesApi;
import abtlibrary.utils.as24ApiClient.api.UsersApi;
import abtlibrary.utils.as24ApiClient.api.VehiclesApi;
import abtlibrary.utils.as24ApiClient.model.Ad;
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
				String output = HttpRequestUtils.getResponse(url, "GET", null, null);
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
				String output = HttpRequestUtils.getResponse(url, "GET", null, null);
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
			abtlibrary.utils.as24ApiClient.ApiClient client;
			Map<String, String> token;

			@Override
			public List<String> getSearchIdFromWeb(String url) {
				ArrayList<String> results = new ArrayList<>();
				String output = HttpRequestUtils.getResponse(url, "GET", null, null);
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
				String output = HttpRequestUtils.getResponse(url, "GET", null, null);
				Document doc = Jsoup.parse(output);
				return Integer.parseInt(doc.getElementsByClass("title-main")
						.first().getElementsByClass("amount").first().text()
						.replace("'", ""));
			}

			@Override
			public List<String> getSearchIdFromApi(String url,
					Map<String, ?> parameters) {
				List<String> resultIds = new ArrayList<>();
				setApiClient(url, null, null);
				String skip = (String) parameters.get("filter");
				String take = (String) parameters.get("filter");
				String filter = (String) parameters.get("filter");
				
				int adToSkip = skip == null ? 0 : Integer.parseInt(skip);
				int adToTake = take == null ? 100 : Integer.parseInt(take);
				VehiclesApi api = new VehiclesApi(client);
				try {
					for(Ad ad : api.gETpublicV41Vehicles(adToSkip, adToTake, filter).getResults()){
						resultIds.add(ad.getId().toString());
					}
					return resultIds;
				} catch (abtlibrary.utils.as24ApiClient.ApiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			}

			@Override
			public int getSearchHitsFromApi(String url,
					Map<String, ?> parameters) {
				setApiClient(url, null, null);
				String filter = (String) parameters.get("filter");
				VehiclesApi api = new VehiclesApi(client);
				try {
					return api.gETpublicV41VehiclesCount(filter).getMatches();
				} catch (abtlibrary.utils.as24ApiClient.ApiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				return 0;
			}

			@Override
			public List<String> getFavouriteIdsFromApi(String host,
					String username, String password) {
				setApiClient(host, username, password);
				UsersApi user = new UsersApi(client);
				try {
					int userId = user.gETpublicV41UsersAuthorizedWithHttpInfo().getData().getResult().getId();
					FavoriteVehiclesApi api = new FavoriteVehiclesApi(client);
					api.gETpublicV41UsersUseridFavoritevehicles(userId, 0, 200, null);
				} catch (abtlibrary.utils.as24ApiClient.ApiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
			
			private abtlibrary.utils.as24ApiClient.ApiClient setApiClient(String host, String username, String password){
				if (client == null) {
					client = new abtlibrary.utils.as24ApiClient.ApiClient();
					client.setBasePath(host);
					if(username == null | password == null){
						token = getOAuthToken(host);
					}else{
						token = getOAuthToken(host, username, password);
					}
				}else{
					if(System.currentTimeMillis()*1000 >  Long.parseLong(token.get("tokenExpireTime"))){
						if(username == null | password == null){
							token = getOAuthToken(host);
						}else{
							token = getOAuthToken(host, username, password);
						}
					}else{
						if(!username.equals(token.get("username")) | !password.equals(token.get("password"))){
							token = getOAuthToken(host, username, password);
						}			
					}
				}
				client.addDefaultHeader("authorization", "Bearer " + token.get("token"));
				return client;
			}
		},
		anibis {
			ApiClient client;

			@Override
			public List<String> getSearchIdFromWeb(String url) {
				ArrayList<String> results = new ArrayList<>();
				String output = HttpRequestUtils.getResponse(url, "GET", null, null);
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
				String output = HttpRequestUtils.getResponse(url, "GET", null, null);
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
	
	protected static Map<String, String> getOAuthToken(String url){
		String pass = "&username=60601-romsup&password=autoscout24";
		return getOAuthToken(url, "anonymous", "anonymous");
	}
	
	protected static Map<String, String> getOAuthToken(String url, String username, String password){
		return getOAuthToken(url, username, password, "Autoscout24_iPhone", "9hPTf5qrAC8UtYej4ACc");
	}

	protected static Map<String, String> getOAuthToken(String url, String username, String password, String clientId, String secret){
		Map<String, String> headers = new HashMap<>();
		Map<String, String> token  = new HashMap<>();
		URI targetURL;
		try {
			targetURL = new URI(url);
		} catch (URISyntaxException e) {
			targetURL = null;
		}
		String host = targetURL.getHost();
		String vertical = host.substring(host.indexOf(".") + 1,
				host.lastIndexOf("."));
		String prefix = host.substring(0, host.indexOf("-"));
		String OAuthUrl = "https://"+ prefix +"-identity."+vertical+".ch/connect/token";
		headers.put("authorization", "Basic " + getBasicAuthToken(clientId, secret));
		headers.put("cache-control", "no-cache");
		headers.put("content-type", "application/x-www-form-urlencoded");
		String body = "scope=api."+ vertical +".ch%2Fv4%20offline_access&username="+ username +"&password="+ password +"&grant_type=password";
		String response = HttpRequestUtils.getResponse(OAuthUrl, "POST", headers, body);
		long tokenExpireTime = System.currentTimeMillis()*1000 + Integer.parseInt(response.split(",")[1].split(":")[1]);
		String tokenValue = response.split("\"")[3];
		token.put("username", username);
		token.put("password", password);
		token.put("tokenExpireTime", Long.toString(tokenExpireTime));
		token.put("token", tokenValue);
		return token;
	}
	
	protected static String getBasicAuthToken(String username, String password) {
		try {
			return new String(Base64.getEncoder().encode(String.format("%s:%s",
					username, password).getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
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
	public List<String> retrieveResultIdsFromWeb(String url) {
		return retrieveResultIdsFromWeb(url, -1);
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
	public List<String> retrieveResultIdsFromWeb(String host, int limit) {
		Vertical vertical = parseURL(host);
		List<String> results = vertical.getSearchIdFromWeb(host);
		if (limit != -1) {
			return results.subList(0, limit);
		}
		return results;
	}

	@RobotKeyword
	@ArgumentNames({ "host" })
	public int retrieveHitsFromWeb(String host) {
		Vertical vertical = parseURL(host);
		return vertical.getSearchHitsFromWeb(host);
	}

	@RobotKeyword
	@ArgumentNames({ "host" })
	public List<String> retrieveResultIdsFromApi(String host, List<String> parameters) {
		Map<String, String> params = new HashMap<>();
		for (String item : parameters) {
			String[] stringFragment = item.split("=");
			if(stringFragment[0].equals("filter")){
				String combination = "";
				for(int i = 1; i< stringFragment.length; i++){
					combination += stringFragment[i];
				}
				stringFragment[1] = urlEncodeUTF8(combination);
			}
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
//		params.add("take=25");
//		System.out.println(retrieveResultIdsFromApi("https://int-newapi.autoscout24.ch",params).toString());
//	}
}

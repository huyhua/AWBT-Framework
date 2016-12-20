package abtlibrary.utils.is24ApiClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Logger;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.TextUtils;

public class APIClient {

	protected static final String API_KEY = "6a81c2d9-743d-2a1c-62bf-2545382fe7e1";
	protected static final String API_VERSION = "1.0";
	protected static final String SHARED_SECRET_KEY = "jdai4*c52kl";
	protected static final String udid = "9B508738-8943-4295-8917-E74D0D54371B";
	protected static final String USER_AGENT = "ch.immoscout24.ImmoScout24/4267 (iPhone, iOS 9.0, Scale 3.00)";
	protected static String serverURL = "http://api.immoscout24.ch/v1/";
	private static DateFormat dateFormat;

	private HttpClient httpClient;
	private String url;
	private Logger logger = Logger.getLogger(APIClient.class.getName());
	private String username = null;
	private String password = null;

	public static void main(String[] args) throws Exception {
		System.out.println(getXToken("Tue, 30 Aug 2016 04:42:40 GMT", udid, API_KEY, SHARED_SECRET_KEY));
//		System.out.println(new String(toHMACMD5(SHARED_SECRET_KEY, )));
	}
	
	public APIClient(){
		this(null, null, null);
	}
	

	public APIClient(String url, String username, String password) {
		try {
			String time = getTimeStamp();
			List<Header> headerList = new ArrayList<Header>();
			headerList.add(new BasicHeader("User-Agent", APIClient.USER_AGENT));
			headerList.add(new BasicHeader("X-Udid", APIClient.udid));
			headerList.add(new BasicHeader("X-IS24-Api-Version", "1.0"));
			headerList.add(new BasicHeader("X-Token", getXToken(time, udid,
					API_KEY, SHARED_SECRET_KEY)));
			headerList.add(new BasicHeader("X-Request-Date", time));
			headerList.add(new BasicHeader("Accept-Language", "en"));
			// headerList.add(new BasicHeader("Accept-Encoding", "gzip,deflate"));
			headerList
					.add(new BasicHeader("X-IS24-Api-Key", APIClient.API_KEY));
			headerList.add(new BasicHeader("Accept",
					"application/json; charset=utf-8"));
			if ((username != null && password != null)) {
				this.username = username;
				this.password = password;
				headerList.add(new BasicHeader("Authorization", String.format(
						"Basic %s", getBaseAuthValue(username, password))));
			}

			httpClient = HttpClientBuilder.create()
					.setDefaultHeaders(headerList).build();

			if (url == null || url.equals("")) {
				this.url = serverURL;
			} else {
				this.url = url;
			}

			logger.fine("API client created for " + url);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String invokeHttpGet(String uriSuffix) throws IOException {
		logger.fine("Invoking " + uriSuffix);
		HttpGet httpGet = new HttpGet(url + uriSuffix);
		return consumeResponse(httpClient.execute(httpGet));
	}

	public String invokeHttpPost(String uriSuffix, String jsonData)
			throws IOException {
		logger.fine("Invoking " + uriSuffix + " with jsonData " + jsonData);
		HttpPost httpPost = new HttpPost(url + uriSuffix);
		StringEntity reqEntity = new StringEntity(jsonData);
		httpPost.setEntity(reqEntity);
		return consumeResponse(httpClient.execute(httpPost));
	}

	public String consumeResponse(HttpResponse response)
			throws IOException {
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		entity.writeTo(os);
		String content = os.toString("UTF-8");

		logger.fine("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		logger.fine(response.getStatusLine().toString());
		logger.fine(content);
		logger.fine("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		if (status != 200) {
			throw new HttpResponseException(status, content);
		}

		return content;
	}


	private static final String getTimeStamp() {
		Date date = new Date();
		dateFormat = new SimpleDateFormat(
				"EEE',' dd MMM yyyy HH':'mm':'ss 'GMT'");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		// Use UTC as the default time zone.
		return dateFormat.format(date);

	}



	private static String getBaseAuthValue(String username, String password) {
		try {
			return new String(Base64.encodeBase64(String.format("%s:%s",
					username, password).getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	private static final String getXToken(String timeStamp, String udid,
			String apiKey, String sharedSecretKey) {
		if (TextUtils.isEmpty(apiKey) || TextUtils.isEmpty(sharedSecretKey))
			return null;

		String secretData = udid + "-" + apiKey + "-" + sharedSecretKey;

		return new String(Base64.encodeBase64(toHMACMD5(secretData, timeStamp)));
	}

	private static byte[] toHMACMD5(String message, String keyString) {
		try {
			Mac mac = Mac.getInstance("HMACMD5");
			SecretKeySpec key = new SecretKeySpec((keyString).getBytes(),
					mac.getAlgorithm());
			mac.init(key);

			return mac.doFinal(message.getBytes());
		} catch (Exception e) {
			return new byte[0];
		}
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}

package abtlibrary.utils.anibisApiClient;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.util.TextUtils;

public class XTokenGenerator {
	private static String udid = "9B508738-8943-4295-8917-E74D0D54371B";
	private static String apiKey = "7c32e4f1-338f-5a9b-19ca-4585251c3a9";
	private static String secret = "kj4qn25dhycuiui5ohck816xdjcfngbi";
	
	public static String generatedTime;

	public static void main(String[] args){
		System.out.println(getXToken("Wed, 24 Feb 2016 03:13:14 GMT", "A7633A85-2A4E-41BE-8B02-4C0D9DEA16DB", "7c32e4f1-338f-5a9b-19ca-4585251c3a9", "kj4qn25dhycuiui5ohck816xdjcfngbi"));
		
	}
	
	private static final String getTimeStamp() {
		DateFormat dateFormat;
		Date date = new Date();
		dateFormat = new SimpleDateFormat(
				"EEE',' dd MMM yyyy HH':'mm':'ss 'GMT'");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		// Use UTC as the default time zone.
		return dateFormat.format(date);

	}
	
	public static String getBaseAuthValue(String username, String password) {
		try {
			return new String(Base64.encodeBase64(String.format("%s:%s",
					username, password).getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
	public static String getToken(){
		generatedTime = getTimeStamp();
		return getXToken(getTimeStamp(), udid, apiKey, secret);
	}
	
	public static String getSecretKey(){
		return secret;
	}
	
	public static String getApiKey(){
		return apiKey;
	}
	
	public static String getUdid(){
		return udid;
	}

	private static final String getXToken(String timeStamp, String udid,
			String apiKey, String sharedSecretKey) {
		if (TextUtils.isEmpty(apiKey) || TextUtils.isEmpty(sharedSecretKey))
			return null;

		String secretData = udid + "-" + apiKey + "-" + sharedSecretKey;

		return new String(Base64.encodeBase64(toHMACMD5(secretData, timeStamp)));
	}

	private static byte[] toHMACMD5 (String keyString , String message) {
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
}

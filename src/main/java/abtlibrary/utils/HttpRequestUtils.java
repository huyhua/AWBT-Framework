package abtlibrary.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import abtlibrary.ABTLibraryFatalException;

public class HttpRequestUtils {
	public static String getResponse(String url, String method,
			Map<String, String> headers) {
		StringBuffer response = new StringBuffer();

		try {
			URL obj;
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			// optional default is GET
			con.setRequestMethod(method);

			// add request header
			if (headers != null) {
				for (Map.Entry<String, String> cursor : headers.entrySet()) {
					con.setRequestProperty(cursor.getKey(), cursor.getValue());
				}
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
			} else {
				throw new ABTLibraryFatalException("Request to:" + url
						+ " failed with message " + con.getResponseMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response.toString();
	}

	public static JSONObject parseStringIntoJson(String content) {
		JSONParser parser = new JSONParser();
		try {
			return (JSONObject) parser.parse(content);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}

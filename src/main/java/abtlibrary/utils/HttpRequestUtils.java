package abtlibrary.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import abtlibrary.ABTLibraryFatalException;

public class HttpRequestUtils {
	public static String getResponse(String url, String method,
			Map<String, String> headers, String body) {
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
			
			if(body != null){
				con.setDoOutput(true);
				OutputStream os = con.getOutputStream();
		        os.write(body.getBytes());
		        os.flush();
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
						+ " failed with message " + con.getResponseMessage() + con.getResponseCode());
			}
			return response.toString();
		} catch (Exception e) {
			throw new ABTLibraryFatalException(e.getMessage());
		}
	}

	public static JSONObject parseStringIntoJson(String content) {
		JSONParser parser = new JSONParser();
		try {
			return (JSONObject) parser.parse(content);
		} catch (ParseException e) {
			throw new ABTLibraryFatalException(e.getMessage());
		}
	}
	
	
}

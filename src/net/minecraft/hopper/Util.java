package net.minecraft.hopper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Util {
	public static String performPost(URL url, String parameters,
			java.net.Proxy proxy, String contentType, boolean returnErrorPage)
			throws java.io.IOException {
		HttpURLConnection connection = (HttpURLConnection) url
				.openConnection(proxy);
		byte[] paramAsBytes = parameters.getBytes(java.nio.charset.Charset
				.forName("UTF-8"));

		connection.setConnectTimeout(15000);
		connection.setReadTimeout(15000);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", contentType
				+ "; charset=utf-8");

		connection.setRequestProperty("Content-Length", ""
				+ paramAsBytes.length);
		connection.setRequestProperty("Content-Language", "en-US");

		connection.setUseCaches(false);
		connection.setDoInput(true);
		connection.setDoOutput(true);

		DataOutputStream writer = new DataOutputStream(
				connection.getOutputStream());
		writer.write(paramAsBytes);
		writer.flush();
		writer.close();

		BufferedReader reader;
		try {
			reader = new BufferedReader(new java.io.InputStreamReader(
					connection.getInputStream()));
		} catch (java.io.IOException e) {
			if (returnErrorPage) {
				java.io.InputStream stream = connection.getErrorStream();

				if (stream != null) {
					reader = new BufferedReader(new java.io.InputStreamReader(
							stream));
				} else {
					throw e;
				}
			} else {
				throw e;
			}
		}

		StringBuilder response = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			response.append(line);
			response.append('\r');
		}

		reader.close();
		return response.toString();
	}

	public static URL constantURL(String input) {
		try {
			return new URL(input);
		} catch (java.net.MalformedURLException e) {
			throw new Error(e);
		}
	}
}

/*
 * Location:
 * M:\AFolderOfMinecraft\Minecraft.jar!\net\minecraft\hopper\Util.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */
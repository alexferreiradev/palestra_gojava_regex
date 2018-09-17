package html;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class HttpRequestExecutorBase implements HttpRequestExecutor {

	@Override
	public InputStream getResponseStream(URL url) {
		URLConnection urlConnection;

		try {
			urlConnection = url.openConnection();
			urlConnection.connect();

			return urlConnection.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String getResponseText(URL url) {
		InputStream httpResponseStream = getResponseStream(url);
		if (httpResponseStream != null) {

		}

		return null;
	}
}

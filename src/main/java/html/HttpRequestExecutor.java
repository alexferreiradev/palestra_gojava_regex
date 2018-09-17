package html;

import java.io.InputStream;
import java.net.URL;

public interface HttpRequestExecutor {

	InputStream getResponseStream(URL url);

	String getResponseText(URL url);
}

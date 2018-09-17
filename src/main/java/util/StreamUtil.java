package util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

public final class StreamUtil {

	public static String extractTextFromStream(InputStream stream) throws IOException {
		Path tempFile = Files.createTempDirectory("").resolve(UUID.randomUUID().toString() + ".tmp");
		Files.copy(stream, tempFile, StandardCopyOption.REPLACE_EXISTING);

		return new String(Files.readAllBytes(tempFile));
	}
}

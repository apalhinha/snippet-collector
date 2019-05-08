package info.trustzone.parser;

import java.io.IOException;
//import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesLib {
	
	public static String readFile(String apath) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(apath));
		return new String(encoded, StandardCharsets.UTF_8);
	}
	
}

package kainos.specs.accessibility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class AccessibilityUtils {

  protected static String readFile(String fileName) throws Exception {
    StringBuilder stringBuilder = new StringBuilder();
    try (InputStream inputStream = AccessibilityHtmlReporter.class.getClassLoader().getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

      // Read the file line by line
      String line;
      while ((line = reader.readLine()) != null) {
        stringBuilder.append(line);
      }
      return stringBuilder.toString();
    } catch (IOException e) {
      throw new Exception(e);
    }
  }

  protected static void createFile(String fileName, String content) throws IOException {
    File file = new File(fileName).getParentFile();
    file.mkdirs();
    try (FileWriter fileWriter = new FileWriter(fileName)) {
      fileWriter.write(content);
    } catch (IOException e) {
      throw new IOException(e);
    }
  }

  protected static void createDirectoriesIfDoesNotExist(String path) {
    File directory = new File(path);
    if(!directory.exists()) {
      directory.mkdirs();
    }
  }
}

package utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Resources {

    public static final String RESOURCE_FOLDER = "src/test/resources/";

    public static Path getResource(String filename) {
        return Paths.get(RESOURCE_FOLDER, filename);
    }
}

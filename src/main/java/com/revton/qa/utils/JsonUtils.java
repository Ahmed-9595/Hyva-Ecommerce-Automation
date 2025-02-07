package com.revton.qa.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;

public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T readJsonFile(String filePath, Class<T> clazz) {
        try (FileInputStream inputStream = new FileInputStream(new File(filePath))) {
            return mapper.readValue(inputStream, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse JSON file", e);
        }
    }
}


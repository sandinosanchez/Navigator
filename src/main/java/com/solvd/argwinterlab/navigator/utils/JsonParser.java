package com.solvd.argwinterlab.navigator.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonParser {
    private static final Logger LOGGER = Logger.getLogger(JsonParser.class);
    private static ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static void serializeJson(List<?> listToSerialize, String path) {
        try(FileWriter outputJsonFile = new FileWriter(path)) {
            outputJsonFile.write(mapper.writeValueAsString(listToSerialize));
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    public static List<?> deSerializeJson(Class<?> classType, String path) {
        try (InputStream is = new FileInputStream(path)){
            return mapper.readValue(is, mapper.getTypeFactory().constructCollectionType(List.class, classType));
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return null;
    }
}

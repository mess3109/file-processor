package com.example.fileprocessor.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtility {

    final static GsonBuilder builder = new GsonBuilder().setPrettyPrinting();

    public static <T> T getFromJsonFile(final String fileName, final Class<T> returnClass) throws IOException {
        Gson gson = builder.create();
        return gson.fromJson(readFile(fileName), returnClass);
    }

    private static String readFile(final String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void writeJson(final Object toJson) throws IOException {
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
        Gson gson = builder.create();
        Writer writer = new FileWriter("jsonOutput.json");
        gson.toJson(toJson, writer);
        writer.close();
    }
}

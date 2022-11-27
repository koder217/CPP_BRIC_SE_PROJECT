package edu.cpp.brcm.frontend.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.*;

import java.io.IOException;
import java.util.Objects;

public class BrcmAPI {
    public static final String ActivitiesUrl = "http://localhost:8080/api/v1/activities/";
    public static final String PriceHistoryUrl = "http://localhost:8080/api/v1/pricehistory/";

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    public static <T> T GetRequest(String url, Class<T> valueType) throws RuntimeException {
        OkHttpClient client = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            var resp = Objects.requireNonNull(response.body()).string();
            return objectMapper.readValue(resp, valueType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T PostRequest(String url, T dto, Class<T> valueType) throws IOException {
        OkHttpClient client = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        var json= objectMapper.writeValueAsString(dto);
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            var resp = Objects.requireNonNull(response.body()).string();
            return objectMapper.readValue(resp, valueType);
        }
    }

    public static <T> Boolean PutRequest(String url, T dto) throws IOException {
        OkHttpClient client = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        var json= objectMapper.writeValueAsString(dto);
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .put(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
           return response.isSuccessful();
        }
    }

    public static boolean DeleteRequest(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.isSuccessful();
        }
    }
}

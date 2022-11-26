package edu.cpp.brcm.frontend.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class BrcmAPI {
    public static final String ActivitiesUrl = "http://localhost:8080/api/v1/activities";

    public static <T> T GetRequest(String url, Class<T> valueType) throws RuntimeException {
        OkHttpClient client = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
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
}

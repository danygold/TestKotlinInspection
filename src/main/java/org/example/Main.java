package org.example;

import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    private void test() throws MalformedURLException {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .cache(new Cache(Path.of("cache").toFile(), 500))
                .build();

        URL fullUrl = new URL("URL");

        HttpUrl.Builder httpUrl = new HttpUrl.Builder()
                .scheme(fullUrl.getProtocol())
                .host(fullUrl.getHost())
                .addPathSegment("issues.json")
                .addQueryParameter("set_filter", "1");

        if (fullUrl.getPort() > 0) httpUrl.port(fullUrl.getPort());

        Request request = new Request.Builder()
                .url(httpUrl.build())
                .addHeader("Accept", "application/json, text/javascript, */*; q=0.01")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36")
                .build();

    }
}
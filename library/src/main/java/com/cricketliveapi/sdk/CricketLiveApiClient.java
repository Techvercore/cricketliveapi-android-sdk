package com.cricketliveapi.sdk;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Entry point for the CricketLiveAPI Android SDK.
 *
 * <pre>
 * CricketLiveApiClient client = new CricketLiveApiClient.Builder()
 *         .apiKey("YOUR_CRICKETLIVEAPI_KEY")
 *         .build();
 *
 * CricketApiService api = client.getService();
 * api.getLiveMatches().enqueue(...);
 * </pre>
 *
 * Get your API key at https://cricketliveapi.com
 */
public final class CricketLiveApiClient {

    public static final String DEFAULT_BASE_URL = "https://cricketliveapi.com/";

    private final CricketApiService service;

    private CricketLiveApiClient(Builder builder) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(builder.debug
                ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE);

        final String key = builder.apiKey;

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .header("Authorization", "Bearer " + key)
                            .header("Accept", "application/json")
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                })
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(builder.baseUrl)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.service = retrofit.create(CricketApiService.class);
    }

    /** Returns the Retrofit service interface. Use this to call any API endpoint. */
    public CricketApiService getService() {
        return service;
    }

    // ── Builder ───────────────────────────────────────────────────────────────

    public static final class Builder {
        private String  apiKey;
        private String  baseUrl = DEFAULT_BASE_URL;
        private boolean debug   = false;

        /**
         * Your CricketLiveAPI bearer token.
         * Get one at https://cricketliveapi.com
         * Never hardcode this in a public repo. Read it from BuildConfig or a secure store.
         */
        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        /** Override the base URL. Default: https://cricketliveapi.com/ */
        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        /** Enable OkHttp body logging. Disable in production. */
        public Builder debug(boolean debug) {
            this.debug = debug;
            return this;
        }

        public CricketLiveApiClient build() {
            if (apiKey == null || apiKey.isEmpty()) {
                throw new IllegalStateException(
                        "apiKey is required. Get yours at https://cricketliveapi.com");
            }
            return new CricketLiveApiClient(this);
        }
    }
}

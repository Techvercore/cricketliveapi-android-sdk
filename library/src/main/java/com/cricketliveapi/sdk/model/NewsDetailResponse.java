package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;

public class NewsDetailResponse {
    @SerializedName("success") public boolean success;
    @SerializedName("data")    public News    data;

    public static class News {
        @SerializedName("id")            public long   id;
        @SerializedName("title")         public String title;
        @SerializedName("slug")          public String slug;
        @SerializedName("content")       public String content;
        @SerializedName("thumbnail_url") public String thumbnailUrl;
        @SerializedName("published_at")  public String publishedAt;
        @SerializedName("source")        public String source;
        @SerializedName("source_url")    public String sourceUrl;
    }
}
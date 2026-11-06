package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SpotlightApiResponse {
    @SerializedName("success") public boolean         success;
    @SerializedName("total")   public int             total;
    @SerializedName("data")    public List<Article>   data;

    public static class Article {
        @SerializedName("id")            public long   id;
        @SerializedName("title")         public String title;
        @SerializedName("slug")          public String slug;
        @SerializedName("thumbnail_url") public String thumbnailUrl;
        @SerializedName("published_at")  public String publishedAt;
        @SerializedName("type")          public String type;
    }
}
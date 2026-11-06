package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class VideosApiResponse {
    @SerializedName("success") public boolean      success;
    @SerializedName("total")   public int          total;
    @SerializedName("data")    public List<Video>  data;

    public static class Video {
        @SerializedName("id")            public long   id;
        @SerializedName("title")         public String title;
        @SerializedName("slug")          public String slug;
        @SerializedName("thumbnail_url") public String thumbnailUrl;
        @SerializedName("video_url")     public String videoUrl;
        @SerializedName("published_at")  public String publishedAt;
        @SerializedName("duration")      public String duration;
    }
}
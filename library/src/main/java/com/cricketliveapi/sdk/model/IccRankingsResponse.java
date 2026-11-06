package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class IccRankingsResponse {
    @SerializedName("success") public boolean success;
    @SerializedName("data")    public Data    data;

    public static class Data {
        @SerializedName("category") public String          category;
        @SerializedName("format")   public String          format;
        @SerializedName("count")    public int             count;
        @SerializedName("rankings") public List<Ranking>   rankings;
    }

    public static class Ranking {
        @SerializedName("rank")        public String rank;
        @SerializedName("id")          public String id;
        @SerializedName("name")        public String name;
        @SerializedName("country")     public String country;
        @SerializedName("rating")      public String rating;
        @SerializedName("faceImageId") public String faceImageId;
    }
}
package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TeamsResponse {
    @SerializedName("success") public boolean success;
    @SerializedName("data")    public Data    data;

    public static class Data {
        @SerializedName("total") public int         total;
        @SerializedName("teams") public List<Team>  teams;
    }

    public static class Team {
        @SerializedName("id")             public long   id;
        @SerializedName("name")           public String name;
        @SerializedName("short_name")     public String shortName;
        @SerializedName("country")        public String country;
        @SerializedName("image_url")      public String imageUrl;
        @SerializedName("team_image_url") public String teamImageUrl;
    }
}
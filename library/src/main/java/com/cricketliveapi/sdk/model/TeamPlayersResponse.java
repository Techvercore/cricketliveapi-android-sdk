package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TeamPlayersResponse {
    @SerializedName("success") public boolean      success;
    @SerializedName("data")    public List<Player> data;

    public static class Player {
        @SerializedName("id")               public long   id;
        @SerializedName("name")             public String name;
        @SerializedName("role")             public String role;
        @SerializedName("image_id")         public String imageId;
        @SerializedName("player_image_url") public String playerImageUrl;
        @SerializedName("batting_style")    public String battingStyle;
        @SerializedName("bowling_style")    public String bowlingStyle;
    }
}
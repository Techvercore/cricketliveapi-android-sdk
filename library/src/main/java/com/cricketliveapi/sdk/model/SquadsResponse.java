package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SquadsResponse {
    @SerializedName("success") public boolean    success;
    @SerializedName("data")    public List<Team> data;

    public static class Team {
        @SerializedName("team_id")    public long          teamId;
        @SerializedName("team_name")  public String        teamName;
        @SerializedName("team_short") public String        teamShort;
        @SerializedName("playing_xi") public List<Player>  playingXi;
        @SerializedName("bench")      public List<Player>  bench;
    }

    public static class Player {
        @SerializedName("id")               public long   id;
        @SerializedName("name")             public String name;
        @SerializedName("role")             public String role;
        @SerializedName("image_id")         public String imageId;
        @SerializedName("player_image_url") public String playerImageUrl;
    }
}
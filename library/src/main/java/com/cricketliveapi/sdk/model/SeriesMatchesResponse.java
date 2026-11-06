package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SeriesMatchesResponse {
    @SerializedName("success") public boolean      success;
    @SerializedName("data")    public List<Match>  data;

    public static class Match {
        @SerializedName("match_id")    public long   matchId;
        @SerializedName("match_desc")  public String matchDesc;
        @SerializedName("format")      public String format;
        @SerializedName("state")       public String state;
        @SerializedName("status")      public String status;
        @SerializedName("date")        public String date;
        @SerializedName("venue")       public String venue;
    }
}
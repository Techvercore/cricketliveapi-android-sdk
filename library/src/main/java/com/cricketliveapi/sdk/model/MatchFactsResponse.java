package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;

public class MatchFactsResponse {
    @SerializedName("success") public boolean success;
    @SerializedName("data")    public Data    data;

    public static class Data {
        @SerializedName("match_id")     public long         matchId;
        @SerializedName("toss")         public String       toss;
        @SerializedName("venue")        public String       venue;
        @SerializedName("umpires")      public String       umpires;
        @SerializedName("referee")      public String       referee;
        @SerializedName("venue_details") public VenueDetails venueDetails;
    }

    public static class VenueDetails {
        @SerializedName("ground")   public String ground;
        @SerializedName("city")     public String city;
        @SerializedName("timezone") public String timezone;
    }
}
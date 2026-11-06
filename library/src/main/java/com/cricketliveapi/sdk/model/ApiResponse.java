package com.cricketliveapi.sdk.model;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

/**
 * Generic wrapper used by live, recent, upcoming, schedule, and fantasy endpoints.
 * {@code data} is a JsonElement because the shape varies per endpoint.
 * Cast or re-parse with Gson as needed.
 */
public class ApiResponse {
    @SerializedName("success") public boolean     success;
    @SerializedName("type")    public String      type;
    @SerializedName("count")   public int         count;
    @SerializedName("total")   public int         total;
    @SerializedName("data")    public JsonElement data;
    @SerializedName("error")   public String      error;
}
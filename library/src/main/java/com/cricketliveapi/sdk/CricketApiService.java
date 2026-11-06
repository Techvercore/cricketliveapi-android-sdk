package com.cricketliveapi.sdk;

import com.cricketliveapi.sdk.model.ApiResponse;
import com.cricketliveapi.sdk.model.CommentaryResponse;
import com.cricketliveapi.sdk.model.GraphsResponse;
import com.cricketliveapi.sdk.model.HighlightsResponse;
import com.cricketliveapi.sdk.model.IccRankingsResponse;
import com.cricketliveapi.sdk.model.MatchFactsResponse;
import com.cricketliveapi.sdk.model.NewsApiResponse;
import com.cricketliveapi.sdk.model.NewsDetailResponse;
import com.cricketliveapi.sdk.model.OversResponse;
import com.cricketliveapi.sdk.model.PlayerProfileResponse;
import com.cricketliveapi.sdk.model.PointsTableResponse;
import com.cricketliveapi.sdk.model.ScorecardResponse;
import com.cricketliveapi.sdk.model.SeriesArchiveApiResponse;
import com.cricketliveapi.sdk.model.SeriesMatchesResponse;
import com.cricketliveapi.sdk.model.SeriesResponse;
import com.cricketliveapi.sdk.model.SpotlightApiResponse;
import com.cricketliveapi.sdk.model.SquadsResponse;
import com.cricketliveapi.sdk.model.TeamPlayersResponse;
import com.cricketliveapi.sdk.model.TeamsResponse;
import com.cricketliveapi.sdk.model.VideosApiResponse;
import com.cricketliveapi.sdk.model.WtcPointsTableResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Retrofit interface for the CricketLiveAPI.
 * Base URL: https://cricketliveapi.com/api/v1/
 * Docs:     https://cricketliveapi.com/api-docs
 */
public interface CricketApiService {

    // ── Live / Recent / Upcoming ──────────────────────────────────────────────

    @GET("api/v1/cricket/matches/live")
    Call<ApiResponse> getLiveMatches();

    @GET("api/v1/cricket/matches/recent")
    Call<ApiResponse> getRecentMatches();

    @GET("api/v1/cricket/matches/upcoming")
    Call<ApiResponse> getUpcomingMatches();

    @GET("api/v1/cricket/live")
    Call<ApiResponse> getLiveScores();

    // ── Match detail ──────────────────────────────────────────────────────────

    /** matchId required. slug is optional — pass empty string if unknown. */
    @GET("api/v1/cricket/scorecard/{matchId}/{slug}")
    Call<ScorecardResponse> getScorecard(
            @Path("matchId") long matchId,
            @Path("slug")    String slug);

    @GET("api/v1/cricket/live-scorecard/{matchId}/{slug}")
    Call<ScorecardResponse> getLiveScorecard(
            @Path("matchId") long matchId,
            @Path("slug")    String slug);

    @GET("api/v1/cricket/commentary/{matchId}/{slug}")
    Call<CommentaryResponse> getCommentary(
            @Path("matchId") long matchId,
            @Path("slug")    String slug);

    @GET("api/v1/cricket/squads/{matchId}/{slug}")
    Call<SquadsResponse> getSquads(
            @Path("matchId") long matchId,
            @Path("slug")    String slug);

    @GET("api/v1/cricket/highlights/{matchId}/{slug}")
    Call<HighlightsResponse> getHighlights(
            @Path("matchId") long matchId,
            @Path("slug")    String slug);

    @GET("api/v1/cricket/graphs/{matchId}/{slug}")
    Call<GraphsResponse> getGraphs(
            @Path("matchId") long matchId,
            @Path("slug")    String slug);

    @GET("api/v1/cricket/overs/{matchId}/{slug}")
    Call<OversResponse> getOvers(
            @Path("matchId") long matchId,
            @Path("slug")    String slug,
            @Query("innings") int innings);

    @GET("api/v1/cricket/match-facts/{matchId}/{slug}")
    Call<MatchFactsResponse> getMatchFacts(
            @Path("matchId") long matchId,
            @Path("slug")    String slug);

    // ── Schedule and series ───────────────────────────────────────────────────

    /** category: all | international | domestic | league | women */
    @GET("api/v1/cricket/schedule/{category}")
    Call<ApiResponse> getSchedule(@Path("category") String category);

    /** category: all | international | domestic | league | women */
    @GET("api/v1/cricket/series/{category}")
    Call<SeriesResponse> getSeries(@Path("category") String category);

    @GET("api/v1/cricket/series/{seriesId}/matches")
    Call<SeriesMatchesResponse> getSeriesMatches(@Path("seriesId") long seriesId);

    @GET("api/v1/cricket/series/{seriesId}/points-table")
    Call<PointsTableResponse> getPointsTable(@Path("seriesId") long seriesId);

    /** year: e.g. 2026. Pass 0 to use the server default (current year). */
    @GET("api/v1/cricket/series-archive")
    Call<SeriesArchiveApiResponse> getSeriesArchive(@Query("year") int year);

    @GET("api/v1/cricket/wtc-points-table")
    Call<WtcPointsTableResponse> getWtcPointsTable();

    // ── Teams and players ─────────────────────────────────────────────────────

    /** category: international | domestic | league | women */
    @GET("api/v1/cricket/teams/{category}")
    Call<TeamsResponse> getTeams(@Path("category") String category);

    @GET("api/v1/cricket/team-players/{teamId}/{slug}")
    Call<TeamPlayersResponse> getTeamPlayers(
            @Path("teamId") long teamId,
            @Path("slug")   String slug);

    @GET("api/v1/cricket/player/{playerId}/{slug}")
    Call<PlayerProfileResponse> getPlayerProfile(
            @Path("playerId") long playerId,
            @Path("slug")     String slug);

    // ── ICC Rankings ──────────────────────────────────────────────────────────

    /** category: batting | bowling | allrounder | teams  format: test | odi | t20 */
    @GET("api/v1/cricket/icc-rankings/{category}/{format}")
    Call<IccRankingsResponse> getIccRankings(
            @Path("category") String category,
            @Path("format")   String format);

    @GET("api/v1/cricket/icc-rankings-women/{category}/{format}")
    Call<IccRankingsResponse> getIccRankingsWomen(
            @Path("category") String category,
            @Path("format")   String format);

    // ── News and video ────────────────────────────────────────────────────────

    @GET("api/v1/cricket/news")
    Call<NewsApiResponse> getNews(
            @Query("limit") int limit,
            @Query("page")  int page);

    @GET("api/v1/cricket/news/{newsId}/{slug}")
    Call<NewsDetailResponse> getNewsDetail(
            @Path("newsId") long newsId,
            @Path("slug")   String slug);

    @GET("api/v1/cricket/videos")
    Call<VideosApiResponse> getVideos(@Query("limit") int limit);

    @GET("api/v1/cricket/spotlight")
    Call<SpotlightApiResponse> getSpotlight(@Query("limit") int limit);

    // ── Fantasy ───────────────────────────────────────────────────────────────

    @GET("api/v1/fantasy/matches")
    Call<ApiResponse> getFantasyMatches();

    @GET("api/v1/fantasy/players/{matchId}")
    Call<ApiResponse> getFantasyPlayers(@Path("matchId") long matchId);

    @GET("api/v1/fantasy/playing-xi/{matchId}")
    Call<ApiResponse> getPlayingXi(@Path("matchId") long matchId);

    @GET("api/v1/fantasy/points-engine")
    Call<ApiResponse> getFantasyPointsEngine();

    @GET("api/v1/fantasy/player-points/{matchId}")
    Call<ApiResponse> getFantasyPlayerPoints(@Path("matchId") long matchId);

    @GET("api/v1/fantasy/live-score/{matchId}")
    Call<ApiResponse> getFantasyLiveScore(@Path("matchId") long matchId);

    @GET("api/v1/contest/leaderboard/{contestId}")
    Call<ApiResponse> getContestLeaderboard(@Path("contestId") long contestId);
}
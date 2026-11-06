# CricketLiveAPI Android SDK

Official Android SDK for [CricketLiveAPI](https://cricketliveapi.com) — Cricket Live Score API for Android, live scorecard, ball-by-ball commentary, fantasy cricket, ICC rankings, and more.

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
[![Min SDK](https://img.shields.io/badge/minSdk-21-blue.svg)](library/build.gradle.kts)
[![Language](https://img.shields.io/badge/language-Java-orange.svg)](library/src/main/java)

## Features

- Live cricket scores and scorecards for Android
- Ball-by-ball commentary
- Match squads, highlights, graphs, overs
- ICC rankings (men and women)
- Series, schedule, points table, WTC table
- Player profiles and team rosters
- Cricket news, videos, spotlight
- Fantasy cricket — matches, players, playing XI, points engine
- No hardcoded keys — supply your own token at runtime

## Installation

Add JitPack to your root `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

Add the dependency in your app `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.github.Techvercore:cricketliveapi-android-sdk:1.0.0")
}
```

Or clone and include as a local module:

```kotlin
// settings.gradle.kts
include(":cricketliveapi-android-sdk:library")

// app/build.gradle.kts
dependencies {
    implementation(project(":cricketliveapi-android-sdk:library"))
}
```

## Quick start

Get your API key at https://cricketliveapi.com

```java
import com.cricketliveapi.sdk.CricketLiveApiClient;
import com.cricketliveapi.sdk.CricketApiService;
import com.cricketliveapi.sdk.model.ApiResponse;

CricketLiveApiClient client = new CricketLiveApiClient.Builder()
        .apiKey(BuildConfig.CRICKETLIVEAPI_KEY)   // never hardcode
        .build();

CricketApiService api = client.getService();

// Live matches
api.getLiveMatches().enqueue(new Callback<ApiResponse>() {
    @Override
    public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
        if (response.isSuccessful() && response.body() != null) {
            Log.d("Cricket", "Live count: " + response.body().count);
        }
    }
    @Override
    public void onFailure(Call<ApiResponse> call, Throwable t) {
        Log.e("Cricket", t.getMessage());
    }
});
```

Store the key in `local.properties` and expose it via `BuildConfig`:

```kotlin
// app/build.gradle.kts
android {
    defaultConfig {
        buildConfigField("String", "CRICKETLIVEAPI_KEY",
            "\"${project.findProperty("CRICKETLIVEAPI_KEY") ?: ""}\"")
    }
}
```

```properties
# local.properties  (never commit this file)
CRICKETLIVEAPI_KEY=YOUR_CRICKETLIVEAPI_KEY
```

## All endpoints

### Live / Recent / Upcoming

```java
api.getLiveMatches().enqueue(...)
api.getRecentMatches().enqueue(...)
api.getUpcomingMatches().enqueue(...)
api.getLiveScores().enqueue(...)
```

### Match detail

```java
api.getScorecard(177701L, "lul-vs-jab").enqueue(...)
api.getLiveScorecard(173060L, "").enqueue(...)
api.getCommentary(177701L, "").enqueue(...)
api.getSquads(177701L, "").enqueue(...)
api.getHighlights(177701L, "").enqueue(...)
api.getGraphs(177701L, "").enqueue(...)
api.getOvers(177701L, "", 1).enqueue(...)
api.getMatchFacts(177701L, "").enqueue(...)
```

### Schedule and series

```java
api.getSchedule("all").enqueue(...)          // all | international | domestic | league | women
api.getSeries("international").enqueue(...)
api.getSeriesMatches(13211L).enqueue(...)
api.getPointsTable(13211L).enqueue(...)
api.getSeriesArchive(2026).enqueue(...)
api.getWtcPointsTable().enqueue(...)
```

### Teams and players

```java
api.getTeams("international").enqueue(...)   // international | domestic | league | women
api.getTeamPlayers(2L, "india").enqueue(...)
api.getPlayerProfile(15273L, "parvez-hossain-emon").enqueue(...)
```

### ICC Rankings

```java
api.getIccRankings("batting", "odi").enqueue(...)
api.getIccRankingsWomen("batting", "odi").enqueue(...)
// category: batting | bowling | allrounder | teams
// format:   test | odi | t20
```

### News and video

```java
api.getNews(20, 1).enqueue(...)
api.getNewsDetail(12345L, "").enqueue(...)
api.getVideos(10).enqueue(...)
api.getSpotlight(10).enqueue(...)
```

### Fantasy

```java
api.getFantasyMatches().enqueue(...)
api.getFantasyPlayers(177701L).enqueue(...)
api.getPlayingXi(177701L).enqueue(...)
api.getFantasyPointsEngine().enqueue(...)
api.getFantasyPlayerPoints(177701L).enqueue(...)
api.getFantasyLiveScore(177701L).enqueue(...)
api.getContestLeaderboard(contestId).enqueue(...)
```

## Verified live responses

All endpoints below were verified against the live CricketLiveAPI.

**getLiveMatches()** — `success: true`, `type: "live"`, `count: 5`. First match: id 173060, "West Indies tour of Bangladesh, 2026", "2nd Test", format TEST, venue "Sylhet International Cricket Stadium, Sylhet".

**getRecentMatches()** — `type: "recent"`, `count: 94`. First: id 177701, "Nepal Premier League 2026", "14th Match", T20, state Complete, status "Lumbini Lions won by 16 runs".

**getUpcomingMatches()** — `type: "upcoming"`, `count: 44`. First: id 173060, match_format "TEST", state "upcoming".

**getScorecard(177701)** — innings[0] bat_team "Lumbini Lions", score "149/8 (20 ov)", run_rate 7.45.

**getCommentary(177701)** — miniscore bat_team_score 133, target 150, status "Lumbini Lions won by 16 runs".

**getSquads(177701)** — data is an array. team_id 2918 "Janakpur Bolts". playing_xi[0] id 15273 "Parvez Hossain Emon", role "WK-Batter".

**getHighlights(177701)** — data.total 28. highlights[0] over 19.6, event "over-break,WICKET".

**getGraphs(177701)** — matchId 177701, team1Name "LUL", team2Name "JAB".

**getMatchFacts(177701)** — toss "Janakpur Bolts won the toss and opt to Bowl", city "Kirtipur", timezone "+05:45".

**getSchedule("all")** — category "all", total 133. data[0].date "FRI, NOV 06 2026".

**getSeries("international")** — total 22. series[0] id 7572 "ICC Cricket World Cup League Two 2023-27".

**getTeams("international")** — data.total 38. teams[0] id 2 "India" short_name "IND".

**getPlayerProfile(15273)** — player_id 15273, name "Parvez Hossain Emon", Role "WK-Batsman".

**getIccRankings("batting","odi")** — count 15. rankings[0] rank "1", name "Shubman Gill", country "India", rating "841".

## Dependencies

The library exposes these as `api` dependencies (no extra `implementation` needed in your app):

- Retrofit 2.11.0
- OkHttp 4.12.0
- Gson 2.11.0
- Kotlin Coroutines Android 1.8.1

## Requirements

- Android minSdk 21 (Android 5.0+)
- Java 11 source compatibility

## Support

- Docs: https://cricketliveapi.com/api-docs
- Website: https://cricketliveapi.com
- Issues: https://github.com/Techvercore/cricketliveapi-android-sdk/issues
- Email: support@cricketliveapi.com
- Company: https://techwarezen.com

## License

MIT — see [LICENSE](LICENSE)
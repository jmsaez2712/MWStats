package dev.jmsaez.projectapi.model.api

import dev.jmsaez.projectapi.model.entity.Leaderboard
import dev.jmsaez.projectapi.model.entity.Player
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

import retrofit2.http.Path

interface RestClient {

    @Headers(
        "X-RapidAPI-Host: call-of-duty-modern-warfare.p.rapidapi.com",
        "X-RapidAPI-Key: cdf0d6bb69msh18763eb3905b3f2p1ccc14jsnd7c9b9675c57"
    )
    @GET("multiplayer/{gamertag}/{platform}")
    suspend fun getFullPlayer(@Path("gamertag")player:String, @Path("platform")platform:String): Response<Player>

    @Headers(
        "X-RapidAPI-Host: call-of-duty-modern-warfare.p.rapidapi.com",
        "X-RapidAPI-Key: cdf0d6bb69msh18763eb3905b3f2p1ccc14jsnd7c9b9675c57"
    )
    @GET("leaderboard/1/battle")
    suspend fun getLeaderboard(): Response<Leaderboard>



}
package dev.jmsaez.projectapi.model.api

import dev.jmsaez.projectapi.model.entity.Player
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

import retrofit2.http.Path

interface RestClient {

    @Headers(
        "X-RapidAPI-Host: call-of-duty-modern-warfare.p.rapidapi.com",
        "X-RapidAPI-Key: 631591178fmsh9a53bae88452547p1aa000jsnfbb142235217"
    )
    @GET("multiplayer/{gamertag}/{platform}")
    fun getFullPlayer(@Path("gamertag")platform:String, @Path("platform")playerName:String): Call<Player>

}
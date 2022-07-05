package dev.jmsaez.projectapi.model.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import dev.jmsaez.projectapi.model.api.RestClient
import dev.jmsaez.projectapi.model.entity.Player
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class Repository(context: Context) {
    var restClient: RestClient
    var playerLiveData: MutableLiveData<Player>
    init {
        restClient = this.returnRestClient()
        playerLiveData = MutableLiveData()
    }
    private fun returnRestClient():RestClient{
        var retrofit = Retrofit.Builder()
            .baseUrl("https://call-of-duty-modern-warfare.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var restClient = retrofit.create(RestClient::class.java)
        return restClient
    }


    fun getPlayer(player:String, platform:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = restClient.getFullPlayer(player, platform)
            val player = call.body()
            if(call.isSuccessful){
                playerLiveData.postValue(player)
            }
        }
    }

    fun returnPlayerLiveData():MutableLiveData<Player>{
        return playerLiveData
    }
}
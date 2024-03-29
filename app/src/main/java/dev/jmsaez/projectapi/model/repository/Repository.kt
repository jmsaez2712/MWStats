package dev.jmsaez.projectapi.model.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import dev.jmsaez.projectapi.model.api.RestClient
import dev.jmsaez.projectapi.model.entity.Leaderboard
import dev.jmsaez.projectapi.model.entity.Player
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class Repository(context: Context) {
    var restClient: RestClient
    var playerLiveData: MutableLiveData<Player>
    var leaderboardLiveData: MutableLiveData<Leaderboard>
    init {
        restClient = this.returnRestClient()
        playerLiveData = MutableLiveData()
        leaderboardLiveData = MutableLiveData()
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
            var urlPlatform = returnPlatform(platform)
            val call = restClient.getFullPlayer(player, urlPlatform)
            val player = call.body()
            if(call.isSuccessful){
                playerLiveData.postValue(player)
            } else {
                Log.d("::ERRORAPI", call.message())
            }
        }
    }

    fun getLeaderboard(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = restClient.getLeaderboard()
            val leaderboard = call.body()
            if(call.isSuccessful){
                leaderboardLiveData.postValue(leaderboard)
            } else {
                Log.d("::ERRORAPI", call.errorBody()!!.string())
            }
        }
    }

    fun returnLeaderboardLiveData():MutableLiveData<Leaderboard>{
        return leaderboardLiveData
    }

    fun returnPlayerLiveData():MutableLiveData<Player>{
        return playerLiveData
    }

    private fun returnPlatform(platform:String):String{
        when(platform){
            "PSN" -> return "psn"
            "Xbox" -> return "xbl"
            "Battle.net"-> return "battle"
            "Activision ID"-> return "acti"
        }
        return ""
    }
}


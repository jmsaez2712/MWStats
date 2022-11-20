package dev.jmsaez.projectapi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonObject
import dev.jmsaez.projectapi.model.entity.Leaderboard
import dev.jmsaez.projectapi.model.repository.Repository
import okhttp3.ResponseBody
import okhttp3.internal.platform.ConscryptPlatform
import org.json.JSONObject

class LeaderboardViewModel(application:Application):AndroidViewModel(application) {

    var repository: Repository

    init {
        repository = Repository(application)
    }

    fun getLeaderboard(platform: String){
        repository.getLeaderboard(platform)
    }

    fun getLeaderborardLiveData():MutableLiveData<Leaderboard>{
        return repository.returnLeaderboardLiveData()
    }
}
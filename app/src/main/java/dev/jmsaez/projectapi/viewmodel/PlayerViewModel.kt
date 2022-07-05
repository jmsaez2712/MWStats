package dev.jmsaez.projectapi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.jmsaez.projectapi.model.entity.Player
import dev.jmsaez.projectapi.model.repository.Repository

class PlayerViewModel(application: Application): AndroidViewModel(application) {

    var repository:Repository

    init {
       repository = Repository(application)
    }

    fun getPlayer(player:String, platform:String){
        repository.getPlayer(player, platform)
    }

    fun getPlayerLiveData():MutableLiveData<Player> {
        return repository.returnPlayerLiveData()
    }
}
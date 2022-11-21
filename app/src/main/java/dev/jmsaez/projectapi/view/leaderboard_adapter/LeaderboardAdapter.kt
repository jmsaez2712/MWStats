package dev.jmsaez.projectapi.view.leaderboard_adapter

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.AndroidViewModel
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.Recycler
import dev.jmsaez.projectapi.R
import dev.jmsaez.projectapi.model.entity.Leaderboard
import dev.jmsaez.projectapi.view.leaderboard_viewholder.LeaderboardViewholder
import dev.jmsaez.projectapi.viewmodel.LeaderboardViewModel

class LeaderboardAdapter(context: Context, recycler: RecyclerView) : Adapter<LeaderboardViewholder>() {

    var leaderboardViewModel: LeaderboardViewModel;
    var leaderboard : List<Leaderboard.Entries>? = null
    var recycler: RecyclerView = recycler
    init {
        leaderboardViewModel = LeaderboardViewModel(context?.applicationContext as Application)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderboardViewholder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.leaderboard_item, parent, false)
        return LeaderboardViewholder(view, recycler)
    }

    override fun onBindViewHolder(holder: LeaderboardViewholder, position: Int) {
        var entry: Leaderboard.Entries? = leaderboard?.get(position)
        holder.entry = entry
        holder.level.text = "Level: " + entry?.values?.level.toString()
        holder.rank.text = "#"+entry?.rank.toString()
        holder.user.text = entry?.username!!.split("#")[0]
        holder.originalUser.text = "Username: " + entry.username

        //Values data
        holder.wins.text = "Wins: " + entry.values.wins.toString()
        holder.kd.text = "KD: " + String.format("%.2f",entry.values.kdRatio)
        holder.accuracy.text = "Accuracy: " + String.format("%.2f",entry.values.accuracy)
        holder.gamesPlayed.text = "Games played: " + entry.values.gamesPlayed.toString()
        holder.hours.text = "Time played: " + entry.values.timePlayed + " h"

    }

    override fun getItemCount(): Int {
        return leaderboard?.size ?: 0
    }

    fun setEntriesList(entriesNewList: List<Leaderboard.Entries>){
        leaderboard = entriesNewList;
        notifyDataSetChanged()
    }
}
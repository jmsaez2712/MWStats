package dev.jmsaez.projectapi.model.entity

import android.os.Parcelable


class Leaderboard (
    var entries: Entries
        ) {


    data class Entries(
        var players: ArrayList<LeaderboardPlayer>
    ){
        override fun toString(): String {
            return "Entries(players=$players)"
        }
    }

    data class LeaderboardPlayer(
        var username: String,
        var rank: Int,
        var values: Values
    )
    {
        override fun toString(): String {
            return "LeaderboardPlayer(username='$username', rank=$rank, values=$values)"
        }
    }

    data class Values(
        var kdRatio: Double,
        var wins: Int,
        var level: Int
    ){
        override fun toString(): String {
            return "Values(kdRatio=$kdRatio, wins=$wins, level=$level)"
        }
    }

    override fun toString(): String {
        return "Leaderboard(entries=${entries.toString()})"
    }

}
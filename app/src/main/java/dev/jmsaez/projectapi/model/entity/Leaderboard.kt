package dev.jmsaez.projectapi.model.entity

import android.os.Parcelable


class Leaderboard (
    var entries: List<Entries>
        ) {


    data class Entries(
        var rank: Int,
        var username: String,
        var values: Values
    ){
        override fun toString(): String {
            return "Entries(username='$username', rank=$rank, values=$values)"
        }
    }
    data class Values(
        var wins: Int,
        var kdRatio: Double,
        var level: Int,
        var accuracy: Double,
        var gamesPlayed: Int,
        var timePlayed: Int
    ){
        override fun toString(): String {
            return "Values(kdRatio=$kdRatio, wins=$wins, level=$level)"
        }
    }

    override fun toString(): String {
        return "Leaderboard(entries=${entries.toString()})"
    }

}
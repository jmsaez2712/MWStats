package dev.jmsaez.projectapi.model.entity

class Player (
        var title: String,
        var platform: String,
        var username: String,
        var type: String,
        var level: Int,
        var maxLevel: Int,
        var prestige: Int,
        var lifetime: Lifetime,
        var engagement: String
    ){

    data class Lifetime(
        var all: All
    ){
        override fun toString(): String {
            return "Lifetime(all=$all)"
        }
    }

    data class Properties(
        var accuracy:Double,
        var assists:Int,
        var bestKD:Double,
        var bestKillChain:Int,
        var bestKillStreak:Int,
        var bestKills:Int,
        var bestScore:Int,
        var deaths:Int,
        var gamesPlayed: Int,
        var headshots:Int,
        var hits:Int,
        var kdRatio:Double,
        var kills:Int,
        var losses:Int,
        var scorePerMinute: Double,
        var scorePerGame: Double,
        var timePlayedTotal: Int,
        var winLossRatio: Double,
        var ties:Int,
        var wins:Int,
        var totalShots: Int
    ){
        override fun toString(): String {
            return "Properties(accuracy=$accuracy, assists=$assists, bestKD=$bestKD, bestKillChain=$bestKillChain, bestKillStreak=$bestKillStreak, bestKills=$bestKills, bestScore=$bestScore, deaths=$deaths, gamesPlayed=$gamesPlayed, headshots=$headshots, hits=$hits, kdRatio=$kdRatio, kills=$kills, losses=$losses, scorePerMinute=$scorePerMinute, timePlayedTotal=$timePlayedTotal, winLossRatio=$winLossRatio, ties=$ties, wins=$wins, totalShots=$totalShots)"
        }
    }

    data class All(
        var properties: Properties
    ){
        override fun toString(): String {
            return "All(properties=$properties)"
        }
    }

    override fun toString(): String {
        return "Player(title='$title', platform='$platform', username='$username', type='$type', level=$level, maxLevel=$maxLevel, prestige=$prestige, lifetime=$lifetime, engagement='$engagement')"
    }


}
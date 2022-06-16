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
    )

    data class Properties(
        var adsKills: Int,
        var ammoBoxUsed: Int,
        var arDeaths: Int,
        var arHeadshots: Int,
        var arKills: Int,
        var assaults: Int,
        var avengerKills:Int,
        var bombDefused: Int,
        var bombDetonated: Int,
        var bombPlanted: Int,
        var c4Kills: Int,
        var captures: Int,
        var carpackagesCaptures: Int,
        var carrierKills: Int,
        var classChanges: Int,
        var claymoreKills: Int,
        var clutch: Int,
        var clutchRevives: Int,
        var comebackKills: Int,
        var deadSilenceKills: Int,
        var deathsFromBehind: Int,
        var decoyHits: Int,
        var destroyedKillstreak: Int,
        var executionKills: Int,
        var fragKills: Int,
        var headshots: Int,
        var accuracy: Double,
        var assists: Int,
        var bestAssists: Int,
        var bestCaptures: Int,
        var bestConfirmed: Int,
        var bestDamage: Int,
        var bestDeaths: Int,
        var bestDefends: Int,
        var bestDefuses: Int,
        var bestDenied: Int,
        var bestDestructions: Int,
        var bestFieldgoals: Int,
        var bestKD: Double,
        var bestKillChains: Int,
        var bestKillStreak:Int,
        var bestKills: Int,
        var kdRatio: Double,
        var wlRatio: Double,
    )

    data class All(
        var properties: Properties
    )



}
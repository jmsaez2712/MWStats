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
    ){
        override fun toString(): String {
            return "Properties(adsKills=$adsKills, ammoBoxUsed=$ammoBoxUsed, arDeaths=$arDeaths, arHeadshots=$arHeadshots, arKills=$arKills, assaults=$assaults, avengerKills=$avengerKills, bombDefused=$bombDefused, bombDetonated=$bombDetonated, bombPlanted=$bombPlanted, c4Kills=$c4Kills, captures=$captures, carpackagesCaptures=$carpackagesCaptures, carrierKills=$carrierKills, classChanges=$classChanges, claymoreKills=$claymoreKills, clutch=$clutch, clutchRevives=$clutchRevives, comebackKills=$comebackKills, deadSilenceKills=$deadSilenceKills, deathsFromBehind=$deathsFromBehind, decoyHits=$decoyHits, destroyedKillstreak=$destroyedKillstreak, executionKills=$executionKills, fragKills=$fragKills, headshots=$headshots, accuracy=$accuracy, assists=$assists, bestAssists=$bestAssists, bestCaptures=$bestCaptures, bestConfirmed=$bestConfirmed, bestDamage=$bestDamage, bestDeaths=$bestDeaths, bestDefends=$bestDefends, bestDefuses=$bestDefuses, bestDenied=$bestDenied, bestDestructions=$bestDestructions, bestFieldgoals=$bestFieldgoals, bestKD=$bestKD, bestKillChains=$bestKillChains, bestKillStreak=$bestKillStreak, bestKills=$bestKills, kdRatio=$kdRatio, wlRatio=$wlRatio)"
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
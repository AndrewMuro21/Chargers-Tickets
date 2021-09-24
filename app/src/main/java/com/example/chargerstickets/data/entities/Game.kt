package com.example.chargerstickets.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    //gameId is the same as week number
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "game_id")
    val gameId: Int,
    @ColumnInfo(name = "home_team")
    val homeTeam: String,
    @ColumnInfo(name = "away_team")
    val awayTeam: String,
    val stadium: String,
    val date: String,
    val time: String,
    val bye: Boolean
)
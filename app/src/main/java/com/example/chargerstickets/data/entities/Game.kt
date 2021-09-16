package com.example.chargerstickets.data.entities

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    //gameId is the same as week number
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "game_id")
    val gameId: Int,
    @Nullable
    @ColumnInfo(name = "home_team")
    val homeTeam: String,
    @Nullable
    @ColumnInfo(name = "away_team")
    val awayTeam: String,
    @Nullable
    val stadium: String,
    @Nullable
    val date: String,
    @Nullable
    val time: String
)
package com.example.chargerstickets.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ticket (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ticket_id")
    val ticketId: Int,
    @ColumnInfo(name = "order_id")
    val orderId: String,
    @ColumnInfo(name = "game_id")
    val gameId: Int,
    @ColumnInfo
    val seat: String,
    @ColumnInfo
    val price: Double
)
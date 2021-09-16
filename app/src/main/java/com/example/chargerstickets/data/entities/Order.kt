package com.example.chargerstickets.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Order (
        //combination of gameId/week and all the seats
        @PrimaryKey(autoGenerate = false)
        val orderId: String,
        //gameId is the same as week number
        @ColumnInfo(name = "game_id")
        val gameId: Int,
        @ColumnInfo(name = "ticket_count")
        val ticketCount: Int,
        @ColumnInfo(name = "total_price")
        val totalPrice: Double,
        @ColumnInfo(name = "order_date")
        val orderDate: String
)
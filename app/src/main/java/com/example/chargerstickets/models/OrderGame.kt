package com.example.chargerstickets.models

//TODO: figure out
/**
 * class holding data from both an Order and a Game
 */
data class OrderGame(
    val ticketCount: String,
    val totalPrice: String,
    val orderDate: String,
    val homeTeam: String,
    val awayTeam: String
)
package com.example.chargerstickets.models

/**
 * subset class of Ticket
 */
data class TicketCore(
    val ticketId: String,
    val seat: String,
    val price: Double
)
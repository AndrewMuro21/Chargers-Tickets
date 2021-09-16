package com.example.chargerstickets.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chargerstickets.data.entities.Game
import com.example.chargerstickets.data.entities.Ticket
import com.example.chargerstickets.models.TicketCore

@Dao
interface ChargersTicketsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(game: Game)


    @Query("SELECT * FROM game ORDER BY game_id ASC")
    suspend fun getAllGames(): List<Game>

    @Query("SELECT * FROM game WHERE home_team = 'CHARGERS' ORDER BY game_id ASC")
    suspend fun getHomeGames(): List<Game>

    @Query("SELECT * FROM game WHERE home_team != 'CHARGERS' ORDER BY game_id ASC")
    suspend fun getAwayGames(): List<Game>


    @Query("SELECT seat FROM ticket WHERE game_id = :gameId")
    suspend fun getTakenSeats(gameId: String): List<String>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTicket(ticket: Ticket)

    @Query("SELECT ticket_id as ticketId, seat, price FROM ticket WHERE order_id = :orderId")
    suspend fun getTicketsFromOrder(orderId: String): List<TicketCore>

}
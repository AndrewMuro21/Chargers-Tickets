package com.example.chargerstickets.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chargerstickets.data.entities.Game
import com.example.chargerstickets.data.entities.Order
import com.example.chargerstickets.data.entities.Ticket

@Database(entities = [Game::class, Order::class, Ticket::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun chargersTicketsDao(): ChargersTicketsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }

}
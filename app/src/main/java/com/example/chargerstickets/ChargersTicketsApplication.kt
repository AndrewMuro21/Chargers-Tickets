package com.example.chargerstickets

import android.app.Application
import com.example.chargerstickets.data.AppDatabase

class ChargersTicketsApplication: Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}
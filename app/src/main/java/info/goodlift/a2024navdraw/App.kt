package info.goodlift.a2024navdraw

import android.app.Application
import info.goodlift.a2024navdraw.database.AppDataBase
import info.goodlift.a2024navdraw.repo.AppRepo

class App : Application() {

    private val appDataBase by lazy { AppDataBase.getDatabase(this) }
    val appRepo by lazy { AppRepo(appDataBase.appDao()) }
}
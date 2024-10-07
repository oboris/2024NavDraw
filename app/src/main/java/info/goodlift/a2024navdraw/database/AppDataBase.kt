package info.goodlift.a2024navdraw.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import info.goodlift.a2024navdraw.dao.AppDao
import info.goodlift.a2024navdraw.model.Author

@Database(entities = [Author::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun appDao(): AppDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    "app_db.db3"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
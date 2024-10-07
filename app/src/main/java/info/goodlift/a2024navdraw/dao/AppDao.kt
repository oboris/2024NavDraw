package info.goodlift.a2024navdraw.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import info.goodlift.a2024navdraw.model.Author


@Dao
interface AppDao {
    @Query("SELECT * FROM authors")
    fun getAllAuthors(): List<Author>

//    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
//    fun loadAllByIds(userIds: IntArray): List<User>

//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllAuthors(authors : List<Author>)

    @Insert
    fun insertAuthor(author : Author)

    @Delete
    fun delete(author : Author)

    @Delete
    fun deleteAuthors(authors : List<Author>)

    @Query("DELETE FROM authors")
    fun clearTableAuthors()
}
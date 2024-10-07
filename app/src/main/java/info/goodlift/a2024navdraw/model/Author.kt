package info.goodlift.a2024navdraw.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "authors")
data class Author(
    @ColumnInfo(name = "first_name") val firstName : String,
    @ColumnInfo(name = "last_name") val lastName : String,
    @ColumnInfo(name = "birth_date") val birthDate : String?
) : ItemTypeInterface {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    override fun getType(): Int {
        return ItemTypeInterface.AUTHOR_TYPE
    }
}

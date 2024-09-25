package info.goodlift.a2024navdraw.model

data class Book(
    val name : String,
    val author : String,
    val numPages : Int
) : ItemTypeInterface {
    override fun getType(): Int {
        return ItemTypeInterface.BOOK_TYPE
    }
}

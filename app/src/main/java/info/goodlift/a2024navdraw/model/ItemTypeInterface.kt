package info.goodlift.a2024navdraw.model

interface ItemTypeInterface {
    fun getType() : Int
    companion object{
        const val BOOK_TYPE = 1
        const val AUTHOR_TYPE = 2
        const val AUTHORS_LIST_TYPE = 3
    }
}
package info.goodlift.a2024navdraw.model

data class Author(
    val firstName : String,
    val lastName : String,
    val birthDate : String
) : ItemTypeInterface {
    override fun getType(): Int {
        return ItemTypeInterface.AUTHOR_TYPE
    }
}

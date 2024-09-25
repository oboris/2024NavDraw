package info.goodlift.a2024navdraw.model

data class AuthorsList(
    val authors: List<Author>
) : ItemTypeInterface {
    override fun getType(): Int {
        return ItemTypeInterface.AUTHORS_LIST_TYPE
    }
}

package info.goodlift.a2024navdraw.repo

import info.goodlift.a2024navdraw.dao.AppDao
import info.goodlift.a2024navdraw.model.Author

class AppRepo (
    private val appDao: AppDao
) {
  suspend fun addAllAuthors(authors : List<Author>){
      appDao.insertAllAuthors(authors)
  }

}
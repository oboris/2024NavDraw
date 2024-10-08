package info.goodlift.a2024navdraw.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import info.goodlift.a2024navdraw.App
import info.goodlift.a2024navdraw.model.Author
import info.goodlift.a2024navdraw.model.AuthorsList
import info.goodlift.a2024navdraw.model.Book
import info.goodlift.a2024navdraw.model.ItemTypeInterface
import kotlinx.coroutines.launch

class HomeViewModel(app : Application) : AndroidViewModel(app) {

    val repo  = (app as App).appRepo
    private val _num = MutableLiveData<Int>().apply {
        value = 100
    }
    val num: LiveData<Int> = _num

    private val _books = MutableLiveData<List<ItemTypeInterface>>().apply {
        val authors = listOf(
            Author("Name 1", "LastName1", "10.10.1990"),
            Author("Name 1", "LastName1", "10.10.1990"),
            Author("Name 1", "LastName1", "10.10.1990"),
            Author("Name 1", "LastName1", "10.10.1990"),
            Author("Name 1", "LastName1", "10.10.1990"),
            Author("Name 1", "LastName1", "10.10.1990"),
            Author("Name 1", "LastName1", "10.10.1990"),
            Author("Name 1", "LastName1", "10.10.1990"),
            Author("Name 1", "LastName1", "10.10.1990"),
        )

        viewModelScope.launch {
            repo.addAllAuthors(authors)
        }
//        repo.addAllAuthors(authors)

        value = listOf(
            Book("Book 1", "Author 1", 100),
            Book("Book 2", "Author 1", 300),
            Author("Name 1", "LastName1", "10.10.1990"),
            Book("Book 3", "Author 2", 200),
            Book("Book 4", "Author 2", 10),
            AuthorsList(authors),
            Author("Name 2", "LastName2", "15.10.2000"),
            Book("Book 5", "Author 1", 50),
            Author("Name 3", "LastName3", "11.10.1990"),
            Book("Book 10", "Author 3", 100),
        )
    }

    val books: LiveData<List<ItemTypeInterface>> = _books

    init {
        val authors = listOf(
            Author("Name 1", "LastName1", "10.10.1990"),
            Author("Name 1", "LastName1", "10.10.1990"),
            Author("Name 1", "LastName1", "10.10.1990"),
            Author("Name 1", "LastName1", "10.10.1990"),
            Author("Name 1", "LastName1", "10.10.1990"),
            Author("Name 1", "LastName1", "10.10.1990"),
            Author("Name 1", "LastName1", "10.10.1990"),
            Author("Name 1", "LastName1", "10.10.1990"),
            Author("Name 1", "LastName1", "10.10.1990"),
        )
//        viewModelScope.launch {
//            repo.addAllAuthors(authors)
//        }
    }

    fun changeValue(){
        _num.value = _num.value?.plus(10)
    }

    fun addBook(){
        _books.postValue(_books.value!!.plus(Book("Book 11", "Author 1", 500)))
    }
}
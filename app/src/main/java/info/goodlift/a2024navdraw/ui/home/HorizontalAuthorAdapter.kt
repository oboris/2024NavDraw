package info.goodlift.a2024navdraw.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.goodlift.a2024navdraw.databinding.ItemAuthorHorizontalBinding
import info.goodlift.a2024navdraw.model.Author

class HorizontalAuthorAdapter : RecyclerView.Adapter<HorizontalAuthorAdapter.AuthorHolder>() {

    class AuthorHolder(private val itemViewBinding: ItemAuthorHorizontalBinding) : RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bind(author: Author){
            itemViewBinding.tvFirstName.text = author.firstName
            itemViewBinding.tvLastName.text = author.lastName
            itemViewBinding.tvBirthDate.text = author.birthDate
        }
    }

    private var authors : List<Author> = emptyList()

    fun submit(newAuthors : List<Author>){
        authors = newAuthors
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorHolder {
        return AuthorHolder(
            ItemAuthorHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return authors.size
    }

    override fun onBindViewHolder(holder: AuthorHolder, position: Int) {
        holder.bind(authors[position])
    }
}

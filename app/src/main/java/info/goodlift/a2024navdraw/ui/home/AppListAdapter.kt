package info.goodlift.a2024navdraw.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import info.goodlift.a2024navdraw.databinding.ItemAuthorBinding
import info.goodlift.a2024navdraw.databinding.ItemAuthorListBinding
import info.goodlift.a2024navdraw.databinding.ItemBookBinding
import info.goodlift.a2024navdraw.model.Author
import info.goodlift.a2024navdraw.model.AuthorsList
import info.goodlift.a2024navdraw.model.Book
import info.goodlift.a2024navdraw.model.ItemTypeInterface

class AppListAdapter : RecyclerView.Adapter<AppListAdapter.AppHolder>() {


    private var itemList: List<ItemTypeInterface> = emptyList()

    override fun onBindViewHolder(holder: AppHolder, position: Int) {
        holder.bind(itemList[position])
    }

    fun submit(newList : List<ItemTypeInterface>){
        itemList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppHolder {
        return when (viewType){
            ItemTypeInterface.BOOK_TYPE -> BookHolder(
                ItemBookBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            ItemTypeInterface.AUTHOR_TYPE -> AuthorHolder(
                ItemAuthorBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> AuthorHorizontalListHolder(
                ItemAuthorListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), parent.context
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].getType()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    abstract class AppHolder(itemViewBinding: ViewBinding) : RecyclerView.ViewHolder(itemViewBinding.root){
        abstract fun bind(item : ItemTypeInterface)
    }

    class BookHolder(private val itemViewBinding: ItemBookBinding) : AppHolder(itemViewBinding) {
        override fun bind(item : ItemTypeInterface){
            item as Book
            itemViewBinding.tvBookName.text = item.name
            itemViewBinding.tvBookAuthor.text= item.author
            itemViewBinding.tvBookPages.text = item.numPages.toString()
        }
    }

    class AuthorHolder(private val itemViewBinding: ItemAuthorBinding) : AppHolder(itemViewBinding) {
        override fun bind(item : ItemTypeInterface){
            item as Author
            itemViewBinding.tvFirstName.text = item.firstName
            itemViewBinding.tvLastName.text = item.lastName
            itemViewBinding.tvBirthDate.text = item.birthDate
        }
    }

    class AuthorHorizontalListHolder(private val itemViewBinding: ItemAuthorListBinding, private val context : Context) : AppHolder(itemViewBinding) {
        override fun bind(item : ItemTypeInterface){
            item as AuthorsList
            val rv = itemViewBinding.rvHorizontalList
            rv.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
            rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rv.adapter = HorizontalAuthorAdapter()
            (rv.adapter as HorizontalAuthorAdapter).submit(item.authors)
        }
    }
}

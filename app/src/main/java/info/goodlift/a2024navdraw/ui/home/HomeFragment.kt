package info.goodlift.a2024navdraw.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import info.goodlift.a2024navdraw.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var homeViewModel : HomeViewModel;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.num.observe(viewLifecycleOwner) { value ->
            textView.text = value.toString()
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnChangeValue.setOnClickListener {
            homeViewModel.addBook()
        }

        val rvAppList = binding.rvAppList
        rvAppList.adapter = AppListAdapter()
        rvAppList.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        rvAppList.layoutManager = LinearLayoutManager(this.context)
        homeViewModel.books.observe(viewLifecycleOwner){
            (rvAppList.adapter as AppListAdapter).submit(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
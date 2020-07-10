package com.aliceresponde.mercadoco.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.aliceresponde.mercadoco.R
import com.aliceresponde.mercadoco.databinding.FragmentSearchItemsBinding
import com.aliceresponde.mercadoco.ui.hideKeyboard
import com.aliceresponde.mercadoco.ui.model.UiItem
import com.aliceresponde.mercadoco.ui.toast
import com.mancj.materialsearchbar.MaterialSearchBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchItemsFragment : Fragment(), MaterialSearchBar.OnSearchActionListener {
    lateinit var binding: FragmentSearchItemsBinding
    private val viewModel: SearchViewModel by viewModels()
    private val adapter: ItemsAdapter by lazy { ItemsAdapter { goToDetail(it) } }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_search_items, container, false)

        binding.apply {
            lifecycleOwner = this@SearchItemsFragment
            viewModel = this@SearchItemsFragment.viewModel
            itemsRecycler.adapter = adapter
            searchBar.setOnSearchActionListener(this@SearchItemsFragment)
        }

        viewModel.items.observe(viewLifecycleOwner, Observer {
            adapter.updateData(it)
        })

        viewModel.isInputEmpty.observe(viewLifecycleOwner, Observer {
            if (it) {
                binding.searchBar.searchEditText.error = getString(R.string.empty_data)
            }
        })

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        toast(getString(R.string.search_message))
    }


    private fun goToDetail(item: UiItem) {
        val action = SearchItemsFragmentDirections.actionSearchItemsFragmentToDetailFragment(item)
        findNavController().navigate(action)
    }

    override fun onButtonClicked(buttonCode: Int) {}

    override fun onSearchStateChanged(enabled: Boolean) {}

    override fun onSearchConfirmed(text: CharSequence?) {
        binding.searchBar.text = ""
        binding.searchBar.searchEditText.error = null
        hideKeyboard()

        viewModel.searchItems(text.toString())
    }
}
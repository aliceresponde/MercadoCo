package com.aliceresponde.mercadoco.ui.detail

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.aliceresponde.mercadoco.R
import com.aliceresponde.mercadoco.databinding.FragmentItemDetailBinding
import com.aliceresponde.mercadoco.ui.model.UiItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    lateinit var binding: FragmentItemDetailBinding
    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()
    private val item: UiItem by lazy { args.item }
    private val images: MutableList<String> by lazy { mutableListOf(item.thumbnail) }
    private val adapter: ImageViewPagerAdapter by lazy { ImageViewPagerAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_item_detail, container, false)
        binding.apply {
            lifecycleOwner = this@DetailFragment
            viewModel = this@DetailFragment.viewModel
            detailImagesPager.adapter = adapter
            detailPagerIndicator.setViewPager(detailImagesPager)
            adapter.registerAdapterDataObserver(detailPagerIndicator.adapterDataObserver)
            detailDescriptionBody.movementMethod = ScrollingMovementMethod.getInstance()


        }

        viewModel.setItem(item)
        viewModel.images.observe(viewLifecycleOwner, Observer {
            images.addAll(it)
            adapter.updateData(images)
            binding.detailPagerIndicator.createIndicators(adapter.list.size, 0)

        })

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getItemDescription(item.id)
        viewModel.getItemImages(item.id)
    }
}
package com.aliceresponde.mercadoco.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.aliceresponde.mercadoco.R
import com.aliceresponde.mercadoco.databinding.ItemRowBinding
import com.aliceresponde.mercadoco.ui.model.UiItem

class ItemsAdapter(var data: List<UiItem> = listOf(), val callback: (UiItem) -> Unit) :
    RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_row, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    fun updateData(newItemList: List<UiItem>) {
        val oldList = data
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(
            ShowItemDiffCallback(oldList, newItemList)
        )
        data = newItemList
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemRowBinding.bind(view)
        fun onBind(uiItem: UiItem) {
            binding.apply {
                itemTitle.text = uiItem.title
                itemPrice.text = uiItem.price
                itemThumbnail.load(uiItem.thumbnail) {
                    crossfade(true)
                    error(R.drawable.ic_sale_bag)
                    placeholder(R.drawable.ic_sale_bag)
                }
                cardContainer.setOnClickListener { callback.invoke(uiItem) }
            }
        }
    }

    class ShowItemDiffCallback(
        private var oldItemList: List<UiItem>,
        private var newItemList: List<UiItem>
    ) : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldItemList[oldItemPosition].id == newItemList[newItemPosition].id

        override fun getOldListSize(): Int = oldItemList.size

        override fun getNewListSize(): Int = newItemList.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldItemList[oldItemPosition] == newItemList[newItemPosition]
    }
}

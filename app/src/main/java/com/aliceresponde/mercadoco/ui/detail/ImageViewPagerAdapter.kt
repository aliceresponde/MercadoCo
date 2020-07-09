package com.aliceresponde.mercadoco.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.aliceresponde.mercadoco.R
import com.aliceresponde.mercadoco.databinding.ImageItemBinding

class ImageViewPagerAdapter(val list: MutableList<String> = mutableListOf()) :
    RecyclerView.Adapter<ImageViewPagerAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(view)
    }

    fun updateData( newData: List<String>){
        list.clear()
        list.addAll(newData)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ImageItemBinding.bind(view)

        fun onBind(url: String) {
            binding.image.load(url) {
                crossfade(true)
                error(R.drawable.ic_un_plug)
                placeholder(R.drawable.ic_sale_bag)
            }
        }
    }
}

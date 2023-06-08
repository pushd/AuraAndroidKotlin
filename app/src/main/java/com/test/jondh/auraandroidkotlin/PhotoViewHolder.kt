package com.test.jondh.auraandroidkotlin

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.jondh.auraandroidkotlin.databinding.ViewPhotoBinding
import com.test.jondh.auraandroidkotlin.network.PicsumInfo

class PhotoViewHolder(private val binding: ViewPhotoBinding) : RecyclerView.ViewHolder(binding.root) {

    var photo: PicsumInfo? = null
        set(value) {
            field = value
            Glide.with(binding.root.context)
                .load(photo?.getDownloadUrl())
                .into(binding.imageView)
            binding.authorLabel.text = photo?.getAuthor()

        }
}

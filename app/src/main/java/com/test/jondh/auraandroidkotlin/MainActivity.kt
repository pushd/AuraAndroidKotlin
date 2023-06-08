package com.test.jondh.auraandroidkotlin

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.jondh.auraandroidkotlin.databinding.ActivityMainBinding
import com.test.jondh.auraandroidkotlin.databinding.ViewPhotoBinding
import com.test.jondh.auraandroidkotlin.network.APIHelper

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = MainViewModel(APIHelper.getInstance(this), ViewModelListener())

        binding.list.setItemViewCacheSize(100)
        binding.list.adapter = PhotoAdapter()
        binding.list.layoutManager = GridLayoutManager(this, 2)
        binding.list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val gridLayoutManager = (binding.list.layoutManager as? GridLayoutManager) ?: return
                if (gridLayoutManager.findLastVisibleItemPosition() == viewModel.photos.lastIndex) {
                    viewModel.fetchPhotos()
                }
            }
        })

        viewModel.fetchPhotos()
    }

    private inner class PhotoAdapter: RecyclerView.Adapter<PhotoViewHolder>() {

        override fun getItemCount(): Int {
            return viewModel.photos.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
            val binding = ViewPhotoBinding.inflate(layoutInflater, parent, false)
            return PhotoViewHolder(binding)
        }

        override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
            holder.photo = viewModel.photos[position]
        }
    }

    private inner class ViewModelListener: MainViewModel.Listener {

        override fun photosReceived() {
            binding.list.adapter?.notifyDataSetChanged()
        }
    }
}

package github.daniedev.pictalens.ui.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import coil.load
import github.daniedev.imgur.model.gallery.Data
import github.daniedev.pictalens.databinding.ItemGalleryFeedBinding


class GalleryFeedAdapter : ListAdapter<Data, GalleryFeedViewHolder >(GalleryFeedDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryFeedViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ItemGalleryFeedBinding.inflate(inflater, parent, false)
        return GalleryFeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryFeedViewHolder, position: Int) {
        val data = getItem(position)
        holder.binding.feedCaption.text = data.title
        holder.binding.feedImage.load("https://i.imgur.com/${data.cover}.jpg")
    }
}
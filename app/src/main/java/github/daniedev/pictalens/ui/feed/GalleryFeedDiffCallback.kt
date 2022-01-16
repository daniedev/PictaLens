package github.daniedev.pictalens.ui.feed

import androidx.recyclerview.widget.DiffUtil
import github.daniedev.imgur.model.gallery.Data

class GalleryFeedDiffCallback: DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.toString() == newItem.toString()
    }

}
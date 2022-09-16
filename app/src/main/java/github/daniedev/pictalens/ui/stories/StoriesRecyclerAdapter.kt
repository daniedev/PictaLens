package github.daniedev.pictalens.ui.stories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import coil.load
import coil.size.Scale
import github.daniedev.imgur.model.common.Tag
import github.daniedev.pictalens.R
import github.daniedev.pictalens.databinding.ItemStoryHeadBinding

class StoriesRecyclerAdapter :
    ListAdapter<Tag, StoriesViewHolder>(StoriesDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ItemStoryHeadBinding.inflate(inflater, parent, false)
        return StoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        val tag = getItem(position)
        holder.binding.storyHeadTextView.text = tag.displayName
        holder.binding.storyHeadImageView.load("https://i.imgur.com/${tag.backgroundHash}.jpg")
    }
}
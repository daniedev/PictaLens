package github.daniedev.pictalens.ui.stories

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import coil.load
import github.daniedev.imgur.model.common.Tag
import github.daniedev.pictalens.databinding.ItemStoryHeadBinding
import github.daniedev.pictalens.ui.storydetail.StoryDetailActivity

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
        holder.binding.root.apply {
            setOnClickListener {
                context.startActivity(
                    Intent(context, StoryDetailActivity::class.java).apply {
                        putExtra("tag", tag.name)
                    }
                )
            }
        }
    }
}
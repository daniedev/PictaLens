package github.daniedev.pictalens.ui.storydetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import coil.load
import github.daniedev.imgur.model.common.Image
import github.daniedev.pictalens.databinding.ItemStoryDetailBinding

class StoryDetailPagerAdapter :
    ListAdapter<Image, StoryDetailPageViewHolder>(StoryDetailDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryDetailPageViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ItemStoryDetailBinding.inflate(inflater, parent, false)
        return StoryDetailPageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryDetailPageViewHolder, position: Int) {
        val image = getItem(position)
        val imageUrl = if (image?.isAlbum == true && image.imagesCount!! > 0)
                           image.images!![0].link
                        else image.link
        imageUrl?.let {
            holder.binding.storyImage.load(it)
        }
    }
}

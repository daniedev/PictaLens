package github.daniedev.pictalens.ui.storydetail

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import github.daniedev.imgur.model.common.Image

class StoryDetailDiffCallback : DiffUtil.ItemCallback<Image>() {
    override fun areItemsTheSame(oldItem: Image, newItem: Image) =
        oldItem == newItem

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Image, newItem: Image) =
        oldItem === newItem
}
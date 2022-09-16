package github.daniedev.pictalens.ui.stories

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import github.daniedev.imgur.model.common.Tag
import github.daniedev.imgur.model.gallerytags.Gallery

class StoriesDiffCallback: DiffUtil.ItemCallback<Tag>() {
    override fun areItemsTheSame(oldItem: Tag, newItem: Tag) = oldItem == newItem

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Tag, newItem: Tag) = oldItem.toString() == newItem.toString()
}
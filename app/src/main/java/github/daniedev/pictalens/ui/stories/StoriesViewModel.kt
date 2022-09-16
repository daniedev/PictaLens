package github.daniedev.pictalens.ui.stories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import github.daniedev.imgur.model.common.Tag
import github.daniedev.imgur.model.gallerytags.Gallery
import github.daniedev.pictalens.repository.ImgurRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoriesViewModel : ViewModel() {

    private val repo = ImgurRepository()
    private val _tags = MutableLiveData<List<Tag>>()

    val tags: LiveData<List<Tag>> = _tags

    fun fetchTags() = viewModelScope.launch(Dispatchers.IO) {
        _tags.postValue(repo.getTags())
    }

}
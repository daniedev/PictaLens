package github.daniedev.pictalens.ui.storydetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import github.daniedev.imgur.model.common.Image
import github.daniedev.pictalens.repository.ImgurRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoryDetailViewModel : ViewModel() {
    private val imgurRepository = ImgurRepository()
    private val _storyDetailImages = MutableLiveData<List<Image>>()
    val storyDetailImages : LiveData<List<Image>> = _storyDetailImages

    fun getGalleryBasedOnTag(tagName: String) = viewModelScope.launch(Dispatchers.IO) {
        _storyDetailImages.postValue(imgurRepository.getGalleryBasedOnTag(tagName))
    }
}
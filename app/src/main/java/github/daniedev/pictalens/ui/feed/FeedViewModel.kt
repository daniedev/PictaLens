package github.daniedev.pictalens.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import github.daniedev.imgur.model.gallery.Data
import github.daniedev.pictalens.repository.ImgurRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    private val imgurRepository = ImgurRepository()
    private val _galleryFeed = MutableLiveData<List<Data>>()
    val galleryFeed : LiveData<List<Data>> = _galleryFeed

    fun updateFeed(sectionName: String) = viewModelScope.launch(Dispatchers.IO) {
        when(sectionName) {
            "hot" -> _galleryFeed.postValue(imgurRepository.getHotFeed())
            "top" -> _galleryFeed.postValue(imgurRepository.getTopFeed())
            else -> Log.e("updateFeed", "feed has to be top or hot")
        }
    }
}
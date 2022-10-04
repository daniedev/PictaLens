package github.daniedev.pictalens.ui.storydetail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import github.daniedev.pictalens.databinding.ActivityStoryDetailBinding

class StoryDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStoryDetailBinding
    private val storyDetailViewModel by viewModels<StoryDetailViewModel>()
    private val storyDetailPagerAdapter = StoryDetailPagerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.storyViewPager.adapter = storyDetailPagerAdapter
        val tagName = intent.getStringExtra("tag")
        tagName?.let { storyDetailViewModel.getGalleryBasedOnTag(it) }
    }

    override fun onResume() {
        super.onResume()
        storyDetailViewModel.storyDetailImages.observe(this) {
            storyDetailPagerAdapter.submitList(it)
        }
    }
}
package github.daniedev.pictalens.ui.storydetail

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.ViewPropertyAnimator
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import github.daniedev.pictalens.databinding.ActivityStoryDetailBinding

class StoryDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStoryDetailBinding
    private val storyDetailViewModel by viewModels<StoryDetailViewModel>()
    private val storyDetailPagerAdapter = StoryDetailPagerAdapter()
    private lateinit var progressBarAnimator : ViewPropertyAnimator
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.storyViewPager.adapter = storyDetailPagerAdapter
        val tagName = intent.getStringExtra("tag")
        tagName?.let { storyDetailViewModel.getGalleryBasedOnTag(it) }
        binding.storyViewPager.registerOnPageChangeCallback(pageChangeCallback)
        progressBarAnimator = binding.progressBar.animate()
    }

    private val nextPageRunnable = Runnable {
        binding.storyViewPager.currentItem++
    }

    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            progressBarAnimator.cancel()
            binding.progressBar.scaleX = 0f
            progressBarAnimator.scaleX(1f).setDuration(5000).setStartDelay(10).start()

            handler.removeCallbacks(nextPageRunnable)
            handler.postDelayed(nextPageRunnable, 5000)
        }
    }

    override fun onResume() {
        super.onResume()
        storyDetailViewModel.storyDetailImages.observe(this) {
            storyDetailPagerAdapter.submitList(it)
        }
    }
}
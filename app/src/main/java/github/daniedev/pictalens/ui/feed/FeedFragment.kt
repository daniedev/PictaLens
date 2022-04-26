package github.daniedev.pictalens.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import github.daniedev.pictalens.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    private val viewModel: FeedViewModel by viewModels()
    private val galleryFeedAdapter = GalleryFeedAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val feed = arguments?.getString("feed")
        feed?.let { viewModel.updateFeed(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentFeedBinding.inflate(inflater, container, false)
        binding.galleryFeedContainer.layoutManager = LinearLayoutManager(requireContext())
        binding.galleryFeedContainer.adapter = galleryFeedAdapter

        viewModel.galleryFeed.observe({lifecycle}) {
            galleryFeedAdapter.submitList(it)
        }

        return binding.root
    }
}
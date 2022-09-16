package github.daniedev.pictalens

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import github.daniedev.pictalens.databinding.ActivityMainBinding
import github.daniedev.pictalens.ui.stories.StoriesRecyclerAdapter
import github.daniedev.pictalens.ui.stories.StoriesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val storiesViewModel by viewModels<StoriesViewModel>()
    private val storiesRecyclerAdapter = StoriesRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.storiesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = storiesRecyclerAdapter
        }

        setupNav()
    }

    private fun setupNav() {
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        /*
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_hot, R.id.navigation_top))
        setupActionBarWithNavController(navController, appBarConfiguration)
        */
        navView.setupWithNavController(navController)
    }

    override fun onResume() {
        super.onResume()
        storiesViewModel.fetchTags()
        storiesViewModel.tags.observe(this) {
            storiesRecyclerAdapter.submitList(it)
        }
    }
}
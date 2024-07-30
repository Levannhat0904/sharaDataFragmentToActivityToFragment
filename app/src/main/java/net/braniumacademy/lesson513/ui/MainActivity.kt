package net.braniumacademy.lesson513.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import net.braniumacademy.lesson513.R
import net.braniumacademy.lesson513.ui.fragment.CountryDetailFragment
import net.braniumacademy.lesson513.ui.viewmodel.SharedCountryItemViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
    }

    private fun setupViewModel() {
        val viewModel =
            ViewModelProvider(this)[SharedCountryItemViewModel::class.java]
        viewModel.selectedCountry.observe(this) {
            showDetailCountry()
        }
    }

    private fun showDetailCountry() {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,  // popEnter
                R.anim.slide_out // popExit
            )
            .replace(
                R.id.fragment_container_view,
                CountryDetailFragment::class.java,
                null
            ).addToBackStack("CountryDetailFragment")
            .commit()
    }
}
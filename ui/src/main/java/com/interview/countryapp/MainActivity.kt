package com.interview.countryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts.Intents.UI
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.interview.countryapp.databinding.ActivityMainBinding
import com.interview.countryapp.domain.model.CountryItems
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private val countryAdapter = CountryAdapter()

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            countriesList.adapter = countryAdapter
            countriesList.layoutManager =
                LinearLayoutManager(this@MainActivity)
            lifecycleScope.launch {
                viewModel.countryList.collect {
                    when (it) {
                        is UIState.Loading -> progressbar.isVisible = it.isLoading
                        is UIState.Success -> countryAdapter.loadCountryList(it.response as CountryItems)
                        is UIState.Error -> Snackbar.make(binding.root, it.error, Snackbar.LENGTH_LONG).show()
                    }
                }
            }
            viewModel.getCountries()
        }
    }
}
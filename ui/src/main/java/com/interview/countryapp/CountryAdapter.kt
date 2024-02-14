package com.interview.countryapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.interview.countryapp.databinding.CountryListItemBinding
import com.interview.countryapp.domain.model.CountryItem

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private val countryList: MutableList<CountryItem> = mutableListOf()

    fun loadCountryList(list: List<CountryItem>) {
        countryList.clear()
        countryList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            CountryListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countryList[position])
    }

    override fun getItemCount(): Int = countryList.size

    inner class CountryViewHolder(private val binding: CountryListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CountryItem) {
            binding.apply {
                countryName.text = item.name
                countryCode.text = item.code
                countryCapital.text = item.capital
            }
        }
    }
}
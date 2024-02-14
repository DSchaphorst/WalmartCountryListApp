# WalmartCountryListApp
 
**Objective:** Display all the countries in a RecyclerView ordered by the position they appear in the JSON. In each table cell, show the country's "name", "region", "code" and "capital"

**Solution:** This project was attempted to be kept as minimal as possible. Using MVVM and Clean Architecture, the major tools implemented are as follows: Retrofit, OKHTTP, and Coroutines. 

I focused on trying to keep the architecture in a way that is as concise, but reusable as possible. Created a simple UI for displaying the JSON data in the format that was requested, and connected the data and networking to the domain and model. 
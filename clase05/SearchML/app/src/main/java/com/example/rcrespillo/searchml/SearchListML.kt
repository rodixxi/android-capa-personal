package com.example.rcrespillo.searchml

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.rcrespillo.searchml.Adapter.SearchItemAdapter
import com.example.rcrespillo.searchml.Model.Search
import com.example.rcrespillo.searchml.Retrofit.MLService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_search_list_ml.*

class SearchListML : AppCompatActivity() {

    private val searchMLService by lazy {
        MLService.create()
    }

    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_list_ml)

        val string: String? = intent.extras!!.getString("searchText")

        items_list_recycler_view.setHasFixedSize(true)
        items_list_recycler_view.layoutManager = LinearLayoutManager(this)
        searchItems(string)

    }
    private fun searchItems(itemString: String?){
        disposable = searchMLService.searchML(itemString)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {search-> displayData(search)},
                {error -> Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()})
    }

    private fun displayData(search: Search?) {
        val adapter = SearchItemAdapter(this, search!!.results!!)
        items_list_recycler_view.adapter = adapter
    }
}

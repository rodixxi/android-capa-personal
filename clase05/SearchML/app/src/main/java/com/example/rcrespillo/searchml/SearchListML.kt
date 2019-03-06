package com.example.rcrespillo.searchml

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SearchListML : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val searchMLService by lazy {
        MLService.create()
    }

    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_list_ml)

        val bundle: Bundle? = intent.extras
        val string: String? = intent.extras!!.getString("searchText")

        val service =

        Toast.makeText(this, "asdadasd", Toast.LENGTH_SHORT).show()

        //viewManager = LinearLayoutManager(this)
        //viewAdapter = MyAdapter(myDataset)

        //recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
          //  setHasFixedSize(true)

            // use a linear layout manager
            //layoutManager = viewManager

            // specify an viewAdapter (see also next example)
       //     adapter = viewAdapter

        //}


    }
    private fun searchItems(itemString: String){
        disposable = searchMLService.searchML(itemString)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {result -> showResult()})
    }
}

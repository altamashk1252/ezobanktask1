package website.orgo.task1

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Dashboard : Fragment() {
    private var recyclerView: RecyclerView?=null

    private var spinner:ProgressBar?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val rootview = inflater.inflate(R.layout.toolbar, container, false)
        spinner = rootview.findViewById(R.id.progressBar1);
        getUserList()
        setUpToolbar(rootview)
        recyclerView = rootview!!.findViewById(R.id.recycler_view)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)


        return rootview
    }

    private fun setUpToolbar(view: View) {
        val toolbar = view.findViewById<Toolbar>(R.id.app_bar)
        val activity = activity as AppCompatActivity?
        activity?.setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menutoolbar, menu)
    }
    fun getUserList() {
        spinner!!.setVisibility(View.VISIBLE);

//        spinner!!.isVisible=true
        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(APIInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val response = apiInterface.getdata()
                if (response.isSuccessful()) {
                    Log.i("asdf", "getUserList: itesm size =${response.body()!!.items!!.size}")
                    if(response.body()!!.status.equals("success")){

                        val adapter = ProductCardRecyclerViewAdapter(
                            response.body()!!.items,requireContext())
                        recyclerView!!.adapter = adapter
                        val largePadding = resources.getDimensionPixelSize(R.dimen.gridspace)
                        val smallPadding = resources.getDimensionPixelSize(R.dimen.gridspacesmall)
                        recyclerView!!.addItemDecoration(ProductGridItemDecoration(largePadding, smallPadding))

                        spinner!!.setVisibility(View.GONE);
                    }
                } else {
                    Toast.makeText(
                        requireActivity(),
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()


                    spinner!!.setVisibility(View.GONE);}
            }catch (Ex:Exception){
                Log.e("Error",Ex.localizedMessage)


                spinner!!.setVisibility(View.GONE);}
        }

}}
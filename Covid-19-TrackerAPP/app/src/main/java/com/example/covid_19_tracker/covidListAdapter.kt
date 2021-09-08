package com.example.covid_19_tracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CovidListAdapter (private val dataSet: ArrayList<Model>) :
    RecyclerView.Adapter<CovidListAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val stateCode : TextView = view.findViewById(R.id.text_State)
        val totalConfirmed : TextView = view.findViewById(R.id.total_confirmed)
        val totalActive : TextView = view.findViewById(R.id.total_recovered)
        val totalVaccinated : TextView = view.findViewById(R.id.total_vaccinated)
        val deltaConfirmed : TextView = view.findViewById(R.id.confirmed_delta)
        val deltaActive : TextView = view.findViewById(R.id.recovered_delta)
        val deltaVaccinated : TextView = view.findViewById(R.id.vaccinated_delta)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_items, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.stateCode.text=dataSet[position].stateCode
        viewHolder.deltaActive.text = dataSet[position].deltaRecovered
        viewHolder.deltaConfirmed.text = dataSet[position].deltaConfirmed
        viewHolder.deltaVaccinated.text = dataSet[position].deltaVaccinated
        viewHolder.totalActive.text = dataSet[position].totalRecovered
        viewHolder.totalConfirmed.text = dataSet[position].totalConfirmed
        viewHolder.totalVaccinated.text = dataSet[position].totalVaccinated
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
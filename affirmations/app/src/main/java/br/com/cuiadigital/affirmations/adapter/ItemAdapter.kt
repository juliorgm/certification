package br.com.cuiadigital.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.cuiadigital.affirmations.R
import br.com.cuiadigital.affirmations.model.Affirmation

class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
    ): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view =  LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
    }

    override fun getItemCount(): Int = dataset.size

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val textView = view.findViewById<TextView>(R.id.item_title)
    }
}
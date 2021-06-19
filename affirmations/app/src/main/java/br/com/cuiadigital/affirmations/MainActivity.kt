package br.com.cuiadigital.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.cuiadigital.affirmations.adapter.ItemAdapter
import br.com.cuiadigital.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datasource = Datasource().loadAffirmations()
        val recyclerView =  findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, datasource)
        recyclerView.setHasFixedSize(true)
    }
}
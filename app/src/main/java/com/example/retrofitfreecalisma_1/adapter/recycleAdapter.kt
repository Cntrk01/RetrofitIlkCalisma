package com.example.retrofitfreecalisma_1.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitfreecalisma_1.R
import com.example.retrofitfreecalisma_1.model.DataClass
import kotlinx.android.synthetic.main.recycler_row.view.*

class recycleAdapter(val dataList:ArrayList<DataClass>) : RecyclerView.Adapter<recycleAdapter.veriListesi>(){
    class veriListesi(view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): veriListesi {
        val inflate=LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return veriListesi(inflate)
    }

    override fun onBindViewHolder(holder: veriListesi, position: Int) {
        holder.itemView.idDeger.text= dataList.get(position).id.toString()
        holder.itemView.title.text= dataList.get(position).title
        holder.itemView.body.text= dataList.get(position).body
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun dataUpdate(newData:List<DataClass>){
        dataList.clear()
        dataList.addAll(newData)
        notifyDataSetChanged()
    }
}
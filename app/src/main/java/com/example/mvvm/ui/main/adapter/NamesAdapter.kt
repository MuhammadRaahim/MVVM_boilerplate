package com.example.mvvm.ui.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.data.model.Blog
import com.example.mvvm.databinding.NameItemBinding
import com.example.mvvm.ui.main.callbacks.OnItemDeleteListener
import com.example.mvvm.ui.main.viewmodel.MainViewModel

class NamesAdapter(
    private var nameList: ArrayList<Blog>,
    private var onItemDelete: OnItemDeleteListener
): RecyclerView.Adapter<NamesAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = NameItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(nameList[position])
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: ArrayList<Blog>){
        nameList = list
        notifyDataSetChanged()
    }

    inner class Holder(
        private val binding: NameItemBinding
    ):RecyclerView.ViewHolder(binding.root){

        fun bind(blog: Blog) {
            binding.tvName.text = blog.title

            binding.ivDelete.setOnClickListener{
                onItemDelete.onItemDelete(blog)
            }
        }

    }
}
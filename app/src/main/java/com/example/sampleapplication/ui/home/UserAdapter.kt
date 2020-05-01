package com.example.sampleapplication.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapplication.R
import com.example.sampleapplication.data.model.user.Data
import com.example.sampleapplication.databinding.ItemListViewBinding
import com.squareup.picasso.Picasso

class UserAdapter(private val onClickListener: ItemClickedListener): ListAdapter<Data, UserAdapter.ViewHolder>(DiffUtilCallback()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemListViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_list_view, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position), onClickListener)


    inner class ViewHolder(val binding: ItemListViewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(user: Data, listener: ItemClickedListener){
             binding.user = user
             binding.displayName.text = "$user.firstName $user.lastName"
             binding.email.text = "$user.email"
             Picasso.get().load(user.avatar).into(binding.userAvatar)
             binding.clickListener = listener
        }
    }
}

class DiffUtilCallback: DiffUtil.ItemCallback<Data>(){

    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        if (oldItem == newItem) {
            return true
        }
        return false
    }
}

class ItemClickedListener(val clickListener: (item: Data?) -> Unit) {
    fun onClick(item: Data) = clickListener(item)
}
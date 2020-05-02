package com.example.sampleapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sampleapplication.R
import com.example.sampleapplication.data.model.user.Data
import com.example.sampleapplication.databinding.FragmentUserListBinding


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this, HomeViewModelFactory()).get(HomeViewModel::class.java)
        val binding =  DataBindingUtil.inflate<FragmentUserListBinding>(inflater, R.layout.fragment_user_list, container, false)
        val root = binding.root
        binding.viewModel = homeViewModel
        val adapter = UserAdapter(ItemClickedListener { item-> handleItemClick(item) })
        binding.listView.adapter = adapter

        homeViewModel.users.observe(viewLifecycleOwner, Observer { users ->
            adapter.submitList(users)
        })


        // This callback will only be called when MyFragment is at least Started.
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Handle the back button event
        }





        return root
    }

    private fun handleItemClick(item: Data?) {
        Toast.makeText(activity?.applicationContext, "I am clicked", Toast.LENGTH_SHORT).show()
    }
}

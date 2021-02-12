package com.example.dogbreeds

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogbreeds.databinding.FragmentFirstBinding
import com.example.dogbreeds.model.viewModel.BreedsViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var mBinding : FragmentFirstBinding
    private val viewModel : BreedsViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFirstBinding.inflate(inflater, container, false)
        return  mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val  adapter = BreedsAdapter()

        mBinding.rvBreeds.adapter = adapter

        mBinding.rvBreeds.layoutManager = LinearLayoutManager(context)
        viewModel.allBreeds.observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.d("debug", "$it")
                adapter.update(it)
            }
        })


        /*view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/
    }
}
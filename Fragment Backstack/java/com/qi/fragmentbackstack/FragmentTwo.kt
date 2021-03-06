package com.qi.fragmentbackstack

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_backstack_two.*

class FragmentTwo : Fragment() {

    var listner : FragmentTwocallback ?= null
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_backstack_two,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_back_stack_two_button?.setOnClickListener {
            listner?.fragmentTwoButtonClick()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is FragmentTwocallback){
            listner = context
        }
    }
}

interface FragmentTwocallback {
    fun fragmentTwoButtonClick()
}

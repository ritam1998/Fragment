package com.qi.fragmentbackstack

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_backstack_one.*

class FragmentOne : Fragment(){

    var listner : OnClickButton ?= null

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_backstack_one,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_back_stack_one_button?.setOnClickListener {
            listner?.onClickButtonFragmentOneListner()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if(context is OnClickButton){
            listner = context
        }
    }

}

interface OnClickButton {
    fun onClickButtonFragmentOneListner()
}

package com.qi.fragmentapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_mainfragment.*

class MainFragment : Fragment(){

    private var  listner : WriteMessageCallbackMainFragment ?= null

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_mainfragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        writeMessageButton?.setOnClickListener {
            listner?.onClickWriteMessage()
        }

        getMessageButton?.setOnClickListener {
            //listner?.onClickGetMessage()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is WriteMessageCallbackMainFragment){
            listner = context
        }
    }
}

interface WriteMessageCallbackMainFragment {

    fun onClickWriteMessage()
    //fun onClickGetMessage()
}


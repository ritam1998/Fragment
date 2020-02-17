package com.qi.viewpager

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {

    private var fragmentAListner : FragmentAListener ?= null

    private var editText : EditText?= null
    private var saveButton : Button?= null

    interface FragmentAListener {
        fun onInputASent(input : String?)
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_a,container,false)

        editText = view.findViewById(R.id.edit_text)
        saveButton = view.findViewById(R.id.button_ok)

        saveButton?.setOnClickListener {

            val input = editText?.text?.toString()
            fragmentAListner?.onInputASent(input = input)
        }

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is FragmentAListener){
            fragmentAListner = context
        }
    }

    fun updateEditText(value : String?){
        editText?.setText(value)
    }

    override fun onDetach() {
        super.onDetach()
        fragmentAListner = null
    }
}
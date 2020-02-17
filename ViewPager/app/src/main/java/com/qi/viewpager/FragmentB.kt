package com.qi.viewpager

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class FragmentB : Fragment() {

    private var fragmentBListener : FragmentBListener? = null

    private var getMessage : EditText? = null
    private var saveButton : Button? = null

    interface FragmentBListener {
        fun onInputBSent(input : String?)
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_b,container,false)
        getMessage = view.findViewById(R.id.edit_text)

        saveButton = view.findViewById(R.id.button_ok)
        saveButton?.setOnClickListener {
            val input = getMessage?.text?.toString()
            fragmentBListener?.onInputBSent(input = input)
        }

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is FragmentBListener){
            fragmentBListener = context
        }
    }

    fun updateEditText(value : String?){
        getMessage?.setText(value)
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBListener = null
    }
}
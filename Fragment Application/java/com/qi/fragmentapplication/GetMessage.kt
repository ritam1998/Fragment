package com.qi.fragmentapplication

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_activity_getmessage.*

class GetMessage : Fragment() {

    private var getMessageText : TextView?= null

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_activity_getmessage,container,false)

        getMessageText = view.findViewById(R.id.getMessageText)

        val bundle = arguments
        val getTextMessage = bundle?.getString("userMessage")

        getMessageText?.text = "hello"

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

    }

    fun showText(value : String?){

        Log.d("name == ","$value")
    }
}



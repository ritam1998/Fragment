package com.qi.fragmentapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class WriteMessage : Fragment() {

    private var textMessage : EditText ?= null
    private var saveButton : Button?= null

    private var fragmentAListener : WriteMessageInterfaceSent? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_activity_writemessage,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textMessage = view.findViewById(R.id.textmessage)

        saveButton = view.findViewById(R.id.savebutton)

        saveButton?.setOnClickListener {

            (activity as? WriteMessageInterfaceSent)?.onInputASent(textMessage?.text?.toString()?:"")
            fragmentAListener?.onClickGetMessage()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if(context is WriteMessageInterfaceSent){
            fragmentAListener = context
        }
    }
}
interface WriteMessageInterfaceSent {
    fun onInputASent(input: String?)
    fun onClickGetMessage()
}
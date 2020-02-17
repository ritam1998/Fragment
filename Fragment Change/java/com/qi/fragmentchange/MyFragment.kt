package com.qi.fragmentchange

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_my.*
import javax.security.auth.callback.Callback

class MyFragment : Fragment(){

    var userNameTextToString : TextView? = null
    var userEmailTextToString : TextView? = null

    var findNameText : String? = null
    var findUserMail : String ?= null

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {

        val myFragmentLayoutShow = inflater.inflate(R.layout.fragment_my,container,false)

        val bundle = arguments

        findNameText = bundle?.getString("username")
        findUserMail = bundle?.getString("userEmail")

        userNameTextToString = myFragmentLayoutShow.findViewById(R.id.usernametextview)
        userEmailTextToString = myFragmentLayoutShow.findViewById(R.id.usermailtextview)

        userNameTextToString?.text = findNameText
        userEmailTextToString?.text = findUserMail

        return myFragmentLayoutShow
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun changeData(username:String,useremail : String){
        userNameTextToString?.text = username
        userEmailTextToString?.text = useremail
    }
}
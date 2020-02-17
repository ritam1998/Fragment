package com.qi.fragmentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(),WriteMessageCallbackMainFragment,WriteMessageInterfaceSent {

    private val fragmentManager = supportFragmentManager
    private val mainFragment = MainFragment()
    private val getMessage = GetMessage()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadManagerAddFirstFragment(mainFragment)
    }
    private fun loadManagerAddFirstFragment(fragment : Fragment){

        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.framelayout,fragment)
        fragmentTransaction.commit()
    }

    override fun onClickWriteMessage() {

        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,WriteMessage())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onClickGetMessage() {

        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,getMessage)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onInputASent(input: String?) {

        Toast.makeText(this,"$input",Toast.LENGTH_LONG).show()
//        val getMessage = fragmentManager.findFragmentById(R.id.framelayout)
//        if (getMessage is GetMessage) {
//            getMessage.showText(input)
//        }
    }
}

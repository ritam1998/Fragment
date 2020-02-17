package com.qi.fragmentbackstack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(),OnClickButton,FragmentTwocallback {

    var fragmentOne = FragmentOne()

    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadManagerAddFirstFragment(fragmentOne)
    }
    private fun loadManagerAddFirstFragment(fragment : Fragment){

        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.framelayout,fragment)

        fragmentTransaction.commit()
    }
    override fun onClickButtonFragmentOneListner() {

        val fragmentOneTransaction = fragmentManager.beginTransaction()

        fragmentOneTransaction.replace(R.id.framelayout,FragmentTwo())

        fragmentOneTransaction.addToBackStack(null)

        fragmentOneTransaction.commit()
    }
    override fun fragmentTwoButtonClick() {

        val fragmentTwoTransaction = fragmentManager.beginTransaction()

        fragmentTwoTransaction.replace(R.id.framelayout,FragmentThird())

        fragmentTwoTransaction.addToBackStack(null)

        fragmentTwoTransaction.commit()
    }
}

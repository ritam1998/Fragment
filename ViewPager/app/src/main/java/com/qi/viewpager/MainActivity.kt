package com.qi.viewpager

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() ,FragmentA.FragmentAListener, FragmentB.FragmentBListener {

    var fragmentA = FragmentA()
    var fragmentB = FragmentB()

    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container_a,fragmentA).replace(R.id.container_b,fragmentB)
        fragmentTransaction.commit()
    }

    override fun onInputBSent(input: String?) {
        fragmentA.updateEditText(input)
    }

    override fun onInputASent(input: String?) {
        fragmentB.updateEditText(input)
    }


}

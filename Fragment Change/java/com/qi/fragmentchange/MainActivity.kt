package com.qi.fragmentchange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var usernameText : EditText? = null
    var userEmail : EditText? = null

    var myFragment :MyFragment?= null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameText = findViewById(R.id.usernametext)
        userEmail = findViewById(R.id.usermailText)

        savebutton?.setOnClickListener {
            myFragment?.apply {
                myFragment?.changeData(usernameText?.text?.toString()?:"",userEmail?.text?.toString()?:"")
            }?:run{
                myFragment = MyFragment()
                val bundle = Bundle()
                bundle.putCharSequence("username",usernameText?.text?.toString())
                bundle.putCharSequence("userEmail",userEmail?.text?.toString())
                myFragment?.arguments = bundle
                myFragment?.let {
                    loadFragment(it)
                }
            }
        }
    }
    private fun loadFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager

        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.framelayout,fragment)

        fragmentTransaction.commit()
    }

}

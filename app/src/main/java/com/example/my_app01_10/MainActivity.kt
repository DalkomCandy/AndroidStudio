package com.example.my_app01_10

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

const val EXTRA_MESSAGE = "com.example.my_app01_10.MESSAGE"

class MainActivity : AppCompatActivity() {

    private val fragment1 = redFragment()
    private val fragment2 = blueFragment()
    private val fragment3 = PinkFragment()
    private val fragment4 = yellowFragment()

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNavigationBar()


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        layoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = layoutManager

        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter
    }

    private fun initNavigationBar() {

        val bnv_main = findViewById<BottomNavigationView>(R.id.bottom_menu)
        bnv_main.run {
            setOnNavigationItemReselectedListener {
                when (it.itemId) {
                    R.id.first_tab -> {
                        changeFragment(fragment1)
                    }
                    R.id.second_tab -> {
                        changeFragment(fragment2)
                    }
                    R.id.third_tab -> {
                        changeFragment(fragment3)
                    }
                    R.id.fourth_tab -> {
                        changeFragment(fragment4)
                    }
                }
            }
            true
        }
        bnv_main.selectedItemId = R.id.first_tab
    }

    /** Called when the user taps the Send button */
    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    private fun changeActivity(activity: Activity) {
        findViewById<>()
    }
}
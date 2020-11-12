package com.oldfredddy.datasavekotlinlesson16

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    var counter = 0
    var test = "0"
    var pref: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pref = getSharedPreferences("TABLE", MODE_PRIVATE)
        counter = pref?.getInt("counter", 0)!!
        test = pref?.getString("test", "0")!!

        tvResult.text = counter.toString()
        tvRes2.text = test
    }

    fun onClickAdd(view: View) {

        counter++
        saveData(counter)
        tvResult.text = counter.toString()


    }

    fun saveData(res: Int) {
        val editor = pref?.edit()
        editor?.putInt("counter", res)
        editor?.putString("test", "Test")
        editor?.apply()
    }

    fun deleteAll() {
        val editor = pref?.edit()
        editor?.clear()
        editor?.apply()
    }

    fun deleteItem(deleteitem: String) {

        val editor = pref?.edit()
        editor?.remove(deleteitem)
        editor?.apply()

    }

    override fun onDestroy() {
        super.onDestroy()

    }

    fun onClickClear(view: View) {
        counter = 0
        tvResult.text = counter.toString()
        deleteAll()
    }

    fun onClickDeleteItem(view: View) {

        deleteItem("counter")

    }
}
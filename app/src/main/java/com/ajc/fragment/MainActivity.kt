package com.ajc.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager


class MainActivity : AppCompatActivity(), View.OnClickListener {

/*    below  properties we never used ..below is java
    // private Button mBtnAddA;
    private var mBtnRemoveA: Button? = null
    private var mBtnReplaceAWithBackstack: Button? = null
    private var mBtnReplaceAWithoutBackstack: Button? = null
    private var mBtnAddB: Button? = null
    private var mBtnReplaceWithA: Button? = null
    private var mBtnRemoveB: Button? = null*/

    private var fragmentManager: FragmentManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        fragmentManager = supportFragmentManager
    }

    private fun initViews() {
        val mBtnAddA = findViewById<Button>(R.id.btnAddA)
//        mBtnAddA.setOnClickListener(this)

        val mBtnAddB = findViewById<Button>(R.id.btnAddB)
        mBtnAddB.setOnClickListener(this)

        val mBtnRemoveA = findViewById<Button>(R.id.btnRemoveA)
        mBtnRemoveA.setOnClickListener(this)

        val mBtnRemoveB = findViewById<Button>(R.id.btnRemoveB)
        mBtnRemoveB.setOnClickListener(this)

        val mBtnReplaceAWithBackstack = findViewById<Button>(R.id.btnReplaceAWithBackstack)
        mBtnReplaceAWithBackstack.setOnClickListener(this)

        val mBtnReplaceAWithoutBackstack =
            findViewById<Button>(R.id.btnReplaceAWithBWithoutBackstack)
        mBtnReplaceAWithoutBackstack.setOnClickListener(this)

        val mBtnReplaceWithA = findViewById<Button>(R.id.btnReplaceBWithA)
        mBtnReplaceWithA.setOnClickListener(this)

        val mBtnReplaceAWithB = findViewById<Button>(R.id.btnReplaceAWithB)
        mBtnReplaceAWithB.setOnClickListener(this)

//        mBtnReplaceWithA.setOnClickListener(this)
        mBtnAddA.setOnClickListener(this)
//        mBtnAddB.setOnClickListener(this)
//        mBtnRemoveA.setOnClickListener(this)
//        mBtnRemoveB.setOnClickListener(this)
//        mBtnReplaceAWithBackstack.setOnClickListener(this)
//        mBtnReplaceAWithoutBackstack.setOnClickListener(this)
//        mBtnReplaceWithA.setOnClickListener(this)
    }

    @SuppressLint("NonConstantResourceId")
    override fun onClick(v: View) {
        val id = v.id
        when (id) {
            R.id.btnAddA -> addA()
            R.id.btnAddB -> addB()
            R.id.btnReplaceAWithBackstack -> replaceAWithBWithBackstack()
            R.id.btnReplaceAWithBWithoutBackstack -> replaceAWithB()
            R.id.btnRemoveA -> removeA()
            R.id.btnRemoveB -> removeB()
            R.id.btnReplaceBWithA -> replaceBWithA()
            R.id.btnReplaceAWithB -> replaceAWithB1()
        }
    }

    private fun replaceAWithB1() {
        val transaction = fragmentManager!!.beginTransaction()
        val fragmentB = FragmentB()
        transaction.replace(R.id.flContainer, fragmentB, "fragmentB").commit()
    }

    private fun replaceAWithBWithBackstack() {
        val transaction = fragmentManager!!.beginTransaction()
        val fragmentB = FragmentB()
        transaction.replace(R.id.flContainer, fragmentB, "fragmentB").addToBackStack("fragB")
            .commit()
    }

    private fun replaceAWithBWithoutBackstack() {
        val transaction = fragmentManager!!.beginTransaction()
        val fragmentB = FragmentB()
        transaction.replace(R.id.flContainer, fragmentB, "fragmentB").commit()
    }

    private fun removeB() {
        val fragmentB: FragmentB? = fragmentManager!!.findFragmentByTag("fragmentB") as FragmentB?
        if (fragmentB != null) {
            val transaction = fragmentManager!!.beginTransaction()
            transaction.remove(fragmentB).commit()
        }
    }

    private fun removeA() {
        // FragmentA fragmentA = fragmentManager.findFragmentByTag("fragmentA"); error is shown so typecast
        val fragmentA = fragmentManager!!.findFragmentByTag("fragmentA") as FragmentA?
        if (fragmentA != null) {
            val transaction = fragmentManager!!.beginTransaction()
            transaction.remove(fragmentA).commit()
        }
    }

    private fun replaceBWithA() {
        val transaction = fragmentManager!!.beginTransaction()
        val fragmentA = FragmentA()
        transaction.replace(R.id.flContainer, fragmentA, "fragmentA").commit()
    }

    private fun replaceAWithB() {
        val transaction = fragmentManager!!.beginTransaction()
        val fragmentB = FragmentB()
        transaction.replace(R.id.flContainer, fragmentB, "fragmentB").commit()
    }

    private fun addB() {
        val transaction = fragmentManager!!.beginTransaction()
        val fragmentB = FragmentB()
        transaction.add(R.id.flContainer, fragmentB, "fragmentB").addToBackStack("aaa").commit()
    }

    private fun addA() {
        val transaction = fragmentManager!!.beginTransaction()
        val fragmentA = FragmentA() //tag : is unique identifier
        transaction.add(R.id.flContainer, fragmentA, "fragmentA").addToBackStack("aaa").commit()
    }
}
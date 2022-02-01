package com.ajc.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class FragmentA : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        printLogs("onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        printLogs("onCreate")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        printLogs("onActivityCreated")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        printLogs("onCreateView")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        printLogs("onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        printLogs("onStart")
    }

    override fun onResume() {
        super.onResume()
        printLogs("onResume")
    }

    override fun onPause() {
        super.onPause()
        printLogs("onPause")
    }

    override fun onStop() {
        super.onStop()
        printLogs("onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        printLogs("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        printLogs("onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        printLogs("onDetach")
    }

    private fun printLogs(message: String) {
        Log.d(TAG, message)
    }

    companion object {
        private val TAG = FragmentA::class.java.simpleName
    }
}
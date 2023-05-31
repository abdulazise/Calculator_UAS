package com.example.uas

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI

class next : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_next, container, false)
        root.findViewById<Button>(R.id.button)
            .setOnClickListener {
                findNavController().navigate(R.id.action_next_to_calculator)
            }
        setHasOptionsMenu(true)
        return root
    }

    fun openAboutApp() {
        val intent = Intent(requireContext(), AboutActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.about -> openAboutApp()
        }
        return super.onOptionsItemSelected(item)
    }
}
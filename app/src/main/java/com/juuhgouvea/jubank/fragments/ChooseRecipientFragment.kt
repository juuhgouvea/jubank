package com.juuhgouvea.jubank.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.juuhgouvea.jubank.R
import kotlinx.android.synthetic.main.fragment_choose_recipient.*
import kotlinx.android.synthetic.main.fragment_choose_recipient.view.*

class ChooseRecipientFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_choose_recipient, container, false)

        view.btnNext.setOnClickListener { nextHandler(inputAmount.text.toString()) }
        view.btnCancel.setOnClickListener { findNavController().navigateUp() }

        return view
    }


    private fun nextHandler(recipient: String = "") {
        if(recipient.equals("")) {
            return;
        }

        val bundle = Bundle()
        bundle.putString("recipient", recipient)

        findNavController().navigate(R.id.navigateToSpecifyAmount, bundle)
    }
}
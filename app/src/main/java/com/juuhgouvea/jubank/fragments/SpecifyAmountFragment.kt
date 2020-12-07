package com.juuhgouvea.jubank.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.juuhgouvea.jubank.R
import kotlinx.android.synthetic.main.fragment_specify_amount.view.*

class SpecifyAmountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_specify_amount, container, false)
        val recipient = arguments?.getString("recipient");

        view.textSendingTo.text = getString(R.string.sending_to, recipient);
        view.btnNext.setOnClickListener { nextHandler(recipient.toString(), view.inputAmount.text.toString()) }
        view.btnCancel.setOnClickListener { findNavController().navigateUp() }
        return view;
    }

    private fun nextHandler(recipient: String = "", amountString: String = "0.00") {
        if(amountString.equals("")) {
            return;
        }

        var amount = amountString.toFloatOrNull();

        val bundle = Bundle().apply {
            putString("recipient", recipient)
            putFloat("amount", amount!!)
        }

        findNavController().navigate(R.id.navigateToConfirmation, bundle)
    }
}
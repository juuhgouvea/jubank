package com.juuhgouvea.jubank.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juuhgouvea.jubank.R
import kotlinx.android.synthetic.main.fragment_confirmation.view.*

class ConfirmationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_confirmation, container, false)
        val recipient = arguments?.getString("recipient");
        val amount = arguments?.getFloat("amount");

        view.textSentMessage.text = getString(R.string.sent_message, amount, recipient);
        return view
    }
}
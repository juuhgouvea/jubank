package com.juuhgouvea.jubank.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.juuhgouvea.jubank.R
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false);
        view.btViewTransactions.setOnClickListener { goToViewTransactions() }
        view.btSendMoney.setOnClickListener { goToChooseRecipient() }
        view.btViewBalance.setOnClickListener { goToViewBalance() }

        return view;
    }

    private fun goToViewTransactions() {
        findNavController().navigate(R.id.navigateToTransactions);
    }

    private fun goToChooseRecipient() {
        findNavController().navigate(R.id.navigateToChooseRecipient);
    }

    private fun goToViewBalance() {
        findNavController().navigate(R.id.navigateToBalance);
    }
}
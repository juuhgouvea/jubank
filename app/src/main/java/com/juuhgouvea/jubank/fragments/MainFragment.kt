package com.juuhgouvea.jubank.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.juuhgouvea.jubank.LoginActivity
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
        view.btnLogout.setOnClickListener { logoutHandler() }

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

    private fun logoutHandler() {
        activity?.getSharedPreferences("login", Context.MODE_PRIVATE)?.edit().apply {
            if(this !== null) {
                clear()
                commit()
            }
        }

        var intent = Intent(activity, LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        };

        startActivity(intent);
    }
}
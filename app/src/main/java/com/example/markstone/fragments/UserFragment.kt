package com.example.markstone.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.example.markstone.R
import com.example.markstone.fragments.users.DeliveryFragment
import com.example.markstone.fragments.users.ExchangeFragment


/**
 * A simple [Fragment] subclass.
 * Use the [UserFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserFragment : Fragment() {

    private lateinit var delivery: TextView
    private lateinit var exchange: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v =  inflater.inflate(R.layout.fragment_user, container, false)

        delivery = v.findViewById(R.id.delivery)
        delivery.setOnClickListener {
            loadFragment(DeliveryFragment())
        }

        exchange = v.findViewById(R.id.exchange)
        exchange.setOnClickListener {
            loadFragment(ExchangeFragment())
        }
        return v;
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = requireFragmentManager().beginTransaction()
        transaction.replace(R.id.fl_wrapper, fragment)
        transaction.commit()
    }

}
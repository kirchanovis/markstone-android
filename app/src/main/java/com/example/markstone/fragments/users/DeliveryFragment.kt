package com.example.markstone.fragments.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.markstone.R
import com.example.markstone.fragments.UserFragment

class DeliveryFragment : Fragment() {

    private lateinit var back_devivery: ImageView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v =  inflater.inflate(R.layout.fragment_delivery, container, false)

        back_devivery = v.findViewById(R.id.back_devivery)
        back_devivery.setOnClickListener {
            loadFragment(UserFragment())
        }
        return v;
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = requireFragmentManager().beginTransaction()
        transaction.replace(R.id.fl_wrapper, fragment)
        transaction.commit()
    }
}
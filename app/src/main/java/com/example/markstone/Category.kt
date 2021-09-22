package com.example.markstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.markstone.fragments.CartFragment
import com.example.markstone.fragments.CatalogFragment
import com.example.markstone.fragments.SaleFragment
import com.example.markstone.fragments.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Category : AppCompatActivity() {

    lateinit var linkDelovery: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        loadFragment(SaleFragment())

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.user_list -> {
                    // startActivity(Intent(this, UserActivity::class.java))
                    loadFragment(UserFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.sale -> {
                    loadFragment(SaleFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.catalog -> {
                    loadFragment(CatalogFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.cart -> {
                    loadFragment(CartFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }

        }

    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().also { fragmentTransaction ->
            fragmentTransaction.replace(R.id.fl_wrapper, fragment)
            fragmentTransaction.commit()
        }
    }

}
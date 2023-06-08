package com.example.bottom_nav_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.bottom_nav_view.databinding.ActivityMainBinding
import com.example.bottom_nav_view.databinding.SearchViewBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(Home())
                R.id.person -> replaceFragment(Person())
                R.id.loc -> replaceFragment(Location())
                R.id.sett -> replaceFragment(Setting())

                else->{

                }
            }
            true
        }
    }
    private fun replaceFragment(fragment:Fragment){
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }
}
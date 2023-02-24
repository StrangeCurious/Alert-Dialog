package com.example.alertdialog

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you sure?")
            builder1.setMessage("Do you want to close the app?")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)
            builder1.setPositiveButton("Yes", { dialogInterface, i ->
                //Action to be performed
                finish()
            })
            builder1.setNegativeButton("No", { dialogInterface, i ->
                //Action to be performed
            })
            builder1.show()
        }

        binding.button2.setOnClickListener {
            val sports = arrayOf("Cricket","Football","Table Tennis", "Badminton")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Choose your favourite sport")

            builder2.setSingleChoiceItems(sports,0, { dialogInterface, i ->
                Toast.makeText(this,"Its ${sports[i]}",Toast.LENGTH_SHORT).show()
            })

            builder2.setPositiveButton("Yes", { dialogInterface, i ->
                Toast.makeText(this,"Ok",Toast.LENGTH_SHORT).show()
            })

            builder2.setNegativeButton("No", { dialogInterface, i ->
                Toast.makeText(this,"Sorry",Toast.LENGTH_SHORT).show()
            })
            builder2.show()
        }

        binding.button3.setOnClickListener {
            val fruits = arrayOf("Mango","Apple","Banana", "Grapes")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Select fruits you like")
            builder3.setMultiChoiceItems(fruits,null,DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->
                Toast.makeText(this,"Its ${fruits[i]}",Toast.LENGTH_SHORT).show()

            })

            builder3.setPositiveButton("Yes", { dialogInterface, i ->
                Toast.makeText(this,"Ok",Toast.LENGTH_SHORT).show()
            })

            builder3.setNegativeButton("No", { dialogInterface, i ->
                Toast.makeText(this,"Sorry",Toast.LENGTH_SHORT).show()
            })

            builder3.show()
        }

    }
}
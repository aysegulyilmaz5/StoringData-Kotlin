package com.aysegulyilmaz.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var ageFromPreferences : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //SharedPrefernces Initialize
        sharedPreferences = this.getSharedPreferences("com.aysegulyilmaz.storingdata",
            Context.MODE_PRIVATE)
        ageFromPreferences = sharedPreferences.getInt("age",0)
        if(ageFromPreferences == 0 ){
            textView.text="Your Age:"
        }else{
            textView.text = "Your Age: $ageFromPreferences"
        }

    }

    fun save(view: View){

        val myAge = editText.text.toString().toIntOrNull()
        if (myAge != null){
            textView.text = "Your Age:" +myAge
            sharedPreferences.edit().putInt("age",myAge).apply()
        }

    }

    fun delete(view: View){
        ageFromPreferences = sharedPreferences.getInt("age",0)//değer var mı yok mu kontrol ediyor
        if(ageFromPreferences != 0){
            sharedPreferences.edit().remove("age").apply()
            textView.text="Your age"

        }


    }
}
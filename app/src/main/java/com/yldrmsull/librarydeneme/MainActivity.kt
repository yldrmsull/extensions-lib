package com.yldrmsull.librarydeneme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yldrmsull.extensions.functions.convertToDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var string:String=""

        string.convertToDate()
    }
}
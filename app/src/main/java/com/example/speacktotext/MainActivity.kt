package com.example.speacktotext

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.speacktotext.databinding.ActivityMainBinding
import java.util.Locale



class MainActivity : AppCompatActivity() {
    private val REQUEST_TO_SPEECH=102
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.speech.setOnClickListener {
            speechinput()
        }
        println("")
        println("First commit done successfully")
        print("one of the best platform to leaning")
        print("for one more time im want to commite that thing")
        print("one the last commit all show you")
        print("for using terminal ")

    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode== REQUEST_TO_SPEECH && resultCode == Activity.RESULT_OK ){
            val result=data?.getStringArrayExtra(RecognizerIntent.EXTRA_RESULTS)
            binding.textSpeech.text = result?.get(0).toString()
        }
    }
    private fun speechinput(){
        if(!SpeechRecognizer.isRecognitionAvailable(this)){
            Toast.makeText(this,"speech is not Available this device",Toast.LENGTH_SHORT).show()
        }else{
            val intent=Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,Locale.CANADA)
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say Something!!")
            startActivityForResult(intent,REQUEST_TO_SPEECH)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if(id==android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
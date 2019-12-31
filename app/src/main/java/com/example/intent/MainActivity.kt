package com.example.intent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_MESSAGE="com.example.intent.MESSAGE"
        const val REQUEST_CODE =1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonSend.setOnClickListener {
            sendMessage();
        }

        button2.setOnClickListener {
            callme();
        }

    }

    private fun callme() {
        val phone="tel:0123456789"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData((Uri.parse(phone)))
        if(intent.resolveActivity(packageManager)!=null)
            startActivity(intent)
    }

    private fun sendMessage() {

        val message = editTextMessage.text.toString()
        val lucky = editTextLucky.text.toString().toInt()
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("Massage",message)
        intent.putExtra("lucky",lucky)
        //startActivity(intent)
        startActivityForResult(intent,REQUEST_CODE)



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==REQUEST_CODE){
            if(resultCode==Activity.RESULT_OK){
                textViewReply.text = String.format("%s %s",getString(R.string.reply),data?.getStringExtra("reply"))
            }
        }


    }
}
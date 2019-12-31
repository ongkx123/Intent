package com.example.intent

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        buttonDone.setOnClickListener {
            if(!editTextReply.text.isEmpty()) {
                val reply = editTextReply.text.toString()
                val intent = getIntent()
                intent.putExtra("reply", editTextReply.text.toString())
                setResult(Activity.RESULT_OK, intent)
            }else{
                setResult(Activity.RESULT_CANCELED)

            }
            finish()
        }
        val message = intent.getStringExtra("Massage")
        textViewMessage.text = String.format("%s %s",getString(R.string.message),message)
        val lucky = intent.getIntExtra("lucky",0)
        textViewluckynumber.text = String.format("%s %s",getString(R.string.message),lucky)

    }
}

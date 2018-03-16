package com.tommasoberlose.customprogressdialog

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.tommasoberlose.progressdialog.ProgressDialogFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    hello.setOnClickListener {
      ProgressDialogFragment.showProgressBar(this)

      Handler().postDelayed({
        ProgressDialogFragment.hideProgressBar(this)
      }, 2000)
    }
  }
}

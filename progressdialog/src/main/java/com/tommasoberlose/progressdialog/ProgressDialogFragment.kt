package com.tommasoberlose.progressdialog

import android.app.Activity
import android.app.Dialog
import android.app.DialogFragment
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.graphics.drawable.ColorDrawable
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.Window.FEATURE_NO_TITLE
import android.widget.RelativeLayout




/**
 * Created by tommaso on 16/03/18.
 */

class ProgressDialogFragment : DialogFragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val rootView = inflater.inflate(R.layout.progress_dialog_fragment_layout, container, false)
    isCancelable = false
    rootView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    dialog.window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    return rootView
  }

  companion object {
    fun showProgressBar(activity: Activity) {
      try {
        val fm = activity.fragmentManager
        val dialogFragment = ProgressDialogFragment()
        dialogFragment.show(fm, Constants.PROGRESS_DIALOG_TAG)
      } catch (ignored: Exception) {}
    }

    fun hideProgressBar(activity: Activity) {
      try {
        val fm = activity.fragmentManager
        val dialog = fm.findFragmentByTag(Constants.PROGRESS_DIALOG_TAG)
        if (dialog != null && dialog is ProgressDialogFragment) {
          dialog.dismiss()
        }
      } catch (ignored: Exception) {}
    }
  }
}
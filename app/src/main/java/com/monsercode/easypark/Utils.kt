package com.monsercode.easypark

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.design.indefiniteSnackbar
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.find

class Utils {
    companion object {
        private const val tag: String = "Utils"
        private const val minPasswordLength = 2
        fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
                && (email.contains("finance.go.ug")
                || email.contains("ssenyonjo")
                )

        fun isValidPassword(password: String): Boolean = password.trim().length >= minPasswordLength

        fun setClickableAnimation(context: Context, view: View) {
            val attrs = intArrayOf(R.attr.selectableItemBackground)
            val typedArray = context.obtainStyledAttributes(attrs)
            val backgroundResource = typedArray.getResourceId(0, 0)
            view.setBackgroundResource(backgroundResource)
            typedArray.recycle()
        }

        fun getSharedP(context: Context)
                = context.getSharedPreferences(
            context.getString(R.string.shared_prefs), Context.MODE_PRIVATE
        )

        fun hideKeyboard(activity: Activity) {
            val imm: InputMethodManager =
                activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            //Find the currently focused view, so we can grab the correct window token from it.
            var view = activity.currentFocus
            //If no view currently has focus, create a new one, just so we can grab a window token from it
            if (view == null) {
                view = View(activity)
            }
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        fun snack(activity: Activity, message: String) {
            hideKeyboard(activity)
            activity.find<View>(android.R.id.content).longSnackbar(message).show()
        }
        fun indefiniteSnack(activity: Activity, message: String) {
            hideKeyboard(activity)
            activity.find<View>(android.R.id.content).indefiniteSnackbar(message).show()
        }

        fun isNetworkAvailable(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
        }


        fun checkNetworkActive(context: Context): Boolean {
            if (!isNetworkAvailable(context)) {
                snack(context as Activity, "Not Connected")
            }
            return isNetworkAvailable(context)
        }

        fun putDivider(activity: Activity, recyclerView: RecyclerView) {
            val itemDecorator = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
            itemDecorator.setDrawable(ContextCompat.getDrawable(activity, R.drawable.divider)!!)
            recyclerView.addItemDecoration(itemDecorator)
        }
    }
}

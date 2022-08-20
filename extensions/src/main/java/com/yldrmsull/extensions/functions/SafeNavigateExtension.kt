package com.yldrmsull.extensions.functions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import java.lang.Exception

fun NavController.navigateSafely(
        @IdRes resId: Int,
        args: Bundle? = null,
        navOptions: NavOptions? = null,
        navExtras: Navigator.Extras? = null)
    {
        try
        {
            val action = currentDestination?.getAction(resId) ?: graph.getAction(resId)

            if(action != null && currentDestination?.id != action.destinationId)
            {
                navigate(resId, args, navOptions, navExtras)
            }
        }
        catch (e: Exception)
        {
            e.printStackTrace()
        }
    }


    inline fun <reified To: AppCompatActivity> navigateToIntent(
        context: Context,
        args: Bundle? = null,
        message: String? = "",
        finish: Boolean = true)
    {
        try
        {
            val activity = context as Activity
            val intent = Intent(context,To::class.java)

            if (args != null)
            {
                intent.putExtras(args)
            }

            if(!message.equals(""))
            {
                intent.putExtra("data",message)
            }

            context.startActivity(intent)

            if(finish)
            activity.finish()
        }
        catch (e : Exception)
        {
            e.printStackTrace()
        }
    }



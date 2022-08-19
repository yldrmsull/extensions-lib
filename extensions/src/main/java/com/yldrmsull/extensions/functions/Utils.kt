package com.yldrmsull.extensions.functions

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.view.animation.Animation
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleCoroutineScope
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.ViewTarget
import com.google.android.material.card.MaterialCardView
import com.yldrmsull.extensions.functions.addCardStroke
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

fun LifecycleCoroutineScope.coroutineMainThread(f: () -> Unit)
    {
        launch {
            withContext(Dispatchers.Main)
            {
                f.invoke()
            }
        }
    }

    fun ImageView.loadFromUrl(url: String): ViewTarget<ImageView?, Drawable?>
    {
        return this.loadFromUrl(url, 100, null, null)
    }

    fun ImageView.loadFromUrl(
        url: String,
        quality: Int,
        width: Int?,
        height: Int?): ViewTarget<ImageView?, Drawable?>
    {
        var requestOptions = RequestOptions()

        if (width != null && height != null)
        {
            requestOptions = requestOptions.override(width, height)
            requestOptions = requestOptions.centerCrop()
        }

        return Glide.with(this)
            .load(if (url.contains("file:")) Uri.parse(url) else url)
            .encodeQuality(quality)
            .apply(requestOptions)
            .into(this)
    }

    fun isGenymotionEmulator(): Boolean
    {
        val buildManufacturer = Build.MANUFACTURER
        return buildManufacturer != null &&
                (buildManufacturer.contains("Genymotion") || buildManufacturer == "unknown")
    }

    fun buildModelContainsEmulatorHints(): Boolean
    {
        val buildModel = Build.MODEL
        return (buildModel.startsWith("sdk")
                || "google_sdk" == buildModel || buildModel.contains("Emulator")
                || buildModel.contains("Android SDK"))
    }

    fun thisDeviceIsNotEmulator() : Boolean
    {
        return !(isGenymotionEmulator() || buildModelContainsEmulatorHints())
    }

    fun addStrokeAndAnimation(cardView: MaterialCardView, color: Int, animation: Animation? = null)
    {
        try
        {
            cardView.addCardStroke(color)
            if(animation != null)
                cardView.startAnimation(animation)
        }
        catch (e: Exception)
        {
            e.printStackTrace()
        }
    }

package com.yldrmsull.extensions.functions

import android.graphics.Paint
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.card.MaterialCardView
import java.text.SimpleDateFormat
import java.util.*
import android.content.res.ColorStateList
import android.text.Spanned
import androidx.core.text.HtmlCompat

fun View.isVisible(boolean: Boolean)
        {
            if (boolean)
                this.visibility = View.VISIBLE
            else
                this.visibility = View.GONE
        }

fun View.setBackColor(colorId : Int)
{
    this.setBackgroundColor(ContextCompat.getColor(this.context, colorId))
}

fun CardView.setBackCardColor(colorId : Int)
{
    this.setCardBackgroundColor(ContextCompat.getColor(this.context, colorId))
}

fun Date.toString(dateFormat: String): String? =
    SimpleDateFormat(dateFormat, Locale.getDefault()).format(this)

fun String.convertToDateEcg(): String
{
    val newDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val date = newDateFormat.parse(this)
    return date?.toString("dd.MM.yyyy HH:mm:ss") ?: ""
}

fun String.convertToDate(): String
{
    val newDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val date = newDateFormat.parse(this)
    return date?.toString("dd.MM.yyyy") ?: ""
}

fun TextView.underline()
{
    paintFlags = paintFlags or Paint.UNDERLINE_TEXT_FLAG
}

fun getSpannedText(text: String): Spanned?
{
    return HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_COMPACT)
}

fun MaterialCardView.addCardStroke(colorId : Int)
{
    this.strokeWidth = 5
    this.setStrokeColor(ColorStateList.valueOf(resources.getColor(colorId,context.theme)))
}
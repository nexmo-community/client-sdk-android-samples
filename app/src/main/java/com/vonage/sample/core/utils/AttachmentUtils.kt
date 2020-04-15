package com.vonage.sample.core.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Environment
import com.vonage.sample.R
import java.io.File
import java.io.FileOutputStream

object AttachmentUtils {
    @JvmStatic
    fun generateImageFile(context: Context): File {
        val path = Environment.getDataDirectory().toString()

        val file = File(path, "Info" + ".png")

        if (!file.exists()) {
            val drawable = context.getDrawable(R.mipmap.ic_launcher_round)
            val bitmap = (drawable as BitmapDrawable).bitmap

            FileOutputStream(file).apply {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, this)
                this.flush()
                this.close()
            }
        }

        return file
    }
}
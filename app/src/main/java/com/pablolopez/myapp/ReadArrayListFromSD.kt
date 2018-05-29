package com.pablolopez.myapp

import android.content.Context
import java.io.ObjectInputStream

fun ReadArrayListFromSD(mContext: Context, filename: String): ArrayList<String> {
    try {
        val fis = mContext.openFileInput("$filename.dat")
        val ois = ObjectInputStream(fis)
        val obj = ois.readObject() as ArrayList<String>
        fis.close()
        return obj

    } catch (e: Exception) {
        e.printStackTrace()
        return ArrayList<String>()
    }

}
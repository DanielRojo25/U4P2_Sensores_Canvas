package com.example.u4p2_sensores_canvas

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.content.Context.SYSTEM_HEALTH_SERVICE
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.ImageDecoder
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.Image
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat.getSystemService

class Lienzo (puntero:MainActivity) : View(puntero) {

    val p = puntero

    var posicionXNube = 200f
    var posicionXSolyLuna = 600F

    var luz = true

    var bruja = BitmapFactory.decodeResource(p.resources, R.drawable.bruja180)
    var luna  =  BitmapFactory.decodeResource(p.resources, R.drawable.luna)
    var nube  =  BitmapFactory.decodeResource(p.resources, R.drawable.nube)
    var sol   =  BitmapFactory.decodeResource(p.resources, R.drawable.sol)

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()

        c.drawBitmap(bruja, 300f, 700f, p)

        c.drawBitmap(nube, posicionXNube, 50f, p)
        c.drawBitmap(nube, posicionXNube, 300f, p)

        if (luz){
            c.drawBitmap(sol, posicionXSolyLuna, 50f, p)
        } else {
            c.drawBitmap(luna, posicionXSolyLuna,50f, p)
        }

    }

}
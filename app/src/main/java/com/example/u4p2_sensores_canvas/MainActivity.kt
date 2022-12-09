package com.example.u4p2_sensores_canvas


import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), SensorEventListener{
    private lateinit var sensorManager: SensorManager
    private lateinit var lienzo: Lienzo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lienzo = Lienzo(this)
        setContentView(lienzo)
        setupSensortuff()
    }

    private fun setupSensortuff() {
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)?.also {
            sensorManager.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_FASTEST,
                SensorManager.SENSOR_DELAY_FASTEST
            )
            sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)?.also {
                sensorManager.registerListener(
                    this,
                    it,
                    SensorManager.SENSOR_DELAY_FASTEST,
                    SensorManager.SENSOR_DELAY_FASTEST
                )
            }
        }
    }

    override fun onSensorChanged(event: SensorEvent) {
        val posicionX = event.values[0]

        if(event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            lienzo.posicionXNube = lienzo.posicionXNube + (-posicionX)
        }

        if(event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            lienzo.posicionXSolyLuna = lienzo.posicionXSolyLuna + (-posicionX)
        }

        if(event.sensor.type == Sensor.TYPE_PROXIMITY) {
            lienzo.luz = (event.values[0] >= 10f)
        }

        lienzo.invalidate()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        return
    }

}
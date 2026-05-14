package com.example.sosapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.telephony.SmsManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationServices

class MainActivity : AppCompatActivity() {

    private val emergencyNumber = "1234567890"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                1
            )
        }

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.SEND_SMS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.SEND_SMS),
                2
            )
        }
        val sosButton = findViewById<Button>(R.id.sosButton)

        sosButton.setOnClickListener {
            getLocationAndSendSOS()
        }
    }

    private fun getLocationAndSendSOS() {

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this, "Location permission not granted", Toast.LENGTH_SHORT).show()
            return
        }

        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        fusedLocationClient.getCurrentLocation(
            com.google.android.gms.location.Priority.PRIORITY_HIGH_ACCURACY,
            null
        ).addOnSuccessListener { location ->

            if (location != null) {
                val latitude = location.latitude
                val longitude = location.longitude

                val mapsLink = "https://maps.google.com/?q=$latitude,$longitude"
                val message = "I am in danger. My location: $mapsLink"

                try {
                    val smsManager = SmsManager.getDefault()
                    smsManager.sendTextMessage(
                        emergencyNumber,
                        null,
                        message,
                        null,
                        null
                    )

                    Toast.makeText(this, "SOS Sent Successfully!", Toast.LENGTH_SHORT).show()

                } catch (e: Exception) {
                    Toast.makeText(this, "Failed to send SOS", Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
            }
        }
    }
}
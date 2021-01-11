package com.daehwan.myapplication

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        val button = findViewById<Button>(R.id.ask)
        button.setOnClickListener {
            val cameraPermissionCheck = ContextCompat.checkSelfPermission(
                this@PermissionActivity,
                android.Manifest.permission.CAMERA
            )
            if (cameraPermissionCheck != PackageManager.PERMISSION_GRANTED){
                // 권한이 없는 경우
                ActivityCompat.requestPermissions(
                    this@PermissionActivity,
                    arrayOf(android.Manifest.permission.CAMERA),
                    1000
                )
                Toast.makeText(this@PermissionActivity,"권한 요청",Toast.LENGTH_LONG).show()
            }else{
                // 권한이 있는 경우
                Toast.makeText(this@PermissionActivity,"이미 있음",Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1000){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this@PermissionActivity,"권한 획득",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
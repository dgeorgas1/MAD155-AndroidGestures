package com.example.androidgestures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    var detector: GestureDetectorCompat? = null
    lateinit var gestureLabel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.detector = GestureDetectorCompat(this, this)
        detector?.setOnDoubleTapListener(this)
        gestureLabel = findViewById(R.id.gestureLabel)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            this.detector?.onTouchEvent(event)
        }
        return super.onTouchEvent(event)
    }

    override fun onDown(e: MotionEvent): Boolean {
        Toast.makeText(this, "onDown", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onShowPress(e: MotionEvent) {
        Toast.makeText(this, "onShowPress", Toast.LENGTH_SHORT).show()
    }

    override fun onSingleTapUp(e: MotionEvent): Boolean {
        Toast.makeText(this, "onSingleTapUp", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        gestureLabel.text = "onScroll"
        return true
    }

    override fun onLongPress(e: MotionEvent) {
        gestureLabel.text = "onLongPress"
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        gestureLabel.text = "onFling"
        return true
    }

    override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
        gestureLabel.text = "onSingleTapConfirmed"
        return true
    }

    override fun onDoubleTap(e: MotionEvent): Boolean {
        gestureLabel.text = "onDoubleTap"
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent): Boolean {
        gestureLabel.text = "onDoubleTapEvent"
        return true
    }
}
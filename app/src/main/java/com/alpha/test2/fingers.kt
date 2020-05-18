package com.alpha.test2

import android.view.GestureDetector
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*

class fingers(mainActivity: MainActivity):GestureDetector.OnGestureListener{
    var main = mainActivity
    override fun onShowPress(e: MotionEvent?) {
        main.Geez.text="onShowPress"
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        main.Geez.text="onSingleTapUp"

        return true
    }

    override fun onDown(e: MotionEvent?): Boolean {
        main.Geez.text="onDown"

        return true
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        main.Geez.text="onFling"

        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        main.Geez.text="onScroll"

        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        main.Geez.text="onLongPress"
    }

}
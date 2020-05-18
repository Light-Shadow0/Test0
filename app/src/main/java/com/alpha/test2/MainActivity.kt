package com.alpha.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var score = 0
    var pepeList:MutableList<PepeHands> = mutableListOf()

    var remindTask:RemindTask? = null
    var Fingers:fingers? = null //question mark says can be equal to null
    var gDetector: GestureDetectorCompat?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Set FullScreen
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN)

        //Init variables
        remindTask = RemindTask(this)
        Fingers = fingers(this)
        gDetector = GestureDetectorCompat(this,Fingers)

        pepeList.add(PepeHands(this))

        //GAME LOOP
        var timer: Timer = Timer()
        timer.schedule(remindTask,0,33)


        }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        gDetector?.onTouchEvent(event)

        return super.onTouchEvent(event)
    }

    }

class RemindTask(mainActivity: MainActivity):TimerTask(){
    var main = mainActivity
    var i = false

    override fun run(){ //fun run is from imported class

        //if(i){
            //main.runOnUiThread(){
            //main.textView2.text = "Duck"
            //i=false}}

        //else{
           // main.runOnUiThread(){
            //main.textView2.text = "Banana"
            //i=true}
        //}

        //update pepes
        for(u in main.pepeList){
            u.update()}


    }

}

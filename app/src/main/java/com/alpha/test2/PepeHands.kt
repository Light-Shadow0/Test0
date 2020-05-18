package com.alpha.test2

import android.util.DisplayMetrics
import android.widget.ImageView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.absoluteValue
import kotlin.random.Random

class PepeHands(main:MainActivity){
    var main= main
    val ran:Random = Random
    val metrics: DisplayMetrics = main.applicationContext.resources.displayMetrics
    var body = ImageView(main)
    var count = -1

    var vx = 0
    var vy = 0

    init{
        vx = ran.nextInt(20)
        vy = ran.nextInt(20)
        if(ran.nextBoolean()){
            vx=-vx}
        if(ran.nextBoolean()){
            vy=-vy}



        create()
        random()


        body.setOnClickListener() {
            main.score++
            if(main.score % 5 == 0){
                main.pepeList.add(PepeHands(main))
                //count++
                println(main.score)
                //for(x in 0..count*count){
                    //main.pepeList.add(PepeHands(main))
                //}
        }
            random()


        }


    }
    fun create(){
        body.layoutParams = LinearLayout.LayoutParams((80 * metrics.density).toInt(),(80 * metrics.density).toInt())
        body.setImageResource(R.drawable.frog_pepe) //R is the resource directory
        main.activityMain.addView(body)



    }
    fun random(){
        body.x = ran.nextInt(metrics.widthPixels - body.width).toFloat()
        body.y = ran.nextInt(metrics.heightPixels - body.height).toFloat()



    }
    fun update(){

        body.x = body.x + vx * metrics.density
        body.y = body.y + vy * metrics.density

        if(body.x <0){
            vx=vx.absoluteValue}
        else if(body.x >= metrics.widthPixels - body.width){
            vx = -(vx.absoluteValue)}

        if(body.y <0){
            vy=vy.absoluteValue}
        else if(body.y >= metrics.heightPixels - body.height){
            vy = -(vy.absoluteValue)}

        }

    }


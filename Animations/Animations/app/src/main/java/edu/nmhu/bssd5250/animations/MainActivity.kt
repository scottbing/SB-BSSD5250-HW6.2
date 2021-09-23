package edu.nmhu.bssd5250.animations

import android.animation.ValueAnimator
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var anim:AnimationDrawable? = null
    private lateinit var imgView:ImageView
    private lateinit var message:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // retrieve the content view witout ggiving it an id
        val vg = findViewById<ViewGroup>(android.R.id.content)
            .getChildAt(0) as ConstraintLayout

       /* //make a new image view
        val imgView = ImageView(this).apply {
            //setImageResource(R.drawable.sm1) // set image resource
            this.setBackgroundResource(R.drawable.smoke_animation)
        }
        val anim = imgView.background as AnimationDrawable
        anim.start()*/

        //make a new image view
        imgView = ImageView(this).apply {
            setImageResource(R.drawable.smoke_animation)
        }
        anim = imgView.drawable as AnimationDrawable

        message = TextView(this).apply {
            text = "0"
        }

        vg.addView(message)
        vg.addView(imgView) //add image view to content view

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                if(anim!!.isRunning) {
                    anim?.stop()
                } else {
                    anim?.start()
                }

                //animate a value that is an in to fo from 0 to 100
                val valAnimator = ValueAnimator.ofInt(0,100)
                //do it in 1000 milliseconds
                valAnimator.duration = 1000
                valAnimator.addUpdateListener {
                    //update the message text with the current animated value
                    message.text = it.animatedValue.toString()
                }
                valAnimator.start()
                return true //tru that I handled the event
            }

            MotionEvent.ACTION_UP -> {
                anim?.stop()
                return true
            }
        }
        return true
    }
}
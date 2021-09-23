package edu.nmhu.bssd5250.animations

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        val imgView = ImageView(this).apply {
            //setImageResource(R.drawable.sm1) // set image resource
            setImageResource(R.drawable.smoke_animation)
        }
        val anim = imgView.drawable as AnimationDrawable
        anim.start()

        vg.addView(imgView)
    }
}
package edu.nmhu.bssd5250.sb_animations

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.animation.ValueAnimator.AnimatorUpdateListener
import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.lang.Math.round


class MainActivity : AppCompatActivity() {
    private var bugAnimation: AnimationDrawable? = null
    private var mothAnimation: AnimationDrawable? = null
    private var birdAnimation: AnimationDrawable? = null
    private var monkeyAnimation: AnimationDrawable? = null
    private var bugMover: ObjectAnimator? = null
    private var mothMover: ObjectAnimator? = null
    private var birdMover: ObjectAnimator? = null
    private var monkeyMover: ObjectAnimator? = null
    private var bugView: ImageView? = null
    private var mothView: ImageView? = null
    private var birdView: ImageView? = null
    private var monkeyView: ImageView? = null
    private var textView: TextView? = null
    private var contentView: ViewGroup? = null
    private var startAnimationButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val linearLayout = LinearLayout(this)

        // show start animation button
        startAnimationButton = Button(this)
        startAnimationButton!!.visibility = View.VISIBLE
        startAnimationButton!!.text = getString(R.string.start_game)
        startAnimationButton!!.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
        )
        //make this button add a new item when clicked
        startAnimationButton!!.setOnClickListener(startClickedListener)
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.addView(startAnimationButton)
        setContentView(linearLayout)
    }

    @SuppressLint("ObjectAnimatorBinding", "ClickableViewAccessibility")
    private val startClickedListener = View.OnClickListener {
        Log.d("addClick Listener", "add clicked")

        // hide the start button
        startAnimationButton!!.visibility = View.GONE
        contentView = (findViewById<View>(android.R.id.content) as ViewGroup)
            .getChildAt(0) as ViewGroup

        // make the bug view
        bugView = ImageView(this@MainActivity)
        bugView!!.setImageResource(R.drawable.bug_animation)
        //bugView.setBackgroundResource(R.drawable.bug_animation);
        bugView!!.setOnTouchListener { _: View?, event: MotionEvent ->
            // TODO Auto-generated method stub
            Log.i("imageviewandontouchlistener", "imageView1 onTouch")
            if (event.action == MotionEvent.ACTION_DOWN) {
                bugMover!!.cancel()
                bugMover!!.end()
                return@setOnTouchListener true
            }
            false
        }

        // make the moth view
        mothView = ImageView(this@MainActivity)
        mothView!!.setImageResource(R.drawable.moth_animation)
        //mothView.setBackgroundResource(R.drawable.moth_animation);
        mothView!!.setOnTouchListener { _: View?, event: MotionEvent ->
            // TODO Auto-generated method stub
            Log.i("imageviewandontouchlistener", "imageView1 onTouch")
            if (event.action == MotionEvent.ACTION_DOWN) {
                mothMover!!.cancel()
                mothMover!!.end()
                return@setOnTouchListener true
            }
            false
        }

        // make the bird view
        birdView = ImageView(this@MainActivity)
        birdView!!.setImageResource(R.drawable.bird_animation)
        //birdView.setBackgroundResource(R.drawable.bird_animation);
        birdView!!.setOnTouchListener { _: View?, event: MotionEvent ->
            // TODO Auto-generated method stub
            Log.i("imageviewandontouchlistener", "imageView1 onTouch")
            if (event.action == MotionEvent.ACTION_DOWN) {
                birdMover!!.cancel()
                birdMover!!.end()
                return@setOnTouchListener true
            }
            false
        }

        // make the monkey view
        monkeyView = ImageView(this@MainActivity)
        monkeyView!!.setImageResource(R.drawable.monkey_animation)
        //monkeyView.setBackgroundResource(R.drawable.monkey_animation);
        monkeyView!!.setOnTouchListener { _: View?, event: MotionEvent ->
            // TODO Auto-generated method stub
            Log.i("imageviewandontouchlistener", "imageView1 onTouch")
            if (event.action == MotionEvent.ACTION_DOWN) {
                monkeyMover!!.cancel()
                monkeyMover!!.end()
                return@setOnTouchListener true
            }
            false
        }

        bugAnimation = bugView!!.drawable as AnimationDrawable
        mothAnimation = mothView!!.drawable as AnimationDrawable
        birdAnimation = birdView!!.drawable as AnimationDrawable
        monkeyAnimation = monkeyView!!.drawable as AnimationDrawable
        textView = TextView(this@MainActivity)
        textView!!.text = "0"
        contentView!!.addView(textView)
        contentView!!.addView(bugView)
        contentView!!.addView(mothView)
        contentView!!.addView(birdView)
        contentView!!.addView(monkeyView)

        // get screen dimensions
        val width = baseContext.resources.displayMetrics.widthPixels
        val height = baseContext.resources.displayMetrics.heightPixels
        Log.e("Width", "" + width)
        Log.e("height", "" + height)

        //start bug animation
        if (bugAnimation!!.isRunning) bugAnimation!!.stop() else {
            bugMover = ObjectAnimator.ofFloat(bugView, "translationY", 1100f)
            bugMover?.duration = 1000
            bugMover?.repeatCount = ValueAnimator.RESTART
            bugMover?.repeatMode = ValueAnimator.REVERSE
            //bugMover.start();
            //bugAnimation.start();
        }

        //start moth animation
        if (mothAnimation!!.isRunning) mothAnimation!!.stop() else {
            mothMover = ObjectAnimator.ofFloat(mothView, "translationX", 500f)
            mothMover?.duration = 1000
            mothMover?.repeatCount = ValueAnimator.RESTART
            mothMover?.repeatMode = ValueAnimator.REVERSE
            //mothMover.start();
            // mothAnimation.start();
        }

        //start bird animation
        if (birdAnimation!!.isRunning) birdAnimation!!.stop() else {
            birdMover = ObjectAnimator.ofFloat(birdView, "translationX", 500f)
            birdMover?.duration = 1000
            birdMover?.repeatCount = ValueAnimator.RESTART
            birdMover?.repeatMode = ValueAnimator.REVERSE
            //birdMover.start();
            // birdAnimation.start();
        }

        //start monkey animation
        if (monkeyAnimation!!.isRunning) monkeyAnimation!!.stop() else {
            monkeyMover = ObjectAnimator.ofFloat(monkeyView, "translationY", 500f)

            /*monkeyMover = ObjectAnimator.ofFloat(monkeyView, "translationX", 500f).apply {
                addUpdateListener { updateAnimation ->
                    monkeyView!!.translationY = updateAnimation.animatedValue as Float
            }*/

            monkeyMover?.duration = 1000
            monkeyMover?.repeatCount = ValueAnimator.RESTART
            monkeyMover?.repeatMode = ValueAnimator.REVERSE
            //monkeyMover.start();
            // monkeyAnimation.start();
        }

        // group the animators inot an AnimationSet
        val set = AnimatorSet()
        set.playTogether(bugMover, mothMover, birdMover, monkeyMover)
        set.start()

        //count from  0 to  100
        val animator = ValueAnimator.ofInt(500, 0)
        animator.reverse() // count down
        //do it 1000  milliseconds
        animator.duration = 1000
        animator.addUpdateListener(animatorUpdated)
        animator.start()
    }
    private val animatorUpdated =
        AnimatorUpdateListener { valueAnimator ->
            textView!!.text = valueAnimator.animatedValue.toString()

            // when timer equals zero, stop the game
            if (valueAnimator.animatedValue.toString().toInt() == 0) {
                mothAnimation!!.stop()
                bugAnimation!!.stop()
                birdAnimation!!.stop()
                monkeyAnimation!!.stop()
                if (!mothAnimation!!.isRunning && !bugAnimation!!.isRunning && !birdAnimation!!.isRunning) {
                    Toast.makeText(this@MainActivity, "Game Over - You Won!", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this@MainActivity, "Game Over - You Lost", Toast.LENGTH_LONG).show()
                }
            }
        }
}

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
import java.security.AccessController.getContext
import android.view.Gravity





class MainActivity : AppCompatActivity() {
    private var bugAnimation: AnimationDrawable? = null
    private var mothAnimation: AnimationDrawable? = null
    private var birdAnimation: AnimationDrawable? = null
    private var monkeyAnimation: AnimationDrawable? = null
    private var catAnimation: AnimationDrawable? = null
    private var foxAnimation: AnimationDrawable? = null
    private var deerAnimation: AnimationDrawable? = null
    private var whiteCatAnimation: AnimationDrawable? = null
    private var bugMover: ObjectAnimator? = null
    private var mothMover: ObjectAnimator? = null
    private var birdMover: ObjectAnimator? = null
    private var monkeyMover: ObjectAnimator? = null
    private var catMover: ObjectAnimator? = null
    private var foxMover: ObjectAnimator? = null
    private var deerMover: ObjectAnimator? = null
    private var whiteCatMover: ObjectAnimator? = null
    private var bugView: ImageView? = null
    private var mothView: ImageView? = null
    private var birdView: ImageView? = null
    private var monkeyView: ImageView? = null
    private var catView: ImageView? = null
    private var foxView: ImageView? = null
    private var deerView: ImageView? = null
    private var whiteCatView: ImageView? = null
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

        // make the cat view
        catView = ImageView(this@MainActivity)
        catView!!.setImageResource(R.drawable.cat_animation)
        //catView.setBackgroundResource(R.drawable.cat_animation);
        catView!!.setOnTouchListener { _: View?, event: MotionEvent ->
            // TODO Auto-generated method stub
            Log.i("imageviewandontouchlistener", "imageView1 onTouch")
            if (event.action == MotionEvent.ACTION_DOWN) {
                catMover!!.cancel()
                catMover!!.end()
                return@setOnTouchListener true
            }
            false
        }

        // make the fox view
        foxView = ImageView(this@MainActivity)
        foxView!!.setImageResource(R.drawable.fox_animation)
        //foxView.setBackgroundResource(R.drawable.fox_animation);
        foxView!!.setOnTouchListener { _: View?, event: MotionEvent ->
            // TODO Auto-generated method stub
            Log.i("imageviewandontouchlistener", "imageView1 onTouch")
            if (event.action == MotionEvent.ACTION_DOWN) {
                foxMover!!.cancel()
                foxMover!!.end()
                return@setOnTouchListener true
            }
            false
        }

        // make the deer view
        deerView = ImageView(this@MainActivity)
        deerView!!.setImageResource(R.drawable.deer_animation)
        //deerView.setBackgroundResource(R.drawable.deer_animation);
        deerView!!.setOnTouchListener { _: View?, event: MotionEvent ->
            // TODO Auto-generated method stub
            Log.i("imageviewandontouchlistener", "imageView1 onTouch")
            if (event.action == MotionEvent.ACTION_DOWN) {
                deerMover!!.cancel()
                deerMover!!.end()
                return@setOnTouchListener true
            }
            false
        }

        // make the whiteCat view
        whiteCatView = ImageView(this@MainActivity)
        whiteCatView!!.setImageResource(R.drawable.white_cat_animation)
        //whiteCatView.setBackgroundResource(R.drawable.whiteCat_animation);
        whiteCatView!!.setOnTouchListener { _: View?, event: MotionEvent ->
            // TODO Auto-generated method stub
            Log.i("imageviewandontouchlistener", "imageView1 onTouch")
            if (event.action == MotionEvent.ACTION_DOWN) {
                whiteCatMover!!.cancel()
                whiteCatMover!!.end()
                return@setOnTouchListener true
            }
            false
        }

        bugAnimation = bugView!!.drawable as AnimationDrawable
        mothAnimation = mothView!!.drawable as AnimationDrawable
        birdAnimation = birdView!!.drawable as AnimationDrawable
        monkeyAnimation = monkeyView!!.drawable as AnimationDrawable
        catAnimation = catView!!.drawable as AnimationDrawable
        foxAnimation = foxView!!.drawable as AnimationDrawable
        deerAnimation = deerView!!.drawable as AnimationDrawable
        whiteCatAnimation = whiteCatView!!.drawable as AnimationDrawable
        textView = TextView(this@MainActivity)
        textView!!.text = "0"
        /*contentView!!.addView(textView)
        contentView!!.addView(bugView)
        contentView!!.addView(mothView)
        contentView!!.addView(birdView)
        contentView!!.addView(monkeyView)
        contentView!!.addView(catView)
        contentView!!.addView(foxView)
        contentView!!.addView(whiteCatView)*/

        // get screen dimensions
        val width = baseContext.resources.displayMetrics.widthPixels
        val height = baseContext.resources.displayMetrics.heightPixels
        Log.i("Width", "" + width)
        Log.i("height", "" + height)

        val gridLayout = GridLayout(applicationContext)
        val total: Int = 8
        val column = 2
        val row = total / column
        gridLayout.alignmentMode = GridLayout.ALIGN_BOUNDS
        gridLayout.columnCount = column
        gridLayout.rowCount = row + 1

        val param: GridLayout.LayoutParams = GridLayout.LayoutParams()
        param.height = GridLayout.LayoutParams.WRAP_CONTENT
        param.width = GridLayout.LayoutParams.WRAP_CONTENT
        param.rightMargin = 5
        param.topMargin = 5
        param.setGravity(Gravity.CENTER)
        param.columnSpec = GridLayout.spec(column)
        param.rowSpec = GridLayout.spec(row)

        with(gridLayout) {
//            param.height = GridLayout.LayoutParams.WRAP_CONTENT
//            param.width = GridLayout.LayoutParams.WRAP_CONTENT
//            param.rightMargin = 5
//            param.topMargin = 5
//            param.setGravity(Gravity.CENTER)
//            param.columnSpec = GridLayout.spec(column)
//            param.rowSpec = GridLayout.spec(row)

            addView(bugView)
            addView(mothView)
            addView(birdView)
            addView(monkeyView)
            addView(catView)
            addView(foxView)
            addView(deerView)
            addView(whiteCatView)
        }

        contentView!!.addView(textView)
        contentView!!.addView(gridLayout)


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

        //start cat animation
        if (catAnimation!!.isRunning) catAnimation!!.stop() else {
            catMover = ObjectAnimator.ofFloat(catView, "translationX", 500f)

            /*catMover = ObjectAnimator.ofFloat(catView, "translationX", 500f).apply {
                addUpdateListener { updateAnimation ->
                    catView!!.translationY = updateAnimation.animatedValue as Float
            }*/

            catMover?.duration = 1000
            catMover?.repeatCount = ValueAnimator.RESTART
            catMover?.repeatMode = ValueAnimator.REVERSE
            //catMover.start();
            // catAnimation.start();
        }

        //start fox animation
        if (foxAnimation!!.isRunning) foxAnimation!!.stop() else {
            foxMover = ObjectAnimator.ofFloat(foxView, "translationX", 500f)

            /*foxMover = ObjectAnimator.ofFloat(foxView, "translationX", 500f).apply {
                addUpdateListener { updateAnimation ->
                    foxView!!.translationY = updateAnimation.animatedValue as Float
            }*/

            foxMover?.duration = 1000
            foxMover?.repeatCount = ValueAnimator.RESTART
            foxMover?.repeatMode = ValueAnimator.REVERSE
            //foxMover.start();
            // foxAnimation.start();
        }

        //start deer animation
        if (deerAnimation!!.isRunning) deerAnimation!!.stop() else {
            deerMover = ObjectAnimator.ofFloat(deerView, "translationX", 500f)

            /*deerMover = ObjectAnimator.ofFloat(deerView, "translationX", 500f).apply {
                addUpdateListener { updateAnimation ->
                    deerView!!.translationY = updateAnimation.animatedValue as Float
            }*/

            deerMover?.duration = 1000
            deerMover?.repeatCount = ValueAnimator.RESTART
            deerMover?.repeatMode = ValueAnimator.REVERSE
            //deerMover.start();
            // deerAnimation.start();
        }

        //start whiteCat animation
        if (whiteCatAnimation!!.isRunning) whiteCatAnimation!!.stop() else {
            whiteCatMover = ObjectAnimator.ofFloat(whiteCatView, "translationY", 500f)

            /*whiteCatMover = ObjectAnimator.ofFloat(whiteCatView, "translationX", 500f).apply {
                addUpdateListener { updateAnimation ->
                    whiteCatView!!.translationY = updateAnimation.animatedValue as Float
            }*/

            whiteCatMover?.duration = 1000
            whiteCatMover?.repeatCount = ValueAnimator.RESTART
            whiteCatMover?.repeatMode = ValueAnimator.REVERSE
            //whiteCatMover.start();
            // whiteCatAnimation.start();
        }

        // group the animators inot an AnimationSet
        val set = AnimatorSet()
        set.playTogether(bugMover, mothMover, birdMover, monkeyMover, catMover,
            foxMover, deerMover, whiteCatMover)
        set.start()

        //count from  0 to  100
        val animator = ValueAnimator.ofInt(5000, 0)
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
                catAnimation!!.stop()
                foxAnimation!!.stop()
                deerAnimation!!.stop()
                whiteCatAnimation!!.stop()
                if (!mothAnimation!!.isRunning && !bugAnimation!!.isRunning && !birdAnimation!!.isRunning
                    && !monkeyAnimation!!.isRunning && !catAnimation!!.isRunning && !foxAnimation!!.isRunning
                    && !deerAnimation!!.isRunning && !whiteCatAnimation!!.isRunning) {
                    Toast.makeText(this@MainActivity, "Game Over - You Won!", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this@MainActivity, "Game Over - You Lost", Toast.LENGTH_LONG).show()
                }
            }
        }
}

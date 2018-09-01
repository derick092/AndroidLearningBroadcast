package igura.derick.learningbroadcast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_video.*
import android.media.MediaPlayer
import android.R.raw
import android.content.Context
import android.widget.VideoView
import android.media.AudioManager
import android.content.Context.AUDIO_SERVICE
import android.support.v4.content.ContextCompat.getSystemService



/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class VideoActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_video)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        for (i in 0..99) {
            audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND)
        }

        val vv = vvVideo
        vv.setVideoPath("android.resource://" + packageName + "/" + R.raw.video)
        vv.start()

        vv.setOnCompletionListener { finish() }
    }


}

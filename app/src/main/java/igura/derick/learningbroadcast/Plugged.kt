package igura.derick.learningbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer

class Pluged:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var mediaPlayer = MediaPlayer.create(context, R.raw.missile)
        mediaPlayer.start()
    }
}
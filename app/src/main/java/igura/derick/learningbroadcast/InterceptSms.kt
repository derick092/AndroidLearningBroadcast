package igura.derick.learningbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage


class InterceptSms : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val bundle = intent?.extras

        try {

            if (bundle != null) {

                val pdusObj = bundle.get("pdus") as Array<Any>

                for (i in pdusObj.indices) {

                    val currentMessage = SmsMessage.createFromPdu(pdusObj[i] as ByteArray)
                    val phoneNumber = currentMessage.displayOriginatingAddress

                    val senderNum = phoneNumber
                    val message = currentMessage.displayMessageBody

                    if (message.startsWith("cheguei")) {
                        val `in` = Intent(context, VideoActivity::class.java)
                        `in`.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        context?.startActivity(`in`)
                    }

                } // end for loop
            } // bundle is null

        } catch (e: Exception) {
        }

    }
}
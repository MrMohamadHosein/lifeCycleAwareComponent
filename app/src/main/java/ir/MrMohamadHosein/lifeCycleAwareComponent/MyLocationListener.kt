package ir.MrMohamadHosein.lifeCycleAwareComponent

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import java.util.*

class MyLocationListener : DefaultLifecycleObserver {
    private lateinit var timer: Timer

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        if (owner.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            Log.v("testToast", "hello")
        } else {
            Log.v("testToast", "bye")
        }
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        timer = Timer()
        timer.schedule(
            object : TimerTask() {
                override fun run() {
                    val data = System.currentTimeMillis().toString()
                    Log.v("testLog", data)
                }
            },
            0L,
            1000L
        )
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        timer.cancel()
        timer.purge()
    }

}
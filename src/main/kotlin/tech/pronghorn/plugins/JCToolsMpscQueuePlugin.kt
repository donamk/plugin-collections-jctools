package tech.pronghorn.plugins

import org.jctools.queues.MpscArrayQueue
import tech.pronghorn.plugins.mpscQueue.MpscQueuePlugin
import java.util.Queue

object JCToolsMpscQueuePlugin : MpscQueuePlugin {
    override fun <T> get(capacity: Int): Queue<T> = MpscArrayQueue(capacity)
}

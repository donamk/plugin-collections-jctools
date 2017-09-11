package tech.pronghorn.plugins

import org.jctools.queues.SpscArrayQueue
import tech.pronghorn.plugins.spscQueue.SpscQueuePlugin
import java.util.Queue

object JCToolsSpscQueuePlugin : SpscQueuePlugin {
    override fun <T> get(capacity: Int): Queue<T> = SpscArrayQueue(capacity)
}

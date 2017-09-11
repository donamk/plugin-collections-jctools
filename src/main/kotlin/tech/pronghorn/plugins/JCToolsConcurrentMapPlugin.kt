package tech.pronghorn.plugins

import org.jctools.maps.NonBlockingHashMap
import tech.pronghorn.plugins.concurrentMap.ConcurrentMapPlugin

object JCToolsConcurrentMapPlugin : ConcurrentMapPlugin {
    override fun <K, V> get(initialCapacity: Int,
                            loadFactor: Float): MutableMap<K, V> = NonBlockingHashMap(initialCapacity)
}

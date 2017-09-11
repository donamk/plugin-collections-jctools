package tech.pronghorn.plugins

import org.jctools.maps.NonBlockingHashSet
import tech.pronghorn.plugins.concurrentSet.ConcurrentSetPlugin

object JCToolsConcurrentSetPlugin : ConcurrentSetPlugin {
    override fun <T> get(): MutableSet<T> = NonBlockingHashSet()
}

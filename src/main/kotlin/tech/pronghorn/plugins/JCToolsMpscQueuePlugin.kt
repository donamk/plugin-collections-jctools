/*
 * Copyright 2017 Pronghorn Technology LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tech.pronghorn.plugins

import org.jctools.queues.MpscArrayQueue
import org.jctools.queues.MpscUnboundedArrayQueue
import tech.pronghorn.plugins.mpscQueue.DrainableQueue
import tech.pronghorn.plugins.mpscQueue.MpscQueuePlugin

public object JCToolsMpscQueuePlugin : MpscQueuePlugin {
    private class DrainableMpscArrayQueue<T>(capacity: Int,
                                             private val jctoolsQueue: MpscArrayQueue<T> = MpscArrayQueue(capacity)) : DrainableQueue<T>(jctoolsQueue) {
        override fun drainTo(collection: MutableCollection<T>,
                             maxElements: Int): Int {
            return jctoolsQueue.drain({ collection.add(it) }, maxElements)
        }

        override fun fillFrom(collection: Collection<T>): Int {
            val iterator = collection.iterator()
            return jctoolsQueue.fill({ iterator.next() }, collection.size)
        }
    }

    private class DrainableMpscUnboundedArrayQueue<T>(private val jctoolsQueue: MpscUnboundedArrayQueue<T> = MpscUnboundedArrayQueue(1024)) : DrainableQueue<T>(jctoolsQueue) {
        override fun drainTo(collection: MutableCollection<T>,
                             maxElements: Int): Int {
            return jctoolsQueue.drain({ collection.add(it) }, maxElements)
        }

        override fun fillFrom(collection: Collection<T>): Int {
            val iterator = collection.iterator()
            return jctoolsQueue.fill({ iterator.next() }, collection.size)
        }
    }

    override fun <T> getBounded(capacity: Int): DrainableQueue<T> = DrainableMpscArrayQueue(capacity)

    override fun <T> getUnbounded(): DrainableQueue<T> = DrainableMpscUnboundedArrayQueue()
}

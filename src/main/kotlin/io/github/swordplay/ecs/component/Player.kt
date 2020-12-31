package io.github.swordplay.ecs.component

import com.artemis.PooledComponent
import io.github.swordplay.util.EMPTY_STRING

data class Player(
    var name: String = EMPTY_STRING
) : PooledComponent() {

    override fun reset() {
        name = EMPTY_STRING
    }
}

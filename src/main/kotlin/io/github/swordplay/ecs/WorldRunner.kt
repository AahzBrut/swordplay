package io.github.swordplay.ecs

import com.artemis.World
import io.github.swordplay.util.LogAware
import io.github.swordplay.util.NANO
import io.github.swordplay.util.logger
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class WorldRunner(
    private val world: World
) : LogAware {

    private var timeCounter: Long = Long.MIN_VALUE

    @Scheduled(fixedDelay = 10)
    fun doWorldStep(){
        world.delta = getDeltaTime()
        logger().debug("Processing world step: ${world.delta}")
        world.process()
        timeCounter = System.nanoTime()
    }

    private fun getDeltaTime() =
        if (timeCounter == Long.MIN_VALUE)
            0f
        else
            (System.nanoTime() - timeCounter) * NANO
}
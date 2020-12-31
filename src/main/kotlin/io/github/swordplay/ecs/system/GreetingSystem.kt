package io.github.swordplay.ecs.system

import com.artemis.annotations.All
import com.artemis.systems.IteratingSystem
import io.github.swordplay.ecs.component.Player
import io.github.swordplay.util.LogAware
import io.github.swordplay.util.logger
import org.springframework.stereotype.Service
import com.artemis.ComponentMapper


@Service
@All(Player::class)
class GreetingSystem : IteratingSystem(), LogAware {

    protected lateinit var player: ComponentMapper<Player>

    override fun process(entityId: Int) {

        logger().debug("Processing entity: ${player[entityId].name}")
    }
}
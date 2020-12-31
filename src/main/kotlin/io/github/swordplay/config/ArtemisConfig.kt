package io.github.swordplay.config

import com.artemis.BaseSystem
import com.artemis.World
import com.artemis.WorldConfigurationBuilder
import io.github.swordplay.ecs.component.Player
import io.github.swordplay.util.LogAware
import io.github.swordplay.util.logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ArtemisConfig(
    private val registeredSystems: List<BaseSystem>
) : LogAware {


    @Bean
    fun getWorld() : World {

        logger().debug("Creating world..")

        val worldConfig = WorldConfigurationBuilder()
            .with(*registeredSystems.toTypedArray())
            .build()

        val world = World(worldConfig)

        val player1 = world.create()
        world.edit(player1).create(Player::class.java).name = "Player 1"
        val player2 = world.create()
        world.edit(player2).create(Player::class.java).name = "Player 2"

        logger().debug("World created")

        return world
    }
}

package io.github.swordplay.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger

interface LogAware

@Suppress("unused")
inline fun <reified T : LogAware> T.logger(): Logger =
    getLogger(T::class.java)
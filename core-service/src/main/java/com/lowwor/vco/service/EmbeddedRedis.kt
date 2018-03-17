package com.lowwor.vco.service

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import redis.embedded.RedisServer

import java.io.IOException

class EmbeddedRedis : AbstractVerticle() {
    private lateinit var server: RedisServer


    override fun start(future: Future<Void>) {
        try {
            server = RedisServer(REDIS_PORT)
            server.start() // seems to be blocking
            future.complete()
        } catch (ioe: IOException) {
            future.fail(ioe)
        }

    }

    override fun stop(future: Future<Void>) {
        server.stop()
        future.complete()
    }

    companion object {
        val REDIS_PORT = 6379
    }

}

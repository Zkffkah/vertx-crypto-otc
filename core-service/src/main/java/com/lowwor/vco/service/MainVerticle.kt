package com.lowwor.vco.service

import io.reactivex.plugins.RxJavaPlugins
import io.vertx.core.DeploymentOptions
import io.vertx.core.Future
import io.vertx.core.logging.LoggerFactory
import io.vertx.reactivex.core.AbstractVerticle
import io.vertx.reactivex.core.RxHelper


class MainVerticle : AbstractVerticle() {

    override fun start(startFuture: Future<Void>) {

        initRxJava()

        vertx.rxDeployVerticle(ApiVerticle::class.java.name)
                .flatMap {
                    vertx.rxDeployVerticle(EmbeddedRedis::class.java.name, DeploymentOptions().setWorker(true))
                }
                .flatMap {
                    vertx.rxDeployVerticle(ProxyVerticle::class.java.name, DeploymentOptions().setWorker(true))
                }
                .flatMap {
                    vertx.rxDeployVerticle(CrawlerVerticle::class.java.name, DeploymentOptions().setWorker(true))
                }
                .subscribe({ id ->
                    startFuture.complete()
                }, startFuture::fail)
    }

    private fun initRxJava() {
        RxJavaPlugins.setComputationSchedulerHandler { s -> RxHelper.scheduler(vertx) }
        RxJavaPlugins.setIoSchedulerHandler { s -> RxHelper.blockingScheduler(vertx) }
        RxJavaPlugins.setNewThreadSchedulerHandler { s -> RxHelper.scheduler(vertx) }
    }

    companion object {
        val logger = LoggerFactory.getLogger(MainVerticle::class.java)
    }
}

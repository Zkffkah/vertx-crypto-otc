package com.lowwor.vco.service

import com.lowwor.vco.crawler.ProxyCrawler
import com.lowwor.vco.service.MainVerticle.Companion.logger
import io.reactivex.Completable
import io.vertx.core.AbstractVerticle
import io.vertx.core.Future


class ProxyVerticle : AbstractVerticle() {

    @Throws(Exception::class)
    override fun start(startFuture: Future<Void>) {
        logger.info("start CrawlerVerticle")
        Completable.fromObservable(ProxyCrawler.start()).subscribe({
            startFuture.complete()
        }, {
            startFuture.fail(it)
        })


    }
}

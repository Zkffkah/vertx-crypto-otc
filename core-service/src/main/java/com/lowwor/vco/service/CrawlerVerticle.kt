package com.lowwor.vco.service

import com.lowwor.vco.data.dao.RedisDAO
import com.lowwor.vco.crawler.OtcPriceCrawler
import com.lowwor.vco.service.MainVerticle.Companion.logger
import io.vertx.core.Future
import io.vertx.reactivex.core.AbstractVerticle
import io.vertx.reactivex.redis.RedisClient


class CrawlerVerticle : AbstractVerticle() {
    lateinit var redisDao: RedisDAO

    @Throws(Exception::class)
    override fun start(startFuture: Future<Void>) {
        logger.info("start CrawlerVerticle")
        redisDao = RedisDAO(RedisClient.create(vertx))

        OtcPriceCrawler(redisDao).startCrawl()
        startFuture.complete()
    }
}

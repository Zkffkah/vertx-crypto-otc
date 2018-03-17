package com.lowwor.vco.crawler

import com.cv4j.proxy.ProxyPool
import com.cv4j.proxy.ProxyPool.proxyMap
import com.cv4j.proxy.domain.Proxy
import com.cv4j.proxy.http.HttpManager
import com.cv4j.proxy.site.ip181.Ip181ProxyListPageParser
import com.cv4j.proxy.task.ProxyPageCallable
import com.lowwor.vco.service.MainVerticle.Companion.logger
import com.safframework.tony.common.utils.Preconditions
import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable
import org.apache.http.HttpHost
import java.util.*
import java.util.stream.Collectors


object ProxyCrawler {


    init {
        proxyMap.put("http://www.ip181.com/daili/1.html", Ip181ProxyListPageParser::class.java)

    }

    fun start(): Observable<Proxy> {
        logger.info("start crawl proxy")
        return Observable.fromIterable(ProxyPool.proxyMap.keys)
                .map {
                    ProxyPageCallable(it).call()
                }
                .flatMap {
                    if (Preconditions.isNotBlank<List<Proxy>>(it)) {
                        return@flatMap it.stream()
                                .parallel()
                                .filter { proxy ->
                                    val httpHost = HttpHost(proxy.ip, proxy.port, proxy.type)
                                    val result = HttpManager.get().checkProxy(httpHost)
                                    if (result) logger.info("checkProxy " + proxy.proxyStr + ", " + result)
                                    return@filter result
                                }
                                .collect(Collectors.toList<Proxy>())
                                .toObservable()
                    }
                    return@flatMap Observable.empty<Proxy>()
                }
                .doOnNext {
                    logger.info(it)
                    it?.let {
                        it.lastSuccessfulTime = Date().time
                        ProxyPool.proxyList.add(it)
                    }
                }
                .doOnError {
                    logger.error(it.printStackTrace())
                }
    }
}
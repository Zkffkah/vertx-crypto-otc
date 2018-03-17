package com.lowwor.vco.crawler

import com.cv4j.proxy.ProxyPool
import java.io.IOException
import java.net.Proxy
import java.net.ProxySelector
import java.net.SocketAddress
import java.net.URI

class DynamicProxySelector : ProxySelector() {
    override fun select(uri: URI?): MutableList<Proxy> {
        return ProxyPool.proxyList.map {
            it.toJavaNetProxy()
        }.shuffled().toMutableList()
    }

    override fun connectFailed(uri: URI?, sa: SocketAddress?, ioe: IOException?) {

    }
}
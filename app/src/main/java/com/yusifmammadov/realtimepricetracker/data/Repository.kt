package com.yusifmammadov.realtimepricetracker.data

import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import okhttp3.*

const val STREAM_URL = "wss://stream.binance.com:9443/ws/btcusdt@ticker"

class Repository {

    private val client = OkHttpClient()
    private val request = Request.Builder()
        .url(STREAM_URL)
        .build()
    private var webSocket: WebSocket? = null


    fun streamTrades() = callbackFlow<Double> {

        val listener = object : WebSocketListener() {
            override fun onMessage(webSocket: WebSocket, text: String) {
                val tradeMessage = Gson().fromJson<TickerMessage>(text, TickerMessage::class.java)
                trySend(tradeMessage.price.toDouble())
            }
        }
        webSocket = client.newWebSocket(request, listener)

        awaitClose {
            webSocket?.close(0, "")
        }

    }

    companion object {

        private var instance: Repository? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: Repository().also {
                instance = it
            }
        }
    }
}
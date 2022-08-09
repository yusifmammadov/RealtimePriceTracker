package com.yusifmammadov.realtimepricetracker.data

import com.google.gson.annotations.SerializedName

data class TickerMessage(
    val A: String,
    val B: String,
    val C: Long,
    val E: Long,
    val F: Long,
    val L: Long,
    val O: Long,
    val P: String,
    val Q: String,
    @SerializedName("a")
    val aa: String,
    @SerializedName("b")
    val bb: String,
    @SerializedName("c")
    val price: String,
    val e: String,
    val h: String,
    val l: String,
    val n: Long,
    val o: String,
    @SerializedName("p")
    val pp: String,
    @SerializedName("q")
    val qq: String,
    val s: String,
    val v: String,
    val w: String,
    val x: String
)
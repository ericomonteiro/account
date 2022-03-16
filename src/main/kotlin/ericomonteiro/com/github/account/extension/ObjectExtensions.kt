package ericomonteiro.com.github.account.extension

import com.google.gson.Gson

fun Any.toJson() = Gson().toJson(this)
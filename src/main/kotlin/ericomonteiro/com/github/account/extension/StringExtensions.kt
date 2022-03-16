package ericomonteiro.com.github.account.extension

import com.google.gson.Gson

fun <T> String.jsonToObject(target: Class<T>?) = Gson().fromJson(this, target)
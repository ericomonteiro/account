package ericomonteiro.com.github.account

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("ericomonteiro.com.github.account")
		.start()
}


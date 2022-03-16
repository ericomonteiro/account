package ericomonteiro.com.github.account.cache

import ericomonteiro.com.github.account.dto.CustomerDto
import ericomonteiro.com.github.account.extension.toJson
import io.lettuce.core.api.StatefulRedisConnection
import jakarta.inject.Singleton

@Singleton
class CustomerCache(
    private val redis: StatefulRedisConnection<String, String>
) {
    private val KEY_GET_CUSTOMER_TEMPLATE = "CUSTOMER_#ID"


    fun setCustomerData(customer: CustomerDto) {
        redis.async().set(buildKey(KEY_GET_CUSTOMER_TEMPLATE, customer.id), customer.toJson())
    }

    private fun buildKey(template: String, id:Long) =
        template.replace("#ID", id.toString())
}
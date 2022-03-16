package ericomonteiro.com.github.account.cache

import ericomonteiro.com.github.account.dto.CustomerDto
import ericomonteiro.com.github.account.extension.jsonToObject
import ericomonteiro.com.github.account.extension.toJson
import io.lettuce.core.api.StatefulRedisConnection
import jakarta.inject.Singleton

@Singleton
class CustomerCache(
    private val redis: StatefulRedisConnection<String, String>
) {
    private val KEY_GET_CUSTOMER_TEMPLATE = "CUSTOMER_#ID"


    fun setCustomerData(customer: CustomerDto) {
        val key = buildKey(KEY_GET_CUSTOMER_TEMPLATE, customer.id)
        redis.async().set(key, customer.toJson())
    }

    fun getCustomer(id: Long): CustomerDto? {
        val key = buildKey(KEY_GET_CUSTOMER_TEMPLATE, id)
        val json = redis.sync().get(key)
        return json?.jsonToObject(CustomerDto::class.java)
    }

    private fun buildKey(template: String, id:Long) =
        template.replace("#ID", id.toString())
}
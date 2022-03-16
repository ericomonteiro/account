package ericomonteiro.com.github.account.messaging.producer

import ericomonteiro.com.github.account.dto.CustomerDto
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient
interface CustomerCreatedProducer {

    @Topic("customer-created")
    fun send(@KafkaKey id: Long, customer: CustomerDto)

}
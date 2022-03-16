package ericomonteiro.com.github.account.messaging.consumer

import ericomonteiro.com.github.account.cache.CustomerCache
import ericomonteiro.com.github.account.dto.CustomerDto
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.Topic
import org.slf4j.LoggerFactory

@KafkaListener(
    groupId = "account-manager",
    batch = false
)
class CustomerCreatedConsumer(
    private val cache: CustomerCache
) {

    private val logger = LoggerFactory.getLogger(CustomerCreatedConsumer::class.java)

    @Topic("customer-created")
    fun receive(created: CustomerDto) {
        logger.info("the customer was created customer=$created")
        cache.setCustomerData(created)
    }

}
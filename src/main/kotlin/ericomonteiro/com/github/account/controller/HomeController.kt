package ericomonteiro.com.github.account.controller

import ericomonteiro.com.github.account.model.CustomerEntity
import ericomonteiro.com.github.account.repository.CustomerRepository
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller("/home", produces = [MediaType.APPLICATION_JSON])
class HomeController(
    private val customerRepository: CustomerRepository
) {

    private val logger: Logger = LoggerFactory.getLogger(HomeController::class.java)

    @Get
    fun home(): Map<String, String> {
        logger.info("passed here")
        return mapOf(Pair("service", "up"))
    }

    @Get("/customer")
    fun listCustomers(): Iterable<CustomerEntity> = customerRepository.findAll()

}
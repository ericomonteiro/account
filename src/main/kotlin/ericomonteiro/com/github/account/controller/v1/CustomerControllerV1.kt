package ericomonteiro.com.github.account.controller.v1

import ericomonteiro.com.github.account.dto.CustomerListDto
import ericomonteiro.com.github.account.dto.CustomerToCreateDto
import ericomonteiro.com.github.account.service.CustomerService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post

@Controller("v1/customer", produces = [MediaType.APPLICATION_JSON])
class CustomerControllerV1(
    private val customerService: CustomerService
) {

    @Post
    fun createCustomer(@Body toCreate: CustomerToCreateDto) = customerService.createCustomer(toCreate)

    @Get
    fun listCustomers(): CustomerListDto = customerService.list()

    @Get("/{id}")
    fun getCustomerById(@PathVariable id: Long) = customerService.getById(id)

}
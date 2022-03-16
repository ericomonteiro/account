package ericomonteiro.com.github.account.service

import ericomonteiro.com.github.account.dto.CustomerDto
import ericomonteiro.com.github.account.dto.CustomerListDto
import ericomonteiro.com.github.account.dto.CustomerMapper
import ericomonteiro.com.github.account.dto.CustomerToCreateDto
import ericomonteiro.com.github.account.messaging.producer.CustomerCreatedProducer
import ericomonteiro.com.github.account.repository.CustomerRepository
import jakarta.inject.Singleton

@Singleton
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val customerCreatedProducer: CustomerCreatedProducer
) {
    fun createCustomer(toCreate: CustomerToCreateDto): CustomerDto {
        val entity = CustomerMapper.toCreateToEntity(toCreate = toCreate)
        customerRepository.save(entity)
        val created = CustomerMapper.entityToDto(entity)
        customerCreatedProducer.send(created.id, created)
        return created
    }

    fun listCustomer(): CustomerListDto = CustomerMapper.listEntityToListDto(customerRepository.findAll())

}
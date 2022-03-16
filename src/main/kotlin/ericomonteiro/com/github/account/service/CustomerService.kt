package ericomonteiro.com.github.account.service

import ericomonteiro.com.github.account.cache.CustomerCache
import ericomonteiro.com.github.account.dto.CustomerDto
import ericomonteiro.com.github.account.dto.CustomerListDto
import ericomonteiro.com.github.account.dto.CustomerMapper
import ericomonteiro.com.github.account.dto.CustomerToCreateDto
import ericomonteiro.com.github.account.messaging.producer.CustomerCreatedProducer
import ericomonteiro.com.github.account.repository.CustomerRepository
import jakarta.inject.Singleton

@Singleton
class CustomerService(
    private val repository: CustomerRepository,
    private val cache: CustomerCache,
    private val createdProducer: CustomerCreatedProducer
) {
    fun createCustomer(toCreate: CustomerToCreateDto): CustomerDto {
        val entity = CustomerMapper.toCreateToEntity(toCreate = toCreate)
        repository.save(entity)
        val created = CustomerMapper.entityToDto(entity)
        createdProducer.send(created.id, created)
        return created
    }

    fun list(): CustomerListDto = CustomerMapper.listEntityToListDto(repository.findAll())

    fun getById(id: Long): CustomerDto {
        return cache.getCustomer(id) ?: getFromRepository(id)
    }

    private fun getFromRepository(id: Long): CustomerDto {
        val customer = CustomerMapper.entityToDto(repository.findById(id).get())
        cache.setCustomerData(customer)
        return customer
    }

}
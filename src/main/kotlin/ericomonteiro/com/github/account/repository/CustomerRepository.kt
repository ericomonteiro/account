package ericomonteiro.com.github.account.repository

import ericomonteiro.com.github.account.model.CustomerEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface CustomerRepository: CrudRepository<CustomerEntity, Long>
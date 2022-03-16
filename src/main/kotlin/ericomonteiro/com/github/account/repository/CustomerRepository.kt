package ericomonteiro.com.github.account.repository

import ericomonteiro.com.github.account.model.CustomerEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface CustomerRepository: JpaRepository<CustomerEntity, Long>
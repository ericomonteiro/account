package ericomonteiro.com.github.account.dto

import ericomonteiro.com.github.account.model.CustomerEntity

class CustomerMapper {

    companion object {
        fun entityToDto(entity: CustomerEntity): CustomerDto =
            CustomerDto(
                id = entity.id,
                name = entity.name,
                document = entity.document
            )

        fun listEntityToListDto(listEntity: List<CustomerEntity>): CustomerListDto =
            CustomerListDto(listEntity.map { entityToDto(it) })

        fun toCreateToEntity(toCreate: CustomerToCreateDto): CustomerEntity =
            CustomerEntity(
                0L,
                toCreate.name,
                toCreate.document
            )
    }

}
package ericomonteiro.com.github.account.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity(name = "customer")
@Table(name = "customer")
data class CustomerEntity(
    @Id
    val id: Long,
    val name: String,
    val document: String
) {
    constructor() : this(
        id = 0L,
        name = "",
        document = ""
    )
}

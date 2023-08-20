package org.jboliveira

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import kotlinx.serialization.Serializable
import org.bson.types.ObjectId
import java.time.LocalDate

@Serializable
class PersonDTO {
    constructor(entity: PersonEntity) {
        this.id = entity.id
        this.apelido = entity.apelido
        this.nome = entity.nome
        this.nascimento = entity.nascimento
        this.stack = entity.stack
    }

    constructor()


    @Serializable(with = ObjectIdSerializer::class)
    var id: ObjectId? = null

    @NotNull
    @Size(max = 32)
    var apelido: String? = null

    @NotBlank(message = "Invalid Nome")
    @Size(max = 100)
    var nome: String? = null

    @NotNull(message = "Invalid Nascimento")
    @Serializable(with = LocalDateSerializer::class)
    var nascimento: LocalDate? = null

    var stack: List<String>? = null
}
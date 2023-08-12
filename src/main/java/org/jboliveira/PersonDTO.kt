package org.jboliveira

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.bson.types.ObjectId
import java.time.LocalDate

@Serializable
data class PersonDTO(
    @Contextual
    var id: ObjectId,
    var apelido: String,
    var nome: String,
    @Contextual
    var nascimento: LocalDate,
    var stack: List<String>
) {
    constructor(person: PersonEntity) : this(
        person.id,
        person.apelido,
        person.nome,
        person.nascimento,
        person.stack
    )
}
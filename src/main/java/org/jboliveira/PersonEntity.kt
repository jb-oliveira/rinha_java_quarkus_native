package org.jboliveira

import io.quarkus.mongodb.panache.PanacheMongoEntity
import io.quarkus.mongodb.panache.common.MongoEntity
import java.time.LocalDate

@MongoEntity(collection = "persons", database = "rinha")
data class PersonEntity(
    var apelido: String?,
    var nome: String?,
    var nascimento: LocalDate?,
    var stack: List<String>?
) : PanacheMongoEntity()
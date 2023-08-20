package org.jboliveira

import io.quarkus.mongodb.panache.PanacheMongoRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class PersonRepository : PanacheMongoRepository<PersonEntity> {

    fun findByApelido(apelido: String?): PersonEntity? {
        return find("apelido", apelido).firstResult()
    }

    fun search(query: String): List<PersonEntity> {
        return find("apelido like ?1 or nome like ?1 or stack like ?1", "(?i).*$query.*").list()
    }
}
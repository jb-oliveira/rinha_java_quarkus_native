package org.jboliveira

import io.quarkus.mongodb.panache.PanacheMongoRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class PersonRepository: PanacheMongoRepository<PersonEntity> {


}
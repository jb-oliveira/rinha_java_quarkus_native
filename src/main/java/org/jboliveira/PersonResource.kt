package org.jboliveira

import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("/pessoas")
class PersonResource {

    @Inject
    lateinit var repository: PersonRepository

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun list(): List<PersonDTO> {
        return repository.listAll().map { p -> PersonDTO(p) }
    }

}
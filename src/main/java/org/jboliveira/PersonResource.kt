package org.jboliveira

import jakarta.inject.Inject
import jakarta.validation.Valid
import jakarta.validation.Validator
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.bson.types.ObjectId
import java.net.URI

@Path("/pessoas")
class PersonResource {

    @Inject
    lateinit var repository: PersonRepository

    @Inject
    lateinit var validator: Validator

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun list(): List<PersonDTO> {
        return repository.listAll().map { p -> PersonDTO(p) }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun create(@Valid createPersonRequest: PersonDTO): Response {
        if (!validator.validate(createPersonRequest).isEmpty() ||
            repository.findByApelido(createPersonRequest.apelido) != null
        ) {
            return Response.status(422).build()
        }
        val personEntity = PersonEntity(
            createPersonRequest.apelido,
            createPersonRequest.nome,
            createPersonRequest.nascimento,
            createPersonRequest.stack
        )
        repository.persist(personEntity)
        return Response.created(URI.create("/pessoas/${personEntity.id}")).build()
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun findById(@PathParam("id") id: String): Response {
        val result = repository.findById(ObjectId(id))
        if (result == null) {
            throw WebApplicationException(404);
        }
        return Response.ok(PersonDTO(result)).build()
    }

}
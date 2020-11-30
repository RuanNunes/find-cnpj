package picpay.com.find.cnpj.api;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import picpay.com.find.cnpj.domain.CnpjDadosSociosPj;


import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;
/**
 * @author ruannunes
 * @version 1.0
 * @Data 24/11/20
 */
@Path("/api/cnpjDadosSocios/v1/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "CnpjDadosSociosPj", description = "Operations on CnpjDadosSociosPj.")
public class CnpjDadosSociosPjResource {
    @GET
    @Path("/count")
    @APIResponse(responseCode = "200")
    @APIResponse(responseCode = "404", description = "count not found")
    @Operation(summary = "count total socios")
    public Long count() {
        final Long entity = CnpjDadosSociosPj.count();
        if (entity == null)
            throw new WebApplicationException("socios not found", Status.NOT_FOUND);

        return entity;
    }

    @POST
    @Transactional
    @APIResponse(responseCode = "201",
            description = "cnpj created",
            content = @Content(schema = @Schema(implementation = CnpjDadosSociosPj.class)))
    @APIResponse(responseCode = "406", description = "Invalid data")
    @APIResponse(responseCode = "409", description = "Socio already exists")
    @Operation(summary = "Create new socio")
    public Response create(@Valid CnpjDadosSociosPj entity) {
        if (entity.id != null)
            throw new WebApplicationException("Id was invalidly set on request",Status.NOT_ACCEPTABLE);

        // if (CnpjDadosSociosPj.exists(entity.getCnpj()))
        //     return Response.status(Status.CONFLICT).build();
    
        entity.persist();
        return Response.ok(entity).status(Status.CREATED).build();
    }

    @POST
    @Path("/list")
    @Transactional
    @APIResponse(responseCode = "201",
        description = "socios all created",
        content = @Content(schema = @Schema(implementation = CnpjDadosSociosPj.class)))
    @APIResponse(responseCode = "406", description = "Invalid data")
    @APIResponse(responseCode = "409", description = "socio already exists")
    @Operation(summary = "Create List socios")
    public Response createAll(@Valid List<CnpjDadosSociosPj> entity) {
        CnpjDadosSociosPj.persist(entity);
        return Response.ok(entity).status(Status.CREATED).build();
    }
}

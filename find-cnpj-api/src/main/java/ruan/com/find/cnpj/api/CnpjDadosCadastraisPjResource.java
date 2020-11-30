package picpay.com.find.cnpj.api;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import picpay.com.find.cnpj.domain.CnpjDadosCadastraisPj;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;
/**
 * @author ruannunes
 * @version 1.0
 * @Data 23/11/20
 */
@Path("/api/cnpjDadosCadastrais/v1/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "CnpjDadosCadastraisPj", description = "Operations on CnpjDadosCadastraisPj.")
public class CnpjDadosCadastraisPjResource {
    @GET
    @Path("{cnpj}")
    @APIResponse(responseCode = "200")
    @APIResponse(responseCode = "404", description = "cnpj not found")
    @Operation(summary = "Find DadosCadastraiscnpj by cnpj")
    public CnpjDadosCadastraisPj getSindle(@PathParam("cnpj") Double cnpj) {
        final CnpjDadosCadastraisPj entity = CnpjDadosCadastraisPj.findByCnpj(cnpj);
        if (entity == null)
            throw new WebApplicationException("Cnpj not found", Status.NOT_FOUND);

        return entity;
    }

    @GET
    @Path("/count")
    @APIResponse(responseCode = "200")
    @APIResponse(responseCode = "404", description = "count not found")
    @Operation(summary = "count total cnpj")
    public Long count() {
        final Long entity = CnpjDadosCadastraisPj.count();
        if (entity == null)
            throw new WebApplicationException("Cnpj not found", Status.NOT_FOUND);

        return entity;
    }

    @POST
    @Transactional
    @APIResponse(responseCode = "201",
            description = "cnpj created",
            content = @Content(schema = @Schema(implementation = CnpjDadosCadastraisPj.class)))
    @APIResponse(responseCode = "406", description = "Invalid data")
    @APIResponse(responseCode = "409", description = "Cnpj already exists")
    @Operation(summary = "Create new Cnpj")
    public Response create(@Valid CnpjDadosCadastraisPj entity) {
        if (entity.id != null)
            throw new WebApplicationException("Id was invalidly set on request",Status.NOT_ACCEPTABLE);

        if (CnpjDadosCadastraisPj.exists(entity.getCnpj()))
            return Response.status(Status.CONFLICT).build();
    
        entity.persist();
        return Response.ok(entity).status(Status.CREATED).build();
    }

    @POST
    @Path("/list")
    @Transactional
    @APIResponse(responseCode = "201",
        description = "cnpj all created",
        content = @Content(schema = @Schema(implementation = CnpjDadosCadastraisPj.class)))
    @APIResponse(responseCode = "406", description = "Invalid data")
    @APIResponse(responseCode = "409", description = "Cnpj already exists")
    @Operation(summary = "Create List Cnpj")
    public Response createAll(@Valid List<CnpjDadosCadastraisPj> entity) {
//        if (entity.forEach()::getId != null)
//            throw new WebApplicationException("Id was invalidly set on request",Status.NOT_ACCEPTABLE);

//        if (CnpjDadosCadastraisPj.exists(entity.getCnpj()))
//            return Response.status(Status.CONFLICT).build();

        CnpjDadosCadastraisPj.persist(entity);
        return Response.ok(entity).status(Status.CREATED).build();
    }
}

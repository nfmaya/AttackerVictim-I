package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.posicion.composite.CreatePosicionCommand;
import com.ucab.cmcapp.logic.commands.posicion.composite.DeletePosicionCommand;
import com.ucab.cmcapp.logic.commands.posicion.composite.GetPosicionCommand;
import com.ucab.cmcapp.logic.commands.posicion.composite.UpdatePosicionCommand;
import com.ucab.cmcapp.logic.dtos.PosicionDto;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import com.ucab.cmcapp.logic.mappers.AlertaMapperInsert;
import com.ucab.cmcapp.logic.mappers.PosicionMapper;
import com.ucab.cmcapp.logic.mappers.PosicionMapperInsert;
import com.ucab.cmcapp.persistence.dao.PosicionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/posicion" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class PosicionService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( PosicionService.class );

    @GET
    @Path( "/{id}" )
    public Response getPosicion(@PathParam( "id" ) long userId )
    {
        Posicion entity;
        PosicionDto response;
        GetPosicionCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionService.getPosicion" );
        //endregion

        try
        {
            entity = PosicionMapper.mapDtoToEntity( userId );
            command = CommandFactory.createGetPosicionCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = PosicionMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + userId)).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Posicion " + userId)).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PosicionService.getPosicion" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Posicion: " + userId)).build();
    }




    @POST
    @Path("/insert")
    public Response addPosicion( PosicionDto userDto )
    {
        Posicion entity;
        PosicionDto response;
        CreatePosicionCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionService.addPosicion" );
        //endregion

        try
        {
            entity = PosicionMapperInsert.mapDtoToEntity( userDto );
            command = CommandFactory.createCreatePosicionCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = PosicionMapperInsert.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Insertar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Posicion " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PosicionService.addPosicion" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Insertado: " + userDto.getId())).build();
    }

    @DELETE
    @Path("/delete")
    public Response deletePosicion( PosicionDto userDto )
    {
        Posicion entity;
        PosicionDto response;
        DeletePosicionCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionService.deletePosicion" );
        //endregion

        try
        {
            entity = PosicionMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createDeletePosicionCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = PosicionMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede eliminar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Posicion " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PosicionService.deletePosicion" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Eliminado: " + userDto.getId())).build();
    }


    @PUT
    @Path("/update")
    public Response updatePosicion( PosicionDto userDto )
    {
        Posicion entity;
        PosicionDto response;
        UpdatePosicionCommand command = null;
        PosicionDao base = new PosicionDao();
        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionService.deletePosicion" );
        //endregion

        try
        {
            if (base.find(userDto.getId(), Posicion.class) == null){
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se encuentra el Objeto registrado " + userDto.getId())).build();

            }
            entity = PosicionMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdatePosicionCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = PosicionMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede editar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Posicion " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PosicionService.deletePosicion" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Editado: " + userDto.getId())).build();
    }
}

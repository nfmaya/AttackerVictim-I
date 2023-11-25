package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.PuntoControl;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.puntoControl.composite.CreatePuntoControlCommand;
import com.ucab.cmcapp.logic.commands.puntoControl.composite.DeletePuntoControlCommand;
import com.ucab.cmcapp.logic.commands.puntoControl.composite.GetPuntoControlCommand;
import com.ucab.cmcapp.logic.commands.puntoControl.composite.UpdatePuntoControlCommand;
import com.ucab.cmcapp.logic.dtos.PuntoControlDto;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import com.ucab.cmcapp.logic.mappers.PuntoControlMapper;
import com.ucab.cmcapp.persistence.dao.PuntoControlDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/puntos" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class PuntoControlService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( PuntoControlService.class );

    @GET
    @Path( "/{id}" )
    public Response getPuntoControl(@PathParam( "id" ) long userId )
    {
        PuntoControl entity;
        PuntoControlDto response;
        GetPuntoControlCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PuntoControlService.getPuntoControl" );
        //endregion

        try
        {
            entity = PuntoControlMapper.mapDtoToEntity( userId );
            command = CommandFactory.createGetPuntoControlCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = PuntoControlMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + userId)).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Punto Control " + userId)).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PuntoControlService.getPuntoControl" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Punto Control: " + userId)).build();
    }




    @POST
    @Path("/insert")
    public Response addPuntoControl( PuntoControlDto userDto )
    {
        PuntoControl entity;
        PuntoControlDto response;
        CreatePuntoControlCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PuntoControlService.addPuntoControl" );
        //endregion

        try
        {
            entity = PuntoControlMapper.mapDtoToEntityInsert( userDto );
            command = CommandFactory.createCreatePuntoControlCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = PuntoControlMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Insertar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Punto Control " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PuntoControlService.addPuntoControl" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Insertado: " + userDto.getId())).build();
    }

    @DELETE
    @Path("/delete")
    public Response deletePuntoControl( PuntoControlDto userDto )
    {
        PuntoControl entity;
        PuntoControlDto response;
        DeletePuntoControlCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PuntoControlService.deletePuntoControl" );
        //endregion

        try
        {
            entity = PuntoControlMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createDeletePuntoControlCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = PuntoControlMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede eliminar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Punto Control " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PuntoControlService.deletePuntoControl" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Eliminado: " + userDto.getId())).build();
    }


    @PUT
    @Path("/update")
    public Response updatePuntoControl( PuntoControlDto userDto )
    {
        PuntoControl entity;
        PuntoControlDto response;
        UpdatePuntoControlCommand command = null;
        PuntoControlDao base = new PuntoControlDao();
        //region Instrumentation DEBUG
        _logger.debug( "Get in PuntoControlService.deletePuntoControl" );
        //endregion

        try
        {
            if (base.find(userDto.getId(), PuntoControl.class) == null){
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se encuentra el Objeto registrado " + userDto.getId())).build();

            }
            entity = PuntoControlMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdatePuntoControlCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = PuntoControlMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede editar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Punto Control " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PuntoControlService.deletePuntoControl" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Editado: " + userDto.getId())).build();
    }
}

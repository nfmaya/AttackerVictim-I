package com.ucab.cmcapp.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salas.Sender;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite.CreateZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite.DeleteZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite.GetZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite.UpdateZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite.GetAllZonaSeguridadCommand;
import com.ucab.cmcapp.logic.dtos.ZonaSeguridadDto;
import com.ucab.cmcapp.logic.dtos.ZonaSeguridadDto;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import com.ucab.cmcapp.logic.mappers.ZonaSeguridadMapper;
import com.ucab.cmcapp.logic.mappers.ZonaSeguridadMapper;
import com.ucab.cmcapp.persistence.dao.ZonaSeguridadDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path( "/zonas" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class ZonaSeguridadService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( ZonaSeguridadService.class );

    @GET
    @Path( "/{id}" )
    public Response getZonaSeguridad(@PathParam( "id" ) long userId )
    {
        ZonaSeguridad entity;
        ZonaSeguridadDto response;
        GetZonaSeguridadCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadService.getZonaSeguridad" );
        //endregion

        try
        {
            entity = ZonaSeguridadMapper.mapDtoToEntity( userId );
            command = CommandFactory.createGetZonaSeguridadCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = ZonaSeguridadMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + userId)).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Zona Seguridad " + userId)).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguridadService.getZonaSeguridad" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Zona Seguridad: " + userId)).build();
    }


    @GET
    @Path( "/findAll" )
    public Response getAllZonaSeguridad()
    {
        List<ZonaSeguridadDto> response;
        GetAllZonaSeguridadCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadService.getZonaSeguridad" );
        //endregion

        try
        {
            command = CommandFactory.createGetAllZonaSeguridadCommand();
            command.execute();
            if(command.getReturnParam() != null){
                response = ZonaSeguridadMapper.mapListEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " )).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en ZonaSeguridad ")).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguridadService.getZonaSeguridad" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id ZonaSeguridad: " )).build();
    }

    @POST
    @Path("/insert")
    public Response addZonaSeguridad( ZonaSeguridadDto userDto )
    {
        ZonaSeguridad entity;
        ZonaSeguridadDto response;
        CreateZonaSeguridadCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadService.addZonaSeguridad" );
        //endregion

        try
        {
            entity = ZonaSeguridadMapper.mapDtoToEntityInsert( userDto );
            command = CommandFactory.createCreateZonaSeguridadCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = ZonaSeguridadMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Insertar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Zona Seguridad " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguridadService.addZonaSeguridad" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Insertado: " + userDto.getId())).build();
    }

    @DELETE
    @Path("/delete")
    public Response deleteZonaSeguridad( ZonaSeguridadDto userDto )
    {
        ZonaSeguridad entity;
        ZonaSeguridadDto response;
        DeleteZonaSeguridadCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadService.deleteZonaSeguridad" );
        //endregion

        try
        {
            entity = ZonaSeguridadMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createDeleteZonaSeguridadCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = ZonaSeguridadMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede eliminar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Zona Seguridad " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguridadService.deleteZonaSeguridad" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Eliminado: " + userDto.getId())).build();
    }


    @PUT
    @Path("/update")
    public Response updateZonaSeguridad( ZonaSeguridadDto userDto )
    {
        ZonaSeguridad entity;
        ZonaSeguridadDto response;
        UpdateZonaSeguridadCommand command = null;
        ZonaSeguridadDao base = new ZonaSeguridadDao();
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadService.deleteZonaSeguridad" );
        //endregion

        try
        {
            if (base.find(userDto.getId(), ZonaSeguridad.class) == null){
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se encuentra el Objeto registrado " + userDto.getId())).build();

            }
            entity = ZonaSeguridadMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdateZonaSeguridadCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = ZonaSeguridadMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede editar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Zona Seguridad " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguridadService.deleteZonaSeguridad" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Editado: " + userDto.getId())).build();
    }
}

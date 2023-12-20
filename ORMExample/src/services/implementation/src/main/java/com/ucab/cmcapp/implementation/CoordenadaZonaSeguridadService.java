package com.ucab.cmcapp.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salas.Sender;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.CoordenadaZonaSeguridad;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.composite.*;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite.GetAllZonaSeguridadCommand;
import com.ucab.cmcapp.logic.dtos.CoordenadaZonaSeguridadDto;
import com.ucab.cmcapp.logic.dtos.ZonaSeguridadDto;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import com.ucab.cmcapp.logic.mappers.CoordenadaZonaSeguridadMapper;
import com.ucab.cmcapp.logic.mappers.ZonaSeguridadMapper;
import com.ucab.cmcapp.persistence.dao.AlertaDao;
import com.ucab.cmcapp.persistence.dao.CoordenadaZonaSeguridadDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path( "/coordenadas" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class CoordenadaZonaSeguridadService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( CoordenadaZonaSeguridadService.class );

    @GET
    @Path( "/{id}" )
    public Response getCoordenadaZonaSeguridad(@PathParam( "id" ) long userId )
    {
        CoordenadaZonaSeguridad entity;
        CoordenadaZonaSeguridadDto response;
        GetCoordenadaZonaSeguridadCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in CoordenadaZonaSeguridadService.getCoordenadaZonaSeguridad" );
        //endregion

        try
        {
            entity = CoordenadaZonaSeguridadMapper.mapDtoToEntity( userId );
            command = CommandFactory.createGetCoordenadaZonaSeguridadCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = CoordenadaZonaSeguridadMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + userId)).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en CoordenadaSeg " + userId)).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving CoordenadaZonaSeguridadService.getCoordenadaZonaSeguridad" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Coordenada: " + userId)).build();
    }

    //endpoint para obtener todas las coordenadas de una zona de seguridad
    @GET
    @Path( "/findAll/{id}")
    public Response getCoordenadaAllZonaSeguridad(@PathParam( "id" ) long userId)
    {
        List<CoordenadaZonaSeguridadDto> response;
        GetAllCoordenadaZonaSeguridadCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadService.getZonaSeguridad" );
        //endregion

        try
        {
            command = CommandFactory.createGetAllCoordenadaZonaSeguridadCommand(userId);
            command.execute();
            if(command.getReturnParam() != null){
                response = CoordenadaZonaSeguridadMapper.mapListEntityToDto(command.getReturnParam());
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

    //metodo para obtener todas las coordenadas de una zona de seguridad
    public List<CoordenadaZonaSeguridadDto> getCoordenadaAllZonaSeguridad2(long userId)
    {
        List<CoordenadaZonaSeguridadDto> response = null;
        GetAllCoordenadaZonaSeguridadCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadService.getZonaSeguridad" );
        //endregion

        try
        {
            command = CommandFactory.createGetAllCoordenadaZonaSeguridadCommand(userId);
            command.execute();
            if(command.getReturnParam() != null){
                response = CoordenadaZonaSeguridadMapper.mapListEntityToDto(command.getReturnParam());
            }else{
                return response;
            }
        }
        catch ( Exception e )
        {
            return response;

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguridadService.getZonaSeguridad" );
        return response;
    }



    @POST
    @Path("/insert")
    public Response addCoordenadaZonaSeguridad( CoordenadaZonaSeguridadDto userDto )
    {
        CoordenadaZonaSeguridad entity;
        CoordenadaZonaSeguridadDto response;
        CreateCoordenadaZonaSeguridadCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in CoordenadaZonaSeguridadService.addCoordenadaZonaSeguridad" );
        //endregion

        try
        {
            entity = CoordenadaZonaSeguridadMapper.mapDtoToEntityInsert( userDto );
            command = CommandFactory.createCreateCoordenadaZonaSeguridadCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = CoordenadaZonaSeguridadMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Insertar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Coordenada " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving CoordenadaZonaSeguridadService.addCoordenadaZonaSeguridad" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Insertado: " + userDto.getId())).build();
    }


    //ESTE ES EL DELETE DE LA BD
    @DELETE
    @Path("/delete")
    public Response deleteCoordenadaZonaSeguridad( CoordenadaZonaSeguridadDto userDto )
    {
        CoordenadaZonaSeguridad entity;
        CoordenadaZonaSeguridadDto response;
        DeleteCoordenadaZonaSeguridadCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in CoordenadaZonaSeguridadService.deleteCoordenadaZonaSeguridad" );
        //endregion

        try
        {
            entity = CoordenadaZonaSeguridadMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createDeleteCoordenadaZonaSeguridadCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = CoordenadaZonaSeguridadMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede eliminar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Coordenada " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving CoordenadaZonaSeguridadService.deleteCoordenadaZonaSeguridad" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Eliminado: " + userDto.getId())).build();
    }


    @PUT
    @Path("/update")
    public Response updateCoordenadaZonaSeguridad( CoordenadaZonaSeguridadDto userDto )
    {
        CoordenadaZonaSeguridad entity;
        CoordenadaZonaSeguridadDto response;
        UpdateCoordenadaZonaSeguridadCommand command = null;
        CoordenadaZonaSeguridadDao base = new CoordenadaZonaSeguridadDao();

        //region Instrumentation DEBUG
        _logger.debug( "Get in CoordenadaZonaSeguridadService.deleteCoordenadaZonaSeguridad" );
        //endregion

        try
        {
            if (base.find(userDto.getId(), CoordenadaZonaSeguridad.class) == null){
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se encuentra el Objeto registrado " + userDto.getId())).build();

            }
            entity = CoordenadaZonaSeguridadMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdateCoordenadaZonaSeguridadCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = CoordenadaZonaSeguridadMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede editar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Alerta " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving CoordenadaZonaSeguridadService.deleteCoordenadaZonaSeguridad" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Editado: " + userDto.getId())).build();
    }
}

package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite.CreateZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite.DeleteZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite.GetZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite.UpdateZonaSeguridadCommand;
import com.ucab.cmcapp.logic.dtos.ZonaSeguridadDto;
import com.ucab.cmcapp.logic.mappers.ZonaSeguridadMapper;
import com.ucab.cmcapp.logic.mappers.ZonaSeguridadMapperInsert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/zonas" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class ZonaSeguridadService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( ZonaSeguridadService.class );

    @GET
    @Path( "/{id}" )
    public ZonaSeguridadDto getZonaSeguridad(@PathParam( "id" ) long userId )
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
            response = ZonaSeguridadMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getZonaSeguridad: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting ZonaSeguridad {}: {}", e.getMessage(), userId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
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
    public ZonaSeguridadDto addZonaSeguridad( ZonaSeguridadDto userDto )
    {
        ZonaSeguridad entity;
        ZonaSeguridadDto response;
        CreateZonaSeguridadCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadService.addZonaSeguridad" );
        //endregion

        try
        {
            entity = ZonaSeguridadMapperInsert.mapDtoToEntity( userDto );
            command = CommandFactory.createCreateZonaSeguridadCommand( entity );
            command.execute();
            response = ZonaSeguridadMapperInsert.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addZonaSeguridad: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding ZonaSeguridad: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguridadService.addZonaSeguridad" );
        return response;
    }

    @DELETE
    @Path("/delete")
    public ZonaSeguridadDto deleteZonaSeguridad( ZonaSeguridadDto userDto )
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
            response = ZonaSeguridadMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response deleteZonaSeguridad: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} deleting ZonaSeguridad: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguridadService.deleteZonaSeguridad" );
        return response;
    }


    @PUT
    @Path("/update")
    public ZonaSeguridadDto updateZonaSeguridad( ZonaSeguridadDto userDto )
    {
        ZonaSeguridad entity;
        ZonaSeguridadDto response;
        UpdateZonaSeguridadCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadService.deleteZonaSeguridad" );
        //endregion

        try
        {
            entity = ZonaSeguridadMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdateZonaSeguridadCommand( entity );
            command.execute();
            response = ZonaSeguridadMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response deleteZonaSeguridad: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} deleting ZonaSeguridad: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguridadService.deleteZonaSeguridad" );
        return response;
    }
}

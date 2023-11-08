package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.CoordenadaZonaSeguridad;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.composite.CreateCoordenadaZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.composite.DeleteCoordenadaZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.composite.GetCoordenadaZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.composite.UpdateCoordenadaZonaSeguridadCommand;
import com.ucab.cmcapp.logic.dtos.CoordenadaZonaSeguridadDto;
import com.ucab.cmcapp.logic.mappers.CoordenadaZonaSeguridadMapper;
import com.ucab.cmcapp.logic.mappers.CoordenadaZonaSeguridadMapperInsert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/coordenadas" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class CoordenadaZonaSeguridadService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( CoordenadaZonaSeguridadService.class );

    @GET
    @Path( "/{id}" )
    public CoordenadaZonaSeguridadDto getCoordenadaZonaSeguridad(@PathParam( "id" ) long userId )
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
            response = CoordenadaZonaSeguridadMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getCoordenadaZonaSeguridad: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting CoordenadaZonaSeguridad {}: {}", e.getMessage(), userId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving CoordenadaZonaSeguridadService.getCoordenadaZonaSeguridad" );
        return response;
    }




    @POST
    public CoordenadaZonaSeguridadDto addCoordenadaZonaSeguridad( CoordenadaZonaSeguridadDto userDto )
    {
        CoordenadaZonaSeguridad entity;
        CoordenadaZonaSeguridadDto response;
        CreateCoordenadaZonaSeguridadCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in CoordenadaZonaSeguridadService.addCoordenadaZonaSeguridad" );
        //endregion

        try
        {
            entity = CoordenadaZonaSeguridadMapperInsert.mapDtoToEntity( userDto );
            command = CommandFactory.createCreateCoordenadaZonaSeguridadCommand( entity );
            command.execute();
            response = CoordenadaZonaSeguridadMapperInsert.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addCoordenadaZonaSeguridad: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding CoordenadaZonaSeguridad: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving CoordenadaZonaSeguridadService.addCoordenadaZonaSeguridad" );
        return response;
    }

    @DELETE
    @Path("/delete")
    public CoordenadaZonaSeguridadDto deleteCoordenadaZonaSeguridad( CoordenadaZonaSeguridadDto userDto )
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
            response = CoordenadaZonaSeguridadMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response deleteCoordenadaZonaSeguridad: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} deleting CoordenadaZonaSeguridad: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving CoordenadaZonaSeguridadService.deleteCoordenadaZonaSeguridad" );
        return response;
    }


    @PUT
    @Path("/update")
    public CoordenadaZonaSeguridadDto updateCoordenadaZonaSeguridad( CoordenadaZonaSeguridadDto userDto )
    {
        CoordenadaZonaSeguridad entity;
        CoordenadaZonaSeguridadDto response;
        UpdateCoordenadaZonaSeguridadCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in CoordenadaZonaSeguridadService.deleteCoordenadaZonaSeguridad" );
        //endregion

        try
        {
            entity = CoordenadaZonaSeguridadMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdateCoordenadaZonaSeguridadCommand( entity );
            command.execute();
            response = CoordenadaZonaSeguridadMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response deleteCoordenadaZonaSeguridad: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} deleting CoordenadaZonaSeguridad: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving CoordenadaZonaSeguridadService.deleteCoordenadaZonaSeguridad" );
        return response;
    }
}

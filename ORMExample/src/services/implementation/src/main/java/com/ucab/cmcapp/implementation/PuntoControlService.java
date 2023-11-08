package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.PuntoControl;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.puntoControl.composite.CreatePuntoControlCommand;
import com.ucab.cmcapp.logic.commands.puntoControl.composite.DeletePuntoControlCommand;
import com.ucab.cmcapp.logic.commands.puntoControl.composite.GetPuntoControlCommand;
import com.ucab.cmcapp.logic.commands.puntoControl.composite.UpdatePuntoControlCommand;
import com.ucab.cmcapp.logic.dtos.PuntoControlDto;
import com.ucab.cmcapp.logic.mappers.PuntoControlMapper;
import com.ucab.cmcapp.logic.mappers.PuntoControlMapperInsert;
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
    public PuntoControlDto getPuntoControl(@PathParam( "id" ) long userId )
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
            response = PuntoControlMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getPuntoControl: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting PuntoControl {}: {}", e.getMessage(), userId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PuntoControlService.getPuntoControl" );
        return response;
    }




    @POST
    public PuntoControlDto addPuntoControl( PuntoControlDto userDto )
    {
        PuntoControl entity;
        PuntoControlDto response;
        CreatePuntoControlCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PuntoControlService.addPuntoControl" );
        //endregion

        try
        {
            entity = PuntoControlMapperInsert.mapDtoToEntity( userDto );
            command = CommandFactory.createCreatePuntoControlCommand( entity );
            command.execute();
            response = PuntoControlMapperInsert.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addPuntoControl: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding PuntoControl: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PuntoControlService.addPuntoControl" );
        return response;
    }

    @DELETE
    @Path("/delete")
    public PuntoControlDto deletePuntoControl( PuntoControlDto userDto )
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
            response = PuntoControlMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response deletePuntoControl: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} deleting PuntoControl: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PuntoControlService.deletePuntoControl" );
        return response;
    }


    @PUT
    @Path("/update")
    public PuntoControlDto updatePuntoControl( PuntoControlDto userDto )
    {
        PuntoControl entity;
        PuntoControlDto response;
        UpdatePuntoControlCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PuntoControlService.deletePuntoControl" );
        //endregion

        try
        {
            entity = PuntoControlMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdatePuntoControlCommand( entity );
            command.execute();
            response = PuntoControlMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response deletePuntoControl: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} deleting PuntoControl: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PuntoControlService.deletePuntoControl" );
        return response;
    }
}

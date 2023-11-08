package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.TiempoControl;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.TiempoControl.composite.CreateTiempoControlCommand;
import com.ucab.cmcapp.logic.commands.TiempoControl.composite.DeleteTiempoControlCommand;
import com.ucab.cmcapp.logic.commands.TiempoControl.composite.GetTiempoControlCommand;
import com.ucab.cmcapp.logic.commands.TiempoControl.composite.UpdateTiempoControlCommand;
import com.ucab.cmcapp.logic.dtos.TiempoControlDto;
import com.ucab.cmcapp.logic.mappers.TiempoControlMapper;
import com.ucab.cmcapp.logic.mappers.TiempoControlMapperInsert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/tiempos" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class TiempoControlService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( TiempoControlService.class );

    @GET
    @Path( "/{id}" )
    public TiempoControlDto getTiempoControl(@PathParam( "id" ) long userId )
    {
        TiempoControl entity;
        TiempoControlDto response;
        GetTiempoControlCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in TiempoControlService.getTiempoControl" );
        //endregion

        try
        {
            entity = TiempoControlMapper.mapDtoToEntity( userId );
            command = CommandFactory.createGetTiempoControlCommand( entity );
            command.execute();
            response = TiempoControlMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getTiempoControl: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting TiempoControl {}: {}", e.getMessage(), userId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving TiempoControlService.getTiempoControl" );
        return response;
    }




    @POST
    public TiempoControlDto addTiempoControl( TiempoControlDto userDto )
    {
        TiempoControl entity;
        TiempoControlDto response;
        CreateTiempoControlCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in TiempoControlService.addTiempoControl" );
        //endregion

        try
        {
            entity = TiempoControlMapperInsert.mapDtoToEntity( userDto );
            command = CommandFactory.createCreateTiempoControlCommand( entity );
            command.execute();
            response = TiempoControlMapperInsert.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addTiempoControl: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding TiempoControl: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving TiempoControlService.addTiempoControl" );
        return response;
    }

    @DELETE
    @Path("/delete")
    public TiempoControlDto deleteTiempoControl( TiempoControlDto userDto )
    {
        TiempoControl entity;
        TiempoControlDto response;
        DeleteTiempoControlCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in TiempoControlService.deleteTiempoControl" );
        //endregion

        try
        {
            entity = TiempoControlMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createDeleteTiempoControlCommand( entity );
            command.execute();
            response = TiempoControlMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response deleteTiempoControl: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} deleting TiempoControl: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving TiempoControlService.deleteTiempoControl" );
        return response;
    }


    @PUT
    @Path("/update")
    public TiempoControlDto updateTiempoControl( TiempoControlDto userDto )
    {
        TiempoControl entity;
        TiempoControlDto response;
        UpdateTiempoControlCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in TiempoControlService.deleteTiempoControl" );
        //endregion

        try
        {
            entity = TiempoControlMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdateTiempoControlCommand( entity );
            command.execute();
            response = TiempoControlMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response deleteTiempoControl: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} deleting TiempoControl: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving TiempoControlService.deleteTiempoControl" );
        return response;
    }
}

package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.posicion.composite.CreatePosicionCommand;
import com.ucab.cmcapp.logic.commands.posicion.composite.DeletePosicionCommand;
import com.ucab.cmcapp.logic.commands.posicion.composite.GetPosicionCommand;
import com.ucab.cmcapp.logic.commands.posicion.composite.UpdatePosicionCommand;
import com.ucab.cmcapp.logic.dtos.PosicionDto;
import com.ucab.cmcapp.logic.mappers.PosicionMapper;
import com.ucab.cmcapp.logic.mappers.PosicionMapperInsert;
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
    public PosicionDto getPosicion(@PathParam( "id" ) long userId )
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
            response = PosicionMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getPosicion: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting Posicion {}: {}", e.getMessage(), userId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PosicionService.getPosicion" );
        return response;
    }




    @POST
    public PosicionDto addPosicion( PosicionDto userDto )
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
            response = PosicionMapperInsert.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addPosicion: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding Posicion: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PosicionService.addPosicion" );
        return response;
    }

    @DELETE
    @Path("/delete")
    public PosicionDto deletePosicion( PosicionDto userDto )
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
            response = PosicionMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response deletePosicion: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} deleting Posicion: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PosicionService.deletePosicion" );
        return response;
    }


    @PUT
    @Path("/update")
    public PosicionDto updatePosicion( PosicionDto userDto )
    {
        Posicion entity;
        PosicionDto response;
        UpdatePosicionCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionService.deletePosicion" );
        //endregion

        try
        {
            entity = PosicionMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdatePosicionCommand( entity );
            command.execute();
            response = PosicionMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response deletePosicion: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} deleting Posicion: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PosicionService.deletePosicion" );
        return response;
    }
}

package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.alerta.atomic.GetAlertaByTipoAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.CreateAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.DeleteAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.GetAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.UpdateAlertaCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.DeleteAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.UpdateAlertaCommand;
import com.ucab.cmcapp.logic.dtos.AlertaDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.dtos.AlertaDto;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import com.ucab.cmcapp.logic.mappers.AlertaMapperInsert;
import com.ucab.cmcapp.logic.mappers.UserMapper;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/alertas" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class AlertaService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( AlertaService.class );

    @GET
    @Path( "/{id}" )
    public AlertaDto getAlerta(@PathParam( "id" ) long alertaId )
    {
        Alerta entity;
        AlertaDto response;
        GetAlertaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in AlertaService.getAlerta" );
        //endregion

        try
        {
            entity = AlertaMapper.mapDtoToEntity( alertaId );
            command = CommandFactory.createGetAlertaCommand( entity );
            command.execute();
            response = AlertaMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getAlerta: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting alerta {}: {}", e.getMessage(), alertaId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving AlertaService.getAlerta" );
        return response;
    }


    @GET
    @Path( "TipoAlerta/{TipoAlerta}" )
    public AlertaDto getAlerta(@PathParam( "TipoAlerta" ) String tipoAlerta )
    {
        Alerta entity;
        AlertaDto response;
        GetAlertaByTipoAlertaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in AlertaService.getAlerta" );
        //endregion

        try
        {
            entity = AlertaMapper.mapDtoToEntityTipoAlerta( tipoAlerta );
            command = CommandFactory.createGetAlertaByTipoAlertaCommand( entity );
            command.execute();
            response = AlertaMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getUser: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting user {}: {}", e.getMessage(), tipoAlerta, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving AlertaService.getAlerta" );
        return response;
    }

    @POST
    public AlertaDto addAlerta( AlertaDto alertaDto )
    {
        Alerta entity;
        AlertaDto response;
        CreateAlertaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in AlertaService.addAlerta" );
        //endregion

        try
        {
            entity = AlertaMapperInsert.mapDtoToEntity( alertaDto );
            command = CommandFactory.createCreateAlertaCommand( entity );
            command.execute();
            response = AlertaMapperInsert.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addAlerta: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding alerta: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving AlertaService.addAlerta" );
        return response;
    }

    @DELETE
    @Path("/delete")
    public AlertaDto deleteAlerta(AlertaDto userDto )
    {
        Alerta entity;
        AlertaDto response;
        DeleteAlertaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in AlertaService.deleteAlerta" );
        //endregion

        try
        {
            entity = AlertaMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createDeleteAlertaCommand( entity );
            command.execute();
            response = AlertaMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response deleteAlerta: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} deleting Alerta: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving AlertaService.deleteAlerta" );
        return response;
    }


    @PUT
    @Path("/update")
    public AlertaDto updateAlerta( AlertaDto userDto )
    {
        Alerta entity;
        AlertaDto response;
        UpdateAlertaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in AlertaService.deleteAlerta" );
        //endregion

        try
        {
            entity = AlertaMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdateAlertaCommand( entity );
            command.execute();
            response = AlertaMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response deleteAlerta: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} deleting Alerta: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving AlertaService.deleteAlerta" );
        return response;
    }
    
}

package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.DistanciaAlejamiento;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic.GetDistanciaAlejamientoByUsuariosCommand;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.composite.CreateDistanciaAlejamientoCommand;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.composite.DeleteDistanciaCommand;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.composite.GetDistanciaAlejamientoCommand;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.composite.UpdateDistanciaCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByIdCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.DeleteUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.UpdateUsuarioCommand;
import com.ucab.cmcapp.logic.dtos.DistanciaAlejamientoDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.DistanciaAlejamientoMapper;
import com.ucab.cmcapp.logic.mappers.DistanciaAlejamientoMapperInsert;
import com.ucab.cmcapp.logic.mappers.UserMapper;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.ucab.cmcapp.logic.commands.CommandFactory.createGetUsuarioByIdCommand;


@Path( "/distancias" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class DistanciaAlejamientoService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( DistanciaAlejamientoService.class );

    @GET
    @Path( "/{IdAlej}" )
    public DistanciaAlejamientoDto getDistanciaAlejamiento(@PathParam( "IdAlej" ) long distanciaId )
    {
        DistanciaAlejamiento entity;
        DistanciaAlejamientoDto response;
        GetDistanciaAlejamientoCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in DistanciaAlejamientoService.getDistanciaAlejamiento" );
        //endregion

        try
        {
            entity = DistanciaAlejamientoMapper.mapDtoToEntity( distanciaId );
            command = CommandFactory.createGetDistanciaAlejamientoCommand( entity );
            command.execute();
            response = DistanciaAlejamientoMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getDistanciaAlejamiento: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting DistanciaAlejamiento {}: {}", e.getMessage(), distanciaId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving DistanciaAlejamientoService.getDistanciaAlejamiento" );
        return response;
    }

/*
    @GET
    @Path("usuarios/{Victima_id}/{Agresor_id}")
    public DistanciaAlejamientoDto getDistanciaAlejamiento(@PathParam("Victima_id") long Victima_id, @PathParam("Agresor_id") long Agresor_id) {
        DistanciaAlejamiento entity;
        DistanciaAlejamientoDto response;
        GetDistanciaAlejamientoByUsuariosCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in DistanciaAlejamientoService.getDistanciaAlejamiento" );
        //endregion

        try
        {
            entity = DistanciaAlejamientoMapper.mapDtoToEntity( distanciaId );
            command = CommandFactory.createGetDistanciaAlejamientoByUsuariosCommand( entity );
            command.execute();
            response = DistanciaAlejamientoMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getDistanciaAlejamiento: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting DistanciaAlejamiento {}: {}", e.getMessage(), distanciaId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving DistanciaAlejamientoService.getDistanciaAlejamiento" );
        return response;
    }
*/



    @POST
    public DistanciaAlejamientoDto addDistanciaAlejamiento( DistanciaAlejamientoDto distanciaDto )
    {
        DistanciaAlejamiento entity;
        DistanciaAlejamientoDto response;
        CreateDistanciaAlejamientoCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in DistanciaAlejamientoService.addDistanciaAlejamiento" );
        //endregion

        try
        {
            entity = DistanciaAlejamientoMapperInsert.mapDtoToEntity( distanciaDto );
            command = CommandFactory.createCreateDistanciaAlejamientoCommand( entity );
            command.execute();
            response = DistanciaAlejamientoMapperInsert.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addDistanciaAlejamiento: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding DistanciaAlejamiento: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving DistanciaAlejamientoService.addDistanciaAlejamiento" );
        return response;
    }


    @POST
    @Path("/delete")
    public DistanciaAlejamientoDto deleteDistancia( DistanciaAlejamientoDto userDto )
    {
        DistanciaAlejamiento entity;
        DistanciaAlejamientoDto response;
        DeleteDistanciaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in DistanciaAlejamientoService.deleteDistanciaAlejamiento" );
        //endregion

        try
        {
            entity = DistanciaAlejamientoMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createDeleteDistanciaCommand( entity );
            command.execute();
            response = DistanciaAlejamientoMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response deleteDistanciaAlejamiento: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} deleting DistanciaAlejamiento: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving DistanciaAlejamientoService.deleteDistanciaAlejamiento" );
        return response;
    }


    @POST
    @Path("/update")
    public DistanciaAlejamientoDto updateUsuario( DistanciaAlejamientoDto userDto )
    {
        DistanciaAlejamiento entity;
        DistanciaAlejamientoDto response;
        UpdateDistanciaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in DistanciaAlejamientoService.deleteDistanciaAlejamiento" );
        //endregion

        try
        {
            entity = DistanciaAlejamientoMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdateDistanciaCommand( entity );
            command.execute();
            response = DistanciaAlejamientoMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response deleteDistanciaAlejamiento: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} deleting DistanciaAlejamiento: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving DistanciaAlejamientoService.deleteDistanciaAlejamiento" );
        return response;
    }

}

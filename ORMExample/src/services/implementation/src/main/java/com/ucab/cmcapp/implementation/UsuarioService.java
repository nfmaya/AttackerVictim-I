package com.ucab.cmcapp.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salas.Sender;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.CommandFactory;

import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByUsernameCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.*;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.*;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Path( "/usuarios" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class UsuarioService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( UsuarioService.class );
//
@GET
@Path( "/{id}" )
public Response getUsuario(@PathParam( "id" ) long userId )
{
    Usuario entity;
    UsuarioDto response;
    GetUsuarioCommand command = null;
    //region Instrumentation DEBUG
    _logger.debug( "Get in UsuarioService.getUsuario" );
    //endregion

    try
    {
        entity = UsuarioMapper.mapDtoToEntity( userId );
        command = CommandFactory.createGetUsuarioCommand( entity );
        command.execute();
        if(command.getReturnParam() != null){
            response = UsuarioMapper.mapEntityToDto(command.getReturnParam());
        }else{
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + userId)).build();
        }
    }
    catch ( Exception e )
    {
        return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Usuario " + userId)).build();

    }
    finally
    {
        if (command != null)
            command.closeHandlerSession();
    }

    _logger.debug( "Leaving UsuarioService.getUsuario" );
    return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Usuario: " + userId)).build();
}


    @GET
    @Path( "/findAll" )
    public Response getAllUsuario()
    {
        List<UsuarioDto> response;
        GetAllUsuarioCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioService.getUsuario" );
        //endregion

        try
        {
            command = CommandFactory.createGetAllUsuarioCommand();
            command.execute();
            if(command.getReturnParam() != null){
                response = UsuarioMapper.mapListEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " )).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Usuario ")).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UsuarioService.getUsuario" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Usuario: " )).build();
    }

    @GET
    @Path( "username/{username}" )
    public Response getUsuario(@PathParam( "username" ) String Username )
    {
        Usuario entity;
        UsuarioDto response;
        GetUsuarioByUsernameCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioService.getUsuario" );
        //endregion

        try
        {
            entity = UsuarioMapper.mapDtoToEntityUsername( Username );
            command = CommandFactory.createGetUsuarioByUsernameCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = UsuarioMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + Username)).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Usuario " + Username)).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UsuarioService.getUsuario" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Username Usuario: " + Username)).build();
    }




    @POST
    @Path("/insert")
    public Response addUsuario( UsuarioDto userDto )
    {
        Usuario entity;
        UsuarioDto response;
        CreateUsuarioCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioService.addUsuario" );
        //endregion

        try
        {
            entity = UsuarioMapper.mapDtoToEntityInsert( userDto );
            command = CommandFactory.createCreateUsuarioCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = UsuarioMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Insertar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Usuario " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UsuarioService.addUsuario" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Insertado: " + userDto.getId())).build();
    }

    @DELETE
    @Path("/delete")
    public Response deleteUsuario( UsuarioDto userDto )
    {
        Usuario entity;
        UsuarioDto response;
        DeleteUsuarioCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioService.deleteUsuario" );
        //endregion

        try
        {
            entity = UsuarioMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createDeleteUsuarioCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = UsuarioMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede eliminar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Usuario " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UsuarioService.deleteUsuario" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Eliminado: " + userDto.getId())).build();
    }


    @PUT
    @Path("/update")
    public Response updateUsuario( UsuarioDto userDto )
    {
        Usuario entity;
        UsuarioDto response;
        UpdateUsuarioCommand command = null;
        UsuarioDao base = new UsuarioDao();
        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioService.deleteUsuario" );
        //endregion

        try
        {
            if (base.find(userDto.getId(), Usuario.class) == null){
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se encuentra el Objeto registrado " + userDto.getId())).build();

            }
            entity = UsuarioMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdateUsuarioCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = UsuarioMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede editar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Usuario " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UsuarioService.deleteUsuario" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Editado: " + userDto.getId())).build();
    }
}

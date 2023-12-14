package com.ucab.cmcapp.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salas.Sender;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.mappers.UserMapper;
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
import java.io.IOException;

@Path( "/users" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class UserService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( UserService.class );

    @GET
    @Path("/{id}")
    public void getUser(@PathParam("id") long userId) {
        User entity;
        UserDto response = null;
        GetUserCommand command = null;
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        _logger.debug("Get in UserService.getUser");

        try {
            entity = UserMapper.mapDtoToEntity(userId);
            command = CommandFactory.createGetUserCommand(entity);
            command.execute();
            if (command.getReturnParam() != null) {
                response = UserMapper.mapEntityToDto(command.getReturnParam());
                jsonString = mapper.writeValueAsString(new CustomResponse<>(response, "Busqueda por Id Usuario: " + userId));
            } else {
                jsonString = mapper.writeValueAsString(Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + userId)).build());
            }
            Sender.send(jsonString);
        } catch (Exception e) {
            try {
                jsonString = mapper.writeValueAsString(Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Usuario " + userId)).build());
                Sender.send(jsonString);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            if (command != null) {
                command.closeHandlerSession();
            }
            _logger.debug("Leaving UserService.getUser");
        }
    }

    @GET
    @Path("email/{email}")
    public void getUser(@PathParam("email") String email) {
        User entity;
        UserDto response = null;
        GetUserByEmailCommand command = null;
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        _logger.debug("Get in UserService.getUser");

        try {
            entity = UserMapper.mapDtoToEntityEmail(email);
            command = CommandFactory.createGetUserByEmailCommand(entity);
            command.execute();
            if (command.getReturnParam() != null) {
                response = UserMapper.mapEntityToDto(command.getReturnParam());
                jsonString = mapper.writeValueAsString(new CustomResponse<>(response, "Busqueda por Email Usuario: " + email));
            } else {
                jsonString = mapper.writeValueAsString(Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + email)).build());
            }
            Sender.send(jsonString);
        } catch (Exception e) {
            try {
                jsonString = mapper.writeValueAsString(Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Usuario " + email)).build());
                Sender.send(jsonString);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            if (command != null) {
                command.closeHandlerSession();
            }
            _logger.debug("Leaving UserService.getUser");
        }
    }


    @POST
    public UserDto addUser( UserDto userDto )
    {
        User entity;
        UserDto response;
        CreateUserCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in UserService.addUser" );
        //endregion

        try
        {
            entity = UserMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createCreateUserCommand( entity );
            command.execute();
            response = UserMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addUser: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding user: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UserService.addUser" );
        return response;
    }
}

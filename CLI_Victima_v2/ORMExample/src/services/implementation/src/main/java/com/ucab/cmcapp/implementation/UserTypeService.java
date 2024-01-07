package com.ucab.cmcapp.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salas.Sender;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.UserType;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.UserType.composite.CreateUserTypeCommand;
import com.ucab.cmcapp.logic.commands.UserType.composite.DeleteUserTypeCommand;
import com.ucab.cmcapp.logic.commands.UserType.composite.GetUserTypeCommand;
import com.ucab.cmcapp.logic.commands.UserType.composite.UpdateUserTypeCommand;
import com.ucab.cmcapp.logic.dtos.UserTypeDto;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import com.ucab.cmcapp.logic.mappers.UserTypeMapper;
import com.ucab.cmcapp.persistence.dao.UserTypeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path( "/tiposUsuarios" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class UserTypeService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( UserTypeService.class );

    @GET
    @Path("/{id}")
    public void getUserType(@PathParam("id") long userId) {
        UserType entity;
        UserTypeDto response = null;
        GetUserTypeCommand command = null;
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        _logger.debug("Get in UserTypeService.getUserType");

        try {
            entity = UserTypeMapper.mapDtoToEntity(userId);
            command = CommandFactory.createGetUserTypeCommand(entity);
            command.execute();
            if (command.getReturnParam() != null) {
                response = UserTypeMapper.mapEntityToDto(command.getReturnParam());
                jsonString = mapper.writeValueAsString(new CustomResponse<>(response, "Busqueda por Id UserType: " + userId));
            } else {
                jsonString = mapper.writeValueAsString(Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + userId)).build());
            }
            Sender.send(jsonString);
        } catch (Exception e) {
            try {
                jsonString = mapper.writeValueAsString(Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en UserType " + userId)).build());
                Sender.send(jsonString);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            if (command != null) {
                command.closeHandlerSession();
            }
            _logger.debug("Leaving UserTypeService.getUserType");
        }
    }





    @POST
    @Path("/insert")
    public Response addUserType( UserTypeDto userDto )
    {
        UserType entity;
        UserTypeDto response;
        CreateUserTypeCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in UserTypeService.addUserType" );
        //endregion

        try
        {
            entity = UserTypeMapper.mapDtoToEntityInsert( userDto );
            command = CommandFactory.createCreateUserTypeCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = UserTypeMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Insertar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en UserType " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UserTypeService.addUserType" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Insertado: " + userDto.getId())).build();
    }

    @DELETE
    @Path("/delete")
    public Response deleteUserType( UserTypeDto userDto )
    {
        UserType entity;
        UserTypeDto response;
        DeleteUserTypeCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in UserTypeService.deleteUserType" );
        //endregion

        try
        {
            entity = UserTypeMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createDeleteUserTypeCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = UserTypeMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede eliminar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en UserType " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UserTypeService.deleteUserType" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Eliminado: " + userDto.getId())).build();
    }


    @PUT
    @Path("/update")
    public Response updateUserType( UserTypeDto userDto )
    {
        UserType entity;
        UserTypeDto response;
        UpdateUserTypeCommand command = null;
        UserTypeDao base = new UserTypeDao();
        //region Instrumentation DEBUG
        _logger.debug( "Get in UserTypeService.deleteUserType" );
        //endregion

        try
        {
            if (base.find(userDto.getId(), UserType.class) == null){
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se encuentra el Objeto registrado " + userDto.getId())).build();

            }
            entity = UserTypeMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdateUserTypeCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = UserTypeMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede editar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en UserType " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UserTypeService.deleteUserType" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Editado: " + userDto.getId())).build();
    }
}

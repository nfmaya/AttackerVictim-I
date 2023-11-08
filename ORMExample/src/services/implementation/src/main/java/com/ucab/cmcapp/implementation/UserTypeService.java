package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.UserType;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.UserType.composite.CreateUserTypeCommand;
import com.ucab.cmcapp.logic.commands.UserType.composite.DeleteUserTypeCommand;
import com.ucab.cmcapp.logic.commands.UserType.composite.GetUserTypeCommand;
import com.ucab.cmcapp.logic.commands.UserType.composite.UpdateUserTypeCommand;
import com.ucab.cmcapp.logic.dtos.UserTypeDto;
import com.ucab.cmcapp.logic.mappers.UserTypeMapper;
import com.ucab.cmcapp.logic.mappers.UserTypeMapperInsert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/tiposUsuarios" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class UserTypeService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( UserTypeService.class );

    @GET
    @Path( "/{id}" )
    public UserTypeDto getUserType(@PathParam( "id" ) long userId )
    {
        UserType entity;
        UserTypeDto response;
        GetUserTypeCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in UserTypeService.getUserType" );
        //endregion

        try
        {
            entity = UserTypeMapper.mapDtoToEntity( userId );
            command = CommandFactory.createGetUserTypeCommand( entity );
            command.execute();
            response = UserTypeMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getUserType: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting UserType {}: {}", e.getMessage(), userId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UserTypeService.getUserType" );
        return response;
    }




    @POST
    public UserTypeDto addUserType( UserTypeDto userDto )
    {
        UserType entity;
        UserTypeDto response;
        CreateUserTypeCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in UserTypeService.addUserType" );
        //endregion

        try
        {
            entity = UserTypeMapperInsert.mapDtoToEntity( userDto );
            command = CommandFactory.createCreateUserTypeCommand( entity );
            command.execute();
            response = UserTypeMapperInsert.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addUserType: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding UserType: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UserTypeService.addUserType" );
        return response;
    }

    @DELETE
    @Path("/delete")
    public UserTypeDto deleteUserType( UserTypeDto userDto )
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
            response = UserTypeMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response deleteUserType: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} deleting UserType: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UserTypeService.deleteUserType" );
        return response;
    }


    @PUT
    @Path("/update")
    public UserTypeDto updateUserType( UserTypeDto userDto )
    {
        UserType entity;
        UserTypeDto response;
        UpdateUserTypeCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in UserTypeService.deleteUserType" );
        //endregion

        try
        {
            entity = UserTypeMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdateUserTypeCommand( entity );
            command.execute();
            response = UserTypeMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response deleteUserType: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} deleting UserType: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UserTypeService.deleteUserType" );
        return response;
    }
}

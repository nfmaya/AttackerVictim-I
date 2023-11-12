package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Alerta;
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
import com.ucab.cmcapp.logic.mappers.*;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.dao.AlertaDao;
import com.ucab.cmcapp.persistence.dao.DistanciaAlejamientoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
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
    public Response getDistanciaAlejamiento(@PathParam( "IdAlej" ) long distanciaId )
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
            if(command.getReturnParam() != null){
                response = DistanciaAlejamientoMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + distanciaId)).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Distancia" + distanciaId)).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving DistanciaAlejamientoService.getDistanciaAlejamiento" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Distancia: " + distanciaId)).build();
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
    @Path("/insert")
    public Response addDistanciaAlejamiento( DistanciaAlejamientoDto distanciaDto )
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
            if(command.getReturnParam() != null){
                response = DistanciaAlejamientoMapperInsert.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Insertar " + distanciaDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Distancia " + distanciaDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving DistanciaAlejamientoService.addDistanciaAlejamiento" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Insertado: " + distanciaDto.getId())).build();
    }

    //ESTE ES EL DELETE DE LA BD
    @DELETE
    @Path("/delete")
    public Response deleteDistancia( DistanciaAlejamientoDto userDto )
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
            if(command.getReturnParam() != null){
                response = DistanciaAlejamientoMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede eliminar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Distancia " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving DistanciaAlejamientoService.deleteDistanciaAlejamiento" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Eliminado: " + userDto.getId())).build();
    }


    @PUT
    @Path("/update")
    public Response updateUsuario( DistanciaAlejamientoDto userDto )
    {
        DistanciaAlejamiento entity;
        DistanciaAlejamientoDto response;
        UpdateDistanciaCommand command = null;
        DistanciaAlejamientoDao base = new DistanciaAlejamientoDao();

        //region Instrumentation DEBUG
        _logger.debug( "Get in DistanciaAlejamientoService.deleteDistanciaAlejamiento" );
        //endregion

        try
        {
            if (base.find(userDto.getId(), DistanciaAlejamiento.class) == null){
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se encuentra el Objeto registrado " + userDto.getId())).build();

            }
            entity = DistanciaAlejamientoMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdateDistanciaCommand( entity );
            command.execute();

            if(command.getReturnParam() != null){
                response = DistanciaAlejamientoMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede editar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Distancia " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving DistanciaAlejamientoService.deleteDistanciaAlejamiento" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Editado: " + userDto.getId())).build();
    }

}

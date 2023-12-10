package com.ucab.cmcapp.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.salas.Sender;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.TiempoControl;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.TiempoControl.composite.CreateTiempoControlCommand;
import com.ucab.cmcapp.logic.commands.TiempoControl.composite.DeleteTiempoControlCommand;
import com.ucab.cmcapp.logic.commands.TiempoControl.composite.GetTiempoControlCommand;
import com.ucab.cmcapp.logic.commands.TiempoControl.composite.UpdateTiempoControlCommand;
import com.ucab.cmcapp.logic.dtos.TiempoControlDto;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import com.ucab.cmcapp.logic.mappers.TiempoControlMapper;
import com.ucab.cmcapp.persistence.dao.TiempoControlDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;


@Path( "/tiempos" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class TiempoControlService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(TiempoControlService.class);

    @GET//Arreglado ya envía al rabbitmq
    @Path("/{id}")
    public void getTiempoControl(@PathParam("id") long userId) {
        TiempoControl entity;
        TiempoControlDto response = null;
        GetTiempoControlCommand command = null;
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        _logger.debug("Get in TiempoControlService.getTiempoControl");

        try {
            entity = TiempoControlMapper.mapDtoToEntity(userId);
            command = CommandFactory.createGetTiempoControlCommand(entity);
            command.execute();
            if (command.getReturnParam() != null) {
                response = TiempoControlMapper.mapEntityToDto(command.getReturnParam());
                jsonString = mapper.writeValueAsString(new CustomResponse<>(response, "Busqueda por Id Alerta: " + userId));
            } else {
                jsonString = mapper.writeValueAsString(Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + userId)).build());
            }
            Sender.send(jsonString);
        } catch (Exception e) {
            try {
                jsonString = mapper.writeValueAsString(Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Tiempo Control " + userId)).build());
                Sender.send(jsonString);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            if (command != null) {
                command.closeHandlerSession();
            }
            _logger.debug("Leaving TiempoControlService.getTiempoControl");
        }
    }


    @POST
    @Path("/insert")
    public Response addTiempoControl( TiempoControlDto userDto )
    {
        TiempoControl entity;
        TiempoControlDto response;
        CreateTiempoControlCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in TiempoControlService.addTiempoControl" );
        //endregion

        try
        {
            entity = TiempoControlMapper.mapDtoToEntityInsert( userDto );
            command = CommandFactory.createCreateTiempoControlCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = TiempoControlMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Insertar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Tiempo Control " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving TiempoControlService.addTiempoControl" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Insertado: " + userDto.getId())).build();
    }

    @DELETE
    @Path("/delete")
    public Response deleteTiempoControl( TiempoControlDto userDto )
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
            if(command.getReturnParam() != null){
                response = TiempoControlMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede eliminar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Tiempo Control " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving TiempoControlService.deleteTiempoControl" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Eliminado: " + userDto.getId())).build();
    }


    @PUT
    @Path("/update")
    public Response updateTiempoControl( TiempoControlDto userDto )
    {
        TiempoControl entity;
        TiempoControlDto response;
        UpdateTiempoControlCommand command = null;
        TiempoControlDao base = new TiempoControlDao();
        //region Instrumentation DEBUG
        _logger.debug( "Get in TiempoControlService.deleteTiempoControl" );
        //endregion

        try
        {
            if (base.find(userDto.getId(), TiempoControl.class) == null){
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se encuentra el Objeto registrado " + userDto.getId())).build();

            }
            entity = TiempoControlMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdateTiempoControlCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = TiempoControlMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede editar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Tiempo Control " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving TiempoControlService.deleteTiempoControl" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Editado: " + userDto.getId())).build();
    }
}

package com.ucab.cmcapp.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salas.Sender;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.alerta.composite.GetAllAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.atomic.GetAlertaByTipoAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.CreateAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.DeleteAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.GetAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.UpdateAlertaCommand;

import com.ucab.cmcapp.logic.commands.alerta.composite.DeleteAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.UpdateAlertaCommand;
import com.ucab.cmcapp.logic.dtos.AlertaDto;
import com.ucab.cmcapp.logic.dtos.AlertaDto;
import com.ucab.cmcapp.logic.dtos.AlertaDto;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import com.ucab.cmcapp.persistence.dao.AlertaDao;
import com.ucab.cmcapp.persistence.dao.BaseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Path( "/alertas" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class AlertaService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( AlertaService.class );

    @GET
    @Path( "/{id}" )
    public Response getAlerta(@PathParam( "id" ) long alertaId )
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
            if(command.getReturnParam() != null){
                response = AlertaMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + alertaId)).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Alerta " + alertaId)).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving AlertaService.getAlerta" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Alerta: " + alertaId)).build();
    }


    @GET
    @Path( "/TipoAlerta/{TipoAlerta}" )
    public Response getAlerta(@PathParam( "TipoAlerta" ) String tipoAlerta )
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
            if(command.getReturnParam() != null){
                response = AlertaMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + tipoAlerta)).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Alerta " + tipoAlerta)).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving AlertaService.getAlerta" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por tipo de alerta: " + tipoAlerta)).build();
    }

    @GET
    @Path( "/findAll" )
    public Response getAllAlerta()
    {
        List<AlertaDto> response;
        GetAllAlertaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in AlertaService.getAlerta" );
        //endregion

        try
        {
            command = CommandFactory.createGetAllAlertaCommand();
            command.execute();
            if(command.getReturnParam() != null){
                response = AlertaMapper.mapListEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " )).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Alerta ")).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving AlertaService.getAlerta" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Alerta: " )).build();
    }

    @GET
    @Path("/findRecent")
    public Response getRecentAlertas() {
        List<AlertaDto> response;
        GetAllAlertaCommand command = null;

        // Get the current timestamp
        long currentTime = System.currentTimeMillis();

        // Subtract 15 seconds from the current timestamp
        long lowerLimitTime = currentTime - 60 * 1000;

        try {
            command = CommandFactory.createGetAllAlertaCommand();
            command.execute();
            if (command.getReturnParam() != null) {
                // Filter the alerts based on their timestamp
                response = AlertaMapper.mapListEntityToDto(command.getReturnParam())
                        .stream()
                        .filter(alertaDto -> alertaDto.get_fechaHora().getTime() > lowerLimitTime)
                        .collect(Collectors.toList());
            } else {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No alerts found in the last 15 seconds")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error while fetching recent alerts")).build();
        } finally {
            if (command != null) {
                command.closeHandlerSession();
            }
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response, "Recent alerts in the last 15 seconds")).build();
    }



    @POST
    @Path("/insert")
    public Response addAlerta( AlertaDto alertaDto )
    {
        Alerta entity;
        AlertaDto response;
        CreateAlertaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in AlertaService.addAlerta" );
        //endregion

        try
        {
            entity = AlertaMapper.mapDtoToEntityInsert( alertaDto );
            command = CommandFactory.createCreateAlertaCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = AlertaMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Insertar " + alertaDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Alerta " + alertaDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving AlertaService.addAlerta" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Insertado: " + alertaDto.getId())).build();
    }


    //ESTE ES EL DELETE DE LA BD
    @DELETE
    @Path("/delete")
    public Response deleteAlerta(AlertaDto userDto )
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
            if(command.getReturnParam() != null){
                response = AlertaMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede eliminar " + userDto.getId())).build();
            }

        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Alerta " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving AlertaService.deleteAlerta" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Eliminado: " + userDto.getId())).build();
    }


    //DELETE LOGICO
    @PUT
    @Path("/delete2")
    public Response deleteAlerta2 (AlertaDto alertaDto){
        Alerta entity;
        AlertaDto responseDto = null;
        UpdateAlertaCommand command = null;
        AlertaDao base = new AlertaDao();

        try{
            if (base.find(alertaDto.getId(),Alerta.class) == null){
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se encuentra el Objeto registrado " + alertaDto.getId())).build();

            }
            entity = AlertaMapper.mapDtoToEntity(alertaDto);
            command = CommandFactory.createUpdateAlertaCommand(entity);
            command.execute();

            if(command.getReturnParam() != null){
                responseDto = AlertaMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede eliminar " + alertaDto.getId())).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Alerta " + alertaDto.getId())).build();
        } finally {
            if(command != null){
                command.closeHandlerSession();
            }
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDto,"Eliminado: " + alertaDto.getId())).build();

    }




    @PUT
    @Path("/update")
    public Response updateAlerta (AlertaDto alertaDto){
        Alerta entity;
        AlertaDto responseDto = null;
        UpdateAlertaCommand command = null;
        AlertaDao base = new AlertaDao();

        try{
            if (base.find(alertaDto.getId(),Alerta.class) == null){
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se encuentra el Objeto registrado " + alertaDto.getId())).build();

            }
            entity = AlertaMapper.mapDtoToEntity(alertaDto);
            command = CommandFactory.createUpdateAlertaCommand(entity);
            command.execute();

            if(command.getReturnParam() != null){
                responseDto = AlertaMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede editar " + alertaDto.getId())).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Alerta " + alertaDto.getId())).build();
        } finally {
            if(command != null){
                command.closeHandlerSession();
            }
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDto,"Editado: " + alertaDto.getId())).build();

    }


}

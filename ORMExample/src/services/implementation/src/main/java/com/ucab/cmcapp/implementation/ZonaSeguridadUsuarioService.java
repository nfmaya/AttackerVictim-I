package com.ucab.cmcapp.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salas.Sender;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.common.entities.ZonaSeguridadUsuario;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite.GetZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.ZonaSeguridadUsuario.composite.GetAllZonaSeguridadUsuarioCommand;
import com.ucab.cmcapp.logic.commands.ZonaSeguridadUsuario.composite.*;
import com.ucab.cmcapp.logic.dtos.*;
import com.ucab.cmcapp.logic.dtos.ZonaSeguridadUsuarioDto;
import com.ucab.cmcapp.logic.mappers.ZonaSeguridadMapper;
import com.ucab.cmcapp.logic.mappers.ZonaSeguridadUsuarioMapper;
import com.ucab.cmcapp.logic.mappers.ZonaSeguridadUsuarioMapper;
import com.ucab.cmcapp.persistence.dao.ZonaSeguridadUsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path( "/zonasUsuario" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class ZonaSeguridadUsuarioService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( ZonaSeguridadUsuarioService.class );

    @GET
    @Path( "/{id}" )
    public Response getZonaSeguridadUsuario(@PathParam( "id" ) long userId )
    {
        ZonaSeguridadUsuario entity;
        ZonaSeguridadUsuarioDto response;
        GetZonaSeguridadUsuarioCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadUsuarioService.getZonaSeguridadUsuario" );
        //endregion

        try
        {
            entity = ZonaSeguridadUsuarioMapper.mapDtoToEntity( userId );
            command = CommandFactory.createGetZonaSeguridadUsuarioCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = ZonaSeguridadUsuarioMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + userId)).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Zona Seguridad " + userId)).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguridadUsuarioService.getZonaSeguridadUsuario" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Zona Seguridad: " + userId)).build();
    }

    @GET
    @Path("/findAll")
    public Response getAllZonaSeguridadUsuario() {
        List<ZonaSeguridadUsuarioDto> response;
        GetAllZonaSeguridadUsuarioCommand command = null;

        _logger.debug("Get in ZonaSeguridadUsuarioService.getZonaSeguridadUsuario");

        try {
            command = CommandFactory.createGetAllZonaSeguridadUsuarioCommand();
            command.execute();
            if (command.getReturnParam() != null) {
                response = ZonaSeguridadUsuarioMapper.mapListEntityToDto(command.getReturnParam());
            } else {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " )).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Zona Seguridad " )).build();

        } finally {
            if (command != null) {
                command.closeHandlerSession();
            }

        }
        _logger.debug("Leaving ZonaSeguridadUsuarioService.getZonaSeguridadUsuario");
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Zona Seguridad: ")).build();

    }


    //endpoint para obtener las zonas de seguridad de un usuario
    @GET
    @Path("/findAll/{id}")
    public Response getUsuarioAllZonaSeguridad(@PathParam("id") long userId) {
        List<ZonaSeguridadUsuarioDto> response;
        GetAllZonaSeguridadUsuarioByUsuarioCommand command = null;
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        _logger.debug("Get in ZonaSeguridadService.getZonaSeguridad");

        try {
            command = CommandFactory.createGetAllZonaSeguridadUsuarioByUsuarioCommand(userId);
            command.execute();
            if (command.getReturnParam() != null) {
                response = ZonaSeguridadUsuarioMapper.mapListEntityToDto(command.getReturnParam());
            } else {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " )).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Zona Seguridad " )).build();

        } finally {
            if (command != null) {
                command.closeHandlerSession();
            }

        }
        _logger.debug("Leaving ZonaSeguridadUsuarioService.getZonaSeguridadUsuario");
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Zona Seguridad: ")).build();

    }

    public List<ZonaSeguridadWithCoordenadasDto> getUsuarioAllZonaSeguridadWithCoordenadas2(long userId) {
        List<ZonaSeguridadUsuarioDto> zonasSeguridadUsuario = getUsuarioAllZonaSeguridad2(userId);
        List<ZonaSeguridadWithCoordenadasDto> result = new ArrayList<>();

        CoordenadaZonaSeguridadService coordenadaZonaSeguridadService = new CoordenadaZonaSeguridadService();

        for (ZonaSeguridadUsuarioDto zonaSeguridadUsuario : zonasSeguridadUsuario) {
            ZonaSeguridadWithCoordenadasDto dto = new ZonaSeguridadWithCoordenadasDto();
            dto.setZonaSeguridad(zonaSeguridadUsuario.getZonaSeguridadDto());
            dto.setCoordenadas(coordenadaZonaSeguridadService.getCoordenadaAllZonaSeguridad2(zonaSeguridadUsuario.getZonaSeguridadDto().getId()));
            result.add(dto);
        }

        return result;
    }

    //endpoint para obtener las zonas de seguridad de un usuario con las coordendas de cada una
    @GET
    @Path("/findAllZonaSeguridadWithCoordenadas/{id}")
    public Response getUsuarioAllZonaSeguridadWithCoordenadas(@PathParam("id") long userId) {
        List<ZonaSeguridadWithCoordenadasDto> response = getUsuarioAllZonaSeguridadWithCoordenadas2(userId);
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Usuario: " + userId)).build();
    }

    //metodo para obtener las zonas de seguridad de un usuario
    public List<ZonaSeguridadUsuarioDto> getUsuarioAllZonaSeguridad2(long userId) {
        List<ZonaSeguridadUsuarioDto> response = null;
        GetAllZonaSeguridadUsuarioByUsuarioCommand command = null;
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        _logger.debug("Get in ZonaSeguridadService.getZonaSeguridad");

        try {
            command = CommandFactory.createGetAllZonaSeguridadUsuarioByUsuarioCommand(userId);
            command.execute();
            if (command.getReturnParam() != null) {
                response = ZonaSeguridadUsuarioMapper.mapListEntityToDto(command.getReturnParam());
            } else {
                return response;
            }
        } catch (Exception e) {
            return response;

        } finally {
            if (command != null) {
                command.closeHandlerSession();
            }

        }
        _logger.debug("Leaving ZonaSeguridadUsuarioService.getZonaSeguridadUsuario");
        return response;

    }


    @POST
    @Path("/insert")
    public Response addZonaSeguridadUsuario( ZonaSeguridadUsuarioDto userDto )
    {
        ZonaSeguridadUsuario entity;
        ZonaSeguridadUsuarioDto response;
        CreateZonaSeguridadUsuarioCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadUsuarioService.addZonaSeguridadUsuario" );
        //endregion

        try
        {
            entity = ZonaSeguridadUsuarioMapper.mapDtoToEntityInsert( userDto );
            command = CommandFactory.createCreateZonaSeguridadUsuarioCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = ZonaSeguridadUsuarioMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Insertar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Zona Seguridad " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguridadUsuarioService.addZonaSeguridadUsuario" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Insertado: " + userDto.getId())).build();
    }

    @DELETE
    @Path("/delete")
    public Response deleteZonaSeguridadUsuario( ZonaSeguridadUsuarioDto userDto )
    {
        ZonaSeguridadUsuario entity;
        ZonaSeguridadUsuarioDto response;
        DeleteZonaSeguridadUsuarioCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadUsuarioService.deleteZonaSeguridadUsuario" );
        //endregion

        try
        {
            entity = ZonaSeguridadUsuarioMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createDeleteZonaSeguridadUsuarioCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = ZonaSeguridadUsuarioMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede eliminar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Zona Seguridad " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguridadUsuarioService.deleteZonaSeguridadUsuario" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Eliminado: " + userDto.getId())).build();
    }


    @PUT
    @Path("/update")
    public Response updateZonaSeguridadUsuario( ZonaSeguridadUsuarioDto userDto )
    {
        ZonaSeguridadUsuario entity;
        ZonaSeguridadUsuarioDto response;
        UpdateZonaSeguridadUsuarioCommand command = null;
        ZonaSeguridadUsuarioDao base = new ZonaSeguridadUsuarioDao();
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadUsuarioService.deleteZonaSeguridadUsuario" );
        //endregion

        try
        {
            if (base.find(userDto.getId(), ZonaSeguridadUsuario.class) == null){
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se encuentra el Objeto registrado " + userDto.getId())).build();

            }
            entity = ZonaSeguridadUsuarioMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdateZonaSeguridadUsuarioCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = ZonaSeguridadUsuarioMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede editar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Zona Seguridad " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguridadUsuarioService.deleteZonaSeguridadUsuario" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Editado: " + userDto.getId())).build();
    }
}

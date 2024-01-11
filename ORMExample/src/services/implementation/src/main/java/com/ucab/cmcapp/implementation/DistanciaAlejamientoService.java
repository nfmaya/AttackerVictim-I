package com.ucab.cmcapp.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salas.Sender;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.DistanciaAlejamiento;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic.GetDistanciaAlejamientoByUsuariosCommand;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.composite.*;

import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByIdCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.DeleteUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.UpdateUsuarioCommand;
import com.ucab.cmcapp.logic.dtos.DistanciaAlejamientoDto;
import com.ucab.cmcapp.logic.dtos.DistanciaAlejamientoDto;
import com.ucab.cmcapp.logic.dtos.DistanciaAlejamientoWithSeparacionDto;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @GET
    @Path("/count")
    public int countDistanciaAlejamiento() {
        List<DistanciaAlejamientoDto> allDistancias;
        int count = 0;
        _logger.debug("Get in DistanciaAlejamientoService.countDistanciaAlejamiento");

        try {
            allDistancias = getAllDistanciaAlejamiento2();
            if (allDistancias == null) {
                return count;
            }
        } catch (Exception e) {
            _logger.error("An error occurred", e);
            return count;
        }

        count = allDistancias.size();
        _logger.debug("Leaving DistanciaAlejamientoService.countDistanciaAlejamiento");
        return count;
    }

    //endpoint que devuelve la DistanciaAlejamiento de un Usuario
    @GET
    @Path( "/usuario/{id}" )
    public Response getDistanciaAlejamientoUsuario(@PathParam( "id" ) long distanciaId )
    {
        List<DistanciaAlejamientoDto> response;
        GetDistanciaAlejamientoUsuariosCommand command = null;
        _logger.debug( "Get in DistanciaAlejamientoService.getDistanciaAlejamientoUsuario" );

        try
        {
            _logger.debug("Creating GetDistanciaAlejamientoUsuariosCommand with IdUsuario: " + distanciaId);
            command = CommandFactory.createGetDistanciaAlejamientoUsuariosCommand(distanciaId);
            _logger.debug("Executing GetDistanciaAlejamientoUsuariosCommand");
            command.execute();
            if(command.getReturnParam() != null){
                _logger.debug("Mapping entities to DTOs");
                response = DistanciaAlejamientoMapper.mapListEntityToDto(command.getReturnParam());
            }else{
                _logger.debug("No entities found for IdUsuario: " + distanciaId);
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + distanciaId)).build();
            }
        }
        catch ( Exception e )
        {
            _logger.debug(String.format("error: %s", e));
            _logger.error("An error occurred", e);
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Distancia" + distanciaId)).build();
        }


        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }





        _logger.debug( "Leaving DistanciaAlejamientoService.getDistanciaAlejamientoUsuario" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Usuario: " + distanciaId)).build();
    }


    //metodo que devuelve la DistanciaAlejamiento de un Usuario
    public long getDistanciaAlejamientoUsuarioAgresorId(long distanciaId )
    {
        List<DistanciaAlejamientoDto> response;
        GetDistanciaAlejamientoUsuariosCommand command = null;
        _logger.debug( "Get in DistanciaAlejamientoService.getDistanciaAlejamientoUsuario" );
        long id;

        try
        {
            command = CommandFactory.createGetDistanciaAlejamientoUsuariosCommand(distanciaId);
            command.execute();
            if(command.getReturnParam() != null){
                response = DistanciaAlejamientoMapper.mapListEntityToDto(command.getReturnParam());
                id = response.get(0).get_agresor().getId();
            }else{
return 0;            }
        }
        catch ( Exception e )
        {
            return 0;
        }

        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }


        _logger.debug( "Leaving DistanciaAlejamientoService.getDistanciaAlejamientoUsuario" );
        return id;
    }

    //metodo para buscar el Id de la victima de una DistanciaAlejamiento
    public long getDistanciaAlejamientoUsuarioVictimaId(long distanciaId )
    {
        List<DistanciaAlejamientoDto> response;
        GetDistanciaAlejamientoUsuariosCommand command = null;
        _logger.debug( "Get in DistanciaAlejamientoService.getDistanciaAlejamientoUsuario" );
        long id;

        try
        {
            command = CommandFactory.createGetDistanciaAlejamientoUsuariosCommand(distanciaId);
            command.execute();
            if(command.getReturnParam() != null){
                response = DistanciaAlejamientoMapper.mapListEntityToDto(command.getReturnParam());
                id = response.get(0).get_victima().getId();
            }else{
                return 0;            }
        }
        catch ( Exception e )
        {
            return 0;
        }

        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }


        _logger.debug( "Leaving DistanciaAlejamientoService.getDistanciaAlejamientoUsuario" );
        return id;
    }


    //metodo para buscar el Id del Agresor de una DistanciaAlejamiento
    public float getDistanciaAlejamientoUsuarioDistanciaMin(long distanciaId )
    {
        List<DistanciaAlejamientoDto> response;
        GetDistanciaAlejamientoUsuariosCommand command = null;
        _logger.debug( "Get in DistanciaAlejamientoService.getDistanciaAlejamientoUsuario" );
        float distanciaMin;

        try
        {
            command = CommandFactory.createGetDistanciaAlejamientoUsuariosCommand(distanciaId);
            command.execute();
            if(command.getReturnParam() != null){
                response = DistanciaAlejamientoMapper.mapListEntityToDto(command.getReturnParam());
                distanciaMin = response.get(0).get_distanciaMinima();
            }else{
                return 0;            }
        }
        catch ( Exception e )
        {
            return 0;
        }

        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }


        _logger.debug( "Leaving DistanciaAlejamientoService.getDistanciaAlejamientoUsuario" );
        return distanciaMin;
    }


    //endpoint que devuelve las DistanciaAlejamientos (completo)
    @GET
    @Path( "/findAll" )
    public Response getAllDistanciaAlejamiento()
    {
        List<DistanciaAlejamientoDto> response;
        GetAllDistanciaAlejamientoCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in DistanciaAlejamientoService.getDistanciaAlejamiento" );
        //endregion

        try
        {
            command = CommandFactory.createGetAllDistanciaAlejamientoCommand();
            command.execute();
            if(command.getReturnParam() != null){
                response = DistanciaAlejamientoMapper.mapListEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " )).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en DistanciaAlejamiento ")).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving DistanciaAlejamientoService.getDistanciaAlejamiento" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id DistanciaAlejamiento: " )).build();
    }


    //metodo que devuelve las DistanciaAlejamientos (completo) en forma de List
    public List<DistanciaAlejamientoDto> getAllDistanciaAlejamiento2()
    {
        List<DistanciaAlejamientoDto> response = null;
        GetAllDistanciaAlejamientoCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in DistanciaAlejamientoService.getDistanciaAlejamiento" );
        //endregion

        try
        {
            command = CommandFactory.createGetAllDistanciaAlejamientoCommand();
            command.execute();
            if(command.getReturnParam() != null){
                response = DistanciaAlejamientoMapper.mapListEntityToDto(command.getReturnParam());
            }else{
                return response;

            }
        }
        catch ( Exception e )
        {
            return response;

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving DistanciaAlejamientoService.getDistanciaAlejamiento" );
        return response;
    }


    //endpoint que ejecuta los calculos de distancias entre Victimas y Agresores, por DistanciaAlejamiento.
    //Osea ejecuta un findAll, donde va por cada DistanciaAlejamiento y calcula la distancia entre los usuarios
    //lo devuelve en forma de List con un Dto modificado, con la separacion siendo la distancia calculada
    @GET
    @Path("/calculateDistances")
    public Response calculateDistancesBetweenUsuarios() {
        List<DistanciaAlejamientoDto> distancias;
        List<DistanciaAlejamientoWithSeparacionDto> distances = new ArrayList<>();
        GetAllDistanciaAlejamientoCommand command = null;
        PosicionService posicionService = new PosicionService();
        //Map<DistanciaAlejamientoWithSeparacionDto, Double> distances = new HashMap<>();

        try {
        command = CommandFactory.createGetAllDistanciaAlejamientoCommand();
        command.execute();
        if (command.getReturnParam() != null) {
            distancias = DistanciaAlejamientoMapper.mapListEntityToDto(command.getReturnParam());
            for (DistanciaAlejamientoDto distancia : distancias) {
                long idUsuario1 = distancia.get_agresor().getId();
                long idUsuario2 = distancia.get_victima().getId();
                double distance = posicionService.getAllPosicionUsuarioLastCalc2(idUsuario1, idUsuario2);

                    DistanciaAlejamientoWithSeparacionDto distanciaWithSeparacion = new DistanciaAlejamientoWithSeparacionDto();
                    distanciaWithSeparacion.setSeparacion(distance);
                    distanciaWithSeparacion.set_agresor(distancia.get_agresor());
                    distanciaWithSeparacion.set_victima(distancia.get_victima());
                    distanciaWithSeparacion.setId(distancia.getId());
                    distanciaWithSeparacion.set_distanciaMinima(distancia.get_distanciaMinima());

                distances.add(distanciaWithSeparacion);
            }
        } else {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por ")).build();
        }

    } catch (Exception e) {
        return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en DistanciaAlejamiento ")).build();
    } finally {
        if (command != null)
            command.closeHandlerSession();
    }



        return Response.status(Response.Status.OK).entity(new CustomResponse<>(distances, "Distancias calculadas")).build();
    }




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
            entity = DistanciaAlejamientoMapper.mapDtoToEntityInsert( distanciaDto );
            command = CommandFactory.createCreateDistanciaAlejamientoCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = DistanciaAlejamientoMapper.mapEntityToDto(command.getReturnParam());
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

    @GET
    @Path("/calculateDistance/{id}")
    public Response calculateDistance(@PathParam("id") long distanciaId) {
        PosicionService posicionService = new PosicionService();
        long idUsuario1 = getDistanciaAlejamientoUsuarioAgresorId(distanciaId);
        long idUsuario2 = getDistanciaAlejamientoUsuarioVictimaId(distanciaId);
        double distance;

        try {
            distance = posicionService.getAllPosicionUsuarioLastCalc2(idUsuario1, idUsuario2);
        } catch (Exception e) {
            _logger.error("An error occurred", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error calculating distance")).build();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(distance, "Calculated distance")).build();
    }

    @POST
    @Path("/insertComplete")
    public Response addDistanciaAlejamientoComplete( DistanciaAlejamientoDto distanciaDto )
    {
        DistanciaAlejamiento entity;
        DistanciaAlejamientoDto response;
        CreateDistanciaAlejamientoCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in DistanciaAlejamientoService.addDistanciaAlejamiento" );
        //endregion

        try
        {
            UsuarioService usuarioService = new UsuarioService();

            UsuarioDto agresor = usuarioService.addUsuarioDto(distanciaDto.get_agresor());

            UsuarioDto victima = usuarioService.addUsuarioDto(distanciaDto.get_victima());

            distanciaDto.set_agresor(agresor);

            distanciaDto.set_victima(victima);


            entity = DistanciaAlejamientoMapper.mapDtoToEntityInsert( distanciaDto );
            command = CommandFactory.createCreateDistanciaAlejamientoCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = DistanciaAlejamientoMapper.mapEntityToDto(command.getReturnParam());
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
    public Response deleteDistanciaAlejamiento( DistanciaAlejamientoDto userDto )
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
    public Response updateDistanciaAlejamiento( DistanciaAlejamientoDto userDto )
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

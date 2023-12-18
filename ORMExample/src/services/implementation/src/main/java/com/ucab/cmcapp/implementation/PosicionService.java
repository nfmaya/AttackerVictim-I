package com.ucab.cmcapp.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salas.Sender;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.posicion.composite.GetAllPosicionCommand;
import com.ucab.cmcapp.logic.commands.posicion.composite.CreatePosicionCommand;
import com.ucab.cmcapp.logic.commands.posicion.composite.DeletePosicionCommand;
import com.ucab.cmcapp.logic.commands.posicion.composite.GetPosicionCommand;
import com.ucab.cmcapp.logic.commands.posicion.composite.UpdatePosicionCommand;
import com.ucab.cmcapp.logic.dtos.*;
import com.ucab.cmcapp.logic.dtos.PosicionDto;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import com.ucab.cmcapp.logic.mappers.PosicionMapper;
import com.ucab.cmcapp.logic.mappers.PosicionMapper;
import com.ucab.cmcapp.persistence.dao.PosicionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Path( "/posicion" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class PosicionService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( PosicionService.class );

    @GET
    @Path( "/{id}" )
    public Response getPosicion(@PathParam( "id" ) long userId )
    {
        Posicion entity;
        PosicionDto response;
        GetPosicionCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionService.getPosicion" );
        //endregion

        try
        {
            entity = PosicionMapper.mapDtoToEntity( userId );
            command = CommandFactory.createGetPosicionCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = PosicionMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " + userId)).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Posicion " + userId)).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PosicionService.getPosicion" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Busqueda por Id Posicion: " + userId)).build();
    }

    public double calculateDistance(PosicionDto pos1, PosicionDto pos2) {
        float xDiff = pos1.getCoordenadaX() - pos2.getCoordenadaX();
        float yDiff = pos1.getCoordenadaY() - pos2.getCoordenadaY();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    @GET
    @Path( "/usuario/{id}" )
    public Response getAllPosicionUsuarioLast1(@PathParam( "id" ) long id )
    {
        List<PosicionDto> response;
        PosicionDto lastResponse = null;
        GetAllPosicionCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionService.getPosicion" );
        //endregion

        try
        {
            command = CommandFactory.createGetAllPosicionCommand(id);
            command.execute();
            if(command.getReturnParam() != null){
                response = PosicionMapper.mapListEntityToDto(command.getReturnParam());
                if (!response.isEmpty()) {
                    lastResponse = response.get(response.size() - 1);
                } else {
                    return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " )).build();
                }
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " )).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Posicion ")).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PosicionService.getPosicion" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(lastResponse,"Busqueda por Id Posicion: " )).build();
    }

    @GET
    @Path( "/usuario/{id1}/{id2}" )
    public Response getAllPosicionUsuarioLastCalc(@PathParam( "id1" ) long id1, @PathParam( "id2" ) long id2 )
    {
        List<PosicionDto> response1, response2;
        PosicionDto lastResponse1 = null, lastResponse2 = null;
        GetAllPosicionCommand command1 = null, command2 = null;
        double distance = 0.0;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionService.getPosicion" );
        //endregion

        try
        {
            command1 = CommandFactory.createGetAllPosicionCommand(id1);
            command1.execute();
            command2 = CommandFactory.createGetAllPosicionCommand(id2);
            command2.execute();
            if(command1.getReturnParam() != null && command2.getReturnParam() != null){
                response1 = PosicionMapper.mapListEntityToDto(command1.getReturnParam());
                response2 = PosicionMapper.mapListEntityToDto(command2.getReturnParam());
                if (!response1.isEmpty() && !response2.isEmpty()) {
                    lastResponse1 = response1.get(response1.size() - 1);
                    lastResponse2 = response2.get(response2.size() - 1);
                    distance = calculateDistance(lastResponse1, lastResponse2);
                } else {
                    return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " )).build();
                }
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Buscar por " )).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Posicion ")).build();

        }
        finally
        {
            if (command1 != null)
                command1.closeHandlerSession();
            if (command2 != null)
                command2.closeHandlerSession();
        }

        _logger.debug( "Leaving PosicionService.getPosicion" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(""+distance)).build();
    }


    public double getAllPosicionUsuarioLastCalc2(long id1, long id2 )
    {
        List<PosicionDto> response1, response2;
        PosicionDto lastResponse1 = null, lastResponse2 = null;
        GetAllPosicionCommand command1 = null, command2 = null;
        double distance = 0.0;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionService.getPosicion" );
        //endregion

        try
        {
            command1 = CommandFactory.createGetAllPosicionCommand(id1);
            command1.execute();
            command2 = CommandFactory.createGetAllPosicionCommand(id2);
            command2.execute();
            if(command1.getReturnParam() != null && command2.getReturnParam() != null){
                response1 = PosicionMapper.mapListEntityToDto(command1.getReturnParam());
                response2 = PosicionMapper.mapListEntityToDto(command2.getReturnParam());
                if (!response1.isEmpty() && !response2.isEmpty()) {
                    lastResponse1 = response1.get(response1.size() - 1);
                    lastResponse2 = response2.get(response2.size() - 1);
                    distance = calculateDistance(lastResponse1, lastResponse2);
                } else {
                return 0.0;                }
            }else{
return 0.0;            }
        }
        catch ( Exception e )
        {
return 0.0;
        }
        finally
        {
            if (command1 != null)
                command1.closeHandlerSession();
            if (command2 != null)
                command2.closeHandlerSession();
        }

        _logger.debug( "Leaving PosicionService.getPosicion" );
return distance;
    }


    public void checkAllUsersLastPositionTimestamp() {
        // Get a list of all users
        UsuarioService usuarioService = new UsuarioService();
        List<UsuarioDto> allUsers = usuarioService.getAllUsuarioList();
        List<PosicionDto> response;
        PosicionDto lastPosition = null;
        GetAllPosicionCommand command = null;

        // Define the acceptable time difference (in milliseconds)
        //long acceptableTimeDifference = 3600000; // 1 hour
        long acceptableTimeDifference = 600000; // 10 minutes

        // Get the current time
        long currentTime = System.currentTimeMillis();

        // Iterate over all users
        for (UsuarioDto user : allUsers) {
            // Get the last position of the user
            try {
                command = CommandFactory.createGetAllPosicionCommand(user.getId());
                command.execute();
                if(command.getReturnParam() != null){
                    response = PosicionMapper.mapListEntityToDto(command.getReturnParam());
                    if (!response.isEmpty()) {
                        lastPosition = response.get(response.size() - 1);
                    } else {
                        break;
                    }
                }else{
                    break;
                }
            }
            catch ( Exception e ) {
                break;
            }

            // Check if the last position exists
            if (lastPosition != null) {
                // Get the timestamp of the last position
                long lastPositionTime = lastPosition.getFechaHora().getTime();

                // Calculate the time difference
                long timeDifference = currentTime - lastPositionTime;

                // Check if the time difference is greater than the acceptable time difference
                if (timeDifference > acceptableTimeDifference) {
                    // Create a new alert
                    AlertaDto alertaDto = new AlertaDto();
                    alertaDto.set_tipoAlerta("No position update");
                    alertaDto.set_fechaHora(new Date());
                    alertaDto.setUsuario(user);

                    // Create an instance of AlertaService
                    AlertaService alertaService = new AlertaService();
                    // Call the method to insert the alert
                    alertaService.addAlerta(alertaDto);
                }
            }
        }
    }


    @POST
    @Path("/insertVictima")
    public Response addPosicionVictima( PosicionDto userDto )
    {
        Posicion entity;
        PosicionDto response;
        CreatePosicionCommand command = null;
        Response customResponse = null;
        DistanciaAlejamientoService distanciaAlejamientoService = new DistanciaAlejamientoService();
        long idAgresor;
        double distancia = 0.0;
        double distanciaMin = 0.0;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionService.addPosicion" );
        //endregion

        try{
            entity = PosicionMapper.mapDtoToEntityInsert( userDto );
            command = CommandFactory.createCreatePosicionCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = PosicionMapper.mapEntityToDto(command.getReturnParam());

                idAgresor = distanciaAlejamientoService.getDistanciaAlejamientoUsuarioAgresorId(userDto.getId());
                distanciaMin = distanciaAlejamientoService.getDistanciaAlejamientoUsuarioDistanciaMin(userDto.getId());
                if (idAgresor != 0){
                    distancia = getAllPosicionUsuarioLastCalc2(userDto.getId(), idAgresor);

                    if (distancia <= distanciaMin){

                    //aqui se construye el objeto de alerta

                        // Create an instance of AlertaDto
                        AlertaDto alertaDto = new AlertaDto();
                        // Set the properties of alertaDto as needed
                        alertaDto.set_tipoAlerta("Dentro radio");
                        alertaDto.set_fechaHora(new Date());
                        alertaDto.setUsuario(userDto.getUsuario());

                        // Create an instance of AlertaService
                        AlertaService alertaService = new AlertaService();
                        // Call the method to insert the alert
                        alertaService.addAlerta(alertaDto);

                        //TAMBIEN SE VA A LLAMAR AL FIREBASE

                    }
                }
                checkAllUsersLastPositionTimestamp();
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Insertar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Posicion " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PosicionService.addPosicion" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,""+ distancia)).build();
    }


    @POST
    @Path("/insertAgresor")
    public Response addPosicionAgresor( PosicionDto userDto )
    {
        Posicion entity;
        PosicionDto response;
        CreatePosicionCommand command = null;

        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionService.addPosicion" );
        //endregion

        try
        {
            entity = PosicionMapper.mapDtoToEntityInsert( userDto );
            command = CommandFactory.createCreatePosicionCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = PosicionMapper.mapEntityToDto(command.getReturnParam());

            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede Insertar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Posicion " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PosicionService.addPosicion" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Insertado: " + userDto.getId())).build();
    }


    @DELETE
    @Path("/delete")
    public Response deletePosicion( PosicionDto userDto )
    {
        Posicion entity;
        PosicionDto response;
        DeletePosicionCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionService.deletePosicion" );
        //endregion

        try
        {
            entity = PosicionMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createDeletePosicionCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = PosicionMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede eliminar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Posicion " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PosicionService.deletePosicion" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Eliminado: " + userDto.getId())).build();
    }


    @PUT
    @Path("/update")
    public Response updatePosicion( PosicionDto userDto )
    {
        Posicion entity;
        PosicionDto response;
        UpdatePosicionCommand command = null;
        PosicionDao base = new PosicionDao();
        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionService.deletePosicion" );
        //endregion

        try
        {
            if (base.find(userDto.getId(), Posicion.class) == null){
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se encuentra el Objeto registrado " + userDto.getId())).build();

            }
            entity = PosicionMapper.mapDtoToEntity( userDto );
            command = CommandFactory.createUpdatePosicionCommand( entity );
            command.execute();
            if(command.getReturnParam() != null){
                response = PosicionMapper.mapEntityToDto(command.getReturnParam());
            }else{
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede editar " + userDto.getId())).build();
            }
        }
        catch ( Exception e )
        {
            return Response.status(Response.Status.OK).entity(new CustomResponse<>("Error en Posicion " + userDto.getId())).build();

        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PosicionService.deletePosicion" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Editado: " + userDto.getId())).build();
    }
}

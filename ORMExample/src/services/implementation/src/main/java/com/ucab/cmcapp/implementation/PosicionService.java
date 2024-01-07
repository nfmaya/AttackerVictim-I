package com.ucab.cmcapp.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.salas.FirebaseSender;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.common.entities.ZonaSeguridadUsuario;
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

    //metodo para calcular la disrtancia entre dos puntos
    public double calculateDistance(PosicionDto pos1, PosicionDto pos2) {
        float xDiff = pos1.getCoordenadaX() - pos2.getCoordenadaX();
        float yDiff = pos1.getCoordenadaY() - pos2.getCoordenadaY();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    //endpoint para obtener la ultima posicion de un usuario dado su id
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


    //metodo que devuelve la ultima posicion de un usuario dado su id
    public List<PosicionDto> getAllPosicionUsuarioLast1Me(long id )
    {
        List<PosicionDto> response = null;
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
                    return response;
                }
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

        _logger.debug( "Leaving PosicionService.getPosicion" );
        return response;
    }


    //endpoint para obtener la distancia de dos usuarios dado sus ids
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

    //metodo para obtener la distancia de dos usuarios dado sus ids
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


    //TODO:
    //ver si se pone como endpoint o se llama desde otro lado

    //metodo que checkea si un usuario no ha actualizado su posicion en un tiempo determinado
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


    //endpoint para checkear si un usuario no ha actualizado su posicion en un tiempo determinado.
    //Conectado o no
    @GET
    @Path( "/estatus/{id}" )
    public boolean checkUserLastPositionTimestamp(@PathParam( "id" ) long userId ) {
        // Define the acceptable time difference (in milliseconds)
        long acceptableTimeDifference = 600000; // 10 minutes

        // Get the current time
        long currentTime = System.currentTimeMillis();

        // Get the last position of the user
        List<PosicionDto> userLastPosition = getAllPosicionUsuarioLast1Me(userId);
        if (!userLastPosition.isEmpty()) {
            PosicionDto lastPosition = userLastPosition.get(userLastPosition.size() - 1);

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
                alertaDto.setUsuario(lastPosition.getUsuario());

                // Create an instance of AlertaService
                AlertaService alertaService = new AlertaService();
                // Call the method to insert the alert
                alertaService.addAlerta(alertaDto);

                return false;
            }else
                return true;

        }
        return false;
    }


    //TODO:
    //ver si se pone como endpoint o se llama desde otro lado

    //metodo que checkea si un usuario esta enviando la misma posicion. despues de 10 envios
    public void checkAllUsersSamePosition() {
        // Get a list of all users
        UsuarioService usuarioService = new UsuarioService();
        List<UsuarioDto> allUsers = usuarioService.getAllUsuarioList();
        List<PosicionDto> response;
        GetAllPosicionCommand command = null;

        // Iterate over all users
        for (UsuarioDto user : allUsers) {
            // Get the last 5 positions of the user
            try {
                command = CommandFactory.createGetAllPosicionCommand(user.getId());
                command.execute();
                if(command.getReturnParam() != null){
                    response = PosicionMapper.mapListEntityToDto(command.getReturnParam());
                    if (response.size() >= 5) {
                        // Check if the last 10 positions are the same
                        PosicionDto referencePosition = response.get(response.size() - 1);
                        boolean allSame = true;
                        for (int i = 2; i <= 5; i++) {
                            PosicionDto currentPosition = response.get(response.size() - i);
                            if (currentPosition.getCoordenadaX() != referencePosition.getCoordenadaX() ||
                                    currentPosition.getCoordenadaY() != referencePosition.getCoordenadaY()) {
                                allSame = false;
                                break;
                            }
                        }
                        if (allSame) {
                            // The user is sending the same location
                            //aqui se construye el objeto de alerta

                            // Create an instance of AlertaDto
                            AlertaDto alertaDto = new AlertaDto();
                            // Set the properties of alertaDto as needed
                            alertaDto.set_tipoAlerta("Inactivo por 5 envios");
                            alertaDto.set_fechaHora(new Date());
                            alertaDto.setUsuario(user);

                            // Create an instance of AlertaService
                            AlertaService alertaService = new AlertaService();
                            // Call the method to insert the alert
                            alertaService.addAlerta(alertaDto);

                            //TAMBIEN SE VA A LLAMAR AL FIREBASE
                        }
                    }
                }
            }
            catch ( Exception e ) {
                continue;
            }
        }
    }



    //endpoint para insertar la ultima ubicacion de la Victima. devuelve la ultima posicion en el response del POST
    //asi como tambien si el agresor se encuentra dentro del radio de distancia minima, envia una Alerta
    //y tambien si el agresor se encuentra dentro de la zona de seguridad de la victima, envia una Alerta
    //ejecuta el checkeo de la ultima posicion
    //TODO: ver si las llamadas de los checkeos se hacen aca
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
                        alertaDto.set_tipoAlerta("Agresor Dentro radio");
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
                checkAgresorInsideVictimaZonaSeguridad();
                checkAllUsersSamePosition();
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


    //endpoint para insertar la posicion de un Agresor. solo vse ejecuta el checkeo de la zona de seguridad
    //TODO: ver si la llamada del chekceo se hace aca
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

        checkAgresorInsideVictimaZonaSeguridad();

        _logger.debug( "Leaving PosicionService.addPosicion" );
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(response,"Insertado: " + userDto.getId())).build();
    }

    //metodo que checkea si un usuario se encuentra dentro de la zona de seguridad de una victima dada
    public boolean isUserInsideSafeZone(PosicionDto userPosition, List<CoordenadaZonaSeguridadDto> safeZoneCoordinatesList) {
        int i, j;
        boolean result = false;
        for (i = 0, j = safeZoneCoordinatesList.size() - 1; i < safeZoneCoordinatesList.size(); j = i++) {
            if ((safeZoneCoordinatesList.get(i).getCoordenadaY() > userPosition.getCoordenadaY()) != (safeZoneCoordinatesList.get(j).getCoordenadaY() > userPosition.getCoordenadaY()) &&
                    (userPosition.getCoordenadaX() < (safeZoneCoordinatesList.get(j).getCoordenadaX() - safeZoneCoordinatesList.get(i).getCoordenadaX()) * (userPosition.getCoordenadaY() - safeZoneCoordinatesList.get(i).getCoordenadaY()) / (safeZoneCoordinatesList.get(j).getCoordenadaY()-safeZoneCoordinatesList.get(i).getCoordenadaY()) + safeZoneCoordinatesList.get(i).getCoordenadaX())) {
                result = !result;
            }
        }
        return result;
    }

    //metodo que checkea si un agresor se encuentra dentro de la zona de seguridad. ejecuta el analisis completo
    public void checkAgresorInsideVictimaZonaSeguridad() {
        // Step 1: Get all DistanciaAlejamiento relations
        DistanciaAlejamientoService distanciaAlejamientoService = new DistanciaAlejamientoService();
        ZonaSeguridadUsuarioService zonaSeguridadUsuarioService = new ZonaSeguridadUsuarioService();
        CoordenadaZonaSeguridadService coordenadaZonaSeguridadService = new CoordenadaZonaSeguridadService();

        List<DistanciaAlejamientoDto> allDistanciaAlejamiento = distanciaAlejamientoService.getAllDistanciaAlejamiento2();

        // Step 2: Iterate over each DistanciaAlejamiento relation
        for (DistanciaAlejamientoDto distanciaAlejamiento : allDistanciaAlejamiento) {
            long victimaId = distanciaAlejamiento.get_victima().getId();
            long agresorId = distanciaAlejamiento.get_agresor().getId();

            // Step 3: Get all ZonaSeguridad for the Victima
            List<ZonaSeguridadUsuarioDto> allZonaSeguridad = zonaSeguridadUsuarioService.getUsuarioAllZonaSeguridad2(victimaId);

            // Step 4: Iterate over each ZonaSeguridad
            for (ZonaSeguridadUsuarioDto zonaSeguridad : allZonaSeguridad) {
                List<CoordenadaZonaSeguridadDto> allCoordenadas = coordenadaZonaSeguridadService.getCoordenadaAllZonaSeguridad2(zonaSeguridad.getId());

                // Step 5: Get the last position of the Agresor
                List<PosicionDto> agresorLastPosition = getAllPosicionUsuarioLast1Me(agresorId);
                PosicionDto agresorLastPos = agresorLastPosition.get(agresorLastPosition.size() - 1);


                // Step 6: Check if the Agresor position is inside the ZonaSeguridad polygon
                if (isUserInsideSafeZone(agresorLastPos, allCoordenadas)) {
                    //aqui se construye el objeto de alerta

                    // Create an instance of AlertaDto
                    AlertaDto alertaDto = new AlertaDto();
                    // Set the properties of alertaDto as needed
                    alertaDto.set_tipoAlerta("Agresor Dentro Zona Seguridad");
                    alertaDto.set_fechaHora(new Date());
                    alertaDto.setUsuario(distanciaAlejamiento.get_victima());

                    // Create an instance of AlertaService
                    AlertaService alertaService = new AlertaService();
                    // Call the method to insert the alert
                    alertaService.addAlerta(alertaDto);

                    //TAMBIEN SE VA A LLAMAR AL FIREBASE

                    FirebaseSender firebaseSender = new FirebaseSender();

                    try {
                        //firebaseSender.SenderVictim(distanciaAlejamiento.get_victima().getIMEI());
                        firebaseSender.SenderVictim("f6pIHEg_QVCPankV0cBSJq:APA91bF8pdkwuXP89onw4tY0xcTc-GOxKY4XVH4yenJRTFTEBb-QMUOPt2Gq5rAZENwhNdc5mkdK0_3tlLwJJOCHlBLrhbyIMQkfnTZ3oO9Nh-eE4t9RVK5nlb6IsYqrsjncOzvlRUCQ");


                    } catch (IOException | FirebaseMessagingException e) {
                        throw new RuntimeException(e);
                    }


                }
            }
        }
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

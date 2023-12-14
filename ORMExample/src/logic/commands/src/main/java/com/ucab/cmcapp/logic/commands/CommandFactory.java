package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.atomic.*;
import com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.composite.*;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic.*;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.composite.*;
import com.ucab.cmcapp.logic.commands.TiempoControl.atomic.*;
import com.ucab.cmcapp.logic.commands.TiempoControl.composite.*;
import com.ucab.cmcapp.logic.commands.UserType.atomic.AddUserTypeCommand;
import com.ucab.cmcapp.logic.commands.UserType.atomic.DeleteUserTypeByIdCommand;
import com.ucab.cmcapp.logic.commands.UserType.atomic.GetUserTypeByIdCommand;
import com.ucab.cmcapp.logic.commands.UserType.atomic.UpdateUserTypeByIdCommand;
import com.ucab.cmcapp.logic.commands.UserType.composite.CreateUserTypeCommand;
import com.ucab.cmcapp.logic.commands.UserType.composite.DeleteUserTypeCommand;
import com.ucab.cmcapp.logic.commands.UserType.composite.GetUserTypeCommand;
import com.ucab.cmcapp.logic.commands.UserType.composite.UpdateUserTypeCommand;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.atomic.*;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite.*;
import com.ucab.cmcapp.logic.commands.alerta.atomic.*;
import com.ucab.cmcapp.logic.commands.alerta.composite.CreateAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.DeleteAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.GetAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.UpdateAlertaCommand;
import com.ucab.cmcapp.logic.commands.posicion.atomic.AddPosicionCommand;
import com.ucab.cmcapp.logic.commands.posicion.atomic.DeletePosicionByIdCommand;
import com.ucab.cmcapp.logic.commands.posicion.atomic.GetPosicionByIdCommand;
import com.ucab.cmcapp.logic.commands.posicion.atomic.UpdatePosicionByIdCommand;
import com.ucab.cmcapp.logic.commands.posicion.composite.CreatePosicionCommand;
import com.ucab.cmcapp.logic.commands.posicion.composite.DeletePosicionCommand;
import com.ucab.cmcapp.logic.commands.posicion.composite.GetPosicionCommand;
import com.ucab.cmcapp.logic.commands.posicion.composite.UpdatePosicionCommand;
import com.ucab.cmcapp.logic.commands.puntoControl.atomic.AddPuntoControlCommand;
import com.ucab.cmcapp.logic.commands.puntoControl.atomic.DeletePuntoControlByIdCommand;
import com.ucab.cmcapp.logic.commands.puntoControl.atomic.GetPuntoControlByIdCommand;
import com.ucab.cmcapp.logic.commands.puntoControl.atomic.UpdatePuntoControlByIdCommand;
import com.ucab.cmcapp.logic.commands.puntoControl.composite.CreatePuntoControlCommand;
import com.ucab.cmcapp.logic.commands.puntoControl.composite.DeletePuntoControlCommand;
import com.ucab.cmcapp.logic.commands.puntoControl.composite.GetPuntoControlCommand;
import com.ucab.cmcapp.logic.commands.puntoControl.composite.UpdatePuntoControlCommand;

import com.ucab.cmcapp.logic.commands.usuario.atomic.*;
import com.ucab.cmcapp.logic.commands.usuario.composite.*;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class CommandFactory
{

    //Usuario

    public static GetUsuarioCommand createGetUsuarioCommand(Usuario user)
    {
        return new GetUsuarioCommand(user);
    }

    public static GetAllUsuarioCommand createGetAllUsuarioCommand()
    {
        return new GetAllUsuarioCommand();
    }

    public static GetAllUsuarioByIdCommand createGetAllUsuarioByIdCommand (DBHandler handler )
    {
        return new GetAllUsuarioByIdCommand(handler);
    }



    public static GetUsuarioByUsernameCommand createGetUsuarioByUsernameCommand(Usuario user)
    {
        return new GetUsuarioByUsernameCommand(user);
    }

    public static GetUsuarioByUsernameCommand createGetUsuarioByUsernameCommand(Usuario user, DBHandler handler)
    {
        return new GetUsuarioByUsernameCommand(user, handler);
    }

    public static DeleteUsuarioByIdCommand createDeleteUsuarioByIdCommand(Usuario user, DBHandler handler)
    {
        return new DeleteUsuarioByIdCommand(user, handler);
    }

    public static DeleteUsuarioByIdCommand createDeleteUsuarioByIdCommand(Usuario user)
    {
        return new DeleteUsuarioByIdCommand(user);
    }

    public static DeleteUsuarioCommand createDeleteUsuarioCommand(Usuario user)
    {
        return new DeleteUsuarioCommand(user);
    }

    public static UpdateUsuarioByIdCommand createUpdateUsuarioByIdCommand(Usuario user, DBHandler handler)
    {
        return new UpdateUsuarioByIdCommand(user, handler);
    }

    public static UpdateUsuarioByIdCommand createUpdateUsuarioByIdCommand(Usuario user)
    {
        return new UpdateUsuarioByIdCommand(user);
    }

    public static UpdateUsuarioCommand createUpdateUsuarioCommand(Usuario user)
    {
        return new UpdateUsuarioCommand(user);
    }


    public static GetUsuarioByIdCommand createGetUsuarioByIdCommand (DBHandler handler, long userId )
    {
        return new GetUsuarioByIdCommand(handler, userId);
    }


    public static AddUsuarioCommand createAddUsuarioCommand(Usuario user, DBHandler handler)
    {
        return new AddUsuarioCommand(user, handler);
    }

    public static AddUsuarioCommand createAddUsuarioCommand(Usuario user)
    {
        return new AddUsuarioCommand(user);
    }

    public static CreateUsuarioCommand createCreateUsuarioCommand(Usuario user)
    {
        return new CreateUsuarioCommand(user);
    }


    //Alerta
    public static GetAlertaCommand createGetAlertaCommand(Alerta alerta)
    {
        return new GetAlertaCommand(alerta);
    }

    public static GetAlertaByTipoAlertaCommand createGetAlertaByTipoAlertaCommand(Alerta alerta)
    {
        return new GetAlertaByTipoAlertaCommand(alerta);
    }

    public static GetAlertaByTipoAlertaCommand createGetAlertaByTipoAlertaCommand(Alerta alerta, DBHandler handler)
    {
        return new GetAlertaByTipoAlertaCommand(alerta, handler);
    }

    public static GetAlertaByIdCommand createGetAlertaByIdCommand (DBHandler handler, long alertaId )
    {
        return new GetAlertaByIdCommand(handler, alertaId);
    }

    public static AddAlertaCommand createAddAlertaCommand(Alerta alerta, DBHandler handler)
    {
        return new AddAlertaCommand(alerta, handler);
    }

    public static AddAlertaCommand createAddAlertaCommand(Alerta alerta)
    {
        return new AddAlertaCommand(alerta);
    }

    public static CreateAlertaCommand createCreateAlertaCommand(Alerta alerta)
    {
        return new CreateAlertaCommand(alerta);
    }



    public static DeleteAlertaByIdCommand createDeleteAlertaByIdCommand(Alerta user, DBHandler handler)
    {
        return new DeleteAlertaByIdCommand(user, handler);
    }

    public static DeleteAlertaByIdCommand createDeleteAlertaByIdCommand(Alerta user)
    {
        return new DeleteAlertaByIdCommand(user);
    }

    public static DeleteAlertaCommand createDeleteAlertaCommand(Alerta user)
    {
        return new DeleteAlertaCommand(user);
    }

    public static UpdateAlertaByIdCommand createUpdateAlertaByIdCommand(Alerta user, DBHandler handler)
    {
        return new UpdateAlertaByIdCommand(user, handler);
    }

    public static UpdateAlertaByIdCommand createUpdateAlertaByIdCommand(Alerta user)
    {
        return new UpdateAlertaByIdCommand(user);
    }

    public static UpdateAlertaCommand createUpdateAlertaCommand(Alerta user)
    {
        return new UpdateAlertaCommand(user);
    }


    //DistanciaAlejamiento

    public static GetDistanciaAlejamientoCommand createGetDistanciaAlejamientoCommand(DistanciaAlejamiento distancia)
    {
        return new GetDistanciaAlejamientoCommand(distancia);
    }

    public static GetDistanciaAlejamientoByUsuariosCommand createGetDistanciaAlejamientoByUsuariosCommand(DistanciaAlejamiento distancia)
    {
        return new GetDistanciaAlejamientoByUsuariosCommand(distancia);
    }

    public static GetDistanciaAlejamientoByUsuariosCommand createGetDistanciaAlejamientoByUsuariosCommand(DistanciaAlejamiento distancia, DBHandler handler)
    {
        return new GetDistanciaAlejamientoByUsuariosCommand(distancia, handler);
    }

    public static GetDistanciaAlejamientoByIdCommand createGetDistanciaAlejamientoByIdCommand (DBHandler handler, long distanciaId )
    {
        return new GetDistanciaAlejamientoByIdCommand(handler, distanciaId);
    }

    public static AddDistanciaAlejamientoCommand createAddDistanciaAlejamientoCommand(DistanciaAlejamiento distancia, DBHandler handler)
    {
        return new AddDistanciaAlejamientoCommand(distancia, handler);
    }

    public static AddDistanciaAlejamientoCommand createAddDistanciaAlejamientoCommand(DistanciaAlejamiento distancia)
    {
        return new AddDistanciaAlejamientoCommand(distancia);
    }

    public static CreateDistanciaAlejamientoCommand createCreateDistanciaAlejamientoCommand(DistanciaAlejamiento distancia)
    {
        return new CreateDistanciaAlejamientoCommand(distancia);
    }


    public static DeleteDistanciaByIdCommand createDeleteDistanciaByIdCommand(DistanciaAlejamiento user, DBHandler handler)
    {
        return new DeleteDistanciaByIdCommand(user, handler);
    }

    public static DeleteDistanciaByIdCommand createDeleteDistanciaByIdCommand(DistanciaAlejamiento user)
    {
        return new DeleteDistanciaByIdCommand(user);
    }

    public static DeleteDistanciaCommand createDeleteDistanciaCommand(DistanciaAlejamiento user)
    {
        return new DeleteDistanciaCommand(user);
    }

    public static UpdateDistanciaByIdCommand createUpdateDistanciaByIdCommand(DistanciaAlejamiento user, DBHandler handler)
    {
        return new UpdateDistanciaByIdCommand(user, handler);
    }

    public static UpdateDistanciaByIdCommand createUpdateDistanciaByIdCommand(DistanciaAlejamiento user)
    {
        return new UpdateDistanciaByIdCommand(user);
    }

    public static UpdateDistanciaCommand createUpdateDistanciaCommand(DistanciaAlejamiento user)
    {
        return new UpdateDistanciaCommand(user);
    }

    public static GetAllDistanciaAlejamientoCommand createGetAllDistanciaAlejamientoCommand()
    {
        return new GetAllDistanciaAlejamientoCommand();
    }


    public static GetAllDistanciaAlejamientoByIdCommand createGetAllDistanciaAlejamientoByIdCommand (DBHandler handler )
    {
        return new GetAllDistanciaAlejamientoByIdCommand(handler);
    }


    //Posicion
    public static GetPosicionCommand createGetPosicionCommand(Posicion Posicion)
    {
        return new GetPosicionCommand(Posicion);
    }


    public static GetPosicionByIdCommand createGetPosicionByIdCommand (DBHandler handler, long PosicionId )
    {
        return new GetPosicionByIdCommand(handler, PosicionId);
    }

    public static AddPosicionCommand createAddPosicionCommand(Posicion Posicion, DBHandler handler)
    {
        return new AddPosicionCommand(Posicion, handler);
    }

    public static AddPosicionCommand createAddPosicionCommand(Posicion Posicion)
    {
        return new AddPosicionCommand(Posicion);
    }

    public static CreatePosicionCommand createCreatePosicionCommand(Posicion Posicion)
    {
        return new CreatePosicionCommand(Posicion);
    }



    public static DeletePosicionByIdCommand createDeletePosicionByIdCommand(Posicion user, DBHandler handler)
    {
        return new DeletePosicionByIdCommand(user, handler);
    }

    public static DeletePosicionByIdCommand createDeletePosicionByIdCommand(Posicion user)
    {
        return new DeletePosicionByIdCommand(user);
    }

    public static DeletePosicionCommand createDeletePosicionCommand(Posicion user)
    {
        return new DeletePosicionCommand(user);
    }

    public static UpdatePosicionByIdCommand createUpdatePosicionByIdCommand(Posicion user, DBHandler handler)
    {
        return new UpdatePosicionByIdCommand(user, handler);
    }

    public static UpdatePosicionByIdCommand createUpdatePosicionByIdCommand(Posicion user)
    {
        return new UpdatePosicionByIdCommand(user);
    }

    public static UpdatePosicionCommand createUpdatePosicionCommand(Posicion user)
    {
        return new UpdatePosicionCommand(user);
    }
    
    
    //PuntoControl

    public static GetPuntoControlCommand createGetPuntoControlCommand(PuntoControl PuntoControl)
    {
        return new GetPuntoControlCommand(PuntoControl);
    }


    public static GetPuntoControlByIdCommand createGetPuntoControlByIdCommand (DBHandler handler, long PuntoControlId )
    {
        return new GetPuntoControlByIdCommand(handler, PuntoControlId);
    }

    public static AddPuntoControlCommand createAddPuntoControlCommand(PuntoControl PuntoControl, DBHandler handler)
    {
        return new AddPuntoControlCommand(PuntoControl, handler);
    }

    public static AddPuntoControlCommand createAddPuntoControlCommand(PuntoControl PuntoControl)
    {
        return new AddPuntoControlCommand(PuntoControl);
    }

    public static CreatePuntoControlCommand createCreatePuntoControlCommand(PuntoControl PuntoControl)
    {
        return new CreatePuntoControlCommand(PuntoControl);
    }



    public static DeletePuntoControlByIdCommand createDeletePuntoControlByIdCommand(PuntoControl user, DBHandler handler)
    {
        return new DeletePuntoControlByIdCommand(user, handler);
    }

    public static DeletePuntoControlByIdCommand createDeletePuntoControlByIdCommand(PuntoControl user)
    {
        return new DeletePuntoControlByIdCommand(user);
    }

    public static DeletePuntoControlCommand createDeletePuntoControlCommand(PuntoControl user)
    {
        return new DeletePuntoControlCommand(user);
    }

    public static UpdatePuntoControlByIdCommand createUpdatePuntoControlByIdCommand(PuntoControl user, DBHandler handler)
    {
        return new UpdatePuntoControlByIdCommand(user, handler);
    }

    public static UpdatePuntoControlByIdCommand createUpdatePuntoControlByIdCommand(PuntoControl user)
    {
        return new UpdatePuntoControlByIdCommand(user);
    }

    public static UpdatePuntoControlCommand createUpdatePuntoControlCommand(PuntoControl user)
    {
        return new UpdatePuntoControlCommand(user);
    }


    //CoordenadaZonaSeguridad

    public static GetCoordenadaZonaSeguridadCommand createGetCoordenadaZonaSeguridadCommand(CoordenadaZonaSeguridad CoordenadaZonaSeguridad)
    {
        return new GetCoordenadaZonaSeguridadCommand(CoordenadaZonaSeguridad);
    }


    public static GetCoordenadaZonaSeguridadByIdCommand createGetCoordenadaZonaSeguridadByIdCommand (DBHandler handler, long CoordenadaZonaSeguridadId )
    {
        return new GetCoordenadaZonaSeguridadByIdCommand(handler, CoordenadaZonaSeguridadId);
    }

    public static AddCoordenadaZonaSeguridadCommand createAddCoordenadaZonaSeguridadCommand(CoordenadaZonaSeguridad CoordenadaZonaSeguridad, DBHandler handler)
    {
        return new AddCoordenadaZonaSeguridadCommand(CoordenadaZonaSeguridad, handler);
    }

    public static AddCoordenadaZonaSeguridadCommand createAddCoordenadaZonaSeguridadCommand(CoordenadaZonaSeguridad CoordenadaZonaSeguridad)
    {
        return new AddCoordenadaZonaSeguridadCommand(CoordenadaZonaSeguridad);
    }

    public static CreateCoordenadaZonaSeguridadCommand createCreateCoordenadaZonaSeguridadCommand(CoordenadaZonaSeguridad CoordenadaZonaSeguridad)
    {
        return new CreateCoordenadaZonaSeguridadCommand(CoordenadaZonaSeguridad);
    }



    public static DeleteCoordenadaZonaSeguridadByIdCommand createDeleteCoordenadaZonaSeguridadByIdCommand(CoordenadaZonaSeguridad user, DBHandler handler)
    {
        return new DeleteCoordenadaZonaSeguridadByIdCommand(user, handler);
    }

    public static DeleteCoordenadaZonaSeguridadByIdCommand createDeleteCoordenadaZonaSeguridadByIdCommand(CoordenadaZonaSeguridad user)
    {
        return new DeleteCoordenadaZonaSeguridadByIdCommand(user);
    }

    public static DeleteCoordenadaZonaSeguridadCommand createDeleteCoordenadaZonaSeguridadCommand(CoordenadaZonaSeguridad user)
    {
        return new DeleteCoordenadaZonaSeguridadCommand(user);
    }

    public static UpdateCoordenadaZonaSeguridadByIdCommand createUpdateCoordenadaZonaSeguridadByIdCommand(CoordenadaZonaSeguridad user, DBHandler handler)
    {
        return new UpdateCoordenadaZonaSeguridadByIdCommand(user, handler);
    }

    public static UpdateCoordenadaZonaSeguridadByIdCommand createUpdateCoordenadaZonaSeguridadByIdCommand(CoordenadaZonaSeguridad user)
    {
        return new UpdateCoordenadaZonaSeguridadByIdCommand(user);
    }

    public static UpdateCoordenadaZonaSeguridadCommand createUpdateCoordenadaZonaSeguridadCommand(CoordenadaZonaSeguridad user)
    {
        return new UpdateCoordenadaZonaSeguridadCommand(user);
    }


    public static GetAllCoordenadaZonaSeguridadCommand createGetAllCoordenadaZonaSeguridadCommand(long id)
    {
        return new GetAllCoordenadaZonaSeguridadCommand(id);
    }


    public static GetAllCoordenadaZonaSeguridadByIdZonaCommand createGetAllCoordenadaZonaSeguridadByIdZonaCommand (DBHandler handler ,long id)
    {
        return new GetAllCoordenadaZonaSeguridadByIdZonaCommand(handler,id);
    }


    //ZonaSeguridad 

    public static GetZonaSeguridadCommand createGetZonaSeguridadCommand(ZonaSeguridad ZonaSeguridad)
    {
        return new GetZonaSeguridadCommand(ZonaSeguridad);
    }


    public static GetZonaSeguridadByIdCommand createGetZonaSeguridadByIdCommand (DBHandler handler, long ZonaSeguridadId )
    {
        return new GetZonaSeguridadByIdCommand(handler, ZonaSeguridadId);
    }

    public static GetAllZonaSeguridadCommand createGetAllZonaSeguridadCommand()
    {
        return new GetAllZonaSeguridadCommand();
    }


    public static GetAllZonaSeguridadByIdCommand createGetAllZonaSeguridadByIdCommand (DBHandler handler )
    {
        return new GetAllZonaSeguridadByIdCommand(handler);
    }

    public static AddZonaSeguridadCommand createAddZonaSeguridadCommand(ZonaSeguridad ZonaSeguridad, DBHandler handler)
    {
        return new AddZonaSeguridadCommand(ZonaSeguridad, handler);
    }

    public static AddZonaSeguridadCommand createAddZonaSeguridadCommand(ZonaSeguridad ZonaSeguridad)
    {
        return new AddZonaSeguridadCommand(ZonaSeguridad);
    }

    public static CreateZonaSeguridadCommand createCreateZonaSeguridadCommand(ZonaSeguridad ZonaSeguridad)
    {
        return new CreateZonaSeguridadCommand(ZonaSeguridad);
    }



    public static DeleteZonaSeguridadByIdCommand createDeleteZonaSeguridadByIdCommand(ZonaSeguridad user, DBHandler handler)
    {
        return new DeleteZonaSeguridadByIdCommand(user, handler);
    }

    public static DeleteZonaSeguridadByIdCommand createDeleteZonaSeguridadByIdCommand(ZonaSeguridad user)
    {
        return new DeleteZonaSeguridadByIdCommand(user);
    }

    public static DeleteZonaSeguridadCommand createDeleteZonaSeguridadCommand(ZonaSeguridad user)
    {
        return new DeleteZonaSeguridadCommand(user);
    }

    public static UpdateZonaSeguridadByIdCommand createUpdateZonaSeguridadByIdCommand(ZonaSeguridad user, DBHandler handler)
    {
        return new UpdateZonaSeguridadByIdCommand(user, handler);
    }

    public static UpdateZonaSeguridadByIdCommand createUpdateZonaSeguridadByIdCommand(ZonaSeguridad user)
    {
        return new UpdateZonaSeguridadByIdCommand(user);
    }

    public static UpdateZonaSeguridadCommand createUpdateZonaSeguridadCommand(ZonaSeguridad user)
    {
        return new UpdateZonaSeguridadCommand(user);
    }
    
    
    //TiempoControl
    public static GetTiempoControlCommand createGetTiempoControlCommand(TiempoControl TiempoControl)
    {
        return new GetTiempoControlCommand(TiempoControl);
    }


    public static GetTiempoControlByIdCommand createGetTiempoControlByIdCommand (DBHandler handler, long TiempoControlId )
    {
        return new GetTiempoControlByIdCommand(handler, TiempoControlId);
    }

    public static AddTiempoControlCommand createAddTiempoControlCommand(TiempoControl TiempoControl, DBHandler handler)
    {
        return new AddTiempoControlCommand(TiempoControl, handler);
    }

    public static AddTiempoControlCommand createAddTiempoControlCommand(TiempoControl TiempoControl)
    {
        return new AddTiempoControlCommand(TiempoControl);
    }

    public static CreateTiempoControlCommand createCreateTiempoControlCommand(TiempoControl TiempoControl)
    {
        return new CreateTiempoControlCommand(TiempoControl);
    }



    public static DeleteTiempoControlByIdCommand createDeleteTiempoControlByIdCommand(TiempoControl user, DBHandler handler)
    {
        return new DeleteTiempoControlByIdCommand(user, handler);
    }

    public static DeleteTiempoControlByIdCommand createDeleteTiempoControlByIdCommand(TiempoControl user)
    {
        return new DeleteTiempoControlByIdCommand(user);
    }

    public static DeleteTiempoControlCommand createDeleteTiempoControlCommand(TiempoControl user)
    {
        return new DeleteTiempoControlCommand(user);
    }

    public static UpdateTiempoControlByIdCommand createUpdateTiempoControlByIdCommand(TiempoControl user, DBHandler handler)
    {
        return new UpdateTiempoControlByIdCommand(user, handler);
    }

    public static UpdateTiempoControlByIdCommand createUpdateTiempoControlByIdCommand(TiempoControl user)
    {
        return new UpdateTiempoControlByIdCommand(user);
    }

    public static UpdateTiempoControlCommand createUpdateTiempoControlCommand(TiempoControl user)
    {
        return new UpdateTiempoControlCommand(user);
    }

    public static GetAllTiempoControlCommand createGetAllTiempoControlCommand()
    {
        return new GetAllTiempoControlCommand();
    }


    public static GetAllTiempoControlByIdCommand createGetAllTiempoControlByIdCommand (DBHandler handler )
    {
        return new GetAllTiempoControlByIdCommand(handler);
    }



    //UserType
    public static GetUserTypeCommand createGetUserTypeCommand(UserType UserType)
    {
        return new GetUserTypeCommand(UserType);
    }


    public static GetUserTypeByIdCommand createGetUserTypeByIdCommand (DBHandler handler, long UserTypeId )
    {
        return new GetUserTypeByIdCommand(handler, UserTypeId);
    }

    public static AddUserTypeCommand createAddUserTypeCommand(UserType UserType, DBHandler handler)
    {
        return new AddUserTypeCommand(UserType, handler);
    }

    public static AddUserTypeCommand createAddUserTypeCommand(UserType UserType)
    {
        return new AddUserTypeCommand(UserType);
    }

    public static CreateUserTypeCommand createCreateUserTypeCommand(UserType UserType)
    {
        return new CreateUserTypeCommand(UserType);
    }



    public static DeleteUserTypeByIdCommand createDeleteUserTypeByIdCommand(UserType user, DBHandler handler)
    {
        return new DeleteUserTypeByIdCommand(user, handler);
    }

    public static DeleteUserTypeByIdCommand createDeleteUserTypeByIdCommand(UserType user)
    {
        return new DeleteUserTypeByIdCommand(user);
    }

    public static DeleteUserTypeCommand createDeleteUserTypeCommand(UserType user)
    {
        return new DeleteUserTypeCommand(user);
    }

    public static UpdateUserTypeByIdCommand createUpdateUserTypeByIdCommand(UserType user, DBHandler handler)
    {
        return new UpdateUserTypeByIdCommand(user, handler);
    }

    public static UpdateUserTypeByIdCommand createUpdateUserTypeByIdCommand(UserType user)
    {
        return new UpdateUserTypeByIdCommand(user);
    }

    public static UpdateUserTypeCommand createUpdateUserTypeCommand(UserType user)
    {
        return new UpdateUserTypeCommand(user);
    }
    


}

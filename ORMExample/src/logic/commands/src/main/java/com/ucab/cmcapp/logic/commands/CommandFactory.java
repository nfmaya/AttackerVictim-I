package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic.*;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.composite.CreateDistanciaAlejamientoCommand;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.composite.DeleteDistanciaCommand;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.composite.GetDistanciaAlejamientoCommand;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.composite.UpdateDistanciaCommand;
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
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.*;
import com.ucab.cmcapp.logic.commands.usuario.composite.CreateUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.DeleteUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.GetUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.UpdateUsuarioCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class CommandFactory
{
    //User
    public static GetUserCommand createGetUserCommand(User user)
    {
        return new GetUserCommand(user);
    }

    public static GetUserByEmailCommand createGetUserByEmailCommand(User user)
    {
        return new GetUserByEmailCommand(user);
    }

    public static GetUserByEmailCommand createGetUserByEmailCommand(User user, DBHandler handler)
    {
        return new GetUserByEmailCommand(user, handler);
    }

    public static GetUserByIdCommand createGetUserByIdCommand (DBHandler handler, long userId )
    {
        return new GetUserByIdCommand(handler, userId);
    }

    public static AddUserCommand createAddUserCommand(User user, DBHandler handler)
    {
        return new AddUserCommand(user, handler);
    }

    public static AddUserCommand createAddUserCommand(User user)
    {
        return new AddUserCommand(user);
    }

    public static CreateUserCommand createCreateUserCommand(User user)
    {
        return new CreateUserCommand(user);
    }

    //Usuario

    public static GetUsuarioCommand createGetUsuarioCommand(Usuario user)
    {
        return new GetUsuarioCommand(user);
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

}

package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.DistanciaAlejamiento;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic.AddDistanciaAlejamientoCommand;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic.GetDistanciaAlejamientoByIdCommand;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic.GetDistanciaAlejamientoByUsuariosCommand;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.composite.CreateDistanciaAlejamientoCommand;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.composite.GetDistanciaAlejamientoCommand;
import com.ucab.cmcapp.logic.commands.alerta.atomic.AddAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.atomic.GetAlertaByIdCommand;
import com.ucab.cmcapp.logic.commands.alerta.atomic.GetAlertaByTipoAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.CreateAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.GetAlertaCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.AddUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByIdCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByUsernameCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.CreateUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.GetUsuarioCommand;
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


}

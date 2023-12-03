package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.AlertaDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UsuarioMapper extends BaseMapper
{
    private static Logger _logger = LoggerFactory.getLogger( UsuarioMapper.class );

    public static Usuario mapDtoToEntity(UsuarioDto dto ) throws ParseException
    {
        Usuario entity = EntityFactory.createUsuario(dto.getId());

        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_Username( dto.get_Username() );
        entity.set_Nombre(dto.get_Nombre());
        entity.setDocIdentidad(dto.getDocIdentidad());
        entity.setIMEI(dto.getIMEI());
        entity.setEstatus(dto.isEstatus());


        if ( Objects.nonNull( dto.getUsuarioTypeDto() ) )
        {
            entity.set_userType( UserTypeMapper.mapDtoToEntity( dto.getUsuarioTypeDto() ) );
        }
/*
        if (Objects.nonNull(dto.getAlertas())) {
            entity.setAlertas(AlertaMapper.mapDtosToEntities(dto.getAlertas()));
        }

 */

        //region Instrumentation DEBUG
        _logger.debug( "Leaving UsuarioMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }


    public static Usuario mapDtoToEntityInsert(UsuarioDto dto ) throws ParseException
    {
        Usuario entity = EntityFactory.createUsuario();

        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_Username( dto.get_Username() );
        entity.set_Nombre(dto.get_Nombre());
        entity.setDocIdentidad(dto.getDocIdentidad());
        entity.setIMEI(dto.getIMEI());
        entity.setEstatus(dto.isEstatus());

        if ( Objects.nonNull( dto.getUsuarioTypeDto() ) )
        {
            entity.set_userType( UserTypeMapper.mapDtoToEntity( dto.getUsuarioTypeDto() ) );
        }
/*
        if (Objects.nonNull(dto.getAlertas())) {
            entity.setAlertas(AlertaMapper.mapDtosToEntities(dto.getAlertas()));
        }

 */

        //region Instrumentation DEBUG
        _logger.debug( "Leaving UsuarioMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static UsuarioDto mapEntityToDto( Usuario entity )
    {
        final UsuarioDto dto = new UsuarioDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.setId( entity.get_idUsuario());
        dto.set_Username(  entity.get_Username() );
        dto.set_Nombre( entity.get_Nombre() );
        dto.setIMEI( entity.getIMEI() );
        dto.setDocIdentidad( entity.getDocIdentidad() );
        dto.setEstatus( entity.isEstatus() );


        if(Objects.nonNull(entity.get_userType()))
            dto.setUsuarioTypeDto( UserTypeMapper.mapEntityToDto( entity.get_userType() ));
/*
        if (Objects.nonNull(entity.getAlertas())) {
            dto.setAlertas(AlertaMapper.mapEntitiesToDtos(entity.getAlertas()));
        }

 */

        //region Instrumentation DEBUG
        _logger.debug( "Leaving UsuarioMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }


    public static List<UsuarioDto> mapListEntityToDto(List<Usuario> entities) {
        List<UsuarioDto> dtos = new ArrayList<>();
        for (Usuario entity : entities) {
            dtos.add(mapEntityToDto(entity));
        }
        return dtos;
    }


    public static Usuario mapDtoToEntity( long id )
    {
        Usuario entity = EntityFactory.createUsuario( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.set_idUsuario( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving UsuarioMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static Usuario mapDtoToEntityUsername( String Username )
    {
        Usuario entity = EntityFactory.createUsuario();

        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioMapper.mapDtoToEntityEmail: Username {}", Username );
        //endregion

        entity.set_Username( Username );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving UsuarioMapper.mapDtoToEntityEmail: entity {}", entity );
        //endregion

        return entity;
    }

}

package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.dtos.PosicionDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PosicionMapper extends BaseMapper
{
    private static Logger _logger = LoggerFactory.getLogger( PosicionMapper.class );

    public static Posicion mapDtoToEntity(PosicionDto dto ) throws ParseException
    {
        Posicion entity = EntityFactory.createPosicion(dto.getId());

        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.setCoordenadaX( dto.getCoordenadaX());
        entity.setCoordenadaY(dto.getCoordenadaY());
        entity.setFechaHora(dto.getFechaHora());

        if ( Objects.nonNull( dto.getUsuario() ) )
        {
            entity.setUsuario( UsuarioMapper.mapDtoToEntity( dto.getUsuario() ) );
        }

        //region Instrumentation DEBUG
        _logger.debug( "Leaving PosicionMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static PosicionDto mapEntityToDto( Posicion entity )
    {
        final PosicionDto dto = new PosicionDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.setId( entity.getIdPos());

        dto.setCoordenadaX(  entity.getCoordenadaX() );
        dto.setCoordenadaY(  entity.getCoordenadaY() );

        dto.setFechaHora( entity.getFechaHora() );

        if(Objects.nonNull(entity.getUsuario()))
            dto.setUsuario( UsuarioMapper.mapEntityToDto( entity.getUsuario() ));



        //region Instrumentation DEBUG
        _logger.debug( "Leaving PosicionMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static Posicion mapDtoToEntity( long id )
    {
        Posicion entity = EntityFactory.createPosicion( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.setIdPos( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving PosicionMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }





}

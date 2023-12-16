package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.ZonaSeguridadUsuario;
import com.ucab.cmcapp.logic.dtos.ZonaSeguridadUsuarioDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ZonaSeguridadUsuarioMapper extends BaseMapper
{
    private static Logger _logger = LoggerFactory.getLogger( ZonaSeguridadUsuarioMapper.class );

    public static ZonaSeguridadUsuario mapDtoToEntity(ZonaSeguridadUsuarioDto dto ) throws ParseException
    {
        ZonaSeguridadUsuario entity = EntityFactory.createZonaSeguridadUsuario(dto.getId());

        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadUsuarioMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        if ( Objects.nonNull( dto.getUsuarioDto() ) )
        {
            entity.setUsuario( UsuarioMapper.mapDtoToEntity( dto.getUsuarioDto() ) );
        }

        if ( Objects.nonNull( dto.getZonaSeguridadDto() ) )
        {
            entity.setZonaSeguridad( ZonaSeguridadMapper.mapDtoToEntity( dto.getZonaSeguridadDto() ) );
        }
        //region Instrumentation DEBUG
        _logger.debug( "Leaving ZonaSeguridadUsuarioMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }


    public static ZonaSeguridadUsuario mapDtoToEntityInsert(ZonaSeguridadUsuarioDto dto ) throws ParseException
    {
        ZonaSeguridadUsuario entity = EntityFactory.createZonaSeguridadUsuario();

        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadUsuarioMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        if ( Objects.nonNull( dto.getUsuarioDto() ) )
        {
            entity.setUsuario( UsuarioMapper.mapDtoToEntity( dto.getUsuarioDto() ) );
        }

        if ( Objects.nonNull( dto.getZonaSeguridadDto() ) )
        {
            entity.setZonaSeguridad( ZonaSeguridadMapper.mapDtoToEntity( dto.getZonaSeguridadDto() ) );
        }

        //region Instrumentation DEBUG
        _logger.debug( "Leaving ZonaSeguridadUsuarioMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static ZonaSeguridadUsuarioDto mapEntityToDto( ZonaSeguridadUsuario entity )
    {
        final ZonaSeguridadUsuarioDto dto = new ZonaSeguridadUsuarioDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadUsuarioMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.setId( entity.getIdZonaUsuario());

        if(Objects.nonNull(entity.getUsuario()))
            dto.setUsuarioDto( UsuarioMapper.mapEntityToDto( entity.getUsuario() ));

        if(Objects.nonNull(entity.getZonaSeguridad()))
            dto.setZonaSeguridadDto( ZonaSeguridadMapper.mapEntityToDto( entity.getZonaSeguridad() ));



        //region Instrumentation DEBUG
        _logger.debug( "Leaving ZonaSeguridadUsuarioMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static ZonaSeguridadUsuario mapDtoToEntity( long id )
    {
        ZonaSeguridadUsuario entity = EntityFactory.createZonaSeguridadUsuario( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadUsuarioMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.setIdZonaUsuario( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving ZonaSeguridadUsuarioMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }


    public static List<ZonaSeguridadUsuarioDto> mapListEntityToDto(List<ZonaSeguridadUsuario> entities) {
        List<ZonaSeguridadUsuarioDto> dtos = new ArrayList<>();
        for (ZonaSeguridadUsuario entity : entities) {
            dtos.add(mapEntityToDto(entity));
        }
        return dtos;
    }



}

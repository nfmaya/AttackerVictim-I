package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.dtos.ZonaSeguridadDto;
import com.ucab.cmcapp.logic.dtos.ZonaSeguridadDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ZonaSeguridadMapper extends BaseMapper
{
    private static Logger _logger = LoggerFactory.getLogger( ZonaSeguridadMapper.class );

    public static ZonaSeguridad mapDtoToEntity(ZonaSeguridadDto dto ) throws ParseException
    {
        ZonaSeguridad entity = EntityFactory.createZonaSeguridad(dto.getId());

        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.setNombreZona( dto.getNombreZona());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving ZonaSeguridadMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }


    public static ZonaSeguridad mapDtoToEntityInsert(ZonaSeguridadDto dto ) throws ParseException
    {
        ZonaSeguridad entity = EntityFactory.createZonaSeguridad();

        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.setNombreZona( dto.getNombreZona());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving ZonaSeguridadMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static ZonaSeguridadDto mapEntityToDto( ZonaSeguridad entity )
    {
        final ZonaSeguridadDto dto = new ZonaSeguridadDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.setId( entity.getIdZona());

        dto.setNombreZona(  entity.getNombreZona() );



        //region Instrumentation DEBUG
        _logger.debug( "Leaving ZonaSeguridadMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static ZonaSeguridad mapDtoToEntity( long id )
    {
        ZonaSeguridad entity = EntityFactory.createZonaSeguridad( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.setIdZona( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving ZonaSeguridadMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }


    public static List<ZonaSeguridadDto> mapListEntityToDto(List<ZonaSeguridad> entities) {
        List<ZonaSeguridadDto> dtos = new ArrayList<>();
        for (ZonaSeguridad entity : entities) {
            dtos.add(mapEntityToDto(entity));
        }
        return dtos;
    }



}

package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.CoordenadaZonaSeguridad;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.dtos.CoordenadaZonaSeguridadDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;

public class CoordenadaZonaSeguridadMapper extends BaseMapper
{
    private static Logger _logger = LoggerFactory.getLogger( CoordenadaZonaSeguridadMapper.class );

    public static CoordenadaZonaSeguridad mapDtoToEntity(CoordenadaZonaSeguridadDto dto ) throws ParseException
    {
        CoordenadaZonaSeguridad entity = EntityFactory.createCoordenadaZonaSeguridad(dto.getId());

        //region Instrumentation DEBUG
        _logger.debug( "Get in CoordenadaZonaSeguridadMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.setCoordenadaX( dto.getCoordenadaX());
        entity.setCoordenadaY(dto.getCoordenadaY());

        if ( Objects.nonNull( dto.getZonaSeguridad() ) )
        {
            entity.setZonaSeguridad( ZonaSeguridadMapper.mapDtoToEntity( dto.getZonaSeguridad() ) );
        }


        //region Instrumentation DEBUG
        _logger.debug( "Leaving CoordenadaZonaSeguridadMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static CoordenadaZonaSeguridad mapDtoToEntityInsert(CoordenadaZonaSeguridadDto dto ) throws ParseException
    {
        CoordenadaZonaSeguridad entity = EntityFactory.createCoordenadaZonaSeguridad();

        //region Instrumentation DEBUG
        _logger.debug( "Get in CoordenadaZonaSeguridadMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.setCoordenadaX( dto.getCoordenadaX());
        entity.setCoordenadaY(dto.getCoordenadaY());
        if ( Objects.nonNull( dto.getZonaSeguridad() ) )
        {
            entity.setZonaSeguridad( ZonaSeguridadMapper.mapDtoToEntity( dto.getZonaSeguridad() ) );
        }


        //region Instrumentation DEBUG
        _logger.debug( "Leaving CoordenadaZonaSeguridadMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static CoordenadaZonaSeguridadDto mapEntityToDto( CoordenadaZonaSeguridad entity )
    {
        final CoordenadaZonaSeguridadDto dto = new CoordenadaZonaSeguridadDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in CoordenadaZonaSeguridadMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.setId( entity.getIdCoor());

        dto.setCoordenadaX(  entity.getCoordenadaX() );
        dto.setCoordenadaY(  entity.getCoordenadaY() );

        if(Objects.nonNull(entity.getZonaSeguridad()))
            dto.setZonaSeguridad( ZonaSeguridadMapper.mapEntityToDto( entity.getZonaSeguridad() ));


        //region Instrumentation DEBUG
        _logger.debug( "Leaving CoordenadaZonaSeguridadMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static CoordenadaZonaSeguridad mapDtoToEntity( long id )
    {
        CoordenadaZonaSeguridad entity = EntityFactory.createCoordenadaZonaSeguridad( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in CoordenadaZonaSeguridadMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.setIdCoor( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CoordenadaZonaSeguridadMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }





}

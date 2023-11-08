package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.PuntoControl;
import com.ucab.cmcapp.logic.dtos.PuntoControlDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

public class PuntoControlMapperInsert extends BaseMapper
{
    private static Logger _logger = LoggerFactory.getLogger( PuntoControlMapperInsert.class );

    public static PuntoControl mapDtoToEntity(PuntoControlDto dto ) throws ParseException
    {
        PuntoControl entity = EntityFactory.createPuntoControl();

        //region Instrumentation DEBUG
        _logger.debug( "Get in PuntoControlMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.setCoordenadaX( dto.getCoordenadaX());
        entity.setCoordenadaY(dto.getCoordenadaY());
        entity.setFechaHora(dto.getFechaHora());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving PuntoControlMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static PuntoControlDto mapEntityToDto( PuntoControl entity )
    {
        final PuntoControlDto dto = new PuntoControlDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in PuntoControlMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.setId( entity.getIdPos());

        dto.setCoordenadaX(  entity.getCoordenadaX() );
        dto.setCoordenadaY(  entity.getCoordenadaY() );

        dto.setFechaHora( entity.getFechaHora() );


        //region Instrumentation DEBUG
        _logger.debug( "Leaving PuntoControlMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static PuntoControl mapDtoToEntity( long id )
    {
        PuntoControl entity = EntityFactory.createPuntoControl( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in PuntoControlMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.setIdPos( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving PuntoControlMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }





}

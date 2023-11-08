package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.TiempoControl;
import com.ucab.cmcapp.logic.dtos.TiempoControlDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

public class TiempoControlMapperInsert extends BaseMapper
{
    private static Logger _logger = LoggerFactory.getLogger( TiempoControlMapperInsert.class );

    public static TiempoControl mapDtoToEntity(TiempoControlDto dto ) throws ParseException
    {
        TiempoControl entity = EntityFactory.createTiempoControl();

        //region Instrumentation DEBUG
        _logger.debug( "Get in TiempoControlMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.setTiempoControl( dto.getTiempoControl());
        entity.setTipoTiempoControl(dto.getTipoTiempoControl());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving TiempoControlMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static TiempoControlDto mapEntityToDto( TiempoControl entity )
    {
        final TiempoControlDto dto = new TiempoControlDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in TiempoControlMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.setId( entity.getIdTiempo());

        dto.setTiempoControl(  entity.getTiempoControl());
        dto.setTipoTiempoControl(  entity.getTipoTiempoControl());



        //region Instrumentation DEBUG
        _logger.debug( "Leaving TiempoControlMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static TiempoControl mapDtoToEntity( long id )
    {
        TiempoControl entity = EntityFactory.createTiempoControl( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in TiempoControlMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.setIdTiempo( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving TiempoControlMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }





}

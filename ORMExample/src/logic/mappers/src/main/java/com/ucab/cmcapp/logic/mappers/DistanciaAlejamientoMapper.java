package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.DistanciaAlejamiento;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.DistanciaAlejamientoDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;

public class DistanciaAlejamientoMapper extends BaseMapper
{
    private static Logger _logger = LoggerFactory.getLogger( DistanciaAlejamientoMapper.class );

    public static DistanciaAlejamiento mapDtoToEntity(DistanciaAlejamientoDto dto ) throws ParseException
    {
        DistanciaAlejamiento entity = EntityFactory.createDistanciaAlejamiento(dto.getId());

        //region Instrumentation DEBUG
        _logger.debug( "Get in DistanciaAlejamientoMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_distanciaMinima( dto.get_distanciaMinima() );


        //AQUI VA LA EL OBJETO DE LA TABLA RELACIONADA
        if ( Objects.nonNull( dto.get_agresor() ) )
        {
            entity.set_agresor( UsuarioMapper.mapDtoToEntity( dto.get_agresor() ) );
        }

        if ( Objects.nonNull( dto.get_victima() ) )
        {
            entity.set_victima( UsuarioMapper.mapDtoToEntity( dto.get_victima() ) );
        }




        //region Instrumentation DEBUG
        _logger.debug( "Leaving DistanciaAlejamientoMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static DistanciaAlejamiento mapDtoToEntityInsert(DistanciaAlejamientoDto dto ) throws ParseException
    {
        DistanciaAlejamiento entity = EntityFactory.createDistanciaAlejamiento();

        //region Instrumentation DEBUG
        _logger.debug( "Get in DistanciaAlejamientoMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_distanciaMinima( dto.get_distanciaMinima() );

        if ( Objects.nonNull( dto.get_agresor() ) )
        {
            entity.set_agresor( UsuarioMapper.mapDtoToEntity( dto.get_agresor() ) );
        }

        if ( Objects.nonNull( dto.get_victima() ) )
        {
            entity.set_victima( UsuarioMapper.mapDtoToEntity( dto.get_victima() ) );
        }


        //region Instrumentation DEBUG
        _logger.debug( "Leaving DistanciaAlejamientoMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static DistanciaAlejamientoDto mapEntityToDto( DistanciaAlejamiento entity )
    {
        final DistanciaAlejamientoDto dto = new DistanciaAlejamientoDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in DistanciaAlejamientoMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.setId( entity.get_IdAlej());
        dto.set_distanciaMinima(  entity.get_distanciaMinima() );

        //AQUI VA LA EL OBJETO DE LA TABLA RELACIONADA

        if(Objects.nonNull(entity.get_victima()))
            dto.set_victima( UsuarioMapper.mapEntityToDto( entity.get_victima() ));

        if(Objects.nonNull(entity.get_agresor()))
            dto.set_agresor( UsuarioMapper.mapEntityToDto( entity.get_agresor() ));


        //region Instrumentation DEBUG
        _logger.debug( "Leaving DistanciaAlejamientoMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static DistanciaAlejamiento mapDtoToEntity( long id )
    {
        DistanciaAlejamiento entity = EntityFactory.createDistanciaAlejamiento( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in DistanciaAlejamientoMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.set_IdAlej( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving DistanciaAlejamientoMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static DistanciaAlejamiento mapDtoToEntityUsuarios( Usuario Victima, Usuario Agresor )
    {
        DistanciaAlejamiento entity = EntityFactory.createDistanciaAlejamiento();

        //region Instrumentation DEBUG
        _logger.debug( "Get in DistanciaAlejamientoMapper.mapDtoToEntityEmail: email" );
        //endregion

        /*
        entity.set_agresor( Agresor );
        entity.set_victima( Victima );

         */

        //region Instrumentation DEBUG
        _logger.debug( "Leaving DistanciaAlejamientoMapper.mapDtoToEntityEmail: entity {}", entity );
        //endregion

        return entity;
    }

}

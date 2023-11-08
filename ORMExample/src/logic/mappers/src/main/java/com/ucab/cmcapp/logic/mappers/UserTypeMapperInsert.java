package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.UserType;
import com.ucab.cmcapp.logic.dtos.UserTypeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

public class UserTypeMapperInsert extends BaseMapper
{
    private static Logger _logger = LoggerFactory.getLogger( UserTypeMapper.class );

    public static UserType mapDtoToEntity(UserTypeDto dto ) throws ParseException
    {
        UserType entity = EntityFactory.createUserType();

        //region Instrumentation DEBUG
        _logger.debug( "Get in UserTypeMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.setName( dto.getName());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving UserTypeMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static UserTypeDto mapEntityToDto( UserType entity )
    {
        final UserTypeDto dto = new UserTypeDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in UserTypeMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.setId( entity.getId());

        dto.setName(  entity.getName());



        //region Instrumentation DEBUG
        _logger.debug( "Leaving UserTypeMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static UserType mapDtoToEntity( long id )
    {
        UserType entity = EntityFactory.createUserType( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in UserTypeMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.setId( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving UserTypeMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }





}

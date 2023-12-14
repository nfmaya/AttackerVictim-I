package com.ucab.cmcapp.logic.dtos;

import java.util.ArrayList;
import java.util.List;

public class UserTypeDto extends BaseDto
{
    private String _name;

    public UserTypeDto()
    {

    }

    public UserTypeDto( long id )
    {
        super( id );

    }

    public String getName()
    {
        return _name;
    }

    public void setName( String name )
    {
        _name = name;
    }


}

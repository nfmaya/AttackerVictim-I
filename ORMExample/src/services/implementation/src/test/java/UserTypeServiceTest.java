import com.ucab.cmcapp.common.entities.UserType;
import com.ucab.cmcapp.implementation.UserTypeService;
import com.ucab.cmcapp.logic.dtos.UserTypeDto;
import com.ucab.cmcapp.logic.mappers.UserTypeMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class UserTypeServiceTest {

    private UserTypeService UserTypeService;
    private UserTypeDto UserTypeDto;

    @Before
    public void setUp() {
        UserTypeService = Mockito.mock(UserTypeService.class);
        UserTypeDto = new UserTypeDto();
        UserTypeDto.setId(1L);
    }

   /* @Test
    public void getUserTypeReturnsExpectedUserTypeWhenUserTypeExists() {
        when(UserTypeService.getUserType(1L)).thenReturn(Response.status(Response.Status.OK).entity(UserTypeDto).build());

        Response actualUserType = UserTypeService.getUserType(1L);

        assertEquals(Response.Status.OK.getStatusCode(), actualUserType.getStatus());
        assertEquals(UserTypeDto, actualUserType.getEntity());
    }


    @Test
    public void getUserTypeReturnsNotFoundWhenUserTypeDoesNotExist() {
        when(UserTypeService.getUserType(2L)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualUserType = UserTypeService.getUserType(2L);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualUserType.getStatus());
    }

    @Test
    public void getUserTypeReturnsServerErrorWhenExceptionOccurs() {
        when(UserTypeService.getUserType(3L)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualUserType = UserTypeService.getUserType(3L);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualUserType.getStatus());
    }*/


    @Test
    public void addUserTypeReturnsExpectedUserTypeWhenUserTypeIsAdded() {
        when(UserTypeService.addUserType(UserTypeDto)).thenReturn(Response.status(Response.Status.OK).entity(UserTypeDto).build());

        Response actualUserType = UserTypeService.addUserType(UserTypeDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualUserType.getStatus());
        assertEquals(UserTypeDto, actualUserType.getEntity());
    }

    @Test
    public void addUserTypeReturnsServerErrorWhenExceptionOccurs() {
        when(UserTypeService.addUserType(UserTypeDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualUserType = UserTypeService.addUserType(UserTypeDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualUserType.getStatus());
    }

    @Test
    public void addUserTypeReturnsNotFoundWhenUserTypeCannotBeAdded() {
        when(UserTypeService.addUserType(UserTypeDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualUserType = UserTypeService.addUserType(UserTypeDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualUserType.getStatus());
    }



    @Test
    public void updateUserTypeReturnsExpectedUserTypeWhenUserTypeIsUpdated() {
        when(UserTypeService.updateUserType(UserTypeDto)).thenReturn(Response.status(Response.Status.OK).entity(UserTypeDto).build());

        Response actualUserType = UserTypeService.updateUserType(UserTypeDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualUserType.getStatus());
        assertEquals(UserTypeDto, actualUserType.getEntity());
    }

    @Test
    public void updateUserTypeReturnsServerErrorWhenExceptionOccurs() {
        when(UserTypeService.updateUserType(UserTypeDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualUserType = UserTypeService.updateUserType(UserTypeDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualUserType.getStatus());
    }

    @Test
    public void updateUserTypeReturnsNotFoundWhenUserTypeCannotBeUpdated() {
        when(UserTypeService.updateUserType(UserTypeDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualUserType = UserTypeService.updateUserType(UserTypeDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualUserType.getStatus());
    }
}
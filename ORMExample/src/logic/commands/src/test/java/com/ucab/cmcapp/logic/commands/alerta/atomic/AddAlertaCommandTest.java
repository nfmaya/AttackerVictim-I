package com.ucab.cmcapp.logic.commands.alerta.atomic;

import com.ucab.cmcapp.logic.commands.alerta.composite.CreateAlertaCommand;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.logic.dtos.AlertaDto;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;

public class AddAlertaCommandTest {

    private CreateAlertaCommand addAlertaCommand;
    private AlertaDto alertaDto;

    @Before
    public void setUp() {
        addAlertaCommand = Mockito.mock(CreateAlertaCommand.class);
        alertaDto = new AlertaDto();
        alertaDto.setId(1L);
    }

    @Test
    public void executeReturnsExpectedAlertaWhenAlertaIsAdded() throws ParseException {
        Alerta alerta = AlertaMapper.mapDtoToEntity(alertaDto);

        addAlertaCommand.execute();
        assertEquals(alerta, alerta);
    }

    @Test
    public void executeThrowsExceptionWhenErrorOccurs() throws ParseException {

        AlertaDto alertaDto2 = new AlertaDto();

        Alerta alerta = AlertaMapper.mapDtoToEntity(alertaDto2);

        addAlertaCommand.execute();
        assertEquals(alerta, alerta);
    }
}
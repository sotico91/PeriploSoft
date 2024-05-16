package com.co.periferiaIT.PeriploSoft.client.controller;

import com.co.periferiaIT.PeriploSoft.client.exceptions.impl.ResourceBadRequestException;
import com.co.periferiaIT.PeriploSoft.client.exceptions.impl.ResourceNotFoundException;
import com.co.periferiaIT.PeriploSoft.client.model.Client;
import com.co.periferiaIT.PeriploSoft.client.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ControllerClientTest {

    @InjectMocks
    private ControllerClient controllerClient;

    @Mock
    private ClientService clientService;

    private Client client;

    @BeforeEach
    void setUp() {
        client = new Client("C", "23445322", "Edgar David",
                "Velasco Pinzón", "2656967",
                "Calle 133 # 58c - 60", "Bogotá");

    }

    @Test
    void testGetInfoClient_Success() {

        String documentType = "C";
        String documentNumber = "23445322";

        when(clientService.getInformationClient()).thenReturn(client);

        ResponseEntity<Client> response = controllerClient.getInfoClient(documentType, documentNumber);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(client, response.getBody());
    }

    @Test
    void testGetInfoClient_NotFound() {

        String documentType = "C";
        String documentNumber = "78999";

        when(clientService.getInformationClient()).thenReturn(client);

        assertThrows(ResourceNotFoundException.class,
                () -> controllerClient.getInfoClient(documentType, documentNumber));
    }

    @Test
    void testGetInfoClient_BadRequest() {

        String documentType = "X";
        String documentNumber = "23445322";

        assertThrows(ResourceBadRequestException.class,
                () -> controllerClient.getInfoClient(documentType, documentNumber));
    }

}
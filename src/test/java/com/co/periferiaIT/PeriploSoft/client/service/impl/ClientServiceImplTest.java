package com.co.periferiaIT.PeriploSoft.client.service.impl;

import com.co.periferiaIT.PeriploSoft.client.model.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceImplTest {

    @Test
    public void testGetInformationClient() {
        ClientServiceImpl clientService = new ClientServiceImpl();
        String expectedDocumentType = "C";
        String expectedDocumentNumber = "23445322";
        String expectedFirstName = "Edgar David";
        String expectedLastName = "Velasco Pinzón";
        String expectedPhoneNumber = "2656967";
        String expectedAddress = "Calle 133 # 58c - 60";
        String expectedCity = "Bogotá";

        Client client = clientService.getInformationClient();

        assertEquals(expectedDocumentType, client.documentType());
        assertEquals(expectedDocumentNumber, client.documentNumber());
        assertEquals(expectedFirstName, client.firstName());
        assertEquals(expectedLastName, client.lastName());
        assertEquals(expectedPhoneNumber, client.phoneNumber());
        assertEquals(expectedAddress, client.address());
        assertEquals(expectedCity, client.residenceCity());
    }

}
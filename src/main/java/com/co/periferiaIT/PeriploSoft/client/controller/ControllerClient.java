package com.co.periferiaIT.PeriploSoft.client.controller;

import com.co.periferiaIT.PeriploSoft.client.exceptions.impl.ResourceBadRequestException;
import com.co.periferiaIT.PeriploSoft.client.exceptions.impl.ResourceNotFoundException;
import com.co.periferiaIT.PeriploSoft.client.model.Client;
import com.co.periferiaIT.PeriploSoft.client.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/clients")
public class ControllerClient {

    private static final Logger logger = LogManager.getLogger(ControllerClient.class);

    @Autowired
    private ClientService clientService;

    @Operation(summary = "Get a client info by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the client",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) })})
    @GetMapping("/getInfoClient")
    public ResponseEntity<Client> getInfoClient(@RequestParam String documentType,@RequestParam String documentNumber) {

        logger.info("Start process to getInfoClient");

        if (!generalValidations(documentType)) {
            logger.error("Bad Request after generalValidations method");
            throw new ResourceBadRequestException(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }

        Client client = clientService.getInformationClient();

        if (client != null && client.documentNumber() != null && client.documentNumber().equals(documentNumber)) {

            logger.info("Final process to getInfoClient ");
            return ResponseEntity.ok(client);

        } else {

            logger.warn("Client not found");
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase());
        }
    }

    private boolean generalValidations(String documentType){
        logger.info("Document type is {}", documentType);
        return documentType.equals("C") || documentType.equals("P");
    }
}

package com.co.periferiaIT.PeriploSoft.client.service.impl;

import com.co.periferiaIT.PeriploSoft.client.model.Client;
import com.co.periferiaIT.PeriploSoft.client.service.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Override
    public Client getInformationClient() {
       return new Client("C",
               "23445322",
               "Edgar David",
               "Velasco Pinzón",
               "2656967",
               "Calle 133 # 58c - 60",
               "Bogotá");
    }
}
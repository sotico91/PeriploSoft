package com.co.periferiaIT.PeriploSoft.client.model;

public record Client(String documentType,
                     String documentNumber,
                     String firstName,
                     String lastName,
                     String phoneNumber,
                     String address,
                     String residenceCity) {
}
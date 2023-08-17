package com.example.crudjava.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//Tomar todos los valores dentro de la clase como un constructor y darle el acceso público
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class taskResponseHttp {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String body;

    @Getter @Setter
    private String status;
}

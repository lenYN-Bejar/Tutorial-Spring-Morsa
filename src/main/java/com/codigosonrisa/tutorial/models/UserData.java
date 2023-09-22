package com.codigosonrisa.tutorial.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class UserData {
    public String name;
    @JsonIgnore
    public int age;

    @JsonProperty("real_direccion")
    public String address;

    @JsonGetter("information") // Retorna un json con el nombre de la propiedad y JsonValue retorna el valor de la propiedad quitando el json que retorna
    public String info() {
        return "Username is " + name + "and age is" + age + " and address is " + address;
    }


    public UserData(String name, int age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }
}

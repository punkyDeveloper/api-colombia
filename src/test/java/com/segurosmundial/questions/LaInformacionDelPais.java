package com.segurosmundial.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LaInformacionDelPais implements Question<String> {
    
    private final String campo;
    
    private LaInformacionDelPais(String campo) {
        this.campo = campo;
    }
    
    public static LaInformacionDelPais en(String campo) {
        return new LaInformacionDelPais(campo);
    }
    
    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse()
            .jsonPath()
            .getString(campo);
    }
}
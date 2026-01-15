package com.segurosmundial.stepdefinitions;

import com.segurosmundial.questions.ElCodigoDeRespuesta;
import com.segurosmundial.questions.LaInformacionDelPais;
import com.segurosmundial.tasks.ConsultarPais;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnAPI;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

public class ConsultarPaisSteps {
    
    private Actor usuario;
    
    @Before
    public void setUp() {
        String baseUrl = System.getProperty("api.base.url", 
            "https://api-colombia.com/api/v1");
        
        usuario = Actor.named("Santiago");
        usuario.can(CallAnAPI.at(baseUrl));
    }
    
    @When("consulto la información del país {string}")
    public void consulto_la_informacion_del_pais(String nombrePais) {
        usuario.attemptsTo(
            ConsultarPais.llamado(nombrePais)
        );
    }
    
    @Then("el código de respuesta debe ser {int}")
    public void el_codigo_de_respuesta_debe_ser(Integer codigoEsperado) {
        usuario.should(
            seeThat(ElCodigoDeRespuesta.es(), equalTo(codigoEsperado))
        );
    }
    
    @Then("el nombre del país debe ser {string}")
    public void el_nombre_del_pais_debe_ser(String nombreEsperado) {
        usuario.should(
            seeThat(LaInformacionDelPais.en("name"), equalTo(nombreEsperado))
        );
    }
    
    @Then("la capital debe ser {string}")
    public void la_capital_debe_ser(String capitalEsperada) {
        usuario.should(
            seeThat(LaInformacionDelPais.en("stateCapital"), 
                equalTo(capitalEsperada))
        );
    }
    
    @Then("el código ISO debe ser {string}")
    public void el_codigo_iso_debe_ser(String codigoISO) {
        usuario.should(
            seeThat(LaInformacionDelPais.en("isoCode"), equalTo(codigoISO))
        );
    }
}
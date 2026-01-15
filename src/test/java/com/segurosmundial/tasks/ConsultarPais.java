package com.segurosmundial.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarPais implements Task {
    
    private final String nombrePais;
    
    private ConsultarPais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
    
    public static ConsultarPais llamado(String nombrePais) {
        return instrumented(ConsultarPais.class, nombrePais);
    }
    
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Get.resource("/Country/{country}")
                .with(request -> request
                    .pathParam("country", nombrePais)
                    .header("Accept", "application/json")
                    .log().all()
                )
        );
    }
}
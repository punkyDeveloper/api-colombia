package com.segurosmundial.hooks;

import io.cucumber.java.*;
import net.serenitybdd.rest.SerenityRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiHooks {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiHooks.class);
    
    @Before
    public void beforeScenario(Scenario scenario) {
        LOGGER.info("========================================");
        LOGGER.info("Iniciando: {}", scenario.getName());
        LOGGER.info("========================================");
    }
    
    @Before("@api")
    public void setupApi() {
        SerenityRest.reset();
    }
    
    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            LOGGER.error("❌ FALLÓ: {}", scenario.getName());
        } else {
            LOGGER.info("✅ EXITOSO: {}", scenario.getName());
        }
        SerenityRest.reset();
    }
}
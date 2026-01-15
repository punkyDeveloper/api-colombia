package com.segurosmundial.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Country {
    
    private Integer id;
    private String name;
    private String description;
    
    @SerializedName("stateCapital")
    private String stateCapital;
    
    private Integer surface;
    private Long population;
    private List<String> languages;
    
    @SerializedName("timeZone")
    private String timeZone;
    
    private String currency;
    
    @SerializedName("currencyCode")
    private String currencyCode;
    
    @SerializedName("currencySymbol")
    private String currencySymbol;
    
    @SerializedName("isoCode")
    private String isoCode;
    
    @SerializedName("internetDomain")
    private String internetDomain;
    
    @SerializedName("phonePrefix")
    private String phonePrefix;
    
    private String region;
    private List<String> borders;
    private List<String> flags;
    
    // Getters
    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getStateCapital() { return stateCapital; }
    public Long getPopulation() { return population; }
    public String getCurrency() { return currency; }
    public String getCurrencyCode() { return currencyCode; }
    public String getCurrencySymbol() { return currencySymbol; }
    public String getIsoCode() { return isoCode; }
    public String getPhonePrefix() { return phonePrefix; }
    public List<String> getBorders() { return borders; }
    
    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + stateCapital + '\'' +
                ", population=" + population +
                '}';
    }
}
package com.fl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Extension")
public class Extension {

    @Id
    private String _id;
    private String id;
    private String idSerie;
    private String name;
    private String logo;
    private String symbol;
    private int count;

    public Extension() {}

    public Extension(String id, String idSerie, String name, String logo, String symbol, int count) {
        this.id = id;
        this.idSerie = idSerie;
        this.name = name;
        this.logo = logo;
        this.symbol = symbol;
        this.count = count;
    }

    public String getId() {return this.id;}
    public void setId(String id) {this.id = id;}
    public String getIdSerie() {return this.idSerie;}
    public void setIdSerie(String idSerie) {this.idSerie = idSerie;}
    public String getLogo() {return logo;}
    public void setLogo(String logo) {this.logo = logo;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getSymbol() {return symbol;}
    public void setSymbol(String symbol) {this.symbol = symbol;}
    public int getCount() {return count;}
    public void setCount(int count) {this.count = count;}
}

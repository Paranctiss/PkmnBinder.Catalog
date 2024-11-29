package com.fl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Series")
public class Serie {

    @Id
    private String _id;
    @Field("id")
    private String id;
    private String name;
    private String logo;

    public Serie(){}

    public Serie(String id, String name, String logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getLogo() {return logo;}
    public void setLogo(String logo) {this.logo = logo;}
}

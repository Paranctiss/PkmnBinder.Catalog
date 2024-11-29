package com.fl.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Pokemon")
public class Pokemon {

    @Id
    private String _id;

    @Field("id")
    private String id;
    private String idSet;
    private String name;
    private String image;


    public Pokemon() {}

    public Pokemon(String idSet, String name, String image) {
        this.idSet = idSet;
        this.name = name;
        this.image = image;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getIdSet() {return idSet;}
    public void setIdSet(String idSet) {this.idSet = idSet;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getImage() {return image;}
    public void setImage(String image) {this.image = image;}
}

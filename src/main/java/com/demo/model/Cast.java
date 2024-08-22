package com.demo.model;

public class Cast {

    private String name;
    private String characterName;

    public Cast() {
    }

    public Cast(String name, String characterName) {
        this.name = name;
        this.characterName = characterName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
}

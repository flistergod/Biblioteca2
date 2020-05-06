package com.es2.Biblioteca;

public class Pessoa {

    private String name, email, morada, telefone;

    public Pessoa(String name, String email, String morada, String telefone) {
        this.name = name;
        this.email = email;
        this.morada = morada;
        this.telefone = telefone;
       // System.out.println("Pessoa " +name+ " criada");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

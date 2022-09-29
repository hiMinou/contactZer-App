package com.himinou.contactzer;

import java.io.Serializable;

public class Contact implements Serializable {
    private String nom, prenom, numero;
    public Contact(String nom, String prenom, String numero){
        this.nom= nom;
        this.prenom= prenom;
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumero() {
        return numero;
    }
}

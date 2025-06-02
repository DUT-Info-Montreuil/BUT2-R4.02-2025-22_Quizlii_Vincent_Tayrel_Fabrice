package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.dto;

/**
 * Représente une question d’un questionnaire.
 */
public class QuestionDTO {

    private int numero;
    private String libelle;
    private String reponse;
    private int difficulte;


    public QuestionDTO() {}

    public QuestionDTO(int numero, String libelle, String reponse, int difficulte, String explication, String reference) {
        this.numero = numero;
        this.libelle = libelle;
        this.reponse = reponse;
        this.difficulte = difficulte;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }



    @Override
    public String toString() {
        return "QuestionDto{" +
                "numero=" + numero +
                ", libelle='" + libelle + '\'' +
                ", reponse='" + reponse + '\'' +
                ", difficulte=" + difficulte +
                '}';
    }
}

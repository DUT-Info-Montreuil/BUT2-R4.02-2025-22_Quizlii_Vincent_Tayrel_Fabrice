package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.dto;

/**
 * Représente une question d’un questionnaire.
 */

public class QuestionDTO {
    private String question;
    private String bonneReponse;
    private int difficulte;

    public QuestionDTO(String question, String bonneReponse, int difficulte) {
        this.question = question;
        this.bonneReponse = bonneReponse;
        this.difficulte = difficulte;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getBonneReponse() {
        return bonneReponse;
    }

    public void setBonneReponse(String bonneReponse) {
        this.bonneReponse = bonneReponse;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "question='" + question + '\'' +
                ", difficulte=" + difficulte +
                '}';
    }
}

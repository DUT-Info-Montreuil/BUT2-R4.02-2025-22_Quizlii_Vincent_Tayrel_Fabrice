package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.dto;

import java.util.List;
import java.util.Objects;

/**
 * Représente un questionnaire avec son identifiant, libellé, langue et liste de questions.
 */
public class QuestionnaireDTO {

    private int idQuestionnaire;
    private String theme;
    private String langue;
    private List<QuestionDTO> questions;

    // Constructeur avec tous les paramètres
    public QuestionnaireDTO(int idQuestionnaire, String theme, String langue, List<QuestionDTO> questions) {
        this.idQuestionnaire = idQuestionnaire;
        this.theme = theme;
        this.langue = langue;
        this.questions = questions;
    }

    // Constructeur par défaut (nécessaire pour les tests et la sérialisation)
    public QuestionnaireDTO() {
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "QuestionnaireDTO{" +
                "idQuestionnaire=" + idQuestionnaire +
                ", theme='" + theme + '\'' +
                ", langue='" + langue + '\'' +
                ", questions=" + questions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionnaireDTO)) return false;
        QuestionnaireDTO that = (QuestionnaireDTO) o;
        return idQuestionnaire == that.idQuestionnaire &&
                Objects.equals(theme, that.theme) &&
                Objects.equals(langue, that.langue) &&
                Objects.equals(questions, that.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuestionnaire, theme, langue, questions);
    }
}
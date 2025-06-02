package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.dto;

import java.util.List;
import java.util.Objects;

/**
 * Représente un questionnaire avec son identifiant, libellé, langue et liste de questions.
 */
public class QuestionnaireDTO {

    private String idQuestionnaire;
    private String libelleQuestionnaire;
    private String langue;
    private List<QuestionDTO> questions;
    public QuestionnaireDTO() {}

    public QuestionnaireDTO(String idQuestionnaire, String libelleQuestionnaire, String langue, List<QuestionDTO> questions) {
        this.idQuestionnaire = idQuestionnaire;
        this.libelleQuestionnaire = libelleQuestionnaire;
        this.langue = langue;
        this.questions = questions;
    }

    public String getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(String idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public String getLibelleQuestionnaire() {
        return libelleQuestionnaire;
    }

    public void setLibelleQuestionnaire(String libelleQuestionnaire) {
        this.libelleQuestionnaire = libelleQuestionnaire;
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
        return "QuestionnaireDto{" +
                "idQuestionnaire='" + idQuestionnaire + '\'' +
                ", libelleQuestionnaire='" + libelleQuestionnaire + '\'' +
                ", langue='" + langue + '\'' +
                ", questions=" + questions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionnaireDTO)) return false;
        QuestionnaireDTO that = (QuestionnaireDTO) o;
        return Objects.equals(idQuestionnaire, that.idQuestionnaire) &&
                Objects.equals(libelleQuestionnaire, that.libelleQuestionnaire) &&
                Objects.equals(langue, that.langue) &&
                Objects.equals(questions, that.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuestionnaire, libelleQuestionnaire, langue, questions);
    }
}

package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

public class QuestionnaireNonTrouveException extends QuestionnaireException {

    public QuestionnaireNonTrouveException(String identifiant) {
        super("Questionnaire non trouvé : " + identifiant, "QUESTIONNAIRE_NOT_FOUND_ERROR");
    }

    public QuestionnaireNonTrouveException(String message, Throwable cause) {
        super(message, cause);
    }
}
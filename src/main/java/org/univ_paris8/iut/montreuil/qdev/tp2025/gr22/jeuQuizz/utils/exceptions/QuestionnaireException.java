package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

/**
 * Exception générique pour toutes les erreurs liées aux questionnaires
 * Sert de classe parente pour toutes les exceptions spécifiques aux questionnaires
 */
public class QuestionnaireException extends Exception {

    public QuestionnaireException() {
        super("Une erreur est survenue avec le questionnaire.");
    }

    public QuestionnaireException(String message) {
        super(message);
    }

    public QuestionnaireException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionnaireException(Throwable cause) {
        super(cause);
    }
}
package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

/**
 * Exception générique pour toutes les erreurs liées aux questionnaires
 * Sert de classe parente pour toutes les exceptions spécifiques aux questionnaires
 */
abstract class QuestionnaireException extends QuizzException {
    protected QuestionnaireException(String message) {
        super(message);
    }

    protected QuestionnaireException(String message, Throwable cause) {
        super(message, cause);
    }

    protected QuestionnaireException(String message, String errorCode) {
        super(message, errorCode);
    }
}
package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

/**
 * Exception lancée lorsqu'aucun questionnaire n'est trouvé ou disponible
 */
public class QuestionnaireNotFoundException extends Exception {

    public QuestionnaireNotFoundException() {
        super("Aucun questionnaire n'est disponible.");
    }

    public QuestionnaireNotFoundException(String message) {
        super(message);
    }
}
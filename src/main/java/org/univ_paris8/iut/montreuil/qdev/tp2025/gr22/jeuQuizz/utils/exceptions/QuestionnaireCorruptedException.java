package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

/**
 * Exception lancée lorsque le fichier de questionnaire est corrompu ou mal formaté
 */
public class QuestionnaireCorruptedException extends QuestionnaireException {

    public QuestionnaireCorruptedException() {
        super("Le fichier de questionnaire est corrompu ou mal formaté.");
    }

    public QuestionnaireCorruptedException(String message) {
        super(message);
    }
}
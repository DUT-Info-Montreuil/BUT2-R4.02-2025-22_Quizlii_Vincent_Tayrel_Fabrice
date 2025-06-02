
package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

/**
 * Exception lancée lorsque le fichier de questionnaire n'existe pas ou est inaccessible
 */
public class QuestionnaireFileNotFoundException extends QuestionnaireException {

    public QuestionnaireFileNotFoundException() {
        super("Le fichier de questionnaire est introuvable ou inaccessible.");
    }

    public QuestionnaireFileNotFoundException(String message) {
        super(message);
    }
}
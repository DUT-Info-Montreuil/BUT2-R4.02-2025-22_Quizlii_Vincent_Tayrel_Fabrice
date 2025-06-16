package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

public class QuestionMalformeeException extends QuestionnaireInvalideException {
    public QuestionMalformeeException(String question, String raison) {
        super(String.format("Question malformée '%s' : %s", question, raison), "MALFORMED_QUESTION_ERROR");
    }
}
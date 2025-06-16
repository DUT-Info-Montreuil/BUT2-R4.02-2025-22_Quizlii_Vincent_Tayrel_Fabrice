package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

public class QuestionnaireInvalideException extends QuestionnaireException {

    public QuestionnaireInvalideException(String message) {
        super(message);
    }

    public QuestionnaireInvalideException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionnaireInvalideException(String format, String malformedQuestionError) {
        super(format, malformedQuestionError);
    }
}
package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

public class ReponseInvalideException extends QuestionnaireInvalideException {
    public ReponseInvalideException(String reponse, String raison) {
        super(String.format("Réponse invalide '%s' : %s", reponse, raison), "INVALID_ANSWER_ERROR");
    }
}
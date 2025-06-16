package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

public class ValidationException extends ChargementException {
    public ValidationException(String message) {
        super("Erreur de validation : " + message, "VALIDATION_ERROR");
    }
}
package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

public class ChargementException extends TraitementException {

    public ChargementException(String message) {
        super(message);
    }

    public ChargementException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChargementException(String message, String validationError) {
        super(message, validationError);
    }

    public ChargementException(String s, Throwable cause, String mappingError) {
        super(s, cause);
    }
}
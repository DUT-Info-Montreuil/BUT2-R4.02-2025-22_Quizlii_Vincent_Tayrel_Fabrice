package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

abstract class TraitementException extends QuizzException {
    protected TraitementException(String message) {
        super(message);
    }

    protected TraitementException(String message, Throwable cause) {
        super(message, cause);
    }

    protected TraitementException(String message, String errorCode) {
        super(message, errorCode);
    }
}
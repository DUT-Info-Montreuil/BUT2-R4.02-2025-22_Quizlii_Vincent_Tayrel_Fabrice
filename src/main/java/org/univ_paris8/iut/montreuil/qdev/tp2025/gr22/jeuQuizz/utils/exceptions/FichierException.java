package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;
/**
 * Exception abstraite pour les erreurs liées aux fichiers
 */
abstract class FichierException extends QuizzException {
    protected FichierException(String message) {
        super(message);
    }

    protected FichierException(String message, Throwable cause) {
        super(message, cause);
    }

    protected FichierException(String message, String errorCode) {
        super(message, errorCode);
    }
}
package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

public class FichierIndisponibleException extends FichierException {

    public FichierIndisponibleException(String message) {
        super(message);
    }

    public FichierIndisponibleException(String message, Throwable cause) {
        super(message, cause);
    }


    public FichierIndisponibleException(String message, String permissionError) {
        super(message, permissionError);
    }
}
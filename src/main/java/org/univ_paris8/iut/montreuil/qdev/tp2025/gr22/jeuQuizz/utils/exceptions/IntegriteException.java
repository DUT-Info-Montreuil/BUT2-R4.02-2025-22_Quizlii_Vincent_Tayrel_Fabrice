package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

public class IntegriteException extends FichierException {

    public IntegriteException() {
        super("L'intégrité des données est compromise");
    }

    public IntegriteException(String message) {
        super(message);
    }

    public IntegriteException(String message, Throwable cause) {
        super(message, cause);
    }

    public IntegriteException(String format, String columnCountError) {
        super(format, columnCountError);
    }
}
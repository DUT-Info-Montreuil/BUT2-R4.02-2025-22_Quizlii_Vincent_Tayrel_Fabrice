package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;


/**
 * Exception levée lorsque le format du fichier est incorrect
 */
public class FormatFichierException extends FichierException {

    public FormatFichierException() {
        super("Le format du fichier n'est pas valide");
    }

    public FormatFichierException(String message) {
        super(message);
    }

    public FormatFichierException(String message, Throwable cause) {
        super(message, cause);
    }


    public FormatFichierException(String message, String fileNotFoundError) {
        super(message, fileNotFoundError);
    }
}
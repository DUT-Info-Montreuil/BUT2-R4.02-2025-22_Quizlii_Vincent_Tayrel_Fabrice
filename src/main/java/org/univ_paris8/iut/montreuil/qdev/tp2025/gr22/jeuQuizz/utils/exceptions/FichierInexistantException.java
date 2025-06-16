package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;


/**
 * Exception spécifique pour les fichiers inexistants
 */
public class FichierInexistantException extends FormatFichierException {
    public FichierInexistantException(String fichier) {
        super("Le fichier '" + fichier + "' n'existe pas", "FILE_NOT_FOUND_ERROR");
    }
}
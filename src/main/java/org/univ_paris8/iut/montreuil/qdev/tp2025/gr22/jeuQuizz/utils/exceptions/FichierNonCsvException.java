package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

/**
 * Exception spécifique pour les fichiers non-CSV
 */
public class FichierNonCsvException extends FormatFichierException {
    public FichierNonCsvException(String fichier) {
        super("Le fichier '" + fichier + "' n'est pas un fichier CSV valide", "NON_CSV_ERROR");
    }
}
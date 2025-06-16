package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

public class FichierVideException extends IntegriteException {
    public FichierVideException() {
        super("Le fichier est vide", "EMPTY_FILE_ERROR");
    }
}
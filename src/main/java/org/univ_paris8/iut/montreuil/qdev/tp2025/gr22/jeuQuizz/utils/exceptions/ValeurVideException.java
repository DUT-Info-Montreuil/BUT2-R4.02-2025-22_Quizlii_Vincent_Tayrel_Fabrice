package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

public class ValeurVideException extends IntegriteException {
    public ValeurVideException(String ligne) {
        super("Valeur vide ou nulle détectée dans la ligne : " + ligne, "EMPTY_VALUE_ERROR");
    }
}
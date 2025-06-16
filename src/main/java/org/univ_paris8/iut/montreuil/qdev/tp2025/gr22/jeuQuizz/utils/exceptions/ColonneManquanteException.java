package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

/**
 * Exception spécifique pour les colonnes manquantes
 */
public class ColonneManquanteException extends IntegriteException {
    public ColonneManquanteException(int attendues, int trouvees, String ligne) {
        super(String.format("Nombre de colonnes incorrect : %d attendues, %d trouvées. Ligne : %s",
                attendues, trouvees, ligne), "COLUMN_COUNT_ERROR");
    }
}
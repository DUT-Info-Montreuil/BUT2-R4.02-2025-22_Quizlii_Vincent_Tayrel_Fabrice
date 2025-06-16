package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

/**
 * Exception spécifique pour les permissions insuffisantes
 */
public class PermissionInsuffisanteException extends FichierIndisponibleException {
    public PermissionInsuffisanteException(String fichier) {
        super("Permissions insuffisantes pour accéder au fichier : " + fichier, "PERMISSION_ERROR");
    }
}
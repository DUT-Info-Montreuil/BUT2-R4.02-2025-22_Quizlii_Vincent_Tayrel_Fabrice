package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

public class MappingException extends ChargementException {
    public MappingException(String message, Throwable cause) {
        super("Erreur lors du mapping des données : " + message, cause, "MAPPING_ERROR");
    }
}
package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions;

/**
 * Exception abstraite mère pour toutes les exceptions liées au jeu Quizz
 */
public abstract class QuizzException extends Exception {

    /**
     * Code d'erreur associé à l'exception
     */
    private final String errorCode;

    /**
     * Constructeur avec message uniquement
     * @param message Message d'erreur
     */
    protected QuizzException(String message) {
        super(message);
        this.errorCode = generateErrorCode();
    }

    /**
     * Constructeur avec message et cause
     * @param message Message d'erreur
     * @param cause Cause de l'exception
     */
    protected QuizzException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = generateErrorCode();
    }

    /**
     * Constructeur avec message et code d'erreur personnalisé
     * @param message Message d'erreur
     * @param errorCode Code d'erreur personnalisé
     */
    protected QuizzException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * Constructeur avec message, cause et code d'erreur personnalisé
     * @param message Message d'erreur
     * @param cause Cause de l'exception
     * @param errorCode Code d'erreur personnalisé
     */
    protected QuizzException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    /**
     * Génère un code d'erreur basé sur le nom de la classe
     * @return Code d'erreur généré
     */
    private String generateErrorCode() {
        return this.getClass().getSimpleName().toUpperCase().replace("EXCEPTION", "_ERROR");
    }

    /**
     * Retourne le code d'erreur associé
     * @return Code d'erreur
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Retourne une représentation complète de l'erreur
     * @return Message formaté avec code d'erreur
     */
    public String getFormattedMessage() {
        return String.format("[%s] %s", errorCode, getMessage());
    }
}
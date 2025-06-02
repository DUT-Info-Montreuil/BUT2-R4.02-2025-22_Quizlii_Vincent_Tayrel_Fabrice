package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions.QuestionnaireException;

import java.util.List;
import java.io.IOException;

/**
 * Interface pour la gestion des questionnaires dans le jeu du Quizz
 */
public interface QuestionnaireServices {

    /**
     * Fournit la liste des questionnaires disponibles dans le jeu
     *
     * @return Liste des questionnaires chargés et disponibles pour jouer
     * @throws QuestionnaireException si un problème lié au questionnaire survient (non trouvé, corrompu, etc.)
     * @throws IOException si une erreur de lecture/écriture survient
     */
    List<QuestionnaireDTO> fournirListeQuestionnaire() throws QuestionnaireException, IOException;
}
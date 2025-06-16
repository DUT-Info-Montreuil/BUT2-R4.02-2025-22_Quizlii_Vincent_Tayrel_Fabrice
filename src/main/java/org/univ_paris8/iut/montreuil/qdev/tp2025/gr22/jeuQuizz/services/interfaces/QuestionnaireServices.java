package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.bo.FichierCsvBO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions.*;

import java.util.ArrayList;

/**
 * Interface pour la gestion des questionnaires dans le jeu du Quizli
 */
public interface QuestionnaireServices {



    public FichierCsvBO chargerFichier(String path) throws FormatFichierException, IntegriteException;

    public ArrayList<QuestionnaireDTO> fournirListeQuestionnaire() throws FichierIndisponibleException, ChargementException;



}
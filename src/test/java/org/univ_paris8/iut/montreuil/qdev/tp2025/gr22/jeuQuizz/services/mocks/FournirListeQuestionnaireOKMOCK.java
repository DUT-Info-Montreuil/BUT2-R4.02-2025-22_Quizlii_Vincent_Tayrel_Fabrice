package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.services.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.bo.FichierCsvBO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.services.interfaces.QuestionnaireServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions.ChargementException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions.FichierIndisponibleException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions.FormatFichierException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions.IntegriteException;

import java.util.ArrayList;

public class FournirListeQuestionnaireOKMOCK implements QuestionnaireServices {
    @Override
    public FichierCsvBO chargerFichier(String path) throws FormatFichierException, IntegriteException {
        return new FichierCsvBO(new ArrayList<>());
    }

    @Override
    public ArrayList<QuestionnaireDTO> fournirListeQuestionnaire() throws FichierIndisponibleException, ChargementException {
        ArrayList<QuestionnaireDTO> questionnaires = new ArrayList<>();
        // Simuler deux questionnaires (à adapter selon votre implémentation de QuestionnaireDTO)
        // questionnaires.add(new QuestionnaireDTO(...));
        // questionnaires.add(new QuestionnaireDTO(...));

        // Pour la démonstration, on simule juste la taille
        questionnaires.add(null); // Remplacer par de vrais objets QuestionnaireDTO
        questionnaires.add(null); // Remplacer par de vrais objets QuestionnaireDTO

        return questionnaires;
    }
}
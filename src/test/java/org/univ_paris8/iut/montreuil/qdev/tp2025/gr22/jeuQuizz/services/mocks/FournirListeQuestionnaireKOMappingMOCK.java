package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.services.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.bo.FichierCsvBO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.services.interfaces.QuestionnaireServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions.*;

import java.util.ArrayList;

public class FournirListeQuestionnaireKOMappingMOCK implements QuestionnaireServices {
    @Override
    public FichierCsvBO chargerFichier(String path) throws FormatFichierException, IntegriteException {
        return new FichierCsvBO(new ArrayList<>());
    }

    @Override
    public ArrayList<QuestionnaireDTO> fournirListeQuestionnaire() throws FichierIndisponibleException, ChargementException {
        throw new MappingException("Erreur lors du mapping", new RuntimeException("Mock mapping error"));
    }
}
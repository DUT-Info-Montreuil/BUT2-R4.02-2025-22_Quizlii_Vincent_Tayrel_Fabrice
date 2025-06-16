package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.services.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.bo.FichierCsvBO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.services.interfaces.QuestionnaireServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions.ChargementException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions.FichierIndisponibleException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions.FormatFichierException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions.IntegriteException;

import java.util.ArrayList;

public class ChargerFichierKOIntegriteMOCK implements QuestionnaireServices {
    @Override
    public FichierCsvBO chargerFichier(String path) throws FormatFichierException, IntegriteException {
        throw new IntegriteException("Erreur d'intégrité des données");
    }

    @Override
    public ArrayList<QuestionnaireDTO> fournirListeQuestionnaire() throws FichierIndisponibleException, ChargementException {
        try {
            chargerFichier("dummy_path.csv");
        } catch (FormatFichierException e) {
            throw new FichierIndisponibleException("Fichier indisponible : " + e.getFormattedMessage(), e);
        } catch (IntegriteException e) {
            throw new ChargementException("Erreur d'intégrité : " + e.getFormattedMessage(), e);
        }
        return null;
    }
}
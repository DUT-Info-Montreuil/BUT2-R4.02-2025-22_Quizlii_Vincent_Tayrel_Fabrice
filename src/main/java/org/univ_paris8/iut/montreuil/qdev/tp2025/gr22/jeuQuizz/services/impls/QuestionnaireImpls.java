package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.services.impls;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.bo.FichierCsvBO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.mappers.FichierCsvBoToQuestionnaireDTOMapper;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.services.interfaces.QuestionnaireServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class QuestionnaireImpls implements QuestionnaireServices {

    public FichierCsvBO chargerFichier(String path) throws FormatFichierException, IntegriteException {
        if (path == null || path.isBlank()) {
            throw new FormatFichierException("Le chemin du fichier est vide ou null.");
        }

        if (!path.endsWith(".csv")) {
            // Utilisation de la classe interne statique
            throw new FichierNonCsvException(path);
        }

        File fichier = new File(path);
        if (!fichier.exists()) {
            // Utilisation de la classe interne statique
            throw new FichierInexistantException(path);
        }

        if (!fichier.isFile()) {
            throw new FormatFichierException("Le chemin ne pointe pas vers un fichier.");
        }

        List<List<String>> contenu;

        try (CSVReader csvReader = new CSVReader(new FileReader(fichier))) {
            List<String[]> lignes = csvReader.readAll();
            contenu = new ArrayList<>();

            for (String[] valeurs : lignes) {
                if (valeurs.length != 12) {
                    // Utilisation de la classe interne statique
                    throw new ColonneManquanteException(12, valeurs.length, String.join(";", valeurs));
                }

                for (String val : valeurs) {
                    if (val == null || val.trim().isEmpty()) {
                        // Utilisation de la classe interne statique
                        throw new ValeurVideException(String.join(";", valeurs));
                    }
                }

                contenu.add(Arrays.asList(valeurs));
            }

            if (contenu.isEmpty()) {
                // Utilisation de la classe interne statique
                throw new FichierVideException();
            }

        } catch (IOException | CsvException e) {
            throw new FormatFichierException("Erreur lors de la lecture du fichier : " + e.getMessage(), e);
        }

        return new FichierCsvBO(contenu);
    }

    @Override
    public ArrayList<QuestionnaireDTO> fournirListeQuestionnaire() throws FichierIndisponibleException, ChargementException {
        String path = "src/main/resources/questionnaires.csv";
        FichierCsvBO fichier;

        try {
            fichier = chargerFichier(path);
        } catch (FormatFichierException e) {
            throw new FichierIndisponibleException("Fichier indisponible : " + e.getFormattedMessage(), e);
        } catch (IntegriteException e) {
            throw new ChargementException("Erreur d'intégrité dans le fichier : " + e.getFormattedMessage(), e);
        }

        try {
            return FichierCsvBoToQuestionnaireDTOMapper.map(fichier);
        } catch (Exception e) {
            // Utilisation de la classe interne statique
            throw new MappingException("Erreur lors du mapping du fichier", e);
        }
    }
}
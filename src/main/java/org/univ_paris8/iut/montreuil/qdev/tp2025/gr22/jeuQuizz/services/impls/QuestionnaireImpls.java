package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.services.impls;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
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
            throw new FichierNonCsvException(path);
        }

        File fichier = new File(path);
        if (!fichier.exists()) {
            throw new FichierInexistantException(path);
        }

        if (!fichier.isFile()) {
            throw new FormatFichierException("Le chemin ne pointe pas vers un fichier.");
        }

        List<List<String>> contenu;

        try (FileReader fileReader = new FileReader(fichier);
             // Configuration du CSVReader avec point-virgule comme séparateur
             CSVReader csvReader = new CSVReaderBuilder(fileReader)
                     .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                     .build()) {


            List<String[]> lignes = csvReader.readAll();
            contenu = new ArrayList<>();

            if (lignes.isEmpty()) {
                throw new FichierVideException();
            }

            for (String[] valeurs : lignes) {
                if (valeurs.length != 12) {
                    throw new ColonneManquanteException(12, valeurs.length, String.join(";", valeurs));
                }

                // Vérification des valeurs vides AVANT d'ajouter à la liste
                for (String val : valeurs) {
                    if (val == null || val.trim().isEmpty()) {
                        throw new ValeurVideException(String.join(";", valeurs));
                    }
                }

                contenu.add(Arrays.asList(valeurs));
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
            throw new MappingException("Erreur lors du mapping du fichier", e);
        }
    }
}
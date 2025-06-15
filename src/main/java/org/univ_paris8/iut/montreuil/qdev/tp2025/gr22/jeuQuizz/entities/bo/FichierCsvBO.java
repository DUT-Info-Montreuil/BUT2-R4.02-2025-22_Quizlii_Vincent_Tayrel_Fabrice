package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.bo;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions.QuestionnaireException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FichierCsvBO {

    /**
     * Charge un fichier CSV et retourne toutes les lignes sous forme de liste de tableaux de chaînes
     *
     * @param cheminFichier Le chemin vers le fichier CSV à charger
     * @return Liste des lignes du fichier CSV, chaque ligne étant un tableau de chaînes
     * @throws QuestionnaireException si le fichier est introuvable, corrompu ou mal formaté
     * @throws IOException si une erreur d'entrée/sortie survient
     */
    public List<String[]> chargerFichierCsv(String cheminFichier) throws QuestionnaireException, IOException {
        List<String[]> lignes;

        try (CSVReader csvReader = new CSVReader(new FileReader(cheminFichier))) {
            lignes = csvReader.readAll();

            // Vérification que le fichier n'est pas vide
            if (lignes == null || lignes.isEmpty()) {
                throw new QuestionnaireException("Le fichier CSV est vide : " + cheminFichier);
            }

            // Vérification du format (9 colonnes attendues selon le cahier des charges)
            for (int i = 0; i < lignes.size(); i++) {
                String[] ligne = lignes.get(i);
                if (ligne.length != 9) {
                    throw new QuestionnaireException(
                            "Format incorrect ligne " + (i + 1) + " : " + ligne.length +
                                    " colonnes trouvées, 9 attendues (id questionnaire, libellé questionnaire, " +
                                    "num quest, langue, libellé question, réponse, difficulté, explication, référence)"
                    );
                }
            }

        } catch (CsvException e) {
            throw new QuestionnaireException("Erreur lors de la lecture du fichier CSV : " + e.getMessage(), e);
        } catch (IOException e) {
            throw new QuestionnaireException("Impossible d'accéder au fichier : " + cheminFichier, e);
        }

        return lignes;
    }

    /**
     * Vérifie si un fichier CSV existe et est accessible
     *
     * @param cheminFichier Le chemin vers le fichier CSV à vérifier
     * @return true si le fichier existe et est accessible, false sinon
     */
    public boolean verifierExistenceFichier(String cheminFichier) {
        try {
            java.io.File fichier = new java.io.File(cheminFichier);
            return fichier.exists() && fichier.canRead();
        } catch (Exception e) {
            return false;
        }
    }
}
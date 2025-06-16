package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.mappers;


import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.bo.FichierCsvBO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions.IntegriteException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FichierCsvBoToQuestionnaireDTOMapper {


    public static ArrayList<QuestionnaireDTO> map(FichierCsvBO fichier) throws Exception {
        Map<Integer, QuestionnaireDTO> mapQuestionnaires = new HashMap<>();

        for (List<String> ligne : fichier.getContenu()) {
            // On attend 12 colonnes car le Csv complet a 12 colonnes
            if (ligne.size() != 12) {
                throw new IntegriteException("Chaque ligne doit contenir 12 colonnes");
            }

            int idQuestionnaire;
            int difficulte;
            try {
                // Extraction uniquement des colonnes utiles
                idQuestionnaire = Integer.parseInt(ligne.get(0).trim());
                difficulte = Integer.parseInt(ligne.get(4).trim());
            } catch (NumberFormatException e) {
                throw new Exception("Erreur de format numérique dans la ligne: " + ligne);
            }

            // Colonnes utiles pour le jeu
            String theme = ligne.get(1).trim();
            String langue = ligne.get(2).trim();
            String questionText = ligne.get(3).trim();
            String bonneReponse = ligne.get(4).trim();

            QuestionDTO question = new QuestionDTO(questionText, bonneReponse, difficulte);

            QuestionnaireDTO questionnaire = mapQuestionnaires.get(idQuestionnaire);

            if (questionnaire == null) {
                ArrayList<QuestionDTO> questions = new ArrayList<>();
                questions.add(question);
                questionnaire = new QuestionnaireDTO(idQuestionnaire, theme, langue, questions);
                mapQuestionnaires.put(idQuestionnaire, questionnaire);
            } else {
                questionnaire.getQuestions().add(question);
            }
        }

        return new ArrayList<>(mapQuestionnaires.values());
    }
}
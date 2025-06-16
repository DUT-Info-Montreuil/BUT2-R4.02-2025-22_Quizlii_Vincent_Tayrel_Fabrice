package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.dto;

import java.util.ArrayList;

public class ListeQuestionnaireDTO {
    private ArrayList<QuestionnaireDTO> liste;

    public ListeQuestionnaireDTO(ArrayList<QuestionnaireDTO> liste) {
        this.liste = liste;
    }

    public ArrayList<QuestionnaireDTO> getListe() {
        return liste;
    }

}

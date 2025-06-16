package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.bo;

import java.util.List;

public class FichierCsvBO {

    private List<List<String>> contenu;

    public FichierCsvBO(List<List<String>> contenu) {
        this.contenu = contenu;
    }

    public List<List<String>> getContenu() {
        return contenu;
    }

    public void setContenu(List<List<String>> contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FichierCSVBO {\n");
        for (List<String> ligne : contenu) {
            sb.append("  ").append(ligne).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
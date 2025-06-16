package org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.io.TempDir;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.bo.FichierCsvBO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.services.impls.QuestionnaireImpls;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.services.interfaces.QuestionnaireServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.services.mocks.*;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr22.jeuQuizz.utils.exceptions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class QuestionnaireImplsTest {

    private QuestionnaireServices questionnaireService;
    private QuestionnaireImpls questionnaireImpls;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        questionnaireImpls = new QuestionnaireImpls();
    }

    // =============================================================================
    // TESTS POUR chargerFichier() - CAS D'ERREUR
    // =============================================================================

    @Test
    @DisplayName("Test chargerFichier avec chemin null")
    void testChargerFichierCheminNull() {
        assertThrows(FormatFichierException.class, () -> {
            questionnaireImpls.chargerFichier(null);
        });
    }

    @Test
    @DisplayName("Test chargerFichier avec chemin vide")
    void testChargerFichierCheminVide() {
        assertThrows(FormatFichierException.class, () -> {
            questionnaireImpls.chargerFichier("");
        });
    }

    @Test
    @DisplayName("Test chargerFichier avec chemin contenant seulement des espaces")
    void testChargerFichierCheminEspaces() {
        assertThrows(FormatFichierException.class, () -> {
            questionnaireImpls.chargerFichier("   ");
        });
    }

    @Test
    @DisplayName("Test chargerFichier avec fichier non CSV")
    void testChargerFichierNonCsv() {
        assertThrows(FichierNonCsvException.class, () -> {
            questionnaireImpls.chargerFichier("fichier.txt");
        });
    }

    @Test
    @DisplayName("Test chargerFichier avec fichier inexistant")
    void testChargerFichierInexistant() {
        assertThrows(FichierInexistantException.class, () -> {
            questionnaireImpls.chargerFichier("fichier_inexistant.csv");
        });
    }

    @Test
    @DisplayName("Test chargerFichier avec répertoire au lieu de fichier")
    void testChargerFichierRepertoire() throws IOException {
        File repertoire = tempDir.resolve("repertoire.csv").toFile();
        repertoire.mkdir();

        assertThrows(FormatFichierException.class, () -> {
            questionnaireImpls.chargerFichier(repertoire.getAbsolutePath());
        });
    }

    @Test
    @DisplayName("Test chargerFichier avec fichier vide")
    void testChargerFichierVide() throws IOException {
        File fichierVide = tempDir.resolve("vide.csv").toFile();
        fichierVide.createNewFile();

        assertThrows(FichierVideException.class, () -> {
            questionnaireImpls.chargerFichier(fichierVide.getAbsolutePath());
        });
    }

    @Test
    @DisplayName("Test chargerFichier avec nombre de colonnes incorrect")
    void testChargerFichierColonnesIncorrectes() throws IOException {
        File fichier = tempDir.resolve("colonnes_incorrectes.csv").toFile();
        try (FileWriter writer = new FileWriter(fichier)) {
            writer.write("col1;col2;col3\n");
            writer.write("val1;val2;val3\n");
        }

        assertThrows(ColonneManquanteException.class, () -> {
            questionnaireImpls.chargerFichier(fichier.getAbsolutePath());
        });
    }

    @Test
    @DisplayName("Test chargerFichier avec valeur vide")
    void testChargerFichierValeurVide() throws IOException {
        File fichier = tempDir.resolve("valeur_vide.csv").toFile();
        try (FileWriter writer = new FileWriter(fichier)) {
            writer.write("c1;c2;c3;c4;c5;c6;c7;c8;c9;c10;c11;c12\n");
            writer.write("v1;v2;;v4;v5;v6;v7;v8;v9;v10;v11;v12\n");
        }

        assertThrows(ValeurVideException.class, () -> {
            questionnaireImpls.chargerFichier(fichier.getAbsolutePath());
        });
    }

    @Test
    @DisplayName("Test chargerFichier avec valeur null simulée (espaces)")
    void testChargerFichierValeurEspaces() throws IOException {
        File fichier = tempDir.resolve("valeur_espaces.csv").toFile();
        try (FileWriter writer = new FileWriter(fichier)) {
            writer.write("c1;c2;c3;c4;c5;c6;c7;c8;c9;c10;c11;c12\n");
            writer.write("v1;v2;   ;v4;v5;v6;v7;v8;v9;v10;v11;v12\n");
        }

        assertThrows(ValeurVideException.class, () -> {
            questionnaireImpls.chargerFichier(fichier.getAbsolutePath());
        });
    }

    // =============================================================================
    // TESTS POUR chargerFichier() - CAS DE SUCCÈS
    // =============================================================================

    @Test
    @DisplayName("Test chargerFichier avec fichier valide")
    void testChargerFichierValide() throws IOException, FormatFichierException, IntegriteException {
        File fichier = tempDir.resolve("valide.csv").toFile();
        try (FileWriter writer = new FileWriter(fichier)) {
            writer.write("q1;r1;r2;r3;r4;c1;c2;c3;c4;cat;diff;theme\n");
            writer.write("Question1;Rep1;Rep2;Rep3;Rep4;1;0;0;0;Math;Facile;Algebre\n");
            writer.write("Question2;Rep1;Rep2;Rep3;Rep4;0;1;0;0;Math;Moyen;Geometrie\n");
        }

        FichierCsvBO resultat = questionnaireImpls.chargerFichier(fichier.getAbsolutePath());

        assertNotNull(resultat);
        assertEquals(3, resultat.getContenu().size()); // Header + 2 lignes de données
    }

    // =============================================================================
    // TESTS POUR fournirListeQuestionnaire() - AVEC MOCKS
    // =============================================================================

    @Test
    @DisplayName("Test fournirListeQuestionnaire avec erreur de format fichier")
    void testFournirListeQuestionnaireFormatInvalide() {
        questionnaireService = new ChargerFichierKOFormatInvalideMOCK();

        assertThrows(FichierIndisponibleException.class, () -> {
            questionnaireService.fournirListeQuestionnaire();
        });
    }

    @Test
    @DisplayName("Test fournirListeQuestionnaire avec erreur d'intégrité")
    void testFournirListeQuestionnaireIntegriteKO() {
        questionnaireService = new ChargerFichierKOIntegriteMOCK();

        assertThrows(ChargementException.class, () -> {
            questionnaireService.fournirListeQuestionnaire();
        });
    }

    @Test
    @DisplayName("Test fournirListeQuestionnaire avec erreur de mapping")
    void testFournirListeQuestionnaireMappingKO() {
        questionnaireService = new FournirListeQuestionnaireKOMappingMOCK();

        assertThrows(MappingException.class, () -> {
            questionnaireService.fournirListeQuestionnaire();
        });
    }

    @Test
    @DisplayName("Test fournirListeQuestionnaire avec succès")
    void testFournirListeQuestionnaireOK() throws FichierIndisponibleException, ChargementException {
        questionnaireService = new FournirListeQuestionnaireOKMOCK();

        ArrayList<QuestionnaireDTO> resultat = questionnaireService.fournirListeQuestionnaire();

        assertNotNull(resultat);
        assertEquals(2, resultat.size());
    }

    // =============================================================================
    // TESTS D'INTÉGRATION
    // =============================================================================

    @Test
    @DisplayName("Test d'intégration complet avec fichier réel")
    void testIntegrationComplete() throws IOException {
        // Créer un fichier CSV de test complet dans le répertoire temporaire
        File fichier = tempDir.resolve("questionnaires_test.csv").toFile();

        try (FileWriter writer = new FileWriter(fichier)) {
            writer.write("question;reponse1;reponse2;reponse3;reponse4;correct1;correct2;correct3;correct4;categorie;difficulte;theme\n");
            writer.write("Combien font 2+2?;3;4;5;6;0;1;0;0;Math;Facile;Arithmetique\n");
            writer.write("Capitale de la France?;Berlin;Madrid;Paris;Rome;0;0;1;0;Geo;Facile;Europe\n");
        }

        // Test du chargement de fichier directement
        assertDoesNotThrow(() -> {
            FichierCsvBO resultat = questionnaireImpls.chargerFichier(fichier.getAbsolutePath());
            assertNotNull(resultat, "Le fichier devrait être chargé correctement");
            assertEquals(3, resultat.getContenu().size(), "Le fichier devrait contenir 3 lignes");
        });
    }

    // =============================================================================
    // TESTS DE VALIDATION DES MESSAGES D'ERREURS
    // =============================================================================

    @Test
    @DisplayName("Test validation du message d'erreur pour fichier non CSV")
    void testMessageErreurFichierNonCsv() {
        FichierNonCsvException exception =
                assertThrows(FichierNonCsvException.class, () -> {
                    questionnaireImpls.chargerFichier("test.txt");
                });

        assertTrue(exception.getMessage().contains("test.txt"));
        assertEquals("NON_CSV_ERROR", exception.getErrorCode());
    }

    @Test
    @DisplayName("Test validation du message d'erreur pour colonnes manquantes")
    void testMessageErreurColonnesManquantes() throws IOException {
        File fichier = tempDir.resolve("test_colonnes.csv").toFile();
        try (FileWriter writer = new FileWriter(fichier)) {
            writer.write("col1;col2;col3\n");
        }

        ColonneManquanteException exception =
                assertThrows(ColonneManquanteException.class, () -> {
                    questionnaireImpls.chargerFichier(fichier.getAbsolutePath());
                });

        // Vérifications corrigées
        assertTrue(exception.getMessage().contains("12 attendues"),
                "Le message devrait contenir '12 attendues'");
        assertTrue(exception.getMessage().contains("3 trouvées"),
                "Le message devrait contenir '3 trouvées'");
        assertEquals("COLUMN_COUNT_ERROR", exception.getErrorCode(),
                "Le code d'erreur devrait être COLUMN_COUNT_ERROR");
    }
}
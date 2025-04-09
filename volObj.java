package Vole;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import Vole.Object;
import Vole.Connexion_to_db;
public class volObj extends Application {



        private TextField txtType;
        private TextField txtNumeroSerie;
        private TextField txtMarque;
        private Label lblStatus;
        private Connexion_to_db repository;

        @Override
        public void start(Stage primaryStage) {
            repository = new Connexion_to_db();

            txtType = new TextField();
            txtNumeroSerie = new TextField();
            txtMarque = new TextField();

            Label lblType = new Label("Type d'objet:");
            Label lblNumeroSerie = new Label("Numéro de série:");
            Label lblMarque = new Label("Marque:");

            lblStatus = new Label();

            Button btnEnregistrer = new Button("1. Enregistrer l'objet");
            Button btnVerifier = new Button("2. Vérifier si volé");
            Button btnAlerter = new Button("3. Alerter si volé");

            btnEnregistrer.setOnAction(e -> {
                String type = txtType.getText().trim();
                String numero = txtNumeroSerie.getText().trim();
                String marque = txtMarque.getText().trim();
                if (!type.isEmpty() && !numero.isEmpty() && !marque.isEmpty()) {
                    Object objet = new Object(type, numero, marque, false);
                    repository.enregistrerObjet(objet);
                    lblStatus.setText(" Objet enregistré avec succès.");
                } else {
                    lblStatus.setText(" Tous les champs sont obligatoires pour l'enregistrement.");
                }
            });

            btnVerifier.setOnAction(e -> {
                String numero = txtNumeroSerie.getText().trim();
                if (!numero.isEmpty()) {
                    boolean vole = repository.estVole(numero);
                    if (vole) {
                        lblStatus.setText(" Cet objet est déclaré volé.");
                    } else {
                        lblStatus.setText("Cet objet n'est pas déclaré volé.");
                    }
                } else {
                    lblStatus.setText(" Entrer un numéro de série pour vérifier.");
                }
            });

            btnAlerter.setOnAction(e -> {
                String numero = txtNumeroSerie.getText().trim();
                if (!numero.isEmpty()) {
                    if (repository.estVole(numero)) {
                        envoyerAlerte(numero);
                        lblStatus.setText(" Alerte envoyée au propriétaire de l'objet volé !");
                    } else {
                        lblStatus.setText(" Aucun signalement : l'objet n'est pas volé.");
                    }
                } else {
                    lblStatus.setText(" Fournir un numéro de série pour envoyer une alerte.");
                }
            });

            GridPane grid = new GridPane();
            grid.setPadding(new Insets(20));
            grid.setVgap(10);
            grid.setHgap(10);

            grid.add(lblType, 0, 0);
            grid.add(txtType, 1, 0);
            grid.add(lblNumeroSerie, 0, 1);
            grid.add(txtNumeroSerie, 1, 1);
            grid.add(lblMarque, 0, 2);
            grid.add(txtMarque, 1, 2);

            HBox boutonBox = new HBox(10, btnEnregistrer, btnVerifier, btnAlerter);
            grid.add(boutonBox, 0, 3, 2, 1);
            grid.add(lblStatus, 0, 4, 2, 1);

            Scene scene = new Scene(grid, 600, 250);
            primaryStage.setTitle("Gestion d'Objets Volés");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        private void envoyerAlerte(String numeroSerie) {
            System.out.println("[ALERTE] Objet volé détecté : " + numeroSerie);
        }

        public static void main(String[] args) {
            launch(args);
        }
    }


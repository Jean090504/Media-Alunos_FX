package br.senai.sp.jandira.media_final;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MediaFinalApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //determinar o tamanho do stage
        stage.setWidth(600);
        stage.setHeight(500);

        //determinar o título do stage (tela/janela)
        stage.setTitle("Média Final");

        //painel raiz (root)
        BorderPane root = new BorderPane();

        //Texto principal
        Label labelTitulo = new Label();
        labelTitulo.setText("Escola \"Prof. Vicente Amato\"");
        //formatação do texto da label
        labelTitulo.setStyle("-fx-text-fill: #3300ff; -fx-font-size: 32; -fx-font-weight: bold");
        labelTitulo.setPadding(new Insets(10, 0, 10, 10));


        //painel de resultados - parte de baixo
        VBox painelResultado = new VBox();
        painelResultado.setPadding(new Insets(0, 0, 10, 10));
        Label labelAluno = new Label("Nome do Aluno:");
        Label labelMedia = new Label("Média Final:");
        Label labelSituacao = new Label("Situação:");
        painelResultado.getChildren().addAll(labelAluno, labelMedia, labelSituacao);

        //painel de botoes
        VBox painelDeBotoes = new VBox();
        painelDeBotoes.setPadding(new Insets(50, 80, 10, 0));
        painelDeBotoes.setSpacing(20);
        Button buttonCalcularMedia = new Button("Calcular Média");
        buttonCalcularMedia.setPrefWidth(120);
        buttonCalcularMedia.setPrefHeight(30);
        Button buttonLimpar = new Button("Limpar");
        buttonLimpar.setPrefWidth(120);
        buttonLimpar.setPrefHeight(30);
        Button buttonSair = new Button("Sair");
        buttonSair.setPrefWidth(120);
        buttonSair.setPrefHeight(30);
        painelDeBotoes.getChildren().addAll(buttonCalcularMedia, buttonLimpar, buttonSair);

        //painel de formulario, inserir dados
        VBox painelDeFormulario = new VBox();
        painelDeFormulario.setPadding(new Insets(0, 0, 10, 10));
        Label labelNomeAluno = new Label("Nome do Aluno");
        Label labelNota1 = new Label("Nota 1:");
        Label labelNota2 = new Label("Nota 2:");
        Label labelNota3 = new Label("Nota 3:");
        Label labelNota4 = new Label("Nota 4:");
        TextField textFieldNome = new TextField();
        TextField textFieldNota1 = new TextField();
        TextField textFieldNota2 = new TextField();
        TextField textFieldNota3 = new TextField();
        TextField textFieldNota4 = new TextField();
        painelDeFormulario.getChildren().addAll(
                labelNomeAluno, textFieldNome,
                labelNota1, textFieldNota1,
                labelNota2, textFieldNota2,
                labelNota3, textFieldNota3,
                labelNota4, textFieldNota4
        );

        root.setTop(labelTitulo);
        root.setBottom(painelResultado);
        root.setRight(painelDeBotoes);
        root.setLeft(painelDeFormulario);

        Scene scene = new Scene(root);

        stage.setScene(scene);

        //mostrar o stage (tela)
        stage.show();

        //eventos de click dos botoes
        buttonCalcularMedia.setOnAction( click -> {
            System.out.println("Botão Clicado");
            String nomeDigitado = textFieldNome.getText();
            labelAluno.setText("Nome do Aluno: " + nomeDigitado);

            //Criar Vetor de Notas
            double[] notas = new double[4];
            String[] notasStr = new String[4];

            // Calcular Média
            notasStr[0] = textFieldNota1.getText();
            notas[0] = Double.parseDouble(notasStr[0]);

            notasStr[1] = textFieldNota2.getText();
            notas[1] = Double.parseDouble(notasStr[1]);

            notasStr[2] = textFieldNota3.getText();
            notas[2] = Double.parseDouble(notasStr[2]);

            notasStr[3] = textFieldNota4.getText();
            notas[3] = Double.parseDouble(notasStr[3]);

            //Uso de Loop While
            double somaDasNotas = 0.0;
            int i = 0;

            while (i < notas.length ){
                somaDasNotas = somaDasNotas + notas[i];
                i++;
            }

            double mediaFinal = somaDasNotas / notas.length;

            String mediaFinalStr = String.format("%.1f", mediaFinal);
            labelMedia.setText("Média Final: " + mediaFinalStr);

            String situacao;

            //SITUAÇÃO DO ALUNO
            if (mediaFinal >= 6){
                situacao = "Aprovado";
                labelSituacao.setText("Situação: " + situacao);
            } else if (mediaFinal <= 4) {
                situacao = "Reprovado";
                labelSituacao.setText("Situação: " + situacao);
            }else {
                situacao = "Recuperação";
                labelSituacao.setText("Situação: " + situacao);
            }
        });

        buttonLimpar.setOnAction( click ->{
            // Limpa os campos de texto das notas e do nome
            textFieldNome.setText("");
            textFieldNota1.setText("");
            textFieldNota2.setText("");
            textFieldNota3.setText("");
            textFieldNota4.setText("");

            textFieldNome.requestFocus();

            // Limpa os labels de resultado no painel inferior
            labelAluno.setText("Nome do Aluno:");
            labelMedia.setText("Média Final:");
            labelSituacao.setText("Situação:");
        });

        buttonSair.setOnAction( click ->{
            stage.close();
        });

    }
}
package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Media {
	public static void main() throws FileNotFoundException {
		Stage primaryStage = new Stage();
		VBox root = new VBox();
		Button bt1 = new Button("Add new media");
		bt1.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		Button bt2 = new Button("Delete media");
		bt2.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		Button bt3 = new Button("Update media's information");
		bt3.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		Button bt4 = new Button("Search media by code");
		bt4.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		Button bt5 = new Button("Print all media info");
		bt5.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		Button bt6 = new Button("Return to main page");
		bt6.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		root.setPrefWidth(400);
		root.setStyle("-fx-background-color: #3D59AB;");
		bt1.setMinWidth(root.getPrefWidth());
		bt2.setMinWidth(root.getPrefWidth());
		bt3.setMinWidth(root.getPrefWidth());
		bt4.setMinWidth(root.getPrefWidth());
		bt5.setMinWidth(root.getPrefWidth());
		bt6.setMinWidth(root.getPrefWidth());
		bt1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt4.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt5.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt6.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt1.setOnAction(e -> {
			try {
				AddM();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt2.setOnAction(e -> {
			try {
				delete();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt3.setOnAction(e -> {
			try {
				update();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt4.setOnAction(e -> {
			try {
				search();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt5.setOnAction(e -> {
			try {
				print();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt6.setOnAction(e -> {
			primaryStage.close();
		});
		ImageView view7 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\print.png")));
		view7.setFitHeight(45);
		view7.setFitWidth(45);
		ImageView view2 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\add.png")));
		view2.setFitHeight(45);
		view2.setFitWidth(45);
		ImageView view3 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\delete.png")));
		view3.setFitHeight(45);
		view3.setFitWidth(45);
		ImageView view4 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\update.png")));
		view4.setFitHeight(45);
		view4.setFitWidth(45);
		ImageView view5 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\search.png")));
		view5.setFitHeight(45);
		view5.setFitWidth(45);
		ImageView view6 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\home.png")));
		view6.setFitHeight(45);
		view6.setFitWidth(45);
		bt1.setGraphic(view2);
		bt2.setGraphic(view3);
		bt3.setGraphic(view4);
		bt4.setGraphic(view5);
		bt5.setGraphic(view7);
		bt6.setGraphic(view6);
		root.getChildren().addAll(bt1, bt2, bt3, bt4, bt5, bt6);
		root.setSpacing(20);
		root.setAlignment(Pos.CENTER);
		Image img1 = new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\media.png"));
		ImageView view1 = new ImageView(img1);
		view1.setFitHeight(250);
		view1.setFitWidth(250);
		Label l1 = new Label("Media's menu");
		l1.setTextFill(Color.BLACK);
		l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
		VBox root2 = new VBox();
		root2.setStyle("-fx-background-color: #3D59AB;");
		root2.getChildren().addAll(view1, l1);
		root2.setAlignment(Pos.CENTER);
		root2.setSpacing(10);
		FlowPane fp = new FlowPane();
		fp.setStyle("-fx-background-color: #3D59AB;");
		fp.getChildren().addAll(root, root2);
		fp.setAlignment(Pos.CENTER);
		fp.setHgap(20);
		Scene scene = new Scene(fp, 1000, 800);
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

	public static void AddM() throws FileNotFoundException {
		Stage primaryStage = new Stage();
		Label l1 = new Label("Media type");
		l1.setTextFill(Color.BLACK);
		Label l2 = new Label("Code");
		l2.setTextFill(Color.BLACK);
		Label l3 = new Label("Title");
		l3.setTextFill(Color.BLACK);
		Label l4 = new Label("Copies available");
		l4.setTextFill(Color.BLACK);
		Label l5 = new Label("......");
		l5.setTextFill(Color.BLACK);
		Label result = new Label();
		result.setTextFill(Color.BLACK);
		TextField txt1 = new TextField();
		TextField txt2 = new TextField();
		TextField txt3 = new TextField();
		TextField txt4 = new TextField();
		ComboBox<String> combo = new ComboBox<String>(FXCollections.observableArrayList("Game", "Movie", "Album"));
		GridPane root = new GridPane();
		root.setStyle("-fx-background-color: #3D59AB;");
		root.add(l1, 0, 0);
		root.add(combo, 1, 0);
		root.add(l2, 0, 1);
		root.add(l3, 0, 2);
		root.add(l4, 0, 3);
		root.add(l5, 0, 4);
		root.add(txt1, 1, 1);
		root.add(txt2, 1, 2);
		root.add(txt3, 1, 3);
		root.add(txt4, 1, 4);
		combo.setOnAction(e -> {
			if (combo.getValue().equals("Game")) {
				l5.setText("Weight");
			} else if (combo.getValue().equals("Movie")) {
				l5.setText("Rating");
			} else {
				l5.setText("Artist");
			}
		});
		ImageView view1 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\back.png")));
		view1.setFitHeight(45);
		view1.setFitWidth(45);
		ImageView view2 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\add.png")));
		view2.setFitHeight(45);
		view2.setFitWidth(45);
		Button bt1 = new Button("Add");
		bt1.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		bt1.setGraphic(view2);
		Button bt2 = new Button("Back");
		bt2.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		bt2.setGraphic(view1);
		VBox root2 = new VBox(result, root);
		root2.setStyle("-fx-background-color: #3D59AB;");
		root2.setSpacing(20);
		root2.setAlignment(Pos.CENTER);
		root2.setPrefSize(400, 50);
		root.setPrefSize(400, 50);
		txt1.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		txt2.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		txt3.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		txt4.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		result.setPrefSize(root2.getPrefWidth(), root2.getPrefHeight());
		combo.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		result.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt4.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt1.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		bt2.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		bt1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt1.setOnAction(e -> {
			if (txt1.getText() == "" || txt2.getText() == "" || txt3.getText() == "" || txt4.getText() == "") {
				result.setText("Error: You must fill all the required");
			} else {
				try {
					File m = new File("Media.txt");
					FileWriter filewriter = new FileWriter(m, true);
					BufferedWriter out = new BufferedWriter(filewriter);
					out.newLine();
					out.write(combo.getValue() + ";" + txt1.getText() + "; " + txt2.getText() + "; " + txt3.getText()
							+ ";" + txt4.getText());
					out.close();
					result.setText("Addition done successfully!");
				} catch (FileNotFoundException r) {
					System.out.println(r);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		bt2.setOnAction(e -> {
			primaryStage.close();
		});
		l1.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		l2.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		l3.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		l4.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		l5.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l4.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l5.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		root.add(bt1, 0, 5);
		root.add(bt2, 1, 5);
		root.setAlignment(Pos.CENTER);
		root.setHgap(20);
		root.setVgap(20);
		Scene scene = new Scene(root2, 1000, 800);
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

	public static void delete() throws FileNotFoundException {
		Stage primaryStage = new Stage();
		Label l1 = new Label("Media Code");
		l1.setTextFill(Color.BLACK);
		Label l2 = new Label("Media title ");
		l2.setTextFill(Color.BLACK);
		Label l3 = new Label("Media type");
		l3.setTextFill(Color.BLACK);
		Label l4 = new Label("Copies available");
		l4.setTextFill(Color.BLACK);
		Label l5 = new Label();
		l5.setTextFill(Color.BLACK);
		TextField txt1 = new TextField();
		Label txt2 = new Label();
		txt2.setTextFill(Color.BLACK);
		Label txt3 = new Label();
		txt3.setTextFill(Color.BLACK);
		Label txt4 = new Label();
		txt4.setTextFill(Color.BLACK);
		Label result = new Label();
		result.setTextFill(Color.BLACK);
		Rectangle rect1 = new Rectangle(400, 50);
		rect1.setFill(Color.TRANSPARENT);
		rect1.setStroke(Color.BLACK);
		rect1.setStrokeWidth(5);
		Rectangle rect2 = new Rectangle(400, 50);
		rect2.setFill(Color.TRANSPARENT);
		rect2.setStroke(Color.BLACK);
		rect2.setStrokeWidth(5);
		Rectangle rect3 = new Rectangle(400, 50);
		rect3.setFill(Color.TRANSPARENT);
		rect3.setStroke(Color.BLACK);
		rect3.setStrokeWidth(5);
		StackPane stack1 = new StackPane();
		stack1.setAlignment(Pos.CENTER);
		stack1.getChildren().addAll(rect1, txt2);
		StackPane stack2 = new StackPane();
		stack2.setAlignment(Pos.CENTER);
		stack2.getChildren().addAll(rect2, txt3);
		StackPane stack3 = new StackPane();
		stack3.setAlignment(Pos.CENTER);
		stack3.getChildren().addAll(rect3, txt4);
		ImageView view1 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\back.png")));
		view1.setFitHeight(45);
		view1.setFitWidth(45);
		ImageView view2 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\delete.png")));
		view2.setFitHeight(45);
		view2.setFitWidth(45);
		ImageView view5 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\search.png")));
		view5.setFitHeight(45);
		view5.setFitWidth(45);
		Button bt1 = new Button("Search");
		bt1.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		bt1.setGraphic(view5);
		Button bt2 = new Button("Remove");
		bt2.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		bt2.setGraphic(view2);
		Button bt3 = new Button("Back");
		bt3.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		bt3.setGraphic(view1);
		GridPane root = new GridPane();
		root.setStyle("-fx-background-color: #3D59AB;");
		HBox h = new HBox();
		h.setStyle("-fx-background-color: #3D59AB;");
		VBox root2 = new VBox(l5, result, root, h);
		root2.setStyle("-fx-background-color: #3D59AB;");
		h.setSpacing(20);
		h.setAlignment(Pos.CENTER);
		h.setPrefSize(200, 20);
		root2.setSpacing(20);
		root2.setAlignment(Pos.CENTER);
		root2.setPrefHeight(400);
		root2.setPrefWidth(50);
		root.setPrefWidth(400);
		root.setPrefHeight(50);
		txt1.setMinHeight(root.getPrefHeight());
		txt2.setMinHeight(root.getPrefHeight());
		txt3.setMinHeight(root.getPrefHeight());
		txt4.setMinHeight(root.getPrefHeight());
		result.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt4.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt1.setPrefSize(h.getPrefWidth(), h.getPrefHeight());
		bt2.setPrefSize(h.getPrefWidth(), h.getPrefHeight());
		bt3.setPrefSize(h.getPrefWidth(), h.getPrefHeight());
		bt1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt1.setMinWidth(root.getPrefWidth());
		txt2.setMinWidth(root.getPrefWidth());
		txt3.setMinWidth(root.getPrefWidth());
		txt4.setMinWidth(root.getPrefWidth());
		l1.setMinWidth(root.getPrefWidth());
		l2.setMinWidth(root.getPrefWidth());
		l3.setMinWidth(root.getPrefWidth());
		l4.setMinWidth(root.getPrefWidth());
		l5.setMinWidth(root2.getPrefWidth());
		l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l4.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l5.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt1.setOnAction(e -> {
			try {
				File m = new File("Media.txt");
				Scanner lines = new Scanner(m);
				while (lines.hasNext()) {
					String line = lines.nextLine();
					String[] tokens = line.split(";");
					tokens[1].strip();// for media code
					if (tokens[1].equals(txt1.getText())) {
						txt2.setText(tokens[2]);// to display Media's title
						txt3.setText(tokens[0]);// to display Media's type
						txt4.setText(tokens[3]);// to display Media's copies
						lines.close();
					}

				}

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt2.setOnAction(e -> {
			try {
				File m = new File("Media.txt");
				ArrayList<String> arr = new ArrayList<>();
				Scanner lines = new Scanner(m);
				PrintWriter out = new PrintWriter(m);
				while (lines.hasNext()) {
					String line = lines.nextLine();
					String[] tokens = line.split(";");
					tokens[1].strip();// for media code
					if (tokens[1].equals(txt1.getText())) {
						if (txt2.getText() == "" && txt3.getText() == "" && txt4.getText() == "") {// means that the
																									// media is not
																									// existed in the
																									// database
							result.setText("Media is not existed in the database");
						} else {
							while (lines.hasNext()) {
								String s = lines.nextLine();
								if (s != line) {
									arr.add(s);
								}
							}
							out.print("");
							Collections.sort(arr);
							out.println(arr);
							lines.close();
							out.close();
							result.setText("Removing is done successfully!");
						}
					}

				}

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt3.setOnAction(e -> {
			primaryStage.close();
		});
		root.add(l1, 0, 0);
		root.add(l2, 0, 1);
		root.add(l3, 0, 2);
		root.add(l4, 0, 3);
		root.add(txt1, 1, 0);
		root.add(stack1, 1, 1);
		root.add(stack2, 1, 2);
		root.add(stack3, 1, 3);
		h.getChildren().addAll(bt1, bt2, bt3);
		root.setAlignment(Pos.CENTER);
		root.setHgap(20);
		root.setVgap(20);
		Scene scene = new Scene(root2, 1000, 800);
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

	public static void update() throws FileNotFoundException {
		Stage primaryStage = new Stage();
		Label l1 = new Label("Media code");
		l1.setTextFill(Color.BLACK);
		Label l2 = new Label("Media title");
		l2.setTextFill(Color.BLACK);
		Label l3 = new Label("Media type");
		l3.setTextFill(Color.BLACK);
		Label l4 = new Label("Media copies available");
		l4.setTextFill(Color.BLACK);
		Label l5 = new Label("......");
		l5.setTextFill(Color.BLACK);// depends on media type
		Label l6 = new Label("Enter new title");
		l6.setTextFill(Color.BLACK);// for updating title
		Label l7 = new Label("Enter new copy number");
		l7.setTextFill(Color.BLACK);// for updating copies
		Label l8 = new Label("");// for updating ... depends on media type
		l8.setTextFill(Color.BLACK);
		TextField txt1 = new TextField();// for code
		TextField up1 = new TextField();// for title
		TextField up2 = new TextField();// for copies
		TextField up3 = new TextField();// for ....depends on media type
		Label txt2 = new Label();
		txt2.setTextFill(Color.BLACK);
		Label txt3 = new Label();
		txt3.setTextFill(Color.BLACK);
		Label txt4 = new Label();
		txt4.setTextFill(Color.BLACK);
		Label txt5 = new Label();
		txt5.setTextFill(Color.BLACK);
		Label result = new Label();
		result.setTextFill(Color.BLACK);
		ImageView view1 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\back.png")));
		view1.setFitHeight(45);
		view1.setFitWidth(45);
		ImageView view2 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\update.png")));
		view2.setFitHeight(45);
		view2.setFitWidth(45);
		ImageView view5 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\search.png")));
		view5.setFitHeight(45);
		view5.setFitWidth(45);
		Button bt1 = new Button("Search");
		bt1.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		bt1.setGraphic(view5);
		Button bt2 = new Button("Update");
		bt2.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		bt2.setGraphic(view2);
		Button bt3 = new Button("Back");
		bt3.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		bt3.setGraphic(view1);
		GridPane root = new GridPane();
		root.setStyle("-fx-background-color: #3D59AB;");
		HBox h = new HBox();
		h.setStyle("-fx-background-color: #3D59AB;");
		VBox root2 = new VBox(result, root, h);
		root2.setAlignment(Pos.CENTER);
		root2.setStyle("-fx-background-color: #3D59AB;");
		Rectangle rect1 = new Rectangle(400, 50);
		rect1.setFill(Color.TRANSPARENT);
		rect1.setStroke(Color.BLACK);
		rect1.setStrokeWidth(5);
		Rectangle rect2 = new Rectangle(400, 50);
		rect2.setFill(Color.TRANSPARENT);
		rect2.setStroke(Color.BLACK);
		rect2.setStrokeWidth(5);
		Rectangle rect3 = new Rectangle(400, 50);
		rect3.setFill(Color.TRANSPARENT);
		rect3.setStroke(Color.BLACK);
		rect3.setStrokeWidth(5);
		Rectangle rect4 = new Rectangle(400, 50);
		rect4.setFill(Color.TRANSPARENT);
		rect4.setStroke(Color.BLACK);
		rect4.setStrokeWidth(5);
		StackPane stack1 = new StackPane();
		stack1.setAlignment(Pos.CENTER);
		stack1.getChildren().addAll(rect1, txt2);
		StackPane stack2 = new StackPane();
		stack2.setAlignment(Pos.CENTER);
		stack2.getChildren().addAll(rect2, txt3);
		StackPane stack3 = new StackPane();
		stack3.setAlignment(Pos.CENTER);
		stack3.getChildren().addAll(rect3, txt4);
		StackPane stack4 = new StackPane();
		stack4.setAlignment(Pos.CENTER);
		stack4.getChildren().addAll(rect4, txt5);
		h.setSpacing(20);
		h.setAlignment(Pos.CENTER);
		h.setPrefSize(200, 20);
		root2.setSpacing(20);
		root2.setAlignment(Pos.CENTER);
		root2.setPrefHeight(400);
		root2.setPrefWidth(50);
		root.setPrefWidth(400);
		root.setPrefHeight(50);
		up1.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		up2.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		up3.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		txt1.setMinHeight(root.getPrefHeight());
		txt2.setMinHeight(root.getPrefHeight());
		txt3.setMinHeight(root.getPrefHeight());
		txt4.setMinHeight(root.getPrefHeight());
		up1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		up2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		up3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		result.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt4.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt5.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt1.setPrefSize(h.getPrefWidth(), h.getPrefHeight());
		bt2.setPrefSize(h.getPrefWidth(), h.getPrefHeight());
		bt3.setPrefSize(h.getPrefWidth(), h.getPrefHeight());
		bt1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt1.setMinWidth(root.getPrefWidth());
		txt2.setMinWidth(root.getPrefWidth());
		txt3.setMinWidth(root.getPrefWidth());
		txt4.setMinWidth(root.getPrefWidth());
		txt5.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		l1.setMinWidth(root.getPrefWidth());
		l2.setMinWidth(root.getPrefWidth());
		l3.setMinWidth(root.getPrefWidth());
		l4.setMinWidth(root.getPrefWidth());
		l5.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		l6.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		l7.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		l8.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l4.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l6.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l7.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l8.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l5.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt1.setOnAction(e -> {
			File m = new File("Media.txt");
			try {
				Scanner lines = new Scanner(m);
				while (lines.hasNext()) {
					String line = lines.nextLine();
					String[] tokens = line.split(";");
					tokens[1].strip();
					txt1.getText().strip();
					if (tokens[1].equals(txt1.getText())) {
						if (tokens[0].equals("Game")) {
							l5.setText("Weight");
						} else if (tokens[0].equals("Movie")) {
							l5.setText("Rating");
						} else {
							l5.setText("Artist");
						}
						txt2.setText(tokens[2]);// because their arrangement as I made it:
						txt3.setText(tokens[1]);// Type;code;title;copies;(depends on type)
						txt4.setText(tokens[3]);// 0 ; 1 ; 2 ; 3 ; 4
						txt5.setText(tokens[4]);
						lines.close();
					}
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt2.setOnAction(e -> {
			File m = new File("Media.txt");
			ArrayList<String> arr = new ArrayList<>();
			try {
				Scanner lines = new Scanner(m);
				PrintWriter out = new PrintWriter(m);
				while (lines.hasNext()) {
					String line = lines.nextLine();
					String[] tokens = line.split(";");
					tokens[1].strip();
					txt1.getText().strip();

					if (up1.getText() != "") {
						tokens[2] = up1.getText();
					}
					if (up2.getText() != "") {
						tokens[3] = up2.getText();
					}
					if (up3.getText() != "") {
						tokens[4] = up3.getText();
					}
					if (up1.getText() == "" && up2.getText() == "" && up3.getText() == "") {
						result.setText("You should enter data to update");
					}
					String upLine = tokens[0] + ";" + tokens[1] + ";" + tokens[2] + ";" + tokens[3] + ";" + tokens[4];
					while (lines.hasNext()) {
						String lin = lines.nextLine();
						if (lin != line) {
							arr.add(lin);
						}
					}
					out.print(" ");// to empty file
					arr.add(upLine);
					Collections.sort(arr);
					out.println(arr);
					out.close();
					lines.close();
					result.setText("Update is done successfully!");

				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt3.setOnAction(e -> {
			primaryStage.close();
		});
		root.add(l1, 0, 0);
		root.add(l2, 0, 1);
		root.add(l3, 0, 2);
		root.add(l4, 0, 3);
		root.add(l5, 0, 4);
		root.add(txt1, 1, 0);
		root.add(stack1, 1, 1);
		root.add(stack2, 1, 2);
		root.add(stack3, 1, 3);
		root.add(stack4, 1, 4);
		root.add(l6, 0, 5);
		root.add(l7, 0, 6);
		root.add(l8, 0, 7);
		root.add(up1, 1, 5);
		root.add(up2, 1, 6);
		root.add(up3, 1, 7);
		h.getChildren().addAll(bt1, bt2, bt3);
		root.setAlignment(Pos.CENTER);
		root.setHgap(20);
		root.setVgap(20);
		Scene scene = new Scene(root2, 1000, 800);
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();

	}

	public static void search() throws FileNotFoundException {
		Stage primaryStage = new Stage();
		Label l1 = new Label("Media code");
		l1.setTextFill(Color.BLACK);
		Label l2 = new Label("Media title");
		l2.setTextFill(Color.BLACK);
		Label l3 = new Label("Media type");
		l3.setTextFill(Color.BLACK);
		Label l4 = new Label("Media copies available");
		l4.setTextFill(Color.BLACK);
		Label l5 = new Label("");// depends on media type
		l5.setTextFill(Color.BLACK);
		TextField txt1 = new TextField();
		Label txt2 = new Label();
		txt2.setTextFill(Color.BLACK);
		Label txt3 = new Label();
		txt3.setTextFill(Color.BLACK);
		Label txt4 = new Label();
		txt4.setTextFill(Color.BLACK);
		Label txt5 = new Label();
		txt5.setTextFill(Color.BLACK);
		Label result = new Label();
		result.setTextFill(Color.BLACK);
		ImageView view1 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\back.png")));
		view1.setFitHeight(45);
		view1.setFitWidth(45);
		ImageView view5 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\search.png")));
		view5.setFitHeight(45);
		view5.setFitWidth(45);
		Button bt1 = new Button("Search");
		bt1.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		bt1.setGraphic(view5);
		Button bt2 = new Button("Back");
		bt2.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		bt2.setGraphic(view1);
		GridPane root = new GridPane();
		root.setStyle("-fx-background-color: #3D59AB;");
		HBox h = new HBox();
		h.setStyle("-fx-background-color: #3D59AB;");
		VBox root2 = new VBox(l5, result, root, h);
		root2.setStyle("-fx-background-color: #3D59AB;");
		h.setSpacing(20);
		h.setAlignment(Pos.CENTER);
		h.setPrefSize(200, 20);
		Rectangle rect1 = new Rectangle(400, 50);
		rect1.setFill(Color.TRANSPARENT);
		rect1.setStroke(Color.BLACK);
		rect1.setStrokeWidth(5);
		Rectangle rect2 = new Rectangle(400, 50);
		rect2.setFill(Color.TRANSPARENT);
		rect2.setStroke(Color.BLACK);
		rect2.setStrokeWidth(5);
		Rectangle rect3 = new Rectangle(400, 50);
		rect3.setFill(Color.TRANSPARENT);
		rect3.setStroke(Color.BLACK);
		rect3.setStrokeWidth(5);
		StackPane stack1 = new StackPane();
		stack1.setAlignment(Pos.CENTER);
		stack1.getChildren().addAll(rect1, txt2);
		StackPane stack2 = new StackPane();
		stack2.setAlignment(Pos.CENTER);
		stack2.getChildren().addAll(rect2, txt3);
		StackPane stack3 = new StackPane();
		stack3.setAlignment(Pos.CENTER);
		stack3.getChildren().addAll(rect3, txt4);
		root2.setSpacing(20);
		root2.setAlignment(Pos.CENTER);
		root2.setPrefHeight(400);
		root2.setPrefWidth(50);
		root.setPrefWidth(400);
		root.setPrefHeight(50);
		txt1.setMinHeight(root.getPrefHeight());
		txt2.setMinHeight(root.getPrefHeight());
		txt3.setMinHeight(root.getPrefHeight());
		txt4.setMinHeight(root.getPrefHeight());
		txt5.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		result.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt4.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt5.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt1.setPrefSize(h.getPrefWidth(), h.getPrefHeight());
		bt2.setPrefSize(h.getPrefWidth(), h.getPrefHeight());
		bt1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		txt1.setMinWidth(root.getPrefWidth());
		txt2.setMinWidth(root.getPrefWidth());
		txt3.setMinWidth(root.getPrefWidth());
		txt4.setMinWidth(root.getPrefWidth());
		l1.setMinWidth(root.getPrefWidth());
		l2.setMinWidth(root.getPrefWidth());
		l3.setMinWidth(root.getPrefWidth());
		l4.setMinWidth(root.getPrefWidth());
		l5.setMinWidth(root2.getPrefWidth());
		l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l4.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l5.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt1.setOnAction(e -> {
			File m = new File("Media.txt");
			txt1.getText().strip();
			try {
				Scanner lines = new Scanner(m);
				while (lines.hasNext()) {
					String line = lines.nextLine();
					String[] tokens = line.split(";");
					tokens[1].strip();
					if (tokens[1].equals(txt1.getText())) {
						if (tokens[0].equals("Game")) {
							l5.setText("Weight");
						} else if (tokens[0].equals("Movie")) {
							l5.setText("Rating");
						} else {
							l5.setText("Artist");
						}
						txt2.setText(tokens[2]);
						txt3.setText(tokens[0]);
						txt4.setText(tokens[3]);
						txt5.setText(tokens[4]);
						result.setText("Done!");
						lines.close();
					}
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt2.setOnAction(e -> {
			primaryStage.close();
		});
		root.add(l1, 0, 0);
		root.add(l2, 0, 1);
		root.add(l3, 0, 2);
		root.add(l4, 0, 3);
		root.add(l5, 0, 4);
		root.add(txt1, 1, 0);
		root.add(stack1, 1, 1);
		root.add(stack2, 1, 2);
		root.add(stack3, 1, 3);
		root.add(txt5, 1, 4);
		h.getChildren().addAll(bt1, bt2);
		root.setAlignment(Pos.CENTER);
		root.setHgap(20);
		root.setVgap(20);
		Scene scene = new Scene(root2, 1000, 800);
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

	public static void print() throws FileNotFoundException {
		ImageView view1 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\back.png")));
		view1.setFitHeight(45);
		view1.setFitWidth(45);
		VBox v = new VBox();
		v.setStyle("-fx-background-color: #3D59AB;");
		v.setPrefSize(400, 50);
		v.setAlignment(Pos.CENTER);
		Text l = new Text("Here's all media info:");
		Button back = new Button("Back");
		back.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		back.setGraphic(view1);
		Rectangle rect1 = new Rectangle(400, 400);
		rect1.setFill(Color.TRANSPARENT);
		rect1.setStroke(Color.BLACK);
		rect1.setStrokeWidth(5);
		VBox root = new VBox();
		l.setFill(Color.BLACK);
		l.setStroke(Color.BLACK);
		l.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
		l.setUnderline(true);
		back.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		File m = new File("Media.txt");
		ArrayList<String> media = new ArrayList<>();
		try {
			Scanner lines = new Scanner(m);
			while (lines.hasNext()) {
				String line = lines.nextLine();
				media.add(line);

			}
			lines.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Collections.sort(media);
		ArrayList<Node> texts = new ArrayList<>();
		for (int i = 0; i < media.size(); i++) {
			Text ll = new Text(media.get(i));
			ll.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 25));
			ll.setFill(Color.WHITE);
			texts.add(ll);
		}
		for (int i = 0; i < texts.size(); i++) {
			v.getChildren().addAll(texts.get(i));
		}
		StackPane stack1 = new StackPane();
		stack1.setAlignment(Pos.CENTER);
		stack1.getChildren().addAll(v, rect1);
		Stage primaryStage = new Stage();
		back.setOnAction(e -> {
			primaryStage.close();
		});
		root.getChildren().addAll(l, stack1, back);
		root.setStyle("-fx-background-color: #3D59AB;");
		root.setSpacing(20);
		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, 600, 600);
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}
}

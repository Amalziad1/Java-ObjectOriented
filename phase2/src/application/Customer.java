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

import javax.swing.ButtonGroup;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Customer {
	public static void main() throws FileNotFoundException {
		Stage primaryStage = new Stage();
		VBox root = new VBox();
		root.setStyle("-fx-background-color: #3D59AB;");
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
		Button bt1 = new Button("Add new customer");
		bt1.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		Button bt2 = new Button("Delete customer");
		bt2.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		Button bt3 = new Button("Update customer's information");
		bt3.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		Button bt4 = new Button("Search a customer by id");
		bt4.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		Button bt5 = new Button("Return to main page");
		bt5.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		bt1.setGraphic(view2);
		bt2.setGraphic(view3);
		bt3.setGraphic(view4);
		bt4.setGraphic(view5);
		bt5.setGraphic(view6);
		root.setPrefWidth(400);
		bt1.setMinWidth(root.getPrefWidth());
		bt2.setMinWidth(root.getPrefWidth());
		bt3.setMinWidth(root.getPrefWidth());
		bt4.setMinWidth(root.getPrefWidth());
		bt5.setMinWidth(root.getPrefWidth());
		bt1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt4.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt5.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt1.setOnAction(e -> {
			try {
				AddC();
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
			primaryStage.close();
		});
		root.getChildren().addAll(bt1, bt2, bt3, bt4, bt5);
		root.setSpacing(20);
		root.setAlignment(Pos.CENTER);
		Image img1 = new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\customer.png"));
		ImageView view1 = new ImageView(img1);
		view1.setFitHeight(250);
		view1.setFitWidth(250);
		Label l1 = new Label("Customer's menu");l1.setTextFill(Color.BLACK);
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

	public static void AddC() throws FileNotFoundException {
		ImageView view1 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\back.png")));
		view1.setFitHeight(45);
		view1.setFitWidth(45);
		ImageView view2 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\add.png")));
		view2.setFitHeight(45);
		view2.setFitWidth(45);
		Stage primaryStage = new Stage();
		Label l1 = new Label("Customer id");l1.setTextFill(Color.BLACK);
		Label l2 = new Label("Customer name");l2.setTextFill(Color.BLACK);
		Label l3 = new Label("Customer address");l3.setTextFill(Color.BLACK);
		Label l4 = new Label("Customer mobile");l4.setTextFill(Color.BLACK);
		TextField txt1 = new TextField();
		TextField txt2 = new TextField();
		TextField txt3 = new TextField();
		TextField txt4 = new TextField();
		Label result = new Label();
		Button bt1 = new Button("Add");
		bt1.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		bt1.setGraphic(view2);
		Button bt2 = new Button("Back");
		bt2.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		bt2.setGraphic(view1);
		GridPane root = new GridPane();
		root.setStyle("-fx-background-color: #3D59AB;");
		VBox root2 = new VBox(result, root);
		root2.setStyle("-fx-background-color: #3D59AB;");
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
		bt1.setMinWidth(root.getPrefWidth());
		bt2.setMinWidth(root.getPrefWidth());
		bt1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt1.setOnAction(e -> {
			if (txt1.getText() == "" || txt2.getText() == "" || txt3.getText() == "" || txt4.getText() == "") {
				result.setText("Error: You must fill all the required");
			} else {
				try {
					File c = new File("Customers.txt");
					Scanner in = new Scanner(c);
					while (in.hasNext()) {
						String line = in.nextLine();
						String[] tokens = line.split(";");
						tokens[0].split(" ");
						for (int i = 0; i < tokens.length; i++) {
							if (txt1.getText().equals(tokens[0])) {
								result.setText("Error: id is already exists");
							}
						}
					}
					FileWriter filewriter = new FileWriter(c, true);
					BufferedWriter out = new BufferedWriter(filewriter);
					out.newLine();
					out.write(txt1.getText() + "; " + txt2.getText() + "; " + txt3.getText() + ";" + txt4.getText());
					out.close();
					in.close();
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
		txt1.setMinWidth(root.getPrefWidth());
		txt2.setMinWidth(root.getPrefWidth());
		txt3.setMinWidth(root.getPrefWidth());
		txt4.setMinWidth(root.getPrefWidth());
		l1.setMinWidth(root.getPrefWidth());
		l2.setMinWidth(root.getPrefWidth());
		l3.setMinWidth(root.getPrefWidth());
		l4.setMinWidth(root.getPrefWidth());
		l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l4.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		root.add(l1, 0, 0);
		root.add(l2, 0, 1);
		root.add(l3, 0, 2);
		root.add(l4, 0, 3);
		root.add(txt1, 1, 0);
		root.add(txt2, 1, 1);
		root.add(txt3, 1, 2);
		root.add(txt4, 1, 3);
		root.add(bt1, 0, 4);
		root.add(bt2, 1, 4);
		root.setAlignment(Pos.CENTER);
		root.setHgap(20);
		root.setVgap(20);
		Scene scene = new Scene(root2, 1000, 800);
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

	public static void delete() throws FileNotFoundException {
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
		Stage primaryStage = new Stage();
		Label l1 = new Label("Customer id");l1.setTextFill(Color.BLACK);
		Label l2 = new Label("Customer name");l2.setTextFill(Color.BLACK);
		Label l3 = new Label("Customer address");l3.setTextFill(Color.BLACK);
		Label l4 = new Label("Customer mobile");l4.setTextFill(Color.BLACK);
		TextField txt1 = new TextField();
		Label txt2 = new Label();
		Label txt3 = new Label();
		Label txt4 = new Label();
		Label result = new Label();result.setTextFill(Color.BLACK);
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
		VBox root2 = new VBox( result, root, h);
		root2.setStyle("-fx-background-color: #3D59AB;");
		Rectangle rect1=new Rectangle(400,50);rect1.setFill(Color.TRANSPARENT);rect1.setStroke(Color.BLACK);rect1.setStrokeWidth(5);
		Rectangle rect2=new Rectangle(400,50);rect2.setFill(Color.TRANSPARENT);rect2.setStroke(Color.BLACK);rect2.setStrokeWidth(5);
		Rectangle rect3=new Rectangle(400,50);rect3.setFill(Color.TRANSPARENT);rect3.setStroke(Color.BLACK);rect3.setStrokeWidth(5);
		StackPane stack1=new StackPane();stack1.setAlignment(Pos.CENTER);stack1.getChildren().addAll(rect1,txt2);
		StackPane stack2=new StackPane();stack2.setAlignment(Pos.CENTER);stack2.getChildren().addAll(rect2,txt3);
		StackPane stack3=new StackPane();stack3.setAlignment(Pos.CENTER);stack3.getChildren().addAll(rect3,txt4);
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
		l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l4.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt1.setOnAction(e -> {
			try {
				File c = new File("Customers.txt");
				Scanner lines = new Scanner(c);
				while (lines.hasNext()) {
					String line = lines.nextLine();
					String[] tokens = line.split(";");
					if (tokens[0].equals(txt1.getText())) {
						txt2.setText(tokens[1]);// to display customer's name
						txt3.setText(tokens[2]);// to display customer's address
						txt4.setText(tokens[3]);// to display customer's mobile
						lines.close();
					}

				}

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt2.setOnAction(e2 -> {// if this is the wanted customer to delete then the button will work as
								// the following
			try {
				File c = new File("Customers.txt");
				ArrayList<String> arr = new ArrayList<>();
				Scanner lines = new Scanner(c);
				PrintWriter out = new PrintWriter(c);
				while (lines.hasNext()) {
					String line = lines.nextLine();
					String[] tokens = line.split(";");
					if (tokens[0].equals(txt1.getText())) {
						if (txt2.getText() != "" && txt3.getText() != "" && txt4.getText() != "") {// means that the
																									// customer is
																									// existed
							while (lines.hasNext()) {
								String up = lines.nextLine();
								if (up != line) {
									arr.add(up);
								}
							}
							out.print("");// to make the file empty
							Collections.sort(arr);
							out.println(arr);
							out.close();
							lines.close();
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
		h.setStyle("-fx-background-color: #3D59AB;");
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
		Stage primaryStage = new Stage();
		Label l1 = new Label("Customer id");l1.setTextFill(Color.BLACK);
		Label l2 = new Label("Customer name");l2.setTextFill(Color.BLACK);
		Label l3 = new Label("Customer address");l3.setTextFill(Color.BLACK);
		Label l4 = new Label("Customer mobile");l4.setTextFill(Color.BLACK);
		Label l6 = new Label("Enter new name");// for updating name
		l6.setTextFill(Color.BLACK);
		Label l7 = new Label("Enter new address");// for updating address
		l7.setTextFill(Color.BLACK);
		Label l8 = new Label("Enter new mobile");// for updating mobile
		l8.setTextFill(Color.BLACK);
		TextField txt1 = new TextField();
		TextField up1 = new TextField();// for name
		TextField up2 = new TextField();// for address
		TextField up3 = new TextField();// for mobile
		Label txt2 = new Label();
		Label txt3 = new Label();
		Label txt4 = new Label();
		Label result = new Label();
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
		root2.setStyle("-fx-background-color: #3D59AB;");
		Rectangle rect1=new Rectangle(400,50);rect1.setFill(Color.TRANSPARENT);rect1.setStroke(Color.BLACK);rect1.setStrokeWidth(5);
		Rectangle rect2=new Rectangle(400,50);rect2.setFill(Color.TRANSPARENT);rect2.setStroke(Color.BLACK);rect2.setStrokeWidth(5);
		Rectangle rect3=new Rectangle(400,50);rect3.setFill(Color.TRANSPARENT);rect3.setStroke(Color.BLACK);rect3.setStrokeWidth(5);
		StackPane stack1=new StackPane();stack1.setAlignment(Pos.CENTER);stack1.getChildren().addAll(rect1,txt2);
		StackPane stack2=new StackPane();stack2.setAlignment(Pos.CENTER);stack2.getChildren().addAll(rect2,txt3);
		StackPane stack3=new StackPane();stack3.setAlignment(Pos.CENTER);stack3.getChildren().addAll(rect3,txt4);
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

		bt1.setOnAction(e -> {
			File c = new File("Customers.txt");
			txt1.getText().strip();
			try {
				Scanner lines = new Scanner(c);
				while (lines.hasNext()) {
					String line = lines.nextLine();
					String[] tokens = line.split(";");
					tokens[0].strip();
					txt1.getText().strip();
					if (tokens[0].equals(txt1.getText())) {
						txt2.setText(tokens[1]);
						txt3.setText(tokens[2]);
						txt4.setText(tokens[3]);
						lines.close();
					}
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt2.setOnAction(e -> {
			File c = new File("Customers.txt");
			txt1.getText().strip();
			ArrayList<String> arr = new ArrayList<>();
			try {
				Scanner lines = new Scanner(c);
				PrintWriter out = new PrintWriter(c);
				while (lines.hasNext()) {
					String line = lines.nextLine();
					String[] tokens = line.split(";");
					tokens[0].strip();
					txt1.getText().strip();
					if (tokens[0].equals(txt1.getText())) {

						if (up1.getText() != "") {
							tokens[1] = up1.getText();
						}
						if (up2.getText() != "") {
							tokens[2] = up2.getText();
						}
						if (up3.getText() != "") {
							tokens[3] = up3.getText();
						}
						if (up1.getText() == "" && up2.getText() == "" && up3.getText() == "") {
							result.setText("You should enter data to update");
						}
						String upLine = tokens[0] + ";" + tokens[1] + ";" + tokens[2] + ";" + tokens[3];
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
		root.add(l6, 0, 4);
		root.add(l7, 0, 5);
		root.add(l8, 0, 6);
		root.add(up1, 1, 4);
		root.add(up2, 1, 5);
		root.add(up3, 1, 6);
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
		ImageView view1 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\back.png")));
		view1.setFitHeight(45);
		view1.setFitWidth(45);
		ImageView view5 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\search.png")));
		view5.setFitHeight(45);
		view5.setFitWidth(45);
		Stage primaryStage = new Stage();
		Label l1 = new Label("Customer id");l1.setTextFill(Color.BLACK);
		Label l2 = new Label("Customer name");l2.setTextFill(Color.BLACK);
		Label l3 = new Label("Customer address");l3.setTextFill(Color.BLACK);
		Label l4 = new Label("Customer mobile");l4.setTextFill(Color.BLACK);
		TextField txt1 = new TextField();
		Label txt2 = new Label();txt2.setTextFill(Color.WHITE);
		Label txt3 = new Label();txt3.setTextFill(Color.WHITE);
		Label txt4 = new Label();txt4.setTextFill(Color.WHITE);
		Label result = new Label();result.setTextFill(Color.BLACK);
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
		VBox root2 = new VBox(result, root, h);
		root2.setStyle("-fx-background-color: #3D59AB;");
		Rectangle rect1=new Rectangle(400,50);rect1.setFill(Color.TRANSPARENT);rect1.setStroke(Color.BLACK);rect1.setStrokeWidth(5);
		Rectangle rect2=new Rectangle(400,50);rect2.setFill(Color.TRANSPARENT);rect2.setStroke(Color.BLACK);rect2.setStrokeWidth(5);
		Rectangle rect3=new Rectangle(400,50);rect3.setFill(Color.TRANSPARENT);rect3.setStroke(Color.BLACK);rect3.setStrokeWidth(5);
		StackPane stack1=new StackPane();stack1.setAlignment(Pos.CENTER);stack1.getChildren().addAll(rect1,txt2);
		StackPane stack2=new StackPane();stack2.setAlignment(Pos.CENTER);stack2.getChildren().addAll(rect2,txt3);
		StackPane stack3=new StackPane();stack3.setAlignment(Pos.CENTER);stack3.getChildren().addAll(rect3,txt4);
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
		l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l4.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt1.setOnAction(e -> {
			File c = new File("Customers.txt");
			txt1.getText().strip();
			try {
				Scanner lines = new Scanner(c);
				while (lines.hasNext()) {
					String line = lines.nextLine();
					String[] tokens = line.split(";");
					tokens[0].strip();
					if (tokens[0].equals(txt1.getText())) {
						txt2.setText(tokens[1]);
						txt3.setText(tokens[2]);
						txt4.setText(tokens[3]);
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
		root.add(txt1, 1, 0);
		root.add(stack1, 1, 1);
		root.add(stack2, 1, 2);
		root.add(stack3, 1, 3);
		h.getChildren().addAll(bt1, bt2);
		root.setAlignment(Pos.CENTER);
		root.setHgap(20);
		root.setVgap(20);
		Scene scene = new Scene(root2, 1000, 800);
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}
}

package application;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javafx.stage.Stage;
import javafx.stage.FileChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;

public class Rent {
	public static void main() throws FileNotFoundException {
		Stage primaryStage = new Stage();
		VBox root = new VBox();
		Button bt1 = new Button("Rent media");
		bt1.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		Button bt2 = new Button("My wish list");
		bt2.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		Button bt3 = new Button("My rented media");
		bt3.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		Button bt4 = new Button("Return media");
		bt4.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		Button bt6 = new Button("Return to main page");
		bt6.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		root.setPrefWidth(400);
		root.setStyle("-fx-background-color: #3D59AB;");
		bt1.setMinWidth(root.getPrefWidth());
		bt2.setMinWidth(root.getPrefWidth());
		bt3.setMinWidth(root.getPrefWidth());
		bt4.setMinWidth(root.getPrefWidth());
		bt6.setMinWidth(root.getPrefWidth());
		bt1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt4.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt6.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt1.setOnAction(e -> {
			try {
				renting();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt2.setOnAction(e -> {
			try {
				wishList();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt3.setOnAction(e -> {
			try {
				rentedMedia();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt4.setOnAction(e -> {
			try {
				Return();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt6.setOnAction(e -> {
			primaryStage.close();
		});
		ImageView view2 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\rent.png")));
		view2.setFitHeight(45);
		view2.setFitWidth(45);
		ImageView view3 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\wish.png")));
		view3.setFitHeight(45);
		view3.setFitWidth(45);
		ImageView view4 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\rentedm.png")));
		view4.setFitHeight(45);
		view4.setFitWidth(45);
		ImageView view5 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\returning.png")));
		view5.setFitHeight(45);
		view5.setFitWidth(45);
		bt1.setGraphic(view2);
		bt2.setGraphic(view3);
		bt3.setGraphic(view4);
		bt4.setGraphic(view5);
		ImageView view6 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\home.png")));
		view6.setFitHeight(45);
		view6.setFitWidth(45);
		bt6.setGraphic(view6);
		root.getChildren().addAll(bt1, bt2, bt3, bt4, bt6);
		root.setSpacing(20);
		root.setAlignment(Pos.CENTER);
		Image img1 = new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\cart.png"));
		ImageView view1 = new ImageView(img1);
		view1.setFitHeight(250);
		view1.setFitWidth(250);
		Label l1 = new Label("Renting menu");
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

	public static void renting() throws FileNotFoundException {
		ImageView view1 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\back.png")));
		view1.setFitHeight(45);
		view1.setFitWidth(45);
		ImageView view2 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\addtocart.png")));
		view2.setFitHeight(45);
		view2.setFitWidth(45);
		ImageView view3 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\process.png")));
		view3.setFitHeight(45);
		view3.setFitWidth(45);
		ImageView view4 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\search.png")));
		view4.setFitHeight(45);
		view4.setFitWidth(45);
		Stage primary = new Stage();
		primary.setTitle("Renting");
		Label l1 = new Label("Customer Id");
		l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		Label l2 = new Label("Media Code");
		l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));

		Label l4 = new Label();// for result..
		l4.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		Button bt1 = new Button("Add to Cart");
		bt1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		Button bt2 = new Button("Process");
		bt2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		Button bt3 = new Button("Back");
		bt3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		Button bt4 = new Button("Search");
		bt4.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l1.setTextFill(Color.BLACK);
		l2.setTextFill(Color.BLACK);
		l4.setTextFill(Color.BLACK);
		bt1.setTextFill(Color.BLACK);
		bt2.setTextFill(Color.BLACK);
		bt3.setTextFill(Color.BLACK);
		bt4.setTextFill(Color.BLACK);
		TextField txt1 = new TextField();
		txt1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		TextField txt2 = new TextField();
		txt2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		Text t1 = new Text();
		t1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		Text t2 = new Text();
		t2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		t1.setFill(Color.WHITE);
		t2.setFill(Color.WHITE);
		t1.setStroke(Color.BLACK);
		GridPane v1 = new GridPane();
		Rectangle rect = new Rectangle(500, 200);
		rect.setStroke(Color.BLACK);
		rect.setSmooth(true);
		rect.setStrokeWidth(5);
		rect.setFill(Color.TRANSPARENT);
		StackPane stack = new StackPane();
		stack.getChildren().addAll(rect, t1);
		Rectangle rect2 = new Rectangle(500, 200);
		rect2.setStroke(Color.BLACK);
		rect2.setSmooth(true);
		rect2.setStrokeWidth(5);
		rect2.setFill(Color.TRANSPARENT);
		StackPane stack2 = new StackPane();
		stack2.getChildren().addAll(rect2, t1);
		v1.setPrefSize(400, 50);
		v1.setHgap(10);
		v1.setVgap(20);
		v1.setAlignment(Pos.CENTER);
		v1.add(l1, 0, 0);
		v1.add(l2, 0, 2);
		v1.add(txt1, 1, 0);
		v1.add(stack, 1, 1);
		v1.add(txt2, 1, 2);
		v1.add(stack2, 1, 4);
		bt1.setGraphic(view2);
		bt2.setGraphic(view3);
		bt3.setGraphic(view1);
		bt4.setGraphic(view4);
		bt1.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		bt2.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		bt3.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		bt4.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		HBox v2 = new HBox();
		v2.setPrefSize(200, 50);
		v2.setSpacing(20);
		v2.setAlignment(Pos.CENTER);
		v2.getChildren().addAll(bt4, bt1, bt2, bt3);
		l1.setMaxWidth(v1.getPrefWidth());
		l2.setMaxWidth(v1.getPrefWidth());
		l4.setMaxWidth(v1.getPrefWidth());
		bt1.setMaxWidth(v1.getPrefWidth());
		bt2.setMaxWidth(v1.getPrefWidth());
		bt3.setMaxWidth(v1.getPrefWidth());
		bt4.setMaxWidth(v1.getPrefWidth());
		l1.setMaxHeight(v1.getPrefHeight());
		l2.setMaxHeight(v1.getPrefHeight());
		l4.setMaxHeight(v1.getPrefHeight());
		bt1.setMaxHeight(v2.getPrefHeight());
		bt2.setMaxHeight(v2.getPrefHeight());
		bt3.setMaxHeight(v2.getPrefHeight());
		bt4.setMaxHeight(v2.getPrefHeight());
		VBox vv = new VBox();
		vv.getChildren().addAll(l4, v1, v2);
		vv.setAlignment(Pos.CENTER);
		vv.setSpacing(20);
		Scene scene = new Scene(vv, 900, 900);
		v1.setStyle("-fx-background-color: #3D59AB;");
		v2.setStyle("-fx-background-color: #3D59AB;");
		vv.setStyle("-fx-background-color: #3D59AB;");
		bt4.setOnAction(e -> {
			if (txt1.getText() != "") {
				File c = new File("Customers.txt");
				try {
					Scanner c1 = new Scanner(c);
					while (c1.hasNext()) {
						String line = c1.nextLine();
						String[] tokens = line.split(";");
						txt1.getText().strip();
						tokens[0].strip();
						if (tokens[0].equals(txt1.getText())) {
							t1.setText(line);
							c1.close();
						}
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
			if (txt2.getText() != "") {
				File m = new File("Media.txt");
				try {
					Scanner m1 = new Scanner(m);
					while (m1.hasNext()) {
						String line = m1.nextLine();
						String[] tokens = line.split(";");
						txt2.getText().strip();
						tokens[1].strip();// for media code
						if (tokens[1].equals(txt2.getText())) {
							t2.setText(line);
							m1.close();
						}
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
			if (txt1.getText() == "" && txt2.getText() == "") {
				l4.setText("You should enter data to search for");
			}
		});
		bt1.setOnAction(e -> {
			try {
				File c = new File("Cart.txt");
				Scanner cart = new Scanner(c);
				PrintWriter out = new PrintWriter(c);
				FileWriter filewriter = new FileWriter(c, true);
				BufferedWriter out2 = new BufferedWriter(filewriter);
				String[] media = t2.getText().split(";");
				if (txt2.getText() != "") {// means that the media is existed
					outerloop: while (true) {
						while (cart.hasNext()) {
							String line = cart.nextLine();
							String[] tokens = line.split("@");
							txt1.getText().strip();// for easier comparing
							tokens[0].strip();// where is customer's id
							if (tokens[0].equals(txt1.getText())) {
								ArrayList<String> updated = new ArrayList<>();
								while (cart.hasNext()) {
									String line2 = cart.nextLine();
									if (line2 != line) {
										updated.add(line);
									}
								}
								out.print("");
								line = line + "@" + txt2.getText() + ":" + media[2];// adding media's code and title to
																					// customer's cart
								updated.add(line);
								Collections.sort(updated);
								out.println(updated);
								out.close();
								cart.close();
								break outerloop;
							}
						}
						out2.newLine();
						out2.write(txt1.getText() + "@" + txt2.getText() + ":" + media[2]);
						out2.close();
					}
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		bt2.setOnAction(e -> {
			try {
				Process();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt3.setOnAction(e -> {
			primary.close();
		});
		primary.setScene(scene);
		primary.setMaximized(true);
		primary.show();
	}

	public static void Process() throws FileNotFoundException {
		Stage primary = new Stage();
		Label l1 = new Label("Enter customer's id");
		Label l2 = new Label("Cart info");
		Label l3 = new Label("Enter (media code:title)");
		Label l4 = new Label("Select one:");
		Label l5 = new Label("Date");
		Text t1 = new Text();
		l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l1.setTextFill(Color.BLACK);
		l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l2.setTextFill(Color.BLACK);
		l3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l3.setTextFill(Color.BLACK);
		l4.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l4.setTextFill(Color.BLACK);
		l5.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l5.setTextFill(Color.BLACK);
		RadioButton op1 = new RadioButton("Add media to wish list");
		op1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		op1.setTextFill(Color.WHITE);
		RadioButton op2 = new RadioButton("Rent media");
		op2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		op2.setTextFill(Color.WHITE);
		Button bt1 = new Button("Ok");
		bt1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		Button bt2 = new Button("Back");
		bt2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		Button bt3 = new Button("Search cart");
		bt3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt1.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");bt2.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		bt3.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		ImageView view5 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\search.png")));
		view5.setFitHeight(45);
		view5.setFitWidth(45);
		bt3.setGraphic(view5);
		ImageView view4 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\ok.png")));
		view4.setFitHeight(45);
		view4.setFitWidth(45);
		bt1.setGraphic(view4);
		ImageView view1 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\back.png")));
		view1.setFitHeight(45);
		view1.setFitWidth(45);
		bt2.setGraphic(view1);
		Rectangle rect1 = new Rectangle(500, 200);
		rect1.setFill(Color.TRANSPARENT);
		rect1.setStroke(Color.BLACK);
		rect1.setStrokeWidth(5);
		Rectangle rect2 = new Rectangle(500, 200);
		rect2.setFill(Color.TRANSPARENT);
		rect2.setStroke(Color.BLACK);
		rect2.setStrokeWidth(5);
		Label result = new Label();
		result.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		TextField txt1 = new TextField();
		txt1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		TextField txt2 = new TextField();
		txt2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		TextField txt3 = new TextField();
		txt3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		txt3.setText(dtf.format(now));
		StackPane stack1 = new StackPane();
		stack1.getChildren().addAll(rect1, t1);
		GridPane root = new GridPane();
		root.setPrefSize(400, 50);
		root.setAlignment(Pos.CENTER);
		root.setVgap(20);
		root.add(l1, 0, 0);
		root.add(txt1, 1, 0);
		l1.setPrefSize(250, root.getPrefHeight());
		txt1.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		root.add(l2, 0, 1);
		root.add(stack1, 1, 1);
		l2.setPrefSize(200, root.getPrefHeight());
		root.add(l3, 0, 2);
		root.add(txt2, 1, 2);
		l3.setPrefSize(300, root.getPrefHeight());
		txt2.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		root.add(l4, 0, 3);
		root.add(op1, 1, 3);
		l4.setPrefSize(200, root.getPrefHeight());
		op1.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		root.add(op2, 1, 4);
		op2.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		root.add(l5, 0, 5);
		root.add(txt3, 1, 5);
		l5.setPrefSize(200, root.getPrefHeight());
		txt3.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		HBox h = new HBox();
		h.setAlignment(Pos.CENTER);
		h.setPrefSize(200, 50);
		h.getChildren().addAll(bt3, bt1, bt2);h.setSpacing(20);
		VBox v = new VBox();
		v.setAlignment(Pos.CENTER);
		v.setSpacing(20);
		v.getChildren().addAll(result, root, h);
		root.setStyle("-fx-background-color: #3D59AB;");
		h.setStyle("-fx-background-color: #3D59AB;");
		v.setStyle("-fx-background-color: #3D59AB;");
		bt3.setOnAction(e -> {
			File c = new File("Cart.txt");
			try {
				Scanner cart = new Scanner(c);
				while (cart.hasNext()) {
					String line = cart.nextLine();
					String[] tokens = line.split("@");
					tokens[0].strip();
					txt1.getText().strip();
					if (tokens[0].equals(txt1.getText())) {
						String disp = "";
						for (int i = 1; i < tokens.length; i++) {// without customer's id
							disp = disp + tokens[i] + ",";
						}
						t1.setText(disp);
						cart.close();
					}
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt1.setOnAction(e -> {
			File w = new File("wishList.txt");
			File r = new File("Rented.txt");
			File m = new File("Media.txt");
			try {
				Scanner rent = new Scanner(r);
				Scanner wish = new Scanner(w);
				Scanner media = new Scanner(m);
				if (t1.getText() != "") {
					if (op1.isSelected()) {// op1 for add to wishList

						PrintWriter out = new PrintWriter(w);
						FileWriter filewriter = new FileWriter(w, true);
						BufferedWriter out2 = new BufferedWriter(filewriter);
						outerloop: while (true) {
							while (wish.hasNext()) {
								String line = wish.nextLine();
								String[] tokens = line.split("@");
								tokens[0].strip();
								txt1.getText().strip();
								if (tokens[0].equals(txt1.getText())) {
									ArrayList<String> updated = new ArrayList<>();
									while (wish.hasNext()) {
										String temp = wish.nextLine();
										if (temp != line) {
											updated.add(temp);
										}
									}
									String up = "";
									for (int i = 0; i < tokens.length; i++) {
										up = up + txt2.getText() + "@";
									}
									updated.add(up);
									Collections.sort(updated);
									out.print("");
									out.println(updated);
									out.close();
									result.setText("Added to your wish list!");
									break outerloop;
								}
							}
							out2.newLine();
							out2.write(txt1.getText() + "@" + txt2.getText());
							out2.close();
							result.setText("Added to your wish list!");
							break;
						}

					} else if (op2.isSelected()) {
						PrintWriter out = new PrintWriter(r);
						PrintWriter outmedia = new PrintWriter(m);
						FileWriter filewriter = new FileWriter(r, true);
						BufferedWriter out2 = new BufferedWriter(filewriter);
						outerloop: while (true) {
							while (rent.hasNext()) {// in rented file: customer id&rented media1 code:rent date&rented
													// media2 code:rent date&...
								String line = rent.nextLine();
								String[] tokens = line.split("&");
								tokens[0].strip();
								txt1.getText().strip();
								if (tokens[0].equals(txt1.getText())) {
									String[] code = txt2.getText().split(":");
									code[0].strip();
									while (media.hasNext()) {
										String mm = media.nextLine();
										String[] lm = mm.split(";");
										int num = Integer.parseInt(lm[3]);
										num = num - 1;
										lm[3] = String.valueOf(num);
										String str = "";
										for (int i = 0; i < lm.length; i++) {
											str = str + lm[i] + ";";
										}
										ArrayList<String> updated = new ArrayList<>();
										while (media.hasNext()) {
											String temp = media.nextLine();
											if (temp != mm) {
												updated.add(temp);
											}
										}
										updated.add(str);
										outmedia.print("");
										outmedia.println(updated);
										outmedia.close();
									}
									ArrayList<String> updated = new ArrayList<>();
									while (rent.hasNext()) {
										String temp = rent.nextLine();
										if (temp != line) {
											updated.add(temp);
										}
									}
									String upLine = line + "&" + txt2.getText() + ":" + txt3.getText();
									updated.add(upLine);
									out.print("");
									out.println(updated);
									out2.close();
									out.close();
									result.setText("Renting is done!");
									break outerloop;
								}
							} // it won't reach this point if their id is existed in rent file
							String line = txt1.getText() + "&" + txt2.getText() + ":" + txt3.getText();
							out2.newLine();
							out2.write(line);
							out2.close();
							out.close();
							result.setText("Renting is done!");
							break;
						}
					} else {
						result.setText("You must choose only one option");
					}
				} else {
					result.setText("Your cart is empty");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		bt2.setOnAction(e -> {
			primary.close();
		});
		Scene scene = new Scene(v, 200, 200);
		primary.setScene(scene);
		primary.setMaximized(true);
		primary.show();

	}

	public static void wishList() throws FileNotFoundException {
		Stage primary = new Stage();
		Label l1 = new Label("Enter customer's id");
		l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l1.setTextFill(Color.BLACK);
		Label l2 = new Label("Your wish list");
		l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l2.setTextFill(Color.BLACK);
		Text t1 = new Text();
		t1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		t1.setFill(Color.WHITE);
		TextField txt = new TextField();
		txt.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		Button search = new Button("Search");
		search.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		search.setTextFill(Color.BLACK);
		Button back = new Button("Back");
		back.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		back.setTextFill(Color.BLACK);
		Rectangle rect = new Rectangle(500, 200);
		rect.setFill(Color.TRANSPARENT);
		rect.setStroke(Color.BLACK);
		rect.setStrokeWidth(5);
		StackPane stack = new StackPane();
		stack.setAlignment(Pos.CENTER);
		stack.getChildren().addAll(t1, rect);
		GridPane grid = new GridPane();
		grid.setVgap(20);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(20);
		grid.setPrefSize(400, 50);
		grid.add(l1, 0, 0);
		grid.add(txt, 1, 0);
		grid.add(l2, 0, 1);
		grid.add(stack, 1, 1);
		grid.add(search, 0, 2);
		grid.add(back, 1, 2);
		stack.setStyle("-fx-background-color: #3D59AB;");
		grid.setStyle("-fx-background-color: #3D59AB;");
		search.setOnAction(e -> {
			File w = new File("wishList.txt");
			try {
				Scanner wish = new Scanner(w);
				while (wish.hasNext()) {
					String line = wish.nextLine();
					String[] tokens = line.split("@");
					tokens[0].strip();
					txt.getText().strip();
					if (tokens[0].equals(txt.getText())) {
						t1.setText(line);
						wish.close();
					}
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		back.setOnAction(e -> {
			primary.close();
		});
		ImageView view1 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\back.png")));
		view1.setFitHeight(45);
		view1.setFitWidth(45);
		ImageView view5 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\search.png")));
		view5.setFitHeight(45);
		view5.setFitWidth(45);
		search.setGraphic(view5);
		back.setGraphic(view1);
		search.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		back.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		Scene scene = new Scene(grid);
		primary.setScene(scene);
		primary.setMaximized(true);
		primary.show();
	}

	public static void rentedMedia() throws FileNotFoundException {
		Stage primary = new Stage();
		Label l1 = new Label("Enter customer's id");
		l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l1.setTextFill(Color.BLACK);
		Label l2 = new Label("Your Rented list");
		l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l2.setTextFill(Color.BLACK);
		Text t1 = new Text();
		t1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		t1.setFill(Color.WHITE);
		TextField txt = new TextField();
		txt.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		Button search = new Button("Search");
		search.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		search.setTextFill(Color.BLACK);
		Button back = new Button("Back");
		back.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		back.setTextFill(Color.BLACK);
		Rectangle rect = new Rectangle(500, 200);
		rect.setFill(Color.TRANSPARENT);
		rect.setStroke(Color.BLACK);
		rect.setStrokeWidth(5);
		StackPane stack = new StackPane();
		stack.setAlignment(Pos.CENTER);
		stack.getChildren().addAll(t1, rect);
		GridPane grid = new GridPane();
		grid.setVgap(20);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(20);
		grid.setPrefSize(400, 50);
		grid.add(l1, 0, 0);
		grid.add(txt, 1, 0);
		grid.add(l2, 0, 1);
		grid.add(stack, 1, 1);
		grid.add(search, 0, 2);
		grid.add(back, 1, 2);
		stack.setStyle("-fx-background-color: #3D59AB;");
		grid.setStyle("-fx-background-color: #3D59AB;");
		search.setOnAction(e -> {
			File r = new File("Rented.txt");
			try {
				Scanner rent = new Scanner(r);
				while (rent.hasNext()) {
					String line = rent.nextLine();
					String[] tokens = line.split("@");
					tokens[0].strip();
					txt.getText().strip();
					if (tokens[0].equals(txt.getText())) {
						t1.setText(line);
						rent.close();
					}
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		back.setOnAction(e -> {
			primary.close();
		});
		ImageView view1 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\back.png")));
		view1.setFitHeight(45);
		view1.setFitWidth(45);
		ImageView view5 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\search.png")));
		view5.setFitHeight(45);
		view5.setFitWidth(45);
		search.setGraphic(view5);
		back.setGraphic(view1);
		search.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		back.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		Scene scene = new Scene(grid);
		primary.setScene(scene);
		primary.setMaximized(true);
		primary.show();
	}

	public static void Return() throws FileNotFoundException {
		Stage primary = new Stage();
		Label l1 = new Label("Enter customer's id");
		l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l1.setTextFill(Color.BLACK);
		Label l2 = new Label("Your Rented list");
		l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l2.setTextFill(Color.BLACK);
		Label l3 = new Label("Enter returned media code");
		l3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		l3.setTextFill(Color.BLACK);
		Label result = new Label();
		result.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		result.setTextFill(Color.BLACK);
		Text t1 = new Text();
		t1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		t1.setFill(Color.WHITE);
		TextField txt = new TextField();
		txt.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		TextField txt1 = new TextField();
		txt1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		Button search = new Button("Search");
		search.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		search.setTextFill(Color.BLACK);
		Button r = new Button("Return");
		r.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		r.setTextFill(Color.BLACK);
		Button back = new Button("Back");
		back.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		back.setTextFill(Color.BLACK);
		Rectangle rect = new Rectangle(500, 200);
		rect.setFill(Color.TRANSPARENT);
		rect.setStroke(Color.BLACK);
		rect.setStrokeWidth(5);
		StackPane stack = new StackPane();
		stack.setAlignment(Pos.CENTER);
		stack.getChildren().addAll(t1, rect);
		GridPane grid = new GridPane();
		grid.setVgap(20);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(20);
		grid.setPrefSize(400, 50);
		grid.add(l1, 0, 0);
		grid.add(txt, 1, 0);
		grid.add(l2, 0, 1);
		grid.add(stack, 1, 1);
		grid.add(l3, 0, 2);
		grid.add(txt1, 1, 2);
		HBox h = new HBox();
		h.setSpacing(20);
		h.getChildren().addAll(search, r, back);
		h.setAlignment(Pos.CENTER);
		h.setStyle("-fx-background-color: #3D59AB;");
		stack.setStyle("-fx-background-color: #3D59AB;");
		grid.setStyle("-fx-background-color: #3D59AB;");
		VBox root = new VBox();
		root.setStyle("-fx-background-color: #3D59AB;");
		root.getChildren().addAll(result, grid, h);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);
		search.setOnAction(e -> {
			File ren = new File("Rented.txt");
			try {
				Scanner rent = new Scanner(ren);
				while (rent.hasNext()) {
					String line = rent.nextLine();
					String[] tokens = line.split("@");
					tokens[0].strip();
					txt.getText().strip();
					if (tokens[0].equals(txt.getText())) {
						t1.setText(line);
						rent.close();
					}
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		r.setOnAction(e -> {
			File ren = new File("Rented.txt");
			File m = new File("Media.txt");
			try {
				Scanner rent = new Scanner(ren);
				Scanner media = new Scanner(m);
				PrintWriter outr = new PrintWriter(ren);
				PrintWriter outm = new PrintWriter(m);
				outerloop: while (true) {
					while (rent.hasNext()) {
						String line = rent.nextLine();
						String[] tokens = line.split("@");
						tokens[0].strip();
						txt.getText().strip();
						if (tokens[0].equals(txt.getText())) {
							for(int i=0;i<tokens.length;i++) {
								String[] code=tokens[i].split(":");//code[0] for code and code[1] for title
								code[0].strip();//removing spaces for both code in rented file and the entered code
								txt1.getText().strip();
								if(code[0].equals(txt1.getText())) {
									while(media.hasNext()) {
										String temp0=media.nextLine();
										String[] temp=temp0.split(";");
										temp[1].strip();//which is for media code
										if(temp[1].equals(txt1.getText())) {
											int num=Integer.parseInt(temp[3]);//which id for copies number
											num=num+1;
											temp[3]=String.valueOf(num);
											String upM="";
											for(int k=0;k<temp.length;k++) {
												upM=upM+temp[k]+";";
											}
											ArrayList<String> med=new ArrayList<>();
											med.add(upM);
											while(media.hasNext()) {
												String lines=media.nextLine();
												if(temp0 != lines) {
													med.add(lines);
												}
											}
											outm.print("");
											Collections.sort(med);
											outm.println(med);
											outm.close();
										}
									}
									String upLine="";
									for(int j=0;j<tokens.length;j++) {
										if(tokens[j] != tokens[i]) {
											upLine=upLine+tokens[j];
										}
									}
									ArrayList<String> updated=new ArrayList<>();
									updated.add(upLine);
									while(rent.hasNext()) {
										String lines=rent.nextLine();
										if(line != lines) {
											updated.add(lines);
										}
									}
									outr.print("");
									outr.println(updated);
									outr.close();
									result.setText("Returning is done!");
									break outerloop;
								}
							}
						}
					}
					result.setText("You have not rent media yet");
					outr.close();
					outm.close();
					rent.close();
					media.close();
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		back.setOnAction(e -> {
			primary.close();
		});
		ImageView view1 = new ImageView(new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\back.png")));
		view1.setFitHeight(45);
		view1.setFitWidth(45);
		ImageView view5 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\search.png")));
		view5.setFitHeight(45);
		view5.setFitWidth(45);
		search.setGraphic(view5);
		back.setGraphic(view1);
		search.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");r.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		back.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		ImageView view2 = new ImageView(
				new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\returning.png")));
		view2.setFitHeight(45);
		view2.setFitWidth(45);
		r.setGraphic(view2);
		Scene scene = new Scene(root);
		primary.setScene(scene);
		primary.setMaximized(true);
		primary.show();
	}

}

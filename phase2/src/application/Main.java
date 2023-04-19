package application;

import javafx.stage.FileChooser;

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

public class Main extends Application {

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Media Rental Manager");
		Image img1 = new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\customer.png"));
		ImageView view1 = new ImageView(img1);
		view1.setFitHeight(75);
		view1.setFitWidth(75);
		Image img2 = new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\media.png"));
		ImageView view2 = new ImageView(img2);
		view2.setFitHeight(75);
		view2.setFitWidth(75);
		Image img3 = new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\cart.png"));
		ImageView view3 = new ImageView(img3);
		view3.setFitHeight(75);
		view3.setFitWidth(75);
		Image img4 = new Image(new FileInputStream("C:\\Users\\Administrator\\Desktop\\view.jpg"));
		ImageView view4 = new ImageView(img4);
		view4.setFitHeight(350);
		view4.setFitWidth(350);
		Button bt1 = new Button("Customer");
		bt1.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		Button bt2 = new Button("Media");
		bt2.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		Button bt3 = new Button("Rent");
		bt3.setStyle("-fx-background-color: #BCD2EE;-fx-text-fill: black;");
		bt1.setGraphic(view1);
		bt2.setGraphic(view2);
		bt3.setGraphic(view3);
		Label l1 = new Label("Rental Media System");
		l1.setTextFill(Color.BLACK);
		l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
		VBox root = new VBox();
		root.setStyle("-fx-background-color: #3D59AB;");
		root.setPrefSize(400, 300);
		bt1.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		bt2.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		bt3.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
		bt1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		bt1.setOnAction(e -> {
			try {
				Customer.main();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt2.setOnAction(e -> {
			try {
				Media.main();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		bt3.setOnAction(e -> {
			try {
				Rent.main();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		root.getChildren().addAll(bt1, bt2, bt3);
		root.setSpacing(50);
		VBox root2 = new VBox();
		root2.setStyle("-fx-background-color: #3D59AB;");
		root2.getChildren().addAll(view4, l1);
		root2.setAlignment(Pos.CENTER);
		root2.setSpacing(10);
		FlowPane fp = new FlowPane();
		fp.getChildren().addAll(root, root2);
		fp.setAlignment(Pos.CENTER);
		fp.setHgap(20);
		fp.setStyle("-fx-background-color: #3D59AB;");
		Scene scene = new Scene(fp, 800, 800, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}

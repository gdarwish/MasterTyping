package Pane;

import MainProgram.Main;
import Scene.MainScene;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class creditPane extends BorderPane{
	
	public creditPane() {
	
		Font font = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 40);
		HBox backHbox = new HBox();
		backHbox.setMaxWidth(40);
		backHbox.setMaxHeight(40);
		backHbox.setAlignment(Pos.TOP_LEFT);
		Image img = new Image("toBack.png");
		ImageView m = new ImageView(img);
		m.setFitWidth(33);
		m.setFitHeight(35);
		backHbox.setBackground(MainPane.bg);
		backHbox.setOnMouseEntered(e -> {
			backHbox.setStyle("-fx-cursor: hand");
			backHbox.setBackground(
					new Background(new BackgroundFill(Color.INDIANRED, new CornerRadii(20), new Insets(1, 1, 1, 1))));
		});
		backHbox.setOnMouseExited(e -> {
			backHbox.setBackground(MainPane.bg);
		});
		backHbox.getChildren().add(m);
		
		backHbox.setOnMouseClicked(e -> {
			Main.mainStage.setScene(new MainScene());
			MainPane.restartGame();	
		});
		
		// Title
		Text title = new Text("Master Typing");
		title.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 80));
		this.setStyle("-fx-background-color: #D5EFFE;");

		// Title animation
		FadeTransition fadetitle = new FadeTransition(Duration.millis(1000), title);
		fadetitle.setFromValue(0.4);
		fadetitle.setToValue(1);
		fadetitle.setCycleCount(Timeline.INDEFINITE);
		fadetitle.setAutoReverse(true);
		fadetitle.play();

		FillTransition filltitle = new FillTransition(Duration.millis(1500), title);
		filltitle.setFromValue(Color.rgb(250, 50, 20));
		filltitle.setToValue(Color.PURPLE);
		filltitle.setCycleCount(Timeline.INDEFINITE);
		filltitle.setAutoReverse(true);
		filltitle.play();

		HBox titleHbox = new HBox();
		titleHbox.setAlignment(Pos.CENTER);
		titleHbox.setSpacing(5);
		titleHbox.getChildren().addAll(title);
		
		HBox headerHbox = new HBox();
		headerHbox.setPadding(new Insets(5));
		headerHbox.setSpacing(275);
		headerHbox.getChildren().addAll(backHbox, title);
		this.setTop(headerHbox);
		
		
		VBox namesVbox = new VBox();
		namesVbox.setAlignment(Pos.CENTER);
		
		Text name1 = new Text("Ghaith Darwish");
		name1.setFont(font);
		FadeTransition  fade =
				new FadeTransition(Duration.millis(2000), name1);
		fade.setFromValue(0.1);
		fade.setToValue(1);
		ScaleTransition scale = new
				ScaleTransition(Duration.millis(1300), name1);
		scale.setByX(.50);
		scale.setByY(.50);
		scale.setCycleCount(2);
		scale.setAutoReverse(true);
		FillTransition fill = 
				new FillTransition(Duration.millis(2000), name1);
		fill.setFromValue(Color.rgb(250, 50, 20));
		fill.setToValue(Color.PURPLE);
		TranslateTransition tran = 
				new TranslateTransition(Duration.millis(2000), name1);
		tran.setFromY(-300);
		tran.setToY(0);	
		ParallelTransition ghaith = new ParallelTransition();
		ghaith.getChildren().addAll(fade, scale, fill, tran);
		
		Text name2 = new Text("Abdur");
		name2.setFont(font);
		name2.setFill(Color.TRANSPARENT);
		FadeTransition  fade2 =
				new FadeTransition(Duration.millis(2000), name2);
		fade2.setFromValue(0.1);
		fade2.setToValue(1);
		ScaleTransition scale2 = new
				ScaleTransition(Duration.millis(1300), name2);
		scale2.setByX(.50);
		scale2.setByY(.50);
		scale2.setCycleCount(2);
		scale2.setAutoReverse(true);
		FillTransition fill2 = 
				new FillTransition(Duration.millis(2000), name2);
		fill2.setFromValue(Color.rgb(250, 50, 20));
		fill2.setToValue(Color.DARKGREEN);
		TranslateTransition tran2 = 
				new TranslateTransition(Duration.millis(2000), name2);
		tran2.setFromX(+500);
		tran2.setFromY(+500);
		tran2.setToX(0);	
		tran2.setToY(0);
		ParallelTransition abdur = new ParallelTransition();
		abdur.getChildren().addAll(fade2, scale2, fill2, tran2);
		
		Text name3 = new Text("David");
		name3.setFont(font);
		name3.setFill(Color.TRANSPARENT);
		FadeTransition  fade3 =
				new FadeTransition(Duration.millis(2000), name3);
		fade3.setFromValue(0.1);
		fade3.setToValue(1);
		ScaleTransition scale3 = new
				ScaleTransition(Duration.millis(1300), name3);
		scale3.setByX(.50);
		scale3.setByY(.50);
		scale3.setCycleCount(2);
		scale3.setAutoReverse(true);
		FillTransition fill3 = 
				new FillTransition(Duration.millis(2000), name3);
		fill3.setFromValue(Color.rgb(250, 50, 20));
		fill3.setToValue(Color.DARKBLUE);
		TranslateTransition tran3 = 
				new TranslateTransition(Duration.millis(2000), name3);
		tran3.setFromY(-500);
		tran3.setFromX(-500);
		tran3.setToX(0);
		tran3.setToY(0);
		ParallelTransition david = new ParallelTransition();
		david.getChildren().addAll(fade3, scale3, fill3, tran3);
		
		namesVbox.getChildren().addAll(name1, name2, name3);
		this.setCenter(namesVbox);
		
		Text name4 = new Text("special thanks to Ali");
		name4.setFont(font);
		name4.setFill(Color.TRANSPARENT);
		this.setBottom(name4);
		this.setAlignment(name4, Pos.CENTER);
		FadeTransition  fade4 =
				new FadeTransition(Duration.millis(2000), name4);
		fade4.setFromValue(0.1);
		fade4.setCycleCount(Timeline.INDEFINITE);
		fade4.setAutoReverse(true);
		fade4.setToValue(1);
		ScaleTransition scale4 = new
				ScaleTransition(Duration.millis(1300), name4);
		scale4.setByX(.50);
		scale4.setByY(.50);
		scale4.setCycleCount(2);
		scale4.setAutoReverse(true);
		FillTransition fill4 = 
				new FillTransition(Duration.millis(2000), name4);
		fill4.setFromValue(Color.rgb(250, 50, 20));
		fill4.setToValue(Color.DARKBLUE);
		ParallelTransition ali = new ParallelTransition();
		ali.getChildren().addAll(fade4, scale4, fill4);
		
		VBox h = new VBox();
		h.setAlignment(Pos.CENTER);
		h.setPadding(new Insets(50));
		Image rotate = new Image("rotate.png");
		ImageView m1 = new ImageView(rotate);
		m1.setFitWidth(150);
		m1.setFitHeight(150);
		h.getChildren().add(m1);
		RotateTransition rot = new RotateTransition(Duration.millis(1500), m1);
		rot.setCycleCount(Timeline.INDEFINITE);
		rot.setInterpolator(Interpolator.SPLINE(1, 1, 1, 1));
	//	rot.setAutoReverse(true);
		rot.setByAngle(360);
		
		ScaleTransition scaleRot = new
				ScaleTransition(Duration.millis(1000), m1);
		scaleRot.setByX(.50);
		scaleRot.setByY(.50);
		scaleRot.setCycleCount(2);
		scaleRot.setAutoReverse(true);
		scaleRot.setCycleCount(Timeline.INDEFINITE);
		this.setLeft(h);
		
		
		VBox g = new VBox();
		g.setAlignment(Pos.CENTER);
		g.setPadding(new Insets(50));
		ImageView m2 = new ImageView(rotate);
		m2.setFitWidth(150);
		m2.setFitHeight(150);
		g.getChildren().add(m2);
		RotateTransition rot2 = new RotateTransition(Duration.millis(1000), m2);
		rot2.setCycleCount(Timeline.INDEFINITE);
		rot2.setInterpolator(Interpolator.SPLINE(1, 1, 1, 1));
	//	rot.setAutoReverse(true);
		rot2.setByAngle(360);
		ScaleTransition scaleRot2 = new
				ScaleTransition(Duration.millis(1300), m2);
		scaleRot2.setByX(.50);
		scaleRot2.setByY(.50);
		scaleRot2.setCycleCount(2);
		scaleRot2.setAutoReverse(true);
		scaleRot2.setCycleCount(Timeline.INDEFINITE);
		this.setRight(g);
		
		ParallelTransition rotatee = new ParallelTransition();
		rotatee.getChildren().addAll(rot, rot2, scaleRot2, scaleRot);
		rotatee.play();
		
		SequentialTransition  all = new  SequentialTransition();
		all.getChildren().addAll(ghaith, abdur, david, ali);
		all.play();
		
	}

}

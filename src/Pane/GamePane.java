package Pane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import MainProgram.Main;
import Scene.MainScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import resources.GameText;
import resources.Keyboard;

public class GamePane extends BorderPane {
	public GamePane instance;
	public static ArrayList<Text> letter = new ArrayList<Text>();
	public static int index = 0;
	public HBox text = new HBox();
	public String paragraph;
	static GameText gameText;

	public static Text errorsText;
	public static Text timerText;
	public static Text accText;
	public static Border border = new Border(
			new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(15), BorderWidths.DEFAULT));
	public static Font font = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 22);
	public static Font doneFont = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 40);

	public VBox headerVbox = new VBox();
	public static HBox doneHbox;
	public static String[] TEXT;
	public static Label perfectScore;
	public static Label goodScore;
	public static Label notBad;
	public static Label veryBad;
	
	public GamePane(String[] textt) {
		TEXT = textt;
		letter.clear();
		index = 0;

		gameText = new GameText(textt);
		paragraph = gameText.getParagraph();
		this.setPadding(new Insets(5, 10, 30, 5));
		this.setStyle("-fx-background-color: #D5EFFE;");

		// VBox headerVbox = new VBox();

		// The back button
		HBox backHbox = new HBox();
		backHbox.setMaxWidth(40);
		backHbox.setMaxHeight(40);
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
			if (GamePane.index == GamePane.letter.size()) {
			try {
				if(!MainPane.highscoresFile.exists()) {
					MainPane.highscoresFile.createNewFile();
				}
				MainPane.wr = new FileWriter(MainPane.highscoresFile,true);
				MainPane.wr.write(MainPane.accr3+" ");
				MainPane.wr.flush();
				MainPane.wr.close();
				
			} catch (IOException r) {
				r.printStackTrace();
			}
			}
			Main.mainStage.setScene(new MainScene());
			MainPane.restartGame();
		});

		// The back button ends here
		// Start the stats HBox

		// We will have three things (Errors, Time, Accuracy)
		HBox statsHbox = new HBox();
		statsHbox.setSpacing(150);
		statsHbox.setAlignment(Pos.CENTER);

		VBox errorsVbox = new VBox();
		errorsVbox.setSpacing(10);
		errorsVbox.setAlignment(Pos.CENTER);
		Text errTitle = new Text("Errors");
		errTitle.setFont(font);
		Image e = new Image("errors.png");
		ImageView errorsImg = new ImageView(e);
		errorsImg.setFitWidth(65);
		errorsImg.setFitHeight(65);
		errorsText = new Text("0");
		errorsText.setFont(Font.font(18));
		errorsVbox.getChildren().addAll(errTitle, errorsImg, errorsText);

		VBox timerVbox = new VBox();
		timerVbox.setSpacing(10);
		timerVbox.setAlignment(Pos.CENTER);
		Text timTitle = new Text("Time");
		timTitle.setFont(font);
		Image t = new Image("timer.png");
		ImageView timersImg = new ImageView(t);
		timersImg.setFitWidth(65);
		timersImg.setFitHeight(65);
		timerText = new Text("0.0");
		timerText.setFont(Font.font(18));
		timerVbox.getChildren().addAll(timTitle, timersImg, timerText);

		VBox accVbox = new VBox();
		accVbox.setSpacing(10);
		accVbox.setAlignment(Pos.CENTER);
		Text accTitle = new Text("Accuracy");
		accTitle.setFont(font);
		Image a = new Image("accuracy.png");
		ImageView accImg = new ImageView(a);
		accImg.setFitWidth(65);
		accImg.setFitHeight(65);
		accText = new Text("0%");
		accText.setFont(Font.font(18));
		accVbox.getChildren().addAll(accTitle, accImg, accText);

		statsHbox.getChildren().addAll(errorsVbox, timerVbox, accVbox);

		headerVbox.getChildren().addAll(backHbox, statsHbox);
		this.setTop(headerVbox);

		// Setting the paragraph to the center of the page
		text.setAlignment(Pos.CENTER);

		// Looping through the the paragraph and adding the letters to the arraylist
		for (int i = 0; i < paragraph.length(); i++) {
			letter.add(new Text(paragraph.charAt(i) + ""));
			letter.get(i).setFont(Font.font("TIMES NEW ROMAN", 20));
			text.getChildren().add(letter.get(i));
		}

		doneHbox = new HBox();
		doneHbox.setAlignment(Pos.CENTER);
		Label done = new Label("Click or press ENTER for a new Game");
		done.setFont(font);
		doneHbox.setBackground(MainPane.bg);
		done.setAlignment(Pos.CENTER);
		doneHbox.setOnMouseEntered(g -> {
			doneHbox.setStyle("-fx-cursor: hand");
			doneHbox.setBackground(
					new Background(new BackgroundFill(Color.INDIANRED, new CornerRadii(15), new Insets(1, 1, 1, 1))));
		});
		doneHbox.setOnMouseExited(y -> {
			doneHbox.setBackground(MainPane.bg);
		});
		
		perfectScore = new Label("WOW, you haven't made any mistakes like are you kidding me!!");
		perfectScore.setFont(doneFont);
		perfectScore.setBackground(Keyboard.green);
		
		goodScore = new Label("You are very good but keep practicing :)");
		goodScore.setFont(doneFont);
		goodScore.setBackground(Keyboard.green);
		
		notBad = new Label("Not too bad but you should do better keep going!");
		notBad.setFont(doneFont);
		notBad.setBackground(Keyboard.yellow);
		
		veryBad = new Label("Come on, are you even trying!!");
		veryBad.setFont(doneFont);
		veryBad.setBackground(Keyboard.red);

		
		doneHbox.getChildren().add(done);

		for (int i = 0; i < 27; i++) {
			GameText.keyboard.text.get(i).setBackground(GameText.keyboard.original);
			char hoverL = letter.get(index).getText().toLowerCase().charAt(0);
			int indexL = (int) hoverL - 97;
			if (indexL < 26 && indexL >= 0) {
				GameText.keyboard.text.get(indexL).setBackground(GameText.keyboard.yellow);
			}
		}
		letter.get(index).setUnderline(true);
		this.setAlignment(GameText.keyboard, Pos.CENTER);
		this.setCenter(text);
		this.setBottom(GameText.keyboard);
		this.requestFocus();
	}

	public BorderPane getInstance() {
		return this;
	}

}

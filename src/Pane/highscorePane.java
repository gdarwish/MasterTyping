package Pane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import MainProgram.Main;
import Scene.GameScene;
import Scene.MainScene;
import Scene.creditScene;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Timeline;
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

public class highscorePane extends BorderPane{
	static ArrayList<Integer> scores = new ArrayList<Integer>();
	public static Font font = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 22);
	

	public highscorePane() {
		
		this.setStyle("-fx-background-color: #D5EFFE;");
		Text title = new Text("Master Typing");
		title.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 80));

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
		
		
		Text highScoreText = new Text("High Scores");
		highScoreText.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 60));
		FadeTransition fadeScore = new FadeTransition(Duration.millis(2000), highScoreText);
		fadeScore.setFromValue(0);
		fadeScore.setToValue(1);
		fadeScore.setCycleCount(1);
		fadeScore.play();
		
		// The back button
		HBox backHboxHigh = new HBox();
		backHboxHigh.setAlignment(Pos.CENTER_LEFT);
		backHboxHigh.setMaxWidth(40);
		backHboxHigh.setMaxHeight(40);
		Image img = new Image("toBack.png");
		ImageView m = new ImageView(img);
		m.setFitWidth(33);
		m.setFitHeight(35);
		backHboxHigh.setBackground(MainPane.bg);
		backHboxHigh.setOnMouseEntered(e -> {
			backHboxHigh.setStyle("-fx-cursor: hand");
			backHboxHigh.setBackground(
					new Background(new BackgroundFill(Color.INDIANRED, new CornerRadii(20), new Insets(1, 1, 1, 1))));
		});
		backHboxHigh.setOnMouseExited(e -> {
			backHboxHigh.setBackground(MainPane.bg);
		});
		backHboxHigh.getChildren().add(m);

		backHboxHigh.setOnMouseClicked(e -> {
			Main.mainStage.setScene(new MainScene());
		});
	

		
		
		
		try {
	        File file = new File("highscores.txt");
	        BufferedReader br = new BufferedReader(new FileReader(file));
	        String s; 
	        while ((s = br.readLine()) != null) {
	            getNumber(s);
	        }
	        br.close();
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Collections.sort(scores);
		Collections.reverse(scores);
		
		StringBuffer nums = new StringBuffer();
		for(Integer s : scores){
		    nums.append(s+"%"+"\n");
		}
		
		Text numbers = new Text("");
		for(int i=0;i<scores.size();i++) {
			numbers = new Text(nums.toString());
		}
		
		numbers.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 35));
		FadeTransition fadeNumbers = new FadeTransition(Duration.millis(3500), numbers);
		fadeNumbers.setFromValue(0);
		fadeNumbers.setToValue(1);
		fadeNumbers.setCycleCount(1);
		fadeNumbers.play();
		
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(backHboxHigh, highScoreText,numbers);
		this.setTop(vbox);


	}
	private static void getNumber(String s){
	    String [] nums = s.split(" ");
	
	    for (int i=0;i<nums.length;i++) {
	        try{
	            int j = Integer.parseInt(nums[i]);
	            scores.add(j);
	        } catch (Exception e){}
	    }
	}

}

package Pane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import MainProgram.Main;


import Scene.GameScene;
import Scene.creditScene;
import Scene.highscoreScene;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import resources.GameText;

public class MainPane extends BorderPane {
	// Ghaith
	boolean correctLetter;
	static int points, errors, keyPoints, keyerrors, totalPoints, totalErrors = 0;
	static double accuracy = 0;
	public static GameScene game;
	public static highscoreScene scores;
	public static Background bg = new Background(
			new BackgroundFill(Color.rgb(34, 161, 244), new CornerRadii(20), new Insets(1)));

	public static int acc=0;
	public Timeline timeline;
    public DoubleProperty timeSeconds = new SimpleDoubleProperty();
    public Duration time = Duration.ZERO;
    public long accr;
    public String accr2;
    public static String accr3;
    public VBox exitVbox = new VBox();
    VBox allVbox = new VBox();
    public static FileWriter wr;
    public static File highscoresFile = new File("highscores.txt");
    
	public MainPane() {
		Font font = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 40);

		// Title
		Text title = new Text("Master Typing");
		title.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 80));
		this.setAlignment(title, Pos.TOP_CENTER);
		this.setTop(title);
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
		// Game option

		// easy
		VBox easyVbox = new VBox();
		easyVbox.setAlignment(Pos.CENTER);
		easyVbox.setBackground(MainPane.bg);
		easyVbox.setOnMouseEntered(e -> {
			easyVbox.setStyle("-fx-cursor: hand");
			easyVbox.setBackground(
					new Background(new BackgroundFill(Color.INDIANRED, new CornerRadii(20), new Insets(1, 1, 1, 1))));
		});
		easyVbox.setOnMouseExited(e -> {
			easyVbox.setBackground(MainPane.bg);
		});
		Text easy = new Text("Easy");
		easy.setFont(font);
		easy.setFill(Color.WHITE);
		easyVbox.getChildren().add(easy);

		// medium
		VBox mediumVbox = new VBox();
		mediumVbox.setAlignment(Pos.CENTER);
		mediumVbox.setBackground(MainPane.bg);
		mediumVbox.setStyle("-fx-cursor: hand");
		mediumVbox.setOnMouseEntered(e -> {
			mediumVbox.setBackground(
					new Background(new BackgroundFill(Color.INDIANRED, new CornerRadii(20), new Insets(1, 1, 1, 1))));
		});
		mediumVbox.setOnMouseExited(e -> {
			mediumVbox.setBackground(MainPane.bg);
		});
		Text medium = new Text("Medium");
		medium.setFont(font);
		medium.setFill(Color.WHITE);
		mediumVbox.getChildren().add(medium);

		// Hard
		VBox hardVbox = new VBox();
		hardVbox.setAlignment(Pos.CENTER);
		hardVbox.setBackground(MainPane.bg);
		hardVbox.setStyle("-fx-cursor: hand");
		hardVbox.setOnMouseEntered(e -> {
			hardVbox.setBackground(
					new Background(new BackgroundFill(Color.INDIANRED, new CornerRadii(20), new Insets(1, 1, 1, 1))));
		});
		hardVbox.setOnMouseExited(e -> {
			hardVbox.setBackground(MainPane.bg);
		});
		Text hard = new Text("Hard");
		hard.setFont(font);
		hard.setFill(Color.WHITE);
		hardVbox.getChildren().add(hard);

		// Exit
		VBox exitVbox = new VBox();
		exitVbox.setAlignment(Pos.CENTER);
		exitVbox.setBackground(MainPane.bg);
		exitVbox.setStyle("-fx-cursor: hand");
		exitVbox.setOnMouseEntered(e -> {
			exitVbox.setBackground(
					new Background(new BackgroundFill(Color.INDIANRED, new CornerRadii(20), new Insets(1, 1, 1, 1))));
		});
		exitVbox.setOnMouseExited(e -> {
			exitVbox.setBackground(MainPane.bg);
		});
		Text exit = new Text("Exit");
		exit.setFont(font);
		exit.setFill(Color.WHITE);
		exitVbox.getChildren().add(exit);
		exitVbox.setOnMouseClicked(e -> {
			System.exit(0);
		});

		// Credit
		VBox creditVbox = new VBox();
		creditVbox.setAlignment(Pos.CENTER);
		creditVbox.setBackground(MainPane.bg);
		creditVbox.setStyle("-fx-cursor: hand");
		creditVbox.setOnMouseEntered(e -> {
			creditVbox.setBackground(
					new Background(new BackgroundFill(Color.INDIANRED, new CornerRadii(20), new Insets(1, 1, 1, 1))));
		});
		creditVbox.setOnMouseExited(e -> {
			creditVbox.setBackground(MainPane.bg);
		});
		Text crediTexit = new Text("Credits");
		crediTexit.setFont(font);
		crediTexit.setFill(Color.WHITE);
		creditVbox.getChildren().add(crediTexit);
		creditVbox.setOnMouseClicked(e -> {
			Main.mainStage.setScene(new creditScene());
		});
		
		// highscore
		VBox highscoreVbox = new VBox();
		highscoreVbox.setAlignment(Pos.CENTER);
		highscoreVbox.setBackground(MainPane.bg);
		highscoreVbox.setStyle("-fx-cursor: hand");
		highscoreVbox.setOnMouseEntered(e -> {
			highscoreVbox.setBackground(
					new Background(new BackgroundFill(Color.INDIANRED, new CornerRadii(20), new Insets(1, 1, 1, 1))));
		});
		highscoreVbox.setOnMouseExited(e -> {
			highscoreVbox.setBackground(MainPane.bg);
		});
		
		Text highscoreText = new Text("High Scores");
		highscoreText.setFont(font);
		highscoreText.setFill(Color.WHITE);
		highscoreVbox.getChildren().add(highscoreText);
		
		highscoreVbox.setOnMouseClicked(e -> {

			scores = new highscoreScene();
			Main.mainStage.setScene(scores);
		});

		VBox allVbox = new VBox();
		allVbox.setAlignment(Pos.CENTER);
		allVbox.setSpacing(12);
		allVbox.setMaxHeight(70);
		allVbox.setMaxWidth(225);
		allVbox.getChildren().addAll(easyVbox, mediumVbox, hardVbox, creditVbox, highscoreVbox, exitVbox);
		this.setCenter(allVbox);
		easyVbox.setOnMouseClicked(e -> {

			game = new GameScene(GameText.EASY);
			game.setOnKeyPressed(new GameCheckPressed());
			game.setOnKeyReleased(new GameCheckReleased());
			Main.mainStage.setScene(game);

		});
		mediumVbox.setOnMouseClicked(e -> {
			game = new GameScene(GameText.MEDIUM);
			game.setOnKeyPressed(new GameCheckPressed());
			game.setOnKeyReleased(new GameCheckReleased());
			Main.mainStage.setScene(game);
		});
		hardVbox.setOnMouseClicked(e -> {

			game = new GameScene(GameText.HARD);
			game.setOnKeyPressed(new GameCheckPressed());
			game.setOnKeyReleased(new GameCheckReleased());
			Main.mainStage.setScene(game);
		});
	}

	private class GameCheckPressed implements EventHandler<KeyEvent> {

		@Override
		public void handle(KeyEvent event) {
			
			if (timeline != null) {
				
            } else {
                timeline = new Timeline(
                    new KeyFrame(Duration.millis(100),
                    new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent t) {
                            Duration duration = ((KeyFrame)t.getSource()).getTime();
                            time = time.add(duration);
                            timeSeconds.set(time.toSeconds());
                        }
                    })
                );
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();
            }

			String l = event.getCode().toString();
			if (l.matches("^[A-Z\\s]+$")) {
				if (GamePane.letter.size() > GamePane.index) {
					if (GamePane.index + 1 < GamePane.letter.size())
						GamePane.letter.get(GamePane.index + 1).setUnderline(true);

					GamePane.letter.get(GamePane.index).setUnderline(false);
//					// TO DO CHANGE THE COLOR BACK TO ORIGINAL

					if (l.equals("SPACE")) {
						if (GamePane.letter.get(GamePane.index).getText().equals(" ")) {
							GameText.keyboard.text.get(26).setBackground(GameText.keyboard.green);
							keyPoints++;
						} else {
							GameText.keyboard.text.get(26).setBackground(GameText.keyboard.red);
							keyerrors++;
						}
					}
					if (l.equals(GamePane.letter.get(GamePane.index).getText().toUpperCase())) {

						GamePane.letter.get(GamePane.index).setFill(Color.GREEN);
						correctLetter = true;
						points++;

					} else {
						GamePane.letter.get(GamePane.index).setFill(Color.RED);
						correctLetter = false;
						if (!l.equals("SPACE")) {
							errors++;

						}
					}
					// Calculating the points and the errors
					totalPoints = keyPoints + points;
					totalErrors = keyerrors + errors;

					double total = totalPoints + totalErrors;
					double acc = total - totalErrors;
					accuracy = (acc / total) * 100;
					String tot = String.valueOf(totalErrors);
					GamePane.errorsText.setText(tot);

					accr = rounding(accuracy);
					accr2 = String.valueOf(accr + "%");
					accr3 = String.valueOf(accr);
					GamePane.accText.setText(accr2);
					
					GamePane.timerText.textProperty().bind(timeSeconds.asString());

					GamePane.index++;
				}
			}
			for (int i = 0; i < 26; i++) {
				if (event.getCode().toString().equals(GameText.keyboard.text.get(i).getText())) {
					if (correctLetter)
						GameText.keyboard.text.get(i).setBackground(GameText.keyboard.green);
					else
						GameText.keyboard.text.get(i).setBackground(GameText.keyboard.red);
				}
			}
		}
	}

	private class GameCheckReleased implements EventHandler<KeyEvent> {
		@Override
		public void handle(KeyEvent event) {

			for (int i = 0; i < 27; i++) {
				GameText.keyboard.text.get(i).setBackground(GameText.keyboard.original);
				if (GamePane.index < GamePane.letter.size()) {
					char hoverL = GamePane.letter.get(GamePane.index).getText().toLowerCase().charAt(0);
					int indexL = (int) hoverL - 97;
					if (indexL < 26 && indexL >= 0) {
						GameText.keyboard.text.get(indexL).setBackground(GameText.keyboard.yellow);
					}
				}
			}

			if (GamePane.index == GamePane.letter.size()) {
				game.returnPane().setBottom(GamePane.doneHbox);
				timeline.stop();
				
				game.setOnKeyPressed(f -> {
					if (f.getCode() == KeyCode.ENTER) {
						try {
						//	File highscoresFile = new File("highscores.txt");
							if(!highscoresFile.exists()) {
								highscoresFile.createNewFile();
							}
							wr = new FileWriter(highscoresFile,true);
							wr.write(accr3+" ");
							wr.flush();
							wr.close();
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						restartGame();
						MainPane.game.setRoot(new GamePane(GamePane.TEXT));
						game.setOnKeyPressed(new GameCheckPressed());
					}
				});
				GamePane.doneHbox.setOnMouseClicked(o -> {
					try {
					//	File highscoresFile = new File("highscores.txt");
						if(!highscoresFile.exists()) {
							highscoresFile.createNewFile();
						}
						wr = new FileWriter(highscoresFile,true);
						wr.write(accr3+" ");
						wr.flush();
						wr.close();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					restartGame();
					game.setRoot(new GamePane(GamePane.TEXT));
					game.setOnKeyPressed(new GameCheckPressed());

				});
			}
			if (GamePane.index == GamePane.letter.size()) {
				if (totalErrors == 0) {
					game.returnPane().setCenter(GamePane.perfectScore);
				}else if (totalErrors <= 10) {
					game.returnPane().setCenter(GamePane.goodScore);
				}else if (totalErrors <= 20) {
					game.returnPane().setCenter(GamePane.notBad);
				}else if (totalErrors >= 21) {
					game.returnPane().setCenter(GamePane.veryBad);
				}
			}
		}
	}

	private static long rounding(double accuracy) {
		return (int) Math.floor(accuracy);
	}

	public static void restartGame() {
		points = errors = keyPoints = keyerrors = totalPoints = totalErrors = 0;
		accuracy = 0;
	}
}

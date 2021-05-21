package Scene;

import Pane.GamePane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class GameScene extends Scene {


	public GameScene(String[] text) {
		super(new GamePane(text), 1100, 800);
	}
	
	public BorderPane returnPane() {
		return (BorderPane) this.getRoot();
	}
}

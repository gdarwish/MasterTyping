package resources;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
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

public class Keyboard extends VBox {
	public ArrayList<Label> text;
	public static Background red = new Background(new BackgroundFill(Color.RED, null, null));
	public static Background green = new Background(new BackgroundFill(Color.GREEN, null, null));
	public static Background yellow = new Background(new BackgroundFill(Color.rgb(142, 249, 152), null, null));
	public static Background original = new Background(new BackgroundFill(Color.rgb(34, 161, 244), null, null));
	public static Font font = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 22);
	public static Border border = new Border(
			new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT));

	public Keyboard() {
		this.setAlignment(Pos.CENTER);
		this.setSpacing(4);
		this.setMaxWidth(800);
		this.setMaxHeight(200);
	//	this.setBorder(border);
		this.setPadding(new Insets(10));
		
		text = new ArrayList<Label>();
		char letter = 65; // A
		for (int i = 0; i < 26; i++) {
			text.add(new Label(letter++ + ""));
			text.get(i).setPadding(new Insets(15, 25, 15, 25));
			text.get(i).setBackground(original);
			text.get(i).setTextFill(Color.WHITE);
			text.get(i).setFont(font);
			text.get(i).setBorder(border);
		}

		HBox firstHbox = new HBox();
		
		firstHbox.setAlignment(Pos.CENTER);
		firstHbox.setSpacing(4);
		firstHbox.getChildren().addAll(text.get(16), text.get(22), text.get(4), text.get(17), text.get(19),
				text.get(24), text.get(20), text.get(8), text.get(14), text.get(15));

		HBox secondHbox = new HBox();
		secondHbox.setAlignment(Pos.CENTER);
		secondHbox.setSpacing(4);
		secondHbox.getChildren().addAll(text.get(0), text.get(18), text.get(3), text.get(5), text.get(6), text.get(7),
				text.get(9), text.get(10), text.get(11));

		HBox thirdHbox = new HBox();
		thirdHbox.setAlignment(Pos.CENTER);
		thirdHbox.setSpacing(4);
		thirdHbox.getChildren().addAll(text.get(25), text.get(23), text.get(2), text.get(21), text.get(1), text.get(13),
				text.get(12));
		
		Label space = new Label("SPACE");
		space.setTextFill(Color.TRANSPARENT);
		space.setMinWidth(300);
		space.setPadding(new Insets(15, 25, 15, 25));
		space.setBackground(original);
		space.setFont(font);
		space.setBorder(border);
		text.add(space);
		
		HBox spaceBox = new HBox(text.get(26));
		spaceBox.setAlignment(Pos.CENTER);

		this.getChildren().addAll(firstHbox, secondHbox, thirdHbox, spaceBox);
	}
}

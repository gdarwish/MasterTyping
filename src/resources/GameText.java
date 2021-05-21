package resources;

import java.util.Random;

public class GameText {
	public static final String[] EASY = {
			"jazz hair camp rock eggs dawn moon world wine water shut boat epic roses debts roses end minute metal memory medical meat",
			"baby back bad bag ball bank base basket bath be bean bear beautiful bed beer measure meal may material match married market",
			"each ear early earn earth east easy eat education effect egg eight either else sell drain drawer dress egg effect east dry",
			"sad safe sail salt same sand save say school science scissors search seat second see drop act angle animal answer every ant" };
//	public static final String[] EASY = {"ABC","EFG","HIG","KLM"};
	public static final String[] MEDIUM = {"love hate truth happy pressure surf believe slime dream religion rhythm disco honey star accumulate adjacent ambiguous",
										  "armies juku zombie heart break exam docks multiply mace jail jane jarl moustache wizards albeit analogy append attain",
										  "sports blind riddle business school blood promenade vault spray eternal dress abstain controls allege abajo abierto",
										  "dangerous skunk house wives flash light console awesome scared hormones promise angel abrazar abrir aceptar acercarse"};

	
	public static final String[] HARD = {"acommodate hankerchief pronunciation floccinaucinihilipilification conscence playwrite tsktsk subdermatoglyphicdisapproval",
										"convalece supercede pronunciation carribean pseudopseudohypoparathyroidism maintainence unimaginatively uncopyrightable",
										"reccommend deductable pneumonoultramicroscopicsilicovolcanoconiosis strengths possess sesquipedalian",
										"pronunciation antidisestablishmentarianism otorhinolaryngologist unnecessarily combination appropriate sesquipedalianism"};

	public static Keyboard keyboard = new Keyboard();

	private String paragraph;
	
	public GameText(String[] text) {
		this.paragraph = randomText(text);
	}
	
	public String getParagraph() {
		return paragraph;
	}

	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}

	public String randomText(String[] text) {
		Random random = new Random();
		int randomtext = random.nextInt(text.length);
		return text[randomtext];
	}
}

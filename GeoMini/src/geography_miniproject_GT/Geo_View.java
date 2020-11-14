package geography_miniproject_GT;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Geo_View {
	protected Stage stage;
	private Geo_Model model;
	

	
	 BorderPane root = new BorderPane ();
	
	 GridPane DataEntry = new GridPane ();

		
	protected Label EnterData = new Label ("Create New File:");
	protected Label OpenFile = new Label ("Open File:");
	protected TextField SaveAs = new TextField ();
	protected TextField openfile = new TextField ();
	
	
	
	protected Label Countrylbl = new Label("Country");
	protected TextField countrytxt = new TextField();
	
	protected Label Statelbl = new Label ("State");
	protected TextField statetxt = new TextField();
			
	
	protected Label Arealbl = new Label("Area");
	protected TextField areatxt = new TextField();
	
	protected Label Poplbl = new Label("Population");
	protected TextField populationtxt = new TextField();
	
	protected Label TypeOfGovlbl = new Label("Type of government");
	
	
	protected Button Clearbtn = new Button ("Clear All");
	protected Button Savebtn = new Button ("Save");
	protected Label SaveStatus = new Label ();
	
	protected Button Loadbtn = new Button ("Load Existing");
	
	protected Button Deletebtn = new Button ("Delete");
	protected Label DeleteStatus = new Label ();
	
	protected Label Copyright = new Label ("ⓒ G. Travaglione 2020 \n for FHNW BIT B. Richards");
	protected Button QuitApp = new Button ("Quit Application");

	public ComboBox <String> typeOfGovBox = new ComboBox<>();
	{typeOfGovBox.getItems().addAll(
			"Democracy",
			"Republic",
			"Monarchy"
			
	);
}
	
	public Geo_View(Stage primaryStage, Geo_Model model) {
		this.stage = primaryStage;
		this.model = model;
		
		
		
		
		root.setCenter(DataEntry);
		
		DataEntry.setPadding(new Insets (20));
		DataEntry.setHgap(35);
		DataEntry.setVgap(20);
		
	
		
		

		
		DataEntry.add(EnterData,0,0,2,1);
		DataEntry.add(SaveAs,1,0,2,1);
		SaveAs.setPromptText("Define a new file name");
		
		
		DataEntry.add(Countrylbl,0,1);
		DataEntry.add(countrytxt,1,1,2,1);
		countrytxt.setPromptText("e.g. Switzerland");
		
		DataEntry.add(Statelbl,0,2);
		DataEntry.add(statetxt,1,2,2,1);
		statetxt.setPromptText("e.g. Aargau");
		
		DataEntry.add(Arealbl,0,3);
		DataEntry.add(areatxt,1,3,2,1);
		areatxt.setPromptText("e.g. 1404");
		
		DataEntry.add(Poplbl,0,4);
		DataEntry.add(populationtxt,1,4,2,1);
		populationtxt.setPromptText("e.g. 680000");
		
		DataEntry.add(TypeOfGovlbl,0,5);
		DataEntry.add(typeOfGovBox,1,5,2,1);
		// Add Combobox "Picker" here (1,5,2,1);
		
		DataEntry.add(Clearbtn,1,7,1,1);
		DataEntry.add(Savebtn,2,7,1,1);
		DataEntry.add(SaveStatus,1,8,2,1);
		
		DataEntry.add(OpenFile,4,0,2,1);
		DataEntry.add(openfile,4,1,2,1);
		openfile.setPromptText("Enter existing file name");
		DataEntry.add(Loadbtn,6,1,2,1);
		
		DataEntry.add(DeleteStatus,4,2,2,1);
		DataEntry.add(Deletebtn,6,2,2,1);
		
		DataEntry.add(QuitApp,6,7);
		DataEntry.add(Copyright,6,8);
		
		

		Scene MainScene = new Scene (root,900,500);
		
		primaryStage.setScene(MainScene);
		
		MainScene.getStylesheets().add("geostyle.css");
		
		primaryStage.setTitle("Mini Geography Tool");
		
		
		
	}

	public void start() {
		stage.getIcons().add(new Image("file:geomini_icon.png"));
		stage.show ();

	}

}

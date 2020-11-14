package geography_miniproject_GT;

import geography_miniproject_GT.Geo_Model.SaveLoadManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.File;

public class Geo_Controller {

	final private Geo_Model model;
	final private Geo_View view;

	private boolean AreaValid = false;
	private boolean PopValid = false;

	
	public Geo_Controller(Geo_View view, Geo_Model model) {
		
		this.model = model;
		this.view = view;
	
	view.areatxt.textProperty().addListener((observable, oldValue, newValue) -> {validateArea(newValue);
	});
	
	view.populationtxt.textProperty().addListener((observable, oldValue, newValue) -> {validatePopulation(newValue);
	});
	
	view.Clearbtn.setOnAction(event-> {
		view.SaveAs.setText(null);
		view.countrytxt.setText(null);
		view.statetxt.setText(null);
		view.countrytxt.setText(null);
		view.areatxt.setText(null);
		view.populationtxt.setText(null);
		view.typeOfGovBox.setValue(null);
		view.openfile.setText(null);
	});
	
	
	view.Savebtn.setOnAction(event -> {
		DataManager data = new DataManager();
		data.countryName = view.countrytxt.getText();
		data.stateName = view.statetxt.getText();
		data.areaSize = Integer.parseInt(view.areatxt.getText());
		data.popSize = Integer.parseInt(view.populationtxt.getText());
		data.formOfGov = view.typeOfGovBox.getValue();
		try {SaveLoadManager.save(data,view.SaveAs.getText());
		
		}
		catch (Exception e) {System.out.println("Could not save data");
		
		}
	});
	
	
	view.Loadbtn.setOnAction(event -> {
        try {
            DataManager data = (DataManager) SaveLoadManager.load(view.openfile.getText());
            view.countrytxt.setText(data.countryName);
            view.statetxt.setText(data.stateName);
            view.areatxt.setText(String.valueOf(data.areaSize));
            view.populationtxt.setText(String.valueOf(data.popSize));
            view.typeOfGovBox.setValue(data.formOfGov);
            view.SaveAs.setText(view.openfile.getText());
            view.Savebtn.setText("Save changes");
            
        }
        catch (Exception e) {
            System.out.println("Couldn't load save data: " + e.getMessage());
        }
    });
	
	view.Deletebtn.setOnAction(event -> {
		File file = new File(view.openfile.getText());
		if (file.delete()) 
		{view.DeleteStatus.setText(view.openfile.getText()+".txt\nsuccessfully deleted");
		view.SaveAs.setText(null);
		view.countrytxt.setText(null);
		view.statetxt.setText(null);
		view.countrytxt.setText(null);
		view.areatxt.setText(null);
		view.populationtxt.setText(null);
		view.typeOfGovBox.setValue(null);
		view.openfile.setText(null);
	} else {view.DeleteStatus.setText("File not found");
	}
	})
	
	;
	
	view.QuitApp.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        	Platform.exit();}
	});
	


	
	
		}
		// TODO Auto-generated method stub
		
	

	
	
	
	private void validateArea(String newValue) {
		boolean valid = isValidArea(newValue);
		view.areatxt.getStyleClass().remove("valid");
		view.areatxt.getStyleClass().remove("invalid");
		if (valid) {view.areatxt.getStyleClass().add("valid");}
		else {view.areatxt.getStyleClass().add("invalid");
			
			AreaValid = valid;
	
		}
	
	}
	
	private void validatePopulation(String newValue) {
		boolean valid = isValidPop(newValue);
		view.populationtxt.getStyleClass().remove("valid");
		view.populationtxt.getStyleClass().remove("invalid");
		if (valid) {view.populationtxt.getStyleClass().add("valid");}
		else {view.populationtxt.getStyleClass().add("invalid");
			
			PopValid = valid;
	
		}
	
	}
	
	
	
	protected boolean isValidArea (String newValue) {
		boolean valid = true;
		
		try {
			int value = Integer.parseInt(newValue);
			if (value <1 || value > 17100000)
				valid = false;
		} catch (NumberFormatException e) {
			valid = false;
		}
		return valid;	
		}
	
	
	protected boolean isValidPop (String newValue) {
		boolean valid = true;
		
		try {
			int value = Integer.parseInt(newValue);
			if (value <1 || value > 1500000000)
				valid = false;
		} catch (NumberFormatException e) {
			valid = false;
		}
		return valid;	
		}
	
	

	
	
		
	}
	
	

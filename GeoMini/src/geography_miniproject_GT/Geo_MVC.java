package geography_miniproject_GT;

import javafx.application.Application;
import javafx.stage.Stage;

public class Geo_MVC extends Application {
	private Geo_Model model;
	private Geo_View view;
	private Geo_Controller controller;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		model = new Geo_Model ();
		view = new Geo_View ( primaryStage, model);
		controller = new Geo_Controller (view, model);
		view.start();
		
		

	}

	public static void main(String[] args) {
		launch ();
		
	}

}

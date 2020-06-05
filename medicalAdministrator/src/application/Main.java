package application;

import control.DoctorsList;
import dao.DBUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import presentation.DoctorsListP;

public class Main extends Application {

	public static void main(String[] args) {
		DBUtil.setBase("soins");
		DBUtil.setHost("127.0.0.1");
		DBUtil.setNumPort("5432");
		DBUtil.setUsername("postgres");
		DBUtil.setPassword("usr");
		launch(args);
	}

	@Override
	public void start(Stage mainStage) throws Exception {
		DoctorsList doctorsList = new DoctorsList (new DoctorsListP (mainStage)) ;
		
		TabPane tabs = new TabPane();
		tabs.getTabs().addAll(doctorsList.getPresentation());
		mainStage.setScene(new Scene(tabs));
		mainStage.setTitle("Medical Administrator");
		mainStage.setMaximized(true);
		mainStage.show();
	}

}

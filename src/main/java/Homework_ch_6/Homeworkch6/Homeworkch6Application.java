package Homework_ch_6.Homeworkch6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Homeworkch6Application extends Application{

	public static void main(String[] args) {
		//SpringApplication.run(Homeworkch6Application.class, args);
                launch(args);
	}

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/Student_Transaction.fxml"));
        loader.setControllerFactory(SpringApplication.run(Homeworkch6Application.class)::getBean);
        Pane pane=loader.load();
        Scene scene=new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

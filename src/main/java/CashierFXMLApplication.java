import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lombok.Setter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CashierFXMLApplication extends Application {

    @Setter
    private static ConfigurableApplicationContext springContext;

    @Override
    public void start(Stage primaryStage) {
        // Initialize Spring context if needed
        if (springContext == null) {
            springContext = new AnnotationConfigApplicationContext(AppConfig.class);
        }

        // Set up your JavaFX scene and stage here

        // Example:
        primaryStage.setTitle("Cashier Application");
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    @Override
    public void stop() {
        // Close Spring context if needed
        if (springContext != null) {
            springContext.close();
        }
    }

}

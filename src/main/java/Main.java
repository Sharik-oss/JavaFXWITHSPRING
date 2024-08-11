import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("Main")
public class Main {

    public static void main(String[] args) {
        // Start Spring Boot and get the application context
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        // Initialize JavaFX separately
        launchJavaFXApplication(context);
    }

    private static void launchJavaFXApplication(ConfigurableApplicationContext context) {
        // Ensure JavaFX is launched on the Application Thread
        Application.launch(CashierFXMLApplication.class, new String[] { "springContext=" + context.getId() });
    }
}

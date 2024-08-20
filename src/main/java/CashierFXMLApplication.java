import controllers.ControlPanel;
import controllers.HookahController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repo.DeviceRepository;
import services.DeviceServices;

@RequiredArgsConstructor
public class CashierFXMLApplication extends Application {

    @Setter
    private static ConfigurableApplicationContext springContext;

    private static ControlPanel controlPanel = new ControlPanel();

    @Override
    public void start(Stage primaryStage) {
        VBox mainVBox = new VBox();
        Scene mainScene = new Scene(mainVBox);
        // Initialize Spring context if needed
        if (springContext == null) {
            springContext = new AnnotationConfigApplicationContext(AppConfig.class);
        }
        mainScene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.F7){
                controlPanel.openControlPanel();
            }
        });
        primaryStage.setScene(mainScene);
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

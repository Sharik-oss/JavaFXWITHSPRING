package controllers;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Controller;
import repo.DeviceRepository;
import services.DeviceServices;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Controller
@RequiredArgsConstructor
public class ControlPanel {

    @Autowired
    private DeviceServices deviceServices;
    private final Stage stage = new Stage();

    public ControlPanel(DeviceServices deviceServices){
        this.deviceServices = deviceServices;
    }



    public void openControlPanel() {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);



        Button startButton = new Button("Add new device");
        startButton.setAlignment(Pos.CENTER);
        vBox.getChildren().add(startButton);
        startButton.setOnAction(ActionEvent -> addDevice());


        stage.setWidth(800);
        stage.setHeight(500);
        stage.setScene(scene);
        stage.setTitle("Control panel");
        stage.setResizable(false);
        stage.show();
    }

    public void addDevice() {
        HookahController hookahController = new HookahController();
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        Scene addDeviceScene = new Scene(gridPane);

        Label deviceName = new Label("Device name: ");
        double fontSize = 25.0;
        deviceName.setFont(Font.font(fontSize));
        TextField name = new TextField();

        Label duration30Min = new Label("Price for 30 min: ");
        duration30Min.setFont(Font.font(fontSize));
        TextField duration30 = new TextField();

        Label duration1Hour = new Label("Price for 1 hour: ");
        duration1Hour.setFont(Font.font(fontSize));
        TextField duration1 = new TextField();

        Label duration3Hours = new Label("Price for 3 hours: ");
        duration3Hours.setFont(Font.font(fontSize));
        TextField duration3 = new TextField();

        Button addButton = new Button("Add");
        addButton.setFont(Font.font(fontSize));
        addButton.setMinWidth(200);
        addButton.setMinHeight(50);

        gridPane.add(deviceName, 0, 0);
        gridPane.add(name, 1, 0);

        gridPane.add(duration30Min, 0, 1);
        gridPane.add(duration30, 1, 1);

        gridPane.add(duration1Hour, 0, 2);
        gridPane.add(duration1, 1, 2);

        gridPane.add(duration3Hours, 0, 3);
        gridPane.add(duration3, 1, 3);

        gridPane.add(addButton, 0, 4);

        addButton.setOnAction(ActionEvent -> getProperties(name.getText(), Double.parseDouble(duration30.getText()), Double.parseDouble(duration1.getText()), Double.parseDouble(duration3.getText())));

        stage.setScene(addDeviceScene);
    }

    private void getProperties(String name, Double min30, Double hour1, Double hour3) {
        Device newDevice = new Device(name, min30, hour1, hour3);
        deviceServices.addDevice(newDevice);
        System.out.println(newDevice);
    }
}

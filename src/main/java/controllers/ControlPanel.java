package controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
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

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Controller
@RequiredArgsConstructor
public class ControlPanel  {
    private Double fontSize = 25.0;
    private DeviceRepository deviceRepository = new DeviceRepository() {
        @Override
        public void deleteDeviceById(Long id) {

        }

        @Override
        public boolean existsById(Long id) {
            return false;
        }

        @Override
        public Device findDeviceById(Long id) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Device> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Device> List<S> saveAllAndFlush(Iterable<S> entities) {
            return List.of();
        }

        @Override
        public void deleteAllInBatch(Iterable<Device> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Device getOne(Long aLong) {
            return null;
        }

        @Override
        public Device getById(Long aLong) {
            return null;
        }

        @Override
        public Device getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Device> List<S> findAll(Example<S> example) {
            return List.of();
        }

        @Override
        public <S extends Device> List<S> findAll(Example<S> example, Sort sort) {
            return List.of();
        }

        @Override
        public <S extends Device> List<S> saveAll(Iterable<S> entities) {
            return List.of();
        }

        @Override
        public List<Device> findAll() {
            return List.of();
        }

        @Override
        public List<Device> findAllById(Iterable<Long> longs) {
            return List.of();
        }

        @Override
        public <S extends Device> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Device> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(Device entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Device> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public List<Device> findAll(Sort sort) {
            return List.of();
        }

        @Override
        public Page<Device> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Device> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Device> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Device> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Device> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Device, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };
    private DeviceServices deviceServices = new DeviceServices(deviceRepository);
    Stage stage = new Stage();


    public void openControlPanel() {
        VBox vBox = new VBox();

        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);
        // Check if the table is empty
        boolean isEmpty = !deviceRepository.existsById(1L); // Check if a device with ID 1 exists

        if (isEmpty) {
            Button startButton = new Button("Add new device");
            startButton.setAlignment(Pos.CENTER);
            vBox.getChildren().add(startButton);
            startButton.setOnAction(ActionEvent -> addDevice());
        } else {
            System.out.println("Device table has records.");
        }

        stage.setWidth(800);
        stage.setHeight(800);
        stage.setScene(scene);
        stage.setTitle("Control panel");
        stage.setResizable(false);
        stage.show();
    }


    public void addDevice(){
        GridPane gridPane = new GridPane();
        gridPane.paddingProperty().set(Insets.EMPTY);
        Scene addDeviceScene = new Scene(gridPane);

        Label deviceName = new Label("Device name: ");
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


        gridPane.add(deviceName, 0, 0);
        gridPane.add(name, 1, 0);

        gridPane.add(duration30Min, 0, 1);
        gridPane.add(duration30, 1, 1);

        gridPane.add(duration1Hour, 0, 2);
        gridPane.add(duration1, 1, 2);

        gridPane.add(duration3Hours, 0, 3);
        gridPane.add(duration3, 1, 3);

        gridPane.add(addButton, 0, 4);
        stage.setScene(addDeviceScene);
    }

}

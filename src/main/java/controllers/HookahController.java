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
import model.Hookah;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Controller;
import repo.HookahRepository;
import services.HookahServices;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Controller
public class HookahController {

    private final HookahRepository hookahRepository = new HookahRepository() {
        @Override
        public void deletePlaystationById(Long id) {

        }

        @Override
        public Hookah findHookahById(Long id) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Hookah> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Hookah> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Hookah> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Hookah getOne(Long aLong) {
            return null;
        }

        @Override
        public Hookah getById(Long aLong) {
            return null;
        }

        @Override
        public Hookah getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Hookah> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Hookah> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public <S extends Hookah> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public List<Hookah> findAll() {
            return null;
        }

        @Override
        public List<Hookah> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends Hookah> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Hookah> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(Hookah entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Hookah> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public List<Hookah> findAll(Sort sort) {
            return null;
        }

        @Override
        public Page<Hookah> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Hookah> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Hookah> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Hookah> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Hookah> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Hookah, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };
    private HookahServices hookahServices = new HookahServices(hookahRepository);
    Stage stage = new Stage();
    public void openHookahPanel(Long id) {
        VBox vBox = new VBox();

        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);
        // Check if the table is empty
        boolean isEmpty = !hookahRepository.existsById(1L); // Check if a device with ID 1 exists

        if (isEmpty) {
            Button startButton = new Button("Add new Hookah");
            startButton.setAlignment(Pos.CENTER);
            vBox.getChildren().add(startButton);
            startButton.setOnAction(ActionEvent -> addHookah(id));
        } else {
            System.out.println("Device table has records.");
        }

        stage.setWidth(800);
        stage.setHeight(500);
        stage.setScene(scene);
        stage.setTitle("Hookahs");
        stage.setResizable(false);
        stage.show();
    }


    public void addHookah(Long id){
        double fontSize = 25.0;
        GridPane hookahGrid = new GridPane();
        hookahGrid.setVgap(10);
        Scene addHookahScene = new Scene(hookahGrid);

        Label flavorLabel = new Label("Flavor: ");
        flavorLabel.setFont(Font.font(fontSize));
        TextField flavor = new TextField();

        Label priceLabel = new Label("Price: ");
        priceLabel.setFont(Font.font(fontSize));
        TextField price = new TextField();


        Button hookahButton = new Button("Add Hookah");
        hookahButton.setFont(Font.font(fontSize));
        hookahButton.setOnAction(ActionEvent -> getHookahProperties(flavor.getText(), Double.parseDouble(price.getText()), id));


        hookahGrid.add(flavorLabel, 0, 0);
        hookahGrid.add(flavor, 1, 0);
        hookahGrid.add(priceLabel, 0, 1);
        hookahGrid.add(price, 1, 1);
        hookahGrid.add(hookahButton, 0, 2);


        stage.setScene(addHookahScene);

    }





    private void getHookahProperties(String name, Double price, Long id){

    }

}

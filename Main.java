package sample;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class Main extends Application
{
    private LeftLayout leftLayout;
    private BottomLayout bottomLayout;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Scene scene;
        BorderPane layout = new BorderPane();

        layout.setStyle("-fx-background-color: #E8E8E8");

        // layouts initializing
        leftLayout = new LeftLayout();
        bottomLayout = new BottomLayout();

        // bottom creation
        HBox theBottomLayout = bottomLayout.getLayout();
        layout.setBottom(theBottomLayout);

        // left creation
        VBox theLeftLayout = leftLayout.getLayout();
        layout.setLeft(theLeftLayout);

        scene = new Scene(layout, 530, 550);
        primaryStage.setTitle("Task Manager");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
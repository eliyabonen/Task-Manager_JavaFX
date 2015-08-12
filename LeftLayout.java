package sample;

import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import java.util.ArrayList;

public class LeftLayout
{
    private VBox layout;
    private static ListView<String> listView;
    private static TaskList taskList;
    private static ArrayList<String> list;
    public static String szSelectedItem;

    public LeftLayout()
    {
        layout = new VBox();
        szSelectedItem = new String();
        list = new ArrayList<>();

        // initializing and getting the tasks list
        taskList = new TaskList();
        taskList.getTasks();
        list = taskList.getList();

        listView = new ListView<>();

        // setting the values from the arraylist to the listview
        for (int i = 3; i < list.size(); i++)
            listView.getItems().add(list.get(i));

        listView.setPrefSize(500, 460);
        listView.setOnMouseClicked(e -> szSelectedItem = listView.getSelectionModel().getSelectedItem());

        layout.getChildren().addAll(listView);
        layout.setMargin(listView, new Insets(20, 0, 0, 20));
    }

    public static void updateListView()
    {
        list = taskList.getList();

        listView.getItems().remove(0, listView.getItems().size());

        for (int i = 3; i < list.size(); i++)
            listView.getItems().add(list.get(i));
    }

    public VBox getLayout()
    {
        return layout;
    }
}

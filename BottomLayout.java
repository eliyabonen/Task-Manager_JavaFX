package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import java.io.IOException;

public class BottomLayout
{
    private HBox layout;
    private Button endTask, refresh;

    public BottomLayout()
    {
        layout = new HBox();

        refresh = new Button("Refresh");
        refresh.setOnAction(e -> refreshClicked());

        endTask = new Button("End task");
        endTask.setOnAction(e -> endTaskClicked());

        layout.getChildren().addAll(refresh, endTask);
        layout.setAlignment(Pos.CENTER_RIGHT);

        layout.setMargin(refresh, new Insets(0, 370, 25, 0));
        layout.setMargin(endTask, new Insets(0, 25, 25, 0));
    }

    private void endTaskClicked()
    {
        try
        {
            Runtime.getRuntime().exec("cmd /c taskkill /im " + LeftLayout.szSelectedItem);

            TaskList.getTasks();
            LeftLayout.updateListView();
        }
        catch(IOException e) {}
    }

    private void refreshClicked()
    {
        TaskList.getTasks();
        LeftLayout.updateListView();
    }

    public HBox getLayout()
    {
        return layout;
    }
}

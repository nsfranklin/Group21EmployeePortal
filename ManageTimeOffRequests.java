import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class ManageTimeOffRequests {

    public static void manageRequests(){
        Stage window = new Stage();
        Pane pane = new Pane();
        Label title = new Label("Manage Time-Off Requests");
        title.setStyle("-fx-font-size: 32pt;");
        //title.setStyle("-fx-font-weight: bold;");
        title.setLayoutX(20); title.setLayoutY(20);

        TableView<Requests> table = new TableView<>();
        table.setLayoutX(0); table.setLayoutY(100);

        TableColumn<Requests, String> typeColumn = new TableColumn<>("Type of Request");
        typeColumn.setMinWidth(130);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("timeOffType"));

        TableColumn<Requests, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setMinWidth(350);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Requests, Date> startDateColumn = new TableColumn<>("Start Date");
        startDateColumn.setMinWidth(200);
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));

        TableColumn<Requests, Date> endDateColumn = new TableColumn<>("End Date");
        endDateColumn.setMinWidth(200);
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        table.setItems(addRequests());
        table.getColumns().addAll(typeColumn, descriptionColumn, startDateColumn, endDateColumn);

        Button approve = new Button("Approve Request");
        approve.setMinWidth(30); approve.setMinHeight(70); //delete.setStyle();
        approve.setOnAction(event -> {
            try {
                boolean del = ConfirmBox.yesOrNo("Delete Request?", "Are you sure you want to delete this request?");
                if (!del) return;
                else updateTable(table);
            }catch (IOException e){}
        });

        approve.setLayoutX(600); approve.setLayoutY(15);

        pane.getChildren().addAll(title, table, approve);
        Scene scene = new Scene(pane);
        window.setScene(scene);
        window.show();
    }

    private static ObservableList<Requests> addRequests (){
        ObservableList<Requests> requests = FXCollections.observableArrayList();
        //Sample data
        requests.add(new timeOff(new Date(), 100, "holiday", new Date(), new Date(), "Bangladesh", "a"));
        requests.add(new timeOff(new Date(), 200, "sickness", new Date(), new Date(), "Cold", "b"));
        requests.add(new timeOff(new Date(), 300, "other", new Date(), new Date(), "dont know", "a"));
        requests.add(new timeOff(new Date(), 200, "sickness", new Date(), new Date(), "Cold", "b"));
        requests.add(new timeOff(new Date(), 300, "other", new Date(), new Date(), "dont know", "a"));
        return requests;

        // Method needs to get all Employee records from file with required instance variables
    }

    public static void updateTable(TableView<Requests> table) throws IOException {
        ObservableList<Requests> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();
        //Employee emp = table.getSelectionModel().getSelectedItem();
        productSelected.forEach(allProducts::remove);
        moveFromRequestsListToApprovedRequestsList();
    }

    public static void moveFromRequestsListToApprovedRequestsList(){
        // Method should delete the Request object from the Requests List, AND THEN ADD the same one to Approved Requests List!!
    }
}

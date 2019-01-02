import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class ListViewSample1 extends Application {
	
	String s = new String();
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ListView<String> list = new ListView<String>();
		String states = "Alabama,Alaska,Arizona,Arkansas,California,"
				+ "Colorado,Connecticut,Delaware,Florida,Georgia,Hawaii,"
				+ "Idaho,Illinois,Indiana,Iowa,Kansas,Kentucky,Louisiana,"
				+ "Maine,Maryland,Massachusetts,Michigan,Minnesota,"
				+ "Mississippi,Missouri,Montana,Nebrask,Nevada,"
				+ "New Hampshire,New Jersey,New Mexico,New York,"
				+ "North Carolina,North Dakota,Ohio,Oklahoma,Oregon,"
				+ "Pennsylvania,Rhode Island,South Carolina,South Dakota,"
				+ "Tennessee,Texas,Utah,Vermont,Virginia,Washington,"
				+ "West Virginia,Wisconsin,Wyoming,District of Columbia,"
				+ "Puerto Rico,Guam,American Samoa,U.S.Virgin Islands,"
				+ "Northern Mariana Islands";

		String[] c = states.split(",");
		ArrayList<String> courseList = new ArrayList<>(Arrays.asList(c));
		ObservableList<String> items = FXCollections.observableArrayList(courseList);
		list.setItems(items);

		list.setPrefWidth(100);
		list.setPrefHeight(300);
		list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		
		
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
				ObservableList<String> tokens = list.getSelectionModel().getSelectedItems();
//				for (String s : tokens) {
					s = new_val;
//				}
			}
		});

		Scene scene = new Scene(list);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

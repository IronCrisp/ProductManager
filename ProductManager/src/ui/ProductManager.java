package ui;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ProductManager extends Application {
	
	// JavaFX19 Button controller declarations for the main menu interface.
	private Button addProductButton = new Button("Add product");
	private Button deleteProductButton = new Button("Delete product");
	private Button viewAllProductsButton = new Button("View products");
	
	// Main Interface with the manual use of JavaFX19.
	@Override
	public void start(Stage primaryStage) {
		
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		
		gridPane.add(addProductButton, 0, 0);
		gridPane.add(deleteProductButton, 4, 0);
		gridPane.add(viewAllProductsButton, 8, 0);
		
		viewAllProductsButton.setOnAction(j -> {
			try {
				viewTable(primaryStage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		addProductButton.setOnAction(f -> {
			try {
				addProduct(primaryStage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		deleteProductButton.setOnAction(x -> {
			try {
				deleteProduct(primaryStage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		gridPane.setAlignment(Pos.CENTER);
		
		// Invokes the scene onto the main stage.
		Scene scene = new Scene(gridPane, 400, 250);
		primaryStage.setTitle("Product Manager");
		primaryStage.setScene(scene);
		
		// Project icon
		Image icon = new Image(getClass().getResourceAsStream("/icon.png"));
		primaryStage.getIcons().add(icon);
		
		// Shows the main interface on the screen.
		primaryStage.show();
	}
	
	// Automatically connects to SQL database server to output the table of products.
	public void viewTable(Stage tableStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("table.fxml"));
		Scene scene = new Scene(root);
		tableStage.setScene(scene);
		tableStage.setTitle("Product Viewer");
		tableStage.show();
	}
	
	// Creates a new product and stores it on the database
	private void addProduct(Stage newProductStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("addProduct.fxml"));
		Scene scene = new Scene(root);
		newProductStage.setScene(scene);
		newProductStage.setTitle("Product Creator");
		newProductStage.show();
	}
	
	// Removes a product by prompting the ID
	private void deleteProduct(Stage deleteProductStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("deleteProduct.fxml"));
		Scene scene = new Scene(root);
		deleteProductStage.setScene(scene);
		deleteProductStage.setTitle("Product Deleter");
		deleteProductStage.show();
	}
	
	// launches the main interface
	public static void main(String[] args) {
	    launch(args);
	}
}

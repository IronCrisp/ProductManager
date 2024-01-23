package databases;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ui.ProductManager;

public class ProductDB implements Initializable {
	
	// Controller skeleton for the use of the table management interface using FXML.
    @FXML
	private Button button_return;

    @FXML
    private Button button_saveProduct;
    
    @FXML
    private Button button_deleteProduct;
	
	@FXML
	private TextField txt_id;
	
	@FXML
	private TextField txt_title;
	
	@FXML
	private TextField txt_releaseDate;
	
	@FXML
	private TextField txt_price;
	
	@FXML
	private TextField txt_genre;
	
	@FXML
	private TextField txt_rating;
	
	@FXML
	private TableColumn<Product, Integer> col_id;
	
	@FXML
	private TableColumn<Product, String> col_title;
	
	@FXML
	private TableColumn<Product, String> col_releaseDate;
	
	@FXML
	private TableColumn<Product, Character> col_rating;
	
	@FXML
	private TableColumn<Product, Double> col_price;
	
	@FXML
	private TableColumn<Product, String> col_genre;
	
	@FXML
	private TableView<Product> table_products;
	
	// Needed elements to output the list on the table
	ObservableList<Product> listOfProducts;
	Connection connection = null;
	PreparedStatement prepSt = null;
	
	// Makes a connection to SQL database. You can modify this so that the connection connects to a different database.
	public static Connection ConnectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/productmanager", "root", "3642427");
			JOptionPane.showMessageDialog(null, "Connection Successful!");
			return con;
			}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	// Reconnects to SQL database, then with a SQL query statement selects the table of products to add on the list
	// and then returns the list to the table interface. The table of products has 6 columns.
	public static ObservableList<Product> getProducts() {
		Connection con = ConnectDB();
		ObservableList<Product> list = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM productmanager.products");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(Integer.parseInt(rs.getString("id")), rs.getString("title"),
						rs.getString("releaseDate"), Double.parseDouble(rs.getString("price")), rs.getString("genre"), (rs.getString("rating").charAt(0))));
			}
		}
		catch (Exception e) {
			
		}
		return list;
	}
	
	// Registers a product with six empty text fields required for the user to fill in and store the product data into the SQL table.
	public void addProduct() {
		connection = ConnectDB();
		String sql = "insert into products (id, title, releaseDate, price, genre, rating)values(?, ?, ?, ?, ?, ? )";
		try {
			prepSt = connection.prepareStatement(sql);
			prepSt.setString(1, txt_id.getText());
			prepSt.setString(2, txt_title.getText());
			prepSt.setString(3, txt_releaseDate.getText());
			prepSt.setString(4, txt_price.getText());
			prepSt.setString(5, txt_genre.getText());
			prepSt.setString(6, txt_rating.getText());
			prepSt.execute();
			JOptionPane.showMessageDialog(null, "The product has been added.");
			updateTable();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	// Deletes a product by prompting the ID on a single text field. This was done with the use of
	// making a SQL query statement.
	public void deleteProduct() {
		connection = ConnectDB();
		String sql = "delete from products where id = ?";
		try {
			prepSt = connection.prepareStatement(sql);
			prepSt.setString(1, txt_id.getText());
			prepSt.execute();
			JOptionPane.showMessageDialog(null, "The product has been deleted");
			updateTable();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	// Function method to swap the current stage to the main menu stage.
	@FXML
	private void returnToStart() {
		Stage stage = (Stage) button_return.getScene().getWindow();
		stage.close();
		Stage primaryStage = new Stage();
		ProductManager productManager = new ProductManager();
		productManager.start(primaryStage);
	}
	
	// Updates the contents of the table after the SQL connection has been established.
	public void updateTable() {
		col_id.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
		col_title.setCellValueFactory(new PropertyValueFactory<Product, String>("title"));
		col_releaseDate.setCellValueFactory(new PropertyValueFactory<Product, String>("releaseDate"));
		col_price.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
		col_genre.setCellValueFactory(new PropertyValueFactory<Product, String>("genre"));
		col_rating.setCellValueFactory(new PropertyValueFactory<Product, Character>("rating"));
		listOfProducts = getProducts();
		table_products.setItems(listOfProducts);
	}
	
	// Initializes table contents from the SQL database to the interface with the
	// use of function calling the updateTable method to avoid repetitive lines of code.
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		updateTable();
	}
}
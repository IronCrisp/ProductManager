# ProductManager
Video game product manager with the use of Java, JavaFX19, fxml and JDBC11 driver for SQL database server connections.

Main Project objectives:

- Making a program that manages listed video game products so that the
products are stored into a generated SQL database server.

- Code must be written neatly and simple as possible as well avoiding unnecessary repetitive
lines of code.

- Offering straight to the point documentation for every function and methods used.

- The exclusive use of the JavaFX library and its other applications (such as fxml.)

- A unique flexible interface allowing the user to navigate to various menus in a single stage instance
as well swapping to the main menu without having to rerun the program.

If you want to run the program without lib path and module errors, use these run configurations
as VM arguments: --module-path "C:\javafx-sdk-19\lib" --add-modules javafx.controls,javafx.fxml

Lib and drivers to debug or compile the source code:

JavaFX19 library may be exclusively required to run this program (through source code.)
mysql-connector-java-8.0.11.jar driver is used to connect to SQL database for this program.

You can edit the SQL connection through the ProductDB.java class. The SQL query is included
in the "databases" package so that you can run the table on a different database server of your
own.

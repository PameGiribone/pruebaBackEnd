package com.backend.mesa;
//Les pedimos que, de manera individual, creen una tabla de figuras donde se guarden los tipos de figuras. Por ejemplo:
//Figura: circulo
// Color: rojo
//Pista: No nos olvidemos que el ID es obligatorio.
//Por lo tanto, les pedimos que:
//Creen una conexión a la base de datos.
//Inserten 2 círculos y 3 cuadrados de distinto color.
//Creen una query para ver los círculos color rojo.
//Mostrar todas las figuras en pantalla con un ResultSet y un System.out.println.
//¡Manos a la obra!

import org.apache.log4j.Logger;

import java.sql.*;

public class Figura {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Logger LOGGER = Logger.getLogger(Figura.class);

        String create = "DROP TABLE IF EXISTS FIGURAS; CREATE TABLE FIGURAS(ID INT AUTO_INCREMENT PRIMARY KEY, " +
                "FIGURA VARCHAR(50) NOT NULL, COLOR VARCHAR(50) NOT NULL)";

        String insert = "INSERT INTO FIGURAS(FIGURA, COLOR) VALUES ('Circulo', 'Verde'), ('Circulo', 'Rojo'), ('Cuadrado', 'Azul'), ('Cuadrado', 'Amarillo'),('Cuadrado', 'Violeta') ";

        Connection connection = null;
        try {
            connection = getConnection();

            Statement statement = connection.createStatement();
            statement.execute(create);

            statement.execute(insert);

            ResultSet resultSet = statement.executeQuery("SELECT * FROM FIGURAS WHERE COLOR = 'Rojo' AND FIGURA = 'Circulo'");
           //ResultSet resultSet = statement.executeQuery("SELECT * FROM FIGURAS");


            while (resultSet.next()){
                LOGGER.info("ID: "+resultSet.getInt(1) + " -Figura: " +resultSet.getString("figura") + "- Color:"+resultSet.getString("color") );
            }

        } catch (Exception exception){
            exception.printStackTrace();
            LOGGER.error(exception.getMessage());

        }
        finally {
            try {
                connection.close();
            } catch (Exception exception) {
                LOGGER.error(exception.getMessage());
            }
        }

    }


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //Indicar que driver vamos a usar
        Class.forName("org.h2.Driver");
         return DriverManager.getConnection("jdbc:h2:~/clase8mesas", "sa", "sa");
        //jdbc:h2:mem:testdb en memoria
    }
}

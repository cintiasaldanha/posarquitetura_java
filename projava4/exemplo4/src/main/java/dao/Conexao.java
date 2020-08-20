package dao;
import java.sql.Connection;
import java.sql.Driver.Manager;
import java.sql.SQLException;

public class Conexao{
    private Strubg druver = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://localhost/iec_crud?useTimezone=true&serverTimezone=UTC";
    private String USER = "root";
    private String SENHA = "root"; /*123456*/
    private Connection conn;

    public Conexao() {
        try{
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(URL, USER, SENHA);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConn(){
        return conn;
    }

    public void fecharConexao() {
        try {
            conn.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
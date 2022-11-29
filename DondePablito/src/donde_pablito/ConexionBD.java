package donde_pablito;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class ConexionBD {
    private Connection con;
    private ResultSet res;
    private Statement sql;
    public Connection getCon() {
        return con;
    }//Fin del metodo getCon
    public void setCon(Connection con, String database) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //Manda llamra la conexion con un driver de java
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, "root", ""); //Manda llamar las bases de datos para que se conecten
            this.con = con; //le da valor a la variable con como la conexion
        } catch (Exception e) {
            System.out.println(e);
        }
    }//Final metodo setCon
    public ResultSet getRs() {
        return res;
    }//Final metodo getrs
    public void setRs(String devcode) {
        try {
            setSql();
            res = getSql().executeQuery(devcode);
        } catch (Exception e) {
        }
    }
    public Statement getSql() {
        return sql;
    }
    public void setSql() {
        try {
            this.sql = (Statement) con.createStatement(); //si no funca se castea
        } catch (Exception e) {
        }
    }
    /*Aqui terminamos de estrablecer los parametros a las variables y
     * pasamos a hacer otra cosa
     */
    //METODO PARA CONECTAR
    public void databaseconect(String database) {
        try {
            setCon(con, database);
            getCon();
            System.out.println("La conexion se realizo con exito");
        } catch (Exception e) {
            System.out.println("La conexion fallo");
        }
    }
    //METODO PARA DESCONECTAR
    public void dbdesc() {
        try {
            con.close();
            System.out.println("Base de datos desconectada");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //METODO PARA INSERTAR
    public void databaseinse(String database) {
        try {
            setSql();
            getSql().executeUpdate(database);//obtiene el resultado, mandando llamar una
            dbdesc();
        } catch (Exception e) {
            System.out.println("Error al insertar datos");
        }
    }
   
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import net.proteanit.sql.DbUtils;

public class Bdatos {

	Connection con=null;
	Statement stat=null;
	Bdatos(){
		try {
			Class.forName("org.sqlite.JDBC");
			con=DriverManager.getConnection("jdbc:sqlite:Busquedas.sqlite");
			System.out.println("Conectado a base de datos");
			
		} catch (Exception e) {
			System.out.println("Error"+e.getMessage());
		}
	}
	
	
	public void reiniciarBD() {
		try {
			Statement st=con.createStatement();
			String query="DELETE FROM Estaciones";
			String query2="DELETE FROM DiaRegistrado3";
			st.executeUpdate(query);
			st.executeUpdate(query2);
			System.out.println("Base de datos reiniciada");
		}
		catch (Exception e){
			System.out.println("Error"+e.getMessage());
		}
		
	}
	public void actualizarEstaciones(String codigo) {
		try {
			Statement st=con.createStatement();
			String query="DELETE FROM Estaciones WHERE codarp='"+codigo+"'";
			String query2="DELETE FROM DiaRegistrado3 WHERE codarp='"+codigo+"'";
			st.executeUpdate(query);
			st.executeUpdate(query2);
			
		} catch (Exception e) {
			System.out.println("Error"+e.getMessage());
		}
		
	}
	public void listEstaciones(){
		try {
			this.stat=con.createStatement();
			ResultSet rs= stat.executeQuery("SELECT * FROM Estaciones");
			while(rs.next()) {
				String codarp=rs.getString("codarp");
				String ciudad=rs.getString("Ciudad");
				
				System.out.println(codarp+" "+ciudad);
			}
		} catch (Exception e) {
			System.out.println("Error"+e.getMessage());
		}
	}
	
	
	
	public void insertarEstaciones(String codigo, String ciudad) {
		try {
			Statement st=con.createStatement();
			String query="INSERT INTO Estaciones(codarp,Ciudad) VALUES ('"+codigo+"','"+ciudad+"')";
			st.executeUpdate(query);
			System.out.println("Agregado");
		} catch (Exception e) {
			System.out.println("Error"+e.getMessage());
		}
	}
	
	public void insertarDias(int dia, int mes, int anyo, int tempHigh, int tempAvg,int tempLow, int rocioHigh, int rocioAvg, int rocioLow, int HumedadHigh, int HumedadAvg, int HumedadLow,double precip,String ciudad) {
		try {
			Statement sd=con.createStatement();
			String query= "INSERT INTO DiaRegistrado3(Fecha,TempHigh,TempAvg,TempLow,RocioHigh,RocioAvg,RocioLow,HumedadHigh,HumedadAvg,HumedadLow,Precip,codarp) VALUES ('"+anyo+"-"+mes+"-"+dia+"',"+tempHigh+","+tempAvg+","+tempLow+","+rocioHigh+","+rocioAvg+","+rocioLow+","+HumedadHigh+","+HumedadAvg+","+HumedadLow+","+precip+", (SELECT codarp FROM Estaciones WHERE Ciudad='"+ciudad+"'))";
			sd.executeUpdate(query);
			System.out.println("OK");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void cerrarConexion(){
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}

package dao;

import java.sql.*;



public class Conexion {
	
	private static Conexion instancia;
	public Conexion getInstancia(){
		if(instancia==null){
			instancia=new Conexion();
		}
		return instancia;
	}
   
   static String login = "root";
   static String password = "abc";
   static String url = "jdbc:mysql://localhost:3306/tp_java";

   Connection conn = null;

   /** Constructor de DbConnection */
   public Conexion() {
      try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(url,login,password);

         if (conn!=null){
            System.out.println("Conexión a base de datos OK");
         }
      }
      catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }catch(Exception e){
         System.out.println(e);
      }
   }
   /**Permite retornar la conexión*/
   public Connection getConnection(){
	   try {
			if(conn==null ){
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn=DriverManager.getConnection(url,login,password);	
			}
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

   public void desconectar(){
	   try {
			if(conn!=null && !conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
   }

}

package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;





import modelo.Electrodomestico;
import modelo.Lavarropa;
import modelo.Televisor;

import com.mysql.jdbc.Driver;

/**
 * Clase que permite el acceso a la base de datos
 */
public class TelevisorDao
{

	
	public void registrarTelevisor(Televisor tele)
	{
		Conexion conex= new Conexion();
		String sin;
		try {
			Statement sentencia = conex.getInstancia().getConnection().createStatement();
			
			if(tele.isSintonizador()){
				sin = "Si";
			}else {sin = "No";
			
			}
			sentencia.executeUpdate("INSERT INTO electrodomesticos(peso, precio_base, color, consumo_ener, carga, resolucion, sintonizador) VALUES ("
					+tele.getPeso()+", "+tele.getPrecioBase()+", '"
					+tele.getColor().getColor()+"', '"+tele.getConsumoEnergetico().getConsumoEner()+"',"+"null," + tele.getResolucion()+", '"
					+sin+ "')");
			//JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			sentencia.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			//JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}

	public List<Electrodomestico> buscarTelevisor() 
	{
		Conexion conex= new Conexion();
		List<Electrodomestico> electrodomesticos = new ArrayList<Electrodomestico>();
		
		boolean existe=false;
		try {
			//Statement estatuto = conex.getConnection().createStatement();
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM electrodomesticos where carga IS NULL");
			//consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				Televisor tele;
				tele= new Televisor(Double.parseDouble(res.getString("precio_base")),Double.parseDouble(res.getString("peso")),
						res.getString("color"), res.getString("consumo_ener").charAt(0), Boolean.parseBoolean(res.getString("sintonizador")), Double.parseDouble(res.getString("resolucion")) );
				
				tele.setIdElectrodomestico(Integer.parseInt(res.getString("id_electrodomestico")));
				electrodomesticos.add(tele);
			
			} 
			res.close();
			conex.desconectar();
					
					
			} catch (SQLException e) {
					//JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return electrodomesticos;
			}
			else  return null;				
	}

	public void modificarTelevisor(Televisor tele) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE electrodomesticos SET precio_base= ? ,peso = ? , color=? , consumo_ener=? , resolucion= ? , sintonizador= ? WHERE id_electrodomestico=" + tele.getIdElectrodomestico();
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setDouble(1, tele.getPrecioBase());
            estatuto.setDouble(2, tele.getPeso());
            estatuto.setString(3, tele.getColor().getColor());
            char c = tele.getConsumoEnergetico().getConsumoEner();
            String con = String.valueOf(c);
            estatuto.setString(4, con);
            estatuto.setDouble(5, tele.getResolucion()); 
            boolean s = tele.isSintonizador();            
            estatuto.setString(6, Boolean.toString(s));
            estatuto.executeUpdate();
          //JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
         
        }catch(SQLException	 e){
            System.out.println(e);
            //JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public void eliminarLavarropa(Televisor tele)
	{
		Conexion conex= new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("DELETE FROM electrodomesticos WHERE id_electrodomestico= " + tele.getIdElectrodomestico());
           // JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}
	
	public Televisor GetTelevisorPorId(int idTelevisor) 
	{
		Conexion conex= new Conexion();
		Televisor tele = null;
		
		boolean existe=false;
		try {
			//Statement estatuto = conex.getConnection().createStatement();
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM electrodomesticos where id_electrodomestico=?");
			consulta.setInt(1, idTelevisor);
			ResultSet res = consulta.executeQuery();
			if(res.next()){
				existe=true;
				tele= new Televisor(Double.parseDouble(res.getString("precio_base")),Double.parseDouble(res.getString("peso")),
						res.getString("color"), res.getString("consumo_ener").charAt(0),Boolean.parseBoolean(res.getString("sintonizador")) , Double.parseDouble(res.getString("resolucion")));
			
				tele.setIdElectrodomestico(Integer.parseInt(res.getString("id_electrodomestico")));
				
			} 
			res.close();
			conex.desconectar();
					
					
			} catch (SQLException e) {
					//JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return tele;
			}
			else return null;				
	}

}

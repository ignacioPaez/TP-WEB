package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Electrodomestico;
import modelo.Lavarropa;



/**
 * Clase que permite el acceso a la base de datos
 */
public class LavarropaDao
{

	//NegocioLavarropa negLavarropa = new  NegocioLavarropa();
	
	public void registrarLavarropa(Lavarropa lava)
	{
		Conexion conex= new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			
			estatuto.executeUpdate("INSERT INTO electrodomesticos(peso, precio_base, color, consumo_ener, carga, resolucion, sintonizador) VALUES ("
					+lava.getPeso()+", "+lava.getPrecioBase()+", '"
					+lava.getColor().getColor()+"', '"+lava.getConsumoEnergetico().getConsumoEner()+"',"+lava.getCarga()+","+"null,"+"null"
					+ ")");
			//JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			//JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}

	public List<Electrodomestico> buscarLavarropa() 
	{
		Conexion conex= new Conexion();
		List<Electrodomestico> electrodomesticos = new ArrayList<Electrodomestico>();
		boolean existe=false;
		try {
			//Statement estatuto = conex.getConnection().createStatement();
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM electrodomesticos where sintonizador IS NULL");
			//consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				Lavarropa lava;
				lava= new Lavarropa(Double.parseDouble(res.getString("precio_base")),Double.parseDouble(res.getString("peso")),
						res.getString("color"), res.getString("consumo_ener").charAt(0), Double.parseDouble(res.getString("carga")));
			
				lava.setIdElectrodomestico(Integer.parseInt(res.getString("id_electrodomestico")));
				
				electrodomesticos.add(lava);
				
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
			else return null;				
	}

	public void modificarLavarropa(Lavarropa lava) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE electrodomesticos SET precio_base= ? ,peso = ? , color=? , consumo_ener=? , carga= ? , sintonizador= ? WHERE id_electrodomestico= " + lava.getIdElectrodomestico();
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);

            estatuto.setDouble(1, lava.getPrecioBase());
            estatuto.setDouble(2, lava.getPeso());
            estatuto.setString(3, lava.getColor().getColor());
            char c = lava.getConsumoEnergetico().getConsumoEner();
            String con = String.valueOf(c);
            estatuto.setString(4, con);
            estatuto.setDouble(5, lava.getCarga());
            //estatuto.setDouble(6, null);
            estatuto.setString(6, null);
            estatuto.executeUpdate();
          //JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
         
        }catch(SQLException	 e){
            System.out.println(e);
            //JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public void eliminarLavarropa(Lavarropa lava)
	{
		Conexion conex= new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("DELETE FROM electrodomesticos WHERE id_electrodomestico= " + lava.getIdElectrodomestico());
            //JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			//JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}
	
	public Lavarropa GetLavarropaPorId(int idLavarropa) 
	{
		Conexion conex= new Conexion();
		Lavarropa lava = null;
		
		boolean existe=false;
		try {
			//Statement estatuto = conex.getConnection().createStatement();
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM electrodomesticos where id_electrodomestico=?");
			consulta.setInt(1, idLavarropa);
			ResultSet res = consulta.executeQuery();
			if(res.next()){
				existe=true;
				lava= new Lavarropa(Double.parseDouble(res.getString("precio_base")),Double.parseDouble(res.getString("peso")),
						res.getString("color"), res.getString("consumo_ener").charAt(0), Double.parseDouble(res.getString("carga")));
			
				lava.setIdElectrodomestico(Integer.parseInt(res.getString("id_electrodomestico")));
				
			} 
			res.close();
			conex.desconectar();
					
					
			} catch (SQLException e) {
					//JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return lava;
			}
			else return null;				
	}
	
	

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ConexionBD;
import modelo.Mascota;

/**
 *
 * @author LENOVO
 */
public class ControladorMascotas {
    
    private final ConexionBD conn;
    private final Connection con;
    
    public ControladorMascotas(){
        conn = new ConexionBD();
        con = conn.getConexion();
    }
    
    public Mascota buscarMascota(String codigo) {
        try{
            PreparedStatement ps;
            ResultSet rs;
            
            String query = "SELECT * FROM tabla_mascotas WHERE codigo = ?";
            
            ps = con.prepareStatement(query);
            ps.setString(1, codigo);
            
            rs = ps.executeQuery();
            
            if(rs.next()){ //Si se encuentra algo
                
                String nombre = rs.getString("nombre");
                String raza = rs.getString("raza");
                float altura = rs.getFloat("altura");
                String color = rs.getString("color");
                int anios = rs.getInt("anios");
                float peso = rs.getFloat("peso");
                
                Mascota mascota = new Mascota(codigo, nombre, raza, altura, color, anios, peso);
                return mascota;                       
            }
        }catch (SQLException ex){
            System.err.println(ex.toString());
        }
        return null;

    }
     public void registrarMascota(Mascota mascota) throws SQLException {

        try {

            PreparedStatement ps;

            String query = "INSERT INTO tabla_mascotas (codigo, nombre, raza, altura, color, anios, peso) VALUES (?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);

            ps.setString(1, mascota.getCodigo());
            ps.setString(2, mascota.getNombre());
            ps.setString(3, mascota.getRaza());
            ps.setFloat(4, mascota.getAltura());
            ps.setString(5, mascota.getColor());
            ps.setInt(6, mascota.getAnios());
            ps.setFloat(7, mascota.getPeso());

            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex);
            throw new SQLException();
        }

    }
     
      public void editarMascota(Mascota mascota) {

        try {
            PreparedStatement ps;

            String query = ("UPDATE tabla_mascotas SET nombre=?, raza=?, altura=?, color=?, anios=?, peso=?  WHERE codigo=?");
            ps = con.prepareStatement(query);

            ps.setString(7, mascota.getCodigo());
            ps.setString(1, mascota.getNombre());
            ps.setString(2, mascota.getRaza());
            ps.setFloat(3, mascota.getAltura());
            ps.setString(4, mascota.getColor());
            ps.setInt(5, mascota.getAnios());
            ps.setFloat(6, mascota.getPeso());
            
            System.out.print(ps);
            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex);

        }
    }
      
    public void eliminarMascota(String codigo) {
        try {
            PreparedStatement ps;

            String query = "DELETE FROM tabla_mascotas WHERE codigo = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, codigo);

            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
      public ArrayList<Mascota> listarMascota(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        
        try{
            PreparedStatement ps;
            ResultSet rs;
            
            String query = "SELECT * FROM tabla_mascotas";
            
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()){
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String raza = rs.getString("raza");
                float altura = rs.getFloat("altura");
                String color = rs.getString("color");
                int anios = rs.getInt("anios");
                float peso = rs.getFloat("peso");
                
                Mascota mascota = new Mascota(codigo, nombre, raza, altura, color, anios, peso);
                mascotas.add(mascota);
                
                System.out.println(mascota.toString());
            }
        }catch (SQLException ex){
            System.err.println(ex.toString());
        }
        return mascotas;
    } 
      
}

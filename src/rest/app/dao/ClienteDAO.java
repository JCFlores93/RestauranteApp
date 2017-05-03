/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import rest.app.dto.ClienteDto;
import rest.app.tools.SQLCommander1;

/**
 *
 * @author JeanCarlo
 */
public class ClienteDAO {
    public ArrayList listCliente(String nombre) throws Exception {
    String sql = "SELECT  * FROM   cliente WHERE nombre LIKE '%" + nombre + "%'";
    ArrayList list = new ArrayList();
    Connection cn = SQLCommander1.obtieneConexion();
    //Crear Statement
    Statement stmt = cn.createStatement();
    //Capturar los datos
    ResultSet rs = stmt.executeQuery(sql);
    //Procesar los datos
    while (rs.next()) {
      ClienteDto dto = new ClienteDto();
      dto.setIdCliente(rs.getInt(1));
      dto.setNombre(rs.getString(2));
      dto.setApellido1(rs.getString(3));
      dto.setApellido2(rs.getString(4));
      dto.setObservaciones(rs.getString(5));
      list.add(dto);
    }
    return list;
  }

  public int registrartCliente(ClienteDto dto) throws Exception {
    //Construir sql
    String sql = "INSERT INTO Cliente(nombre,apellido1,apellido2,observaciones)VALUES(?,?,?,?)";
    //Conexion
    Connection cn = SQLCommander1.obtieneConexion();
    //Statement,PreparedStatement,CallableStatement
    PreparedStatement pstmt = cn.prepareStatement(sql);
    pstmt.setString(1,dto.getNombre());
    pstmt.setString(2,dto.getApellido1());
    pstmt.setString(3,dto.getApellido2());
    pstmt.setString(4,dto.getObservaciones());
    int n = pstmt.executeUpdate();
    return n;
  }

  public int eliminarCliente(int codigo) throws Exception {
    String sql = "DELETE FROM Cliente WHERE  IdCliente =?";
    //Conexion
    Connection cn = SQLCommander1.obtieneConexion();
    //Statement,PreparedStatement,CallableStatement
    PreparedStatement pstmt = cn.prepareStatement(sql);
    pstmt.setInt(1,codigo);
    int n = pstmt.executeUpdate();
    return n;
  }
  public ClienteDto buscarClientePorId(int codigo) throws Exception {
    String sql = "SELECT  * FROM   cliente WHERE IdCliente LIKE '%" + codigo + "%'";
    
    Connection cn = SQLCommander1.obtieneConexion();
    //Crear Statement
    Statement stmt = cn.createStatement();
    //Capturar los datos
    ResultSet rs = stmt.executeQuery(sql);
    //Procesar los datos
     ClienteDto dto = new ClienteDto();
    while (rs.next()) {
     
      dto.setIdCliente(rs.getInt(1));
      dto.setNombre(rs.getString(2));
      dto.setApellido1(rs.getString(3));
      dto.setApellido2(rs.getString(4));
      dto.setObservaciones(rs.getString(5));
      
    }
    return dto;
  }
 

  public int modificarCliente(ClienteDto dto) throws Exception {
    String sql = "UPDATE  cliente SET  nombre=?,apellido1=?,apellido2=?,observaciones=? WHERE  IdCliente= ?";
    //Conexion
    Connection cn = SQLCommander1.obtieneConexion();
    //Statement,PreparedStatement,CallableStatement
    PreparedStatement pstmt = cn.prepareStatement(sql);    
    pstmt.setString(1, dto.getNombre());
    pstmt.setString(2, dto.getApellido1());
    pstmt.setString(3, dto.getApellido2());
    pstmt.setString(4, dto.getObservaciones());
    pstmt.setInt(5, dto.getIdCliente());
    
    int n = pstmt.executeUpdate();
    return n;
  }
}

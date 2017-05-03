/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.app.test;

import java.util.ArrayList;
import rest.app.dao.ClienteDAO;
import rest.app.dto.ClienteDto;

/**
 *
 * @author Gustavo Coronel
 */
public class TestDatos {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws Exception {
    // TODO code application logic here
    ClienteDAO dao=new ClienteDAO();
    ArrayList list= dao.listCliente("m");
    if (list!=null) {
      System.out.println("Existen Datos.");
        System.out.println("hola1");
        System.out.println("cantidad : "+list.size());
      
    } else {
      System.out.println("No existen Datos.");
    }           
  }
  
}

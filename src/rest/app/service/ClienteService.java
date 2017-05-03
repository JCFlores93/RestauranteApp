/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.app.service;

import java.util.ArrayList;
import rest.app.dao.ClienteDAO;
import rest.app.dto.ClienteDto;

/**
 *
 * @author JeanCarlo
 */
public class ClienteService {
    public ArrayList listCliente(String nombre) throws Exception {
    ClienteDAO dao = new ClienteDAO();           
    return dao.listCliente(nombre);
  }
    
    public int registrarCliente(ClienteDto cliente)throws Exception{
        ClienteDAO dao=new ClienteDAO();
        return dao.registrartCliente(cliente);
    }
    
     public int eliminarCliente(int codigo)throws Exception{
        ClienteDAO dao=new ClienteDAO();
        return dao.eliminarCliente(codigo);
    }
     
       public ClienteDto buscarClientePorId(int codigo) throws Exception {
        ClienteDAO dao = new ClienteDAO();           
        return dao.buscarClientePorId(codigo);
  }
       
       public int modificarCliente(ClienteDto cli)throws Exception{
        ClienteDAO dao=new ClienteDAO();
        return dao.modificarCliente(cli);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.app.ctl;

import java.util.ArrayList;
import rest.app.dto.ClienteDto;
import rest.app.service.ClienteService;

/**
 *
 * @author JeanCarlo
 */
public class ClienteCtl {
     public ArrayList listCliente(String nombre) throws Exception {
     ClienteService dao = new ClienteService();           
    return dao.listCliente(nombre);
  }
     public int registarCliente(ClienteDto cliente)throws Exception{
         ClienteService dao=new ClienteService();
         return dao.registrarCliente(cliente);
     }
     public int eliminarCliente(int codigo)throws Exception{
         ClienteService dao=new ClienteService();
         return dao.eliminarCliente(codigo);
     }
     
          public ClienteDto buscarClientePorId(int codigo) throws Exception {
        ClienteService dao = new ClienteService();           
        return dao.buscarClientePorId(codigo);
  }
          
         public int modificarCliente(ClienteDto cli)throws Exception{
         ClienteService dao=new ClienteService();
         return dao.modificarCliente(cli);
     }
     
}

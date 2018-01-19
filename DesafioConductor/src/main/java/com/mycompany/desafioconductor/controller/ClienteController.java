/**
 * Classe que implementa a camada de controle do padrão 
 * de arquitetura MVC.
 */
package com.mycompany.desafioconductor.controller;

import com.mycompany.desafioconductor.DAO.ClienteDAO;
import com.mycompany.desafioconductor.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author rodst
 */

/**
 * 
 */
@Path("cliente")
public class ClienteController {
        
    /**
     * Acessa o BD a partir do DAO e retorna
     * uma lista com os dados contidos nele.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Cliente> ListadeCliente(Cliente cliente)
    {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            if (clienteDAO.listar().isEmpty())
            {
                clienteDAO.inserir(cliente);
            }
            return clienteDAO.listar();
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * Acessa o BD a partir do DAO e retorna
     * uma objeto do banco de dados.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Cliente GetCliente(@PathParam("id") long id)
    {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            return clienteDAO.selecionar(id);
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * Cria um novo objeto e através do 
     * DAO adiciona no banco de dados.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response CreateCliente(Cliente cliente)
    {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.inserir(cliente);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * Acessa o BD a partir do DAO, atualiza
     * um objeto contido e retorna pra o BD 
     * através do DAO.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response UpdateCliente(Cliente cliente)
    {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.alterar(cliente);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
}

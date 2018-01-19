/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.desafioconductor.DAO;

import com.mycompany.desafioconductor.controller.ClienteController;
import com.mycompany.desafioconductor.model.Cliente;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author rodst
 */
public class ClienteDAOTest {
    
    public ClienteDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of listar method, of class ClienteDAO.
     */
    @Test
    @Ignore
    public void testListar() throws Exception {
        ClienteDAO clientedao = new ClienteDAO();
        Cliente cliente = new Cliente();
        
        clientedao.inserir(cliente);
        clientedao.listar().toString();
        
    }

    /**
     * Test of alterar method, of class ClienteDAO.
     */
    @Test
    public void testAlterar() throws Exception {
        
                
    }

    /**
     * Test of inserir method, of class ClienteDAO.
     */
    @Test
    public void testInserir() throws Exception {
        Cliente c = new Cliente();
        c.setNome("Ziriguidum");
        c.setCpf("120084054054");
        c.setEmail("r@r");
        c.setTelefone("26mole6748");
        ClienteDAO cdao = new ClienteDAO();
        cdao.inserir(c);
    }

    /**
     * Test of selecionar method, of class ClienteDAO.
     */
    @Test
    @Ignore
    public void testSelecionar() throws Exception {
        System.out.println("selecionar");
        long id = 0L;
        ClienteDAO instance = new ClienteDAO();
        Cliente expResult = null;
        Cliente result = instance.selecionar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

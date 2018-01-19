/**
 * Classe para abstração de acesso aos dados.
 */
package com.mycompany.desafioconductor.DAO;

import com.mycompany.desafioconductor.infra.ConexaoJDBC;
import com.mycompany.desafioconductor.infra.ConexaoPostgres;
import com.mycompany.desafioconductor.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodst
 */

/**
 * Padrão de projeto DAO para prover uma interface que
 * abstrai o acesso aos dados, ou seja encapsula o acesso 
 * aos dados.
 */ 
public class ClienteDAO {
    private final ConexaoJDBC conexao;

    public ClienteDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new ConexaoPostgres();
    }
    
    /**
    * Acessa o banco de dados e copias os dados para exibir 
    * pro usuário em forma de lista, sem que o usuário acesse
    * diretamente o banco de dados.
    */ 
    public List<Cliente> listar() throws SQLException, ClassNotFoundException {
        String sqlQuery = "SELECT * FROM tbCliente ORDER BY id";
        
                try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            ResultSet rs = stmt.executeQuery();

            List<Cliente> clientes = new ArrayList<>();

            while (rs.next()) {
                clientes.add(parser(rs));
            }

            return clientes;
        } catch (SQLException e) {
            throw e;
        }
    }
            
    /**
    * Altera dados de forma segura no banco de dados.
    */ 
    public int alterar(Cliente cliente) throws SQLException, ClassNotFoundException {
    
        String sqlQuery = "UPDATE tbCliente SET nome = ?, cpf = ?, email = ?, telefone = ? WHERE id = ?";
               
        int linhasAfetadas = 0;

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setLong(5, cliente.getId());

            linhasAfetadas = stmt.executeUpdate();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }

        return linhasAfetadas;
    }
            
    /**
     * Insere dados de forma segura no banco de dados. 
     */
    public Long inserir(Cliente cliente) throws SQLException, ClassNotFoundException {
                    
        Long id = null;
        String sqlQuery = "INSERT INTO tbCliente (nome, cpf, email, telefone) VALUES (?, ?, ?, ?) RETURNING id";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getLong("id");
            }

            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }

        return id;
    }
            
    /**
     * Lista um dado do banco de dados de forma segura. 
     */
    public Cliente selecionar(long id) throws SQLException, ClassNotFoundException {
        
        String sqlQuery = "SELECT * FROM tbCliente WHERE id = ?";
        
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return parser(rs);
            }
        } catch (SQLException e) {
            throw e;
        }

        return null;
    }
    
    /**
     * Método de auxílio para a execução da Query.
     */
    private Cliente parser(ResultSet resultSet) throws SQLException {
        Cliente c = new Cliente();

        c.setId(resultSet.getLong("id"));
        c.setNome(resultSet.getString("nome"));
        c.setCpf(resultSet.getString("cpf"));
        c.setEmail(resultSet.getString("email"));
        c.setTelefone(resultSet.getString("telefone"));

        return c;
    }
}

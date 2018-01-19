/**
 * Classe de conexão da aplicação
 * com o banco de dados.
 */
package com.mycompany.desafioconductor.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodst
 */

/**
 * Classe que implementa um interface
 * de conexão com o banco de dados.
 */
public class ConexaoPostgres implements ConexaoJDBC {

        private Connection connection = null;

    /**
     * Construtor da classe de conexão da aplicação com o BD.
     */
    public ConexaoPostgres() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        
        Properties properties = new Properties();
        properties.put("user", "postgres");
        properties.put("password", "postgres");

        this.connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5433/dbClientes", properties);
        //this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/dbClientes","postgres", "postgres");
        this.connection.setAutoCommit(false);
    }

    /**
     * Retorna a conexão do BD para que 
     * for usá-la.
     */
    @Override
    public Connection getConnection() {
        return this.connection;
    }

    /**
     * Fecha a conexão caso seja diferente
     * de NULL.
     */
    @Override
    public void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoPostgres.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *Verifica se há erro na instrução, caso contrário
     * faz o commit e fecha a conexão.
     */
    @Override
    public void commit() throws SQLException {
        this.connection.commit();
        this.close();
    }

    /**
     * Caso tenha um erro na aplicação, 
     * há possibilidade de reverter.
    */
    @Override
    public void rollback() {
        if (this.connection != null) {
            try {
                this.connection.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoPostgres.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                this.close();
            }
        }
    }
    
}

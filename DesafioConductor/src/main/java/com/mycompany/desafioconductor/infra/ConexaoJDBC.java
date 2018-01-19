/**
 * Classe que implementa uma interface
 * de conexão de banco de dados.
 */
package com.mycompany.desafioconductor.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rodst
 */

/**
* Serve de superclasse para outra classe
* que implemente seus métodos.
*/
public interface ConexaoJDBC {
    
    /**
     * Retorna a conexão do BD para que 
     * for usá-la.
     */
    public Connection getConnection();

    /**
     * Fecha a conexão caso seja diferente
     * de NULL.
     */
    public void close();

    /**
     *Verifica se há erro na instrução, caso contrário
     * faz o commit e fecha a conexão.
     */
    public void commit() throws SQLException;

    /**
     * Caso tenha um erro na aplicação, 
     * há possibilidade de reverter.
    */
    public void rollback();

}

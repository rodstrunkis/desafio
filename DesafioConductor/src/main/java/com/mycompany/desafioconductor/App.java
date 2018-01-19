/**
 * Classe principal da aplicação.
 */
package com.mycompany.desafioconductor;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author rodst
 */

/**
 * A Classe possui os imports do Jersey que é um framework
 * que implementa todas as características da aquitetura
 * REST.
 */ 
@ApplicationPath("rest")
public class App extends ResourceConfig {
    
    public App() {
        packages("com.mycompany.desafioconductor.controller");
    }
    
}

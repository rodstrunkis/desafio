/**
 * Classe que implementa a camada de modelo 
 * do padrão de arquitetura MVC.
 */
package com.mycompany.desafioconductor.model;

/**
 *
 * @author rodst
 */

/**
 * Classe que implementa a camada de modelo 
 * do cliente, get and set, hashcode and equals
 * e toString.
 */
public class Cliente {
    
    private long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

   @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + id + ", nomeCliente=" 
                + nome + ", cpfCliente=" + cpf + ", emailCliente=" 
                + email + ", telefoneCliente=" + telefone + '}';
    } 
}

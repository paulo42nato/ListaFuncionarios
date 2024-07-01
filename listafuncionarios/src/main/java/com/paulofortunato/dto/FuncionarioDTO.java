package com.paulofortunato.dto;

public class FuncionarioDTO {
    public int id_funcionario;
    String nome_funcionario, funcao_funcionario;
    
    
   //Getters e Setters
   
    public int getId_funcionarios() {
        return id_funcionario;
    }
    public void setId_funcionarios(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
    public String getNome_funcionario() {
        return nome_funcionario;
    }
    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }
    public String getFuncao_funcionario() {
        return funcao_funcionario;
    }
    public void setFuncao_funcionario(String funcao_funcionario) {
        this.funcao_funcionario = funcao_funcionario;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_funcionario;
        return result;
    }
   
   
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FuncionarioDTO other = (FuncionarioDTO) obj;
        if (id_funcionario != other.id_funcionario)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "ID: " + getId_funcionarios() + "     NOME: "
                + getNome_funcionario() + "     Função: " + getFuncao_funcionario()  + " ]\n ";
    }
    
   
}

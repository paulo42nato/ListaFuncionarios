package com.paulofortunato.dao;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.paulofortunato.dto.FuncionarioDTO;

public class FuncionarioDAO {
    //declaração de variaveis globais
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private ArrayList<FuncionarioDTO> lista = new ArrayList<>();
    
    //Método de cadastro de funcionario
    public void cadastrarFuncionario(FuncionarioDTO objFuncionarioDTO){
            String sql = "Insert into funcionario (nome_funcionario, funcao_funcionariol) values (?,?)";

            conn = new ConexaoDAO().conectaBD();
            try {
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, objFuncionarioDTO.getNome_funcionario());
                pstm.setString(2, objFuncionarioDTO.getFuncao_funcionario());
                
                pstm.execute();
                pstm.close();
                System.out.println("Funcionário cadastrado");

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null,"FuncionarioDAO - cadastrar" + erro);
            }
    
        }   
    //Método para listar funcionários
    public ArrayList<FuncionarioDTO> listarFuncionario(){
        String sql = "SELECT * FROM funcionario";
        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            lista.clear();
            while(rs.next()){
                FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO();
                objFuncionarioDTO.setId_funcionarios(rs.getInt("idfuncionario"));
                objFuncionarioDTO.setNome_funcionario(rs.getString("nome_funcionario"));
                objFuncionarioDTO.setFuncao_funcionario(rs.getString("funcao_funcionariol"));
            
                if(lista.contains(objFuncionarioDTO.getId_funcionarios()));
                else{
                    lista.add(objFuncionarioDTO);}
                

            }
            
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"FuncionarioDAO - listar" + erro);
        }
        
        return lista;

    }
    //Método para remover funcionário
    public void removerFuncionario(FuncionarioDTO objFuncionarioDTO){
        String sql = "delete from funcionario where idfuncionario=? ";

        conn = new ConexaoDAO().conectaBD();
        try {
            pstm = conn.prepareStatement(sql);

            
            pstm.setInt(1, objFuncionarioDTO.getId_funcionarios());
            pstm.executeUpdate();
            System.out.println("Funcionario removido");
            pstm.close();
            
        }   catch (Exception e) {
            System.out.println("Não foi possivel remover funcionario" + e);

            }
    }
    //Método para atualizar funcionário
    public void atualizarFuncionario(FuncionarioDTO objFuncionarioDTO){
        String sql = " UPDATE funcionario SET nome_funcionario = ?, funcao_funcionariol = ? WHERE idfuncionario = ?";
        
        conn = new ConexaoDAO().conectaBD();
        try {   
            pstm = conn.prepareStatement(sql);

           
            pstm.setString(1, objFuncionarioDTO.getNome_funcionario());
            pstm.setString(2, objFuncionarioDTO.getFuncao_funcionario());
            pstm.setInt(3, objFuncionarioDTO.getId_funcionarios());

            pstm.executeUpdate();
            System.out.println("Funcionario atualizado");
            pstm.close();


        } catch (Exception e) {
            System.out.println("Não foi possível atualizar funcionario " + e);
        }

    }
}
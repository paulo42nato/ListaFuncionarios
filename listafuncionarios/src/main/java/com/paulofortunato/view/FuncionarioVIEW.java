package com.paulofortunato.view;


import java.util.ArrayList;
import java.util.Scanner;

import com.paulofortunato.dao.FuncionarioDAO;
import com.paulofortunato.dto.FuncionarioDTO;

public class FuncionarioVIEW {

    FuncionarioDAO objFuncionarioDAO = new FuncionarioDAO();
    FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO();
    Scanner sc = new Scanner(System.in);
    String nome, funcao;
    int id;

    public void addFuncionario() {
        System.out.println("Adicionar Funcionário");
        System.out.println("Digite o nome do funcionário:");
        nome = sc.nextLine();
        System.out.println("Digite a função:");
        funcao = sc.nextLine();

        objFuncionarioDTO.setNome_funcionario(nome);
        objFuncionarioDTO.setFuncao_funcionario(funcao);

        objFuncionarioDAO.cadastrarFuncionario(objFuncionarioDTO);
    }

    public void listaFuncionario() {

        ArrayList<FuncionarioDTO> lista = objFuncionarioDAO.listarFuncionario();
        objFuncionarioDTO.equals(lista);
        System.out.println(lista);
        

    }

    public void removerFuncionario() {
        int id;
        System.out.println("Digite o id do funcionario");
        id = Integer.parseInt(sc.nextLine());
        objFuncionarioDTO.setId_funcionarios(id);
        objFuncionarioDAO.removerFuncionario(objFuncionarioDTO);
    }

    public void atualizarFuncionario() {
        int id;
        System.out.println("Atualizar Funcionário");
        System.out.println("Digite o id do funcionario");
        id = Integer.parseInt(sc.nextLine());
        System.out.println("Digite o nome do funcionário:");
        nome = sc.nextLine();
        System.out.println("Digite a função:");
        funcao = sc.nextLine();
        objFuncionarioDTO.setId_funcionarios(id);
        objFuncionarioDTO.setNome_funcionario(nome);
        objFuncionarioDTO.setFuncao_funcionario(funcao);

        objFuncionarioDAO.atualizarFuncionario(objFuncionarioDTO);

    }
}

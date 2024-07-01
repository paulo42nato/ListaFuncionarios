package com.paulofortunato;

import java.util.Scanner;

import com.paulofortunato.view.FuncionarioVIEW;

public class Main {
    public static void main(String[] args) {
        int escolha = 0;
        Scanner sc = new Scanner(System.in);
        FuncionarioVIEW objFuncionarioVIEW = new FuncionarioVIEW();

        while (escolha == 0){

            System.out.println("              Menu         \n 1 - Cadastrar funcionario \n 2 - Listar funcionarios \n 3 - Remover funcionario \n 4 - Atualizar funcionario \n 5 - Sair \n \nDigite a opção desejada: "); 
            escolha = Integer.parseInt(sc.nextLine());
            if (escolha == 1){
                objFuncionarioVIEW.addFuncionario();
                escolha = 0;
            }

            if (escolha == 2) {
                objFuncionarioVIEW.listaFuncionario();
                escolha = 0;
            }

            if(escolha == 3){
                objFuncionarioVIEW.removerFuncionario();
                escolha = 0;
            }

            if(escolha == 4){
                objFuncionarioVIEW.atualizarFuncionario();
                escolha = 0;

            }
            if(escolha == 5){
                System.exit(0);
            }
        }
        
        
    }
}
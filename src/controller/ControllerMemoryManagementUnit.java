package controller;


import model.Configuration;
import model.Memory;
import model.TablePage;
import vision.UserInteraction;

import java.util.ArrayList;
import java.util.List;

public class ControllerMemoryManagementUnit {

    private UserInteraction ui;

    private Configuration configuration;
    private Memory memory;
    private List<TablePage> tablesPages;
    private List<Process> processes;

    public ControllerMemoryManagementUnit() {
        this.ui = new UserInteraction();
        this.tablesPages = new ArrayList<TablePage>();
        this.processes = new ArrayList<Process>();
    }

    public void init() {
        ui.showMessage("Olá, seja bem vindo ao trabalho 2 de Sistemas Operacionais");
        this.initialConfiguration();
        this.controlMenuOptions();
        ui.showMessage("Obrigado por usar o programa...");
    }

    private void controlMenuOptions() {
        boolean running = true;

        do {
            int choosedOption = ui.receiveInt(
                "Digite um número para escolher uma das opções abaixo:\n" +
                         "1 - Criar um novo processo;\n" +
                         "2 - Exibir memória;\n" +
                         "3 - Exibir tabela;\n" +
                         "4 - Sair.", 1, 4);

            switch (choosedOption) {
                case 1:
                    this.createNewProcess();
                    break;
                case 2:
                    this.showMemory();
                    break;
                case 3:
                    this.showTable();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    break;
            }
        } while (running);
    }

    private void showTable() {
        //         Criar Exibir tabela
        // pegar o id do processo, e exibir a tabela desse id;
    }

    private void showMemory() {
        //         Criar exibir memória(pode exibir inteira, ou baseada em quadros)
    }

    private void createNewProcess() {
        int maxSizeProcess = this.configuration.getMaxSizeProcess();
        String idProcess = ui.receiveString("Você está criando um novo processo.\n\n" +
                         "Por favor digite o id desejado para o processo.");
        int processSize = ui.receiveInt("Você está criando um novo processo.\n\n" +
                                "Por favor digite o tamanho do processo (em bytes)" , 1 , maxSizeProcess,
                   "O tamanho digitado não atende aos parâmetros (entre 1 e " + maxSizeProcess + ")");

        // fazer try catch para mostrar mensagem de erro caso o processo não possa ser adicionado (não há memória disponíbel)
        if (this.memory.countAvailableBoards() > 0) {
            List<Integer> usedBoards = this.memory.addNewProcess(processSize);

//            TablePage teste = new TablePage();

  //          this.tablesPages.add();
            //implementar lógica para paginas e criar a tabela de processos para o processo e adicionar o mesmo na lista de processos

            ui.showMessage("Processo de id (" + idProcess + ") cadastrado com sucesso!!!");

        } else {
            ui.showMessage("Não foi possível adicionar um novo processo, a memória está cheia");
        }
    }

//int memorySize = 1000, boardSize = 10, maxSizeProcess = 25;

    private void initialConfiguration() {
        int memorySize = 0, boardSize = 0, maxSizeProcess = 0;

        //Configuração

        // Dizer para entrar com o tamanho de memória desejado
        // -- Validar se o tamanho está correto (é multiplo de 2)
        //Dizer para entrar com o tamanho de uma pagina
        // -- Validar se é multiplo de 2 e se é um divisor da memória
        //Dizer para entrar com o tamanho máximo que um processo pode assumir
        // -- Validar se é diferente de 0; (pode ser maior que a memória, é só dar erro dps)


        //Deve ao final do método conter as variáveis validas
        this.memory = new Memory(memorySize, boardSize);
        this.configuration = new Configuration(boardSize, maxSizeProcess, memorySize);

    }

}

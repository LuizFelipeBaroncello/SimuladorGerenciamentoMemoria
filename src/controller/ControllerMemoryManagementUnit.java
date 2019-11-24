package controller;


import model.Configuration;
import model.Memory;
import vision.UserInteraction;

public class ControllerMemoryManagementUnit {

    private UserInteraction ui;

    private Configuration configuration;
    private Memory memory;


    public ControllerMemoryManagementUnit() {
        this.ui = new UserInteraction();
    }

    public void init() {
        ui.showMessage("Olá, seja bem vindo ao trabalho 2 de Sistemas Operacionais");
        this.initialConfiguration();
        this.controlMenuOptions();
    }

    private void controlMenuOptions() {
        boolean running = true;
        // Mostrar menu de opções
        // 1 - Criar um novo processo (procID, tamanho)
        // 2 - Exibir memória()
        // 3 - Exibir tabela(procID) (Exibe a tabela de páginas e o tamanho do processo)
        // 4 - Sair

        // validar se ele clicar ou digitar outra coisa

        do {
            int choosedOption = ui.receiveInt("Mostrar opções", 1, 4);

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
        System.out.println("Criar criador de novo processo");
    }


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

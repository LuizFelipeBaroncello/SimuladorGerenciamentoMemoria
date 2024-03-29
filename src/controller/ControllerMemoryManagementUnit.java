package controller;


import exceptions.MemoryOutOfBound;
import exceptions.ProcessNotFound;
import model.Configuration;
import model.Memory;
import model.Page;
import model.Process;
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
        try {
            String processId = ui.receiveString("Digite o id do processo que deseja visualizar a tabela de páginas:");

            Process process = this.findProcess(processId);
            TablePage tablePage = this.findTableProcess(processId);

            ui.showMessage("O processo (" + processId + ") contém as seguintes informações: \n\n" +
                    "Tamanho: " + process.getSize() + "\n" +
                    "Tabela de páginas: " + tablePage.toString());
        }catch (ProcessNotFound e){
            ui.showMessage(e.getMessage());
        }
    }

    private TablePage findTableProcess(String processId) {
        int indexTable = -1;

        for (int i = 0; i < tablesPages.size(); i++) {
            if (this.tablesPages.get(i).getProcessID().equals(processId)) {
                indexTable = i;
            }
        }

        if (indexTable == -1) {
//            throw mandar execeção de processo não encontrado
        }

        return this.tablesPages.get(indexTable);

    }

    private Process findProcess(String processId) throws ProcessNotFound {
        int indexProcess = -1;

        for (int i = 0; i < processes.size(); i++) {
            if (this.processes.get(i).getId().equals(processId)) {
                indexProcess = i;
            }
        }

        if (indexProcess == -1) {
            throw new ProcessNotFound("Processo não encontrado");
        }

        return this.processes.get(indexProcess);
    }

    private boolean existProcess(String processId) {
        for (int i = 0; i < processes.size(); i++) {
            if (this.processes.get(i).getId().equals(processId)) {
                return true;
            }
        }

        return false;
    }

    private void showMemory() {
        ui.showMessage(this.memory.toString());
     }

    private void createNewProcess() {
        boolean loopGetProcessId = false;
        int maxSizeProcess = this.configuration.getMaxSizeProcess();
        String processId = "";

        do {
            processId = ui.receiveString("Por favor digite o id desejado para o processo.");

            if (this.existProcess(processId)) {
                loopGetProcessId = true;
                ui.showMessage("Esse id de processo já está em uso.");
            } else {
                loopGetProcessId = false;
            }
        } while (loopGetProcessId);

        int processSize = ui.receiveInt("Por favor digite o tamanho do processo (em bytes)" , 1 , maxSizeProcess,
                   "O tamanho digitado não atende aos parâmetros (entre 1 e " + maxSizeProcess + ")");

        // fazer try catch para mostrar mensagem de erro caso o processo não possa ser adicionado (não há memória disponíbel)
        if (this.memory.countAvailableBoards() > 0) {
            try {
                List<Integer> usedBoards = this.memory.addNewProcess(processSize);
                List<Page> pages = new ArrayList<>();

                for (int i = 0; i < usedBoards.size(); i++) {
                    pages.add(new Page(usedBoards.get(i)));
                }

                TablePage tablePageProcess = new TablePage(pages, processId);

                this.processes.add(new Process(processId, processSize));
                this.tablesPages.add(tablePageProcess);

                ui.showMessage("Processo de id (" + processId + ") cadastrado com sucesso!!!");
            } catch (MemoryOutOfBound e){
                ui.showMessage(e.getMessage());
            }
        } else {
            ui.showMessage("Não foi possível adicionar um novo processo, a memória está cheia");
        }
    }

    private void initialConfiguration() {
        int memorySize = 0, boardSize = 0, maxSizeProcess = 0;

        boolean loop = false;

        do {
            memorySize = ui.receiveInt("Entre com o tamanho da memória: ",
                    1, 999999, "O número digitado não atende aos parametros, favor tentar novamente.");
            if( memorySize % 2 == 0) {
                loop = false;
            } else {
                ui.showMessage("Por favor digite um valor par");
                loop = true;
            }
        } while (loop);

        do {
            boardSize = ui.receiveInt("Entre com o tamanho da pagina: ",
                    1, memorySize, "O número digitado não atende aos parametros, favor tentar novamente.");
            if(memorySize % boardSize == 0) {
                loop = false;
            } else {
                ui.showMessage("Por favor digite um tamanho de quadro que seja divisor da memoria");
                loop = true;
            }
        } while (loop);

        maxSizeProcess = ui.receiveInt("Entre com o tamanho máximo que os processos criados poderão ter.",
                1, 999999, "O número digitado não atende aos parametros, favor tentar novamente.");

        this.memory = new Memory(memorySize, boardSize);
        this.configuration = new Configuration(boardSize, maxSizeProcess, memorySize);

    }

}

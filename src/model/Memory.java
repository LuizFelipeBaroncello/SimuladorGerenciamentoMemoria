package model;

import exceptions.MemoryOutOfBound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Memory{

    private LinkedList<MemoryPosition> phisicalMemory;
    private HashMap<Object, LinkedList<MemoryPosition>> mapBoards;
    private int usedBoards;
    private int boardSize;

    // mandar exceção se o calculo tiver errado
    public Memory(int size, int boardSize) { //VALIDAR SE SIZE TA CRIANDO O NUMERO CORRETO
        this.usedBoards = 0;
        this.boardSize = boardSize;
        this.phisicalMemory = new LinkedList<MemoryPosition>();

        for (int i = 0; i < size; i++) {
            this.phisicalMemory.add(new MemoryPosition());
        }

        int boardNumber = (size / boardSize);

        mapBoards = new HashMap<Object, LinkedList<MemoryPosition>>();

        for (int i = 0; i < boardNumber; i++) {
            int initialPosition =  boardSize * i;
            int endPosition = (boardSize * (i+1)) - 1;

            LinkedList<MemoryPosition> subList = new LinkedList<MemoryPosition>();

            for (int j = initialPosition; j <= endPosition; j++) {
                subList.add(phisicalMemory.get(j));
            }

            mapBoards.put(i, subList);
        }

    }

    // Saber quantas posições foram usadas em um determinado quadro
    public int countPositionsOnBoard(int boardIndex) {
        if (boardIndex < this.countBoards()){ // algo assim ou o try catch msm, tu que sabe
            LinkedList<MemoryPosition> board  = mapBoards.get(boardIndex);
            int usedBits = 0;
            for(int i = 0; i < board.size(); i++){
                usedBits++;
            }
            return usedBits;
        } else {
            return -1;
        }
    }

    // Saber quantos quadros existem
    public int countBoards() {
        return this.mapBoards.size();
    }

    // Retorna o index do ultimo quadro usado
    public int getLastIndex() {
        return this.countBoards() - 1;
    }

    // Saber quantos quadros estão usados indexNextEmptyBoard
    public int countUsedBoards() {
        return usedBoards;
    }

    // Saber quantos quadros estão disponíveis
    public int countAvailableBoards() {
        return this.countBoards() - this.countUsedBoards();
    }

    // Alterar próximo quadro vazio
    public boolean updateNextEmptyBoard(int numberMemoryPositionUsed) {
        int indexNextEmptyBoard = this.countUsedBoards();

        if (indexNextEmptyBoard < this.countBoards() && numberMemoryPositionUsed != 0) {
            LinkedList<MemoryPosition> board  = mapBoards.get(indexNextEmptyBoard); 
            
            for (int i = 0; i < board.size(); i++) {
                if (numberMemoryPositionUsed > 0) {
                    board.get(i).setUsed();
                }

                numberMemoryPositionUsed--;
            }

            usedBoards++;
            return true;
        } else {
            return false;
        }
    }

    //Adiciona um novo processo e retorna uma lista com os idex dos quadros usados
    public List<Integer> addNewProcess(int processSize) throws MemoryOutOfBound{
        List<Integer> usedBoards = new ArrayList<Integer>();

        int boardsNeeded = processSize / this.boardSize;

        if ((boardsNeeded * boardSize) < processSize) {
            boardsNeeded++;
        }

        if (boardsNeeded > this.countAvailableBoards()) {
            //throw criar execeção para quando exede o tamanho da memória diponivel
            throw new MemoryOutOfBound("memoria sem expaço disponivel");
        } else {
            for (int i = 0; i < boardsNeeded; i++) {
                if (i == boardsNeeded-1) {
                    this.updateNextEmptyBoard(processSize % boardSize);
                } else {
                    this.updateNextEmptyBoard(this.boardSize);
                }
                usedBoards.add(this.getLastIndex());
            }
        }

        return usedBoards;
    }

    // ToString retornando os quadros com suas posições usadas
    @Override
    public String toString() {
        int boards = mapBoards.size();
        
        String stringMemory = "|";
        
        for (int k = 0; k < boardSize; k++) {
            stringMemory += "=";
        }
        stringMemory += "| \n";

        for (int i = 0; i < boards; i++) {
            stringMemory += "|";
            
            if (mapBoards.get(i) == null) {
                stringMemory += "|";

                for (int t = 0; t < boardSize; t++) {
                    stringMemory += "0";
                }

                stringMemory += "| \n";

            } else {
                
                LinkedList<MemoryPosition> board  = mapBoards.get(i); 
                stringMemory += "|";

                for (int w = 0; w < boardSize; w++) {
                    if (board.get(w).isUsed()) {
                        stringMemory += "1";
                    } else {
                        stringMemory += "0";
                    };
                }
                stringMemory += "| \n";
            }
        }
        stringMemory += "|";

        for (int y = 0; y < boardSize; y++) {
            stringMemory += "=";
        }
        stringMemory += "| \n";

        return stringMemory;
    }
    
}

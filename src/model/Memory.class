package model;

import java.util.List;
import java.util.LinkedList;

public class Memory{

    private LinkedList<MemoryPosition> phisicalMemory;
    private HashMap<Object, LinkedList<MemoryPosition>> mapBoards; 
    private int usedBoards;

    // mandar exceção se o calculo tiver errado
    public Memory(int size, int boardSize) { //VALIDAR SE SIZE TA CRIANDO O NUMERO CORRETO
        this.usedBoards = 0;
        this.phisicalMemory = new LinkedList<MemoryPosition>();

        for (int i = 0; i < size; i++) {
            this.phisicalMemory.add(new MemoryPosition());
        }

        System.out.println("===================   Checando tamanho memoria");
        System.out.println("Tamanho desejado = " + size);
        System.out.println("Tamanho real = " + phisicalMemory.size());


        int boardNumber = (size / boardSize);
        // board size têm que ser a quantidade de quadros

        mapBoards = new HashMap<Object, LinkedList<MemoryPosition>>();

        for (int i = 0; i < boardNumber; i++) {
            int initialPosition =  boardSize * i;
            int endPosition = (boardSize * (i+1)) - 1;

            LinkedList<MemoryPosition> subList = new LinkedList<MemoryPosition>();

            for (int j = initialPosition; j < endPosition; j++) {
                subList.add(phisicalMemory.get(j));
            }

            mapBoards.put(i, subList);
        }

        System.out.println("===================   Checando Numero quadros");
        System.out.println("Numero esperado: " + boardNumber);
        System.out.println("Numero obtido: " + mapBoards.size());
        
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

    // Saber quantos quadros estão usadosindexNextEmptyBoard
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

        if (indexNextEmptyBoard < this.countBoards() && memoryPositionUsed != 0) {
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

    // ToString retornando os quadros com suas posições usadas
    @Override
    public String toString() {
        int boardSize = mapBoards.get(0).size();
        int boards = Memory.size() / boardSize;
        
        String stringMemory = '|';
        
        for (int k = 0; k < boardSize; k++) {
            stringMemory += '=';
        }
        stringMemory += '| \n';

        for (int i = 0; i < board; i++) {
            stringMemory += '|';
            
            if (mapBoards.get(i) == null) {
                stringMemory += '|';

                for (int t = 0; t < boardSize; t++) {
                    stringMemory += '0';
                }

                stringMemory += '| \n';

            } else {
                
                LinkedList<MemoryPosition> board  = mapBoards.get(i); 
                stringMemory += '|';

                for (int w = 0; w < boardSize; w++) {
                    if (board.get(w).isUsed()) {
                        stringMemory += '1'
                    } else {
                        stringMemory += '0'
                    };
                }
                stringMemory += '| \n';
            }
        }
        stringMemory += '|';

        for (int y = 0; y < boardSize; y++) {
            stringMemory += '=';
        }
        stringMemory += '| \n';
    }
    
}

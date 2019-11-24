package model;

public class Page {

    private int boardIndex;

    public Page(int boardIndex) {
        this.boardIndex = boardIndex;
    }

    public int getBoardIndex() {
        return boardIndex;
    }

    public Page setBoardIndex(int boardIndex) {
        this.boardIndex = boardIndex;
        return this;
    }

}
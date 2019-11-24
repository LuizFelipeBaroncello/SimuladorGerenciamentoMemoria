package model;

import java.util.List;

public class TablePage {

    private String processID;
    private List<Page> pages;

    public TablePage(List<Page> pages, String processID) {
        this.pages = pages;
        this.processID = processID;
    }

    public String getProcessID() {
        return processID;
    }

    @Override
    public String toString() {
        String string = "| index | page |\n" +
                        "________________ \n";

        for (int i = 0; i < this.pages.size(); i++) {
            string +=  "|   "+ i + "   |  " + pages.get(i).getBoardIndex() + "   |\n"+
                        "________________ \n";
        }

        return string;
    }

}
package model;

import java.util.List;

public class TablePage {

    private List<Page> pages;
    private String processID;

    public TablePage(List<Page> pages, String processID) {
        this.pages = pages;
        this.processID = processID;
    }

    public List getPages() {
        return pages;
    }

    public TablePage setPages(List<Page> pages) {
        this.pages = pages;
        return this;
    }

    public TablePage addPage(Page page) {
        this.pages.add(page);
        return this;
    }

    public String getProcessID() {
        return processID;
    }

    public TablePage setProcessID(String processID) {
        this.processID = processID;
        return this;
    }

}
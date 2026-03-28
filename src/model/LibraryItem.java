package model;

public abstract class LibraryItem {
    protected int id;
    protected String title;
    protected boolean issued;

    public LibraryItem(int id, String title) {
        this.id = id;
        this.title = title;
        this.issued = false;
    }

    public abstract void displayDetails();

    public void issue() { issued = true; }
    public void returnItem() { issued = false; }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isIssued() { return issued; }
}
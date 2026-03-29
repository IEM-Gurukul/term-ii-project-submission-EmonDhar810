package model;

public abstract class LibraryItem implements Issuable {

    protected int id;
    protected String title;
    protected boolean isIssued;

    public LibraryItem(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    @Override
    public void issue() {
        this.isIssued = true;
    }

    @Override
    public void returnBook() {
        this.isIssued = false;
    }

    public abstract void displayDetails();
}
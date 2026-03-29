package model;

public class Magazine extends LibraryItem {

    private int issueNumber;

    public Magazine(int id, String title, int issueNumber) {
        super(id, title);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }
@Override
public void displayDetails() {
    System.out.println(
        "Magazine [ID=" + getId() +
        ", Title=" + getTitle() +
        ", Issue No=" + issueNumber +
        ", Status=" + (isIssued() ? "Issued" : "Available") +
        "]"
    );
}

}


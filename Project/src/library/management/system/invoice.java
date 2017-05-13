package library.management.system;

public class invoice {

    int invoiceNo;
    /*
    *   store the date of the invoice
    *   
    *   @var String
     */
    private String date;

    /*
    *   store the total amount book into the invoice
    *   
    *   @var double
     */
    private double totalAmount;

    /*
    *   store the list of the book that member are buy it
    *   
    *   @var array book
     */
    private book[] book;

    /*
    *   store the name of the member
    *   
    *   @var String
     */
    private String memberId;

    /*
    *   function to generate the invoice .......
    *
    *
    *   @param .....
    *   @return .....
     */
    private database db = database.getInstance();

    public boolean setDate(String date) {
        this.date = date;
        return true;
    }

    public String getDate() {
        return this.date;
    }

    public invoice generateInvoice(String memID, book[] book) {
        // to do ......
        invoice obj = new invoice();
        obj.memberId = memID;
        obj.date = this.date;
        obj.book = book;
        return obj;
    }

    /*
    *   function to generate the invoice .......
    *
    *
    *   @param .....
    *   @return .....
     */
    public invoice generateInvoiceByAmount(String memID, double amount) {
        // to do ......
        invoice obj = new invoice();
        obj.memberId = memID;
        obj.date = this.date;
        obj.book = book;
        obj.totalAmount = amount;
        return obj;
    }

}

package library.management.system;

import java.util.HashMap;
import static library.management.system.database.getInstance;

public class librarian {

    /*
    *   store name of librarian that are access now
    *
    *
    *   @var String
     */
    private String name;

    /*
    *   store phone number of librarian that are access now
    *
    *
    *   @var String
     */
    private String phoneNo;

    private String condition;

    /*
    *   store salary of librarian that are access now
    *
    *
    *   @var double
     */
    private double salary;

    /*
    *   store the email
    *
    *
    *   @var String
     */
    private String email;

    /*
    *   store the address
    *
    *
    *   @var String
     */
    private String address;

    /*
    *   store the gender
    *
    *
    *   @var Boolean
     */
    private Boolean gender;

    /*
    *   store the ssn
    *
    *
    *   @var int
     */
    private String ssn;

    /*
    *   store the username
    *
    *
    *   @var String
     */
    private String username;

    /*
    *   store the password
    *
    *
    *   @var String
     */
    private String password;

    /*
    *   store the date of birth
    *
    *
    *   @var String
     */
    private String dateOfBirth;

    /*
    *   store the admin
    *
    *
    *   @var Boolean
     */
    private Boolean admin;

    private String type;

    private database db = getInstance();
//    public HashMap<String, String> search;


    /*
    *   function set the name
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean setName(String name) {
        //to do ...
        this.name = name;
        return true;
    }

    /*
    *   function get the name
    *
    *
    *   @param ...  
    *   @return ...
     */
    public String getName() {
        //to do ...
        return this.name;
    }

    /*
    *   function set the phone number
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean setPhoneNo(String phone) {
        //to do ...
        this.phoneNo = phone;
        return true;
    }

    /*
    *   function get the phone number
    *
    *
    *   @param ...  
    *   @return ...
     */
    public String getPhoneNo() {
        //to do ...
        return this.phoneNo;
    }

    /*
    *   function set the gender
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean setGender(boolean gender) {
        this.gender = gender;
        return true;
    }

    /*
    *   function get the gender
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean getGender() {
        //to do ...
        return this.gender;
    }

    /*
    *   function set the email
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean setEmail(String email) {
        //to do ...
        this.email = email;
        return true;
    }

    /*
    *   function get the email
    *
    *
    *   @param ...  
    *   @return ...
     */
    public String getEmail() {
        //to do ...
        return this.email;
    }

    /*
    *   function set the salary
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean setSalary(double salary) {
        //to do ...
        this.salary = salary;
        return true;
    }

    /*
    *   function get the salary
    *
    *
    *   @param ...  
    *   @return ...
     */
    public double getSalary() {
        //to do ...
        return this.salary;
    }

    /*
    *   function set the address
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean setAddress(String address) {
        //to do ...
        this.address = address;
        return true;
    }

    /*
    *   function get the address
    *
    *
    *   @param ...  
    *   @return ...
     */
    public String getAddress() {
        //to do ...
        return this.address;
    }

    /*
    *   function set the username
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean setUsername(String username) {
        //to do ...
        this.username = username;
        return true;
    }

    /*
    *   function get the username
    *
    *
    *   @param ...  
    *   @return ...
     */
    public String getUsername() {
        //to do ...
        return this.username;
    }

    /*
    *   function set the password
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean setPassword(String password) {
        //to do ...
        this.password = password;
        return true;
    }

    /*
    *   function get the password
    *
    *
    *   @param ...  
    *   @return ...
     */
    public String getPassword() {
        //to do ...
        return this.password;
    }

    /*
    *   function set the admin
    *
    *
    *   @param ...  
    *   @return ...
     */
 /* public boolean setAdmin(){
        //to do ...
    }
    
    /*
    *   function get the admin
    *
    *
    *   @param ...  
    *   @return ...
    *
    public void getAdmin(){
        //to do ...
    }*/
 /*
    *   function set the ssn
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean setSsn(String ssn) {
        //to do ...
        this.ssn = ssn;
        return true;
    }

    /*
    *   function get the ssn
    *
    *
    *   @param ...  
    *   @return ...
     */
    public String getSsn() {
        //to do ...
        return this.ssn;
    }

    public boolean setType(String type) {
        //to do ...
        this.type = type;
        return true;
    }

    public String getType() {
        //to do ...
        return this.type;
    }

    /*
    *   function set the date of  birth
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean setDateOfBirth(String birthDate) {
        //to do ...
        this.dateOfBirth = birthDate;
        return true;
    }

    /*
    *   function get the date of  birth
    *
    *
    *   @param ...  
    *   @return ...
     */
    public String getDateOfBirth() {
        //to do ...
        return this.dateOfBirth;
    }

    /*
    *   function add new book into specific section 
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean addBook(book obj) {
        // to do ....
        HashMap<String, String> insert = new HashMap<>();
        insert.put("name", obj.getName());
        insert.put("price", Double.toString(obj.getPrice()));
        insert.put("type", obj.getType());
        insert.put("description", obj.getDescription());
        insert.put("auther", obj.getAuther());
        insert.put("numOfPaper", Integer.toString(obj.getNumOfPaper()));
        insert.put("publishPlace", obj.getPublishPlace());
        insert.put("state", Boolean.toString(obj.getState()));
        insert.put("dateOfReturn", obj.getDateOfReturn());
        return db.insert("book", insert);
    }

    /*
    *   function update book into specific section 
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean updateBook(String sn, book obj) {
        HashMap<String, String> insert = new HashMap<>();
        insert.put("name", obj.getName());
        insert.put("price", Double.toString(obj.getPrice()));
        insert.put("type", obj.getType());
        insert.put("description", obj.getDescription());
        insert.put("auther", obj.getAuther());
        insert.put("numOfPaper", Integer.toString(obj.getNumOfPaper()));
        insert.put("publishPlace", obj.getPublishPlace());
        insert.put("state", Boolean.toString(obj.getState()));
        insert.put("dateOfReturn", obj.getDateOfReturn());
        condition = "ssn = " + sn + " ";

        return db.update("book", insert, condition);
    }

    /*
    *   function delete book by serial number  into specific section 
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean deleteBook(String sn, String name) {
        // to do ....
        HashMap<String, String> delete = new HashMap<>();
        delete.put("nameTable", "book");
        delete.put("sn", sn);
        delete.put("name", name);
        delete.put("condition", "ssn = " + sn + " ");

        return db.delete(delete);
    }

    /*
    *   function add new Librarian 
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean addLibrarian(librarian obj) {
        // to do ....
        HashMap<String, String> insert = new HashMap<>();
        insert.put("salary", Double.toString(obj.getSalary()));
        insert.put("name", obj.getName());
        insert.put("phone", obj.getPhoneNo());
        insert.put("email", obj.getEmail());
        insert.put("address", obj.getAddress());
        insert.put("gender", Boolean.toString(obj.getGender()));
        insert.put("snn", obj.getSsn());
        insert.put("type", obj.getType());
        insert.put("dateOfBirth", obj.getDateOfBirth());
        insert.put("username", obj.getUsername());
        insert.put("password", obj.getPassword());
        return db.insert("librarian", insert);
    }

    /*
    *   function update librarian by id  
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean updateLibrarian(String id, librarian obj) {
        // to do ....
        HashMap<String, String> insert = new HashMap<>();
        insert.put("salary", Double.toString(obj.getSalary()));
        insert.put("name", obj.getName());
        insert.put("phone", obj.getPhoneNo());
        insert.put("email", obj.getEmail());
        insert.put("address", obj.getAddress());
        insert.put("gender", Boolean.toString(obj.getGender()));
        insert.put("snn", obj.getSsn());
        insert.put("type", obj.getType());
        insert.put("dateOfBirth", obj.getDateOfBirth());
        insert.put("username", obj.getUsername());
        insert.put("password", obj.getPassword());
        condition = "id = " + id + " ";

        return db.update("librarian", insert, condition);
    }

    /*
    *   function delete librarian by id
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean deleteLibrarian(String id) {
        // to do ....
        HashMap<String, String> delete = new HashMap<>();
        delete.put("nameTable", "librarian");
        delete.put("condition", "id = " + id + " ");
        return db.delete(delete);
    }

    /*
    *   function add new member
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean addMember(member obj) { // there is error ther becuase when the class liberian fnish everything well be okay
        HashMap<String, String> insert = new HashMap<>();
        insert.put("name", obj.getName());
        insert.put("phone", obj.getPhoneNo());
        insert.put("email", obj.getEmail());
        insert.put("address", obj.getAddress());
        insert.put("gender", Boolean.toString(obj.getGender()));
        insert.put("snn", obj.getSsn());
        insert.put("type", obj.getType());
        insert.put("dateOfBirth", obj.getDateOfBirth());
        return db.insert("member", insert);
    }

    public boolean deleteMember(String id) {
        HashMap<String, String> delete = new HashMap<>();
        delete.put("nameTable", "member");
        delete.put("condition", "id = " + id + " ");
        return db.delete(delete);
    }

    public boolean editMember(String id, member obj) {
        HashMap<String, String> insert = new HashMap<>();
        insert.put("name", obj.getName());
        insert.put("phone", obj.getPhoneNo());
        insert.put("email", obj.getEmail());
        insert.put("address", obj.getAddress());
        insert.put("gender", Boolean.toString(obj.getGender()));
        insert.put("snn", obj.getSsn());
        insert.put("type", obj.getType());
        insert.put("dateOfBirth", obj.getDateOfBirth());
        condition = "id = " + id + " ";

        return db.update("member", insert, condition);
    }

    /*
    *   function add new section
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean addSection(section obj) {
        HashMap<String, String> insert = new HashMap<>();
        insert.put("name", obj.getName());
        insert.put("numOfBook", Integer.toString(obj.getNumOfBook()));
        insert.put("sn", obj.getSn());
        insert.put("description", obj.getDescription());
        return db.insert("section", insert);
    }

    public boolean editSection(section obj, String sn) {

        HashMap<String, String> edit = new HashMap<>();
        edit.put("name", obj.getName());
        edit.put("numOfBook", Integer.toString(obj.getNumOfBook()));
        edit.put("sn", obj.getSn());
        edit.put("description", obj.getDescription());
        condition = "sn = " + sn + " ";

        return db.update("section", edit, condition);
    }

    public boolean deleteSection(String sn, String name) {
        HashMap<String, String> delete = new HashMap<>();
        delete.put("nameTable", "section");
        delete.put("condition", "sn = " + sn + " ");
        return db.delete(delete);
    }


    /*
    *   function for search book
    *
    *
    *   @param ...  
    *   @return ...
     */
    public book searchBook(String sn, String name) {
        HashMap<String, String> search = new HashMap<>();
        search.put("column", " * ");
        search.put("nameTable", "book");
        search.put("condition", "sn = " + sn + " ");

        return (book) db.select(search);
    }

    /*
    *   function search member
    *
    *
    *   @param ...  
    *   @return ...
     */
    public member searchMember(String id) {
        HashMap<String, String> search = new HashMap<>();

        search.put("column", " * ");
        search.put("nameTable", "member");
        search.put("condition", "id = " + id + " ");

        return (member) db.select(search);
    }

    /*
    *   function search section
    *
    *
    *   @param ...  
    *   @return ...
     */
    public section searchSection(String sn, String name) {
        HashMap<String, String> search = new HashMap<>();

        search.put("column", " * ");
        search.put("nameTable", "section");
        search.put("condition", "sn = " + sn + " ");

        return (section) db.select(search);
    }

    /*
    *   function show the invoice
    *
    *
    *   @param ...  
    *   @return ...
     */
    public invoice showInvoice(String memID, book[] book) {
        // to do ....
        invoice obj = new invoice();
        return obj.generateInvoice(memID, book);
    }

    /*
    *   function show invoice by amount
    *
    *
    *   @param ...  
    *   @return ...
     */
    public invoice showInvoiceByAmount(String memID, double amount) {
        invoice obj = new invoice();
        return obj.generateInvoiceByAmount(memID, amount);
    }

    /*
    *   function for login librarian
    *
    *
    *   @param ...  
    *   @return ...
     */
    public boolean login(String username, String password) {
        // to do ....
        HashMap<String, String> search = new HashMap<String, String>();

        search.put("column", " * ");
        search.put("condition", "username = " + username + " " + "password = " + password);
        search.put("nameTable", "user");

        if (db.select(search) == null) {
            return false;
        } else {
            return true;
        }

    }

    /*
    *   function to logout the librarian from the system
    *
    *
    *   @param ...  
    *   @return ...
     */
    public void logout() {
        this.login(null, null);
    }

}

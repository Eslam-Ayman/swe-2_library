package swegui;

//import member class from control package
import control.bookData;
import control.libData;
import control.memberData;
import control.sectionData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Ahmed Hesham
 */
public class librarian extends JFrame implements ActionListener {

    //prepare width , height of fields & labels and x position of label & field
    int width = 250, height = 35, x1 = 250, x2 = 100;

    //username
    static String username = "";

    //frame variables for lib_form function
    //fields to get member data (input)
    JTextField nameField, phoneField, emailField, addressField, ssnField, b_dayField, userField, passField, salaryField;
    //labels for member data
    JLabel nameLabel, phoneLabel, emailLabel, addressLabel, ssnLabel, b_dayLabel, genderLabel, userLabel, passLabel, salaryLabel, adminLabel;
    //checkbox to get member gender
    JRadioButton male, female, admin;
    ButtonGroup gender = new ButtonGroup();
    JButton add = new JButton("Add Librarian"), edit = new JButton("Edit Librarian"), back = new JButton("Back"), deleteBtn = new JButton("Delete Librarian");
    //end of lib_form frame variables
    
    //login_form function variables
    JTextField usernameField = new JTextField(), passwordField = new JPasswordField();
    JLabel usernameLabel = new JLabel("Username : "), passwordLabel = new JLabel("Password : ");
    JButton loginBtn = new JButton("Login"), exitBtn = new JButton("Exit");
    //end of login_form function variables

    
    //frame variables for main_frame function
    //only buttons
    JButton add_lib = new JButton("Add Librarian"),edit_lib = new JButton("Edit Librarian"),
            delete_lib = new JButton("Delete Librarian"),search_lib = new JButton("Search Librarian"),
            add_book = new JButton("Add Book"),edit_book = new JButton("Edit Book"),
            delete_book = new JButton("Delete Book"),search_book = new JButton("Search Book"),
            add_section = new JButton("Add Section"),edit_section = new JButton("Edit Section"),
            delete_section = new JButton("Delete Section"),search_section = new JButton("Search Section"),
            add_mem = new JButton("Add Member"),edit_mem = new JButton("Edit Member"),
            delete_mem = new JButton("Delete Member"),search_mem = new JButton("Search Member"),
            memberPayFee = new JButton("Member Pay Fee"),generate_invoice = new JButton("Generate Invoice"),
            logout = new JButton("Logout"),exitSys = new JButton("Exit Program");
    //end of frame variables of main_frame function
    
    //prepare constructor of member frame
    public librarian() {
        this.setTitle("Librarian Frame");
        this.setResizable(false);
        this.setLocation(300, 0);
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
    }

    /* function name : lib_form
    ** parameter : boolean to select add or edit a Librarian , an Librarian object to edit it's data 
    **                  , boolean to show only and boolean to delete
    ** implementation : 1-prepare text field variable to get input from user
    **                  2-prepare label of input variable
    **                  3-prepare checkbox to select Librarian gender
    **                  4-prepare admin checkbox to set an admin
    **                  5-prepare add edit delete and back buttons
    **                  6-check if boolean parameter true or false
    **                      true : check if member object null or not and set it's attribute to input fields
    **                      false: make edit button unvisible to add a user
    **                  7-need to prepare actions of button
    **                  8-make fields uneditable to show data only need (Librarian object and show ture)
    **                  9-make fields uneditable to delete Librarian need (Librarian object and delete ture)
    ** parameter and it's meaning
    **      1-false,null,false,false => add new Librarian
    **      2-true,member object,false,false => edit Librarian data using Librarian object
    **      3-false,member object,true,false => show Librarian data only neither edit nor add
    **      4-false,member object,false,true => show Librarian data and delete button to delete Librarian
     */
    public void lib_form(boolean editMember, libData memberObj, boolean show, boolean delete) {
        this.setSize(600, 720);
        this.getContentPane().removeAll();

        //initialize fields and set it's bound to set it at specific position in frame
        nameField = new JTextField();
        this.add(nameField);
        nameField.setBounds(x1, 15, width, height);

        nameLabel = new JLabel("Librarian Name");
        this.add(nameLabel);
        nameLabel.setBounds(x2, 15, width, height);

        phoneField = new JTextField();
        this.add(phoneField);
        phoneField.setBounds(x1, 65, width, height);

        phoneLabel = new JLabel("Librarian Phone");
        this.add(phoneLabel);
        phoneLabel.setBounds(x2, 65, width, height);

        emailField = new JTextField();
        this.add(emailField);
        emailField.setBounds(x1, 115, width, height);

        emailLabel = new JLabel("Librarian Email");
        this.add(emailLabel);
        emailLabel.setBounds(x2, 115, width, height);

        addressField = new JTextField();
        this.add(addressField);
        addressField.setBounds(x1, 165, width, height);

        addressLabel = new JLabel("Librarian Address");
        this.add(addressLabel);
        addressLabel.setBounds(x2, 165, width, height);

        ssnField = new JTextField();
        this.add(ssnField);
        ssnField.setBounds(x1, 215, width, height);

        ssnLabel = new JLabel("Librarian SSN");
        this.add(ssnLabel);
        ssnLabel.setBounds(x2, 215, width, height);

        b_dayField = new JTextField();
        this.add(b_dayField);
        b_dayField.setBounds(x1, 265, width, height);

        b_dayLabel = new JLabel("Librarian Birth Day");
        this.add(b_dayLabel);
        b_dayLabel.setBounds(x2, 265, width, height);

        genderLabel = new JLabel("Librarian Gender");
        this.add(genderLabel);
        genderLabel.setBounds(x2, 315, width, height);

        //prepare gender checkbox
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        //add gender checkbox to button group
        gender.add(male);
        gender.add(female);

        //set checkbox to specific position in frame
        this.add(male);
        male.setBounds(x1, 315, width, height);

        this.add(female);
        female.setBounds(x1, 345, width, height);

        //user ,salary , admin check and pass of librarian
        userLabel = new JLabel("Librarian Username :");
        this.add(userLabel);
        userLabel.setBounds(x2, 385, width, height);

        userField = new JTextField();
        this.add(userField);
        userField.setBounds(x1, 385, width, height);

        passLabel = new JLabel("Librarian Password :");
        this.add(passLabel);
        passLabel.setBounds(x2, 435, width, height);

        passField = new JPasswordField();
        this.add(passField);
        passField.setBounds(x1, 435, width, height);

        salaryField = new JTextField();
        this.add(salaryField);
        salaryField.setBounds(x1, 485, width, height);

        salaryLabel = new JLabel("Librarian Salary :");
        this.add(salaryLabel);
        salaryLabel.setBounds(x2, 485, width, height);

        admin = new JRadioButton("ADMIN");
        this.add(admin);
        admin.setBounds(x1, 535, width, height);

        adminLabel = new JLabel("Admin Or Librarian");
        this.add(adminLabel);
        adminLabel.setBounds(x2, 535, width, height);

        //prepare buttons
        this.add(add);
        add.setBounds(x1, 585, width, height + 10);
        add.setActionCommand("addlibdata");
        add.addActionListener(this);

        this.add(edit);
        edit.setBounds(x1, 585, width, height + 10);
        edit.setActionCommand("editlibdata");
        edit.addActionListener(this);

        this.add(deleteBtn);
        deleteBtn.setBounds(x1, 585, width, height + 10);
        deleteBtn.setActionCommand("deletelibdata");
        deleteBtn.addActionListener(this);

        this.add(back);
        back.setBounds(x1, 635, width, height + 10);
        back.setActionCommand("backlibdata");
        back.addActionListener(this);

        if (editMember && memberObj != null && !show) {
            add.setVisible(false);
            deleteBtn.setVisible(false);

            nameField.setText(memberObj.name);
            emailField.setText(memberObj.email);
            phoneField.setText(memberObj.phone);
            addressField.setText(memberObj.address);
            b_dayField.setText(memberObj.b_day);
            ssnField.setText(memberObj.ssn);
            userField.setText(memberObj.user);
            passField.setText(memberObj.pass);
            salaryField.setText(memberObj.salary);
            if (memberObj.gender.equals("Male")) {
                male.setSelected(true);
            } else if (memberObj.gender.equals("Female")) {
                female.setSelected(true);
            }
            if (memberObj.admin == true) {
                admin.setSelected(true);
            }
        } else if ((show || delete) && memberObj != null) {
            add.setVisible(false);
            edit.setVisible(false);
            if (!delete) {
                back.setBounds(x1, 585, width, height + 10);
                deleteBtn.setVisible(false);
            }

            nameField.setText(memberObj.name);
            nameField.setEditable(false);

            emailField.setText(memberObj.email);
            emailField.setEditable(false);

            phoneField.setText(memberObj.phone);
            phoneField.setEditable(false);

            addressField.setText(memberObj.address);
            addressField.setEditable(false);

            b_dayField.setText(memberObj.b_day);
            b_dayField.setEditable(false);

            ssnField.setText(memberObj.ssn);
            ssnField.setEditable(false);

            userField.setText(memberObj.user);
            userField.setEditable(false);

            passField.setText(memberObj.pass);
            passField.setEditable(false);

            salaryField.setText(memberObj.salary);
            salaryField.setEditable(false);

            if (memberObj.gender.equals("Male")) {
                male.setSelected(true);
                male.setEnabled(true);
                female.setEnabled(false);
            } else if (memberObj.gender.equals("Female")) {
                female.setSelected(true);
                female.setEnabled(true);
                male.setEnabled(false);
            }
            if (memberObj.admin) {
                admin.setSelected(true);
            }
            admin.setEnabled(false);
        } else {
            add.setVisible(true);
            edit.setVisible(false);
            deleteBtn.setVisible(false);
        }
    }

    /*
    ** Function Name : main_frame
    ** Parameters : no parameter
    ** Implementation : prepare all buttons on the frame to set it's position and handle it's action
    */
    public void main_frame() {
        this.getContentPane().removeAll();
        this.setTitle("Main Frame");
        this.setSize(800, 470);
        this.setLocation(150,0);
        int x_1=10,x_2=210,x_3=410,x_4=610,_width=180,btn_height = 50;
        
        this.add(add_lib);
        add_lib.setBounds(x_1,50,_width,btn_height);
        add_lib.setActionCommand("add_lib");
        add_lib.addActionListener(this);
        
        this.add(edit_lib);
        edit_lib.setBounds(x_2,50,_width,btn_height);
        edit_lib.setActionCommand("edit_lib");
        edit_lib.addActionListener(this);
        
        this.add(delete_lib);
        delete_lib.setBounds(x_3,50,_width,btn_height);
        delete_lib.setActionCommand("delete_lib");
        delete_lib.addActionListener(this);
        
        this.add(search_lib);
        search_lib.setBounds(x_4,50,_width,btn_height);
        search_lib.setActionCommand("search_lib");
        search_lib.addActionListener(this);
        
        this.add(add_book);
        add_book.setBounds(x_1,110,_width,btn_height);
        add_book.setActionCommand("add_book");
        add_book.addActionListener(this);
        
        this.add(edit_book);
        edit_book.setBounds(x_2,110,_width,btn_height);
        edit_book.setActionCommand("edit_book");
        edit_book.addActionListener(this);
        
        this.add(delete_book);
        delete_book.setBounds(x_3,110,_width,btn_height);
        delete_book.setActionCommand("delete_book");
        delete_book.addActionListener(this);
        
        this.add(search_book);
        search_book.setBounds(x_4,110,_width,btn_height);
        search_book.setActionCommand("search_book");
        search_book.addActionListener(this);
        
        this.add(add_section);
        add_section.setBounds(x_1,170,_width,btn_height);
        add_section.setActionCommand("add_section");
        add_section.addActionListener(this);
        
        this.add(edit_section);
        edit_section.setBounds(x_2,170,_width,btn_height);
        edit_section.setActionCommand("edit_section");
        edit_section.addActionListener(this);
        
        this.add(delete_section);
        delete_section.setBounds(x_3,170,_width,btn_height);
        delete_section.setActionCommand("delete_section");
        delete_section.addActionListener(this);
        
        this.add(search_section);
        search_section.setBounds(x_4,170,_width,btn_height);
        search_section.setActionCommand("search_section");
        search_section.addActionListener(this);
        
        this.add(add_mem);
        add_mem.setBounds(x_1,230,_width,btn_height);
        add_mem.setActionCommand("add_mem");
        add_mem.addActionListener(this);
        
        this.add(edit_mem);
        edit_mem.setBounds(x_2,230,_width,btn_height);
        edit_mem.setActionCommand("edit_mem");
        edit_mem.addActionListener(this);
        
        this.add(delete_mem);
        delete_mem.setBounds(x_3,230,_width,btn_height);
        delete_mem.setActionCommand("delete_mem");
        delete_mem.addActionListener(this);
        
        this.add(search_mem);
        search_mem.setBounds(x_4,230,_width,btn_height);
        search_mem.setActionCommand("search_mem");
        search_mem.addActionListener(this);
        
        this.add(memberPayFee);
        memberPayFee.setBounds(x_1,290,_width+200,btn_height);
        memberPayFee.setActionCommand("memberPayFee");
        memberPayFee.addActionListener(this);
        
        this.add(generate_invoice);
        generate_invoice.setBounds(x_3,290,_width+200,btn_height);
        generate_invoice.setActionCommand("generate_invoice");
        generate_invoice.addActionListener(this);
        
        this.add(logout);
        logout.setBounds(x_1,370,_width+200,btn_height);
        logout.setActionCommand("logout");
        logout.addActionListener(this);
        
        this.add(exitSys);
        exitSys.setBounds(x_3,370,_width+200,btn_height);
        exitSys.setActionCommand("exitSys");
        exitSys.addActionListener(this);
    }

    /*
    ** Function Name : login_form()
    ** Parameters : no parameter
    ** Implementation : 1-remove all frame component
    **                  2-set new sze , title and location
    **                  3-set attributes for variables using in frame to make an login form
    **                  4-set a listener to buttons
     */
    public void login_form() {
        this.getContentPane().removeAll();
        this.setTitle("Login Form");
        this.setSize(600, 320);
        this.setLocation(300, 100);

        this.add(usernameLabel);
        usernameLabel.setBounds(x2, 50, width, height);

        this.add(usernameField);
        usernameField.setBounds(x1, 50, width, height);

        this.add(passwordLabel);
        passwordLabel.setBounds(x2, 100, width, height);

        this.add(passwordField);
        passwordField.setBounds(x1, 100, width, height);

        this.add(loginBtn);
        loginBtn.setBounds(x1, 150, width, height + 10);
        loginBtn.setActionCommand("login");
        loginBtn.addActionListener(this);

        this.add(exitBtn);
        exitBtn.setBounds(x1, 210, width, height + 10);
        exitBtn.setActionCommand("exit");
        exitBtn.addActionListener(this);
    }

    public static void main(String args[]) {
        /* test implementation
        //prepare an member object to test
        libData ahmed = new libData("Ahmed Hesham", "01145618685",
                "ahmed@test.test", "Mokattam",
                "20140063", "27/4/1996", "Male", "root", "root", "2500", true);

        //check frame functionality lib_form function
        //1- new librarian().lib_form(false,null,false,false);
        //2- new librarian().lib_form(true,ahmed,false,false);
        //3- new librarian().lib_form(false,ahmed,true,false);
        //4- new librarian().lib_form(false,ahmed,false,true);
        /*      1-false,null,false,false => add new member
        **      2-true,member object,false,false => edit member data using member object
        **      3-false,member object,true,false => show member data only neither edit nor add
        **      4-false,member object,false,true => show member data and delete button to delete member
         */
        new librarian().login_form();
    }

    //an override method to make action of buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        //check if comes action login to check username and password and move user to other screen
        if (e.getActionCommand().equals("login")) {
            String username = this.usernameField.getText(), password = this.passwordField.getText();
            if (username.equals("test") && password.equals("test")) {
                this.main_frame();
            } else {
                JOptionPane.showMessageDialog(null, "Please Enter a correct username and password");
            }
        } //check if user check exit button to exit the program
        else if (e.getActionCommand().equals("exit")||e.getActionCommand().equals("exitSys")) {
            this.dispose();
        }
        //check if user click add librarian data button
        else if(e.getActionCommand().equals("addlibdata")){
            this.main_frame();
        }
        //check if user click edit librarian data button
        else if(e.getActionCommand().equals("editlibdata")){
            this.main_frame();
        }
        //check if user click delete librarian data button
        else if(e.getActionCommand().equals("deletelibdata")){
            this.main_frame();
        }
        //check if user click back librarian data button
        else if(e.getActionCommand().equals("backlibdata")){
            this.main_frame();
        }
        //check if user click logout button
        else if(e.getActionCommand().equals("logout")){
            this.login_form();
        }
        //check if user click add lib button
        else if(e.getActionCommand().equals("add_lib")){
            this.lib_form(false, null,false, false);
        }
        //check if user click edit lib button
        else if(e.getActionCommand().equals("edit_lib")){
            String lib_ssn_id = JOptionPane.showInputDialog(null, "Enter Librarian ID or SSN");
            //name,phone,email,address ,ssn,b_day,gender,user,pass,salary;
            libData librarian = new libData("Test Librarain Name","01111111222","lib@lib.lib"
                    ,"Test Librarain Address","Test Librarain SSN","dd/mm/yyyy","Male","test","test","3500",false);
            this.lib_form(true, librarian,false, false);
        }
        //check if user click delete lib button
        else if(e.getActionCommand().equals("delete_lib")){
            String lib_ssn_id = JOptionPane.showInputDialog(null, "Enter Librarian ID or SSN");
            //name,phone,email,address ,ssn,b_day,gender,user,pass,salary;
            libData librarian = new libData("Test Librarain Name","01111111222","lib@lib.lib"
                    ,"Test Librarain Address","Test Librarain SSN","dd/mm/yyyy","Male","test","test","3500",false);
            this.lib_form(false, librarian,false, true);
        }
        //check if user click delete lib button
        else if(e.getActionCommand().equals("search_lib")){
            String lib_ssn_id = JOptionPane.showInputDialog(null, "Enter Librarian ID or SSN");
            //name,phone,email,address ,ssn,b_day,gender,user,pass,salary;
            libData librarian = new libData("Test Librarain Name","01111111222","lib@lib.lib"
                    ,"Test Librarain Address","Test Librarain SSN","dd/mm/yyyy","Male","test","test","3500",false);
            this.lib_form(false, librarian,true,false);
        }
        //check if user click add book button
        else if(e.getActionCommand().equals("add_book")){
            new book().book_form(false, null, false, false);
            this.dispose();
        }
        //check if user click edit book button
        else if(e.getActionCommand().equals("edit_book")){
            String book_ssn_id = JOptionPane.showInputDialog(null, "Enter Book ID or SSN");
            bookData book = new bookData("test book","test book","test book","test book","test book","test book"
                            ,"test book","test book","test book");
            this.dispose();
            new book().book_form(true, book, false, false);
        }
        //check if user click delete book button
        else if(e.getActionCommand().equals("delete_book")){
            String book_ssn_id = JOptionPane.showInputDialog(null, "Enter Book ID or SSN");
            bookData book = new bookData("test book","test book","test book","test book","test book","test book"
                            ,"test book","test book","test book");
            this.dispose();
            new book().book_form(false, book, false, true);
        }
        //check if user click search book button
        else if(e.getActionCommand().equals("search_book")){
            String book_ssn_id = JOptionPane.showInputDialog(null, "Enter Book ID or SSN");
            bookData book = new bookData("test book","test book","test book","test book","test book","test book"
                            ,"test book","test book","test book");
            this.dispose();
            new book().book_form(false, book, true,false);
        }
        //check if user click add section
        else if(e.getActionCommand().equals("add_section")){
            new section().section_form(false, null, false, false);
            this.dispose();
        }
        //check if user click edit section
        else if(e.getActionCommand().equals("edit_section")){
            String sec_ssn_id = JOptionPane.showInputDialog(null, "Enter Section ID or SSN");
            sectionData sec = new sectionData("test section","test section","test section","test section");
            new section().section_form(true, sec, false, false);
            this.dispose();
        }
        //check if user click delete section
        else if(e.getActionCommand().equals("delete_section")){
            String sec_ssn_id = JOptionPane.showInputDialog(null, "Enter Section ID or SSN");
            sectionData sec = new sectionData("test section","test section","test section","test section");
            new section().section_form(false, sec, false, true);
            this.dispose();
        }
        //check if user click delete section
        else if(e.getActionCommand().equals("search_section")){
            String sec_ssn_id = JOptionPane.showInputDialog(null, "Enter Section ID or SSN");
            sectionData sec = new sectionData("test section","test section","test section","test section");
            new section().section_form(false, sec, true, false);
            this.dispose();
        }
        //check if user click add member button
        else if(e.getActionCommand().equals("add_mem")){
            this.dispose();
            new member().member_form(false,null, false, false);
            this.dispose();
        }
        //check if user click edit member button
        else if(e.getActionCommand().equals("edit_mem")){
            String mem_ssn_id = JOptionPane.showInputDialog(null, "Enter Member ID or SSN");
            memberData member = new memberData("test member data","test member data","test member data",
                    "test member data","test member data","test member data","Male");
            new member().member_form(true, member, false, false);
            this.dispose();
        }
        //check if user click delete member button
        else if(e.getActionCommand().equals("delete_mem")){
            String mem_ssn_id = JOptionPane.showInputDialog(null, "Enter Member ID or SSN");
            memberData member = new memberData("test member data","test member data","test member data",
                    "test member data","test member data","test member data","Male");
            new member().member_form(false, member, false, true);
            this.dispose();
        }
        //check if user click search member button
        else if(e.getActionCommand().equals("search_mem")){
            String mem_ssn_id = JOptionPane.showInputDialog(null, "Enter Member ID or SSN");
            memberData member = new memberData("test member data","test member data","test member data",
                    "test member data","test member data","test member data","Male");
            new member().member_form(false, member, true, false);
            this.dispose();
        }
        //check if user click generate invoice button
        else if(e.getActionCommand().equals("generate_invoice")){
            bookData books[] = new bookData[5];
            books[0] = new bookData("Java", "", "", "0", "", "", "", "", "");
            books[1] = new bookData("Php", "", "", "1500", "", "", "", "", "");
            books[2] = new bookData("C++", "", "", "500", "", "", "", "", "");
            books[3] = new bookData("OS", "", "", "650", "", "", "", "", "");
            books[4] = new bookData("SWE", "", "", "", "", "", "", "", "");
            new invoice().generateInvoice("00/11/2222","test Name", books);
            this.dispose();
        }
        //check if user click pay member fee
        else if (e.getActionCommand().equals("memberPayFee")){
            new member().pay_member_fee();
            this.dispose();
        }
    }
}

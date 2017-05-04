package swegui;

//import member class from control package
import control.memberData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Ahmed Hesham
 */
public class member extends JFrame implements ActionListener{

    //prepare width , height of fields & labels and x position of label & field
    int width = 250, height = 35, x1 = 250, x2 = 100;

    //frame variables for member_form function
    //fields to get member data (input)
    JTextField nameField, phoneField, emailField, addressField, ssnField, b_dayField;
    //labels for member data
    JLabel nameLabel, phoneLabel, emailLabel, addressLabel, ssnLabel, b_dayLabel, genderLabel;
    //checkbox to get member gender
    JRadioButton male, female;
    ButtonGroup gender = new ButtonGroup();
    JButton add = new JButton("Add Member"), edit = new JButton("Edit Member"),
            back = new JButton("Back"), deleteBtn = new JButton("Delete Member");
    //end of frame variables

    //frame variables for pay_fee function
    //fields to get member data (input)
    JTextField memberIDField = new JTextField(), amountField = new JTextField();
    //labels for member data
    JLabel memberIDLabel = new JLabel("Member ID (SSN)"), amountLabel = new JLabel("Amount");
    JButton pay = new JButton("Pay Fee"), backBtn = new JButton("Back");
    //end of frame variables for pay_fee function

    //prepare constructor of member frame
    public member() {
        this.setTitle("Member Frame");
        this.setResizable(false);
        this.setLocation(300, 100);
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
    }

    /* function name : member_form
    ** parameter : boolean to select add or edit a member , an member object to edit it's data 
    **                  , boolean to show only and boolean to delete
    ** implementation : 1-prepare text field variable to get input from user
    **                  2-prepare label of input variable
    **                  3-prepare checkbox to select member gender
    **                  4-prepare add edit and back buttons
    **                  5-check if boolean parameter true or false
    **                      true : check if member object null or not and set it's attribute to input fields
    **                      false: make edit button unvisible to add a user
    **                  6-need to prepare actions of button
    **                  7-make fields uneditable to show data only need (member object and show ture)
    **                  8-make fields uneditable to delete member need (member object and delete ture)
    ** parameter and it's meaning
    **      1-false,null,false,false => add new member
    **      2-true,member object,false,false => edit member data using member object
    **      3-false,member object,true,false => show member data only neither edit nor add
    **      4-false,member object,false,true => show member data and delete button to delete member
     */
    public void member_form(boolean editMember, memberData memberObj, boolean show, boolean delete) {
        this.getContentPane().removeAll();

        //initialize fields and set it's bound to set it at specific position in frame
        nameField = new JTextField();
        this.add(nameField);
        nameField.setBounds(x1, 55, width, height);

        nameLabel = new JLabel("Member Name");
        this.add(nameLabel);
        nameLabel.setBounds(x2, 55, width, height);

        phoneField = new JTextField();
        this.add(phoneField);
        phoneField.setBounds(x1, 105, width, height);

        phoneLabel = new JLabel("Member Phone");
        this.add(phoneLabel);
        phoneLabel.setBounds(x2, 105, width, height);

        emailField = new JTextField();
        this.add(emailField);
        emailField.setBounds(x1, 155, width, height);

        emailLabel = new JLabel("Member Email");
        this.add(emailLabel);
        emailLabel.setBounds(x2, 155, width, height);

        addressField = new JTextField();
        this.add(addressField);
        addressField.setBounds(x1, 205, width, height);

        addressLabel = new JLabel("Member Address");
        this.add(addressLabel);
        addressLabel.setBounds(x2, 205, width, height);

        ssnField = new JTextField();
        this.add(ssnField);
        ssnField.setBounds(x1, 255, width, height);

        ssnLabel = new JLabel("Member SSN");
        this.add(ssnLabel);
        ssnLabel.setBounds(x2, 255, width, height);

        b_dayField = new JTextField();
        this.add(b_dayField);
        b_dayField.setBounds(x1, 305, width, height);

        b_dayLabel = new JLabel("Member Birth Day");
        this.add(b_dayLabel);
        b_dayLabel.setBounds(x2, 305, width, height);

        genderLabel = new JLabel("Member Gender");
        this.add(genderLabel);
        genderLabel.setBounds(x2, 355, width, height);

        //prepare gender checkbox
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        //add gender checkbox to button group
        gender.add(male);
        gender.add(female);

        //set checkbox to specific position in frame
        this.add(male);
        male.setBounds(x1, 355, width, height);

        this.add(female);
        female.setBounds(x1, 385, width, height);

        //prepare buttons
        this.add(add);
        add.setBounds(x1, 435, width, height + 10);
        add.setActionCommand("addmember");
        add.addActionListener(this);

        this.add(edit);
        edit.setBounds(x1, 435, width, height + 10);
        edit.setActionCommand("editmember");
        edit.addActionListener(this);

        this.add(deleteBtn);
        deleteBtn.setBounds(x1, 435, width, height + 10);
        deleteBtn.setActionCommand("deletemember");
        deleteBtn.addActionListener(this);

        this.add(back);
        back.setBounds(x1, 495, width, height + 10);
        back.setActionCommand("backBtn");
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
            if (memberObj.gender.equals("Male")) {
                male.setSelected(true);
            } else if (memberObj.gender.equals("Female")) {
                female.setSelected(true);
            }
        } else if ((show || delete) && memberObj != null) {
            add.setVisible(false);
            edit.setVisible(false);
            if (!delete) {
                back.setBounds(x1, 435, width, height + 10);
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

            if (memberObj.gender.equals("Male")) {
                male.setSelected(true);
                male.setEnabled(true);
                female.setEnabled(false);
            } else if (memberObj.gender.equals("Female")) {
                female.setSelected(true);
                female.setEnabled(true);
                male.setEnabled(false);
            }
        } else {
            add.setVisible(true);
            edit.setVisible(false);
            deleteBtn.setVisible(false);
        }
    }

    /* function name : pay_member_fee
    ** parameter : no parameter
    ** implementation : 1-set frame size
    **                  2-prepare nutton , fields and labels variable
    **                  3-set it's bound to set it on the frame
    **                  4-need to implement actions for buttons
     */
    public void pay_member_fee() {
        this.getContentPane().removeAll();
        this.setSize(600, 320);

        //prepare id field
        this.add(memberIDField);
        memberIDField.setBounds(x1, 50, width, height);

        //prepare id label
        this.add(memberIDLabel);
        memberIDLabel.setBounds(x2, 50, width, height);

        //prepare amount field
        this.add(amountField);
        amountField.setBounds(x1, 105, width, height);

        //prepare amount label
        this.add(amountLabel);
        amountLabel.setBounds(x2, 105, width, height);

        //prepare pay button
        this.add(pay);
        pay.setBounds(x1, 155, width, height + 10);
        pay.setActionCommand("payfee");
        pay.addActionListener(this);

        //prepare back button
        this.add(backBtn);
        backBtn.setBounds(x1, 215, width, height + 10);
        backBtn.setActionCommand("backfee");
        backBtn.addActionListener(this);
    }

    /* test code
    public static void main(String args[]) {
        //prepare an member object to test
        memberData ahmed = new memberData("Ahmed Hesham", "01145618685",
                "ahmed@test.test", "Mokattam",
                "20140063", "27/4/1996", "Male");
        //check frame functionality pay_member_fee function
        //new member().pay_member_fee();

        //check frame functionality member_form function
        //1- new member().member_form(false,null,false,false);
        //2- new member().member_form(true,ahmed,false,false);
        //3- new member().member_form(false,ahmed,true,false);
        //4- new member().member_form(false,ahmed,false,true);
        /*      1-false,null,false,false => add new member
        **      2-true,member object,false,false => edit member data using member object
        **      3-false,member object,true,false => show member data only neither edit nor add
        **      4-false,member object,false,true => show member data and delete button to delete member
        *
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        //check user click button
        //member_form function buttons
        //check if user click add member
        if(e.getActionCommand().equals("addmember")){
            new librarian().main_frame();
            this.dispose();
        }
        //check if user click edit member
        else if(e.getActionCommand().equals("editmember")){
            new librarian().main_frame();
            this.dispose();
        }
        //check if user click delete member
        else if(e.getActionCommand().equals("deletemember")){
            new librarian().main_frame();
            this.dispose();
        }
        //check if user click back button
        else if(e.getActionCommand().equals("backBtn")){
            new librarian().main_frame();
            this.dispose();
        }
        
        //pay_fee buttons
        //check if user click pay fee button
        else if(e.getActionCommand().equals("payfee")){
            new librarian().main_frame();
            this.dispose();
        }
        //check if user click back button in payfee function
        else if(e.getActionCommand().equals("backfee")){
            new librarian().main_frame();
            this.dispose();
        }
    }
}

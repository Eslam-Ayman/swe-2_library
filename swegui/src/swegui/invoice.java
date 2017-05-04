/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swegui;

import control.bookData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Ahmed
 */
public class invoice extends JFrame implements ActionListener {

    //prepare width , height of fields & labels and x position of label & field
    int width = 250, height = 35, x1 = 250, x2 = 100;

    //frame variables for generateInvoice function
    //prepare fields and labels variables
    JTextField dateField, memberNameField, totalField, book1_Field, book2_Field, book3_Field,
            book4_Field, book5_Field;
    JLabel dateLabel, memberNameLabel, totalLabel, book1_Label, book2_Label, book3_Label, book4_Label, book5_Label;
    JButton backBtn = new JButton("Back"), generateBtn = new JButton("Generate Invoice");
    //end frame variables of generateInvoice function

    //prepare constructor of member frame
    public invoice() {
        this.setTitle("Invoice Frame");
        this.setResizable(false);
        this.setLocation(300, 100);
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
    }

    /*
    ** Function Name : generateInvoice
    ** Parameters : date , member name , list of books with maximum 5 books
    ** Implementation : 1-check books array length
    **                  2-prepare fields , labels and buttons for inputs
    **                  3-set it's attributes to set it to specific position on frame
    **                  4-set values into total and fields of book from books array
    **                  5-use try and catch to handle total variable
    **                  6-need to implement buttons action
    ** parameters values and it's meaning :
    **          this function only generate invoice with associated with book object array with maximum length 5
     */
    public void generateInvoice(String date, String memberName, bookData bookObj[]) {
        JOptionPane.showMessageDialog(null, "5 Books is Maximum In Invoice");

        float total = 0;

        dateField = new JTextField();
        this.add(dateField);
        dateField.setBounds(x1, 25, width, height);
        dateField.setText(date);

        dateLabel = new JLabel("Invoice Date : ");
        this.add(dateLabel);
        dateLabel.setBounds(x2, 25, width, height);

        memberNameField = new JTextField();
        this.add(memberNameField);
        memberNameField.setBounds(x1, 75, width, height);
        memberNameField.setText(memberName);

        memberNameLabel = new JLabel("Member Name : ");
        this.add(memberNameLabel);
        memberNameLabel.setBounds(x2, 75, width, height);

        book1_Field = new JTextField();
        this.add(book1_Field);
        book1_Field.setBounds(x1, 125, width, height);
        try {
            book1_Field.setText(bookObj[0].name);
            total += Float.valueOf(bookObj[0].price);
        } catch (Exception e) {
            total += 0;
        }

        book1_Label = new JLabel("Book No. 1 ");
        this.add(book1_Label);
        book1_Label.setBounds(x2, 125, width, height);

        book2_Field = new JTextField();
        this.add(book2_Field);
        book2_Field.setBounds(x1, 175, width, height);
        try {
            book2_Field.setText(bookObj[1].name);
            total += Float.valueOf(bookObj[1].price);
        } catch (Exception e) {
            total += 0;
        }

        book2_Label = new JLabel("Book No. 2 ");
        this.add(book2_Label);
        book2_Label.setBounds(x2, 175, width, height);

        book3_Field = new JTextField();
        this.add(book3_Field);
        book3_Field.setBounds(x1, 225, width, height);
        try {
            book3_Field.setText(bookObj[2].name);
            total += Float.valueOf(bookObj[2].price);
        } catch (Exception e) {
            total += 0;
        }

        book3_Label = new JLabel("Book No. 3 ");
        this.add(book3_Label);
        book3_Label.setBounds(x2, 225, width, height);

        book4_Field = new JTextField();
        this.add(book4_Field);
        book4_Field.setBounds(x1, 275, width, height);
        try {
            book4_Field.setText(bookObj[3].name);
            total += Float.valueOf(bookObj[3].price);
        } catch (Exception e) {
            total += 0;
        }

        book4_Label = new JLabel("Book No. 4 ");
        this.add(book4_Label);
        book4_Label.setBounds(x2, 275, width, height);

        book5_Field = new JTextField();
        this.add(book5_Field);
        book5_Field.setBounds(x1, 325, width, height);
        try {
            book5_Field.setText(bookObj[4].name);    
            total += Float.valueOf(bookObj[4].price);
        } catch (Exception e) {
            total += 0;
        }

        book5_Label = new JLabel("Book No. 5 ");
        this.add(book5_Label);
        book5_Label.setBounds(x2, 325, width, height);

        totalField = new JTextField();
        this.add(totalField);
        totalField.setBounds(x1, 375, width, height);
        totalField.setText(total + "");

        totalLabel = new JLabel("Total Price :");
        this.add(totalLabel);
        totalLabel.setBounds(x2, 375, width, height);

        //prepare buttons
        this.add(generateBtn);
        generateBtn.setBounds(x1, 425, width, height + 10);
        generateBtn.setActionCommand("generateinvoice");
        generateBtn.addActionListener(this);

        this.add(backBtn);
        backBtn.setBounds(x1, 485, width, height + 10);
        backBtn.setActionCommand("backinvoice");
        backBtn.addActionListener(this);
    }

    /* test code
    public static void main(String args[]) {
        bookData books[] = new bookData[5];
        books[0] = new bookData("Java", "", "", "0", "", "", "", "", "");
        books[1] = new bookData("Php", "", "", "1500", "", "", "", "", "");
        books[2] = new bookData("C++", "", "", "500", "", "", "", "", "");
        books[3] = new bookData("OS", "", "", "650", "", "", "", "", "");
        books[4] = new bookData("SWE", "", "", "", "", "", "", "", "");
        new invoice().generateInvoice("test", "test", books);
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        //check user clicked buttons
        //check for generate an invoice
        if (e.getActionCommand().equals("generateinvoice")) {
            new librarian().main_frame();
            this.dispose();
        } //check if back button clicked or not
        else if (e.getActionCommand().equals("backinvoice")) {
            new librarian().main_frame();
            this.dispose();
        }
    }
}

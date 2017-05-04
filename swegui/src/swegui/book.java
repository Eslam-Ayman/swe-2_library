/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swegui;

import control.bookData;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Ahmed
 */
public class book extends JFrame implements ActionListener{

    //prepare width , height of fields & labels and x position of label & field
    int width = 250, height = 35, x1 = 250, x2 = 100;

    //frame variables for book_form function
    //prepare fields and labels variables for inputs
    JTextField nameField, snField, no_of_bookField, priceField, typeField, authorField, no_of_papersField,
            publish_houseField;
    JTextArea descField;
    JLabel nameLabel, snLabel, no_of_bookLabel, priceLabel, typeLabel, descLabel, authorLabel, no_of_papersLabel,
            publish_houseLabel;
    JButton addBtn = new JButton("Add Book"), editBtn = new JButton("Edit Book"), backBtn = new JButton("Back"), deleteBtn = new JButton("Delete Book");
    //end of book_form frame variables

    //prepare constructor of member frame
    public book() {
        this.setTitle("Book Frame");
        this.setResizable(false);
        this.setLocation(300, 100);
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
    }

    /*
    ** Function Name : book_form
    ** Parameters : boolean edit , book object , boolean show ,boolan delete
    ** Implementation : 1-prepare fields variables to get input from user
    **                  2-prepare labels for that's fields
    **                  3-prepare add , edit , delete and back buttons
    **                  4-set bounds to this variables and add them into frame
    **                  5-check parameters to perform one function only like (add , edit ,delete and show book details)
    ** parameters values and it's mening
    **      1-false,null,false,false => that's mean add new book
    **      2-true,book,false,false => that's mean edit book data
    **      3-false,book,true,false => that's mean show book data only
    **      4-false,book,false,true => that's mean see book data and perfom a delete function to delete book
     */
    public void book_form(boolean editable, bookData bookObj, boolean show, boolean delete) {
        this.setSize(600, 700);
        this.setLocation(300, 0);
        this.getContentPane().removeAll();

        //prepare fields and labels attributes to set it on frame
        nameField = new JTextField();
        this.add(nameField);
        nameField.setBounds(x1, 25, width, height);

        nameLabel = new JLabel("Book Name");
        this.add(nameLabel);
        nameLabel.setBounds(x2, 25, width, height);

        snField = new JTextField();
        this.add(snField);
        snField.setBounds(x1, 75, width, height);

        snLabel = new JLabel("Book Serial No.");
        this.add(snLabel);
        snLabel.setBounds(x2, 75, width, height);

        priceField = new JTextField();
        this.add(priceField);
        priceField.setBounds(x1, 125, width, height);

        priceLabel = new JLabel("Book Price");
        this.add(priceLabel);
        priceLabel.setBounds(x2, 125, width, height);

        no_of_bookField = new JTextField();
        this.add(no_of_bookField);
        no_of_bookField.setBounds(x1, 175, width, height);

        no_of_bookLabel = new JLabel("No Of Book");
        this.add(no_of_bookLabel);
        no_of_bookLabel.setBounds(x2, 175, width, height);

        typeField = new JTextField();
        this.add(typeField);
        typeField.setBounds(x1, 225, width, height);

        typeLabel = new JLabel("Book Type");
        this.add(typeLabel);
        typeLabel.setBounds(x2, 225, width, height);

        authorField = new JTextField();
        this.add(authorField);
        authorField.setBounds(x1, 275, width, height);

        authorLabel = new JLabel("Book Author");
        this.add(authorLabel);
        authorLabel.setBounds(x2, 275, width, height);

        publish_houseField = new JTextField();
        this.add(publish_houseField);
        publish_houseField.setBounds(x1, 325, width, height);

        publish_houseLabel = new JLabel("Book Publishing House");
        this.add(publish_houseLabel);
        publish_houseLabel.setBounds(x2, 325, width, height);

        no_of_papersField = new JTextField();
        this.add(no_of_papersField);
        no_of_papersField.setBounds(x1, 375, width, height);

        no_of_papersLabel = new JLabel("No. Of Papers");
        this.add(no_of_papersLabel);
        no_of_papersLabel.setBounds(x2, 375, width, height);

        descLabel = new JLabel("Book Description");
        this.add(descLabel);
        descLabel.setBounds(x2, 425, width, height);

        descField = new JTextArea();
        this.add(descField);
        descField.setBounds(x1, 425, width, height + 50);

        //prepare buttons
        this.add(addBtn);
        addBtn.setBounds(x1, 525, width, height + 10);
        addBtn.setActionCommand("addbook");
        addBtn.addActionListener(this);

        this.add(editBtn);
        editBtn.setBounds(x1, 525, width, height + 10);
        editBtn.setActionCommand("editbook");
        editBtn.addActionListener(this);

        this.add(deleteBtn);
        deleteBtn.setBounds(x1, 525, width, height + 10);
        deleteBtn.setActionCommand("deletebook");
        deleteBtn.addActionListener(this);

        this.add(backBtn);
        backBtn.setBounds(x1, 585, width, height + 10);
        backBtn.setActionCommand("backbtn");
        backBtn.addActionListener(this);

        if (editable && bookObj != null) {
            addBtn.setVisible(false);
            deleteBtn.setVisible(false);

            nameField.setText(bookObj.name);
            snField.setText(bookObj.sn);
            authorField.setText(bookObj.author);
            no_of_bookField.setText(bookObj.no_of_book);
            no_of_papersField.setText(bookObj.no_of_papers);
            publish_houseField.setText(bookObj.publish_house);
            typeField.setText(bookObj.type);
            descField.setText(bookObj.desc);
            priceField.setText(bookObj.price);
        } else if ((show || delete) && bookObj != null) {
            addBtn.setVisible(false);
            editBtn.setVisible(false);

            nameField.setText(bookObj.name);
            nameField.setEditable(false);

            snField.setText(bookObj.sn);
            snField.setEditable(false);

            authorField.setText(bookObj.author);
            authorField.setEditable(false);

            no_of_bookField.setText(bookObj.no_of_book);
            no_of_bookField.setEditable(false);

            no_of_papersField.setText(bookObj.no_of_papers);
            no_of_papersField.setEditable(false);

            publish_houseField.setText(bookObj.publish_house);
            publish_houseField.setEditable(false);

            typeField.setText(bookObj.type);
            typeField.setEditable(false);

            descField.setText(bookObj.desc);
            descField.setEditable(false);

            priceField.setText(bookObj.price);
            priceField.setEditable(false);

            if (!delete) {
                deleteBtn.setVisible(false);
                backBtn.setBounds(x1, 525, width, height + 10);
            }
        } else {
            editBtn.setVisible(false);
            deleteBtn.setVisible(false);
        }
    }

    public void list_book() {

    }

    /* test code
    public static void main(String args[]) {
        // name,sn,no_of_book,price,type,desc,author,no_of_papers,publish_house;
        bookData book = new bookData("Java", "1001java", "52", "75", "programming language", "book help u to study java PL", "ibram isack", "635", "FCIH");
        //to show book details only use this
        //new book().book_form(false,book, true,false);

        //to delete book use this
        //new book().book_form(false,book, false,true);
        //to update book use this
        //new book().book_form(true,book, false,false);
        //to add new book details use this
        //new book().book_form(false,null, false,false);
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        //check user click button to perform some action
        //add new book
        if(e.getActionCommand().equals("addbook")){
            new librarian().main_frame();
            this.dispose();
        }
        //edit an book
        else if(e.getActionCommand().equals("editbook")){
            new librarian().main_frame();
            this.dispose();
        }
        //delete an book
        else if(e.getActionCommand().equals("deletebook")){
            new librarian().main_frame();
            this.dispose();
        }
        //back button clicked
        else if(e.getActionCommand().equals("backbtn")){
            new librarian().main_frame();
            this.dispose();
        }
    }
}

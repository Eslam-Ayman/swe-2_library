/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swegui;

import control.sectionData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Ahmed
 */
public class section extends JFrame implements ActionListener{

    //prepare width , height of fields & labels and x position of label & field
    int width = 250, height = 35, x1 = 250, x2 = 100;

    //frame variables for section_form function
    //prepare fields and labels variables for frame
    JTextField nameField, no_of_bookField, snField;
    JTextArea descField;
    JLabel nameLabel, no_of_bookLabel, descLabel, snLabel;
    JButton addSec = new JButton("Add Section"), editSec = new JButton("Edit Section"), deleteSec = new JButton("Delete Section"), back = new JButton("Back");
    //end of frame variables for section_form function
    
    //prepare constructor of member frame
    public section() {
        this.setTitle("Section Frame");
        this.setResizable(false);
        this.setLocation(300, 100);
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
    }

    /*
    ** Function Name : section_form
    ** Parameter : boolean edit, section object , bollean show, boolean delete
    ** Implementation : 1-set frame size
    **                  2-prepare fields for inputs and labels for that's input
    **                  3-prepare buttons for perform actions
    **                  4-prepare them attributes to set it's position on frame
    **                  5-check comes parameter to prepare values for frame
    ** Function Input and it's probability :
    **                  1-false,null,false,false that's mean add new section
    **                  2-true,object,false,false that's mean edit section object
    **                  3-false,object,true,false that's mean show section data only
    **                  4-false,object,false,true that's mean show section data and perfom delete section
     */
    public void section_form(boolean editable, sectionData sectionObj, boolean show, boolean delete) {
        this.setSize(600, 500);
        this.getContentPane().removeAll();

        //prepare each variable (initialize and set some attributes) and add it to frame
        nameField = new JTextField();
        this.add(nameField);
        nameField.setBounds(x1, 50, width, height);

        nameLabel = new JLabel("Section Name : ");
        this.add(nameLabel);
        nameLabel.setBounds(x2, 50, width, height);

        no_of_bookField = new JTextField();
        this.add(no_of_bookField);
        no_of_bookField.setBounds(x1, 100, width, height);

        no_of_bookLabel = new JLabel("No. Of Books :");
        this.add(no_of_bookLabel);
        no_of_bookLabel.setBounds(x2, 100, width, height);

        snField = new JTextField();
        this.add(snField);
        snField.setBounds(x1, 150, width, height);

        snLabel = new JLabel("Section Serial No. :");
        this.add(snLabel);
        snLabel.setBounds(x2, 150, width, height);

        descField = new JTextArea();
        this.add(descField);
        descField.setBounds(x1, 200, width, height + 50);

        descLabel = new JLabel("Section Description : ");
        this.add(descLabel);
        descLabel.setBounds(x2, 200, width, height);

        //prepare buttons
        this.add(addSec);
        addSec.setBounds(x1, 300, width, height + 10);
        addSec.setActionCommand("addsec");
        addSec.addActionListener(this);

        this.add(editSec);
        editSec.setBounds(x1, 300, width, height + 10);
        editSec.setActionCommand("editsec");
        editSec.addActionListener(this);

        this.add(deleteSec);
        deleteSec.setBounds(x1, 300, width, height + 10);
        deleteSec.setActionCommand("deletesec");
        deleteSec.addActionListener(this);

        this.add(back);
        back.setBounds(x1, 360, width, height + 10);
        back.setActionCommand("backBtn");
        back.addActionListener(this);

        //prepare frame for selected option (add,delete,edit,show)
        if ((editable || show) && sectionObj != null) {
            addSec.setVisible(false);
            deleteSec.setVisible(false);

            nameField.setText(sectionObj.name);
            no_of_bookField.setText(sectionObj.no_of_book);
            snField.setText(sectionObj.sn);
            descField.setText(sectionObj.desc);
            if (show) {
                editSec.setVisible(false);
                back.setBounds(x1, 300, width, height + 10);

                nameField.setEditable(false);
                snField.setEditable(false);
                no_of_bookField.setEditable(false);
                descField.setEditable(false);
            }
        } else if (delete) {
            addSec.setVisible(false);
            editSec.setVisible(false);

            nameField.setText(sectionObj.name);
            no_of_bookField.setText(sectionObj.no_of_book);
            snField.setText(sectionObj.sn);
            descField.setText(sectionObj.desc);

            nameField.setEditable(false);
            snField.setEditable(false);
            no_of_bookField.setEditable(false);
            descField.setEditable(false);
        } else {
            addSec.setVisible(true);
            editSec.setVisible(false);
            deleteSec.setVisible(false);
        }
    }

    //need idea for make frame scrollable
    public void list_section() {

    }

    /* test code
    public static void main(String args[]) {
        sectionData secData = new sectionData("History", "15432AB", "History Of Books", "1500");

        //to add new section use this
        //new section().section_form(false,null,false,false);
        //to edit section use this
        //new section().section_form(true,secData,false,false);
        //to show section data only use this
        //new section().section_form(false,secData,true,false);
        //to show section data and delete it use this
        //new section().section_form(false,secData,false,true);
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        //check user button click
        //check add section button clicked or not
        if(e.getActionCommand().equals("addsec")){
            new librarian().main_frame();
            this.dispose();
        }
        //check edit section button clicked or not
        else if(e.getActionCommand().equals("editsec")){
            new librarian().main_frame();
            this.dispose();
        }
        //check delete section button clicked or not
        else if(e.getActionCommand().equals("deletesec")){
            new librarian().main_frame();
            this.dispose();
        }
        //check back section button clicked or not
        else if(e.getActionCommand().equals("backBtn")){
            new librarian().main_frame();
            this.dispose();
        }
    }
}

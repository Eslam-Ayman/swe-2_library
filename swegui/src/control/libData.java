/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Ahmed
 */
public class libData {
    public String name,phone,email,address ,ssn,b_day,gender,user,pass,salary;
    public boolean admin;
    public libData(String name,String phone,String email,String address ,String ssn,String b_day
            ,String gender,String user,String pass,String salary,boolean admin){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.ssn = ssn;
        this.b_day = b_day;
        this.gender = gender;
        this.user = user;
        this.pass = pass;
        this.salary = salary;
        this.admin = admin;
    }
}

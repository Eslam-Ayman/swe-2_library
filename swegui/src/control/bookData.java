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
public class bookData {
    public String name,sn,no_of_book,price,type,desc,author,no_of_papers,publish_house;
    public bookData(String name,String sn,String no_of_book,String price,String type,
            String desc,String author,String no_of_papers,String publish_house){
        this.name = name;
        this.sn = sn;
        this.no_of_book = no_of_book;
        this.price = price;
        this.type = type;
        this.desc = desc;
        this.author = author;
        this.no_of_papers = no_of_papers;
        this.publish_house = publish_house;
    }
}

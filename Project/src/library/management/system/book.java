/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ahmed96
 */
public class Book {
    private String sn;
    private Boolean state;
    private String dateOfreturn;
    private Copy copy;
    private final Validation valid;
    private final database db;
    public Book()
    {
        copy =new Copy();
        valid =new Validation();
        db = database.getInstance();
    }
    public Boolean setSn(String sn)
    {
        if(valid.validateSn(sn))
        {
            this.sn=sn;
            return true;
        }
        return false;
    }
    public String getSn()
    {
        return this.sn;
    }
    public Boolean setDateOfReturn(String date)
    {
        if(valid.validateDate(date))
        {
            this.dateOfreturn =date;
            return true;
        }
        return false;
    }
    public String getDateOfReturn()
    {
        return this.dateOfreturn;
    }
    
    public Boolean setState(Boolean state)
    {
            this.state =state;
            return true;
    }
    public Boolean getstate()
    {
        return this.state;
    }
    public Boolean setCopy(Copy copy)
    {
        this.copy =copy;
        return true;
    }
    public Copy getCopy()
    {
        return this.copy;
    }
    public Boolean addBook(Book obj) throws SQLException
    {
        HashMap hash = new HashMap<String,String>();
        hash.put("column","id");
        hash.put("nameTable","copy");
        String statement = "name = '"+ obj.getCopy().getname() + "' AND description = '" + obj.getCopy().getDescription() + "' AND publishPlace = '" + obj.getCopy().getPublishPlace() + "' AND author = '" + obj.getCopy().getAuther() + "' AND numberOfPaper = " + String.valueOf(obj.getCopy().getNumOfPeper()) + " AND type = "+ String.valueOf(obj.getCopy().getType())+"";
        hash.put("condition",statement);
        ResultSet rs = db.select(hash);
        
        int id;
        if(rs.next())
        {
            id = (Integer) rs.getObject(1);
            hash = new HashMap<String,String>();
            if(obj.getstate()==true)
                hash.put("state","1");
            else
                hash.put("state","0");
            hash.put("copyID",String.valueOf(id));
            hash.put("serialNo",obj.getSn());
            hash.put("dateOfReturn","'"+obj.getDateOfReturn()+"'");
            if(db.insert("book", hash))
            {
                return true;
            }
        }
        else
        {
            hash = new HashMap<String,String>();
            hash.put("name","'"+obj.getCopy().getname()+"'");
            hash.put("price",String.valueOf(obj.getCopy().getprice()));
            hash.put("type",String.valueOf(obj.getCopy().getType()));
            hash.put("description","'"+obj.getCopy().getDescription()+"'");
            hash.put("author","'"+obj.getCopy().getAuther()+"'");
            hash.put("numberOfPaper",String.valueOf(obj.getCopy().getNumOfPeper()));
            hash.put("publishPlace","'"+obj.getCopy().getPublishPlace()+"'");
            if(db.insert("copy", hash))
            {
                
                hash = new HashMap<String,String>();
                hash.put("column","id");
                hash.put("nameTable","copy");
                hash.put("condition",statement);
                rs = db.select(hash);
                if(rs.next())
                {
                    id = (Integer) rs.getObject(1);
                    hash = new HashMap<String,String>();
                    hash.put("serialNo",obj.getSn());
                    hash.put("copyID",String.valueOf(id));
                    if(obj.getstate()==true)
                        hash.put("state","1");
                    else
                        hash.put("state","0");
                    hash.put("dateOfReturn","'"+obj.getDateOfReturn()+"'");
                    if(db.insert("book", hash))
                    {
                        return true;
                    }
                }
                
            }
            
        }
        return false;
    }

    public Boolean editBook(Book obj) throws SQLException
    {
        if(deleteBook(obj.getSn(),obj.getCopy().getname()))
        {
            if(addBook(obj))
            {
                return true;
            }
        }
        return false;
    }
// fe eldb 4el klmt table min el elquery
    public Boolean deleteBook(String sn,String name) throws SQLException
    {
        HashMap hash = new HashMap<String,String>();
        if(searchBook(sn, name))
        {
            HashMap hash1 = new HashMap<String,String>();
            hash1.put("column","copyID");
            hash1.put("nameTable","book");
            hash1.put("condition","serialNo = "+sn);
            ResultSet rs = db.select(hash1);
            int  id;
            if(rs.next())
                id = ((Integer) rs.getObject(1));
            else return false;
                
            hash1 = new HashMap<String,String>();
            hash1.put("column","*");
            hash1.put("nameTable","book");
            hash1.put("condition","copyID = "+id);
            rs = db.select(hash1);
            
            if(rs.next())
            {
                if(!rs.next())
                {
                    hash1 = new HashMap<String,String>();
                    hash1.put("nameTable","book");
                    hash1.put("condition","copyID = "+id);
                    if( db.delete(hash1))
                    {
                                hash = new HashMap<String,String>();
                                hash.put("nameTable","copy");
                                hash.put("condition","id = "+id);
                            return db.delete(hash);
                    }
                }
                else
                    {
                        hash.put("nameTable","book");
                        hash.put("condition","serialNo = "+sn);
                        return db.delete(hash);
                    }
            }
            
        }
        return false;
    }
    public Boolean searchBook(String sn,String name) throws SQLException
    {
        HashMap hash = new HashMap<String,String>();
        hash.put("column","*");
        hash.put("nameTable","book");
        hash.put("condition","serialNo = "+sn);
        ResultSet rs = db.select(hash);
        return rs.next();
    }

    public Book getBook(String sn,String name) throws SQLException
    {
        if(searchBook(sn, name))
        {
        HashMap hash = new HashMap<String,String>();
        hash.put("column","copy.name,copy.price,copy.type,copy.description,copy.author,copy.numberOfPaper,copy.publishPlace,book.serialNo,book.state,book.dateOfReturn");
        hash.put("nameTable","copy Join book on copy.id = book.copyID");
        hash.put("condition","serialNo = "+sn);
        ResultSet resultSet =db.select(hash);
        Book book =new Book();
        if(resultSet.next())
        {
            int i=1;
                book.copy.setname((String) resultSet.getObject(i));
                book.copy.setprice((Double) resultSet.getObject(++i));
                book.copy.setType((Integer) resultSet.getObject(++i));
                book.copy.setDescription((String) resultSet.getObject(++i));
                book.copy.setAuther((String) resultSet.getObject(++i));
                book.copy.setNumOfPeper((Integer) resultSet.getObject(++i));
                book.copy.setPublishPlace((String) resultSet.getObject(++i));
                book.setSn(String.valueOf( resultSet.getObject(++i)));
                if(((Boolean) resultSet.getObject(++i)))
                {
                    book.setState(true);
                }
                else book.setState(false);
                book.setDateOfReturn(String.valueOf( resultSet.getObject(++i)));
                
            
        
        return book;
        }
        else
            return null;
        }
        else
            return null;
    }
    public Book [] convertToArray(ArrayList<Book> book)
    {
        Book booklist[] =new Book[book.size()];
        for(int i=0;i<book.size();i++)
        {
            booklist[i]=book.get(i);
        }
        return booklist;
        
    }
    
    public Book[] listBook(String sn ,String name ) throws SQLException
    {
        HashMap hash = new HashMap<String,String>();
        hash.put("column","serialNo");
        hash.put("nameTable","copy Join book on copy.id = book.copyID");
        hash.put("condition", "type = "+sn);
        ResultSet resultSet =db.select(hash);
        ArrayList<Book> bookList =new ArrayList<Book>();
        Book book;
        int j=0;
        
        while (resultSet.next())
        {
            book=getBook(String.valueOf(resultSet.getObject(1)), name);
            if(j==0 && book==null)
                return null;
            if(book==null)
                return convertToArray(bookList);
            bookList.add(book);
            j++;
        }
        if(j==0)
            return null;
        else
        return convertToArray(bookList);
        
    }

}

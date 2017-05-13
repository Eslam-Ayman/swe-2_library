
package library.management.system;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import static library.management.system.database.getInstance;

public class section {
    private database db = getInstance();
    private String sectionName;
    private int numOfBook;
    private String sn = new String();
    private String description = new String();
    
    public boolean setName(String name)
    {
        this.sectionName = name;
        return true;
    }
    public String getName()
    {
        return this.sectionName;
    }
    public boolean setNumOfBook(int num)
    {
        this.numOfBook = num;
        return true;
    }
    public int getNumOfBook()
    {
        return this.numOfBook;
    }
    public boolean setSn(String sn)
    {
        this.sn = sn;
        return true;
    }
    public String getSn()
    {
        return this.sn;
    }
    public boolean setDescription(String desc)
    {
        this.description = desc;
        return true;
    }
    public String getDescription()
    {
        return this.description;
    }
    public boolean addSection(section obj)
    {
        HashMap<String,String> insert = new HashMap<>();
        insert.put("name", "'"+obj.getName()+"'");
        insert.put("numberBook", Integer.toString(obj.getNumOfBook()));
        insert.put("serialNo", obj.getSn());
        insert.put("description", "'"+obj.getDescription()+"'");
        //insert.put("subSection", "1");
        return db.insert("section",insert);
    }
    public boolean editSection(String data, String sn)
    {
         HashMap<String,String> edit = new HashMap<>();
        edit.put("data",data);
        return db.update("section",edit,"serialNo = "+sn);
    }
    public boolean deleteSection(String sn, String name)
    {
        HashMap<String,String> delete = new HashMap<>();
        delete.put("nameTable","section");
        delete.put("condition" , "serialNo = " + sn +"AND name = '"+name+"'");
        return db.delete(delete);
    }
    public boolean searchSection(String sn, String name) throws SQLException
    {
        HashMap<String,String> search = new HashMap<>();
        search.put("column","*");
        search.put("nameTable","section");
        search.put("condition" , "serialNo = " + sn +"AND name = '"+name+"'");
        ResultSet rs = db.select(search);
        return rs.next();
    }
    
    public section [] convertToArray(ArrayList<section> section)
    {
        section booklist[] =new section[section.size()];
        for(int i=0;i<section.size();i++)
        {
            booklist[i]=section.get(i);
        }
        return booklist;
    }
    
    
   /* public section[] listSection(String sn, String name) throws SQLException
    {
        HashMap<String,String> search = new HashMap<>();
        search.put("column","*");
        search.put("nameTable","section");
        search.put("condition" , "sn = " + sn +"AND name = '"+name+"'");
        ResultSet rs = db.select(search);
        
        ArrayList<section> sectionList =new ArrayList<section>();
        section section;
        int j=0;
        
        while (rs.next())
        {
            section=getBook(String.valueOf(rs.getObject(1)), name);
            if(j==0 && section==null)
                return null;
            if(section==null)
                return convertToArray(sectionList);
            sectionList.add(section);
            j++;
        }
        if(j==0)
            return null;
        else
        return convertToArray(sectionList);*/
        
        /*section[] obj = new section[10];
        return obj;
    }*/
    
}


package library.management.system;

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
        insert.put("name", obj.getName());
        insert.put("numOfBook", Integer.toString(obj.getNumOfBook()));
        insert.put("sn", obj.getSn());
        insert.put("description", obj.getDescription());
        return db.insert("section",insert);
    }
    public boolean editSection(String data, String sn)
    {
         HashMap<String,String> edit = new HashMap<>();
        edit.put("sn", sn);
        edit.put("data", data);
        return db.update("section",edit,"");
    }
    public boolean deleteSection(String sn, String name)
    {
        HashMap<String,String> delete = new HashMap<>();
        delete.put("sn", sn);
        delete.put("name", name);
        return db.delete(delete);
    }
    public section searchSection(String sn, String name)
    {
        HashMap<String,String> search = new HashMap<>();
        search.put("sn", sn);
        search.put("name", name);
        return (section)db.select(search);
    }
    public section[] listSection(String sn, String name)
    {
        section[] obj = new section[10];
        return obj;
    }
    
}


package library.management.system;

public class section {
    private String sectionName;
    private int numOfBook;
    private String sn = new String();
    private String description = new String();
    
    public boolean setNam(String name)
    {
        this.sectionName = name;
        return true;
    }
    public String getNam()
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
        return true;
    }
    public boolean editSection(String data, String sn)
    {
        
        return true;
    }
    public boolean deleteSection(String sn, String name)
    {
        
        return true;
    }
    public section searchSection(String sn, String name)
    {
        section obj = new section();
        return obj;
    }
    public section[] listSection(String sn, String name)
    {
        section[] obj = new section[10];
        return obj;
    }
    
}

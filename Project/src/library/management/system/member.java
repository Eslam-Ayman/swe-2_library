
package library.management.system;

import java.sql.ResultSet;
import java.util.HashMap;
import static library.management.system.database.getInstance;

public class member extends librarian {
    private database db = getInstance();
   public boolean addMember(member obj)
    {
        HashMap<String,String> insert = new HashMap<>();
        insert.put("name", obj.getName());
        insert.put("phone", obj.getPhoneNo());
        insert.put("email", obj.getEmail());
        insert.put("address", obj.getAddress());
        insert.put("gender", obj.getGender());
        insert.put("snn", obj.getSsn());
        insert.put("type", obj.getType());
        insert.put("dateOfBirth", obj.getDateOfBirth());
        return db.insert("member",insert );
    }
    public boolean deleteMember(String ID)
    {
         HashMap<String,String> delete = new HashMap<>();
        delete.put("ID", ID);
        return db.delete(delete);
    }
    public boolean editMember(String ID , member obj)
    {
         HashMap<String,String> insert = new HashMap<>();
        insert.put("name", obj.getName());
        insert.put("phone", obj.getPhoneNo());
        insert.put("email", obj.getEmail());
        insert.put("address", obj.getAddress());
        insert.put("gender", obj.getGender());
        insert.put("snn", obj.getSsn());
        insert.put("type", obj.getType());
        insert.put("dateOfBirth", obj.getDateOfBirth());
        return db.update("member",insert,"");
    }
    public member searchMember(String ID)
    {
        HashMap<String,String> search = new HashMap<>();
        search.put("ID", ID);
        return (member)db.select(search);
    }
    

    
}


package library.management.system;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import static library.management.system.database.getInstance;

public class member extends librarian {
   private final database db = database.getInstance();
   
   public boolean addMember(member obj)
    { // there is error ther becuase when the class liberian fnish everything well be okay
        HashMap<String,String> insert = new HashMap<>();
        insert.put("name", "'"+obj.getName()+"'");
        insert.put("phone", obj.getPhoneNo());
        insert.put("email", "'"+obj.getEmail()+"'");
        insert.put("address", "'"+obj.getAddress()+"'");
        insert.put("gender", Boolean.toString(obj.getGender()));
        insert.put("ssn", obj.getSsn());
        insert.put("typeUser", obj.getType());
        insert.put("dateBirth", "'"+obj.getDateOfBirth()+"'");
        return db.insert("users",insert);
    }
    public boolean deleteMember(String ID)
    {
         HashMap<String,String> delete = new HashMap<>();
        delete.put("nameTable","users");
        delete.put("condition" , "ID = " + ID);
        return db.delete(delete);
    }
    public boolean editMember(String ID , member obj)
    {
        HashMap<String,String> insert = new HashMap<>();
        insert.put("data","name = '"+obj.getName()+"'"
                    +",phone = "+obj.getPhoneNo()
                    +",email = '"+obj.getEmail()+"'"
                    +",address = '"+obj.getAddress()+"'"
                    +",gender = "+Boolean.toString(obj.getGender())
                    +",ssn = "+obj.getSsn()
                    +",typeUser = "+obj.getType()
                    +",dateBirth = '"+obj.getDateOfBirth()+"'");
        return db.update("users",insert,"ID = "+ID);
    }
    public Boolean searchMember(String ID) throws SQLException 
    {
        HashMap<String,String> search = new HashMap<>();
        search.put("column","*");
        search.put("nameTable","users");
        search.put("condition","ID = "+ID);
        ResultSet rs = db.select(search);
        return rs.next();
    }
    

    
}

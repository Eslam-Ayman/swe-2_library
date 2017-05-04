
package library.management.system;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//            database.getInstance();
//            
           database db = database.getInstance();
          // db.dropDB();
          // db.dropDB();
//           HashMap hash = new HashMap<String,String>();
//           hash.put("column","*");
//           hash.put("nameTable","users u,librarian l,typeUser t");
//           hash.put("condition","name = 'hassan'");
//           ResultSet rs= db.select(hash);
//           
//        try {
//            ResultSetMetaData rrs = rs.getMetaData();
//            int count = rrs.getColumnCount();
//            while(rs.next())
//                for (int i=1;i<count;i++)
//                    System.out.print(rrs.getColumnName(i) +" :" +rs.getString(i) + " ,");
//        } catch (SQLException ex) {
//            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//        }
           
    }
    
}

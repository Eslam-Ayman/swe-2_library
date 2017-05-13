
package library.management.system;

import java.sql.SQLException;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        member eslam = new member();
        eslam.setName("jhhhhhh");
        eslam.setEmail("eslam@yahoo.com");
        eslam.setPhoneNo("2201149702173");
        eslam.setSsn("767676");
        eslam.setAddress("sssss streeet");
        eslam.setGender(true);
        eslam.setDateOfBirth("2017-04-11");
        eslam.setType("2");
        System.out.println(eslam.addMember(eslam));
        //System.out.println(eslam.editMember("8",eslam));
        
        //eslam.deleteMember("1");
        
        
        section science = new section();
        science.setDescription("ay hagaa ya3mm");
        science.setName("science");
        science.setNumOfBook(8);
        science.setSn("1");
        //science.addSection(science);
        
        
    }
    
}

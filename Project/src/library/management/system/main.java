
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
        eslam.setSsn("9032100");
        eslam.setAddress("sssss streeet");
        eslam.setGender(true);
        eslam.setDateOfBirth("2017-04-11");
        eslam.setType("2");
        //System.out.println(eslam.addMember(eslam));
        //System.out.println(eslam.editMember("8",eslam));
        
        //eslam.deleteMember("1");
        
        
        section science = new section();
        science.setDescription("asasasaas hagaa ya3mm ttatatatatatat");
        science.setName("science");
        science.setNumOfBook(8);
        science.setSn("1232");
        //science.addSection(science);
        //System.out.println(science.addSection(science));
        //System.out.println(science.editSection(science,"1"));
        //System.out.println(science.deleteSection("121","science"));
        //System.out.println(science.searchSection("1231","science"));
        //System.out.println(science.listSection("1234","science")[0].getSn());
        
    }
    
}

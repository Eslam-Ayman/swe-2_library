
/*{-#######    Main Class Database    #########-}*/

/*
*####################
*####
*##
*#
* this class contain the database  that used for the project
* this class contain of single object 
* if you need to access the all function into this class
* why? this class use singletone pattern 
* that create single object only and use it for all call the classes
* 
*
*#
*##
*####
*####################
*
*/

package library.management.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class database {
    
    
   /*
    *   store the name of database , username , password , url 
    *
    *   
    *   @var final hashmap 
    */
    private final HashMap<String,String> details = new HashMap<String,String>();
                
    /*
    *   store the object of the class and use only one object
    *
    *
    *   @var database
    */
    private static database _object;
    
    /*
    *   store the connection of the database
    *
    *
    *
    *   @var static connection
    */
    private  Connection connectionDB;
    
    /*
    *   store the statement of the query
    *
    *
    *   @var static statement
    */
    private  Statement statement;
    
    /*
    *   store teh result set of ther query operqtion
    *
    *
    *   @var static resultset
    */
    private  ResultSet resultSet;
    
    /*
    *   store the record into object
    *
    *
    *   @var array String
    */
    private ArrayList<String> record;
    
    /*
    *   setting the constructor to private function to cannot to create object directly
    *
    *
    *   @param void
    *   @return void
    */
    private database(){ 
        // constructor
        this.settingDB();
        
        // perpare the statement and connection and result set
        this.prepare();
            
        // open connection 
        this.connection();
      
    }
    
    /*
    *   function to create only one object and use it for all class
    *
    *
    *   @param void
    *   @return object database
    */
    public static database getInstance(){
        if(_object == null)
            _object = new database();
         return _object;   
    }
    
    /*
    *   function to set the details to connect to the database
    *
    *
    *   @param void
    *   @return void
    */
    private void settingDB(){
        this.details.put("username", "root");
        this.details.put("password", "");
        this.details.put("databaseName","library_management_system");
        this.details.put("url", "jdbc:mysql://localhost/");
        this.details.put("jdbcDriver", "com.mysql.jdbc.Driver");
    }
    
    /*
    *   function to connect to the database and open connection
    *
    *
    *   @param void
    *   @return Boolean
    */
    private Boolean connection(){
        try{
                
                
                // check prepare the database
               if (this.prepareDB() == 1 || this.prepareDB() == 2)
               {
                   this.prepare();
                    this.connectionDB = DriverManager.getConnection(
                              this.details.get("url")+this.details.get("databaseName")
                            , this.details.get("username")
                            , this.details.get("password")
                    );
                    
                    return true;
               }
              else 
                return false;
        }
        catch(SQLException ex){
            
            if(this.connectionDB == null)
            {
                System.err.println("Please check the server already running  and try agin!");
            }
            else
            {
                try{
                    if(this.statement.getLargeUpdateCount() < 1)
                        System.err.println("Error for create the database!");
                }catch(SQLException e){
                    
                    System.err.println("the database already exists!");
                }
            }
            
            return false;
            
        }
         
    }
    
    /*
    *   function to create the basic database and create the basic tables
    *   and set the basic data
    *
    *
    *   @param void
    *   @return Boolean
    */
    private int prepareDB(){
        
        // get each line from the file
        String store = "";
        
        // check if the database already found or not
        Boolean found =false;
        
        //store all contain into a buffer
        StringBuffer strStore = new StringBuffer();
        
        try {
            // Register to the JDBC DRIVER
                Class.forName(this.details.get("jdbcDriver"));
                
                // open connection
                this.connectionDB = DriverManager.getConnection(
                          this.details.get("url")
                        
                        , this.details.get("username")
                        
                        , this.details.get("password")
                        
                );
                
            // read from the file
            FileReader file = new FileReader(new File("library_management_system.sql"));
            
            // store the read file into a buffer
            BufferedReader bufferLine = new BufferedReader(file);
            
            // read each line from the file
            while((store = bufferLine.readLine())!=null){
                
                strStore.append(store); 
            }
            
            // close buffer after end the file and finish the operation
            bufferLine.close();
            
            // open connection
            this.statement = this.connectionDB.createStatement();
            
            //get the all contain of database from the server
            this.resultSet = this.connectionDB.getMetaData().getCatalogs();
            
            // check if the database already exists or not
            while (this.resultSet.next()){
                
                  String databaseName = this.resultSet.getString(1);
                  
                  if(databaseName.equals(this.details.get("databaseName"))){
                      
                      found =true;
                  }
            }
            if (found == false)
            {
                //here is our splitter ! We use ";" as a delimiter for each request
                // then we are sure to have well formed statements
                String[] inst = strStore.toString().split(";");
                
                // show message for wait to create the default database
                System.out.println("Please Wait for create the database.....");
                 
                for(int i = 0; i<inst.length; i++)
                {
                    // we ensure that there is no spaces before or after the request string
                    // in order to not execute empty statements
                    if(!inst[i].trim().equals(""))
                    {
                        this.statement.executeUpdate(inst[i]);
                        
                    }
                }
                System.out.println("successfully created database");
                 
                return 2;
            }
            else return 1;
            
        } catch (FileNotFoundException ex) {
            
            System.err.println("the file database isn't found!");
            
            return -1;
            
        } catch (IOException ex) {
            
             System.err.println("cannot read from the file");
             
             return -1;
          
        } catch (SQLException ex) {
            
            System.err.println("cannot to connect to the server");
            
            
            if(this.connectionDB == null)
            {
                System.err.println("Please check the server already running  and try agin!");
            }
            else
            {
                try{
                    if(this.statement.getLargeUpdateCount() < 1)
                        System.err.println("Error for create the database!");
                }catch(SQLException e){
                    
                    System.err.println("the database already exists!");
                }
            }
            
            return -1;
            
        } catch (ClassNotFoundException ex) {
            
            System.err.println("the class mysql database driver are not found !");
           
           return -1;
        }finally{
            try {
                
                this.connectionDB.close();
                this.resultSet.close();
                this.statement.close();
                
            } catch (SQLException ex) {
                
            }catch(NullPointerException e){
                
            }
            
        }
    }
    
    /*
    *   prepare the connection and result set and statement 
    *
    *
    *   @param void
    *   @return void
    */
    private void prepare(){
        
        this.resultSet      = null;
        this.statement      = null;
        this.connectionDB   = null;
        
    }
    
    
    /*
    *   function to get containt from the database
    *
    *
    *   @param  HashMap contain (query , nametable,condition)
    *   @return String
    */
    public ResultSet select(HashMap<String,String> object){
        
        String column = (String)object.get("column");
        
        
        String nameTable = (String)object.get("nameTable");
        
        String condition = (String)object.get("condition");
        
        if(condition == null)
            condition ="";
        else 
            condition = "WHERE " + condition;
        
        String query = "SELECT "+ column + " FROM " + nameTable + " " + condition + ";" ;
        System.out.println(query);
       
           try{
           
                this.statement = this.connectionDB.createStatement(
                                  this.resultSet.TYPE_SCROLL_INSENSITIVE
                                , this.resultSet.CONCUR_READ_ONLY
                );
                    
                 this.resultSet = this.statement.executeQuery(query);
                
                 return this.resultSet;
           }catch(SQLException ex){
            
            System.out.println("error");
            return null;
            
            }catch(NullPointerException e){
            
            System.err.println("Error for connection!");
                return null;
            
            }
           
    }
    
   /*
    *   function to Insert data into the database and identify the table name
    *
    *
    *   @var HashMap
    */
    public Boolean insert(String nameTable, HashMap<String,String> insert){
        
        
        try {
            
            this.statement = this.connectionDB.createStatement(this.resultSet.TYPE_SCROLL_INSENSITIVE
                    , this.resultSet.CONCUR_UPDATABLE);
            
            HashMap keyValue = this.keyValues(insert);
            
            String column = (String)keyValue.get("key");
            
            String value = (String)keyValue.get("value");
            
            
            String query = "INSERT INTO `" + nameTable + "` (" + column + ") VALUES (" + value + ");";
            
            
            this.statement.executeUpdate(query);
            
            return true;
            
        } catch (SQLException ex) {
            
            System.err.println("Cannot execute this query!");
            
            return false;
            
        }catch(NullPointerException e){
            
            System.err.println("Error for connection!");
            
            return false;
        }
          
    }
    
    /*
    *   function to combine all keys and values  
    *
    *
    *   @var hashmap
    *   @return hahsmap
    */
    private HashMap keyValues(HashMap<String,String> object){
        
        String key = "" , value ="";
        
        HashMap combine = new HashMap <String,String>();
        
        int i = 0;
        for(String keys : object.keySet())
        {
            if(i+1 >= object.keySet().size())
            {
                
                key += keys;
            }
            else
                key +=keys + ",";
            i++;
        }
        i=0;
        for(String values : object.values())
        {
            if(i+1 >= object.values().size())
            {
                
                value += values;
            }
            else
                value +=values + ",";
            i++;
        }
        
        combine.put("key", key);
        combine.put("value", value);
        
        return combine;
           
    }
    
    /*
    *   function to update the data into a specific in the database
    *
    *
    *   @param string , hashmap 
    *   @return Boolean
    */
    public Boolean update(String nameTable , HashMap<String,String> update,String condition){
        
        try {
            
            this.statement = this.connectionDB.createStatement(
                    this.resultSet.TYPE_SCROLL_INSENSITIVE
                    ,this.resultSet.CONCUR_UPDATABLE
            );
            
            // name key for the data update
            String data = (String)update.get("data");
            
            if(condition == null)
                condition ="";
            else
                condition = "WHERE " + condition;
            
            String query = "UPDATE `" + nameTable + "` SET " + data + " " + condition + ";";
            
            this.statement.executeLargeUpdate(query);
            
            return true;
            
        } catch (SQLException ex) {
           
           System.err.println("Error for execute the query");
           
            return false;
        }catch(NullPointerException e){
            
            System.err.println("Error for connection!");
            
            return false;
        }
    }
    
   /*
    *   function to drop table
    *
    *
    *   @param  String
    *   @return  boolean
    */
    public Boolean drop(String nameTable){
        
        
        try {
            
            this.statement = this.connectionDB.createStatement(
                    this.resultSet.TYPE_SCROLL_INSENSITIVE
                    ,this.resultSet.CONCUR_UPDATABLE
            );
            
            
            String query = "DROP TABLE " + nameTable;
            
            this.statement.executeLargeUpdate(query);
            
            return true;
            
        } catch (SQLException ex) {
           
            System.err.println("Cannot Drop the table!");
            
            return false;
        }catch(NullPointerException e){
            
            System.err.println("Error for connection!");
            
            return false;
        }
          
    }
    
    /*
    *   function delete either all record or specific record into a specfic table
    *
    *
    *   @param String , String
    *   @return Boolean
    */
    public Boolean delete(HashMap<String,String> delete){
            
        String nameTable = (String)delete.get("nameTable");
            
        String condition = (String)delete.get("condition");
        
        try {
            
            this.statement = this.connectionDB.createStatement(
                    this.resultSet.TYPE_SCROLL_INSENSITIVE
                    ,this.resultSet.CONCUR_UPDATABLE
            );
            
            if(condition.equals(null))
                condition ="";
            else
                condition = "WHERE " + condition;
            
            String query = "DELETE FROM  TABLE " + nameTable + " " + condition;
            
            this.statement.executeLargeUpdate(query);
            
            return true;
            
        } catch (SQLException ex) {
           
            if(condition.equals(null))
                System.err.println("Cannot Delete " + nameTable);
            else
                System.err.println("Cannot Delete " + condition);
            
            return false;
        }catch(NullPointerException e){
            
            System.err.println("Error for connection!");
            
            return false;
        }
       
    }
    
    /*
    *   function to modify a specific column  into specific table
    *
    *
    *   @param string , string , hashmap<String,String>
    *   @return Boolean
    */
    public Boolean modify(String nameTable , HashMap<String,String> modify ,String operation){
        
        String columns ="" , query = "ALTER TABLE " + nameTable;
        
        int i=0;
        
        if(!modify.values().equals(""))
            
            for(String col : modify.keySet())
            {
                if(i+1 >= modify.keySet().size())
                    
                    columns += col + " " + modify.get(col);
                else
                    columns += col + " " + modify.get(col) + ",";
               
                i++;
            }
        
        try {
            
                this.statement = this.connectionDB.createStatement(
                        this.resultSet.TYPE_SCROLL_INSENSITIVE
                        ,this.resultSet.CONCUR_UPDATABLE
                );
            
           
                if (operation.equals("add"))
                    query +=" ADD "+columns;
                else
                    if(operation.equals("modify"))
                        query +=" MODIFY COLUMN "+columns;
                else
                    if(operation.equals("drop")){
                        
                       HashMap column = this.keyValues(modify);
                        String key = (String)column.get("key");
                        query +=" DROP COLUMN "+key;
                    }
                       
                this.statement.executeUpdate(query);
                        
             return true;
            
        } catch (SQLException ex) {
           
            System.err.println("Cannot execute this query!");
            
            return false;
        }catch(NullPointerException e){
            
            System.err.println("Error for connection!");
            
            return false;
        }
    }
    
    /*
    *   function to create new table
    *
    *
    *
    *   @param string
    *   @return Boolean
    */
    public Boolean create(String create){
        
        try {
            this.statement = this.connectionDB.createStatement(
                    this.resultSet.TYPE_SCROLL_INSENSITIVE
                    ,this.resultSet.CONCUR_UPDATABLE
            );
            
            this.statement.executeUpdate(create);
            return true;
            
        } catch (SQLException ex) {
           
            System.err.println("Cannot create this query");
            
            return false;
            
        }catch(NullPointerException e){
            
            System.err.println("Error for connection!");
            
            return false;
        }
       
    }
    
    /*
    *   function to drop the database
    *
    *
    *   @param void
    *   @return Boolean
    */
    public Boolean dropDB(){
        
        try {
            
            this.statement = this.connectionDB.createStatement(
                    this.resultSet.TYPE_SCROLL_INSENSITIVE
                    ,this.resultSet.CONCUR_UPDATABLE
            );
            
            
            String query = "DROP DATABASE " + this.details.get("databaseName");
            
            this.statement.executeLargeUpdate(query);
            
            return true;
            
        } catch (SQLException ex) {
           
            System.err.println("Cannot Drop the database!");
            
            return false;
        }catch(NullPointerException e){
            
            System.err.println("Error for connection!");
            
            return false;
        }
        
    }
    
    /*
    *   function to close and distroy the connection to the database
    *   
    *
    *   @param void
    *   @retrun Boolean
    */
    public Boolean close(){
        
        try {
            
            this.connectionDB.close();
            this.statement.close();
            this.resultSet.close();
            
            return true;
            
        } catch (SQLException ex) {
            
           System.err.println("Cannot close the connection");
           
           return false;
        }
        
    }
} 

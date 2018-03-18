package models;



import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adrian
 */
public class StudentModel {
   
    static Connection connection;
    static String url;
    static Statement st;
    static ResultSet rs;
    
    
  public int search(String id) throws SQLException, ClassNotFoundException{
          Class .forName("com.mysql.jdbc.Driver");
         url="jdbc:mysql://localhost:3306/math";
           connection = DriverManager.getConnection(url, "root","");
            st = connection.createStatement();
            rs=st.executeQuery("Select * From student Where idno= '"+id+ "'");
            if(rs!=null){
              return 1;
            }
            else{
              return 0;
            }
            
     }
public boolean providedata(String idNo,String lname,String fname,String mi,String course,String sex, String prof,String sub,String datepay,String paystat,String memstat,String memsy){
int check=0,answer,idch=0;
        char aa;
         
        answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to register this account?","System Message",JOptionPane.YES_NO_OPTION);
        if(answer==JOptionPane.YES_OPTION)
        {
          
            
           
            try {
                check = search(idNo);
            } catch(SQLException ex) {
                // Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            }catch(ClassNotFoundException ex) {
                //Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(check==1){
//String idNo,String lname,String fname,String mi,String course,String sex, String prof,String sub,String datepay,String paystat               
                try {
                    if(idNo.equals("")|| lname.equals("")
                    ||fname.equals("")||course.equals("")
                    ||sex.equals("")||prof.equals("")){
                       
                        JOptionPane.showMessageDialog(null,"NEED TO FILL ALL INFORMATION","ERROR",JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                    else if(idNo.length()!=10){
                           JOptionPane.showMessageDialog(null,"INCORRECT ID NUMBER","ERROR",JOptionPane.ERROR_MESSAGE);
                           return false;
                    }
                   
                            
                    else{
                        st.executeUpdate("Insert into student ("+"idno,lname,fname,mi,course,sex,professor,subject,datepay,paystat,memstat,memsy) "
                            + "VALUES ('" + idNo + "','" + lname + "','" + fname + "','"+ mi + "','"  + course
                            + "','" + sex + "','" + prof + "','"+sub+ "','"+datepay+ "','"+paystat+ "','"+memstat+ "','"+memsy+  "')");
                        JOptionPane.showMessageDialog(null, "Record Created","REGISTER",JOptionPane.INFORMATION_MESSAGE);
                       return true;
                        
                }
                }catch(SQLException ex){
                    // Logger.getLogger(frameMain.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "INVALID INPUT(S) OR RECORD ALREADY EXISTS","System Message",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
               
            }
            return false; 
        } 
        
        
        


 public void deletedata(String idNo){
         if(idNo.equalsIgnoreCase("wala"))
                {
                  JOptionPane.showMessageDialog(null, "ERROR","System Message",JOptionPane.ERROR_MESSAGE);   
                }
         else{
  int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this data?","System Message",JOptionPane.YES_NO_OPTION);
        if(answer==JOptionPane.YES_OPTION){

            try {
                
               
                Connection cnn;
                Statement stp;
                String urla;

                urla = "jdbc:mysql://localhost:3306/math";
                cnn = (Connection) DriverManager.getConnection(urla, "root","");
                stp = (Statement) cnn.createStatement();

                String query;
                query = "Delete From student Where idno='" +idNo+ "'";
                stp.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data Deleted","System Message",JOptionPane.INFORMATION_MESSAGE);
                 } catch (SQLException ex) {
            }

        }
         }
  
	
    }
 
 public void declinemem(String[] idNo,int length){
   
  int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to decline ALL student membership?","System Message",JOptionPane.YES_NO_OPTION);
        if(answer==JOptionPane.YES_OPTION){

            try {
                
               
                Connection cnn;
                Statement stp;
                String urla;

                urla = "jdbc:mysql://localhost:3306/math";
                cnn = (Connection) DriverManager.getConnection(urla, "root","");
                stp = (Statement) cnn.createStatement();
   for(int x=0;x<length;x++){
                    stp.executeUpdate("UPDATE student SET  datepay= '00-00-0000',paystat= 'NOT PAID' ,memstat= 'NOT MEMBER',memsy= '0000-0000' Where idno = '"+idNo[x]+"' ");
                    }
                 JOptionPane.showMessageDialog(null, "Payment Confirmed","System Message",JOptionPane.INFORMATION_MESSAGE);
                
            } catch (SQLException ex) {
            }

        
         }
 }
 
    
    public boolean editdata(String reId,String idNo,String lname,String fname,String mi,String course,String sex, String prof,String sub,String datepay,String paystat){
        int answer;
        answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this record?","System Message",JOptionPane.YES_NO_OPTION);
        if(answer==JOptionPane.YES_OPTION){
         
            try {
             
                Connection cn;
                Statement stf;
                String urla;
                urla = "jdbc:mysql://localhost:3306/math";
                Class.forName("com.mysql.jdbc.Driver");
                cn = (Connection) DriverManager.getConnection(urla, "root","");
                stf = (Statement) cn.createStatement();
              
               
                
               if(idNo.equals("wala"))
                {
                  JOptionPane.showMessageDialog(null, "ERROR","System Message",JOptionPane.ERROR_MESSAGE);   
                return false;
                }
               
                      else   if(idNo.equals("")|| lname.equals("")
                    ||fname.equals("")||course.equals("")
                    ||sex.equals("")||prof.equals("")||datepay.equals("")||paystat.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "INFORMATION(S) NEEDED","System Message",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
               else if(idNo.length()!=10){
                           JOptionPane.showMessageDialog(null,"INCORRECT ID NUMBER","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                else{
                stf.executeUpdate("UPDATE student SET  idno= '"+idNo+"',lname= '"+lname+"', fname= '"+fname+"', mi= '"+mi+"',course= '"+course+"',sex= '"+sex
                +"',professor= '"+prof+"',datepay= '"+datepay+"',paystat= '"+paystat+"'Where idno = '"+reId+"' ");
                JOptionPane.showMessageDialog(null, "Record Updated","System Message",JOptionPane.INFORMATION_MESSAGE);
               return true;
               }
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(frameTerminateEdit.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "INVALID INPUT","System Message",JOptionPane.ERROR_MESSAGE);
                 return false;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "INVALID INPUT","System Message",JOptionPane.ERROR_MESSAGE);
              return false;
                //Logger.getLogger(frameTerminateEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    
   
       public void paymentconfirmation(String[] idNo,int ctr,int length,String info){
        Date datee= new Date();
         Date dateesy= new Date();
       SimpleDateFormat ft = 
      new SimpleDateFormat ("MM-dd-yyyy");
       SimpleDateFormat ftt = 
      new SimpleDateFormat ("Y");
       SimpleDateFormat fttmo = 
      new SimpleDateFormat ("MM");
      String sy="";
     int prevyr= Integer.parseInt(ftt.format(dateesy))-1;
     int nxtyr= Integer.parseInt(ftt.format(dateesy))+1;
     if(fttmo.format(dateesy).equalsIgnoreCase("01")||fttmo.format(dateesy).equalsIgnoreCase("02")||
          fttmo.format(dateesy).equalsIgnoreCase("03")){
        sy=prevyr+"-"+ftt.format(dateesy);
     }
     else{
         sy=ftt.format(dateesy)+"-"+nxtyr;
     }
       int answer;
        if(ctr==1){
        answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to confirm the payment?"+"\n"+"ID Number: "+ idNo[0] 
                +"\n"+"Information: "+ info ,"System Message",JOptionPane.YES_NO_OPTION);
        }
        else if(ctr==0){
             answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to confirm ALL payment?"
                ,"System Message",JOptionPane.YES_NO_OPTION);
        }
        else{
            
             answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to confirm the payment/s?"
                ,"System Message",JOptionPane.YES_NO_OPTION);
        }
        
        if(answer==JOptionPane.YES_OPTION){

            try {
             
                Connection cn;
                Statement stf;
                String urla;
                urla = "jdbc:mysql://localhost:3306/math";
                Class.forName("com.mysql.jdbc.Driver");
                cn = (Connection) DriverManager.getConnection(urla, "root","");
                stf = (Statement) cn.createStatement();
              
                if(ctr==0){
                    //lahat
                    for(int x=0;x<length;x++){
                    stf.executeUpdate("UPDATE student SET  datepay= '"+ft.format(datee)+"',paystat= '"+"PAID"+"',memstat= '"+"MEMBER"+"',memsy= '"+sy +"'Where idno = '"+idNo[x]+"' ");
                    }
                 JOptionPane.showMessageDialog(null, "Payment Confirmed","System Message",JOptionPane.INFORMATION_MESSAGE);
                }
                
                else if(ctr==1){
                    //isa lng
                    stf.executeUpdate("UPDATE student SET  datepay= '"+ft.format(datee)+"',paystat= '"+"PAID"+"',memstat= '"+"MEMBER"+"',memsy= '"+sy +"'Where idno = '"+idNo[0]+"' ");
                JOptionPane.showMessageDialog(null, "Payment Confirmed","System Message",JOptionPane.INFORMATION_MESSAGE);
                }
                else if(ctr==2){
                   //maramihan
                    for(int x=0;x<(length);x++){
                        
                    stf.executeUpdate("UPDATE student SET  datepay= '"+ft.format(datee)+"',paystat= '"+"PAID"+"',memstat= '"+"MEMBER"+"',memsy= '"+sy +"'Where idno = '"+idNo[x]+"' ");
                        
                    }
                    JOptionPane.showMessageDialog(null, "Payment Confirmed","System Message",JOptionPane.INFORMATION_MESSAGE);
                 
                }
                else{
                   JOptionPane.showMessageDialog(null, "ERROR","System Message",JOptionPane.ERROR_MESSAGE);
                }
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(frameTerminateEdit.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERROR","System Message",JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR","System Message",JOptionPane.ERROR_MESSAGE);
                //Logger.getLogger(frameTerminateEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
 

}

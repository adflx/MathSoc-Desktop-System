/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import views.*;
import models.*;
/**
 *
 * @author Adrian
 */
public class StudentController {
       private Student v;
    private StudentModel m;
     public StudentController(Student view,StudentModel model){
        this.v=view;
        this.m=model;
        this.v.reg(new provide());
        this.v.del(new dell());
        this.v.ed(new edd());
        this.v.pay(new pa());
          this.v.dec(new de());
    }
     
//String idNo,String lname,String fname,String mi,String course,String sex, String prof,String sub,String datepay,String paystat             
      class provide implements ActionListener{
        public void actionPerformed(ActionEvent e){
           boolean data=false; 
          data = m.providedata(v.getid(),v.getlast(),v.getfirst(),v.getmi(),v.getcourse(),v.sex,v.getprof()
            ,v.getsub(),"00-00-0000","NOT PAID","NOT MEMBER","0000-0000");
          if(data==true){
                         try {
                v.load();
            } catch(SQLException ex) {
                // Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch(ClassNotFoundException ex) {
                //Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
            v.resetprovide();
          }
          
        }
        
    }
      
 class edd implements ActionListener{
        public void actionPerformed(ActionEvent e){
            boolean data=false;
           
           m.editdata(v.getreid(),v.getedid(), v.getedlast(), v.getedfirst(), v.getedmi(), v.getedcourse(),
                   v.sex2, v.getedprof(), v.getedsub(), v.geteddatepay(), v.getedpaystat());
            if(data==true){
                try {
                v.load();
            } catch(SQLException ex) {
                // Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch(ClassNotFoundException ex) {
                //Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
         v.reseted();
            }
           
        }
    }
      
     class dell implements ActionListener{
        public void actionPerformed(ActionEvent e){
            m.deletedata(v.getiddel());
          
                         try {
                v.load();
            } catch(SQLException ex) {
                // Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch(ClassNotFoundException ex) {
                //Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        }
    }  
     
      class de implements ActionListener{
        public void actionPerformed(ActionEvent e){
            m.declinemem(v.getiddec(),v.getlength());
          
                         try {
                v.load();
            } catch(SQLException ex) {
                // Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch(ClassNotFoundException ex) {
                //Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        }
    }  
     
     class pa implements ActionListener{
        public void actionPerformed(ActionEvent e){
           if(v.ctr==0){
               m.paymentconfirmation(v.getpayall(), v.ctr, v.getlength(),v.info());
           }
           else if(v.ctr==1){
                  m.paymentconfirmation(v.getpayone(), v.ctr, v.getlength(),v.info());   
            }
           else if(v.ctr==2){
                 m.paymentconfirmation(v.getpaymany(), v.ctr, v.getlength(),v.info());
           }
          
                         try {
                v.load();
            } catch(SQLException ex) {
                // Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch(ClassNotFoundException ex) {
                //Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        }
    }  
     
       
      
        public static void main(String[] args){
        Student vi=new Student();
        StudentModel mo=new StudentModel();
        StudentController co=new StudentController(vi,mo);
        vi.setVisible(true);
    }
     
}

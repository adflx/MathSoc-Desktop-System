/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.*;

/**
 *
 * @author Doyong
 */
public class main {
    
    public static void main(String[]args){
        Login login = new Login();
       
        String officerPosition = login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null, "Look Ma, I'm in Main...");
            }
            
        });
        login.setVisible(true);
        
        officerPosition = login.getOfficerPosition();
    }
}

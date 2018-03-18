/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author Doyong
 */
public class restrictions {
    String officerPosition;
    String task;
    
    public restrictions(String officerposition, String task){
        this.officerPosition = officerposition;
        this.task = task;
    }
    
    public boolean isRestricted(){
        if(null != officerPosition)switch (officerPosition) {
            case "Adviser":
            case "Co-Adviser":
            case "President":
            case "Vice President":
                return false;
            case "Secretary":
                if("Student".equals(task) || "Officer".equals(task) || "Report".equals(task) || "Events".equals(task)){
                    return false;
                }   break;
            case "Treasurer":
                 if("Expenses".equals(task) || "Collection".equals(task)){
                    return false;
                }   break;
            case "Auditor":
                if("Expenses".equals(task) || "Collection".equals(task)){
                    return false;
                }   break;
            case "Business Manager":
                if("Report".equals(task)){
                    return false;
                }   break;
            default:
                break;
        }
        return true;
        }
        
    }
    


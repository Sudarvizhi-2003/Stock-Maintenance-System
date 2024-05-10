/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonFinish;

import dao.StockUtils;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author SAI
 */
public class openPdf {
    public static void openbyid(String id){
        try{
            if((new File(StockUtils.billpath+id+".pdf")).exists()){
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll, FileProtocolHandler "+StockUtils.billpath+""+id+".pdf");
            }
            else{
                JOptionPane.showMessageDialog(null, "File does not exists");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}

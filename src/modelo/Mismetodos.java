/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author FREL DAVID
 */
public class Mismetodos {
    public ImageIcon resizePic(String picPath,byte[]BLOBpic,int wdth,int hgt){
    ImageIcon myImg;
        if(picPath  != null){
    
        myImg = new ImageIcon(picPath);
    
    }else{ myImg=new ImageIcon(BLOBpic);
    }
    Image imag= myImg.getImage().getScaledInstance(wdth, hgt,Image.SCALE_SMOOTH);
        String img = null;
    ImageIcon myPicture= new ImageIcon(imag);
    return myPicture;
    }
 public String browseImage(JLabel lbl) {
 String Path=null;
 JFileChooser filec= new JFileChooser();
 filec.setCurrentDirectory(new File(System.getProperty("user.home")));
 //file extencion
 FileNameExtensionFilter fileFilter=new FileNameExtensionFilter("Images","jpg","png","gif");
 filec.addChoosableFileFilter(fileFilter);
 
 int fileState=filec.showOpenDialog(null);
 //si el usuario selecciona el archivo
 
 if(fileState==JFileChooser.APPROVE_OPTION){
 File selectedFile=filec.getSelectedFile();
 Path=selectedFile.getAbsolutePath();
 
 lbl.setIcon(resizePic(Path,null,lbl.getWidth(),lbl.getHeight()));
 }
       //siel usuario cansela
 else if(fileState==JFileChooser.CANCEL_OPTION){
 System.out.println("no selecciono imagen");
 }
 return Path;
 }

    

}
 
   
    
    
    
    
    


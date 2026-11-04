/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.awt.Container;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import vista.Admini_users_form;

/**
 *
 * @author FREL DAVID
 */
public class ReportesView {

    private static Container visorIncrustado() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return visorIncrustado();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  public ReportesView() {
  } 
   public static void mostrarReportes(String rutaReporte, Map parametros)throws Exception{
    try{
        JasperReport report= JasperCompileManager.compileReport(rutaReporte);
    Connection con = modelo.conexion_DB.getConnection();
    JasperPrint print= JasperFillManager.fillReport(report, parametros, con);
    
    
    JasperViewer visor= new JasperViewer(print);
     JasperViewer.viewReport(print,true);
     visor.setExtendedState(JFrame.MAXIMIZED_BOTH);
  Admini_users_form.ventanaprincipal.setExtendedState(JFrame.ICONIFIED);
  
    
    }catch(Exception e){
    throw new Exception("Error al generar el reporte"+e.getMessage());
    }
    
    
    } 
    public static Container mostrarReporte(InputStream ioReporte, Map parametros)throws Exception{
        //compila el reporte fichero. jrxml y lo convierte en fichero jasper
        try{
   JasperReport reporte= JasperCompileManager.compileReport(ioReporte);
   Connection con =modelo.conexion_DB.getConnection();
    JasperPrint print= JasperFillManager.fillReport(reporte,parametros,con);
   //JasperViewer visor =new JasperViewer(print);
    net.sf.jasperreports.view.JRViewer visorIncrustado = new net.sf.jasperreports.view.JRViewer(print);
    return visorIncrustado();
    
        }catch(Exception e){
        e.printStackTrace();
        throw new Exception("error al generar reporte"+e.getMessage());
        }
    }    
    public static void mostrarReporte(Map parametros){
    //crea un ficehro carpeta por defecto
    File carpetaReportes=new File("reportes");
    //crea un objeto para trabajar con un navegador de fichero (abrir o guardar)
    JFileChooser ventanaAbrirFichero=new JFileChooser();
    //colocar el titulo de la ventana abrir
    ventanaAbrirFichero.setDialogTitle("buscar el reporte.jrxml");
    //cambio el nombre del boton 
    ventanaAbrirFichero.setApproveButtonText("seleccionar reportes");
    //coloco una rayita sobre la S selnombre bton 
    ventanaAbrirFichero.setApproveButtonMnemonic('s');
    //colo un mensaje al momento de tocar el boton con el raton para abrir
    ventanaAbrirFichero.setApproveButtonToolTipText("prisionelo una vez este selecionado el fichero.jrxml");
    //hago visible los controles de la ventana 
    ventanaAbrirFichero.setControlButtonsAreShown(true);
    // le d paso la carperta en la que va a iniciara la navegacion.
    ventanaAbrirFichero.setCurrentDirectory(carpetaReportes);
    //crea un fichero para que lo coloque por defecto  en la casilla nombre dl fichero a abrir.
    File ficheroSeleccionadoDefault=new File("todos_contactos_s_ec.jrxml");
    //coloco a buscar el fichero por defecto
    ventanaAbrirFichero.setSelectedFile(ficheroSeleccionadoDefault);
    //coloco un objero para filtrar los tipos de archivo que se pueden seleccionar
    //en este caso solo archivos con extension .jrxml
    //ventanaAbrirFichero.setFileFilter(new JrxmlFiltro());
    int respuesta=ventanaAbrirFichero.showOpenDialog(Admini_users_form.ventanaprincipal);
    //verifica si se oprimio el boton abrir o le cancelar
    if (respuesta==JFileChooser.APPROVE_OPTION){
    //obtenemos el fichero desde la ventana abrir
    File ficheroSeleccionado=ventanaAbrirFichero.getSelectedFile();
    //obtenmos el nombre fichero
    String nombreFicehro=ficheroSeleccionado.getName();
    //verifico que el fichero contine la extension.jrxml
    if(nombreFicehro.lastIndexOf(".jrxml")==-1){
     JOptionPane.showMessageDialog(ventanaAbrirFichero,"debe selecionar un fichero .jrxml");   
       ventanaAbrirFichero.showOpenDialog(ventanaAbrirFichero);//vuelve a mostrar la ventana de abrr
        
    }else{
    //llamamos al metodo mostrarportes y leir pasamos la ruta completa del ficheroselecionado con la ventana abr
    try{
    mostrarReportes(ficheroSeleccionado.getAbsolutePath(),parametros);
    }catch(Exception e){
    JOptionPane.showMessageDialog(ventanaAbrirFichero,e.getMessage());
    }
    }
    
    }
    
    
    
    
    }
    
}
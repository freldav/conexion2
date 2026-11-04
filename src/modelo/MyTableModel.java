/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FREL DAVID
 */
public  class MyTableModel extends AbstractTableModel{
    //para mostrar la pantalla completa
    //this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    private  String []column;
    private Object[][] rows;
    private int col;
    
    public MyTableModel(){}
    
     public MyTableModel(Object[][] data,String[] columnName){
     this.column= columnName;
     this.rows=data;
     
     
     }
    public Class getColumnClass(int col){
    if(col==7){return Icon.class;}
    else{
        if(getRowCount()>0&& getValueAt(0,col)!=null){
         return getValueAt(0,col).getClass();
        }
   return Object.class;
    }
    
    }

    @Override
    public int getRowCount() {
        
        return(rows !=null)? rows.length: 0;
        
    }

    @Override
    public int getColumnCount() {
       return (column != null) ? column.length : 0;
    }

@Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       return rows[rowIndex][columnIndex];
   }
    
    public String getColumnName(int col) {
       return (column != null) ? column[col] :"";
    } 
     
}

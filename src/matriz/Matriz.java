/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz;

import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Juan David Monroy
 */
public class Matriz {
    public int[][] matriz ;
    public int[][] matriz_A ;
    public int[][] matriz_B ;
    public int[][] matriz_suma ;
    public int[][] matriz_resta ;
    public int[][] matriz_producto;
    public int[][] matriz_cubo;
    public int[][] matriz_transpuesta;
    public int[][] matriz_multiplicacion;
    
    /**
     * Metodo que recorre la matriz y la muestra por consola
     * @param matriz es la matriz entera
     * @param filas  es el número de filas de la matriz
     * @param columnas es el número de columnas de la matriz
     */
   public void mostrarMatriz(int[][] matriz,int filas, int columnas){
    
        for (int i = 0; i < filas; i++) {
            for (int j = 0;j  < columnas; j++) {
               
                System.out.print(" "+matriz[i][j]+" ");
            }
        }System.out.print("");
           
    }
    public void crearMatriz( int filas, int columnas){
       {
           try{matriz = new int[filas][columnas];
                 for ( int i = 0;i<filas;i++){
           for(int j = 0;j<columnas;j++){
                 String llenado = JOptionPane.showInputDialog("Inserte el dato número ["+(i+1)+","+(j+1)+"]");
                 if(llenado.equals("")){
                 int sub_opcion = JOptionPane.showConfirmDialog(null, "¿No agregó un numero, desea que se llene por defecto?");
                 switch(sub_opcion){
                     case 0:
                     matriz[i][j] = 0;
                     break;
                     case 1:
                     JOptionPane.showMessageDialog(null,"Volviendo al menu principal");
                     break;
                     case 2:
                     JOptionPane.showMessageDialog(null,"Volviendo al menu principal");
                     break;
                 }               
                 }else {
                     int num = Integer.parseInt(llenado); 
                         matriz[i][j] =  num;
                         System.out.println(" "+matriz[i][j]+" ");
                         }  
                                                                }
                                                               }
               }catch(IndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(null,"Está buscando en una posición fuera de los limites");
                                    }
                catch(NullPointerException e){
                    JOptionPane.showMessageDialog(null,"Está buscando en una posición inexistente, intentalo de nuevo");
                }
       }
       
    }
    
    public void crearMatrizAleatorio(int filas, int columnas){
        matriz = new int[filas][columnas];
       try{
            
         String n1 = JOptionPane.showInputDialog("Inserte el primer valor del rango de los números aleatorios ");
         String n2 =JOptionPane.showInputDialog("Inserte el último valor del rango de los números aleatorios ");
         int rango_inicial = Integer.parseInt(n1);
         int rango_final = Integer.parseInt(n2);
         if(rango_inicial<rango_final){
           for (int i = 0;i<matriz.length;i++){
           matriz[i][0]= i++;
                                                }
        for(int i = 0;i< filas;i++){  
            for(int j =0; j< columnas;j++){
                matriz[i][j] = (int)(Math.random()*(rango_final-rango_inicial))+rango_inicial;
            }
        }
        }else{
             JOptionPane.showMessageDialog(null,"Ingresó un rango de números incorrecto");
         }
        
       }  catch(NumberFormatException e){
           JOptionPane.showMessageDialog(null,"Ingrese un valor correcto");
        } 
       
    }
    
    public void sumasMatriz(int[][] _A, int[][] matriz_B){
       if(matriz_A.length == matriz_B.length && matriz_A[0].length== matriz_B[0].length){
         matriz_suma = new int[matriz_A.length][matriz_B.length];
           for (int i = 0; i < matriz_A.length; i++) {
               for (int j = 0; j < matriz_A[i].length; j++) {
                   matriz_suma[i][j]= matriz_A[i][j]+matriz_B[i][j];
               }
           }
       }else{
           JOptionPane.showMessageDialog(null,"La operación no es posible, ingrese dos matrices de igual dimensión");
       }
    }
    
    public void restasMatriz(int[][] _A, int[][] matriz_B){
          if(matriz_A.length == matriz_B.length && matriz_A[0].length== matriz_B[0].length){
           matriz_resta = new int[matriz_A.length][matriz_B.length];
           for (int i = 0; i < matriz_A.length; i++) {
               for (int j = 0; j < matriz_A[i].length; j++) {
                   matriz_resta[i][j]= matriz_A[i][j]-matriz_B[i][j];
               }
           }
       }else{
           JOptionPane.showMessageDialog(null,"La operación no es posible, ingrese dos matrices de igual dimensión");
       }
    }
    
    public void productoPuntoMatriz(int[][] _A, int[][] matriz_B){
         if(matriz_A.length == matriz_B.length && matriz_A[0].length== matriz_B[0].length){
          matriz_producto = new int[matriz_A.length][matriz_B.length];
           for (int i = 0; i < matriz_A.length; i++) {
               for (int j = 0; j < matriz_A[i].length; j++) {
                   matriz_producto[i][j]= matriz_A[i][j] * matriz_B[i][j];
               }
           }
       }else{
           JOptionPane.showMessageDialog(null,"La operación no es posible, ingrese dos matrices de igual dimensión");
       }
    }
     
     public void multiplicacionMatriz(int[][] _A, int[][] matriz_B){
         if(matriz_A[0].length==matriz_B.length){
              matriz_multiplicacion = new int[matriz_A.length][matriz_B[0].length];
             for(int i=0;i<matriz_A.length;i++){
                 for (int j = 0; j < matriz_B[0].length; j++) {
                     for (int k = 0; k< matriz_A[0].length ; k++) {
                         matriz_multiplicacion[i][j]+= matriz_A[i][k]* matriz_B[k][j];
                     }
                 }
             }
         }else{
           JOptionPane.showMessageDialog(null,"La operación no es posible, el número de columnas de una Matriz es diferente al número de filas de la otra");
       }
     }
     
     public void transpuestaMatriz(int matriz[][],int filas, int columnas){
         
         matriz_transpuesta = new int[columnas][filas];
        for(int i = 0;i< filas;i++){  
            for(int j =0; j< columnas;j++){
               matriz_transpuesta[j][i] = matriz[i][j];
            }
        }
     }
     
     public void cuboMatriz(int matriz[][],int filas, int columnas){
         matriz_cubo = new int[filas][columnas];

        for(int i = 0;i< filas;i++){  
            for(int j =0; j< columnas;j++){
                matriz_cubo[i][j] =(int) Math.pow(matriz[i][j],3);
            }
        }
     }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI userInterface = new GUI();
         userInterface.setVisible(true);
    }

   
    
}

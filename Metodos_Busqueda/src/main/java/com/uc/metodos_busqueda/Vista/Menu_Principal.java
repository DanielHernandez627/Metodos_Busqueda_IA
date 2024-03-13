/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.uc.metodos_busqueda.Vista;

import com.uc.metodos_busqueda.Controlador.ControladorA;
import com.uc.metodos_busqueda.Controlador.ControladorBpp;
import com.uc.metodos_busqueda.Controlador.ControladorColina;
import com.uc.metodos_busqueda.Modelo.Nodo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author pillo
 */
public class Menu_Principal extends javax.swing.JFrame {

    
    private int[][] matriz;
    private int[][] estadoInicial;
    private int[][] estadoMeta;
    private int cantidad_nodos;
    
    public Menu_Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        n_nodos = new javax.swing.JTextField();
        btn_bpp = new javax.swing.JButton();
        btn_ascenso = new javax.swing.JButton();
        btn_Asterisco = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btn_arfin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btn_arini = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_finalE = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_ini = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_finalS = new javax.swing.JTextArea();
        btn_reinicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Estado Inicial");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Estado Final");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Estado Final Esperado");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad de nodos");

        n_nodos.setEnabled(false);

        btn_bpp.setText("BPP");
        btn_bpp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bppActionPerformed(evt);
            }
        });

        btn_ascenso.setText("Ascenso de colina");
        btn_ascenso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ascensoActionPerformed(evt);
            }
        });

        btn_Asterisco.setText("A*");
        btn_Asterisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AsteriscoActionPerformed(evt);
            }
        });

        jButton4.setText("Algoritmo Genetico");

        btn_arfin.setText("Seleccionar archivo final");
        btn_arfin.setToolTipText("");
        btn_arfin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_arfinActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Metodos de Busqueda");

        btn_arini.setText("Seleccionar archivo inicial");
        btn_arini.setToolTipText("");
        btn_arini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ariniActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Metodos de Busqueda");

        txt_finalE.setColumns(20);
        txt_finalE.setRows(5);
        txt_finalE.setEnabled(false);
        jScrollPane1.setViewportView(txt_finalE);

        txt_ini.setColumns(20);
        txt_ini.setRows(5);
        txt_ini.setEnabled(false);
        jScrollPane2.setViewportView(txt_ini);

        txt_finalS.setColumns(20);
        txt_finalS.setRows(5);
        txt_finalS.setEnabled(false);
        jScrollPane3.setViewportView(txt_finalS);

        btn_reinicio.setText("Reiniciar Menu");
        btn_reinicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reinicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel1)
                        .addGap(152, 152, 152)
                        .addComponent(jLabel3)
                        .addGap(149, 149, 149)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(760, 760, 760)
                        .addComponent(btn_Asterisco, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(740, 740, 740)
                        .addComponent(btn_arini))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(740, 740, 740)
                        .addComponent(btn_arfin, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel2))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(n_nodos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_reinicio))
                                .addGap(250, 250, 250)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(150, 150, 150)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_bpp, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_ascenso, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_bpp)
                        .addGap(27, 27, 27)
                        .addComponent(btn_ascenso)))
                .addComponent(btn_Asterisco)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(10, 10, 10)
                                .addComponent(n_nodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btn_reinicio)))))
                .addComponent(btn_arini)
                .addGap(17, 17, 17)
                .addComponent(btn_arfin)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ariniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ariniActionPerformed
        //limpiarMatrices();
        seleccionarArchivo(1);
    }//GEN-LAST:event_btn_ariniActionPerformed

    private void btn_arfinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_arfinActionPerformed
        //limpiarMatrices();
        seleccionarArchivo(2);
    }//GEN-LAST:event_btn_arfinActionPerformed

    private void btn_bppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bppActionPerformed
        String profundidadStr = JOptionPane.showInputDialog(null, "Ingrese la profundidad deseada:");
        if (profundidadStr != null && !profundidadStr.isEmpty()) {
            try {
                int profundidad = Integer.parseInt(profundidadStr);
                System.out.println("Profundidad ingresada: " + profundidad);
                Nodo nodoInicial = new Nodo(estadoInicial, null, 0);
                Nodo nodoMeta = new Nodo(estadoMeta, null, 0);
                ControladorBpp bpp = new ControladorBpp(nodoInicial, nodoMeta, profundidad);
                matriz = bpp.resolverPuzzle();
                mostrarMatrizfinalS();
                cantidad_nodos = bpp.contarNodosGenerados();
                n_nodos.setText(String.valueOf(bpp.contarNodosGenerados()));
                bpp.guardarMovimientosEnArchivo("movimientosBPP.txt");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor válido para la profundidad.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("Entrada cancelada por el usuario.");
        }
    }//GEN-LAST:event_btn_bppActionPerformed

    private void btn_AsteriscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AsteriscoActionPerformed
       ControladorA controladorA = new ControladorA(estadoInicial, estadoMeta);
       matriz = controladorA.resolverProblema();
       mostrarMatrizfinalS();
       n_nodos.setText(String.valueOf(controladorA.getNodosGenerados()));
    }//GEN-LAST:event_btn_AsteriscoActionPerformed

    private void btn_ascensoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ascensoActionPerformed
        ControladorColina colina = new ControladorColina(estadoInicial, estadoMeta);
        matriz = colina.resolver();
        mostrarMatrizfinalS();
        n_nodos.setText(String.valueOf(colina.cantidadNodosGenerados()));
        colina.guardarMovimientosEnArchivo("movimientosColina.txt");
    }//GEN-LAST:event_btn_ascensoActionPerformed

    private void btn_reinicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reinicioActionPerformed
        reiniciarMenu();
    }//GEN-LAST:event_btn_reinicioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Principal().setVisible(true);
            }
        });
    }
    
    
    public void seleccionarArchivo(int btn_selecionado){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar Archivo");
        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            leerContenidoArchivo(archivoSeleccionado, btn_selecionado);
            if(btn_selecionado == 1){
                mostrarMatrizinicial();
            }else{
                mostrarMatrizfinal();
            }
            
        }
    }
    
    public void leerContenidoArchivo(File archivo,int btn_seleccionado) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int fila = 0;
            if(btn_seleccionado == 1){
                while ((linea = br.readLine()) != null) {
                    String[] valores = linea.split("\\|");
                    if (estadoInicial == null) {
                        estadoInicial = new int[valores.length][valores.length];
                    }

                    for (int columna = 0; columna < valores.length; columna++) {
                        estadoInicial[fila][columna] = Integer.parseInt(valores[columna]);
                    }

                    fila++;
                }
            }else{
                while ((linea = br.readLine()) != null) {
                    String[] valores = linea.split("\\|");
                    if (estadoMeta == null) {
                        estadoMeta = new int[valores.length][valores.length];
                    }

                    for (int columna = 0; columna < valores.length; columna++) {
                        estadoMeta[fila][columna] = Integer.parseInt(valores[columna]);
                    }

                    fila++;
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void mostrarMatrizinicial() {
        if (estadoInicial != null) {
            for (int[] fila : estadoInicial) {
                for (int valor : fila) {
                    txt_ini.append(valor + "\t");
                }
                txt_ini.append("\n");
            }
        }
    }
    
    public void mostrarMatrizfinal() {
        if (estadoMeta != null) {
            for (int[] fila : estadoMeta) {
                for (int valor : fila) {
                    txt_finalE.append(valor + "\t");
                }
                txt_finalE.append("\n");
            }
        }
    }
    
    public void mostrarMatrizfinalS() {
        if (matriz != null) {
            for (int[] fila : matriz) {
                for (int valor : fila) {
                    txt_finalS.append(valor + "\t");
                }
                txt_finalS.append("\n");
            }
        }
    }
    
    private void reiniciarMenu(){
        n_nodos.setText("");
        txt_ini.setText("");
        txt_finalE.setText("");
        txt_finalS.setText("");
        limpiarMatrices();
    }
    
    
    private void limpiarMatrices(){
        estadoInicial = null;
        estadoMeta = null;  
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Asterisco;
    private javax.swing.JButton btn_arfin;
    private javax.swing.JButton btn_arini;
    private javax.swing.JButton btn_ascenso;
    private javax.swing.JButton btn_bpp;
    private javax.swing.JButton btn_reinicio;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField n_nodos;
    private javax.swing.JTextArea txt_finalE;
    private javax.swing.JTextArea txt_finalS;
    private javax.swing.JTextArea txt_ini;
    // End of variables declaration//GEN-END:variables

}

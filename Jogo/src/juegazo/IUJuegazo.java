/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegazo;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import objects.AI;
import objects.Tablero;

/**
 *
 * @author Jimmi
 */
public class IUJuegazo extends javax.swing.JFrame {

    private int nivel;
    private Tablero tablero;
    private AI genious;
    /**
     * Creates new form IUJuegazo
     */
    public IUJuegazo(boolean iniciaP1, int pnivel) {
        nivel = pnivel;
        tablero = new Tablero(iniciaP1);
        genious = new AI(tablero,nivel);
        initComponents();
        acomodarTablero();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJuego = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaJuego.setAutoCreateRowSorter(true);
        tablaJuego.setBorder(new javax.swing.border.MatteBorder(null));
        tablaJuego.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaJuego.setToolTipText("");
        tablaJuego.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaJuego.setMaximumSize(new java.awt.Dimension(7, 7));
        tablaJuego.setMinimumSize(new java.awt.Dimension(7, 7));
        tablaJuego.setRowHeight(30);
        tablaJuego.setRowSelectionAllowed(false);
        tablaJuego.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaJuego.getTableHeader().setResizingAllowed(false);
        tablaJuego.getTableHeader().setReorderingAllowed(false);
        tablaJuego.setUpdateSelectionOnSort(false);
        tablaJuego.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(tablaJuego);
        tablaJuego.getAccessibleContext().setAccessibleName("tablero");

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jButton1)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!tablero.isGameOver()){
            int iFila = tablaJuego.getRowCount()-1;
            int columna = tablaJuego.getSelectedColumn();
            boolean colocada = false;

            while(iFila>-1 && !colocada){
                if(tablaJuego.getValueAt(iFila, columna).toString().equals("")){
                    if(tablero.isTurno()){
                            tablaJuego.setValueAt("O", iFila,columna);
                    }else{
                            tablaJuego.setValueAt("X", iFila,columna);
                    }
                    tablero.colocarFicha(iFila,columna);
                    colocada = true;
                }
                iFila--;
            }
            System.out.println(tablero.ganadorVertical(6,0));
            System.out.println(tablero.ganadorHorizontal(6,6));
            System.out.println(tablero.ganadorDiagonalDerIzq(6,6));
            System.out.println(tablero.ganadorDiagonalIzqDer(0,0));
            
        }
        System.out.println(tablero.mostrarTablero());
        //System.out.println(genious.getScore());
        
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaJuego;
    // End of variables declaration//GEN-END:variables

    private void acomodarTablero() {
        for(int i = 0 ; i<tablaJuego.getRowCount();i++)
            for(int j = 0 ; j<tablaJuego.getColumnCount();j++)
                tablaJuego.setValueAt("", i, j);
    }
}

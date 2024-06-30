/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Clases.Append;
import Clases.AsignVect;
import Clases.AsignVect2D;
import Clases.Assign;
import Clases.Declaration;
import Clases.DinamicList;
import Clases.Entorno;
import Clases.Function;
import Clases.Instruccion;
import Clases.START;
import Clases.Struct;
import Clases.Vect;
import Clases.Vect2D;
import Utilidades.Salidas;
import Utilidades.TableSymbol;
import javacup.Parser;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import javacup.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.KeyedValues;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Gerson
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
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

        datasets = new LinkedList<>();
        cl = new CardLayout();
        listFile = new ArrayList<File>();
        listTextArea = new ArrayList<JTextPane>();
        listScroll = new ArrayList<javax.swing.JScrollPane>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setBounds(new java.awt.Rectangle(150, 70, 0, 0));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 764));

        jLabel1.setFont(new java.awt.Font("JetBrains Mono ExtraBold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Entrada");

        jLabel2.setFont(new java.awt.Font("JetBrains Mono ExtraBold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Consola");

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jTabbedPane1.setBackground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(150, 150));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 500));

        jTextPane1.setFont(new java.awt.Font("JetBrains Mono", 1, 17));
        jTextPane1.setMaximumSize(new java.awt.Dimension(2147483647, 500));
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("JetBrains Mono", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("RUN");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 658, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(587, 587, 587))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(647, 647, 647)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenu5.setBackground(new java.awt.Color(255, 255, 255));
        jMenu5.setForeground(new java.awt.Color(255, 255, 255));
        jMenu5.setText("Archivo");
        jMenu5.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jMenuItem1.setText("Nuevo Archivo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jMenuItem2.setText("Abrir Archivo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jMenuItem3.setText("Guardar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuItem7.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jMenuItem7.setText("Cerrar Pestaña");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuBar1.add(jMenu5);

        jMenu7.setText("Ejecutar");
        jMenu7.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu7);

        jMenu8.setText("Reportes");
        jMenu8.setFont(new java.awt.Font("JetBrains Mono ExtraBold", 1, 14)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jMenuItem4.setText("Reporte de Errores");
        jMenu8.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jMenuItem5.setText("Reporte de Tokens");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem5);

        jMenuItem6.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jMenuItem6.setText("Tabla de símbolos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem6);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1384, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // OPCION DE CREAR NUEVA PESTAÑA
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code sdfhere:
        crearPanel();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    //   OPCION DE GUARDAR
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if (listFile.get(jTabbedPane1.getSelectedIndex()).getPath().equals("")) {
            JFileChooser guardar = new JFileChooser();
            int opc = guardar.showSaveDialog(null);
            if (opc == JFileChooser.APPROVE_OPTION) {
                File archivo = guardar.getSelectedFile();
                listFile.set(jTabbedPane1.getSelectedIndex(), archivo);
                jTabbedPane1.setTitleAt(jTabbedPane1.getSelectedIndex(), archivo.getName());
                try {
                    FileWriter fw = new FileWriter(listFile.get(jTabbedPane1.getSelectedIndex()).getPath());
                    String text = listTextArea.get(jTabbedPane1.getSelectedIndex()).getText(); //aqui puedo obtener el texto de la interfaz como un string
                    for (int i = 0; i < text.length(); i++) {
                        fw.write(text.charAt(i));
                    }
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            try {
                FileWriter fw = new FileWriter(listFile.get(jTabbedPane1.getSelectedIndex()).getPath());
                String text = listTextArea.get(jTabbedPane1.getSelectedIndex()).getText(); //aqui puedo obtener el texto de la interfaz como un string
                for (int i = 0; i < text.length(); i++) {
                    fw.write(text.charAt(i));
                }
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    // ABRIR ARCHIVO E INSERTARLO EN EL AREA DE TEXTO
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:

        crearPanel();
        JFileChooser selector = new JFileChooser();
        selector.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int resultado = selector.showOpenDialog(listTextArea.get(jTabbedPane1.getSelectedIndex()));

        if (resultado == JFileChooser.APPROVE_OPTION) {

            try {
                boolean existePath = false;
                for (int i = 0; i < jTabbedPane1.getTabCount(); i++) {
                    File f = selector.getSelectedFile();
                    if (listFile.get(i).getPath().equals(f.getPath())) {
                        existePath = true;
                    }
                }

                if (!existePath) {
                    File archivo = selector.getSelectedFile();
                    listFile.set(jTabbedPane1.getSelectedIndex(), archivo);

                    FileReader entrada = new FileReader(listFile.get(jTabbedPane1.getSelectedIndex()).getPath());
                    BufferedReader buffer = new BufferedReader(entrada);
                    String linea = "";
                    String titulo = listFile.get(jTabbedPane1.getSelectedIndex()).getName();
                    jTabbedPane1.setTitleAt(jTabbedPane1.getSelectedIndex(), titulo);

                    while (linea != null) {
                        linea = buffer.readLine();
                        if (linea != null) {
                            append(linea + "\n", listTextArea.get(jTabbedPane1.getSelectedIndex()));

                        }
                        if (jTabbedPane1.getTabCount() > 0) {
                            font(contadorPane, tipo, listTextArea);
                        }
                    }

                } else {
                    for (int i = 0; i < jTabbedPane1.getTabCount(); i++) {
                        File f = selector.getSelectedFile();
                        if (listFile.get(i).getPath().equals(f.getPath())) {
                            jTabbedPane1.setSelectedIndex(i);
                            listTextArea.remove(jTabbedPane1.getTabCount() - 1);
                            listScroll.remove(jTabbedPane1.getTabCount() - 1);
                            listFile.remove(jTabbedPane1.getTabCount() - 1);
                            jTabbedPane1.remove(jTabbedPane1.getTabCount() - 1);
                            contadorPane--;
                            break;
                        }
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            int seleccion = jTabbedPane1.getSelectedIndex();
            if (seleccion != -1) {
                listTextArea.remove(jTabbedPane1.getTabCount() - 1);
                listScroll.remove(jTabbedPane1.getTabCount() - 1);
                listFile.remove(jTabbedPane1.getTabCount() - 1);
                jTabbedPane1.remove(jTabbedPane1.getTabCount() - 1);
                contadorPane--;
            }
        }


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        int seleccion = jTabbedPane1.getSelectedIndex();
        if (seleccion != -1) {
            listTextArea.remove(seleccion);
            listScroll.remove(seleccion);
            listFile.remove(seleccion);
            jTabbedPane1.remove(seleccion);
            contadorPane--;
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    //   BOTON RUN
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String texto = listTextArea.get(jTabbedPane1.getSelectedIndex()).getText();
        
        
        jTextPane1.setText("");
       
        Salidas.resetConsola();
        
        
        try {
            Lex scanner = new Lex(new BufferedReader(new StringReader(texto.toString())));
            Parser parser = new Parser(scanner);
            var resultado = parser.parse();
            TableSymbol.limpiar();
            Entorno global = new Entorno(null, "Global");
            START empezar = null;
            
            if(resultado.value instanceof LinkedList){
                LinkedList<?> lista = (LinkedList<?>) resultado.value;
                for(var instruccion: lista){
                    if(instruccion instanceof Function || instruccion instanceof AsignVect || instruccion instanceof AsignVect2D || instruccion instanceof Append || instruccion instanceof Struct){
                        ((Instruccion) instruccion).ejecutar(global);
                    }
                    if(instruccion instanceof Declaration || instruccion instanceof Vect || instruccion instanceof Vect2D || instruccion instanceof DinamicList || instruccion instanceof Assign){
                        ((Instruccion) instruccion).ejecutar(global);
                    }
                    if(instruccion instanceof START){
                        //((Instruccion) instruccion).ejecutar(global);
                        empezar = (START) instruccion;
                    }
                }
            }
            //System.out.println(Salidas.getConsola());
            if(empezar!=null){
                empezar.ejecutar(global);
            }
            jTextPane1.setText(Salidas.getConsola());
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Ocurrio un error");
                e.printStackTrace();
            }
        
        /*try {
            String text5 = "println(\"Int a Char\");\nprintln((char)97 + \"\\n\");";
            Lex scanner = new Lex(new BufferedReader(new StringReader(texto)));

            Symbol token = null;
            do{
                token = scanner.next_token();
                //if(token.value!=null){
                if(sym.terminalNames[token.sym]=="STRING"){
                    System.out.println("token: " + token.value.toString().replace("\"", "") + "---" + sym.terminalNames[token.sym]);
                    continue;
                }
                
                    System.out.println("token: " + token.value + "---" + sym.terminalNames[token.sym]);    
                //}
            }while(token.value!=null);              
            Parser parser = new Parser(scanner);
            parser.parse();
            System.out.println("Análisis terminado");

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }*/
     
    }//GEN-LAST:event_jButton1ActionPerformed

    // REPORTE DE TOKENS
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        String texto = listTextArea.get(jTabbedPane1.getSelectedIndex()).getText();
        try {
            //PRUEBA PARA IMPRIMIR LOS TOKENS Y PODER USARLOS EN EL REPORTE DE TOKENS EN HTML
            HTML.archivoTokens(texto);
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    // REPORTE DE SIMBOLOS O TABLA DE SIMBOLOS MEJOR DICHO
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        TableSymbol.crearTabla();
    }//GEN-LAST:event_jMenuItem6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

    private ArrayList<JTextPane> listTextArea;
    private ArrayList<File> listFile;
    private ArrayList<javax.swing.JScrollPane> listScroll;
    private int contadorPane = 0;
    private boolean existPane = false;
    private final String tipo = "w";
    private CardLayout cl;
    private LinkedList<ChartPanel> datasets;

    public void crearPanel() {
        JPanel ventana = new javax.swing.JPanel();
        ventana.setLayout(new BorderLayout());
        listFile.add(new File(""));
        listTextArea.add(new JTextPane());
        listScroll.add(new javax.swing.JScrollPane(listTextArea.get(contadorPane)));

        //JTextPane areaTexto = new javax.swing.JTextPane(); 
        ventana.add(listScroll.get(contadorPane));
        jTabbedPane1.addTab("title", ventana);
        jTabbedPane1.setSelectedIndex(contadorPane);
        contadorPane++;
        font(contadorPane, tipo, listTextArea);
        existPane = true;
    }

    public static void append(String linea, javax.swing.JTextPane areaTexto) {
        try {
            Document doc = areaTexto.getDocument();
            doc.insertString(doc.getLength(), linea, null);
        } catch (BadLocationException exc) {
            exc.printStackTrace();
        }
    }

    public static void font(int contador, String tipo, ArrayList<JTextPane> list) {
        if (tipo.equals("w")) {
            for (int i = 0; i < contador; i++) {
                list.get(i).selectAll();
                StyleContext sc = StyleContext.getDefaultStyleContext();
                AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.WHITE);
                aset = sc.addAttribute(aset, StyleConstants.FontFamily, "JetBrains Mono ExtraBold");
                aset = sc.addAttribute(aset, StyleConstants.FontSize, 16);

                list.get(i).setCharacterAttributes(aset, false);

            }
        }
    }

    public void crearGrafica(LinkedList<String> label, LinkedList<Double> values, String titulo) throws CloneNotSupportedException {
        //datasets.clear();
        DefaultPieDataset data = new DefaultPieDataset();
        for (int i = 0; i < label.size(); i++) {
            data.setValue(label.get(i), values.get(i));

        }
        JFreeChart chart = ChartFactory.createPieChart(titulo, (PieDataset) data.clone());
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(550, 100));
        datasets.add(chartPanel);
        data.clear();
    }

    public void graficaBarra(String titulo, LinkedList<String> ejex, LinkedList<Double> ejey, String titulox, String tituloy){
 
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        for (int i = 0; i < ejex.size(); i++) {
            datos.setValue(ejey.get(i), ejex.get(i), ejex.get(i));
        }
        
        JFreeChart barras = ChartFactory.createBarChart(titulo, titulox, tituloy, datos,PlotOrientation.VERTICAL, true,true,false);
        ChartPanel chartPanel = new ChartPanel(barras);
        chartPanel.setPreferredSize(new Dimension(550, 100));
        datasets.add(chartPanel);
    }
    
    public void mostrar() {
        
    }

    public static DefaultPieDataset crearDataset(String etiqueta, double valor) {
        DefaultPieDataset datas = new DefaultPieDataset();
        datas.setValue(etiqueta, valor);
        return datas;
    }

}

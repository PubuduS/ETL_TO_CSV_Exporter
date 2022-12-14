/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl_to_csv;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Pubudu
 */

public class ExportCSV extends javax.swing.JFrame {

    private String m_RootFolderPath = null;
    private final String m_ProfilePath = System.getProperty("user.dir")+"\\wprProfiles\\";
    private String m_ProfileDirectory = null;
    private String m_WPRProfile = null;
    
    private File[] m_ListOfFiles;
    
    private int m_CurrentRow = -1;
    private boolean m_RadioButtonSelectedFlag = false;
    
    public ExportCSV() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("logo.jpg");  
        this.setIconImage(icon);
    }
        
    private void RemoveTableRows( DefaultTableModel myTableModel )
    {  
        if( myTableModel.getRowCount() > 0 ) 
        {
            for( int i = myTableModel.getRowCount() - 1; i > -1; i-- ) {
                myTableModel.removeRow(i);
            }
        }
    }
    
    private void ShowExportedProfileNumber()
    {
        jLabelProcessedAmount.setText("Processed: " + (m_CurrentRow + 1) + " out of " + m_ListOfFiles.length);
    }
    
    private void PopulateTableWithETLFiles()
    {
        File folder = new File( m_RootFolderPath );
        
        FileFilter fileFilter = file -> !file.isDirectory() && file.getName().endsWith(".etl");
        
        m_ListOfFiles = folder.listFiles( fileFilter );
        
        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
        RemoveTableRows( dtm );

        for( int i = 0; i < m_ListOfFiles.length; i++ ) 
        {
          if( m_ListOfFiles[i].isFile() ) 
          {            
            dtm.addRow( new Object[]{ m_ListOfFiles[i].getName() } );
          } 
          else
          {
            JOptionPane.showMessageDialog( null, "Something Went Wrong!" );
          }
        }        
        
        if( m_ListOfFiles.length == 0 )
        {
            JOptionPane.showMessageDialog( null, "No ETL file detected" );
        }
    }  
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtETLPath = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        jRadioButtonCPU = new javax.swing.JRadioButton();
        jRadioButtonGPU = new javax.swing.JRadioButton();
        jRadioButtonMemory = new javax.swing.JRadioButton();
        jRadioButtonStorage = new javax.swing.JRadioButton();
        btnExtractCSV = new javax.swing.JButton();
        btnOpenFileLocation = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable()
        {
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
            {
                Component c = super.prepareRenderer(renderer, row, column);

                if (isRowSelected(row))
                c.setBackground(Color.GREEN);
                else
                c.setBackground(Color.WHITE);

                return c;
            }

        };
        jLabelProcessing = new javax.swing.JLabel();
        jLabelProcessedAmount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ETL to CSV Exporter (UNO Network Lab)");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel1.setText("Export ETL Traces as CSV");

        jLabel2.setText("Path to ETL files:");

        txtETLPath.setEditable(false);

        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonCPU);
        jRadioButtonCPU.setText("CPU");
        jRadioButtonCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCPUActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonGPU);
        jRadioButtonGPU.setText("GPU");
        jRadioButtonGPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonGPUActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonMemory);
        jRadioButtonMemory.setText("Memory");
        jRadioButtonMemory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMemoryActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonStorage);
        jRadioButtonStorage.setText("Storage");
        jRadioButtonStorage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonStorageActionPerformed(evt);
            }
        });

        btnExtractCSV.setText("Extract CSV");
        btnExtractCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtractCSVActionPerformed(evt);
            }
        });

        btnOpenFileLocation.setText("Open Location");
        btnOpenFileLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenFileLocationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtETLPath, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButtonCPU)
                        .addGap(28, 28, 28)
                        .addComponent(jRadioButtonGPU)
                        .addGap(27, 27, 27)
                        .addComponent(jRadioButtonMemory)
                        .addGap(27, 27, 27)
                        .addComponent(jRadioButtonStorage)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBrowse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExtractCSV, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addComponent(btnOpenFileLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtETLPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse)
                    .addComponent(btnOpenFileLocation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCPU)
                    .addComponent(jRadioButtonGPU)
                    .addComponent(jRadioButtonMemory)
                    .addComponent(jRadioButtonStorage)
                    .addComponent(btnExtractCSV))
                .addContainerGap())
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "File Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabelProcessing.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelProcessing.setText("Processing: Nothing.....");

        jLabelProcessedAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelProcessedAmount.setText("Processed: None");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelProcessing, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabelProcessedAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProcessing)
                    .addComponent(jLabelProcessedAmount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(895, 561));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
       final JFileChooser fileChooser = new JFileChooser();
       fileChooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );
       int returnVal = fileChooser.showOpenDialog(this);
       
       if( returnVal == JFileChooser.APPROVE_OPTION )
       {
           m_RootFolderPath = fileChooser.getSelectedFile().toString()+"\\";
           txtETLPath.setText( m_RootFolderPath );
       }
       else
       {
           txtETLPath.setText("Error Code " + returnVal);
       }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void jRadioButtonCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCPUActionPerformed
        m_ProfileDirectory = "CPU_Profile";
        m_WPRProfile = "CPUProfile.wpaProfile";        
        m_RadioButtonSelectedFlag = true;
    }//GEN-LAST:event_jRadioButtonCPUActionPerformed

    private void jRadioButtonGPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGPUActionPerformed
        m_ProfileDirectory = "GPU_Profile";
        m_WPRProfile = "GPUProfile.wpaProfile";        
        m_RadioButtonSelectedFlag = true;
    }//GEN-LAST:event_jRadioButtonGPUActionPerformed

    private void jRadioButtonMemoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMemoryActionPerformed
        m_ProfileDirectory = "Memory_Profile";
        m_WPRProfile = "MemoryProfile.wpaProfile";        
        m_RadioButtonSelectedFlag = true;
    }//GEN-LAST:event_jRadioButtonMemoryActionPerformed

    private void jRadioButtonStorageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonStorageActionPerformed
        m_ProfileDirectory = "Storage_Profile";
        m_WPRProfile = "StorageProfile.wpaProfile";        
        m_RadioButtonSelectedFlag = true;
    }//GEN-LAST:event_jRadioButtonStorageActionPerformed

    private void btnExtractCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtractCSVActionPerformed
        PopulateTableWithETLFiles();
        runBackgroundTask();
    }//GEN-LAST:event_btnExtractCSVActionPerformed

    private void btnOpenFileLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenFileLocationActionPerformed
        try 
        {            
            if( txtETLPath.getText().isEmpty())
            {
                JOptionPane.showMessageDialog( null, "Please enter a valid path to textfield.");
                return;
            }

            if( m_RadioButtonSelectedFlag == false )
            {
                JOptionPane.showMessageDialog( null, "Please check one of the radio buttons.");
                return;
            }
            
            Desktop.getDesktop().open( new File( m_RootFolderPath + m_ProfileDirectory ) );
        } 
        catch (IOException ex) 
        {
            JOptionPane.showMessageDialog( null, "Unable to Open File Location " + ex );
        }
    }//GEN-LAST:event_btnOpenFileLocationActionPerformed
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
            java.util.logging.Logger.getLogger(ExportCSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExportCSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExportCSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExportCSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExportCSV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnExtractCSV;
    private javax.swing.JButton btnOpenFileLocation;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelProcessedAmount;
    private javax.swing.JLabel jLabelProcessing;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonCPU;
    private javax.swing.JRadioButton jRadioButtonGPU;
    private javax.swing.JRadioButton jRadioButtonMemory;
    private javax.swing.JRadioButton jRadioButtonStorage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtETLPath;
    // End of variables declaration//GEN-END:variables
private void runBackgroundTask() 
{
    new SwingWorker<Void, Integer>() 
    {

      // Called on background thread
      protected Void doInBackground() throws Exception 
      {
        
        File profileDirectory = new File( m_RootFolderPath + m_ProfileDirectory );
        
        String outputFolder = m_RootFolderPath + m_ProfileDirectory + "\\";
        
        if( profileDirectory.exists() == false )
        {
            profileDirectory.mkdirs();
        }   
        
        for( int i = 0; i < m_ListOfFiles.length; i++ )
        {
            String fileName = m_ListOfFiles[i].getName();
            String command =  "wpaexporter " + fileName + " -profile " + m_WPRProfile + " -outputfolder " + outputFolder + " -prefix " + fileName;
            System.out.println(command);
            ProcessBuilder builder = new ProcessBuilder( "cmd.exe", "/c", command );        
            builder = builder.directory( new File( m_RootFolderPath ) );
            publish(i);
            try 
            {
                builder.redirectErrorStream(true);
                Process process = builder.start();
                jLabelProcessing.setForeground(Color.magenta);
                jLabelProcessing.setText("Processing: " + fileName );               
                
                process.waitFor(300, TimeUnit.SECONDS);
                process.destroyForcibly();
                process.waitFor();
                
            } 
            catch (IOException ex) 
            {            
                JOptionPane.showMessageDialog(null, "Failed to run cmd command "+ex);
            } 
            catch (InterruptedException ex) 
            {
                JOptionPane.showMessageDialog(null, "Command Line Thread "+ex);
            } 
        }
        return null;
      }
      
      protected void process(List<Integer> chunks)
      {
          for( int number : chunks )
          {
              m_CurrentRow = number;
              System.out.println(m_CurrentRow);
              ShowExportedProfileNumber();             
              jTable1.setRowSelectionInterval(0, number);              
          }
      }
      
      protected void done()
      {         
          Font font = new Font("Tahoma", Font.BOLD,11);
          jLabelProcessing.setFont(font);
          jLabelProcessing.setForeground(Color.GREEN);
          jLabelProcessing.setText("Processing: Done" );
      }
    }.execute();
}

}

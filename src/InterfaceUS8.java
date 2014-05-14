import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @authors Robin & Amélie
 */


public class InterfaceUS8 extends JFrame implements ActionListener {
    
   private  JPanel typeAnalyse;
   private  JPanel samplePanel;
   private  JPanel samplePanel1;
   private  JPanel samplePanel2;
   private  JPanel samplePanel3;
   
   private  JPanel iDPanel, datePanel, selectionPanel;
   private  JPanel selectionBouton;
   private  JPanel grosDuBas, grosDeDroite;
   private JPanel grosPanel;
   private JPanel buttonPanel;
   private JButton valider;
   private JButton annuler;
   private JFrame frame;
   private JComboBox testCombo;
   private Database d = new Database();
   private ArrayList<String> items = new ArrayList<>();
   private ArrayList<JCheckBox>  box = new ArrayList<JCheckBox>();
   private ArrayList<JCheckBox>  box2 = new ArrayList<JCheckBox>();
   private ArrayList<JCheckBox>  box3 = new ArrayList<JCheckBox>();
   private ArrayList<String> id = new ArrayList <String>();
   private ArrayList<String> id1 = new ArrayList <String>();
   private ArrayList<String> id2 = new ArrayList <String>();
   private ArrayList<String> id3 = new ArrayList <String>();
   private ArrayList<String> date = new ArrayList <String>();
   private ArrayList<String> date1 = new ArrayList <String>();
   private ArrayList<String> date2 = new ArrayList <String>();
   private ArrayList<String> date3 = new ArrayList <String>();
   private String s1 = "";
   private String s2 = "";
   private String s3 = "";
   private int idBatch;
   private String nameTest;
   
public InterfaceUS8(){
    
    /* Panel button */
    valider  = new JButton("Valider");
    annuler   = new JButton("Annuler");
    
    buttonPanel = new JPanel();
    buttonPanel.add(valider);
    buttonPanel.add(annuler);
    valider.addActionListener(this);
    annuler.addActionListener(this);
    
    /* Type d'analyses*/
    
    testCombo = new JComboBox ();
    items = d.getTestType();
        for (int i=0;i< items.size();i++)
        {                
                testCombo.addItem(items.get(i));      
        }           
    testCombo.addActionListener(this);
    typeAnalyse = new JPanel();
    typeAnalyse.add(testCombo); 
    typeAnalyse.setBorder(BorderFactory.createTitledBorder(
           BorderFactory.createEtchedBorder(), "Type de test :"));
           
    /*************************************************************************************/
    iDPanel = new JPanel();
    datePanel = new JPanel();
    selectionPanel = new JPanel();
    
    grosDeDroite = new JPanel();
    grosDeDroite.setLayout(new GridLayout(2,2));
    grosDeDroite.add(buttonPanel, BorderLayout.SOUTH);
    
    /*Gros Panel du bas*/
    grosDuBas = new JPanel();
    grosDuBas.setLayout(new GridLayout(1,2));
    //grosDuBas.add(samplePanel, BorderLayout.WEST);
    
    
    grosPanel = new JPanel();
    grosPanel.setLayout(new GridLayout(2,1));
    grosPanel.add(typeAnalyse, BorderLayout.PAGE_START);
    grosPanel.add(grosDuBas, BorderLayout.PAGE_END);
    
    frame = new JFrame("US8");
    frame.add(grosPanel);    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    //JFrame.setDefaultLookAndFeelDecorated(true);
        
    frame.pack();
    frame.setVisible(true);    
}   

   @Override
   public void actionPerformed(ActionEvent e){
	   
	   if(e.getSource() == testCombo){		   
		   nameTest = (String)testCombo.getSelectedItem();  
		   
		   if(samplePanel != null){
			   grosDuBas.removeAll();
			   samplePanel1.removeAll();
			   samplePanel2.removeAll();
			   samplePanel3.removeAll();
		   }
		   
		   /*Les differents Panels de echantillons*/
		   
		   id1 = new ArrayList<String>();
		   id2 = new ArrayList<String>();
		   id3 = new ArrayList<String>();
		   
		   
		   date1 = new ArrayList<String>();
		   date2 = new ArrayList<String>();
		   date3 = new ArrayList<String>();
		   
		   
		   box = new ArrayList<JCheckBox>();
		   box2 = new ArrayList<JCheckBox>();
		   box3 = new ArrayList<JCheckBox>();
		   
		   
			samplePanel1 = new JPanel();  			
			ArrayList<ArrayList<String>> sampleR =d.getSampleAnalysis(1, nameTest);
			for (ArrayList<String> A : sampleR) {
			    id1.add(A.get(0));
			    date1.add(A.get(1));
			} 
			
			if(id1.size() == 0){
				samplePanel1.add(new JLabel("Aucun échantillon"));
			}
			else {
			    for (int i=0 ; i<id1.size();i++ ){
			        s1 = id1.get(i) + "   " + date1.get(i);
			        box.add(new JCheckBox(s1));
			        box.get(i).addActionListener(this);
			    }
			}
			
			for (JCheckBox c : box){
			        samplePanel1.add(c);
			}
			
			samplePanel1.setLayout(new GridLayout(box.size(),1));
			samplePanel1.setBorder(BorderFactory.createTitledBorder(
			       BorderFactory.createEtchedBorder(), "Echantillon(s) a reanalyser :"));
			/*************************************************************************************/
			samplePanel2 = new JPanel();			
			ArrayList<ArrayList<String>> sampleCEC =d.getSampleAnalysis(2, nameTest);
			for (ArrayList<String> A : sampleCEC) {
			    id2.add(A.get(0));
			    date2.add(A.get(1));
			}
			
			if(id2.size() == 0){
				samplePanel2.add(new JLabel("Aucun échantillon"));
			}
			else {
			    for (int i=0 ; i<id2.size();i++ ){
			        s2 = id2.get(i) + "   " + date2.get(i);
			        box2.add(new JCheckBox(s2));
			        box2.get(i).addActionListener(this);
			    }
			}
			
			for (JCheckBox c : box2){
			        samplePanel2.add(c);
			}
			samplePanel2.setLayout(new GridLayout(box2.size(),1));
			samplePanel2.setBorder(BorderFactory.createTitledBorder(
			       BorderFactory.createEtchedBorder(), "Echantillon(s) de commande en cours :"));
			/***************************************************************************************/
			
			samplePanel3 = new JPanel();  			
			ArrayList<ArrayList<String>> sampleAA =d.getSampleAnalysis(3, nameTest);
			for (ArrayList<String> A : sampleAA) {
			    id3.add(A.get(0));
			    date3.add(A.get(1));
			    
			}
			
			if(id3.size() == 0){
				samplePanel3.add(new JLabel("Aucun échantillon"));
			}
			else {
			    for (int i=0 ; i<id3.size();i++ ){
			        s3 = id3.get(i) + "   " + date3.get(i);
			        box3.add(new JCheckBox(s3));
			        box3.get(i).addActionListener(this);
			    }
			}
			
			for (JCheckBox c : box3){
			        samplePanel3.add(c);
			} 
			samplePanel3.setLayout(new GridLayout(box3.size(),1));
			samplePanel3.setBorder(BorderFactory.createTitledBorder(
			       BorderFactory.createEtchedBorder(), "Echantillon(s) a analyser :"));
			/******************************************************************************************/
			samplePanel = new JPanel();
			samplePanel.setLayout(new GridLayout(3, 1));
			samplePanel.add(samplePanel1);
			samplePanel.add(samplePanel2);
			samplePanel.add(samplePanel3);
			
			grosDuBas.add(samplePanel, BorderLayout.WEST);
			grosDuBas.add(grosDeDroite, BorderLayout.EAST);	   		  
			grosDuBas.revalidate();
	   }   
	   	id = new ArrayList<String>();
   		date = new ArrayList<String>();
        for (int i=0 ; i<box.size();i++ ){
            if (box.get(i).isSelected()){
                id.add(id1.get(i));
                date.add(date1.get(i));
            }
            else {	
            	if(id.contains(id1.get(i))){
            	
            		id.remove(id1.get(i));
            		date.remove(id1.get(i));
            	}
            }
        }
        
        for (int i=0 ; i<box3.size();i++ ){
            if (box3.get(i).isSelected()){
                id.add(id3.get(i));
                date.add(date3.get(i));
            }
            else {
            	if(id.contains(id3.get(i))){
            		id.remove(id3.get(i));
            		date.remove(id3.get(i));
            	}
            }
        }               
        
        for (int i=0 ; i<box2.size();i++ ){
            if (box2.get(i).isSelected()){
                id.add(id2.get(i));
                date.add(date2.get(i));
            }
            else {
            	if(id.contains(id2.get(i))){
            		id.remove(id2.get(i));
            		date.remove(id2.get(i));
            	}
            }
        }
        
        
        
        if(id != null && date != null){
        	/**********Selection Panel ********************************************************************************/
        	iDPanel.removeAll();
            iDPanel.setLayout(new GridLayout(id.size(),1));    
            for (String x : id ){  
                    iDPanel.add(new JLabel(x));
            }
            iDPanel.setBorder(BorderFactory.createTitledBorder(
                   BorderFactory.createEtchedBorder(), "Echantillons :"));
            
            
            /*********************************************************************************/ 
            datePanel.removeAll();
            datePanel.setLayout(new GridLayout(date.size(),1));
            for (String s : date ){  
                    datePanel.add(new JLabel(s));
            }
            datePanel.setBorder(BorderFactory.createTitledBorder(
                   BorderFactory.createEtchedBorder(), "date analyse :"));
            /*********************************************************************************/ 
            selectionPanel.setLayout(new GridLayout(1, 2));
            selectionPanel.add(iDPanel, BorderLayout.WEST);
            selectionPanel.add(datePanel, BorderLayout.EAST);
            selectionPanel.setBorder(BorderFactory.createTitledBorder(
                   BorderFactory.createEtchedBorder(), "Selection en cours :"));
            
            grosDeDroite.add(selectionPanel, BorderLayout.NORTH);
            grosDuBas.revalidate();
        }
        
        if ( e.getSource() == valider ) {
        	d.createBatch(8);
        	idBatch = d.getIdBatch();
        	for(int i=0; i<id.size(); i++)
        		d.addSampleToBatch(Integer.parseInt(id.get(i)), idBatch);
        }
        
        if ( e.getSource() == annuler ) {
        	frame.dispose();
        }
        
        d.close();
    
}

 public static void main(String[] args) {    
                InterfaceUS8 us = new InterfaceUS8();

    }
}

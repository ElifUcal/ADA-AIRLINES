package Anaİşlemler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Bilet.YurtiçiBilet;
import GirisEkranı.GirisEkranı;
import com.toedter.calendar.JDateChooser;

public class YurtiçiBiletler extends JFrame {
	
	
	
		private JDateChooser elifdate;
		private String[] havalimanları ;
		private String[] bilettipleri ;
		private String[] kisitipleri ;
		private String[] alfabe ;
		private String[] sayılar ;
		private String[] saatler ;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private YurtiçiBilet y;
		private File dosya;
		private File dosya1;
		private File dosya2;
		private File dosya3;
		private File dosya4;
		private File dosya5;
		private File dosya6;
		private JCheckBox ok;
	
	public YurtiçiBiletler(String id) {

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		dosya1 = new File("kisitipleri.txt");
		elifdate = new JDateChooser();
		try(BufferedReader reader = new BufferedReader(new FileReader(dosya1))) {

			String line;

			while((line = reader.readLine()) != null) {

				kisitipleri = line.split(",");

			}
			reader.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Dosya okuma hatası oluştu.");
		}


		dosya2 = new File("yurticihavalimanı.txt");

		try(BufferedReader reader = new BufferedReader(new FileReader(dosya2))) {

			String line2;

			while((line2 = reader.readLine()) != null) {

				havalimanları = line2.split(",");

			}
			reader.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Dosya okuma hatası oluştu.");
		}

		dosya3 = new File("koltuktip.txt");

		try(BufferedReader reader = new BufferedReader(new FileReader(dosya3))) {

			String line2;

			while((line2 = reader.readLine()) != null) {

				bilettipleri = line2.split(",");

			}
			reader.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Dosya okuma hatası oluştu.");
		}

		dosya4 = new File("sayılar.txt");

		try(BufferedReader reader = new BufferedReader(new FileReader(dosya4))) {

			String line;

			while((line = reader.readLine()) != null) {

				sayılar = line.split(",");

			}
			reader.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Dosya okuma hatası oluştu.");
		}


		dosya5 = new File("alfabe.txt");

		try(BufferedReader reader = new BufferedReader(new FileReader(dosya5))) {

			String line2;

			while((line2 = reader.readLine()) != null) {

				alfabe = line2.split(",");

			}
			reader.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Dosya okuma hatası oluştu.");
		}

		dosya6 = new File("saatler.txt");

		try(BufferedReader reader = new BufferedReader(new FileReader(dosya6))) {

			String line2;

			while((line2 = reader.readLine()) != null) {

				saatler = line2.split(",");

			}
			reader.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Dosya okuma hatası oluştu.");
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		ok = new JCheckBox("Sigortalı bilet");
		dosya = new File("biletkontrol.txt");
		y = new YurtiçiBilet();
		this.getContentPane().setBackground(new Color(255, 250, 250));
		this.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		this.setBounds(100, 100, 1920,1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("ADA AİRLİNES / Yurtiçi Biletler");
		ImageIcon logo = new ImageIcon("LOGO.png");
		this.setIconImage(logo.getImage());
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);

		ok.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		ok.setBounds(670, 635, 200, 25);
		this.getContentPane().add(ok);





		JLabel lblNewLabel = new JLabel("ADA AİRLİNES");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\birgu\\OneDrive\\Masaüstü\\Ada Airlines\\logo5.png"));
		lblNewLabel.setBounds(0, 0, 296, 58);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Yurt İçi Bilet AL");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		lblNewLabel_1.setBounds(609, 93, 489, 58);
		this.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Kalkış Yeri:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_2.setBounds(528, 174, 102, 37);
		this.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(784, 180, 296, 30);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox(havalimanları);
		comboBox.setForeground(new Color(0, 139, 139));
		comboBox.setBounds(784, 210, 296, 21);
		this.getContentPane().add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(784, 261, 296, 30);
		this.getContentPane().add(textField_1);
		
		JComboBox comboBox_1 = new JComboBox(havalimanları);
		comboBox_1.setForeground(new Color(0, 139, 139));
		comboBox_1.setBounds(784, 291, 296, 21);
		this.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Varış Yeri:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_2_1.setBounds(528, 255, 102, 37);
		this.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Bilet Tipi:");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_2_1_1.setBounds(528, 336, 102, 37);
		this.getContentPane().add(lblNewLabel_2_1_1);
		
		JComboBox comboBox_1_1 = new JComboBox(kisitipleri);
		comboBox_1_1.setForeground(new Color(0, 139, 139));
		comboBox_1_1.setBounds(784, 346, 296, 21);
		this.getContentPane().add(comboBox_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Koltuk Tipi:");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_2_2.setBounds(528, 405, 102, 37);
		this.getContentPane().add(lblNewLabel_2_2);
		
		JComboBox comboBox_1_1_1 = new JComboBox(bilettipleri);
		comboBox_1_1_1.setForeground(new Color(0, 139, 139));
		comboBox_1_1_1.setBounds(784, 415, 296, 21);
		this.getContentPane().add(comboBox_1_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Koltuk:");
		lblNewLabel_2_2_1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_2_2_1.setBounds(528, 470, 102, 37);
		this.getContentPane().add(lblNewLabel_2_2_1);
		
		JComboBox comboBox_1_1_1_1 = new JComboBox(alfabe);
		comboBox_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBox_1_1_1_1.setForeground(new Color(0, 139, 139));
		comboBox_1_1_1_1.setBounds(931, 480, 149, 21);
		this.getContentPane().add(comboBox_1_1_1_1);
		
		JButton buton2 = new JButton("Geri Dön");
		buton2.setBounds(574, 678, 200, 100);
		this.getContentPane().add(buton2);
		
		JButton buton1 = new JButton("İlerle");
		buton1.setBounds(784, 678, 200, 100);
		this.getContentPane().add(buton1);
		
		buton1.setFont(new Font("TimesRoman",Font.BOLD,20));
		buton1.setFocusPainted(false);
		buton1.setBackground(new Color( 0 ,139 ,139));
		buton1.setBorderPainted(false);
		buton1.setHorizontalAlignment(JLabel.CENTER);
		buton1.setVerticalTextPosition(JLabel.BOTTOM);
		
		buton2.setFont(new Font("TimesRoman",Font.BOLD,20));
		buton2.setFocusPainted(false);
		buton2.setBackground(new Color( 0 ,139 ,139));
		buton2.setBorderPainted(false);
		buton2.setHorizontalAlignment(JLabel.CENTER);
		buton2.setVerticalTextPosition(JLabel.BOTTOM);
		
		JComboBox comboBox_1_1_1_1_1 = new JComboBox(sayılar);
		comboBox_1_1_1_1_1.setForeground(new Color(0, 139, 139));
		comboBox_1_1_1_1_1.setBounds(784, 480, 149, 21);
		this.getContentPane().add(comboBox_1_1_1_1_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Tarih:");
		lblNewLabel_2_2_1_1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_2_2_1_1.setBounds(528, 533, 102, 37);
		this.getContentPane().add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_2_1_2 = new JLabel("Saat:");
		lblNewLabel_2_2_1_2.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_2_2_1_2.setBounds(528, 600, 102, 37);
		this.getContentPane().add(lblNewLabel_2_2_1_2);
		
		JComboBox comboBox_1_1_1_2 = new JComboBox(saatler);
		comboBox_1_1_1_2.setForeground(new Color(0, 139, 139));
		comboBox_1_1_1_2.setBounds(784, 610, 296, 21);
		this.getContentPane().add(comboBox_1_1_1_2);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		elifdate.setBounds(784, 544, 296, 30);
		this.getContentPane().add(elifdate);
		
		buton1.addMouseListener(new MouseAdapter() {
        	
			public void mouseEntered(MouseEvent e) {
				buton1.setBackground(new Color(32 ,178 ,170));
			}

			public void mouseExited(MouseEvent e) {
				buton1.setBackground(new Color( 0 ,139 ,139));
			}
			
		});
		
		buton2.addMouseListener(new MouseAdapter() {
        	
			public void mouseEntered(MouseEvent e) {
				buton2.setBackground(new Color(32 ,178 ,170));
			}

			public void mouseExited(MouseEvent e) {
				buton2.setBackground(new Color( 0 ,139 ,139));
			}
			
		});
		buton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==buton2) {
					setVisible(false);
					Anaİşlemler a1 = new Anaİşlemler(id);	
				}
			}});
		
		    
	    
	
		
		DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                formatText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                formatText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                formatText();
            }

            private void formatText() {
                SwingUtilities.invokeLater(() -> { // / bu işaretin sayılarla iç içe geçmesini engelliyor.
                    String text = textField_2.getText();
                    if (text.length() == 2 || text.length() == 5) {
                        text += "/";
                        textField_2.setText(text);
                    }
                });
            }
        };

        textField_2.getDocument().addDocumentListener(documentListener);
        
        textField_2.addKeyListener((KeyListener) new KeyAdapter() {
			
			
			
			public void keyTyped(KeyEvent e) {
				 char c = e.getKeyChar();
				if(textField_2.getText().length() >= 10) {
				e.consume();
				}
				 if(!Character.isDigit(c)) {
	                    e.consume();
	                }

			}
			
			
			
		});
        comboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


            	textField.setText((String) comboBox.getSelectedItem());



             }


        });
		textField.setEditable(false);
        
        comboBox_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


            	 textField_1.setText((String) comboBox_1.getSelectedItem());



             }


        });
        textField_1.setEditable(false);
        //txt işlemleriii........................................
        buton1.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                if(e.getSource()==buton1) {
                	boolean bulundumu = false;
					boolean aynı = false;
					boolean tarihoncemi = false;

					Date bugun = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					String strbugun = formatter.format(bugun);
					String strelif = formatter.format(elifdate.getDate());

					if(bugun.after(elifdate.getDate())){
						tarihoncemi = true;
					}
					if(strbugun.equals(strelif)){
						tarihoncemi = false;
					}


                	   if (textField.getText().isEmpty()  || textField_1.getText().isEmpty() ||   elifdate.isValid()) {

                           JOptionPane.showMessageDialog(null, "Boşlukların Hepsini Doldurmalısınız !");

                   	
                           
                       	}
					if (textField.getText().equals( textField_1.getText())){
						JOptionPane.showMessageDialog(null, "Aynı Yerden Aynı Yere Uçamassınnız !");
						aynı= true;
					}
                	   
                	   else {

					 y.setId(id);
                   y.setKalkış(textField.getText());
                   y.setVarış(textField_1.getText());
                   y.setBilettipi((String)comboBox_1_1.getSelectedItem());
                   y.setKoltuktipi((String)comboBox_1_1_1.getSelectedItem());
                   y.setKoltukno((String)comboBox_1_1_1_1.getSelectedItem()+(String)comboBox_1_1_1_1_1.getSelectedItem());

				   Date date = elifdate.getDate();
				   String strDate = DateFormat.getDateInstance().format(date);

                   y.setTarih(strDate);
                   y.setSaat((String)comboBox_1_1_1_2.getSelectedItem());
				   y.setSigorta(ok.isSelected());
                   
                   
                   try (BufferedReader reader = new BufferedReader(new FileReader(dosya))) {
                       String line;
                       String[] strArray;
                       
                       

                       while ((line = reader.readLine()) != null) {
                           strArray = line.split(",");
                           
                           if(strArray[5].equals(y.getKoltukno())&&strArray[1].equals(y.getKalkış())&&strArray[2].equals(y.getVarış())&&strArray[3].equals(y.getBilettipi())&&strArray[4].equals(y.getKoltuktipi())&&strArray[6].equals(y.getTarih())&&strArray[7].equals(y.getSaat())) {
                        	   
                        	   bulundumu = true;
                           	 
                           }

                          
                       }
                      
                      
                   } catch (Exception ex) {
                       ex.printStackTrace();
                       JOptionPane.showMessageDialog(null, "Dosya okuma hatası oluştu.");
                   }
                
                   if((bulundumu==false) && (aynı ==false) && (tarihoncemi == false)) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosya,true))){

                        writer.write(y.getId()+",");
                        writer.write(y.getKalkış() + ",");
                        writer.write(y.getVarış() + ",");
                        writer.write(y.getBilettipi() + ",");
                        writer.write(y.getKoltuktipi() + ",");
                        writer.write(y.getKoltukno() + ",");
                        writer.write(y.getTarih() + ",");
                        writer.write(y.getSaat() + ",");
						writer.write(y.getSigorta() + ",");
                        writer.write("\n");




                        y.setFiyat(1000);
						if (y.getSigorta() == true){
							y.setFiyat(y.getFiyat()+500);
						}

                        setVisible(false);
                        if(y.getKoltuktipi().equals("Ekonomi Sınıfı (Economy Class)")) {
                        	Ödeme o1 = new Ödeme(id, y.getFiyat());

                        }
                        else if(y.getKoltuktipi().equals("Premium Ekonomi Sınıfı (Premium Economy Class)")) {
							Ödeme o1 = new Ödeme(id, y.getFiyat()+500);
                        }
                        else if(y.getKoltuktipi().equals("Business Sınıfı (Business Class)")) {
                        	Ödeme o1 = new Ödeme(id, y.getFiyat()+1000);

                        }
                        else if(y.getKoltuktipi().equals("First Sınıfı (First Class)")) {
                        	Ödeme o1 = new Ödeme(id, y.getFiyat()+1500);

                        }
                        else if(y.getKoltuktipi().equals("Suit (Özel Süit)")) {
                        	Ödeme o1 = new Ödeme(id,y.getFiyat()+2000 );

                        }





                   } catch (Exception e2) {
                       JOptionPane.showMessageDialog(null, "Bilet Seçimi Gerçekleştirilemedi");
                   }




                    }
                   else if(tarihoncemi == true){
                	   JOptionPane.showMessageDialog(null, "Geçmişten bilet alınamaz!");
                   }
				   else {
					   JOptionPane.showMessageDialog(null, "Bu Koltuk Dolu");

				   }

                }
              
                } } });
	
		
		this.setVisible(true);
	}
	
}

package GirisEkranı;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
import java.util.Date;
import java.util.logging.Handler;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import Anaİşlemler.Anaİşlemler;
import Müşteri.Müşteri;
import com.toedter.calendar.JDateChooser;

public class ÜyeOl extends JFrame  {
	
	private Müşteri müşteri=new Müşteri();
	private boolean tcsorgu;
	private  int  id = 1;
	private File dosya1;
	private JPanel logoPanel;
	private JPanel topJPanel;
	private JPanel bottomJPanel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	private JPanel panel7;
	private JPanel panel8;
	private JPanel panel9;
	private JPanel panel10;
	private JButton üyeolbutonbuton;
	private JButton geridönButton;
	private JLabel isimlLabel;
	private JLabel soyisimlLabel;
	private JLabel tclLabel;
	private JLabel telefonNolLabel;
	private JLabel emaillLabel;
	private JLabel şifrelLabel;
	private JLabel kontrolşifrelLabel;
	private JLabel cinsiyetLabel;
	private JLabel dogumtarihiLabel;
	private JLabel logoLabel;
	private JTextField tisim;
	private JTextField tsoyisim;
	private JTextField tTelefonNo;
	private JTextField temail;
	private JTextField tTc;

	private JPasswordField tşifre;
	private JPasswordField tKontrolŞifre;
	private JLabel uyrukLabel;
	private JTextField tuyruk;
	private String[] Cinsiyet = {"Kadın","Erkek","Diğer"};
	private JComboBox cinsiyetBox;
	private JDateChooser dateelif = new JDateChooser();
	
	
	public ÜyeOl() {
		//Frame özellikleri
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1920,1080);
		this.setLayout(new GridLayout(3,1));
		
		this.setTitle("Üye ol...");
		ImageIcon logo = new ImageIcon("LOGO.png");
		this.setIconImage(logo.getImage());
		
		//////////////////////////////////////////////////////
		
		//Nesne Oluşturma
		topJPanel = new JPanel();
		bottomJPanel = new JPanel();
		logoPanel = new JPanel();
		üyeolbutonbuton = new JButton("Üye Ol");
		tisim = new JTextField();
		tsoyisim = new JTextField();
		tTelefonNo = new JTextField();
		temail = new JTextField();
		tTc = new JTextField();
		tşifre = new JPasswordField();
		tKontrolŞifre = new JPasswordField();
		cinsiyetBox = new JComboBox(Cinsiyet); //(combox.getselecteditem();
		isimlLabel = new JLabel("Adınız:");
		soyisimlLabel = new JLabel("Soyadınız:");
		telefonNolLabel = new JLabel("Telefon No:");
		emaillLabel = new JLabel("Email:");
		şifrelLabel = new JLabel("Şifre:");
		kontrolşifrelLabel = new JLabel("Tekrar Şifre:");
		tclLabel = new JLabel("Tc:");
		cinsiyetLabel = new JLabel("Cinsiyet:");
		dogumtarihiLabel = new JLabel("Doğum Tarihi:");

		logoLabel = new JLabel();
		tuyruk = new JTextField();
		uyrukLabel = new JLabel("Uyruk:");
		dosya1 = new File("Üye Bilgileri.txt");
		geridönButton = new JButton("Geri Dön");
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();
		panel8 = new JPanel();
		panel9 = new JPanel();
		panel10 = new JPanel();
		
		////////////////////////////////////////////////////////
		
		//Panel işlemleri
		logoPanel.add(logoLabel);
		logoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		panel4.setLayout(new FlowLayout());
		panel5.setLayout(new FlowLayout());
		panel6.setLayout(new FlowLayout());
		panel7.setLayout(new FlowLayout());
		panel8.setLayout(new FlowLayout());
		panel9.setLayout(new FlowLayout());
		panel1.add(isimlLabel);
		panel1.add(tisim);
		panel2.add(soyisimlLabel);
		panel2.add(tsoyisim);
		panel3.add(tclLabel);
		panel3.add(tTc);
		panel4.add(telefonNolLabel);
		panel4.add(tTelefonNo);
		panel5.add(emaillLabel);
		panel5.add(temail);
		panel6.add(cinsiyetLabel);
		panel6.add(cinsiyetBox);
		panel10.add(uyrukLabel);
		panel10.add(tuyruk);
		panel7.add(dogumtarihiLabel);
		panel7.add(dateelif);
		bottomJPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		topJPanel.setLayout(new GridLayout(5,2));
		bottomJPanel.add(üyeolbutonbuton);
		bottomJPanel.add(geridönButton);
		
		panel8.add(şifrelLabel);
		panel8.add(tşifre);
		panel9.add(kontrolşifrelLabel);
		panel9.add(tKontrolŞifre);
		
		
		//Frame     
		this.add(logoPanel);
		this.add(topJPanel);
		this.add(bottomJPanel);
		
		
		
		//Label özellikleri 
		logoLabel.setText("ADA AİRLİNES");
		logoLabel.setFont(new Font("TimesRoman", Font.ITALIC, 30));
		isimlLabel.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		soyisimlLabel.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		telefonNolLabel.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		tclLabel.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		şifrelLabel.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		kontrolşifrelLabel.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		emaillLabel.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		cinsiyetLabel.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		dogumtarihiLabel.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		uyrukLabel.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		ImageIcon logo3 = new ImageIcon("logo5.png");
		logoLabel.setIcon(logo3);
		tşifre.setEchoChar('*');
		tKontrolŞifre.setEchoChar('*');
		
		
		
		
		tisim.setPreferredSize(new Dimension(200,30));
		tsoyisim.setPreferredSize(new Dimension(200,30));
		tTc.setPreferredSize(new Dimension(200,30));
		tTelefonNo.setPreferredSize(new Dimension(200,30));
		dateelif.setPreferredSize(new Dimension(200,30));
		tKontrolŞifre.setPreferredSize(new Dimension(200,30));
		tşifre.setPreferredSize(new Dimension(200,30));
		temail.setPreferredSize(new Dimension(200,30));
		tuyruk.setPreferredSize(new Dimension(200,30));
		cinsiyetBox.setPreferredSize(new Dimension(200,30));
		cinsiyetBox.setForeground(new Color( 0 ,139 ,139));
		
		
		// isme fln sayı giremiycek tc ye fln da harf giremiycek.
		

		
		tTc.addKeyListener((KeyListener) new KeyAdapter() {
		
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
            if (tTc.getText().length() >= 11) {
                e.consume();
        }
            if(!Character.isDigit(c)) {
                e.consume();
            }



        }
}
    );
		
		tTelefonNo.addKeyListener((KeyListener) new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
	            if (tTelefonNo.getText().length() >= 11) {
	                e.consume();
	        }
	            if(!Character.isDigit(c)) {
                    e.consume();
                }



	        }
	}
	    );
		
		tsoyisim.addKeyListener((KeyListener) new KeyAdapter() {

            public void keyTyped(KeyEvent e) {

                char text = e.getKeyChar();



                if(!Character.isAlphabetic(text)) {
                    e.consume();
                }


            }
    }
        );
		tisim.addKeyListener((KeyListener) new KeyAdapter() {

            public void keyTyped(KeyEvent e) {

                char text = e.getKeyChar();



                if(!Character.isAlphabetic(text)) {
                    e.consume();
                }


            }
    }
        );
		tuyruk.addKeyListener((KeyListener) new KeyAdapter() {

            public void keyTyped(KeyEvent e) {

                char text = e.getKeyChar();



                if(!Character.isAlphabetic(text)) {
                    e.consume();
                }


            }
    }
        );
			


		
		// Buton özellikleri
		
		
		üyeolbutonbuton.setPreferredSize(new Dimension(200, 100));
		üyeolbutonbuton.setFont(new Font("TimesRoman",Font.BOLD,20));
		üyeolbutonbuton.setFocusPainted(false);
		üyeolbutonbuton.setBackground(new Color( 0 ,139 ,139));
		logoLabel.setIcon(logo3);
		üyeolbutonbuton.setBorderPainted(false);
		üyeolbutonbuton.setHorizontalAlignment(JLabel.CENTER);
		üyeolbutonbuton.setVerticalTextPosition(JLabel.BOTTOM);
		üyeolbutonbuton.addMouseListener(new MouseAdapter() {
	        	
				public void mouseEntered(MouseEvent e) {
					üyeolbutonbuton.setBackground(new Color( 32 ,178 ,170));
					
				}

				public void mouseExited(MouseEvent e) {
					üyeolbutonbuton.setBackground(new Color( 0 ,139 ,139));
				}
				
			});
		geridönButton.setPreferredSize(new Dimension(200, 100));
		geridönButton.setFont(new Font("TimesRoman",Font.BOLD,20));
		geridönButton.setFocusPainted(false);
		geridönButton.setBackground(new Color( 0 ,139 ,139));
		geridönButton.setBorderPainted(false);
		geridönButton.setHorizontalAlignment(JLabel.CENTER);
		geridönButton.setVerticalTextPosition(JLabel.BOTTOM);
		geridönButton.addMouseListener(new MouseAdapter() {
	        	
				public void mouseEntered(MouseEvent e) {
					geridönButton.setBackground(new Color( 32 ,178 ,170));
				}

				public void mouseExited(MouseEvent e) {
					geridönButton.setBackground(new Color( 0 ,139 ,139));
				}
				
			});
		geridönButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==geridönButton) {
					setVisible(false);
					GirisEkranı g1 = new GirisEkranı();
				}
			}});
		
		
		
		//Panel özellikleri
		logoPanel.setBackground(new Color(255, 250 ,250));
		bottomJPanel.setBackground(new Color(255, 250 ,250));
		panel1.setBackground(new Color(255, 250 ,250));
		panel2.setBackground(new Color(255, 250 ,250));
		panel3.setBackground(new Color(255, 250 ,250));
		panel4.setBackground(new Color(255, 250 ,250));
		panel5.setBackground(new Color(255, 250 ,250));
		panel6.setBackground(new Color(255, 250 ,250));
		panel7.setBackground(new Color(255, 250 ,250));
		panel8.setBackground(new Color(255, 250 ,250));
		panel9.setBackground(new Color(255, 250 ,250));
		panel10.setBackground(new Color(255, 250 ,250));
		topJPanel.add(panel1);
		topJPanel.add(panel2);
		topJPanel.add(panel3);
		topJPanel.add(panel4);
		topJPanel.add(panel5);
		topJPanel.add(panel6);
		topJPanel.add(panel7);
		topJPanel.add(panel8);
		topJPanel.add(panel10);
		topJPanel.add(panel9);
		
		
		//id mevzusu-
		üyeolbutonbuton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
                if(e.getSource()==üyeolbutonbuton) {
                
                	
                	
                	
                         try(BufferedReader reader = new BufferedReader(new FileReader(dosya1))) {


                        	String line;
                        	String[] strArray;
                        
                        	//id işlemleri
                        	while((line = reader.readLine()) != null) {

                                strArray = line.split(",");

                                if(strArray[0].isEmpty()) {
                                    müşteri.setId(1);

                                }
                                
                                else {
                                    int yeniid = Integer.valueOf(strArray[0]) + 1;
                                    müşteri.setId(yeniid);
                                }
                                if(strArray[3].equals(tTc.getText())) {

                                    tcsorgu = true;
                                    break;
                                }
                                else {
                                    tcsorgu = false;
                                    continue;
                                }


                            }
                        	if(müşteri.getId() == 0) {
                                müşteri.setId(1);
                            }

                         	}
                         	
                         	
                         	 
                        catch(Exception e2) {

                     	   JOptionPane.showMessageDialog(null, "Dosyada bir hata var.");

                         }
                         
                        



                     }
                	
                	
                	//dosya işlemleri
                	if (tisim.getText().isEmpty() || tsoyisim.getText().isEmpty() || tTelefonNo.getText().isEmpty() || tTc.getText().isEmpty()) {
                		
                		JOptionPane.showMessageDialog(null, "Boşlukların Hepsini Doldurmalısınız !");
                		
                		
                		
                	}
                	
                	else if(tcsorgu) {
                        JOptionPane.showMessageDialog(null, "Bu T.C İle Hesap Zaten Oluşturulmuş!");

                    }
                	else {
                		
                	
                    if(new String(tşifre.getPassword()).equals(new String(tKontrolŞifre.getPassword()))) {
 

                    	
                    	
                    	müşteri.setAd(tisim.getText());
                    	müşteri.setSoyad(tsoyisim.getText());
                    	müşteri.setTc(tTc.getText());
                    	müşteri.setTelefonno(tTelefonNo.getText());
                    	müşteri.setEmail(temail.getText());
                    	müşteri.setCinsiyet(cinsiyetBox.getSelectedItem());
						Date date = dateelif.getDate();
						String strDate = DateFormat.getDateInstance().format(date);
						müşteri.setDogumgünü(strDate);
                    	müşteri.setSifre(new String(tşifre.getPassword()));	
                    	
                     try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosya1,true))){
                    	
                    	 writer.write(müşteri.getId() + ",");
                         writer.write(müşteri.getAd() + ",");
                         writer.write(müşteri.getSoyad() + ",");
                         writer.write(müşteri.getTc() + ",");
                         writer.write(müşteri.getTelefonno() + ",");
                         writer.write(müşteri.getEmail()+",");
                         writer.write(müşteri.getCinsiyet() + ",");
                         writer.write(müşteri.getDogumgünü() + ",");
                         writer.write(müşteri.getSifre() + ",");
                         writer.write("\n");
                         

                         
                         
                         
                         setVisible(false);
                         GirisEkranı girisekrani = new GirisEkranı();
                         
                         
                         
                         
                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(null, "Üyelik Oluşturulumadı.\nTekrar Deneyiniz.");
                    }



                    }
                    else {
                       
                        JOptionPane.showMessageDialog(null, "Girdiğiniz Şifreler Aynı Değil");
                    }
                	}

                }
            });
		
		
		
		//Frame görünebilirlik
				this.setVisible(true);
			
		}
			
		}

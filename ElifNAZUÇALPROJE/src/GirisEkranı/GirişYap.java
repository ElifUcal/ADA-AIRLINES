package GirisEkranı;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Anaİşlemler.Anaİşlemler;

public class GirişYap extends JFrame {
	
	private File dosya1;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JPanel emailPanel;
	private JPanel şifrePanel;
	private JPanel temailPanel;
	private JPanel tşifrePanel;
	private JPanel logoPanel;
	private JLabel emaiLabel;
	private JLabel şifreLabel;
	private JTextField temail;
	private JPasswordField tşifre;
	private JButton girisyapButton;
	private JButton şifremiunuttumButton;
	private JButton geridönButton;
	private JLabel logoLabel;
	private String id;
	
	
	public GirişYap() {
			
				//Frame ile ilgili kısım 
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setSize(1920,1080);
				this.setLayout(new GridLayout(3,1));
				this.setTitle("GİRİŞ YAP...");
				ImageIcon logo = new ImageIcon("LOGO.png");
				this.setIconImage(logo.getImage());
				
				
				////////////////////////////////////////////////////
				
				
				//Nene oluşturma
				topPanel = new JPanel();
				bottomPanel = new JPanel();
				logoPanel = new JPanel();
				 emailPanel = new JPanel();
				 şifrePanel = new JPanel();
				 temailPanel = new JPanel();
				 tşifrePanel = new JPanel();
				emaiLabel = new JLabel("Email:");
				şifreLabel = new JLabel("Şifre:");
				temail = new JTextField();
				tşifre = new JPasswordField();
				girisyapButton = new JButton("Giriş Yap");
				logoLabel = new JLabel();
				şifremiunuttumButton = new JButton("Şifremi Unutum");
				dosya1 = new File("Üye Bilgileri.txt");
				geridönButton = new JButton("Geri Dön");
				
				////////////////////////////////////////////////
				
				//Text field özelikleri;
				temail.setFont(new Font("TimesRoman",Font.ITALIC,20));
				tşifre.setFont(new Font("TimesRoman",Font.ITALIC,20));
				tşifre.setPreferredSize(new Dimension(200,50));
				temail.setPreferredSize(new Dimension(200,50));
				
				//Panel özellikleri
				emailPanel.setLayout(new FlowLayout()); 
				şifrePanel.setLayout(new FlowLayout());
				topPanel.setLayout(new GridLayout(2,1));
				bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
				logoPanel.add(logoLabel);
				logoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
				logoLabel.setText("ADA AİRLİNES");
				logoLabel.setFont(new Font("TimesRoman", Font.ITALIC, 30));
				ImageIcon logo3 = new ImageIcon("logo5.png");
				logoLabel.setIcon(logo3);
				emaiLabel.setFont(new Font("TimesRoman", Font.ITALIC, 40));
				şifreLabel.setFont(new Font("TimesRoman", Font.ITALIC, 40));
				tşifre.setEchoChar('*');
				
				
				emailPanel.add(emaiLabel);
				emailPanel.add(temail);
				şifrePanel.add(şifreLabel);
				şifrePanel.add(tşifre);
				topPanel.add(emailPanel);
				topPanel.add(şifrePanel);
				bottomPanel.add(girisyapButton);
				bottomPanel.add(şifremiunuttumButton);
				bottomPanel.add(geridönButton);
				emailPanel.setBackground(new Color(255, 250 ,250));
				şifrePanel.setBackground(new Color(255, 250 ,250));
				logoPanel.setBackground(new Color(255, 250 ,250));
				bottomPanel.setBackground(new Color(255, 250 ,250));
				topPanel.setBackground(new Color(255, 250 ,250));
				
				
				this.add(logoPanel);
				this.add(topPanel);
				this.add(bottomPanel);
				
				//buton özellikleri
				girisyapButton.setPreferredSize(new Dimension(200, 100));
				şifremiunuttumButton.setPreferredSize(new Dimension(200, 100));
				şifremiunuttumButton.setBackground(new Color( 0 ,139 ,139));
				girisyapButton.setFont(new Font("TimesRoman",Font.BOLD,20));
				şifremiunuttumButton.setFont(new Font("TimesRoman",Font.BOLD,20));
				girisyapButton.setFocusPainted(false);
				şifremiunuttumButton.setFocusPainted(false);
				şifremiunuttumButton.setBorderPainted(false);
				girisyapButton.setBackground(new Color( 0 ,139 ,139));
				girisyapButton.setBorderPainted(false);
				girisyapButton.setHorizontalAlignment(JLabel.CENTER);
				girisyapButton.setVerticalTextPosition(JLabel.BOTTOM);
				girisyapButton.addMouseListener(new MouseAdapter() {
		        	
					public void mouseEntered(MouseEvent e) {
						girisyapButton.setBackground(new Color(32 ,178 ,170));
					}

					public void mouseExited(MouseEvent e) {
						girisyapButton.setBackground(new Color( 0 ,139 ,139));
					}
					
				});
				şifremiunuttumButton.addMouseListener(new MouseAdapter() {
		        	
					public void mouseEntered(MouseEvent e) {
						şifremiunuttumButton.setBackground(new Color(32 ,178 ,170));
					}

					public void mouseExited(MouseEvent e) {
						şifremiunuttumButton.setBackground(new Color( 0 ,139 ,139));
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
							geridönButton.setBackground(new Color(32,178,170));
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
				
				şifremiunuttumButton.addActionListener(new ActionListener() {
				    @Override
				    public void actionPerformed(ActionEvent e) {
				        if (e.getSource() == şifremiunuttumButton) {
				            String tc = JOptionPane.showInputDialog(null, "Lütfen TC numaranızı girin", "Şifremi Göster", JOptionPane.INFORMATION_MESSAGE);

				            try (BufferedReader reader = new BufferedReader(new FileReader(dosya1))) {
				                String line;
				                String[] strArray;
				                boolean hesapVarMi = false;

				                while ((line = reader.readLine()) != null) {
				                    strArray = line.split(",");

				                    if (strArray[3].equals(tc)) {
				                        JOptionPane.showMessageDialog(null, "Şifreniz: " + strArray[8]);
				                        hesapVarMi = true;
				                        break;
				                    }
				                }

				                if (!hesapVarMi) {
				                    JOptionPane.showMessageDialog(null, "Hesabınız bulunamadı.");
				                }
				            } catch (Exception ex) {
				                ex.printStackTrace();
				                JOptionPane.showMessageDialog(null, "Dosya okuma hatası oluştu.");
				            }
				        }
				    }
				});

				
				// Dosya işlemleri
				girisyapButton.addActionListener(new ActionListener() {

		            @Override
		            public void actionPerformed(ActionEvent e) {
		                if(e.getSource()==girisyapButton) {
		                    try(BufferedReader reader = new BufferedReader(new FileReader(dosya1))) {


		                       String line;
		                       String[] strArray;
		                       boolean hesapvarmi = false;


		                        while((line = reader.readLine()) != null) {

		                            strArray = line.split(",");


		                        if(strArray[5].equals(temail.getText().trim()) && strArray[8].equals(new String(tşifre.getPassword()))) {

		                            hesapvarmi = true;
		                            id = strArray[0];
		                            JOptionPane.showMessageDialog(null, "Hesabınıza Başarıyla Giriş Yapıldı...");
		                            reader.close();
		                            setVisible(false);
		                            Anaİşlemler a1 = new Anaİşlemler(id);
		                            break;


		                        }


		                         }
		                        if(hesapvarmi == false) {
		                            JOptionPane.showMessageDialog(null, "Kullanıcı Adınız Veya Şifreniz Yanlış !");

		                        }

		                    }
		                   catch(Exception e2) {

		                       JOptionPane.showMessageDialog(null, "Dosyada bir hata var.");

		                    }

		                }
		            }});
				
				//Frame görünebilirlik
				this.setVisible(true);

	}
	
	
}

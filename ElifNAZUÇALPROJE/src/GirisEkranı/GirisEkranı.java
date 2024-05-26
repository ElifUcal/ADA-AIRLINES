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
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GirisEkranı extends JFrame{
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JButton girisyapbuton;
	private JButton uyeolbuton;
	private JLabel label1;
	private JLabel label2;
	
	
	public GirisEkranı() {
	
		//Nesneler
		panel1 = new JPanel();
		panel2= new JPanel();
		girisyapbuton = new JButton("Giriş yapınız.");
		uyeolbuton = new JButton("Hesabınız yoksa lütfen üye olunuz.");
		label1 = new JLabel();
		label2 = new JLabel();
		panel3 = new JPanel();
		
		
		//Frame ile ilgili kısım 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1920,1080);
		this.setLayout(new GridLayout(3,1));
		this.setTitle("Ada Airlines / Giriş Ekranı");
		ImageIcon logo = new ImageIcon("LOGO.png");
		this.setIconImage(logo.getImage());
		
		//////////////////////////////////////////////////////////
		
		
		//Label ile ilgili kısım
		label1.setText("ADA AİRLİNES");
		label1.setFont(new Font("TimesRoman", Font.ITALIC, 30));
		label2.setText("HOŞGELDİNİZ LÜTFEN GİRİŞ YAPINIZ.");
		label2.setFont(new Font("TimesRoman", Font.ITALIC, 40));
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setVerticalTextPosition(JLabel.BOTTOM);
		ImageIcon logo3 = new ImageIcon("logo5.png");
		label1.setIcon(logo3);
		
		//////////////////////////////////////////////////////////
		
		//Panel ile ilgili kısımlar
		panel1.add(label2);
		panel3.add(label1);
		panel2.add(uyeolbuton);
		panel2.add(girisyapbuton);
		panel1.setLayout(new GridLayout(1,1));
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel1.setBackground(new Color(255 ,250 ,250));
		panel2.setBackground(new Color(255 ,250 ,250));
		panel3.setBackground(new Color(255, 250 ,250));
		
		//Buton işlemleri
		girisyapbuton.setPreferredSize(new Dimension(400, 150));
        uyeolbuton.setPreferredSize(new Dimension(400, 150));
        girisyapbuton.setFont(new Font("TimesRoman",Font.BOLD,20));
        uyeolbuton.setFont(new Font("TimesRoman",Font.BOLD,20));
        girisyapbuton.setForeground(new Color(255, 250 ,250));
        uyeolbuton.setForeground(new Color(255, 250 ,250));
        girisyapbuton.setFocusPainted(false);
        uyeolbuton.setFocusPainted(false);
        girisyapbuton.setBackground(new Color( 0 ,139 ,139));
        uyeolbuton.setBackground(new Color( 0 ,139 ,139));
        girisyapbuton.addMouseListener(new MouseAdapter() {
        	
			public void mouseEntered(MouseEvent e) {
				girisyapbuton.setBackground(new Color( 32 ,178 ,170));
				girisyapbuton.setPreferredSize(new Dimension(300, 50));
			}

			public void mouseExited(MouseEvent e) {
				girisyapbuton.setBackground(new Color( 0 ,139 ,139));
				girisyapbuton.setPreferredSize(new Dimension(400, 150));
			}

			
			
        	
		});
        
          uyeolbuton.addMouseListener(new MouseAdapter() {
        	
			public void mouseEntered(MouseEvent e) {
				uyeolbuton.setBackground(new Color(32 ,178 ,170));
			}

			public void mouseExited(MouseEvent e) {
				uyeolbuton.setBackground(new Color( 0 ,139 ,139));
			}
        	
		});
          girisyapbuton.setBorderPainted(false);
          
          
          
          uyeolbuton.setBorderPainted(false);
          girisyapbuton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==girisyapbuton) {
						GirişYap g1 = new GirişYap();
						setVisible(false);
						
					}
				}});
          uyeolbuton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==uyeolbuton) {
						ÜyeOl u1 = new ÜyeOl();
						setVisible(false);
						
					}
				}});
		
		//Frame ekleme işlemleri
		this.add(panel3);
		this.add(panel1);
		this.add(panel2);
		this.setVisible(true);
		
		
	}
	
}
	

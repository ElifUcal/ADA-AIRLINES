package Anaİşlemler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import GirisEkranı.GirisEkranı;

public class Anaİşlemler extends JFrame{
	JMenuBar anaMenuBar;
	JMenu biletMenuBar;
	JMenu bagaJMenuBar;
	JMenu havaJMenuBar;
	JMenu iletişimMenuBar;
	JMenuItem şehirlerarasıbiletItem;
	JMenuItem ülkelerarasıbiletItem;
	JMenuItem biletkonturoluItem;
	JMenuItem exbagajalmaItem;
	JMenuItem bagajkgeklemeItem;
	JMenuItem cıkItem;
	JMenuItem havamsı;
	JMenu hesapMenu;
	JPanel menuPanel;
	JLabel menuLabel;
	JLabel menuLabel1;
	JLabel menuLabel2;
	JPanel iletisimPanel;
	JLabel iletisimLabel;
	
	
	
	public Anaİşlemler(String id) {
		//Frame işlemleri
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1920,1080);
		this.setTitle("Ada Airlines / İşlemler");
		ImageIcon logo = new ImageIcon("LOGO.png");
		this.setIconImage(logo.getImage());
		this.setLayout(new GridLayout(2,1));
		this.setLocationRelativeTo(null);
		
		////////////////////////////////////////
		this.setBackground(new Color(255, 250 ,250));

		
		//MenuBar işlemleri
		havaJMenuBar = new JMenu("Hava Durumu");
		iletisimLabel = new JLabel();
		iletisimPanel= new JPanel();
		menuLabel = new JLabel();
		menuLabel1 = new JLabel();
		menuLabel2 = new JLabel();
		menuPanel = new JPanel();
		anaMenuBar = new JMenuBar();
		biletMenuBar = new JMenu("Bilet İşlemleri");
		bagaJMenuBar = new JMenu("Bagaj İşlemleri");
		iletişimMenuBar = new JMenu("Iletişim Bilgileri");
		şehirlerarasıbiletItem = new JMenuItem("Yurtiçi bilet al");
		ülkelerarasıbiletItem = new JMenuItem("Ulkeler arası bilet al");
		cıkItem= new JMenuItem("Hesaptan Çıkış") ;
		havamsı = new JMenuItem("Hava Durumu");
		hesapMenu = new JMenu("Hesap İşlemleri");
		exbagajalmaItem = new JMenuItem("Ekstra Bagaj");
		bagajkgeklemeItem = new JMenuItem("Bagaj Ağırlığı");
		biletkonturoluItem = new JMenuItem("Bilet Kontrolü");
		havamsı.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		havaJMenuBar.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		şehirlerarasıbiletItem.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		ülkelerarasıbiletItem.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		biletkonturoluItem.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		exbagajalmaItem.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		bagajkgeklemeItem.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		biletMenuBar.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		bagaJMenuBar.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		iletişimMenuBar.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		hesapMenu.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		cıkItem.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		havaJMenuBar.setMnemonic(KeyEvent.VK_H);
		biletMenuBar.setMnemonic(KeyEvent.VK_B);
		şehirlerarasıbiletItem.setMnemonic(KeyEvent.VK_Y);
		ülkelerarasıbiletItem.setMnemonic(KeyEvent.VK_U);
		biletkonturoluItem.setMnemonic(KeyEvent.VK_B);
		cıkItem.setMnemonic(KeyEvent.VK_H);
		hesapMenu.setMnemonic(KeyEvent.VK_H);
		havamsı.setMnemonic(KeyEvent.VK_H);
		bagaJMenuBar.setMnemonic(KeyEvent.VK_B);
		exbagajalmaItem.setMnemonic(KeyEvent.VK_E);
		bagajkgeklemeItem.setMnemonic(KeyEvent.VK_B);
		iletişimMenuBar.setMnemonic(KeyEvent.VK_I);
		this.setJMenuBar(anaMenuBar);
		biletMenuBar.add(ülkelerarasıbiletItem);
		biletMenuBar.add(şehirlerarasıbiletItem);
		biletMenuBar.add(biletkonturoluItem);
		havaJMenuBar.add(havamsı);
		hesapMenu.add(cıkItem);
		anaMenuBar.add(havaJMenuBar);
		anaMenuBar.add(biletMenuBar);
		
		anaMenuBar.add(hesapMenu);
		anaMenuBar.setBackground(new Color( 0 ,139 ,139));
		
		//görsel
		ImageIcon logo3 = new ImageIcon("ADA AİRLİNES1.png");
		menuLabel.setIcon(logo3);
		ImageIcon logo4 = new ImageIcon("aman1.png");
		menuLabel1.setIcon(logo4);
		ImageIcon logo5 = new ImageIcon("iletisim1.png");
		menuPanel.setLayout(new FlowLayout());
		menuLabel2.setIcon(logo5);
		menuPanel.add(menuLabel2);
		menuPanel.add(menuLabel);
		menuPanel.add(menuLabel1);
		menuPanel.setBackground(new Color(255, 250 ,250));
		iletisimPanel.setBackground(new Color(255, 250 ,250));
		iletisimLabel.setBackground(new Color(255, 250 ,250));
		iletisimLabel.setPreferredSize(new Dimension(200, 200));
		iletisimPanel.add(iletisimLabel);
		
		
		this.add(menuPanel); 
		this.add(iletisimPanel);
		
			
	
		anaMenuBar.setPreferredSize(new Dimension(200,80));
		cıkItem.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
	                if(e.getSource()==cıkItem) {
	                	setVisible(false);
	                	GirisEkranı g1 = new GirisEkranı();
	                	
	                }
			 }
		 });

		şehirlerarasıbiletItem.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
	                if(e.getSource()==şehirlerarasıbiletItem) {
	                	setVisible(false);
	                	YurtiçiBiletler s1 = new YurtiçiBiletler(id);
	                	
	                }
			 }

			
		 });
			 ülkelerarasıbiletItem.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
		                if(e.getSource()==ülkelerarasıbiletItem) {
		                	setVisible(false);
		                	Ulekelerarasıbilet u1 = new Ulekelerarasıbilet(id);
		                }
				 }
			 });
			 
		biletkonturoluItem.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
	                if(e.getSource()==biletkonturoluItem) {
	                	setVisible(false);
						BiletKontrol b1 = new BiletKontrol(id);
	                }
			 }
			 });
		bagajkgeklemeItem.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
	                if(e.getSource()==bagajkgeklemeItem) {
	                	
	                }
			 }
			 });
		exbagajalmaItem.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
	                if(e.getSource()==exbagajalmaItem) {
	                	
	                }
			 }
			 });
		havamsı.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new HavaDurumu(id).setVisible(true);
			}
		});
		
			
		//Görünebilirlik
		this.setVisible(true);
			
			}


	

}

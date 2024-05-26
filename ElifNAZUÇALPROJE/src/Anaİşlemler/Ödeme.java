package Anaİşlemler;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Ödeme extends JFrame{
	
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	
	 
	public Ödeme(String id,int fiyat1) {
		
		this.getContentPane().setBackground(new Color(255, 250, 250));
		this.setBounds(100, 100, 1920, 1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setTitle("ADA AİRLİNES / Ödeme");
		ImageIcon logo = new ImageIcon("LOGO.png");
		this.setIconImage(logo.getImage());
		this.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("ADA AİRLİNES");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\birgu\\OneDrive\\Masaüstü\\Ada Airlines\\logo5.png"));
		lblNewLabel.setBounds(0, 0, 270, 71);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ödeme işlemini gerçekleştiriniz.");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		lblNewLabel_1.setBounds(602, 113, 393, 46);
		this.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Kart No:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		lblNewLabel_2.setBounds(602, 195, 122, 46);
		this.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Son Kullanma Tarihi:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		lblNewLabel_3.setBounds(602, 273, 270, 46);
		this.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CVV:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		lblNewLabel_4.setBounds(602, 370, 75, 39);
		this.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(765, 208, 270, 33);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(891, 286, 144, 33);
		this.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(712, 374, 323, 35);
		this.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel fiyat = new JLabel("fiyat:" + fiyat1 + " ₺");
		fiyat.setBounds(750, 450, 450, 70);
		fiyat.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		this.getContentPane().add(fiyat);
		
		
		JButton ödemebutonu = new JButton("Ödeme Yap");
		ödemebutonu.setBounds(712, 521, 200, 100);
		this.getContentPane().add(ödemebutonu);
	 	ödemebutonu.setFont(new Font("TimesRoman",Font.BOLD,20));
		ödemebutonu.setFocusPainted(false);
		ödemebutonu.setBackground(new Color( 0 ,139 ,139));
		ödemebutonu.setBorderPainted(false);
		ödemebutonu.setHorizontalAlignment(JLabel.CENTER);
		ödemebutonu.setVerticalTextPosition(JLabel.BOTTOM);
			
		ödemebutonu.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if (e.getSource() ==ödemebutonu) {
		        	 if (textField.getText().isEmpty()  || textField_1.getText().isEmpty() ||   textField_2.getText().isEmpty()) {

                         JOptionPane.showMessageDialog(null, "Boşlukların Hepsini Doldurmalısınız !");

                 	
                         
                     	}
		        	 else {
		        	setVisible(false);
		        	Anaİşlemler a1 = new Anaİşlemler(id);
		        	JOptionPane.showMessageDialog(null, "Ödemeniz alınmıştır");
		        	 }
		        }
		        
		    }
	    
	});
		
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
                    String text = textField_1.getText();
                    if (text.length() == 2 || text.length() == 2) {
                        text += "/";
                        textField_1.setText(text);
                    }
                });
            }
        };

        textField_1.getDocument().addDocumentListener(documentListener);
        
        
        textField_1.addKeyListener((KeyListener) new KeyAdapter() {
			
			
			
			public void keyTyped(KeyEvent e) {
				 char c = e.getKeyChar();
				if(textField_1.getText().length() >= 5) {
				e.consume();
				}
				 if(!Character.isDigit(c)) {
	                    e.consume();
	                }

			}
			
			
			
		});
        
        textField.addKeyListener((KeyListener) new KeyAdapter() {
			
			
			
			public void keyTyped(KeyEvent e) {
				 char c = e.getKeyChar();
				if(textField.getText().length() >= 19) {
				e.consume();
				}
				 if(!Character.isDigit(c)) {
	                    e.consume();
	                }

			}
			
			
			
		});
        
        textField_2.addKeyListener((KeyListener) new KeyAdapter() {
			
			
			
			public void keyTyped(KeyEvent e) {
				 char c = e.getKeyChar();
				if(textField_2.getText().length() >= 3) {
				e.consume();
				}
				 if(!Character.isDigit(c)) {
	                    e.consume();
	                }

			}
			
			
			
		});
        DocumentListener documentListener1 = new DocumentListener() {
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
                    String text = textField.getText();
                    if (text.length() == 4 || text.length() == 9 || text.length() == 14) {
                        text += " ";
                        textField.setText(text);
                    }
                });
            }
        };

        textField.getDocument().addDocumentListener(documentListener1);
        
		
		
		this.setVisible(true);
	}
	}


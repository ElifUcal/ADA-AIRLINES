package Anaİşlemler;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class BiletKontrol extends JFrame {

    private JTable table;
    private MyTableModel model;
    private JButton geridonbuton;
    private static String tempid;
    private JSONObject Hava;
    private boolean yagmursorgu = false;
    private boolean ruzgarsorgu = false;
    private  boolean rotaruyarı = false;



    String dosyayolu;

    File biletkontrol;

    public BiletKontrol(String id) {

        ImageIcon logo = new ImageIcon("LOGO.png");
        this.setIconImage(logo.getImage());
        tempid = id;
        //Nesne Oluşturma

        geridonbuton = new JButton("Geri Dön");
        biletkontrol = new File("biletkontrol.txt");
        dosyayolu = "biletkontrol.txt";




        //Rotarinyosssss...
        try (BufferedReader reader = new BufferedReader(new FileReader(biletkontrol))) {
            String line;
            String[] strArray;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

            String[] kalkıs;
            String bugununTarihi = LocalDate.now().format(formatter);
            List<String[]> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                strArray = line.split(",");
                kalkıs = strArray[1].split(" ");
                String bilettarihi;    //[6]


                if (strArray[6].equals(bugununTarihi)) {
                    Hava = WeatherApp.getWeatherData(kalkıs[0]);
                    String yagmurlu = (String) Hava.get("weather_condition");
                    if (yagmurlu.equals("Rain")) {
                        yagmursorgu = true;
                    }
                    double ruzgarhızı = (double) Hava.get("windspeed");
                    if (ruzgarhızı >= 7) {
                        ruzgarsorgu = true;
                    }
                }
                lines.add(strArray);
            }
            if (yagmursorgu && ruzgarsorgu) {
                for (String[] lineArray : lines) {
                    if (lineArray[6].equals(LocalDate.now().format(formatter))) {
                        lineArray[6] = LocalDate.now().plusDays(1).format(formatter);


                    }
                }
                FileHelper.writeLinesToFile(dosyayolu, lines);
                rotaruyarı = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //JTable İşlemleri


        List<String[]> data = null;
        try {

            data = FileHelper.readLinesFromFile(dosyayolu);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] columnNames = {"İd", "Kalkış", "Varış", "Kişi Tİpi", "Koltuk Tipi", "Koltuk No:", "Bilet Tarihi", "Saat"};
        model = new MyTableModel(columnNames, data);
        table = new JTable(model);
        table.getColumn("Sigorta").setCellRenderer(new ButtonRenderer());
        table.getColumn("Sigorta").setCellEditor(new ButtonEditor(table, dosyayolu));



        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setBounds(0, 0, 1530, 600);

        table.getTableHeader().setReorderingAllowed(false);






        //Buton İşlemleri

        geridonbuton.setBounds(650, 610, 250, 100);
        geridonbuton.setFont(new Font("TimesRoman", Font.BOLD, 20));
        geridonbuton.setFocusPainted(false);
        geridonbuton.setBackground(new Color(0, 139, 139));
        geridonbuton.setBorderPainted(false);
        geridonbuton.setHorizontalAlignment(JLabel.CENTER);
        geridonbuton.setVerticalTextPosition(JLabel.BOTTOM);

        geridonbuton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                geridonbuton.setBackground(new Color(32, 178, 170));
            }

            public void mouseExited(MouseEvent e) {
                geridonbuton.setBackground(new Color(0, 139, 139));
            }

        });





        geridonbuton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                Anaİşlemler a1 = new Anaİşlemler(id);


            }


        });

        //TABLE BUTON
        JButton addButton = new JButton("Add Data from Another File");
        addButton.addActionListener(e -> {
            try {
                List<String[]> newData = FileHelper.readLinesFromFile("another_data.txt"); // Yeni txt dosyasının yolu
                model.addData(newData);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        //TXT İŞLEMLERİ


        //Frame ile ilgili kısımlar
        this.add(addButton);
        this.add(geridonbuton);
        this.setIconImage(logo.getImage());
        this.add(scrollPane);
        this.setSize(1920, 1080);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Bilet Kontrol");
        this.getContentPane().setBackground(new Color(255, 250, 250));

        this.setVisible(true);
        if (rotaruyarı ){
            JOptionPane.showMessageDialog(null, "Bugunkü biletiniz rotardan dolayı ertesi güne ertelenmiştir");
        }
        this.setLocationRelativeTo(null);


    }


    class FileHelper {
        public static List<String[]> readLinesFromFile(String filePath) throws IOException {
            List<String[]> lines = new java.util.ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                String[] strArray2;
                while ((line = br.readLine()) != null) {
                    strArray2 = line.split(",");

                    if (strArray2[0].equals(tempid)) {

                        lines.add(line.split(","));
                    }


                }
            }
            return lines;
        }

        public static void writeLinesToFile(String filePath, List<String[]> lines) throws IOException {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                for (String[] line : lines) {
                    bw.write(String.join(",", line));
                    bw.newLine();
                }
            }
        }
    }


    class MyTableModel extends AbstractTableModel { //Tablo modelini kullanmak için extends ettimm
        private final String[] columnNames;
        private final List<String[]> data;

        public MyTableModel(String[] columnNames, List<String[]> data) {
            this.columnNames = columnNames;
            this.data = data;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length + 1; // Sil butonu için ek bir sütun
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex < columnNames.length) {
                return data.get(rowIndex)[columnIndex];
            } else {
                return "Bilet İptal";
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == columnNames.length; // Sadece sil butonu düzenlenebilir
        }

        @Override
        public String getColumnName(int column) {
            if (column < columnNames.length) {
                return columnNames[column];
            } else {
                return "Sigorta";
            }
        }

        public void removeRow(int rowIndex) {
            data.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }

        public void addData(List<String[]> newData) {
            int rowCount = getRowCount();
            for (String[] row : newData) {
                data.add(row);
            }
            fireTableRowsInserted(rowCount, getRowCount() - 1);
        }
    }


    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
            setText("Bilet İptal");
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }


    class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
        private final JButton button;
        private int row;
        private JTable table;
        private String filePath;

        public ButtonEditor(JTable table, String filePath) {
            this.table = table;
            this.filePath = filePath;
            button = new JButton("Bilet İptal");
            button.setOpaque(true);
            button.addActionListener(this);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.row = row;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return "Bilet İptal";
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                List<String[]> lines = FileHelper.readLinesFromFile(filePath);
                String[] strArray2;
                strArray2 = new String(Arrays.toString(lines.get(row))).split(",");
                if (strArray2[8].equals(" true]")) {

                    fireEditingStopped();
                    MyTableModel model = (MyTableModel) table.getModel();
                    model.removeRow(row);


                        lines.remove(row); // Satırı doğru indekste kaldırmak için düzeltilmiş
                        FileHelper.writeLinesToFile(filePath, lines);

                }
                else {
                    JOptionPane.showMessageDialog(null, "Biletiniz Sigortasızdır");
                }
            }
            catch (IOException ex) {
            ex.printStackTrace();
            }


        }

        @Override
        public boolean isCellEditable(EventObject e) {
            return true;
        }
    }
}
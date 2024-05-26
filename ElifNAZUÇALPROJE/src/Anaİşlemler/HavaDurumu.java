package Anaİşlemler;
import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;




public class HavaDurumu extends JFrame {
    private JSONObject weatherData;


    public  HavaDurumu(String id){



        // setup our gui and add a title
        super("Weather App");
        this.setBackground(new Color(255, 250 ,250));
        this.setTitle("Ada Airlines / HavaDurumu");
        ImageIcon logo = new ImageIcon("LOGO.png");
        this.setIconImage(logo.getImage());

        // configure gui to end the program's process once it has been closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set the size of our gui (in pixels)
        setSize(1920, 1080);

        // load our gui at the center of the screen
        setLocationRelativeTo(null);

        // make our layout manager null to manually position our components within the gui
        setLayout(null);

        // prevent any resize of our gui
        setResizable(false);


        addGuiComponents(id);
    }

    private void addGuiComponents(String id){


        // search field
        JTextField searchTextField = new JTextField();

        // set the location and size of our component
        searchTextField.setBounds(15, 15, 351, 45);

        // change the font style and size
        searchTextField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(searchTextField);

        // weather image
        JLabel weatherConditionImage = new JLabel(loadImage("cloudy.png"));
        weatherConditionImage.setBounds(550, 125, 450, 217);
        add(weatherConditionImage);

        // temperature text
        JLabel temperatureText = new JLabel("10 C");
        temperatureText.setBounds(550, 350, 450, 54);
        temperatureText.setFont(new Font("Dialog", Font.BOLD, 48));

        // center the text
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);

        // weather condition description
        JLabel weatherConditionDesc = new JLabel("Cloudy");
        weatherConditionDesc.setBounds(550, 405, 450, 36);
        weatherConditionDesc.setFont(new Font("Dialog", Font.PLAIN, 32));
        weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDesc);

        // humidity image
        JLabel humidityImage = new JLabel(loadImage("humidity.png"));
        humidityImage.setBounds(565, 500, 74, 66);
        add(humidityImage);

        // humidity text
        JLabel humidityText = new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(640, 500, 85, 55);
        humidityText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(humidityText);

        // windspeed image
        JLabel windspeedImage = new JLabel(loadImage("windspeed.png"));
        windspeedImage.setBounds(950, 500, 74, 66);
        add(windspeedImage);

        // windspeed text
        JLabel windspeedText = new JLabel("<html><b>Windspeed</b> 15km/h</html>");
        windspeedText.setBounds(860, 500, 85, 55);
        windspeedText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(windspeedText);

        // search button
        JButton searchButton = new JButton("ARA");
        JButton geriButton  = new JButton("Geri Dön");
        geriButton.setFont(new Font("TimesRoman",Font.BOLD,20));
        geriButton.setFocusPainted(false);
        geriButton.setBackground(new Color( 0 ,139 ,139));
        geriButton.setBorderPainted(false);
        geriButton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                geriButton.setBackground(new Color(32,178,170));
            }

            public void mouseExited(MouseEvent e) {
                geriButton.setBackground(new Color( 0 ,139 ,139));
            }

        });
        searchButton.setFont(new Font("TimesRoman",Font.BOLD,20));
        searchButton.setFocusPainted(false);
        searchButton.setBackground(new Color( 0 ,139 ,139));
        searchButton.setBorderPainted(false);
        searchButton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                searchButton.setBackground(new Color(32,178,170));
            }

            public void mouseExited(MouseEvent e) {
                searchButton.setBackground(new Color( 0 ,139 ,139));
            }

        });


        // change the cursor to a hand cursor when hovering over this button
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375, 13, 100, 45);
        geriButton.setBounds(480, 13, 200, 45);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get location from user
                String userInput = searchTextField.getText();

                // validate input - remove whitespace to ensure non-empty text
                if(userInput.replaceAll("\\s", "").length() <= 0){
                    return;
                }

                // retrieve weather data
                weatherData = WeatherApp.getWeatherData(userInput);

                // update gui

                // update weather image
                String weatherCondition = (String) weatherData.get("weather_condition");

                // depending on the condition, we will update the weather image that corresponds with the condition
                switch(weatherCondition){
                    case "Clear":
                        weatherConditionImage.setIcon(loadImage("clear.png"));
                        break;
                    case "Cloudy":
                        weatherConditionImage.setIcon(loadImage("cloudy.png"));
                        break;
                    case "Rain":
                        weatherConditionImage.setIcon(loadImage("rain.png"));
                        break;
                    case "Snow":
                        weatherConditionImage.setIcon(loadImage("snow.pngImage"));
                        break;
                }

                // update temperature text
                double temperature = (double) weatherData.get("temperature");
                temperatureText.setText(temperature + " C");

                // update weather condition text
                weatherConditionDesc.setText(weatherCondition);

                // update humidity text
                long humidity = (long) weatherData.get("humidity");
                humidityText.setText("<html><b>Humidity</b> " + humidity + "%</html>");

                // update windspeed text
                double windspeed = (double) weatherData.get("windspeed");
                windspeedText.setText("<html><b>Windspeed</b> " + windspeed + "km/h</html>");
            }
        });
        geriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                Anaİşlemler elif = new Anaİşlemler(id);
            }
        });
        add(geriButton);
        add(searchButton);
    }

    // used to create images in our gui components
    private ImageIcon loadImage(String resourcePath){
        try{
            // read the image file from the path given
            BufferedImage image = ImageIO.read(new File(resourcePath));

            // returns an image icon so that our component can render it
            return new ImageIcon(image);
        }catch(IOException e){
            e.printStackTrace();
        }

        System.out.println("Could not find resource");
        return null;
    }



}

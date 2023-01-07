import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

/**
 * Code that outputs a digital clock. Each section is separated into its own method
 * for better readability.
 */

public class DigitalClock {

    private static final int TIME_FONT_SIZE = 90;
    private static final String TIME_FORMAT = "h:mm:ss a";
    private static final String FONT = "Courier New";
    private static final String WINDOW_TITLE = "Digital clock";
    private static final int WINDOW_HEIGHT = 350;
    private static final int WINDOW_WIDTH = 600;
    private SimpleDateFormat time;
    private JFrame timeFrame;
    private JLabel timeLabel;


    public DigitalClock(){
        initialiseTimePattern();
        initialiseLabelText();
        initialiseWindowFrame();
        assignDigitalTime();
    }

    /**
     * Method to initialise time to h:mm:ss format
     */

    private void initialiseTimePattern(){
        time = new SimpleDateFormat(TIME_FORMAT);
    }


    /**
     * Method that sets the appearance of the digital time
     */

    private void initialiseLabelText(){
        timeLabel = new JLabel();
        timeLabel.setFont(new Font(FONT, Font.PLAIN, TIME_FONT_SIZE));
        timeLabel.setForeground(Color.GREEN);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }


    /**
     * Method that sets the appearance of the pop-up window frame
     */

    private void initialiseWindowFrame(){
        timeFrame = new JFrame(WINDOW_TITLE);
        timeFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        timeFrame.getContentPane().add(timeLabel);
        timeFrame.getContentPane().setBackground(Color.BLACK);
        timeFrame.setVisible(true);
        timeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Method that adds the current time to the label text
     */

    private void assignDigitalTime(){
        try {
            while (true){
                timeLabel.setText(time.format(Calendar.getInstance().getTime()));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DigitalClock();
    }

}

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.UUID;

public class AttendanceTracker {

    public static void main(String[] args) {

        
        JFrame frame = new JFrame("Attendance Tracker");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

     
        JLabel nameLabel = new JLabel("Attendance Name:");
        JLabel courseLabel = new JLabel("Course/Year:");
        JLabel timeInLabel = new JLabel("Time In:");
        JLabel signatureLabel = new JLabel("E-Signature:");

       
        JTextField nameField = new JTextField();
        JTextField courseField = new JTextField();
        JTextField timeInField = new JTextField();
        JTextField signatureField = new JTextField();

        
        String timeIn = LocalDateTime.now().toString();
        timeInField.setText(timeIn);
        timeInField.setEditable(false); 

       
        String eSignature = UUID.randomUUID().toString();
        signatureField.setText(eSignature);
        signatureField.setEditable(false); 

    
        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(courseLabel);
        panel.add(courseField);

        panel.add(timeInLabel);
        panel.add(timeInField);

        panel.add(signatureLabel);
        panel.add(signatureField);

     
        frame.add(panel);

     
        frame.setVisible(true);
    }
}

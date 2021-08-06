package bus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class MainScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public MainScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\20109\\Desktop\\scholar1.jpg"));
		setForeground(Color.WHITE);
		setFont(new Font("Arial Black", Font.PLAIN, 12));
		setTitle("Bus Reservation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(460, 250, 460, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton adminBTN = new JButton("Admin");
		adminBTN.setBackground(Color.BLACK);
		adminBTN.setForeground(Color.RED);
		adminBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin frame = new Admin();
				frame.setVisible(true);
			}
		});
		adminBTN.setBounds(69, 159, 110, 23);
		contentPane.add(adminBTN);
		
		JButton passengerBTN = new JButton("Passenger");
		passengerBTN.setBackground(Color.BLACK);
		passengerBTN.setForeground(Color.RED);
		passengerBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passenger frame = new Passenger();
				frame.setVisible(true);
			}
		});
		passengerBTN.setBounds(253, 159, 110, 23);
		contentPane.add(passengerBTN);
		
		JLabel lblNewLabel = new JLabel("Who Are You ?");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(138, 69, 162, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\20109\\Desktop\\1st semester\\java\\java\\assignment_1\\BusReservation_\\src\\bus\\scholar1.jpg"));
		lblNewLabel_1.setBounds(0, 0, 444, 261);
		contentPane.add(lblNewLabel_1);
		
	}
}



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    private static DefaultTableModel tableModel;

    public static void main(String[] args) {
        // Welcome Frame
        JFrame welcomeFrame = new JFrame("Welcome Page");
        welcomeFrame.setSize(500, 300);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setLayout(new BorderLayout());
        welcomeFrame.getContentPane().setBackground(new Color(52, 152, 219)); // Blue background
        welcomeFrame.setLocationRelativeTo(null);
        JLabel welcomeLabel = new JLabel("Welcome to Flight Ticket Booking", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.WHITE);

        JButton proceedButton = new JButton("Book Now");
        proceedButton.setBackground(new Color(46, 204, 113)); // Green button
        proceedButton.setForeground(Color.WHITE);
        proceedButton.setFont(new Font("Arial", Font.BOLD, 16));

        welcomeFrame.add(welcomeLabel, BorderLayout.CENTER);
        welcomeFrame.add(proceedButton, BorderLayout.SOUTH);
        welcomeFrame.setVisible(true);

        // Main Booking Frame
        JFrame frame = new JFrame("Flight Ticket Booking");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(236, 240, 241)); // Light gray background
        frame.setLocationRelativeTo(null);

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(41, 128, 185)); // Dark blue background
        JLabel headerLabel = new JLabel("Flight Ticket Booking Form", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 22));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(236, 240, 241));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = new JLabel("Passenger Name:");
        JTextField nameField = new JTextField(15);

        JLabel departureLabel = new JLabel("Departure City:");
        String[] departureCities = {"Jakarta", "Surabaya", "Bali", "Yogyakarta", "Medan", "Batam"};
        JComboBox<String> departureBox = new JComboBox<>(departureCities);

        JLabel destinationLabel = new JLabel("Destination City:");
        JComboBox<String> destinationBox = new JComboBox<>(departureCities);

        JLabel classLabel = new JLabel("Flight Class:");
        String[] flightClasses = {"Economy", "Business", "First Class"};
        JComboBox<String> classBox = new JComboBox<>(flightClasses);

        JLabel airlineLabel = new JLabel("Airline:");
        String[] airlines = {"Lion Air", "Garuda", "Batik Air", "Citilink"};
        JComboBox<String> airlineBox = new JComboBox<>(airlines);

        JLabel dayLabel = new JLabel("Flight Day:");
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        JComboBox<String> dayBox = new JComboBox<>(days);

        JLabel dateLabel = new JLabel("Flight Date:");
        JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
        dateSpinner.setEditor(dateEditor);

        JLabel timeLabel = new JLabel("Flight Time (HH:MM):");
        JTextField timeField = new JTextField(5);

        JLabel ticketLabel = new JLabel("Number of Tickets:");
        JTextField ticketField = new JTextField(5);

        JButton submitButton = new JButton("Book Ticket");
        submitButton.setBackground(new Color(46, 204, 113)); // Green button
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));

        JButton resetButton = new JButton("Reset Form");
        resetButton.setBackground(new Color(192, 57, 43)); // Red button
        resetButton.setForeground(Color.WHITE);
        resetButton.setFont(new Font("Arial", Font.BOLD, 16));

        // Add components to form panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(departureLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(departureBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(destinationLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(destinationBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(classLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(classBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(airlineLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(airlineBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(dayLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(dayBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        formPanel.add(dateLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(dateSpinner, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        formPanel.add(timeLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(timeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        formPanel.add(ticketLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(ticketField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        formPanel.add(resetButton, gbc);
        gbc.gridx = 1;
        formPanel.add(submitButton, gbc);

        // Table to display bookings
        String[] columnNames = {"Name", "From", "To", "Class", "Airline", "Day", "Date", "Time", "Tickets", "Total Price"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable bookingTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(bookingTable);

        // Customize table appearance
        bookingTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        bookingTable.getTableHeader().setBackground(new Color(41, 128, 185));
        bookingTable.getTableHeader().setForeground(Color.WHITE);
        bookingTable.setFont(new Font("Arial", Font.PLAIN, 12));
        bookingTable.setRowHeight(25);

        // Add panels to frame
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(tableScrollPane, BorderLayout.SOUTH);

        // Action Listener for submitButton
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();
                    String departure = (String) departureBox.getSelectedItem();
                    String destination = (String) destinationBox.getSelectedItem();
                    String flightClass = (String) classBox.getSelectedItem();
                    String airline = (String) airlineBox.getSelectedItem();
                    String day = (String) dayBox.getSelectedItem();
                    Date date = (Date) dateSpinner.getValue();
                    String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
                    String time = timeField.getText();
                    int ticketCount = Integer.parseInt(ticketField.getText());

                    if (departure.equals(destination)) {
                        JOptionPane.showMessageDialog(frame, "Departure and Destination cannot be the same.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (!isValidTime(time)) {
                        JOptionPane.showMessageDialog(frame, "Invalid time format! Use HH:MM (24-hour).", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    double basePrice = switch (airline) {
                        case "Lion Air" -> 600000;
                        case "Garuda" -> 1200000;
                        case "Batik Air" -> 800000;
                        case "Citilink" -> 700000;
                        default -> 0;
                    };

                    double multiplier = flightClass.equals("Economy") ? 1 : flightClass.equals("Business") ? 1.5 : 2;
                    double totalPrice = basePrice * ticketCount * multiplier;

                    Object[] row = {name, departure, destination, flightClass, airline, day, formattedDate, time, ticketCount, totalPrice};
                    tableModel.addRow(row);

                    nameField.setText("");
                    timeField.setText("");
                    ticketField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for tickets.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        resetButton.addActionListener(e -> {
            nameField.setText("");
            timeField.setText("");
            ticketField.setText("");
            departureBox.setSelectedIndex(0);
            destinationBox.setSelectedIndex(0);
            classBox.setSelectedIndex(0);
            airlineBox.setSelectedIndex(0);
            dayBox.setSelectedIndex(0);
        });

        proceedButton.addActionListener(e -> {
            welcomeFrame.setVisible(false);
            frame.setVisible(true);
        });
    }

    private static boolean isValidTime(String time) {
        return time.matches("([01]?\\d|2[0-3]):[0-5]\\d");
    }
}
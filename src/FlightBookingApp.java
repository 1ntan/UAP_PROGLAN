import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FlightBookingApp {
    private static Map<String, String[]> bookingData = new HashMap<>();

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

        JButton proceedButton = new JButton("Mulai");
        proceedButton.setBackground(new Color(46, 204, 113)); // Green button
        proceedButton.setForeground(Color.WHITE);
        proceedButton.setFont(new Font("Arial", Font.BOLD, 16));

        welcomeFrame.add(welcomeLabel, BorderLayout.CENTER);
        welcomeFrame.add(proceedButton, BorderLayout.SOUTH);
        welcomeFrame.setVisible(true);

        // Menu Frame
        JFrame menuFrame = new JFrame("Flight Ticket Menu");
        menuFrame.setSize(500, 300);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(new BorderLayout());
        menuFrame.getContentPane().setBackground(new Color(236, 240, 241));
        menuFrame.setLocationRelativeTo(null);

        JPanel panelPilih = new JPanel() {
            private final Image backgroundImage = new ImageIcon("C:\\Users\\User\\Pictures\\prolan\\photo_2024-12-27_21-20-08.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelPilih.setLayout(new BoxLayout(panelPilih, BoxLayout.Y_AXIS));
        panelPilih.add(Box.createVerticalGlue());

        JButton bookTicketButton = new JButton("Pesan Tiket");
        bookTicketButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPilih.add(bookTicketButton);

        panelPilih.add(Box.createVerticalStrut(20));

        JButton checkInButton = new JButton("Check-In");
        checkInButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPilih.add(checkInButton);
        panelPilih.add(Box.createVerticalGlue());

        menuFrame.add(panelPilih);

        // Booking Frame
        JFrame bookingFrame = new JFrame("Flight Ticket Booking");
        bookingFrame.setSize(800, 1000);
        bookingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bookingFrame.setLayout(new BorderLayout());
        bookingFrame.getContentPane().setBackground(new Color(236, 240, 241)); // Light gray background
        bookingFrame.setLocationRelativeTo(null);

        JPanel mainFormPanel = new JPanel();
        mainFormPanel.setLayout(new BoxLayout(mainFormPanel, BoxLayout.Y_AXIS));

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

        JLabel nameLabel = new JLabel("Passenger Name:");
        taruhKomponen(nameLabel, formPanel, 0, 0, 1, 1);

        JTextField nameField = new JTextField(15);
        taruhKomponen(nameField, formPanel, 1, 0, 1, 1);

        JLabel departureLabel = new JLabel("Departure City:");
        String[] departureCities = {"Jakarta", "Surabaya", "Bali", "Yogyakarta", "Medan", "Batam"};
        taruhKomponen(departureLabel, formPanel, 0, 1, 1, 1);

        JComboBox<String> departureBox = new JComboBox<>(departureCities);
        taruhKomponen(departureBox, formPanel, 1, 1, 1, 1);

        JLabel destinationLabel = new JLabel("Destination City:");
        taruhKomponen(destinationLabel, formPanel, 0, 2, 1, 1);

        JComboBox<String> destinationBox = new JComboBox<>(departureCities);
        taruhKomponen(destinationBox, formPanel, 1, 2, 1, 1);

        JLabel classLabel = new JLabel("Flight Class:");
        String[] flightClasses = {"Economy", "Business", "First Class"};
        taruhKomponen(classLabel, formPanel, 0, 3, 1, 1);

        JComboBox<String> classBox = new JComboBox<>(flightClasses);
        taruhKomponen(classBox, formPanel, 1, 3, 1, 1);

        JLabel airlineLabel = new JLabel("Airline:");
        String[] airlines = {"Lion Air", "Garuda", "Batik Air", "Citilink"};
        taruhKomponen(airlineLabel, formPanel, 0, 4, 1, 1);

        JComboBox<String> airlineBox = new JComboBox<>(airlines);
        taruhKomponen(airlineBox, formPanel, 1, 4, 1, 1);

        JLabel dayLabel = new JLabel("Flight Day:");
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        taruhKomponen(dayLabel, formPanel, 0, 5, 1, 1);

        JComboBox<String> dayBox = new JComboBox<>(days);
        taruhKomponen(dayBox, formPanel, 1, 5, 1, 1);

        JLabel dateLabel = new JLabel("Flight Date:");
        taruhKomponen(dateLabel, formPanel, 0, 6, 1, 1);

        JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
        dateSpinner.setEditor(dateEditor);
        taruhKomponen(dateSpinner, formPanel, 1, 6, 1, 1);

        JLabel timeLabel = new JLabel("Flight Time (HH:MM):");
        taruhKomponen(timeLabel, formPanel, 0, 7, 1, 1);

        JTextField timeField = new JTextField(5);
        taruhKomponen(timeField, formPanel, 1, 7, 1, 1);

        JLabel ticketLabel = new JLabel("Number of Tickets:");
        taruhKomponen(ticketLabel, formPanel, 0, 8, 1, 1);

        JTextField ticketField = new JTextField(5);
        taruhKomponen(ticketField, formPanel, 1, 8, 1, 1);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));

        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(0, 0, 0));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        taruhKomponen(backButton, buttonsPanel, 0, 0, 1, 1);

        buttonsPanel.add(Box.createHorizontalStrut(20));

        JButton submitButton = new JButton("Book Ticket");
        submitButton.setBackground(new Color(46, 204, 113)); // Green button
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        taruhKomponen(submitButton, buttonsPanel, 1, 0, 1, 1);

        buttonsPanel.add(Box.createHorizontalStrut(20));

        JButton updateButton = new JButton("Update");
        updateButton.setBackground(new Color(0, 115,255));
        updateButton.setForeground(Color.WHITE);
        updateButton.setFont(new Font("Arial", Font.BOLD, 16));
        taruhKomponen(updateButton, buttonsPanel, 2, 0, 1, 1);

        buttonsPanel.add(Box.createHorizontalStrut(20));

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(new Color(192, 57, 43)); // Red button
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFont(new Font("Arial", Font.BOLD, 16));
        taruhKomponen(deleteButton, buttonsPanel, 3, 0, 1, 1);

        // Table to display bookings
        String[] columnNames = {"Name", "From", "To", "Class", "Airline", "Day", "Date", "Time", "Tickets", "Total Price", "Ticket Code"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable bookingTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(bookingTable);

        // Add panels to booking frame
        mainFormPanel.add(headerPanel);
        mainFormPanel.add(formPanel);
        mainFormPanel.add(Box.createVerticalStrut(20));
        mainFormPanel.add(buttonsPanel);
        mainFormPanel.add(Box.createVerticalStrut(20));
        mainFormPanel.add(tableScrollPane);
        bookingFrame.setContentPane(mainFormPanel);

        // Check-In Frame
        JFrame checkInFrame = new JFrame("Flight Check-In");
        checkInFrame.setSize(500, 400);
        checkInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        checkInFrame.setLayout(new GridBagLayout());
        checkInFrame.getContentPane().setBackground(new Color(52, 73, 94)); // Dark gray background
        checkInFrame.setLocationRelativeTo(null);


        JPanel checkInPanel = new JPanel(new GridBagLayout());
        checkInPanel.setBackground(new Color(52, 73, 94));

        JLabel checkInNameLabel = new JLabel("Passenger Name:");
        taruhKomponen(checkInNameLabel, checkInPanel, 0, 0, 1, 1);

        JTextField checkInNameField = new JTextField(15);
        taruhKomponen(checkInNameField, checkInPanel, 1, 0, 1, 1);

        JLabel bookingCodeLabel = new JLabel("Booking Code:");
        taruhKomponen(bookingCodeLabel, checkInPanel, 0, 1, 1, 1);

        JTextField bookingCodeField = new JTextField(10);
        taruhKomponen(bookingCodeField, checkInPanel, 1, 1, 1, 1);

        JButton checkInButtonSubmit = new JButton("Check-In");
        checkInButtonSubmit.setBackground(new Color(46, 204, 113));
        checkInButtonSubmit.setForeground(Color.WHITE);
        checkInButtonSubmit.setFont(new Font("Arial", Font.BOLD, 16));
        taruhKomponen(checkInButtonSubmit, checkInPanel, 0, 2, 1, 1);

        JButton backToMenuButton = new JButton("Back");
        backToMenuButton.setBackground(new Color(192, 57, 43));
        backToMenuButton.setForeground(Color.WHITE);
        backToMenuButton.setFont(new Font("Arial", Font.BOLD, 16));
        taruhKomponen(backToMenuButton, checkInPanel, 1, 2, 1, 1);

        checkInFrame.add(checkInPanel);
        checkInFrame.setVisible(false); // Hide check-in frame initially

        // Action Listeners
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeFrame.setVisible(false);
                menuFrame.setVisible(true);
            }
        });

        bookTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                bookingFrame.setVisible(true);
            }
        });

        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                checkInFrame.setVisible(true);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookingFrame.setVisible(false);
                menuFrame.setVisible(true);
            }
        });

        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkInFrame.setVisible(false);
                menuFrame.setVisible(true);
            }
        });
        checkInButtonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String checkInName = checkInNameField.getText().trim();
                String bookingCode = bookingCodeField.getText().trim();

                if (checkInName.isEmpty() || bookingCode.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Data cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (bookingData.containsKey(bookingCode)) {
                        // Retrieve booking data
                        String[] bookingDetails = bookingData.get(bookingCode);
                        String passengerName = bookingDetails[0];
                        String flightDetails = "Flight from " + bookingDetails[1] + " to " + bookingDetails[2] + " on " +
                                bookingDetails[5] + " (" + bookingDetails[6] + ") with " + bookingDetails[3] + " class via " +
                                bookingDetails[4] + " airline";

                        // Check if the passenger name matches
                        if (checkInName.equals(passengerName)) {
                            // Successful check-in
                            JOptionPane.showMessageDialog(null, "Check-in Successful!\n" + flightDetails, "Success", JOptionPane.INFORMATION_MESSAGE);
                            checkInFrame.setVisible(false);
                            menuFrame.setVisible(true); // Return to menu after check-in
                        } else {
                            // Name mismatch
                            JOptionPane.showMessageDialog(null, "Name does not match the booking", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Booking code not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String departure = (String) departureBox.getSelectedItem();
                String destination = (String) destinationBox.getSelectedItem();
                String flightClass = (String) classBox.getSelectedItem();
                String airline = (String) airlineBox.getSelectedItem();
                String flightDay = (String) dayBox.getSelectedItem();
                Date flightDate = (Date) dateSpinner.getValue();
                String flightTime = timeField.getText();
                String stringTiket = ticketField.getText();

                if (name.isEmpty() || flightTime.isEmpty() || stringTiket.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Data must be entered");
                } else {
                    // Add booking data to table
                    try {
                        int numTickets = Integer.parseInt(stringTiket);
                        String ticketCode = "TK" + (int) (Math.random() * 1000000);
                        double totalPrice = calculatePrice(flightDay, numTickets);

                        String[] row = {name, departure, destination, flightClass, airline, flightDay,
                                new SimpleDateFormat("yyyy-MM-dd").format(flightDate), flightTime,
                                String.valueOf(numTickets), String.valueOf(totalPrice), ticketCode};
                        tableModel.addRow(row);

                        // Store the booking data
                        bookingData.put(ticketCode, row);

                        // Clear the form fields
                        nameField.setText("");
                        ticketField.setText("");
                        timeField.setText("");
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Number of tickets must be numeric");
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(null, "Unknown Error" + exc);
                    }
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialogUpdateRow = new JDialog((Frame) null, "Update Row");
                dialogUpdateRow.setLayout(new GridLayout(6, 2));

                JLabel labelTicketCode = new JLabel("Ticket Code");
                JTextField fieldTicketCode = new JTextField(10);

                JLabel labelPassangerName = new JLabel("New Name");
                JTextField filedPassangerName = new JTextField(10);

                JLabel labelFlightTime = new JLabel("New Flight Time");
                JTextField fieldFlightTime = new JTextField(10);

                JLabel labelNumberTicket = new JLabel("New Number of Ticket");
                JTextField fieldNumberTicket = new JTextField(10);

                JButton buttonUpdate = new JButton("Update");

                dialogUpdateRow.add(labelTicketCode);
                dialogUpdateRow.add(fieldTicketCode);
                dialogUpdateRow.add(labelPassangerName);
                dialogUpdateRow.add(filedPassangerName);
                dialogUpdateRow.add(labelFlightTime);
                dialogUpdateRow.add(fieldFlightTime);
                dialogUpdateRow.add(labelNumberTicket);
                dialogUpdateRow.add(fieldNumberTicket);
                dialogUpdateRow.add(new JLabel());
                dialogUpdateRow.add(new JLabel());

                dialogUpdateRow.add(buttonUpdate);

                buttonUpdate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String ticketCodeInput = fieldTicketCode.getText().trim();
                        String passangerNameInput = filedPassangerName.getText().trim();
                        String flightTimeInput = fieldFlightTime.getText().trim();
                        String numberTicketInput = fieldNumberTicket.getText().trim();

                        if (ticketCodeInput.isEmpty() || passangerNameInput.isEmpty() || flightTimeInput.isEmpty() || numberTicketInput.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Input Cannot Empty");
                            return;
                        }

                        if (bookingData.containsKey(ticketCodeInput)) {
                            try {
                                String[] detailRow = bookingData.get(ticketCodeInput);
                                detailRow[0] = passangerNameInput;
                                detailRow[7] = flightTimeInput;

                                int numTickets = Integer.parseInt(numberTicketInput);

                                detailRow[8] = String.valueOf(numTickets);
                                double newPrice = calculatePrice(detailRow[5], numTickets);
                                detailRow[9] = String.valueOf(newPrice);

                                bookingData.put(ticketCodeInput, detailRow);

                                // Update Table
                                for (int i = 0; i < tableModel.getRowCount(); i++) {
                                    if (tableModel.getValueAt(i, 10).equals(ticketCodeInput)) {
                                        tableModel.setValueAt(passangerNameInput, i, 0);
                                        tableModel.setValueAt(flightTimeInput, i, 7);
                                        tableModel.setValueAt(numberTicketInput, i, 8);
                                        tableModel.setValueAt(newPrice, i, 9);
                                        break;
                                    }
                                }

                                JOptionPane.showMessageDialog(null, "Row updated succesfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                                dialogUpdateRow.dispose();
                            } catch (NumberFormatException nfe) {
                                JOptionPane.showMessageDialog(null, "Number of ticket must be numeric");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Ticket code not found!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                dialogUpdateRow.setSize(400, 200);
                dialogUpdateRow.setLocationRelativeTo(null);
                dialogUpdateRow.setVisible(true);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialogDeleteRow = new JDialog((Frame) null, "Remove Row", true);
                dialogDeleteRow.setLayout(new FlowLayout());

                JLabel labelInputCode = new JLabel("Enter Ticket Code");
                JTextField fieldInputCode = new JTextField(10);
                JButton buttonRemove = new JButton("Remove");

                dialogDeleteRow.add(labelInputCode);
                dialogDeleteRow.add(fieldInputCode);
                dialogDeleteRow.add(buttonRemove);

                buttonRemove.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String ticketInput = fieldInputCode.getText().trim();

                        if (ticketInput.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Input Cannot Empty");
                            return;
                        }

                        if (bookingData.containsKey(ticketInput)) {
                            // Remove from Map
                            bookingData.remove(ticketInput);

                            // Remove from Table
                            for (int i = 0; i < tableModel.getRowCount(); i++) {
                                if (tableModel.getValueAt(i, 10).equals(ticketInput)) {
                                    tableModel.removeRow(i);
                                    break;
                                }
                            }

                            JOptionPane.showMessageDialog(null, "Row removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                            dialogDeleteRow.dispose(); // Close dialog after successful removal
                        } else {
                            JOptionPane.showMessageDialog(null, "Ticket code not found!", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                });

                dialogDeleteRow.setSize(300, 150);
                dialogDeleteRow.setLocationRelativeTo(null);
                dialogDeleteRow.setVisible(true);
            }
        });
    }

    private static double calculatePrice(String flightDay, int numTickets) {
        double pricePerTicket = 100.00; // Sample price
        if (flightDay.equals("Saturday") || flightDay.equals("Sunday")) {
            pricePerTicket *= 1.2; // Increase price by 20% on weekends
        }
        double totalPrice = pricePerTicket * numTickets;
        return totalPrice;
    }

    private static void taruhKomponen(JComponent comp, JPanel panel, int gridx, int gridy, int gridwidth, int gridheight) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel.add(comp, gbc);
    }
}
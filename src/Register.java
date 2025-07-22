import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends JFrame {
    private final String username;
    private final Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");

    public Register(String username) {
        this.username = username;

        JPanel  registerPanel = registerPage();

        CardLayout cardLayout = new CardLayout();
        JPanel panel = new JPanel();
        panel.setLayout(cardLayout);

        panel.add(registerPanel, "register");

        cardLayout.show(panel, "register");
        this.add(panel);

        setTitle("Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public JPanel registerPage() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Register Page");
        JLabel  lblEmail = new JLabel("Email"),
                lblUsername = new JLabel("Username"),
                lblPassword = new JLabel("Password"),
                lblError = new JLabel("");
        JTextField  emailField = new JTextField(15),
                usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton regisButton = new JButton("Register");

        // Center align all components
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblError.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
        emailField.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblError.setAlignmentX(Component.CENTER_ALIGNMENT);
        regisButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add vertical spacing and components
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(lblEmail);
        mainPanel.add(emailField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(lblUsername);
        mainPanel.add(usernameField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(lblPassword);
        mainPanel.add(passwordField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(lblError);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(regisButton);
        mainPanel.add(Box.createVerticalGlue());

        Dimension fieldSize = new Dimension(200, 25);

        emailField.setMaximumSize(fieldSize);
        usernameField.setMaximumSize(fieldSize);
        passwordField.setMaximumSize(fieldSize);

        panel.add(mainPanel, BorderLayout.CENTER);

        title.setFont(new Font("Tahoma", Font.BOLD, 16));

        regisButton.addActionListener(e -> {
            String  usr_email = emailField.getText(),
                    usr_username = usernameField.getText(),
                    usr_password = new String(passwordField.getPassword());
            Matcher mat = pattern.matcher(usr_email);

            if (!mat.matches()) {
                lblError.setText("Invalid Email");
                return;
            }
            if (usr_username.equals(username)) {
                lblError.setText("Username is already taken");
                return;
            }
            if (usr_password.length() < 8) {
                lblError.setText("Password must be at least 8 characters");
                return;
            }

            JOptionPane.showMessageDialog(null,
                    "Your input:\nEmail: " + usr_email + "\nUsername: " + usr_username + "\nPassword: " + usr_password,
                    "Information", JOptionPane.INFORMATION_MESSAGE);
        });

        return panel;
    }
}
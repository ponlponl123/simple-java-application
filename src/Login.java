import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private final JPanel panel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    private final String username, password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;

        JPanel  loginPanel = loginPage(),
                WelcomePanel = welcomePage();

        panel.setLayout(cardLayout);

        panel.add(loginPanel, "login");
        panel.add(WelcomePanel, "welcome");

        cardLayout.show(panel, "login");
        this.add(panel);

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public JPanel loginPage() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Login Page");
        JLabel lblUsername = new JLabel("Username");
        JLabel lblPassword = new JLabel("Password");
        JLabel lblError = new JLabel("");
        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");

        // Center align all components
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblError.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add vertical spacing and components
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(lblUsername);
        mainPanel.add(usernameField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(lblPassword);
        mainPanel.add(passwordField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(lblError);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(loginButton);
        mainPanel.add(Box.createVerticalGlue());

        Dimension fieldSize = new Dimension(200, 25);

        usernameField.setMaximumSize(fieldSize);
        passwordField.setMaximumSize(fieldSize);

        panel.add(mainPanel, BorderLayout.CENTER);

        title.setFont(new Font("Tahoma", Font.BOLD, 16));

        loginButton.addActionListener(e -> {
            String usr_username = usernameField.getText();
            String usr_password = new String(passwordField.getPassword());
            if (usr_username.equals(username) && usr_password.equals(password)) {
                switchPanel("welcome");
            } else {
                lblError.setText("Invalid username or password");
            }
        });

        return panel;
    }

    public JPanel welcomePage() {
        JPanel panel = new JPanel();
        JLabel heading = new JLabel("Welcome, " + username + "!");
        JButton logoutButton = new JButton("Logout");

        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(heading);
        panel.add(logoutButton);

        logoutButton.addActionListener(e -> {
            switchPanel("login");
        });

        return panel;
    }

    public void switchPanel(String title) {
        cardLayout.show(panel, title);
    }
}

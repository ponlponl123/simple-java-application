import java.awt.*;

public class Main {
    private static final String username = "admin", password = "admin";
    public static void main(String[] args) {
        Login login = new Login(username, password);
        Register register = new Register(username);

        centreWindow(login);
        centreWindow(register);

        Point   loginPos = login.getLocation(),
                registerPos = register.getLocation();

        login.setLocation(loginPos.x - login.getWidth(), loginPos.y);
        registerPos.setLocation(registerPos.x + register.getWidth(), registerPos.y);

        login.setVisible(true);
        register.setVisible(true);
    }

    public static void centreWindow(Window frame) {
        centreWindow(frame, 2, 2);
    }
    public static void centreWindow(Window frame, int devideX) {
        centreWindow(frame, devideX, 2);
    }
    public static void centreWindow(Window frame, int devideX, int devideY) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int     x = (int) ((dimension.getWidth() - frame.getWidth()) / devideX),
                y = (int) ((dimension.getHeight() - frame.getHeight()) / devideY);
        frame.setLocation(x, y);
    }
}
package stepik.task_4_2_7;

import java.io.FileOutputStream;

public class Task_4_2_7 {
    public static void main(String[] args) {
        RobotConnectionManager rcm = new TestRobotConnectionManager();
        moveRobot(rcm, 1,1);
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean isConnected = false;
        boolean isMoved = false;
        for (int i = 0; i < 3 && !(isConnected && isMoved); i++) {
            try (RobotConnection connection = robotConnectionManager.getConnection()) {
                isConnected = true;
                connection.moveRobotTo(toX, toY);
                isMoved = true;
            } catch (RobotConnectionException e) {
                if (i == 2) {
                    throw e;
                }
            }
        }
    }
}

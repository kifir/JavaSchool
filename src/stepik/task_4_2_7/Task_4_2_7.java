package stepik.task_4_2_7;

public class Task_4_2_7 {
    public static void main(String[] args) {
        RobotConnectionManager rcm = new TestRobotConnectionManager();
        moveRobot(rcm, 1,1);
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        try (robotConnectionManager.getConnection();){

        }
        finally {
            robotConnectionManager.clo       }
    }
}

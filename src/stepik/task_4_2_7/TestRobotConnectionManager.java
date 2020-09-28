package stepik.task_4_2_7;

public class TestRobotConnectionManager implements RobotConnectionManager {
    @Override
    public RobotConnection getConnection() {
//        throw new RobotConnectionException("Fail connection");
        return new TestRobotConnection();
    }
}

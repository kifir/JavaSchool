package stepik.task_4_2_7;

public class TestRobotConnection implements RobotConnection{
    @Override
    public void moveRobotTo(int x, int y) {
        throw new RobotConnectionException("Fail move");
    }

    @Override
    public void close() {

    }
}

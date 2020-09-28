package stepik.task_4_3_8;

import java.util.logging.*;

/**
 *  В этой задаче вам нужно реализовать метод, настраивающий параметры логирования. Конфигурирование в коде позволяет выполнить более тонкую и хитрую настройку, чем при помощи properties-файла.
 *
 * Требуется выставить такие настройки, чтобы:
 *
 * Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
 * Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
 * Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java", независимо от серьезности сообщения печатались в консоль в формате XML (*) и не передавались вышестоящим обработчикам на уровнях "org.stepic", "org" и "".
 * Не упомянутые здесь настройки изменяться не должны.
 */

public class Task_4_3_8 {
    public static void main(String[] args) {
        configureLogging();
    }

    private static void configureLogging() {
        Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
        Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB");

        loggerA.setLevel(Level.ALL);
        loggerB.setLevel(Level.WARNING);

        Logger loggerParent = Logger.getLogger("org.stepic.java");
        ConsoleHandler handlerParent = new ConsoleHandler();
        handlerParent.setLevel(Level.ALL);
        handlerParent.setFormatter(new XMLFormatter());
        loggerParent.addHandler(handlerParent);
        loggerParent.setUseParentHandlers(false);
    }
}

package stepik.task_4_3_9;

import java.util.logging.Logger;

public class Spy implements MailService {
    private Logger logger;
    private final RealMailService realMailService;

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage) {
            if (mail.getFrom() == "Austin Powers" || mail.getTo() == "Austin Powers") {
                logger.warning(
                        "Detected target mail correspondence: from " + mail.getFrom()
                                + " to " + mail.getTo()
                                + " \"" + ((MailMessage) mail).getMessage() + "\"");
            } else {
                logger.info("Usual correspondence: from " + mail.getFrom() + " to " + mail.getTo());
            }
        }

        return realMailService.processMail(mail);
    }

    public Spy(Logger logger) {
        this.logger = logger;
        this.realMailService = new RealMailService();
    }
}

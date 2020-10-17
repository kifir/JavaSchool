package stepik.task_4_3_9;

public class Thief implements MailService {
    private final int minPrice;
    private int sumStolen;
    private final RealMailService realMailService;

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage ) {
            MailPackage currentMail = (MailPackage) mail;

            if (currentMail.getContent().getPrice() >= minPrice) {
                sumStolen += currentMail.getContent().getPrice();
                Package freePackage = new Package("stones instead of " + currentMail.getContent().getContent(), 0);
                MailPackage freeMailPackage = new MailPackage(currentMail.getFrom(), currentMail.getTo(), freePackage);

                return realMailService.processMail(freeMailPackage);
            }
        }

        return realMailService.processMail(mail);
    }

    public Thief(int minPrice) {
        this.minPrice = minPrice;
        this.realMailService = new RealMailService();
    }

    public int getStolenValue() {
        return sumStolen;
    }
}

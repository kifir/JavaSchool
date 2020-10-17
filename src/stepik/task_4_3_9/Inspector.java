package stepik.task_4_3_9;

public class Inspector implements MailService {
    private final RealMailService realMailService;

    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage currentMail = (MailPackage) mail;

            if (currentMail.getContent().getContent().toLowerCase().contains(WEAPONS)
                    || currentMail.getContent().getContent().toLowerCase().contains(BANNED_SUBSTANCE)) {
                throw new IllegalPackageException();
            }

            if (currentMail.getContent().getContent().toLowerCase().contains("stones")) {
                throw new StolenPackageException();
            }
        }

        return mail;
    }

    public Inspector() {
        realMailService = new RealMailService();
    }
}



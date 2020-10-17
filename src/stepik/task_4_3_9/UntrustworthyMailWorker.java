package stepik.task_4_3_9;

public class UntrustworthyMailWorker implements MailService {
    private MailService[] mailServices;
    private final RealMailService realMailService;

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable currentSend = mail;
        for (int i = 0; i < mailServices.length; i++){
            currentSend = mailServices[i].processMail(mail);
        }
        return realMailService.processMail(currentSend);
    }

    public UntrustworthyMailWorker(MailService[] mailServices){
        this.mailServices = mailServices.clone();
        this.realMailService = new RealMailService();
    }

    public RealMailService getRealMailService() {
        return realMailService;
    }
}

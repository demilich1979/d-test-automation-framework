package diaceutics.selenium.utilities;

import com.mailosaur.MailosaurClient;
import com.mailosaur.models.Message;
import com.mailosaur.models.SearchCriteria;
import lombok.SneakyThrows;

public class MailUtil {

    private final static String APIKEY = "2HL1lqrHeuFm9Xs";
    public final static String SERVER_ID = "9ffkrhae";
    public final static String MAIL_ADDRESS_PATTERN = "%s.%s@mailosaur.io";

    public static String getLinkFromMailWithSubject(String mail, String subject) {
        Message message = getMailMessage(mail);
        return message.withSubject(subject).text().links().get(0).href();
    }

    public static boolean isMailWithSubjectExist(String mail, String subject) {
        Message message = getMailMessage(mail);
        return subject.equals(message.withSubject(subject).subject());
    }

    @SneakyThrows
    private static Message getMailMessage(String mailAddress) {
        MailosaurClient client = new MailosaurClient(APIKEY);
        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo(mailAddress);
        return client.messages().get(SERVER_ID, criteria);
    }

}

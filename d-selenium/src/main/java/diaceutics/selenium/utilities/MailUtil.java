package diaceutics.selenium.utilities;

import com.mailosaur.MailosaurClient;
import com.mailosaur.models.Message;
import com.mailosaur.models.SearchCriteria;
import diaceutics.selenium.enums.propertykeys.PropertyKeys;
import lombok.SneakyThrows;

public class MailUtil {
    private static final String MAIL_PROPERTIES = "mail.properties";
    public static final String MAIL_ADDRESS_PATTERN = "%s.%s@mailosaur.io";
    private static final String APIKEY = PropertyUtil.getProperty(PropertyKeys.API_KEY.toString(), MAIL_PROPERTIES);
    public static final String SERVER_ID = PropertyUtil.getProperty(PropertyKeys.SERVER_ID.toString(), MAIL_PROPERTIES);

    public static String getLinkFromMailWithSubject(String mail, String subject) {
        Message message = getMailMessage(mail, subject);
        return message.text().links().get(0).href();
    }

    public static boolean isMailWithSubjectExist(String mail, String subject) {
        Message message = getMailMessage(mail, subject);
        return subject.equals(message.subject());
    }

    @SneakyThrows
    private static Message getMailMessage(String mailAddress, String subject) {
        MailosaurClient client = new MailosaurClient(APIKEY);
        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo(mailAddress);
        criteria.withSubject(subject);
        return client.messages().get(SERVER_ID, criteria);
    }

}

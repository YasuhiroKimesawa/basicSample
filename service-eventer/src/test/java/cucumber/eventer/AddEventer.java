package cucumber.eventer;

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mocked;

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.EventerRepository;
import com.pilgrim_lifestyle.model.eventer.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.contact.MailAddress;
import com.pilgrim_lifestyle.model.eventer.contact.TelephoneNumber;
import com.pilgrim_lifestyle.model.eventer.profile.PersonName;
import com.pilgrim_lifestyle.model.eventer.profile.Profile;
import com.pilgrim_lifestyle.model.eventer.security.Password;
import com.pilgrim_lifestyle.model.eventer.security.Passwords;
import com.pilgrim_lifestyle.service.eventer.EventerService;

import cucumber.annotation.ja.ならば;
import cucumber.annotation.ja.もし;

public class AddEventer
{
    private Contact contact;
    private Profile profile;
    private Passwords passwords;

    private EventerService eventerService = new EventerService();

    @Mocked
    private EventerRepository eventerRepository;

    @Mocked( capture = 1 )
    private Eventer eventer;

    @もし("^: 主催者情報 名前 田中 達也 メール mail@mail.com 電話番号 (\\d+)-(\\d+)-(\\d+) パスワード (\\d+)aaaa を入力して保存する$")
    public void _主催者情報_名前_田中_達也_メール_mail_mail_com_電話番号_パスワード_aaaa_を入力して保存する(int arg1, int arg2, int arg3, int arg4) throws Throwable
    {
        PersonName personName = new PersonName( "田中", "達也" );
        TelephoneNumber telephoneNumber = new TelephoneNumber( "080-9999-1111" );
        MailAddress mailAddress = new MailAddress( "mail@mail.com" );
        Password password = new Password( "1111aaaa" );
        Password confirm = new Password( "1111aaaa" );

        profile = new Profile( personName );
        passwords = new Passwords( password, confirm );
        contact = new Contact( mailAddress, telephoneNumber );
    }

    @ならば("^: 登録完了になる$")
    public void _登録完了になる() throws Throwable
    {
        Deencapsulation.setField( eventerService, eventerRepository );
        new Expectations()
        {{
            eventerRepository.nextId(); result = 1;
            eventerRepository.add( eventer );
        }};

        eventerService.add( contact, profile, passwords );
    }

}

package features.step_definitions.registereventer

import geb.pages.dashboard.DashBoardPage
import geb.pages.eventer.RegisterPage
import geb.pages.eventer.ConfirmPage
import geb.pages.eventer.CompletionPage

this.metaClass.mixin(cucumber.runtime.groovy.JA)

前提(~'^: 登録入口ページを開く$') { ->
    to DashBoardPage
    waitFor{ at DashBoardPage }
}

前提(~'^: 主催者登録ボタンを押す$') { ->
    page.enterEventerLink.click()
    waitFor{ at RegisterPage }
}

もし(~'^: 主催者情報\\( 姓:(.+) 名:(.+) メール:(.+) 電話番号:(.+) パスワード:(.+) \\)を入力して登録確認ボタンを押す$')
{ String lastName, String firstName, String mailAddress, String telephone, String password ->
    page.lastName.value( lastName )
    page.firstName.value( firstName )
    page.mailAddress.value( mailAddress )
    page.number.value( telephone )
    page.password.value( password )
    page.confirm.value( password )

    page.buttonConfirm.click()

}

もし(~'^: 登録ボタンを押す$') { ->
    waitFor{ at ConfirmPage }
    page.buttonRegister.click()
}

ならば(~'^: 完了画面に遷移する$') { ->
    waitFor{ at CompletionPage }
}


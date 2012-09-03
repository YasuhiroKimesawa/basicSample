package features.step_definitions.login

import cucumber.runtime.PendingException
import geb.pages.dashboard.DashBoardPage
import geb.pages.eventer.RegisterPage
import geb.pages.eventer.ConfirmPage
import geb.pages.eventer.CompletionPage

this.metaClass.mixin(cucumber.runtime.groovy.JA)

前提(~'^: ダッシュボードページを開く$') { ->
    to DashBoardPage
    waitFor{ at DashBoardPage }
}

もし(~'^: 存在するログイン情報\\( メールアドレス:(.+) パスワード:(.+) \\)を入力し、ログインボタンを押す$')
{ String emailAddress, String password ->
   page.mailAddress.value( emailAddress )
   page.password.value( password )

   page.loginButton.click();
}

ならば(~'^: ログイン情報が表示される$') { ->
    waitFor{ at DashBoardPage }
    page.loginUserName.text().contains( "佐藤" )

    page.logoutButton.click()
}

package features.step_definitions.login

import cucumber.runtime.PendingException
import geb.pages.dashboard.DashBoardPage
import geb.pages.eventer.register.RegisterPage
import geb.pages.eventer.register.ConfirmPage
import geb.pages.eventer.register.CompletionPage

this.metaClass.mixin(cucumber.runtime.groovy.JA)

もし(~'^: 存在するシステム管理者ログイン情報\\( メールアドレス:(.+) パスワード:(.+) \\)を入力し、ログインボタンを押す$')
{ String emailAddress, String password ->

   page.mailAddress.value( emailAddress )
   page.password.value( password )

   page.loginButton.click();
}

ならば(~'^: システム管理者情報とログイン情報が表示される$') { ->

    waitFor{ at DashBoardPage }
    page.loginUserName.text().contains( "佐藤" )
    page.adminInfo.text().contains( "管理者" )

    page.logoutButton.click()
    waitFor{ at DashBoardPage }
}
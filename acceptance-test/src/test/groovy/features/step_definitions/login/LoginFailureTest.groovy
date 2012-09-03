package features.step_definitions.login

import cucumber.runtime.PendingException
import geb.pages.dashboard.DashBoardPage
import geb.pages.eventer.RegisterPage
import geb.pages.eventer.ConfirmPage
import geb.pages.eventer.CompletionPage

this.metaClass.mixin(cucumber.runtime.groovy.JA)


もし(~'^: 存在しないログイン情報\\( メールアドレス:(.+) パスワード:(.+) \\)を入力し、ログインボタンを押す$')
{ String emailAddress, String password ->
   page.mailAddress.value( emailAddress )
   page.password.value( password )

   page.loginButton.click();
}

ならば(~'^: ログイン失敗エラーメッセージが表示される$') { ->
    waitFor{ at DashBoardPage }
    page.loginFailureMessage.text().contains( "ユーザ名とパスワードが一致しません" )
}

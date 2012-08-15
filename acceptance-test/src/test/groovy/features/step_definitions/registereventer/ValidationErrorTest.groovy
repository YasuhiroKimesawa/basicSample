package features.step_definitions.registereventer

import geb.pages.eventer.RegisterPage

this.metaClass.mixin(cucumber.runtime.groovy.JA)

ならば(~'^: エラーメッセージが表示される$') { ->
    at RegisterPage

    page.errorMessages(2).text().contains( "メールアドレスはEメールの形式で入力して下さい。" )
}
package features.step_definitions.registereventer

import geb.pages.eventer.register.RegisterPage

this.metaClass.mixin(cucumber.runtime.groovy.JA)

ならば(~'^: エラーメッセージが表示される$') { ->
    waitFor{ at RegisterPage }

    page.errorMessages(2).text().contains( "メールアドレスはEメールの形式で入力して下さい。" )
}

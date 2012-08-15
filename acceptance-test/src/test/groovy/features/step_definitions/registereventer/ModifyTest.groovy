package features.step_definitions.registereventer

import geb.pages.eventer.RegisterPage
import geb.pages.eventer.ConfirmPage

this.metaClass.mixin(cucumber.runtime.groovy.JA)

もし(~'^: 修正ボタンを押す$') { ->
    waitFor{ at ConfirmPage }
    page.buttonModify.click()
}

ならば(~'^: 登録ページが表示される$') { ->
    waitFor{ at RegisterPage }
}
package features.step_definitions

import cucumber.runtime.PendingException
import geb.pages.dashboard.DashBoardPage

this.metaClass.mixin(cucumber.runtime.groovy.JA)

前提(~'^: 登録入口ページを開く$') { ->
    to DashBoardPage
    at DashBoardPage
}

前提(~'^: 主催者登録ボタンを押す$') { ->
    // Express the Regexp above with the code you wish you had
    throw new PendingException()
}

もし(~'^: 主催者情報 名前 田中  メール mail@mail.com 電話番号 (\\d+)-(\\d+)-(\\d+) 勤務先名 （株）勤務 パスワード (\\d+) を入力して登録確認ボタンを押す$') { int arg1, int arg2, int arg3, int arg4 ->
    // Express the Regexp above with the code you wish you had
    throw new PendingException()
}

ならば(~'^: 完了画面に遷移する$') { ->
    // Express the Regexp above with the code you wish you had
    throw new PendingException()
}

もし(~'^: 主催者情報 名前 田中  メール mail 電話番号 (\\d+)-(\\d+)-(\\d+) 勤務先名 （株）勤務 パスワード (\\d+) を入力して登録確認ボタンを押す$') { int arg1, int arg2, int arg3, int arg4 ->
    // Express the Regexp above with the code you wish you had
    throw new PendingException()
}

もし(~'^: 登録ボタンを押す$') { ->
        // Express the Regexp above with the code you wish you had
        throw new PendingException()
}

ならば(~'^: エラーメッセージが表示される$') { ->
    // Express the Regexp above with the code you wish you had
    throw new PendingException()
}

もし(~'^: 修正ボタンを押す$') { ->
    // Express the Regexp above with the code you wish you had
    throw new PendingException()
}

ならば(~'^: 登録ページが表示される$') { ->
    // Express the Regexp above with the code you wish you had
    throw new PendingException()
}

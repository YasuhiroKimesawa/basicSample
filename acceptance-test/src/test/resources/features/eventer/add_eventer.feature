# language: ja
フィーチャ: 主催者
シナリオ: 主催者を追加する
  前提 : 登録入口ページを開く
  かつ : 主催者登録ボタンを押す
  もし : 主催者情報( 姓:田中 名:太郎 メール:mail@mail.com 電話番号:080-9999-1111 パスワード:1111 )を入力して登録確認ボタンを押す
  かつ : 登録ボタンを押す
  ならば : 完了画面に遷移する

シナリオ: 主催者を追加するがバリデーションエラーになる。
  前提 : 登録入口ページを開く
  かつ : 主催者登録ボタンを押す
  もし : 主催者情報( 姓:田中 名:太郎 メール:mail 電話番号:080-9999-1111 パスワード:1111 )を入力して登録確認ボタンを押す
  ならば : エラーメッセージが表示される

シナリオ: 主催者を追加する前に修正する。
  前提 : 登録入口ページを開く
  かつ : 主催者登録ボタンを押す
  もし : 主催者情報( 姓:田中 名:太郎 メール:maila@mail.com 電話番号:080-9999-1111 パスワード:1111 )を入力して登録確認ボタンを押す
  かつ : 修正ボタンを押す
  ならば : 登録ページが表示される
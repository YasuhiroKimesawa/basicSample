<?php
/**
 * The base configurations of the WordPress.
 *
 * このファイルは、MySQL、テーブル接頭辞、秘密鍵、言語、ABSPATH の設定を含みます。
 * より詳しい情報は {@link http://wpdocs.sourceforge.jp/wp-config.php_%E3%81%AE%E7%B7%A8%E9%9B%86
 * wp-config.php の編集} を参照してください。MySQL の設定情報はホスティング先より入手できます。
 *
 * このファイルはインストール時に wp-config.php 作成ウィザードが利用します。
 * ウィザードを介さず、このファイルを "wp-config.php" という名前でコピーして直接編集し値を
 * 入力してもかまいません。
 *
 * @package WordPress
 */

// 注意:
// Windows の "メモ帳" でこのファイルを編集しないでください !
// 問題なく使えるテキストエディタ
// (http://wpdocs.sourceforge.jp/Codex:%E8%AB%87%E8%A9%B1%E5%AE%A4 参照)
// を使用し、必ず UTF-8 の BOM なし (UTF-8N) で保存してください。

// ** MySQL 設定 - こちらの情報はホスティング先から入手してください。 ** //
/** WordPress のためのデータベース名 */
define('DB_NAME', 'wordpress');

/** MySQL データベースのユーザー名 */
define('DB_USER', 'wordpress');

/** MySQL データベースのパスワード */
define('DB_PASSWORD', 'wordpress');

/** MySQL のホスト名 */
define('DB_HOST', 'localhost');

/** データベースのテーブルを作成する際のデータベースのキャラクターセット */
define('DB_CHARSET', 'utf8');

/** データベースの照合順序 (ほとんどの場合変更する必要はありません) */
define('DB_COLLATE', '');

/**#@+
 * 認証用ユニークキー
 *
 * それぞれを異なるユニーク (一意) な文字列に変更してください。
 * {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org の秘密鍵サービス} で自動生成することもできます。
 * 後でいつでも変更して、既存のすべての cookie を無効にできます。これにより、すべてのユーザーを強制的に再ログインさせることになります。
 *
 * @since 2.6.0
 */
define('AUTH_KEY',         'cdA%, l{Q~nu/um*Mnuz)=Yt$>@tNxOjLhBb|fb:Mz:OQkX:vnIur5gw(r*P={}=');
define('SECURE_AUTH_KEY',  ',[flm<lV5cRe]MG4YB^tYk-M>Sh<]&yZ#D!ioxT?;cQ^0l~Rq h,#tKK>}A_W]W.');
define('LOGGED_IN_KEY',    ')A()IFGd-@T&G#07,u?(0w2x9dn`8ASwX= }Q0}/1!D;N?);A(+E!YcJ2??|[RP:');
define('NONCE_KEY',        'gRUiWV1_i/_wTY$yFa.Y0V0XYq-SUYCx.lV}naM,K|j]]&~R4ZpD7dQX8gXDdz7<');
define('AUTH_SALT',        'Z._LJO?_-cK=WdAAGdQh{ov$]`A0R61dv3pBvU}O*Di= uR?Ln.=hwY#SR1_:G:H');
define('SECURE_AUTH_SALT', 'h/LYE139t*2I>pr]LJg~l@A1E4W;nCS+^[DbNhNGR0*2~,W2)hV? r9+-Gu@]D(_');
define('LOGGED_IN_SALT',   'QfDT?;+2%zk6hg`iv=&?BXp$|qKq[X*;1Yp <1_;0`:O-gJ6aNv7iOKk}2jc@eK1');
define('NONCE_SALT',       'n[*u,5~t7V98~HV1z9:/86U7J+f&$U)gZ-O($ Q8$xV50%&9qtXi=D|@P:0VWy#=');

/**#@-*/

/**
 * WordPress データベーステーブルの接頭辞
 *
 * それぞれにユニーク (一意) な接頭辞を与えることで一つのデータベースに複数の WordPress を
 * インストールすることができます。半角英数字と下線のみを使用してください。
 */
$table_prefix  = 'wp_';

/**
 * ローカル言語 - このパッケージでは初期値として 'ja' (日本語 UTF-8) が設定されています。
 *
 * WordPress のローカル言語を設定します。設定した言語に対応する MO ファイルが
 * wp-content/languages にインストールされている必要があります。例えば de_DE.mo を
 * wp-content/languages にインストールし WPLANG を 'de_DE' に設定することでドイツ語がサポートされます。
 */
define('WPLANG', 'ja');

/**
 * 開発者へ: WordPress デバッグモード
 *
 * この値を true にすると、開発中に注意 (notice) を表示します。
 * テーマおよびプラグインの開発者には、その開発環境においてこの WP_DEBUG を使用することを強く推奨します。
 */
define('WP_DEBUG', false);

/* 編集が必要なのはここまでです ! WordPress でブログをお楽しみください。 */

/** Absolute path to the WordPress directory. */
if ( !defined('ABSPATH') )
	define('ABSPATH', dirname(__FILE__) . '/');

/** Sets up WordPress vars and included files. */
require_once(ABSPATH . 'wp-settings.php');

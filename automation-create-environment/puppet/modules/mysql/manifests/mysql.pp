
$mysql_password = "myT0pS3cretPa55worD"

class mysql
{
    include mysql::install, mysql::config, mysql::service
}

class mysql::install
{
     package
	{
	  mysql-server:
        ensure => installed
    }
}

class mysql::config
{
	file
	{
	  "/etc/my.cnf":
        owner => "root",
        group => "root",
        mode  => "660",
        content  => template("mysql/my.cnf"),
	    subscribe => Package['mysql-server']
    }


    exec
    {
      "set-mysql-password":
      unless => "mysqladmin -uroot -p$mysql_password status",
      path => ["/bin", "/usr/bin"],
      command => "mysqladmin -uroot password $mysql_password",
      require => Service["mysqld"],
    }
}

class mysql::service
{
	service
    {
	  'mysqld':
        ensure => 'running',
        enable => true,
        hasrestart => true,
        hasstatus => true,
        subscribe => Package['mysql-server'],
    }
}

define mysqldb( $user, $password )
{
      exec
      {
        "create-${name}-db":
        	unless => "/usr/bin/mysql -uroot -p$mysql_password ${name}",
       		command => "/usr/bin/mysql -uroot -p$mysql_password -e \"create database ${name};\"",
        	require => [Service["mysqld"], Exec["set-mysql-password"]],
      }

      exec
      {
      	"grant-${name}-db":
        	unless => "/usr/bin/mysql -u${user} -p${password} ${name}",
        	command => "/usr/bin/mysql -uroot -p$mysql_password -e \"grant all on ${name}.* to ${user}@localhost identified by '$password';\"",
        	require => [Service["mysqld"], Exec["create-${name}-db"], Exec["set-mysql-password"]]
      }
}


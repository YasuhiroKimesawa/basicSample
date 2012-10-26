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

    $mysql_password = "myT0pS3cretPa55worD"
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


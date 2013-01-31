import "../../mysql/manifests/*"
import "../../nginx/manifests/*"

class wordpress
{
    include wordpress::download, wordpress::setup
}

class wordpress::download
{
	exec
    {
      "download-wordpress":
         command => "/usr/bin/wget -nc http://ja.wordpress.org/wordpress-3.4.2-ja.tar.gz",
         timeout => 0,
         logoutput => "on_failure",
         creates => "/usr/share/nginx/html/index.php",
         require => Package["nginx"],
	}

	exec
    {
      "deploy-wordpress":
         command => "tar vxfz ./wordpress-3.4.2-ja.tar.gz; cp -R ./wordpress/* /usr/share/nginx/html/; rm -rf ./wordpress-3.4.2-ja.tar.gz ./wordpress",
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         logoutput => "on_failure",
         require => Exec["download-wordpress"],
         creates => "/usr/share/nginx/html/index.php",
	}

	file
	{
	  "/usr/share/nginx/html/wp-config.php":
        owner => "root",
        group => "root",
        mode  => "777",
        require => Exec["deploy-wordpress"],
        content => template("/etc/puppet/modules/wordpress/templates/wp-config.php ")
    }
}

class wordpress::setup
{
	$wordpress_dbuser="wordpress"
	$wordpress_dbpassword="wordpress"

  	mysqldb
  	{
  	  "wordpress":
  	  	user => $wordpress_dbuser,
  	  	password => $wordpress_dbpassword,
  	  	require => Service["mysqld"],
  	}
}
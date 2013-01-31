import "../../files/manifests/*"

class nginx
{
    include nginx::install, nginx::config, nginx::service
}

class nginx::install
{
    package
	{
	  nginx:
        ensure => installed,
        require => File["/etc/yum.repos.d/remi.repo"]
    }

    package
	{
	  php-fpm:
        ensure => installed,
        require => File["/etc/yum.repos.d/remi.repo"]
    }
}

class nginx::config
{
    file
	{
	  "/etc/nginx/nginx.conf":
        owner => "root",
        group => "root",
        mode  => "777",
        require => [Package["nginx"], Package["php-fpm"]],
        content => template("/etc/puppet/modules/nginx/templates/nginx.conf")
    }

    file
	{
	  "/etc/nginx/conf.d/default.conf":
        owner => "root",
        group => "root",
        mode  => "777",
        require => [Package["nginx"], Package["php-fpm"]],
        content => template("/etc/puppet/modules/nginx/templates/default.conf")
    }
}

class nginx::service
{
    service
	{
	  nginx:
        enable => true,
        ensure => 'running',
        require => [File["/etc/nginx/nginx.conf"], Service["httpd"]]
    }

    service
	{
	  php-fpm:
        enable => true,
        ensure => 'running',
        require => [File["/etc/nginx/conf.d/default.conf"], Service["httpd"]]
    }

    service
	{
	  httpd:
        enable => true,
        ensure => 'stopped',
        require => File["/etc/nginx/conf.d/default.conf"]
    }
}

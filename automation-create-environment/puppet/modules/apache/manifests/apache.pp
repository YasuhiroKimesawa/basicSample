import "../../php/manifests/*"

class apache
{
    include apache::install, apache::config, apache::service
}

class apache::install
{
    package
	{
	  httpd:
        ensure => installed,
        require => Class['php']
    }
}

class apache::config
{
    file
	{
	  "/etc/httpd/conf/httpd.conf":
        owner => "root",
        group => "root",
        mode  => "777",
        require => Package["httpd"],
        content => template("/etc/puppet/modules/apache/templates/httpd.conf")
    }
}

class apache::service
{
    service
	{
	  httpd:
        enable => true,
        ensure => running,
        require => Package["httpd"]
    }
}

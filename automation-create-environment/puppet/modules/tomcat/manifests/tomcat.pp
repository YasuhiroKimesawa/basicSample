import "../../files/manifests/*"
import "../../openjdk/manifests/*"

class tomcat
{
    include tomcat::install, tomcat::config, tomcat::service

	require files, openjdk
}

class tomcat::install
{
    package
	{
	  tomcat6:
        ensure => installed
    }
    package
	{
	  tomcat6-webapps:
        ensure => installed
    }
    package
	{
	  tomcat6-admin-webapps:
        ensure => installed
    }
}

class tomcat::config
{
    file
	{
	  "/var/lib/tomcat6/webapps":
        owner => "root",
        group => "tomcat",
        mode  => "777",
        require => Package["tomcat6"],
    }

	file
	{
	  "/usr/share/tomcat6/conf/context.xml":
        owner => "root",
        group => "tomcat",
        mode  => "777",
        require => Package["tomcat6"],
    }

	file
	{
	  "/usr/share/tomcat6/conf/catalina.properties":
        owner => "root",
        group => "tomcat",
        mode  => "777",
        require => Package["tomcat6"],
    }

	file
	{
	  "/usr/share/tomcat6/shared-lib":
		ensure => directory,
        owner => "root",
        group => "tomcat",
        mode  => "777",
        require => Package["tomcat6"],
    }

	file
	{
	  "/usr/share/tomcat6/shared-lib/conf":
		ensure => directory,
        owner => "root",
        group => "tomcat",
        mode  => "777",
        require => Package["tomcat6"],
    }

	file
	{
	  "/etc/tomcat6/tomcat-users.xml":
        owner => "root",
        group => "tomcat",
        mode  => "664",
        content => template("/etc/puppet/modules/tomcat/templates/tomcat-users.xml"),
        require => Package["tomcat6"],
    }
}

class tomcat::service
{
    service
	{
	  tomcat6:
        enable => true,
        ensure => running,
        require => [ Package["tomcat6"], Package["tomcat6-webapps"], Package["tomcat6-admin-webapps"] ]
    }
}

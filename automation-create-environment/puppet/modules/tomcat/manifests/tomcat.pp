import "../../files/manifests/*"
import "../../openjdk/manifests/*"

$server_name = $virtual ?
{
    virtualbox => 'serversman',
    openvzve => 'serversman',
    default => 'sampleproject',
}

class tomcat
{
    include tomcat::install, tomcat::config, tomcat::service
}

class tomcat::install
{
    require files, openjdk

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
        content  => template("/etc/puppet/modules/tomcat/templates/$server_name/context.xml"),
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
	  "/usr/share/tomcat6/conf/tomcat-users.xml":
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
        require => [ Package["tomcat6"],
                     Package["tomcat6-webapps"],
                     Package["tomcat6-admin-webapps"]
                   ]
    }
}

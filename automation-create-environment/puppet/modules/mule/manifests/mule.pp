import "../../files/manifests/*"

class mule 
{
    include mule::install, mule::config, mule::service
}

class mule::install 
{
     package 
	{ 
	  mule:
        ensure => installed,
       require => Class['files']
    }
}

class mule::config 
{
    file 
	{ 
	  "/usr/local/mule/apps":
        owner => "root",
        group => "root",
        mode  => "777"
    }
    
	file 
	{ 
	  "/usr/local/mule/conf":
        owner => "root",
        group => "root",
        mode  => "777"
    }
    
	file 
	{ 
	  "/usr/local/mule/lib/user":
        owner => "root",
        group => "root",
        mode  => "777"
    }
}

class mule::service 
{
}


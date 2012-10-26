import "../../files/manifests/*"

class james 
{
    include james::install, james::config, james::service
}



class james::install 
{
    package 
	{ 
	  james:
        ensure => installed,
        require => Class['files']
    }
}

class james::config 
{
    file 
	{ 
	  "/usr/local/james/conf":
        owner => "root",
        group => "root",
        mode  => "777"
    }

    file 
	{ 
	  "/usr/local/james/conf/lib":
        owner => "root",
        group => "root",
        mode  => "777"
    }

    file 
	{ 
	  "/usr/local/james/conf/META-INF":
        owner => "root",
        group => "root",
        mode  => "777"
    }
    
	file 
	{ 
	  "/usr/local/james/conf/META-INF/org/apache/james":
        owner => "root",
        group => "root",
        mode  => "777"
    }
    
	file 
	{ 
	  "/usr/local/james/conf/META-INF/spring":
        owner => "root",
        group => "root",
        mode  => "777"
    }
}

class james::service 
{
}
class localtime 
{
    include localtime::install, localtime::config, localtime::service
}

class localtime::install 
{
    package 
	{ 
	  tzdata:
        ensure => installed
    }
}

class localtime::config 
{
    file 
	{ 
	  "/etc/localtime":
        ensure => "/usr/share/zoneinfo/Japan"
    }
}

class localtime::service 
{
}


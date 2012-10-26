class ant 
{
    include ant::install, ant::config, ant::service
}


class ant::install 
{
    package 
	{ 
	  ant:
        ensure => installed 
    }
}

class ant::config 
{
}

class ant::service 
{
}

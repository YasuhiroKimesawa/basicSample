import "../../files/manifests/*"

class h2database 
{
    include h2database::install, h2database::config, h2database::service
}

class h2database::install 
{
    package 
	{ 
	  h2:
        ensure => installed ,
        require => Class['files']
    }
}

class h2database::config 
{
}

class h2database::service 
{
}



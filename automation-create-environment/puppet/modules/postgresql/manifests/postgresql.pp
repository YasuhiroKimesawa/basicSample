class postgresql
{
    include postgresql::install, postgresql::config, postgresql::service
}

class postgresql::install 
{
     package 
	{ 
	  postgresql-server:
        ensure => installed
    }
}

class postgresql::config 
{

}

class postgresql::service 
{
	service 
    { 
	  'postgresql':
        ensure => 'running',
        enable => true,
        hasrestart => true,
        hasstatus => true,
        subscribe => Package['postgresql-server'],
    }
}


class php
{
    include php::install, php::config, php::service
}

class php::install
{
    package
	{
	  php:
        ensure => installed
    }

	package
	{
	  php-mbstring:
        ensure => installed
    }

	package
	{
	  php-mysql:
        ensure => installed
    }
}

class php::config
{
}

class php::service
{
}


class postfix
{
    include postfix::install, postfix::config, postfix::service
}

class postfix::install 
{
     package 
	{ 
	  postfix:
        ensure => installed
    }

    package
    {
      dovecot:
        ensure => installed
    }
}

class postfix::config 
{

}

class postfix::service 
{
}


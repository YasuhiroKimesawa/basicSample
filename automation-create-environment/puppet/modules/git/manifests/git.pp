class git 
{
    include git::install, git::config, git::service
}

class git::install 
{
    package 
	{ 
	  git:
        ensure => installed ,
    }
}

class git::config 
{
}

class git::service 
{
}



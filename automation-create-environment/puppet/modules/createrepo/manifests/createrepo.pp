class createrepo
{
    include createrepo::install
}

class createrepo::install
{
    package
	{
	  createrepo:
        ensure => installed
    }
}

class createrepo::htppdfolder
{
	file
	{
	  "/var/www/html/yumserver":
		ensure => directory,
        owner => "root",
        group => "root",
        mode  => "777",
        require => Package["createrepo"],
    }
}

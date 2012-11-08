import "./*"

class serversman-git
{
	include serversman-git::sampleproject
}

class serversman-git::sampleproject
{
	file
	{
	  "/usr/local/myproject":
		ensure => directory,
        owner => "root",
        group => "root",
        mode  => "777",
        require => Package["git"],
    }

	file
	{
	  "/usr/local/myproject/basic-sample":
		ensure => directory,
        owner => "root",
        group => "root",
        mode  => "777",
        require => [Package["git"], File["/usr/local/myproject"]],
    }

    file
	{
	  "/usr/local/myproject/basic-sample/basicSample.git":
		ensure => directory,
        owner => "root",
        group => "root",
        mode  => "777",
        require => [Package["git"], File["/usr/local/myproject/basic-sample"]],
    }


	exec
    {
      "create-sampleproject-git":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "git init --bare --shared=true",
         require => File["/usr/local/myproject/basic-sample/basicSample.git"],
         creates => "/usr/local/myproject/basic-sample/basicSample.git/HEAD",
         cwd => "/usr/local/myproject/basic-sample/basicSample.git",
	}

	file
	{
	  "/usr/local/myproject/basic-sample/basicSample.git/hooks/update":
        owner => "root",
        group => "root",
        mode  => "777",
        require => Exec["create-sampleproject-git"],
        content => template("/etc/puppet/modules/git/templates/serversman/update"),
    }

}
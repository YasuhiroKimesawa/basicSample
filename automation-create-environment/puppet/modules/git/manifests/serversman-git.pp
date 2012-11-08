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
        require => Package["git"],
    }


	exec
    {
      "create-sampleproject-git":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "git init --bare --shared=true",
         require => File["/usr/local/myproject/basic-sample"],
         creates => "/usr/local/myproject/basic-sample/basicsample.git",
         cwd => "/usr/local/myproject/basic-sample",
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
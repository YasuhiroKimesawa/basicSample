class files
{
	include files::config
}

class files::config
{
	#file
	#{
	#  "/etc/yum.repos.d/pilgrim.lifestyle.com.repo":
    #    owner => "root",
    #    group => "root",
    #    mode  => "777",
    #    content  => template("/etc/puppet/modules/files/templates/pilgrim.lifestyle.com.repo")
    #}

	file
	{
	  "/etc/yum.repos.d/jpackage50.repo":
        owner => "root",
        group => "root",
        mode  => "777",
        content  => template("/etc/puppet/modules/files/templates/jpackage50.repo")
    }

    exec
    {
      "epel":
    	 path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "rpm -Uvh  http://ftp-srv2.kddilabs.jp/Linux/distributions/fedora/epel/6/x86_64/epel-release-6-8.noarch.rpm;",
    	 creates => "/etc/yum.repos.d/epel.repo",
    }

    exec
    {
      "remi":
    	 path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "rpm -Uvh http://rpms.famillecollet.com/enterprise/remi-release-6.rpm;",
         require => Exec['epel'],
         creates => "/etc/yum.repos.d/remi.repo",
    }

    file
    {
	   "/etc/yum.repos.d/remi.repo":
        owner => "root",
        group => "root",
        mode  => "777",
        content  => template("/etc/puppet/modules/files/templates/remi.repo"),
        require => Exec['remi']
    }
}
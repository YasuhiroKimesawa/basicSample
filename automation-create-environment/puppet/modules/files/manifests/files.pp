class files
{
	include files::config
}

class files::config
{
	file
	{
	  "/etc/yum.repos.d/pilgrim.lifestyle.com.repo":
        owner => "root",
        group => "root",
        mode  => "777",
        content  => template("/etc/puppet/modules/files/templates/pilgrim.lifestyle.com.repo")
    }

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
         command => "rpm --import http://ftp.riken.jp/Linux/fedora/epel/RPM-GPG-KEY-EPEL-6;
                     rpm -ivh http://ftp.riken.jp/Linux/fedora/epel/6/x86_64/epel-release-6-7.noarch.rpm",
         creates => "/etc/yum.repos.d/epel.repo"
    }
}
import "./*"
import "../../createrepo/manifests/*"

class activemqyum
{
    include activemqyum::download, activemqyum::rpmbuildCopy, activemqyum::createYum
}

class activemqyum::yum
{
	file
	{
	  "/var/www/html/activemq/5/noarch":
        ensure => directory,
        owner => "root",
        group => "root",
        mode  => "777",
    }
}

class activemqyum::rpmbuildCopy
{
	exec
    {
      "rpmbuildCopy":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "cp -f /home/vagrant/rpmbuild/RPMS/noarch/activemq-5.7.0-1.noarch.rpm /var/www/html/activemq/5/noarch/activemq-5.7.0-1.noarch.rpm",
         require => File["/var/www/html/activemq/5/noarch"],
         creates => "/var/www/html/activemq/5/noarch/activemq-5.7.0-1.noarch.rpm"
	}
}

class activemqyum::createYum
{
	exec
	{
	  "createYum":
        path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "createrepo /var/www/html/activemq/5/noarch/",
         creates => "/var/www/html/activemq/5/noarch/repodata",
         require => Package["createrepo"],
    }
}


import "./*"
import "../../createrepo/manifests/*"

$acticemq_folder=[ "/var/www/html/activemq/", "/var/www/html/activemq/5", "/var/www/html/activemq/5/noarch"]

class activemqyum
{
    include activemqyum::yum, activemqyum::rpmbuildCopy, activemqyum::createYum
}

class activemqyum::yum
{
	file
	{
	  $acticemq_folder:
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
         require => File[$acticemq_folder],
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
         require => [Package["createrepo"],File["/var/www/html/activemq/5/noarch"]],
    }
}


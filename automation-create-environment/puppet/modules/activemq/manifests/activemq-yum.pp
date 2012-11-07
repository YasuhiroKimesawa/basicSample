import "./*"
import "../../createrepo/manifests/*"
import "../../apache/manifests/*"

$activemqyum_folder=[ "/var/www/html/yumserver/activemq/", "/var/www/html/yumserver/activemq/5", "/var/www/html/yumserver/activemq/5/noarch"]

class activemqyum
{
    include activemqyum::yum, activemqyum::rpmbuildCopy, activemqyum::createYum
}

class activemqyum::yum
{
	file
	{
	  $activemqyum_folder:
        ensure => directory,
        owner => "root",
        group => "root",
        mode  => "777",
        require => [Package["httpd"], File["/var/www/html/yumserver"]],
    }
}

class activemqyum::rpmbuildCopy
{
	exec
    {
      "activeMqRpmbuildCopy":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "cp -f /home/vagrant/rpmbuild/RPMS/noarch/activemq-5.7.0-1.noarch.rpm /var/www/html/yumserver/activemq/5/noarch/activemq-5.7.0-1.noarch.rpm",
         require => [File[$activemqyum_folder], Exec["rpmbuild-activemq"]],
         creates => "/var/www/html/yumserver/activemq/5/noarch/activemq-5.7.0-1.noarch.rpm"
	}
}

class activemqyum::createYum
{
	exec
	{
	  "createActiveMqYum":
        path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "createrepo /var/www/html/yumserver/activemq/5/noarch/",
         creates => "/var/www/html/yumserver/activemq/5/noarch/repodata",
         require => [Package["createrepo"], File["/var/www/html/yumserver/activemq/5/noarch"]],
    }
}


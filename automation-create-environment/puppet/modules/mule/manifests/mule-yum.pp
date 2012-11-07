import "./*"
import "../../createrepo/manifests/*"
import "../../apache/manifests/*"

$muleyum_folder=[ "/var/www/html/yumserver/mule/", "/var/www/html/yumserver/mule/3", "/var/www/html/yumserver/mule/3/noarch"]

class muleyum
{
    include muleyum::yum, muleyum::rpmbuildCopy, muleyum::createYum
}

class muleyum::yum
{
	file
	{
	  $muleyum_folder:
        ensure => directory,
        owner => "root",
        group => "root",
        mode  => "777",
        require => [Package["httpd"], File["/var/www/html/yumserver"]],
    }
}

class muleyum::rpmbuildCopy
{
	exec
    {
      "MuleRpmbuildCopy":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "cp -f /home/vagrant/rpmbuild/RPMS/noarch/mule-3.3.0-1.noarch.rpm /var/www/html/yumserver/mule/3/noarch/mule-3.3.0-1.noarch.rpm",
         require => [File[$muleyum_folder], Exec["rpmbuild-mule"]],
         creates => "/var/www/html/yumserver/mule/3/noarch/mule-3.3.0-1.noarch.rpm"
	}
}

class muleyum::createYum
{
	exec
	{
	  "createMuleYum":
        path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "createrepo /var/www/html/yumserver/mule/3/noarch/",
         creates => "/var/www/html/mule/3/noarch/repodata",
         require => [Package["createrepo"], File["/var/www/html/yumserver/mule/3/noarch"]],
    }
}


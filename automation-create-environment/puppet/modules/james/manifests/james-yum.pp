import "./*"
import "../../createrepo/manifests/*"
import "../../apache/manifests/*"

$jamesyum_folder=[ "/var/www/html/yumserver/james/", "/var/www/html/yumserver/james/3", "/var/www/html/yumserver/james/3/noarch"]

class jamesyum
{
    include jamesyum::yum, jamesyum::rpmbuildCopy, jamesyum::createYum
}

class jamesyum::yum
{
	file
	{
	  $jamesyum_folder:
        ensure => directory,
        owner => "root",
        group => "root",
        mode  => "777",
        require => [Package["httpd"], File["/var/www/html/yumserver"]],
    }
}

class jamesyum::rpmbuildCopy
{
	exec
    {
      "jamesRpmbuildCopy":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "cp -f /home/vagrant/rpmbuild/RPMS/noarch/james-3.0-beta4.noarch.rpm /var/www/html/yumserver/james/3/noarch/james-3.0-beta4.noarch.rpm",
         require => [File[$jamesyum_folder], Exec["rpmbuild-james"]],
         creates => "/var/www/html/yumserver/james/3/noarch/james-3.0-beta4.noarch.rpm"
	}
}

class jamesyum::createYum
{
	exec
	{
	  "createJamesYum":
        path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "createrepo /var/www/html/yumserver/james/3/noarch/",
         creates => "/var/www/html/yumserver/james/3/noarch/repodata",
         require => [Package["createrepo"], File["/var/www/html/yumserver/james/3/noarch"]],
    }
}


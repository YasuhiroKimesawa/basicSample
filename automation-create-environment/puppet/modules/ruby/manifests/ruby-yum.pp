import "./*"
import "../../createrepo/manifests/*"
import "../../apache/manifests/*"

$rubyyum_folder=[ "/var/www/html/yumserver/ruby/", "/var/www/html/yumserver/ruby/1", "/var/www/html/yumserver/ruby/1/x86_64/"]

class rubyyum
{
    include rubyyum::yum, rubyyum::rpmbuildCopy, rubyyum::createYum
}

class rubyyum::yum
{
	file
	{
	  $rubyyum_folder:
        ensure => directory,
        owner => "root",
        group => "root",
        mode  => "777",
        require => [Package["httpd"], File["/var/www/html/yumserver"]],
    }
}

class rubyyum::rpmbuildCopy
{
	exec
    {
      "RubyRpmbuildCopy":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "cp -f /home/vagrant/rpmbuild/RPMS/x86_64/ruby-1.9.3p286-2.el6.x86_64.rpm /var/www/html/yumserver/ruby/1/x86_64/ruby-1.9.3p286-2.el6.x86_64.rpm",
         require => [File[$rubyyum_folder], Exec["rpmbuild-ruby"]],
         creates => "/var/www/html/yumserver/ruby/1/x86_64/ruby-1.9.3p286-2.el6.x86_64.rpm"
	}
}

class rubyyum::createYum
{
	exec
	{
	  "createRubyYum":
        path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "createrepo /var/www/html/yumserver/ruby/1/x86_64/",
         creates => "/var/www/html/yumserver/ruby/1/x86_64/repodata",
         require => [Package["createrepo"], File["/var/www/html/yumserver/ruby/1/x86_64"]],
    }
}


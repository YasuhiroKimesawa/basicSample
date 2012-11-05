import "../../rpmbuild/manifests/*"
import "../../files/manifests/*"

class rubyrpm
{
    include rubyrpm::dependencies, rubyrpm::download, rubyrpm::createRPM
}

class rubyrpm::dependencies
{
    package
    {
       zlib-devel:
         ensure => installed,
	}

	package
    {
       openssl-devel:
         ensure => installed,
	}

	package
    {
       readline-devel:
         ensure => installed,
	}

	package
    {
       ncurses-devel:
         ensure => installed,
	}

	package
    {
       gdbm-devel:
         ensure => installed,
	}

	package
    {
       db4-devel:
         ensure => installed,
	}

	package
    {
       libffi-devel:
         ensure => installed,
	}

	package
    {
       tk-devel:
         ensure => installed,
	}

	package
    {
       libyaml-devel:
         ensure => installed,
         require => Exec["epel"],
	}

	package
    {
       byacc:
         ensure => installed,
	}
}


class rubyrpm::download
{
    exec
    {
      "download-ruby":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "wget -nc -P /home/vagrant/rpmbuild/SOURCES ftp://ftp.ruby-lang.org/pub/ruby/1.9/ruby-1.9.3-p286.tar.gz",
         require => File["/home/vagrant/rpmbuild/SOURCES"],
	}

	file
	{
	  "/home/vagrant/rpmbuild/SOURCES/apache-ruby-3.0-beta4-app.tar.gz":
        owner => "vagrant",
        group => "vagrant",
        mode  => "777",
        require => Exec["download-ruby"],
    }
}

class rubyrpm::createRPM
{
	file
	{
	  "/home/vagrant/rpmbuild/SPECS/ruby.spec":
        owner => "vagrant",
        group => "vagrant",
        mode  => "777",
        require => File["/home/vagrant/rpmbuild/SPECS"],
        content => template("/etc/puppet/modules/ruby/templates/ruby.spec")
    }

	exec
    {
      "rpmbuild-ruby":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "rpmbuild -bb SPECS/ruby.spec",
         require => [File["/home/vagrant/rpmbuild/SPECS/ruby.spec"],
                     Package["zlib-devel"],
                     Package["openssl-devel"],
                     Package["readline-devel"],
                     Package["ncurses-devel"],
                     Package["gdbm-devel"],
                     Package["db4-devel"],
                     Package["libffi-devel"],
                     Package["tk-devel"],
                     Package["libyaml-devel"]],
         user => "vagrant",
         cwd => "/home/vagrant/rpmbuild",
         logoutput => "on_failure",
         environment =>"HOME=/home/vagrant",
         timeout => 0,
	}
}


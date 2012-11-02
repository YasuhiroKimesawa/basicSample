import "../../rpmbuild/manifests/*"

class rubyrpm
{
    include rubyrpm::download, rubyrpm::createRPM
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
         require => File["/home/vagrant/rpmbuild/SPECS/ruby.spec"],
         user => "vagrant",
         cwd => "/home/vagrant/rpmbuild",
         logoutput => "on_failure",
         environment =>"HOME=/home/vagrant"
	}
}


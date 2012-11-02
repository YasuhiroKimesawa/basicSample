import "../../rpmbuild/manifests/*"

class jamesrpm
{
    include jamesrpm::download, jamesrpm::createSource, jamesrpm::createRPM
}

class jamesrpm::download
{
    exec
    {
      "download-james":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "wget -nc -P /home/vagrant/rpmbuild/SOURCES http://ftp.meisei-u.ac.jp/mirror/apache/dist/james/apache-james/3.0beta4/apache-james-3.0-beta4-app.tar.gz",
         require => File["/home/vagrant/rpmbuild/SOURCES"],
	}

	file
	{
	  "/home/vagrant/rpmbuild/SOURCES/apache-james-3.0-beta4-app.tar.gz":
        owner => "vagrant",
        group => "vagrant",
        mode  => "777",
        require => Exec["download-james"],
    }
}

class jamesrpm::createSource
{
	exec
    {
      "decompression-james":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "tar xzvf /home/vagrant/rpmbuild/SOURCES/apache-james-3.0-beta4-app.tar.gz -C /home/vagrant/rpmbuild/SOURCES/; chown -R vagrant /home/vagrant/rpmbuild/SOURCES/apache-james-3.0-beta4/;rm -rf /home/vagrant/rpmbuild/SOURCES/apache-james-3.0-beta4-app.tar.gz",
         require => [Exec["download-james"], File["/home/vagrant/rpmbuild/BUILD"]],
         creates => "/home/vagrant/rpmbuild/SOURCES/apache-james-3.0-beta4"
	}

	file
	{
	  "/home/vagrant/rpmbuild/SOURCES/apache-james-3.0-beta4/james":
        owner => "root",
        group => "root",
        mode  => "777",
        require => Exec["decompression-james"],
        content => template("/etc/puppet/modules/james/templates/james")
    }

    exec
    {
      "compression-james":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "tar czvf apache-james-3.0-beta4-app.tar.gz apache-james-3.0-beta4;rm -rf /home/vagrant/rpmbuild/SOURCES/apache-james-3.0-beta4",
         require => File["/home/vagrant/rpmbuild/SOURCES/apache-james-3.0-beta4/james"],
         cwd => "/home/vagrant/rpmbuild/SOURCES"
	}


}

class jamesrpm::createRPM
{
	file
	{
	  "/home/vagrant/rpmbuild/SPECS/james.spec":
        owner => "vagrant",
        group => "vagrant",
        mode  => "777",
        require => File["/home/vagrant/rpmbuild/SPECS"],
        content => template("/etc/puppet/modules/james/templates/james.spec")
    }

	exec
    {
      "rpmbuild-james":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "rpmbuild -bb SPECS/james.spec",
         require => Exec["compression-james"],
         creates => "/home/vagrant/rpmbuild/RPMS/apache-james-3.0-beta4",
         user => "vagrant",
         cwd => "/home/vagrant/rpmbuild",
         logoutput => "on_failure",
         environment =>"HOME=/home/vagrant"
	}
}


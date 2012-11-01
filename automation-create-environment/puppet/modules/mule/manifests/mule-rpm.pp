import "../../rpmbuild/manifests/*"

class mulerpm
{
    include mulerpm::download, mulerpm::createSource, mulerpm::createRPM
}

class mulerpm::download
{
    exec
    {
      "download-mule":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "wget -nc -P /home/vagrant/rpmbuild/SOURCES http://dist.codehaus.org/mule/distributions/mule-standalone-3.3.0.tar.gz",
         require => File["/home/vagrant/rpmbuild/SOURCES"],
	}

	file
	{
	  "/home/vagrant/rpmbuild/SOURCES/mule-standalone-3.3.0.tar.gz":
        owner => "vagrant",
        group => "vagrant",
        mode  => "777",
        require => Exec["download-mule"],
    }
}

class mulerpm::createSource
{
	exec
    {
      "decompression-mule":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "tar xzvf /home/vagrant/rpmbuild/SOURCES/mule-standalone-3.3.0.tar.gz -C /home/vagrant/rpmbuild/SOURCES/; chown -R vagrant /home/vagrant/rpmbuild/SOURCES/mule-standalone-3.3.0/;rm -rf /home/vagrant/rpmbuild/SOURCES/mule-standalone-3.3.0.tar.gz",
         require => [Exec["download-mule"], File["/home/vagrant/rpmbuild/BUILD"]],
         creates => "/home/vagrant/rpmbuild/SOURCES/mule-standalone-3.3.0"
	}

	file
	{
	  "/home/vagrant/rpmbuild/SOURCES/mule-standalone-3.3.0/mule":
        owner => "root",
        group => "root",
        mode  => "777",
        require => Exec["decompression-mule"],
        content => template("/etc/puppet/modules/mule/templates/mule")
    }

    exec
    {
      "compression-mule":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "tar czvf mule-standalone-3.3.0.tar.gz mule-standalone-3.3.0;rm -rf /home/vagrant/rpmbuild/SOURCES/mule-standalone-3.3.0",
         require => File["/home/vagrant/rpmbuild/SOURCES/mule-standalone-3.3.0/mule"],
         cwd => "/home/vagrant/rpmbuild/SOURCES"
	}


}

class mulerpm::createRPM
{
	file
	{
	  "/home/vagrant/rpmbuild/SPECS/mule.spec":
        owner => "root",
        group => "root",
        mode  => "777",
        require => File["/home/vagrant/rpmbuild/SPECS"],
        content => template("/etc/puppet/modules/mule/templates/mule.spec")
    }

	exec
    {
      "rpmbuild-mule":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "rpmbuild -bb /home/vagrant/rpmbuild/SPECS/mule.spec",
         require => Exec["compression-mule"],
         creates => "/home/vagrant/rpmbuild/RPMS/mule-standalone-3.3.0",
         user => vagrant,
	}
}


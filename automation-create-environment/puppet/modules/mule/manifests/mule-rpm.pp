import "../../rpmbuild/manifests/*"

class mulerpm
{
    include mulerpm::download, mulerpm::config, mulerpm::service
}

class mulerpm::download
{
    exec
    {
      "download-mule":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "wget -nc -P /home/rpm/rpmbuild/SOURCES http://dist.codehaus.org/mule/distributions/mule-standalone-3.3.0.tar.gz",
         require => File["/home/rpm/rpmbuild/SOURCES"],
	}
}

class mulerpm::config
{
	exec
    {
      "decompression-mule":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "tar -xzvf /home/rpm/rpmbuild/SOURCES/mule-standalone-3.3.0.tar.gz -C /home/rpm/rpmbuild/BUILD",
         require => [Exec["download-mule"], File["/home/rpm/rpmbuild/BUILD"]],
         creates => "/home/rpm/BUILD/mule-standalone-3.3.0"
	}

    file
	{
	  "/home/rpm/rpmbuild/SPECS/mule.spec":
        owner => "root",
        group => "root",
        mode  => "777",
        require => File["/home/rpm/rpmbuild/SPECS"],
        content => template("/etc/puppet/modules/mule/templates/mule.spec")
    }
}

class mulerpm::service
{
	exec
    {
      "rpmbuild-mule":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "rpmbuild -bb /home/rpm/rpmbuild/SPECS/mule.spec",
         require => Exec["decompression-mule"],
         creates => "/home/rpm/rpmbuild/RPMS/mule-standalone-3.3.0",
         user => "rpm",
	}
}


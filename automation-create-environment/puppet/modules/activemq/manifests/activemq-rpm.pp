import "../../rpmbuild/manifests/*"

class activemqrpm
{
    include activemqrpm::download, activemqrpm::createSource, activemqrpm::createRPM
}

class activemqrpm::download
{
    exec
    {
      "download-activemq":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "wget -nc -P /home/vagrant/rpmbuild/SOURCES http://ftp.riken.jp/net/apache/activemq/apache-activemq/5.7.0/apache-activemq-5.7.0-bin.tar.gz",
         require => File["/home/vagrant/rpmbuild/SOURCES"],
	}

	file
	{
	  "/home/vagrant/rpmbuild/SOURCES/apache-activemq-5.7.0-bin.tar.gz":
        owner => "vagrant",
        group => "vagrant",
        mode  => "777",
        require => Exec["download-activemq"],
    }
}

class activemqrpm::createSource
{
	exec
    {
      "decompression-activemq":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "tar xzvf /home/vagrant/rpmbuild/SOURCES/apache-activemq-5.7.0-bin.tar.gz -C /home/vagrant/rpmbuild/SOURCES/; chown -R vagrant /home/vagrant/rpmbuild/SOURCES/apache-activemq-5.7.0/;rm -rf /home/vagrant/rpmbuild/SOURCES/apache-activemq-5.7.0-bin.tar.gz",
         require => [Exec["download-activemq"], File["/home/vagrant/rpmbuild/BUILD"]],
         creates => "/home/vagrant/rpmbuild/SOURCES/apache-activemq-5.7.0"
	}

	file
	{
	  "/home/vagrant/rpmbuild/SOURCES/apache-activemq-5.7.0/activemq":
        owner => "root",
        group => "root",
        mode  => "777",
        require => Exec["decompression-activemq"],
        content => template("/etc/puppet/modules/activemq/templates/activemq")
    }

    exec
    {
      "compression-activemq":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "tar czvf apache-activemq-5.7.0-bin.tar.gz apache-activemq-5.7.0;rm -rf /home/vagrant/rpmbuild/SOURCES/apache-activemq-5.7.0",
         require => File["/home/vagrant/rpmbuild/SOURCES/apache-activemq-5.7.0/activemq"],
         cwd => "/home/vagrant/rpmbuild/SOURCES"
	}


}

class activemqrpm::createRPM
{
	file
	{
	  "/home/vagrant/rpmbuild/SPECS/activemq.spec":
        owner => "vagrant",
        group => "vagrant",
        mode  => "777",
        require => File["/home/vagrant/rpmbuild/SPECS"],
        content => template("/etc/puppet/modules/activemq/templates/activemq.spec")
    }

	exec
    {
      "rpmbuild-activemq":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "rpmbuild -bb SPECS/activemq.spec",
         require => [Exec["compression-activemq"], FILE["/home/vagrant/rpmbuild/SPECS/activemq.spec"]],
         creates => "/home/vagrant/rpmbuild/RPMS/apache-activemq-5.7.0",
         user => "vagrant",
         cwd => "/home/vagrant/rpmbuild",
         logoutput => "on_failure",
         environment =>"HOME=/home/vagrant"
	}
}


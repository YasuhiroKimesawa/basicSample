class rpmbuild
{
    include rpmbuild::install, rpmbuild::config
}

class rpmbuild::install
{
    package
	{
	   rpm-build:
        ensure => installed,
    }
}

class rpmbuild::config
{
	file
	{
	  "/home/vagrant/rpmbuild":
		ensure => directory,
        owner => "vagrant",
        group => "vagrant",
        mode  => "777",
        require => Package["rpm-build"],
    }

	file
	{
	  "/home/vagrant/rpmbuild/BUILD":
		ensure => directory,
        owner => "vagrant",
        group => "vagrant",
        mode  => "777",
        require => File["/home/vagrant/rpmbuild"],
    }

    file
	{
	  "/home/vagrant/rpmbuild/BUILDROOT":
		ensure => directory,
        owner => "vagrant",
        group => "vagrant",
        mode  => "777",
        require => File["/home/vagrant/rpmbuild"],
    }

    file
	{
	  "/home/vagrant/rpmbuild/RPMS":
		ensure => directory,
        owner => "vagrant",
        group => "vagrant",
        mode  => "777",
        require => File["/home/vagrant/rpmbuild"],
    }

    file
	{
	  "/home/vagrant/rpmbuild/SOURCES":
		ensure => directory,
        owner => "vagrant",
        group => "vagrant",
        mode  => "777",
        require => File["/home/vagrant/rpmbuild"],
    }

    file
	{
	  "/home/vagrant/rpmbuild/SPECS":
		ensure => directory,
        owner => "vagrant",
        group => "vagrant",
        mode  => "777",
        require => File["/home/vagrant/rpmbuild"],
    }

    file
	{
	  "/home/vagrant/rpmbuild/SRPMS":
		ensure => directory,
        owner => "vagrant",
        group => "vagrant",
        mode  => "777",
        require => File["/home/vagrant/rpmbuild"],
    }

    exec
    {
      "create-rpmmacros":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => 'echo "%_topdir /home/vagrant/rpmbuild" > /home/vagrant/.rpmmacros',
         user => "vagrant",
         cwd => "/home/vagrant/",
         environment =>"HOME=/home/vagrant"
	}

	file
	{
	  "/home/vagrant/.rpmbuild":
        owner => "vagrant",
        group => "vagrant",
        mode  => "777",
        require => Exec["create-rpmmacros"],
    }
}

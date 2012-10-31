class rpmbuild
{
    include rpmbuild::install, rpmbuild::config
}

class rpmbuild::install
{
    package
	{
	   rpm-build:
        ensure => installed
    }
}

class rpmbuild::config
{
	user
	{
	  'rpm':
	      home => '/home/rpm',
	      managehome => true,
	      shell => '/bin/bash',
	      password => 'd839ee45896e6fd6af263edfd34014da50964f0b',
	      ensure => present,
	}

	file
	{
	  "/home/rpm/rpmbuild":
		ensure => directory,
        owner => "rpm",
        group => "rpm",
        mode  => "777",
        require => [Package["rpm-build"], User["rpm"]],
    }

	file
	{
	  "/home/rpm/rpmbuild/BUILD":
		ensure => directory,
        owner => "rpm",
        group => "rpm",
        mode  => "777",
        require => File["/home/rpm/rpmbuild"],
    }

    file
	{
	  "/home/rpm/rpmbuild/BUILDROOT":
		ensure => directory,
        owner => "rpm",
        group => "rpm",
        mode  => "777",
        require => File["/home/rpm/rpmbuild"],
    }

    file
	{
	  "/home/rpm/rpmbuild/RPMS":
		ensure => directory,
        owner => "rpm",
        group => "rpm",
        mode  => "777",
        require => File["/home/rpm/rpmbuild"],
    }

    file
	{
	  "/home/rpm/rpmbuild/SOURCES":
		ensure => directory,
        owner => "rpm",
        group => "rpm",
        mode  => "777",
        require => File["/home/rpm/rpmbuild"],
    }

    file
	{
	  "/home/rpm/rpmbuild/SPECS":
		ensure => directory,
        owner => "rpm",
        group => "rpm",
        mode  => "777",
        require => File["/home/rpm/rpmbuild"],
    }

    file
	{
	  "/home/rpm/rpmbuild/SRPMS":
		ensure => directory,
        owner => "rpm",
        group => "rpm",
        mode  => "777",
        require => File["/home/rpm/rpmbuild"],
    }

    exec
    {
      "create-rpmmacros":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => 'echo "%_topdir /home/rpm/rpmbuild/" > ./.rpmmacros',
         require => User["rpm"],
	}
}

class postgresql
{
    include vsftpd::install, vsftpd::config, vsftpd::service
}

class vsftpd::install
{
     package
	{
	  vsftpd:
        ensure => installed
    }
}

class vsftpd::config
{
	file
	{
	  "/etc/vsftpd/vsftpd.conf":
        owner => "root",
        group => "root",
        mode  => "777",
        require => Package["vsftpd"],
        content => template("/etc/puppet/modules/vsftpd/templates/vsftpd.conf")
    }

    file
	{
	  "/etc/vsftpd/chroot_list":
        owner => "root",
        group => "root",
        mode  => "777",
        require => Package["vsftpd"],
        content => template("/etc/puppet/modules/vsftpd/templates/chroot_list")
    }

    file
	{
	  "/etc/vsftpd/ftpusers":
        owner => "root",
        group => "root",
        mode  => "777",
        require => Package["vsftpd"],
        content => template("/etc/puppet/modules/vsftpd/templates/ftpusers")
    }
}

class vsftpd::service
{
	service
    {
	  'vsftpd':
        ensure => 'running',
        enable => true,
        hasrestart => true,
        hasstatus => true,
        subscribe => [File['/etc/vsftpd/vsftpd.conf'], File['/etc/vsftpd/chroot_list'], File['/etc/vsftpd/ftpusers']],
    }

    exec
    {
      "thisserver-access-vsftpd":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "echo "vsftpd:127.0.0.1" >> /etc/hosts.allow",
		 require => Service["vsftpd"],
	}

	exec
    {
      "include-access-vsftpd":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "echo "vsftpd:192.168.1." >> /etc/hosts.allow",
		 require => Service["vsftpd"],,
	}

	exec
    {
      "all-deny-vsftpd":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "echo "vsftpd:ALL" >> /etc/hosts.deny",
		 require => Service["vsftpd"],
	}
}


class iptables
{
    include iptables::settings, iptables::openService, iptables::saveStart
}

class iptables::settings
{
    exec
    {
      "iptables-init":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "iptables -F",
	}

	exec
    {
      "iptables-policy":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "iptables -P INPUT DROP; iptables -P OUTPUT ACCEPT; iptables -P FORWARD DROP",
		 require => Exec["iptables-init"],
	}

	exec
    {
      "iptables-roopback":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "iptables -A INPUT -i lo -j ACCEPT",
         require => Exec["iptables-policy"],
	}

	exec
    {
      "iptables-establish":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "iptables -A INPUT -m state --state ESTABLISHED,RELATED -j ACCEPT",
		 require => Exec["iptables-roopback"],
	}

	exec
    {
      "iptables-ping":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "iptables -A INPUT -p icmp --icmp-type echo-request -m limit --limit 1/s -j ACCEPT",
		 require => Exec["iptables-establish"],
	}
}

class iptables::openService
{
	exec
    {
      "iptables-ssh":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "iptables -A INPUT -p tcp --dport 22 -m state --state NEW -j ACCEPT",
		 require => Exec["iptables-ping"],
	}

	exec
    {
      "iptables-smtp":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "iptables -A INPUT -p tcp --dport 25 -m state --state NEW -j ACCEPT",
		 require => Exec["iptables-ssh"],
	}

	exec
    {
      "iptables-http":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "iptables -A INPUT -p tcp --dport 80 -m state --state NEW -j ACCEPT",
		 require => Exec["iptables-smtp"],
	}

	exec
    {
      "iptables-https":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "iptables -A INPUT -p tcp --dport 443 -m state --state NEW -j ACCEPT",
		 require => Exec["iptables-http"],
	}
}

class iptables::saveStart
{
    exec
    {
      "iptables-save":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "service iptables save",
         require => Exec["iptables-https"],
	}

	exec
    {
      "iptables-start":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "service iptables restart",
         require => Exec["iptables-save"],
	}
}
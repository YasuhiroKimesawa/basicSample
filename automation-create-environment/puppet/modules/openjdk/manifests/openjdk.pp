class openjdk 
{
    include openjdk::install, openjdk::config, openjdk::service
}

class openjdk::install 
{
    package 
	{ 
	  "java-1.6.0-openjdk-devel":
        ensure => installed
    }
}

class openjdk::config 
{
    exec 
    { 
      "update-alternatives ":
         path => "/bin:/sbin:/usr/bin:/usr/sbin",
         command => "update-alternatives --set java /usr/lib/jvm/jre-1.6.0-openjdk/bin/java",
         unless => "sudo test `readlink /etc/alternatives/java` = '/usr/lib/jvm/jre-1.6.0-openjdk/bin/java'",
         require => Package["java-1.6.0-openjdk-devel"],
	}
}

class openjdk::service 
{
}

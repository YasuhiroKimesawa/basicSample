import "../../tomcat/manifests/*"

$jenkinsapp_folder=["/usr/share/tomcat6/jenkins", "/usr/share/tomcat6/jenkins/ROOT"]

class jenkins
{
    include jenkins::download
}

class jenkins::download
{
	file
	{
	  $jenkinsapp_folder:
        ensure => directory,
        owner => "root",
        group => "root",
        mode  => "777",
        require => Package["tomcat6"],
    }

	exec
    {
      "download-jenkins":
         command => "/usr/bin/wget -nc -P /usr/share/tomcat6/jenkins/ROOT http://mirrors.jenkins-ci.org/war/latest/jenkins.war;mv /usr/share/tomcat6/jenkins/ROOT/jenkins.war /usr/share/tomcat6/jenkins/ROOT/ROOT.war",
         timeout => 0,
         logoutput => "on_failure",
         creates => "/usr/share/tomcat6/jenkins/ROOT/ROOT.war",
         require => File[$jenkinsapp_folder],
	}
}
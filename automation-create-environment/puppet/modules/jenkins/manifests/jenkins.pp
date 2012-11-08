import "../../tomcat/manifests/*"

$jenkinsapp_folder=["/usr/local/tomcat6/jenkins", "/usr/local/tomcat6/jenkins/ROOT"]

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
         command => "/usr/bin/wget -nc -P /usr/local/tomcat/jenkins/ROOT http://mirrors.jenkins-ci.org/war/latest/jenkins.war",
         timeout => 0,
         logoutput => "on_failure",
         creates => "/var/www/html/index.php",
         require => File[$jenkinsapp_folder],
	}
}
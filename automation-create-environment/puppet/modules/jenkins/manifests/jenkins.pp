import "../../tomcat/manifests/*"

class jenkins
{
    include jenkins::download
}

class jenkins::download
{
	file
	{
		"/usr/local/jenkins":
		ensure => directory,
        owner => "vagrant",
        group => "vagrant",
        mode  => "777",
        require => Package["tomcat6"],
	}

	exec
    {
      "download-jenkins":
         command => "/usr/bin/wget -nc -P /usr/share/tomcat6/webapps/ http://mirrors.jenkins-ci.org/war/1.456/jenkins.war",
         timeout => 0,
         logoutput => "on_failure",
         creates => "/usr/share/tomcat6/webapps/jenkins.war",
         require => File["/usr/local/jenkins"],
	}
}

#############################
# backupのリストア
#1.JENKINS_HOMEにファイルを配置
#2.権限変更 chmod 777 -R ./jenkins
#################################

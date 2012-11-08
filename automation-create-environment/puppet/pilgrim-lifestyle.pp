import "./modules/localtime/manifests/*"
import "./modules/apache/manifests/*"
import "./modules/tomcat/manifests/*"
import "./modules/git/manifests/*"
import "./modules/files/manifests/*"
import "./modules/mysql/manifests/*"
import "./modules/php/manifests/*"
import "./modules/openjdk/manifests/*"
import "./modules/iptables/manifests/*"
import "./modules/wordpress/manifests/*"
import "./modules/jenkins/manifests/*"

node default
{
    include "files"
    include "localtime"
    include "git"
    include "apache"
    include "mysql"
    include "php"
    include "openjdk"
    include "tomcat"

    include "iptables"

    include "wordpress"
    include "jenkins"

    include "serversman-git"
}
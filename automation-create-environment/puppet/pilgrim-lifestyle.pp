import "./modules/localtime/manifests/*"
import "./modules/tomcat/manifests/*"
import "./modules/git/manifests/*"
import "./modules/files/manifests/*"
import "./modules/mysql/manifests/*"
import "./modules/php/manifests/*"
import "./modules/openjdk/manifests/*"
import "./modules/iptables/manifests/*"
import "./modules/wordpress/manifests/*"
import "./modules/jenkins/manifests/*"
import "./modules/nginx/manifests/*"

node default
{
    include "files"
    include "localtime"
	include "mysql"
    include "nginx"
    include "php"

    include "iptables"

    include "wordpress"

}
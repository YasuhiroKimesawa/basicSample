import "./modules/localtime/manifests/*"
import "./modules/ant/manifests/*"
import "./modules/apache/manifests/*"
import "./modules/tomcat/manifests/*"
import "./modules/mule/manifests/*"
import "./modules/james/manifests/*"
import "./modules/files/manifests/*"
import "./modules/git/manifests/*"
import "./modules/postgresql/manifests/*"
import "./modules/mysql/manifests/*"
import "./modules/postfix/manifests/*"
import "./modules/php/manifests/*"
import "./modules/openjdk/manifests/*"
import "./modules/iptables/manifests/*"

node default
{
    include "files"
    include "localtime"
    include "ant"
    include "apache"
    include "tomcat"
    include "mule"
    include "james"
    include "git"
    include "postgresql"
    include "mysql"
    include "postfix"
    include "php"
    include "openjdk"

    include "iptables"
}

node 'localhost'
{
    include "files"
    include "localtime"
    include "ant"
    include "apache"
    include "tomcat"
    include "mule"
    include "james"
    include "git"
    include "postgresql"
    include "postfix"
    include "php"
    include "openjdk"

    include "iptables"
}

node 'pilgrim-lifestyle.com'
{
    include "files"
    include "localtime"
    include "ant"
    include "apache"
    include "tomcat"
    include "mule"
    include "james"
    include "git"
    include "postgresql"
    include "mysql"
    include "postfix"
    include "php"
    include "openjdk"

    include "iptables"
}


import "./modules/localtime/manifests/*"
import "./modules/apache/manifests/*"
import "./modules/files/manifests/*"
import "./modules/mysql/manifests/*"
import "./modules/php/manifests/*"
import "./modules/openjdk/manifests/*"
import "./modules/iptables/manifests/*"
import "./modules/wordpress/manifests/*"

node default
{
    include "files"
    include "localtime"
    include "apache"
    include "mysql"
    include "php"
    include "openjdk"

    include "iptables"

    include wordpress
}
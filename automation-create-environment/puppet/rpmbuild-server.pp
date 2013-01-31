import "./modules/mule/manifests/*"
import "./modules/james/manifests/*"
import "./modules/ruby/manifests/*"
import "./modules/activemq/manifests/*"
import "./modules/rpmbuild/manifests/*"
import "./modules/files/manifests/*"
import "./modules/createrepo/manifests/*"
import "./modules/apache/manifests/*"
import "./modules/php/manifests/*"
import "./modules/iptables/manifests/*"


node default
{
    include "rpmbuild"
    include "mulerpm"
    include "jamesrpm"
    include "rubyrpm"
    include "activemqrpm"
    include "files"
    include "createrepo"

	include "apache"
    include "activemqyum"
    include "muleyum"
    include "jamesyum"
    include "rubyyum"
    include "php"


    include "iptables"
}



import "./modules/mule/manifests/*"
import "./modules/james/manifests/*"
import "./modules/ruby/manifests/*"
import "./modules/activemq/manifests/*"
import "./modules/rpmbuild/manifests/*"
import "./modules/files/manifests/*"
import "./modules/createrepo/manifests/*"
import "./modules/apache/manifests/*"


node 'localhost' {
    include "rpmbuild"
    include "mulerpm"
    include "jamesrpm"
    include "rubyrpm"
    include "activemqrpm"
    include "files"
    include "createrepo"

	include "apache"
    include "activemqyum"
}



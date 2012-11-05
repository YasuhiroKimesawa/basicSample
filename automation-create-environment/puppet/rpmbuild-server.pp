import "./modules/mule/manifests/*"
import "./modules/james/manifests/*"
import "./modules/ruby/manifests/*"
import "./modules/activemq/manifests/*"
import "./modules/rpmbuild/manifests/*"
import "./modules/files/manifests/*"


node 'localhost' {
    include "rpmbuild"
    include "mulerpm"
    include "jamesrpm"
    include "rubyrpm"
    include "activemqrpm"
    include "files"
}



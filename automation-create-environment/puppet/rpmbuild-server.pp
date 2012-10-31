import "./modules/mule/manifests/*"
import "./modules/rpmbuild/manifests/*"


node 'localhost' {
    include "rpmbuild"
    include "mulerpm"
}



package features.support

import geb.Browser
import geb.binding.BindingUpdater

this.metaClass.mixin (cucumber.runtime.groovy.Hooks)

def bindingUpdater

Before () {
    bindingUpdater = new BindingUpdater(binding, new Browser ())
    bindingUpdater.initialize ()
}

After () {
    bindingUpdater.remove ()
}
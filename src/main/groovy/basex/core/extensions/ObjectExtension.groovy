package basex.core.extensions

import org.grails.orm.hibernate.cfg.GrailsHibernateUtil
import org.hibernate.proxy.HibernateProxy
import org.hibernate.proxy.HibernateProxyHelper

class ObjectExtension {


  static Object deproxy(final Object self, Class baseClass = null) {
    if (self == null) {
      return
    }
    if (baseClass == null) {
      baseClass = HibernateProxyHelper.getClassWithoutInitializingProxy(self)
    }
    if (!(baseClass instanceof Class)) {
      throw new Exception("Expected type class but got ${baseClass?.class}")
    }

    if (self instanceof HibernateProxy) {
      return baseClass.cast(GrailsHibernateUtil.unwrapIfProxy(self))
    }
    return baseClass.cast(self)
  }


}

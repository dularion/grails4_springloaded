package basex.core.traits

import grails.artefact.Enhances
import org.grails.core.artefact.DomainClassArtefactHandler
import org.grails.orm.hibernate.cfg.GrailsHibernateUtil
import org.hibernate.Hibernate
import org.hibernate.proxy.HibernateProxy

@Enhances(DomainClassArtefactHandler.TYPE)
trait BasexDomain {
  Object asType(Class clazz){
    if(this instanceof HibernateProxy && Hibernate.getClass(this).isCase(clazz)) {
      return this.deproxy(clazz)
    }
    return super.asType(clazz)
  }
}

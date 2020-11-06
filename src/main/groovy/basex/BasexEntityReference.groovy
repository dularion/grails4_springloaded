package basex

/**
 * Creates an association between two Domains, which are reference by an entityClass and entityId on one side of the association.
 * The enclosedClass holds the properties entityId/entityClass
 * The referencedClass is referenced in these properties
 *
 * example usage:  static basexHasMany = [textBlocks: new BasexEntityReference<TextBlock>(TextBlock, Product)]
 *
 * @param < T >
 */

class BasexEntityReference<T> extends BasexAssociation<T> {
  Class referencedClass

  BasexEntityReference(Class enclosedClass, Class referencedClass) {
    this.enclosedClass = enclosedClass
    this.referencedClass = referencedClass
  }

  List<T> list(Long id, Closure callable = null) {
    return enclosedClass.withCriteria {
      eq('entityClass', referencedClass.canonicalName)
      eq('entityId', id)
    }
  }
}

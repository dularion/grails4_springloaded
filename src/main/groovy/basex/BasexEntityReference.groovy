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

class BasexEntityReference extends BasexAssociation {
  String status

  BasexEntityReference(String name, String status) {
    this.name = name
    this.status = status
  }
}

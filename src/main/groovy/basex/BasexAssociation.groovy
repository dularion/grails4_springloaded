package basex

/**
 * Abstract class for all associations which can be used in the basexHasMany
 * @param <T>
 */

abstract class BasexAssociation<T> {

  protected Class<T> enclosedClass

  BasexAssociation() {
  }

  abstract List<T> list(Long id, Closure callable = null)
}

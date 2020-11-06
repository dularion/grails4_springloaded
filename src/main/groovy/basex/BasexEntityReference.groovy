package basex


class BasexEntityReference extends BasexAssociation {
  String status

  BasexEntityReference(String name, String status) {
    this.name = name  //this will break the application, because it sets the property of the abstract superclass
    this.status = status
  }
}

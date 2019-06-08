class ArrayOfPerson {
  private var personArray : Array[Person] = _

  def setPersonArray(personArray : Array[Person]) : Unit = this.personArray = personArray
  def getPersonArray: Array[Person] = personArray
}
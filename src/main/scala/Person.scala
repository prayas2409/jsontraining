class Person {
  private var name : String = _
  private var email : String = _
  private var mobileNumber : String = _

  def this(name : String, email : String , mobileNumber : String) = {
    this()                          // call to primary constructor
    this.name = name
    this.email = email
    this.mobileNumber = mobileNumber
  }

  def setName(name : String) : Unit  = this.name = name
  def setEmail(email : String) : Unit  = this.email = email
  def setMobNum(mobileNum : String) : Unit  = this.mobileNumber = mobileNum

  def getName : String = name
  def getEmail : String = email
  def getMobileNumber : String = mobileNumber

  override def toString: String =
    s"""
      |name is $name
      |email is $email
      |mobile number is $mobileNumber
    """.stripMargin
}

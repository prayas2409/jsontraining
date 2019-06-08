import java.io.{File, PrintWriter}

import com.fasterxml.jackson.core.`type`.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

import scala.collection.mutable.ListBuffer

object HelloScala {

  val objectMapper = new ObjectMapper()

  def printPersonJSON(pathFile : String): Unit = {
    val person = objectMapper.readValue(new File(s"B:\\JSONData\\$pathFile.json"), classOf[Person])
    print(
      s"""
         | Read JSON data from file "$pathFile.json"
         | _____________________________________________________________________
         | $person
          _____________________________________________________________________
      """.stripMargin
    )
  }

  def printPersonListJSON(pathFile: String): Unit = {
    val personList: List[Person] = objectMapper.readValue(new File(s"B:\\JSONData\\$pathFile.json"),
      new TypeReference[List[Person]] {})

    print(
      s"""
         | Read JSON data from file "$pathFile.json"
         | _____________________________________________________________________
      """.stripMargin
    )
    for (person <- personList) {
      print(person)
    }
    print("_____________________________________________________________________")

  }

  def printObjectWithArray() : Unit = {
    val objectWithPersonArray: ArrayOfPerson = objectMapper.readValue(new File("B:\\JSONData\\ArrayOfPerson.json"), classOf[ArrayOfPerson])
    for (person <- objectWithPersonArray.getPersonArray) {
      print(person)
    }
  }

  def writeObjToFileAsJSON[T](filePath: String, element : T): Unit = {
    val file = new File(s"B:\\JSONData\\$filePath.json")
    createFile(file)
    objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, element)
  }

  def writeArrayToFileAsJSON(filePath: String, personArray : Array[Person]): Unit = {
    val file = new File(s"B:\\JSONData\\$filePath.json")
    createFile(file)
    objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, personArray)
  }

  def createFile(file : File) : Unit = { val printWriter = new PrintWriter(file); printWriter.close() }

  def readJSON(filePath: String): Unit = {}

  def main(args: Array[String]): Unit = {
    print("Hello Scala!")
    objectMapper.registerModule(DefaultScalaModule)

    def getPreparedList : Array[Person] = ListBuffer[Person](
      new Person(name = "Ajay Khurana", email = "klshjhs@gmail.com", mobileNumber = "887687578575"),
      new Person(name = "Ashok Sharma", email = "hghsghghs@gmail.com", mobileNumber = "87887678378"),
      new Person(name = "Shiva Vishkarma", email = "jsghjghs@gmail.com", mobileNumber = "3566464646"),
      new Person(name = "HariOm Malhotra", email = "smnjsnjs@gmail.com", mobileNumber = "246534653463"),
      new Person(name = "Vaibhav Dutt", email = "smnbns@gmail.com", mobileNumber = "45534534354534"),
      new Person(name = "Nikunj Nema", email = "kssjls@gmail.com", mobileNumber = "453465646464")
    ).toArray[Person]

    val personList = getPreparedList
    writeObjToFileAsJSON[Array[Person]]("writingarray", personList)
    printPersonListJSON("writingarray")
  }
}
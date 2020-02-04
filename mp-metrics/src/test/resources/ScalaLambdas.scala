class ScalaLambdas {
  def functionWithLambda(list: List[Any]): Boolean = { // Noncompliant {{Lambdas: 1}}
    list.exists(element => element == null)
  }

  def functionWithoutLambda(list: List[Any]): Boolean = {
    list.contains(null)
  }
}
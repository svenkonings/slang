class KotlinLambdas {
  fun functionWithLambda(list: List<Any?>): Boolean { // Noncompliant {{Lambdas: 1}}
    return list.any { it == null }
  }

  fun functionWithoutLambda(list: List<Any?>): Boolean {
    return list.contains(null)
  }
}
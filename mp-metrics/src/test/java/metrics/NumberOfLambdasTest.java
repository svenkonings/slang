package metrics;

import org.junit.Test;
import verify.KotlinVerifier;
import verify.ScalaVerifier;

public class NumberOfLambdasTest {

    @Test
    public void numberOfScalaLambdas() {
        ScalaVerifier.verify("ScalaLambdas.scala", new NumberOfLambdasMetric());
    }

    @Test
    public void numberOfKotlinLambdas() {
        KotlinVerifier.verify("KotlinLambdas.kt", new NumberOfLambdasMetric());
    }
}

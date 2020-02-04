package utils;

import org.sonarsource.kotlin.converter.KotlinConverter;
import org.sonarsource.scala.converter.ScalaConverter;
import org.sonarsource.slang.api.ASTConverter;

public class Converters {
    public static final ASTConverter SCALA_CONVERTER = new ScalaConverter();
    public static final ASTConverter KOTLIN_CONVERTER = new KotlinConverter();
}

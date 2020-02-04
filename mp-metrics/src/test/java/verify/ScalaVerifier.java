package verify;

import org.sonarsource.slang.checks.api.SlangCheck;
import org.sonarsource.slang.testing.Verifier;
import utils.Converters;
import utils.Resources;

public class ScalaVerifier {
    public static void verify(String fileName, SlangCheck check) {
        Verifier.verify(Converters.SCALA_CONVERTER, Resources.getResource(fileName), check);
    }

    public static void verifyNoIssue(String fileName, SlangCheck check) {
        Verifier.verifyNoIssue(Converters.SCALA_CONVERTER, Resources.getResource(fileName), check);
    }
}

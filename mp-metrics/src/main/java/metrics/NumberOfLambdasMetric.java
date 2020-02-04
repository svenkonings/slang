package metrics;

import org.sonarsource.slang.api.FunctionDeclarationTree;
import org.sonarsource.slang.api.NativeTree;
import org.sonarsource.slang.api.Tree;
import org.sonarsource.slang.checks.api.InitContext;
import org.sonarsource.slang.checks.api.SlangCheck;

import java.util.List;

public class NumberOfLambdasMetric implements SlangCheck {

    @Override
    public void initialize(InitContext init) {
        init.register(FunctionDeclarationTree.class, (ctx, tree) -> {
            long count = countLambdas(tree);
            if (count > 0) {
                ctx.reportIssue(tree.textRange(), String.format("Lambdas: %d", count));
            }
        });
    }

    private static long countLambdas(Tree tree) {
        return isLambda(tree) ? 1 : countLambdas(tree.children());
    }

    private static long countLambdas(List<Tree> trees) {
        return trees.stream().mapToLong(NumberOfLambdasMetric::countLambdas).sum();
    }

    private static boolean isLambda(Tree tree) {
        if (tree instanceof NativeTree) {
            NativeTree nativeTree = (NativeTree) tree;
            String kind = nativeTree.nativeKind().toString();
            switch (kind) {
                case "ScalaNativeKind(class scala.meta.Term$Function$TermFunctionImpl)":
                case "KtLambdaExpression":
                    return true;
            }
        }
        return false;
    }
}

package equations;

public abstract class EqSolver {

    private String pattern;

    public EqSolver(String pattern) {
        this.pattern = pattern;
    }

    public boolean matchesForm(String input) {
        return input.matches(pattern);
    }

    public abstract String solve(String input);
}

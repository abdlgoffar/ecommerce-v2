package ecommerce.v2.lambda;

@FunctionalInterface
public interface Function2<P1, P2, R> {
    abstract public R apply(P1 p1, P2 p2);
}
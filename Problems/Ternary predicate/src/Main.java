class Predicate {

    @FunctionalInterface
    public interface TernaryIntPredicate {
        public boolean test(int x, int y, int z);
    }

    public static final TernaryIntPredicate allValuesAreDifferentPredicate =
            (x,y,z)->{
                return x!=y && x!=z && y!=z ? true : false;
            };

}
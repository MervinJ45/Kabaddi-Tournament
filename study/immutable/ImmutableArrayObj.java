package study.immutable;

//made the class final so that the class cant be inherited
public final class ImmutableArrayObj {

    //made array final (final ensures only the array refer cant be changed)
    //the values are still mutable
    private final int[] arr;

    public ImmutableArrayObj() {
        arr = new int[]{1, 2, 3};
    }

    //dont return the array directly because we can manipulate the array even though it is final so returning clone of an array
    public int[] getArr() {
        return arr.clone();
    }

}

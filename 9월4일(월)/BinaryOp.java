public interface BinaryOp {
    int apply();
    
}
class Computer implements BinaryOp {
    public int apply() {
        return 1;
    }
}
class User implements BinaryOp {
    public int apply() {
        return 2;
    }
}

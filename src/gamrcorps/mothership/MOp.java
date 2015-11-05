package src.gamrcorps.mothership;

public abstract class MOp implements IOperator{
    private String name;

    public MOp(String id){
        this.name = id;
    }

    public abstract MObject run(MStack stack);
}

package src.gamrcorps.mothership;

public abstract class MOp implements IOperator{
    public MOp(String id){

    }

    public MOp(){

    }

    public abstract MObject run(MStack stack);
}

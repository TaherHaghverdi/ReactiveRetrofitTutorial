package ir.coursio.reactiveretrofittutorial.model;

/**
 * Created by Taher on 12/04/2017.
 * Project: ReactiveRetrofitTutorial
 */

public class SampleModel {
    private String name;

    public SampleModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

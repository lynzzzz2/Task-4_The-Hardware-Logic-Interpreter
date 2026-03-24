package org.example;

public class Phone extends Hardware {

    public Phone(int id, String brand, int spec) {
        super(id, brand, spec);
    }

    @Override
    public String interpretSpec() {
        return getSpec() + " Megapixels";  // use getter, not spec directly
    }
}

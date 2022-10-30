public class IsoscelesTriangle {
    private double legLength;
    private double baseLength;

    public IsoscelesTriangle(double legLength, double baseLength){
        ThrowExceptionIfSideLengthIsInvalid(legLength);
        ThrowExceptionIfSideLengthIsInvalid(baseLength);
        ThrowExceptionIfTriangleIsInvalid(legLength, baseLength);

        this.legLength = legLength;
        this.baseLength = baseLength;
    }

    public double getLegLength() {
        return legLength;
    }

    public double getBaseLength() {
        return baseLength;
    }

    public void setLegLength(double legLength){
        ThrowExceptionIfSideLengthIsInvalid(legLength);
        ThrowExceptionIfTriangleIsInvalid(legLength, baseLength);

        this.legLength = legLength;
    }

    public void setBaseLength(double baseLength){
        ThrowExceptionIfSideLengthIsInvalid(baseLength);
        ThrowExceptionIfTriangleIsInvalid(legLength, baseLength);

        this.baseLength = baseLength;
    }

    public double getPerimeter() {
        return legLength * 2 + baseLength;
    }

    public double getArea() {
        return (baseLength / 2) * Math.sqrt(legLength * legLength - baseLength * baseLength / 4);
    }

    @Override
    public String toString() {
        return String.format("IsoscelesTriangle {legLength=%f, baseLength=%f}", legLength, baseLength);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        IsoscelesTriangle isoscelesTriangle = (IsoscelesTriangle) obj;

        return Double.compare(isoscelesTriangle.legLength, this.legLength) == 0 &&
                Double.compare(isoscelesTriangle.baseLength, this.baseLength) == 0;
    }

    private boolean isTriangleValid(double legLength, double baseLength) {
        return legLength * 2 > baseLength;
    }

    private void ThrowExceptionIfSideLengthIsInvalid(double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Side length must be greater than 0. Provided value: " + sideLength);
        }
    }

    private void ThrowExceptionIfTriangleIsInvalid(double legLength, double baseLength){
        if (!isTriangleValid(legLength, baseLength)) {
            System.out.println("Isosceles triangle is valid if sum of its legs is greater than its base. " +
                    String.format("Provided values: leg length: %f, base length: %f", legLength, baseLength));
        }
    }
}

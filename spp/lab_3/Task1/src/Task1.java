public class Task1 {
    public static void main(String [] args){
            IsoscelesTriangle firstTriangle = new IsoscelesTriangle(13, 24);

            System.out.println(firstTriangle.getLegLength());
            System.out.println(firstTriangle.getBaseLength());
            System.out.println(firstTriangle.getPerimeter());
            System.out.println(String.format("Area of %s = %f", firstTriangle, firstTriangle.getArea()));
            System.out.println(firstTriangle);

            IsoscelesTriangle secondTriangle = new IsoscelesTriangle(13, 24);
            IsoscelesTriangle thirdTriangle = new IsoscelesTriangle(14, 24);

            System.out.println(firstTriangle.equals(secondTriangle));
            System.out.println(firstTriangle.equals(thirdTriangle));
    }
}

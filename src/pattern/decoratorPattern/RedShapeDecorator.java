package pattern.decoratorPattern;

/**
 * @Descript:
 * @Author: zhouwei
 * @Date: 19-6-17 下午5:57
 * @Version 1.0
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }

}

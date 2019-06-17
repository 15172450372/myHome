package pattern.decoratorPattern;

/**
 * @Descript:
 * @Author: zhouwei
 * @Date: 19-6-17 下午5:45
 * @Version 1.0
 */
public abstract class ShapeDecorator implements Shape {

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw(){
        decoratedShape.draw();
    }

}

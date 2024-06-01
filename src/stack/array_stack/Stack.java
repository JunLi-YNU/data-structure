package stack.array_stack;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年01月09日 23:26:19
 * @version: 1.0
 * @Description: Stack功能的定义
 */
public interface Stack<E> {
    //压栈
    void push(E e);
    //出栈
    E pop();
    //查看Top元素
    E peek();

}
